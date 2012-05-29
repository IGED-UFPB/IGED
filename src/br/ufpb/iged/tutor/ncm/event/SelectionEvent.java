
package br.ufpb.iged.tutor.ncm.event;

import br.ufpb.iged.tutor.ncm.entity.Entity;

/**
 *
 * @author GILBERTO FARIAS
 */
public class SelectionEvent extends EntityEvent{

    public SelectionEvent(){
    }
    
    public SelectionEvent(SelectionEvent e){
        super(e);
    }
    
    @Override
    public Entity getSource() {
        return source;
    }

    public void setSource(Entity source) {
        this.source = source;
    }
    
    @Override
    public EntityEvent getCopy() {
        return new SelectionEvent(this);
    }
}
