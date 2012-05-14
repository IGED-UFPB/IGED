
package br.ufpb.iged.tutor.ncm.entity;

<<<<<<< HEAD
/**
 *
 * @author GILBERTO FARIAS
=======
import br.ufpb.iged.tutor.ncm.event.EntityEvent;
import br.ufpb.iged.tutor.ncm.event.EntityListener;
import br.ufpb.iged.tutor.ncm.event.EventStateMachine;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author GILBERTO FARIAS
 * Representa todas as entidades do NCM, implementando o padrão Observer
 * para enviar os eventos ocorridos nas entidades.
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
 */
public abstract class Entity {
    private String id;
    private String name;
    private String description;
<<<<<<< HEAD
=======
    
    private List<EntityListener> listeners = null;
    
    Entity(){
        this.listeners = new LinkedList<EntityListener>();
    }
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
<<<<<<< HEAD
=======
    
        
    public void addListener(EntityListener el){
        this.listeners.add(el);
    }
    
    public void removeListener(EntityListener el){
        this.listeners.remove(el);
    }
    
    public void receiveEventStateTransition(final EntityEvent ne){
        for(final EntityListener nl : this.listeners){
            new Thread(){
                @Override
                public void run(){
                    nl.stateTransition(ne);
                }
            }.start();
        }
    }
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
}
