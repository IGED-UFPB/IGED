package br.ufpb.iged.tutor.players;

import br.ufpb.iged.tutor.players.event.PlayerListener;
import br.ufpb.iged.tutor.players.event.PlayerEvent;
import br.ufpb.iged.tutor.ncm.entity.Node;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class Player {
    public abstract void init();
    public abstract void execute();
    public abstract void resume();
    public abstract void pause();
    public abstract void finish();
    public abstract void play(Node n);
    
    public void addListener(PlayerListener el){
        this.listeners.add(el);
    }
    
    public void removeListener(PlayerListener el){
        this.listeners.remove(el);
    }
    
    public void sendEvent(final PlayerEvent ne){
        for(final PlayerListener nl : this.listeners){
            new Thread(){
                @Override
                public void run(){
                    nl.receiveEvent(ne);
                }
            }.start();
        }
    }
    
    private List<PlayerListener> listeners = new LinkedList<PlayerListener>();
}
