package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.event.CompositionEvent;
import br.ufpb.iged.tutor.ncm.event.EntityEvent;
import br.ufpb.iged.tutor.ncm.event.EntityListener;
import br.ufpb.iged.tutor.ncm.event.EventStateMachine;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class CompositeNode extends Node implements EntityListener{
    protected Map<String, Port> ports;
    protected Map<String, Node> nodes;
    
    CompositeNode(){
        super();
        this.ports = new HashMap<String, Port>();
        this.nodes = new HashMap<String, Node>();

        CompositionEvent ce = new CompositionEvent();
        ce.setSource(this);
        this.presetationMachine = new EventStateMachine(ce);
    }
    
    @Override
    Entity getComponentByInterface(String aInterface) {
        Port p = this.ports.get(aInterface);
        if(p != null){
            Node n = this.nodes.get(p.getComponent());
            if(n != null){  
                if(p.getIp() != null){
                    return n.getComponentByInterface(p.getIp());
                }else
                    return n;
            }else
                return null;
        }
        return super.getComponentByInterface(aInterface);
    }
      
    @Override
    public void execute(String portID){
        Port p = this.getPort(portID);
        if(p == null)
            return;//lançar excessão
        this.execute(p);
    }
    
    @Override
    public void resume(String portID){
        Port p = this.getPort(portID);
        if(p == null)
            return;//lançar excessão
        this.resume(p);
    }
    
    @Override
    public void pause(){
        if(this.getState() != EntityEvent.OCCURING)
            return;
        
        this.presetationMachine.transitionPauses();
        for(Node n : this.getNodes())
            if(n.getState() == EntityEvent.OCCURING)
                n.pause();
    }
     
    
    @Override
    public void finish(){
        if(this.getState() == EntityEvent.SLEEPING)
            return;
        
        this.presetationMachine.transitionStops();
        for(Node n : this.getNodes()){
            n.removeListener(this);
            if(n.getState() != EntityEvent.SLEEPING)
                n.finish();
        }
    }
    
    protected void execute(Port p){
        if(this.getState() == EntityEvent.OCCURING)
            return;
        
        System.out.println("Init execute CompositeNode: " + this.getId());
        this.presetationMachine.transitionStarts();
        //Registrando escutadores em todos Nodes do CompositeNode.
        for(Node n : nodes.values())
            n.addListener(this);
        
        //Executando o Node referenciado pela porta indicada por parâmetro
        Node n = this.getNode(p.getComponent());
        if(n instanceof ContentNode){
            ((ContentNode)n).execute();
        }else{
            if(p.getIp() != null){
                n.execute(p.getIp());
            }
        }
        
    }
    
    @Override
    public void resume(){
        if(this.getState() == EntityEvent.OCCURING)
            return;
        
        System.out.println("Resume execute CompositeNode: " + this.getId());
        this.presetationMachine.transitionResumes();
        
    }
    
    protected void resume(Port p){
        if(this.getState() == EntityEvent.OCCURING)
            return;
        
        System.out.println("Resume execute CompositeNode: " + this.getId());
        this.resume();
        
        //Executando o Node referenciado pela porta indicada por parâmetro
        Node n = this.getNode(p.getComponent());
        if(n instanceof ContentNode){
            ((ContentNode)n).resume();
        }else{
            if(p.getIp() != null)
                n.resume(p.getIp());
        }
        
    }
    
    @Override
    public void stateTransition(EntityEvent e) {
        System.out.println("Event: " + e.getSource().getId());
        synchronized(this){
            switch(e.getStaus()){
                 case EntityEvent.OCCURING:
                    if(this.getState() != EntityEvent.OCCURING){
                        this.resume();
                        //this.presetationMachine.transitionResumes();
                    }
                    break;
                //Se n houver nenhum node executanto, lança transicao de PAUSED
                case EntityEvent.PAUSED:
                    boolean isOccuring = false;
                    for(Node n : this.getNodes()){
                        if(n.getState() == EntityEvent.OCCURING)
                            isOccuring = true;
                    }
                    if((!isOccuring) && (this.getState() == EntityEvent.OCCURING)){
                            this.pause();
                            //this.presetationMachine.transitionPauses();
                    }
                    break;
                //Se todos os nodes estiverem parados,lança transicao de SLEEPING
                case EntityEvent.SLEEPING:
                    boolean isSleeping = true;
                    for(Node n : this.getNodes()){
                        if((n.getState() == EntityEvent.OCCURING)
                                || (n.getState() == EntityEvent.PAUSED))
                            isSleeping = false;
                    }
                    if((isSleeping) && (this.getState() != EntityEvent.SLEEPING)){
                        this.finish();
                        //this.presetationMachine.transitionStops();
                        for(Node n : nodes.values())
                            n.removeListener(this);
                    }
                    break;
                //Se
            }
        }
    }
        
    public abstract void add(Node n);
    
    public void remove(Node n){
        this.nodes.remove(n.getId());
    }

    public Collection<Node> getNodes() {
        return nodes.values();
    }
    
    public Node getNode(String id){
        return this.nodes.get(id);
    }

    public Collection<Port> getPorts() {
        return ports.values();
    }
    
    public void add(Port p){
        this.ports.put(p.getId(), p);
    }
    public void remove(Port p){
        this.ports.remove(p.getId());
    }
    
    public Port getPort(String id){
        return this.ports.get(id);
    }
}
