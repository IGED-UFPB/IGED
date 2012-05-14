
package br.ufpb.iged.tutor.ncm.entity;

<<<<<<< HEAD
=======
import br.ufpb.iged.tutor.ncm.event.EventStateMachine;
import br.ufpb.iged.tutor.ncm.event.SelectionEvent;

>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
/**
 *
 * @author GILBERTO FARIAS
 */
public class Anchor extends Interface{
<<<<<<< HEAD
    
=======
    EventStateMachine selectionMachine = null;
    
    public Anchor(){
        SelectionEvent se = new SelectionEvent();
        this.selectionMachine = new EventStateMachine(se);
    }
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
}
