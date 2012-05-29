
package br.ufpb.iged.tutor.ncm.event;

import br.ufpb.iged.tutor.ncm.entity.CompositeNode;

/**
 *
 * @author GILBERTO FARIAS
 */
public class CompositionEvent extends EntityEvent{
    public CompositionEvent(){
    }
    
    public CompositionEvent(CompositionEvent e){
        super(e);
    }
    
    @Override
    public CompositeNode getSource() {
        return (CompositeNode)source;
    }

    public void setSource(CompositeNode source) {
        this.source = source;
    }

    @Override
    public EntityEvent getCopy() {
        return new CompositionEvent(this);
    }
   
}
