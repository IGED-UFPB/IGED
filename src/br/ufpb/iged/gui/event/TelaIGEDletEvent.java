package br.ufpb.iged.gui.event;

import br.ufpb.iged.gui.TelaIGEDlet;

/**
 *
 * @author GILBERTO FARIAS
 */
public class TelaIGEDletEvent {
    public TelaIGEDlet source = null;
    
    TelaIGEDletEvent(TelaIGEDlet ti){
        this.source = ti;
    }

    public TelaIGEDlet getSource() {
        return source;
    }

    public void setSource(TelaIGEDlet source) {
        this.source = source;
    }
}
