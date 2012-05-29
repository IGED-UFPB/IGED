
package br.ufpb.iged.tutor.ncm.event;

import br.ufpb.iged.tutor.ncm.entity.Entity;

/**
 *
 * @author GILBERTO FARIAS
 */
public class EventStateMachine {
    private EntityEvent event = null;

    public EventStateMachine(EntityEvent e){
        this.event = e;
    }
    
    EntityEvent getEvent() {
        return event;
    }

    public void setEvent(EntityEvent event) {
        this.event = event;
    }
    
    /**
     * Envia o evento para seus escutadores.
     */
    private void sendEvent(){
        Entity e = this.event.getSource();
        e.receiveEventStateTransition(this.event.getCopy());
        //Se o evento for SelectionEvent, sua transição para o estado
        //SLEEPING deve ser imediata
        if(this.event instanceof SelectionEvent)
            this.transitionStops();
    }
    
    public void transitionStarts(){
        if(this.event.getStaus() != EntityEvent.OCCURING){
            this.event.setStaus(EntityEvent.OCCURING);
            
            this.sendEvent();
        }
    }
    
    public void transitionResumes(){
        if(this.event.getStaus() == EntityEvent.PAUSED){
            this.event.setStaus(EntityEvent.OCCURING);
            
            this.sendEvent();
        }
    }
    
    public void transitionPauses(){
        if(this.event.getStaus() == EntityEvent.OCCURING){
            this.event.setStaus(EntityEvent.PAUSED);
            
            this.sendEvent();
        }
    }
    
    public void transitionStops(){
        if(this.event.getStaus() != EntityEvent.SLEEPING){
            this.event.setStaus(EntityEvent.SLEEPING);
            
            this.sendEvent();
        }
    }
    
    public void transitionAborts(){
        if(this.event.getStaus() != EntityEvent.SLEEPING){
            this.event.setStaus(EntityEvent.SLEEPING);
            
            this.sendEvent();
        }
    }

    public int getStatus() {
        return this.event.getStaus();
    }
}
