
package br.ufpb.iged.tutor.ncm.event;

<<<<<<< HEAD
=======
import br.ufpb.iged.tutor.ncm.entity.Entity;

>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
/**
 *
 * @author GILBERTO FARIAS
 */
public class EventStateMachine {
<<<<<<< HEAD
    private Event event = null;

    public EventStateMachine(Event e){
        this.event = e;
    }
    
    Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
    public void transitionStarts(){
        if(this.event.getStaus() != Event.OCCURING){
            this.event.setStaus(Event.OCCURING);
=======
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
        e.receiveEventStateTransition(this.event);
    }
    
    public void transitionStarts(){
        if(this.event.getStaus() != EntityEvent.OCCURING){
            this.event.setStaus(EntityEvent.OCCURING);
            
            this.sendEvent();
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
        }
    }
    
    public void transitionResumes(){
<<<<<<< HEAD
        if(this.event.getStaus() == Event.PAUSED){
            this.event.setStaus(Event.OCCURING);
=======
        if(this.event.getStaus() == EntityEvent.PAUSED){
            this.event.setStaus(EntityEvent.OCCURING);
            
            this.sendEvent();
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
        }
    }
    
    public void transitionPauses(){
<<<<<<< HEAD
        if(this.event.getStaus() == Event.OCCURING){
            this.event.setStaus(Event.PAUSED);
=======
        if(this.event.getStaus() == EntityEvent.OCCURING){
            this.event.setStaus(EntityEvent.PAUSED);
            
            this.sendEvent();
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
        }
    }
    
    public void transitionStops(){
<<<<<<< HEAD
        if(this.event.getStaus() != Event.SLEEPING){
            this.event.setStaus(Event.SLEEPING);
=======
        if(this.event.getStaus() != EntityEvent.SLEEPING){
            this.event.setStaus(EntityEvent.SLEEPING);
            
            this.sendEvent();
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
        }
    }
    
    public void transitionAborts(){
<<<<<<< HEAD
        if(this.event.getStaus() != Event.SLEEPING){
            this.event.setStaus(Event.SLEEPING);
        }
    }
=======
        if(this.event.getStaus() != EntityEvent.SLEEPING){
            this.event.setStaus(EntityEvent.SLEEPING);
            
            this.sendEvent();
        }
    }

    public int getStatus() {
        return this.event.getStaus();
    }
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
}
