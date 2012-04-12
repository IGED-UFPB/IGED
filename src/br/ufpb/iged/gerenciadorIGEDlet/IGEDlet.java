/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gerenciadorIGEDlet;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public abstract class IGEDlet {
    IGEDletDAO ativ = null;
    List<IGEDletListener> listeners = null;
    
    public IGEDlet(){
        this.listeners = new ArrayList<IGEDletListener>();
    }
    
    public void addListener(IGEDletListener l){
        this.listeners.add(l);
    }
    
    public void removeListener(IGEDletListener l){
        this.listeners.remove(l);
    }
    
    protected void enviaEventoInicio(final IGEDletEvent e){
        for(final IGEDletListener al : this.listeners){
            new Thread(){
                public void run(){
                    al.atividadeIniciada(e);
                }
            }.start();
        }
    }
    
    protected void enviaEventoResolvido(final IGEDletEvent e){
        for(final IGEDletListener al : this.listeners){
            new Thread(){
                public void run(){
                    al.atividadeResolvida(e);
                }
            }.start();
        }
    }
    
    public IGEDletDAO getDAO(){
        return this.ativ;
    }
    
    public void setDAO(IGEDletDAO a){
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
