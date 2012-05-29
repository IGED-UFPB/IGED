
package br.ufpb.iged.tutor.ncm.event;

import br.ufpb.iged.tutor.ncm.entity.Entity;

/**
 *
 * @author GILBERTO FARIAS
 */
public class SelectionEvent extends EntityEvent{
    private Entity source = null;
    
    

    @Override
    public Entity getSource() {
        return source;
    }

    public void setSource(Entity source) {
        this.source = source;
    }
}
