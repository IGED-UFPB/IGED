/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gui;

import br.ufpb.iged.gui.event.TelaPlayerEvent;
import br.ufpb.iged.gui.event.TelaPlayerListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class TelaPlayer extends javax.swing.JFrame {
    
    protected PlayerEventHandler peh = null;
    
    public TelaPlayer(){
    	super();
        this.peh = new PlayerEventHandler(this);
       
    }
    
    class PlayerEventHandler extends WindowAdapter  {
        List<TelaPlayerListener> listeners = new LinkedList<TelaPlayerListener>();
        TelaPlayer tp = null;
        
        PlayerEventHandler(TelaPlayer tp){
            this.tp = tp;
            this.tp.addWindowListener(this);
       
        }
        
        @Override
        public void windowOpened(WindowEvent evt) {
            System.out.println("Window Opened!");
            TelaPlayerEvent ev = new TelaPlayerEvent(this.tp);
            ev.setAction(TelaPlayerEvent.INIT_PLAYER);
            this.sendEvent(ev);
        }
        
        @Override
        public void windowClosing(WindowEvent evt) {
            System.out.println("Window Closed!");
            TelaPlayerEvent ev = new TelaPlayerEvent(this.tp);
            ev.setAction(TelaPlayerEvent.CLOSE_PLAYER);
            this.sendEvent(ev);
        }
        
        
        void sendEvent(final TelaPlayerEvent tie){
            for(final TelaPlayerListener tl : listeners){
                new Thread(){
                    @Override
                    public void run(){
                        tl.receiveEvent(tie);
                    }
                }.start();
            }
        }


	
    }
    
    public void addListener(TelaPlayerListener til){
        this.peh.listeners.add(til);
    }
    public void removeListener(TelaPlayerListener til){
        this.peh.listeners.remove(til);
    }
}
