
package br.ufpb.iged.tutor.ncm.event;

import br.ufpb.iged.tutor.ncm.entity.Anchor;
import br.ufpb.iged.tutor.ncm.entity.ContentNode;

/**
 *
 * @author GILBERTO FARIAS
 */
<<<<<<< HEAD
public class PresentationEvent extends Event{
=======
public class PresentationEvent extends EntityEvent{
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
    private ContentNode source = null;
    private Anchor contentAnchor = null;
    
    private int repetitions = 0; 
    
    public Anchor getContentAnchor() {
        return contentAnchor;
    }

    void setContentAnchor(Anchor contentAnchor) {
        this.contentAnchor = contentAnchor;
    }

    @Override
    public ContentNode getSource() {
        return source;
    }

    void setSource(ContentNode source) {
        this.source = source;
    }
    
}
