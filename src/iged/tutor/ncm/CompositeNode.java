
package iged.tutor.ncm;

import java.util.List;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class CompositeNode extends Node{
    List<Port> ports;
    List<Node> nodes;
    
    public void add(Node n){
        this.nodes.add(n);
    }
    public void remove(Node n){
        this.nodes.remove(n);
    }
    
    public void add(Port p){
        this.ports.add(p);
    }
    public void remove(Port p){
        this.ports.remove(p);
    }
}
