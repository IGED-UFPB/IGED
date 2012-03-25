/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

import iged.IGEDConst;
import iged.Interpretador;
import java.util.StringTokenizer;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class AtividadeSubjetiva extends Atividade{
    
    Interpretador iter = null;
    Thread exec = null;
    Semaphore sem = null;
    
    public AtividadeSubjetiva(){
        iter = new Interpretador();
        sem = new Semaphore(1, true);
    }
    
    @Override
    public void inicio() {
        //Bloqueia as outras ações na Atividade, enquanto sua Thread n finaliza.
        try {
            sem.acquire();
        } catch (InterruptedException ex){
        }
        
        final AtividadeSubjetiva as = (AtividadeSubjetiva)this;
        this.exec = new Thread(){
            public void run(){  
                as.iter.setMode(IGEDConst.MODE_BOTH);
                String codigo = ((AtividadeSubjetivaDAO)as.ativ).getCodInicializacao();
                as.execute(codigo);
                as.enviaEventoInicio(new AtividadeEvent(AtividadeEvent.INIT, as));
                
                as.iter.setMode(IGEDConst.MODE_PROFESSOR);
                codigo = ((AtividadeSubjetivaDAO)as.ativ).getCodSolucao();
                as.execute(codigo);
                as.iter.setMode(IGEDConst.MODE_STUDENT);
                
                as.sem.release();
            }
        };
        this.exec.start();
    }

    private void execute(String cod) {
        StringTokenizer st = new StringTokenizer(cod, "\n");
        while (st.hasMoreTokens()) {
            String c = st.nextToken();
            System.out.println(c);
            iter.interprete(c);
        }
    }
    
    @Override
    public void resolve(final String response) {
        //Bloqueia as outras ações na Atividade, enquanto sua Thread n finaliza.
        try {
            sem.acquire();
        } catch (InterruptedException ex){
        }
        
        final AtividadeSubjetiva as = (AtividadeSubjetiva)this;
        this.exec = new Thread(){
            public void run(){  
                as.execute(response);
                
                AtividadeEvent e;
                if(as.estaCorreta()){
                    e = new AtividadeEvent(AtividadeEvent.SUCCESS, as);
                }else{
                    e = new AtividadeEvent(AtividadeEvent.FAIL, as);
                }
                as.enviaEventoResolvido(e);
                
                as.sem.release();
            }
        };
        this.exec.start();
    }

    @Override
    public void reinicio() {
        try {
            sem.acquire();
            sem.release();
        } catch (InterruptedException ex){
        }
                
        iter.clear();
        this.inicio();
    }

    @Override
    public boolean estaCorreta() {
        return this.iter.taskIsCorrect();
    }

    @Override
    public JPanel getQuadro() {
        if(this.iter == null)
            this.iter = new Interpretador();
        return this.iter.getQuadro();
    }
}
