package br.ufpb.iged.gui.event;

import br.ufpb.iged.gui.TelaIGEDlet;

/**
 *
 * @author GILBERTO FARIAS
 */
public class TelaIGEDletEvent extends TelaPlayerEvent{
    
    TelaIGEDletEvent(TelaIGEDlet ti){
        super(ti);
    }

    public TelaIGEDlet getSource() {
        return (TelaIGEDlet)source;
    }

    public void setSource(TelaIGEDlet source) {
        this.source = source;
    }
}
