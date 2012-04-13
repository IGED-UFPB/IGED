
package br.ufpb.iged.tutor.ncm.event;

import br.ufpb.iged.tutor.ncm.entity.Anchor;
import br.ufpb.iged.tutor.ncm.entity.ContentNode;

/**
 *
 * @author GILBERTO FARIAS
 */
public class SelectionEvent extends EntityEvent{
    private ContentNode source = null;
    private Anchor contentAnchor = null;
    
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
