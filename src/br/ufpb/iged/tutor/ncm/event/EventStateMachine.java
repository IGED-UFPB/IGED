
package br.ufpb.iged.tutor.ncm.event;

/**
 *
 * @author GILBERTO FARIAS
 */
public class EventStateMachine {
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
        }
    }
    
    public void transitionResumes(){
        if(this.event.getStaus() == Event.PAUSED){
            this.event.setStaus(Event.OCCURING);
        }
    }
    
    public void transitionPauses(){
        if(this.event.getStaus() == Event.OCCURING){
            this.event.setStaus(Event.PAUSED);
        }
    }
    
    public void transitionStops(){
        if(this.event.getStaus() != Event.SLEEPING){
            this.event.setStaus(Event.SLEEPING);
        }
    }
    
    public void transitionAborts(){
        if(this.event.getStaus() != Event.SLEEPING){
            this.event.setStaus(Event.SLEEPING);
        }
    }
}
