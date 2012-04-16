
package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.event.EventStateMachine;
import br.ufpb.iged.tutor.ncm.event.SelectionEvent;

/**
 *
 * @author GILBERTO FARIAS
 */
public class Anchor extends Interface{
    EventStateMachine selectionMachine = null;
    
    public Anchor(){
        SelectionEvent se = new SelectionEvent();
        this.selectionMachine = new EventStateMachine(se);
    }
}
