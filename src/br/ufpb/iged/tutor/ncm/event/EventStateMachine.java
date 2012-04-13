
package br.ufpb.iged.tutor.ncm.event;

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
    
    public void transitionStarts(){
        if(this.event.getStaus() != EntityEvent.OCCURING){
            this.event.setStaus(EntityEvent.OCCURING);
        }
    }
    
    public void transitionResumes(){
        if(this.event.getStaus() == EntityEvent.PAUSED){
            this.event.setStaus(EntityEvent.OCCURING);
        }
    }
    
    public void transitionPauses(){
        if(this.event.getStaus() == EntityEvent.OCCURING){
            this.event.setStaus(EntityEvent.PAUSED);
        }
    }
    
    public void transitionStops(){
        if(this.event.getStaus() != EntityEvent.SLEEPING){
            this.event.setStaus(EntityEvent.SLEEPING);
        }
    }
    
    public void transitionAborts(){
        if(this.event.getStaus() != EntityEvent.SLEEPING){
            this.event.setStaus(EntityEvent.SLEEPING);
        }
    }
}
