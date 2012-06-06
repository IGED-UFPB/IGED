package br.ufpb.iged.tutor.players.event;

import br.ufpb.iged.tutor.players.Player;

/**
 *
 * @author GILBERTO FARIAS
 */
public class PlayerEvent {
    protected Player source = null;

    public PlayerEvent(){
        
    }

    public Player getSource() {
        return source;
    }

    public void setSource(Player source) {
        this.source = source;
    }
    
}
