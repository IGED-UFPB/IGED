
package br.ufpb.iged.tutor.ncm;

import java.util.List;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class CompositeNode extends Node{
    List<Port> ports;
    List<Node> nodes;
    
    public abstract void add(Node n);
    
    public void remove(Node n){
        this.nodes.remove(n);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Port> getPorts() {
        return ports;
    }
    
    public void add(Port p){
        this.ports.add(p);
    }
    public void remove(Port p){
        this.ports.remove(p);
    }
}
