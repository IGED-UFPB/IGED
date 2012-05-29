
package br.ufpb.iged.tutor.ncm.event;

import br.ufpb.iged.tutor.ncm.entity.Anchor;
import br.ufpb.iged.tutor.ncm.entity.ContentNode;
import br.ufpb.iged.tutor.ncm.entity.Entity;

/**
 *
 * @author GILBERTO FARIAS
 */
public class PresentationEvent extends EntityEvent{
    private Anchor contentAnchor = null;
    private int repetitions = 0; 
    
    
    public PresentationEvent(){
    }
    
    public PresentationEvent(PresentationEvent e){
        super(e);
        this.contentAnchor = e.contentAnchor;
        this.repetitions = e.repetitions;
    }
    
    public Anchor getContentAnchor() {
        return contentAnchor;
    }

    void setContentAnchor(Anchor contentAnchor) {
        this.contentAnchor = contentAnchor;
    }

    @Override
    public ContentNode getSource() {
        return (ContentNode)source;
    }

    public void setSource(Entity source) {
        this.source = source;
    }

    @Override
    public EntityEvent getCopy() {
        return new PresentationEvent(this);
    }
    
}
