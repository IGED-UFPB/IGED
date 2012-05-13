
package br.ufpb.iged.tutor.ncm.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class CompositeNode extends Node{
    Map<String, Port> ports;
    Map<String, Node> nodes;
    
    CompositeNode(){
        this.ports = new HashMap<String, Port>();
        this.nodes = new HashMap<String, Node>();
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
