
package br.ufpb.iged.tutor.ncm.entity;

<<<<<<< HEAD
=======
import br.ufpb.iged.tutor.ncm.event.EventStateMachine;
import br.ufpb.iged.tutor.ncm.event.PresentationEvent;
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GILBERTO FARIAS
<<<<<<< HEAD
 */
public abstract class Node extends Entity{
    Map<String, Anchor> anchors;
    
    Node(){
        this.anchors = new HashMap<String, Anchor>();
    }
    
=======
 * 
 * Representa todos os nós do NCM, implementando o padrão Observer
 * para enviar os eventos ocorridos no Nó. 
 */
public abstract class Node extends Entity{
    private Map<String, Anchor> anchors;
    protected EventStateMachine presetationMachine = null;
    
    Node(){
        this.anchors = new HashMap<String, Anchor>(); 
        PresentationEvent pe = new PresentationEvent();
        this.presetationMachine = new EventStateMachine(pe);
    }
    
    public abstract void execute(String interfaceID);
    public abstract void finish();
    
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
    public void add(Anchor a){
        this.anchors.put(a.getId(), a);
    }
    
    public void remove(Anchor a){
        this.anchors.remove(a.getId());
    }

    public Anchor getAnchor(String id){
        return this.anchors.get(id);
    }
    
    public Collection<Anchor> getAnchors() {
        return anchors.values();
    }
    
<<<<<<< HEAD
=======
    public int getState(){
        return this.presetationMachine.getStatus();
    }
    
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
}
