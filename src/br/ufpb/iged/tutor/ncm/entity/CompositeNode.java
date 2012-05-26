package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.event.EntityEvent;
import br.ufpb.iged.tutor.ncm.event.EntityListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class CompositeNode extends Node implements EntityListener{
    protected Map<String, Port> ports;
    protected Map<String, Node> nodes;
    private Semaphore sem = null;
    
    CompositeNode(){
        this.ports = new HashMap<String, Port>();
        this.nodes = new HashMap<String, Node>();

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
        this.execute(p);
    }
    
    public void finish(){
        for(Node n : this.getNodes())
            n.finish();
    }
    
    protected void execute(Port p){
        //Registrando escutadores em todos Nodes do CompositeNode.
        for(Node n : nodes.values())
            n.addListener(this);
        
        //Executando o Node referenciado pela porta indicada por parâmetro
        Node n = this.getNode(p.getComponent());
        if(p.getIp() != null){
            n.execute(p.getIp());
        }else{
            if(n instanceof ContentNode)
                ((ContentNode)n).execute();
        }
        
    }
    
    @Override
    public void stateTransition(EntityEvent e) {
        synchronized(this){
            switch(e.getStaus()){
                //Se n houver nenhum node executanto, lança transicao de PAUSED
                case EntityEvent.PAUSED:
                    boolean isOccuring = false;
                    for(Node n : this.getNodes()){
                        if(n.getState() == EntityEvent.OCCURING)
                            isOccuring = true;
                    }
                    if(!isOccuring)
                        this.presetationMachine.transitionPauses();
                    break;
                //Se todos os nodes estiverem parados,lança transicao de SLEEPING
                case EntityEvent.SLEEPING:
                    boolean isSleeping = true;
                    for(Node n : this.getNodes()){
                        if((n.getState() == EntityEvent.OCCURING)
                                || (n.getState() == EntityEvent.PAUSED))
                            isSleeping = false;
                    }
                    if(!isSleeping){
                        this.presetationMachine.transitionStops();
                        for(Node n : nodes.values())
                            n.removeListener(this);
                    }
                    break;
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
