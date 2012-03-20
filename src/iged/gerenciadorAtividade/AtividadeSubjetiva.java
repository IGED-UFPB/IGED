/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

import iged.IGEDConst;
import iged.Interpretador;
import java.util.StringTokenizer;
import javax.swing.JPanel;

public class AtividadeSubjetiva extends Atividade{
    
    Interpretador iter = null;
    Thread exec = null;
    
    private String codInicializacao;
    private String codSolucao;

    public String getCodInicializacao() {
        return codInicializacao;
    }

    public void setCodInicializacao(String codInicializacao) {
        this.codInicializacao = codInicializacao;
    }
    
    public String getCodSolucao() {
        return codSolucao;
    }

    public void setCodSolucao(String codSolucao) {
        this.codSolucao = codSolucao;
    }

    @Override
    public void inicio() {
        if(iter == null)
            iter = new Interpretador();
        
        final AtividadeSubjetiva as = (AtividadeSubjetiva)this;
        this.exec = new Thread(){
            public void run(){  
                as.iter.setMode(IGEDConst.MODE_BOTH);
                String codigo = as.getCodInicializacao();
                as.execute(codigo);
                as.iter.setMode(IGEDConst.MODE_PROFESSOR);
                codigo = as.getCodSolucao();
                as.execute(codigo);
                as.iter.setMode(IGEDConst.MODE_STUDENT);
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
    public void resolve(String response) {
        this.execute(response);
    }

    @Override
    public void reinicio() {
        if((this.exec != null) && (this.exec.isAlive()))
            this.exec.interrupt();
        
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
