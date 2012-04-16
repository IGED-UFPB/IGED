
package br.ufpb.iged.tutor.ncm.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author GILBERTO FARIAS
 */
public class Trail extends CompositeNode{
    List<Node> lista = null;
    ListIterator<Node> iNode = null;
    Node currentNode = null;
    //int 

    public Node getCurrentNode() {
        return this.currentNode;
    }
    
    public void home(String componentID){
        if(this.nodes.size() > 0){
            if(this.lista == null)
                this.lista = new LinkedList<Node>(this.nodes.values());
            iNode = this.lista.listIterator();
            while(true){
                currentNode = iNode.next();
                if(currentNode == null){
                    //lancar exception
                    return;
                }
                if(currentNode.getId().equals(componentID))
                    break;
            }
            
        }
    }
    
    @Override
    public void execute(String portID){
        Port p = this.getPort(portID);
        this.home(p.getComponent());
        this.execute(p);
    }
    
    public void next() throws NoSuchElementException{
        Node last = currentNode;
        currentNode = iNode.next();
        
        if(currentNode != null){
            if(currentNode instanceof ContentNode)
                ((ContentNode)currentNode).execute();
        }
        last.finish();
            
    }
    
    public void previus() throws NoSuchElementException{
        currentNode = iNode.previous();
    }
    
    @Override
    public void add(Node n){
        this.nodes.put(n.getId(), n);
    }
}
