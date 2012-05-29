
package br.ufpb.iged.tutor.ncm.event;

import br.ufpb.iged.tutor.ncm.entity.CompositeNode;

/**
 *
 * @author GILBERTO FARIAS
 */
public class CompositionEvent extends EntityEvent{
    private CompositeNode source = null;

    @Override
    public CompositeNode getSource() {
        return source;
    }

    public void setSource(CompositeNode source) {
        this.source = source;
    }

   
}
