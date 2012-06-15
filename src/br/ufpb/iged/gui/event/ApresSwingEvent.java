/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gui.event;

import br.ufpb.iged.gui.ApresSwing;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ApresSwingEvent {
    ApresSwing source = null;
    int action;
    
    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public ApresSwing getSource() {
        return source;
    }

    public void setSource(ApresSwing source) {
        this.source = source;
    }
    
    public static final int UNKNOWN = -1;
    public static final int CLOSE_PLAYER = 0;
    public static final int SELECT_NEXT_NODE = 1;
    public static final int SELECT_PREVIUS_NODE = 2;
    public static final int SELECT_ANCHOR = 3;
}
