/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gui.event;

import br.ufpb.iged.gui.AnchorIcon;

/**
 *
 * @author GILBERTO FARIAS
 */
public class AnchorIconEvent extends TelaPlayerEvent{
    public AnchorIconEvent(AnchorIcon ti){
        super(ti);
    }

    @Override
    public AnchorIcon getSource() {
        return (AnchorIcon)source;
    }

    public void setSource(AnchorIcon source) {
        this.source = source;
    }
}
