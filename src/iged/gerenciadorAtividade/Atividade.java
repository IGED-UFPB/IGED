/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public abstract class Atividade {
    AtividadeDAO ativ = null;
    List<AtividadeListener> listeners = null;
    
    public Atividade(){
        this.listeners = new ArrayList<AtividadeListener>();
    }
    
    public void addListener(AtividadeListener l){
        this.listeners.add(l);
    }
    
    public void removeListener(AtividadeListener l){
        this.listeners.remove(l);
    }
    
    protected void enviaEventoInicio(final AtividadeEvent e){
        for(final AtividadeListener al : this.listeners){
            new Thread(){
                public void run(){
                    al.atividadeIniciada(e);
                }
            }.start();
        }
    }
    
    protected void enviaEventoResolvido(final AtividadeEvent e){
        for(final AtividadeListener al : this.listeners){
            new Thread(){
                public void run(){
                    al.atividadeResolvida(e);
                }
            }.start();
        }
    }
    
    public AtividadeDAO getDAO(){
        return this.ativ;
    }
    
    public void setDAO(AtividadeDAO a){
        this.ativ = a;
    }
    
    public abstract void inicio();
    public abstract void resolve(String response);
    public abstract void reinicio();
    public abstract boolean estaCorreta();
    public abstract JPanel getQuadro();

    public static final int SUBJETIVA = 0;
    public static final int OBJETIVA = 1;
}
