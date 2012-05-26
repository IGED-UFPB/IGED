
package br.ufpb.iged.tutor.ncm.entity;

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
 */
public abstract class Entity {
    private String id;
    private String name;
    private String description;
    
    private List<EntityListener> listeners = null;
    
    Entity(){
        this.listeners = new LinkedList<EntityListener>();
    }

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
}
