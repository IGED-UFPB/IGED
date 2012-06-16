package br.ufpb.iged.gui.event;

import br.ufpb.iged.gui.TelaPlayer;

/**
 *
 * @author GILBERTO FARIAS
 */
public class TelaPlayerEvent {
    
    TelaPlayer source = null;
    int action;
    
    public TelaPlayerEvent(TelaPlayer ti){
        this.source = ti;
    }

    public TelaPlayer getSource() {
        return source;
    }

    public void setSource(TelaPlayer source) {
        this.source = source;
    }
    
    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
    
    public static final int UNKNOWN = -1;
    public static final int CLOSE_PLAYER = 0;
    public static final int INIT_PLAYER = 1;
    public static final int SELECT_NEXT_NODE = 2;
    public static final int SELECT_PREVIUS_NODE = 3;
    public static final int SELECT_ANCHOR = 4;
}
