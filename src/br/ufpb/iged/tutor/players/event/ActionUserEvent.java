package br.ufpb.iged.tutor.players.event;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ActionUserEvent extends PlayerEvent{

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
    
    private int action;
    public static final int UNKNOWN = -1;
    public static final int CLOSE_PLAYER = 0;
    public static final int SELECT_NEXT_NODE = 1;
    public static final int SELECT_PREVIUS_NODE = 2;
    public static final int SELECT_ANCHOR = 3;
}
