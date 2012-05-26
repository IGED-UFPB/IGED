
package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.event.EntityEvent;
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
    
    /*
     * Coloca como no corrente, o elemento que tenha o id passado como parametro.
     */
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
    
    @Override
    public void finish(){
        if(currentNode != null){
            if(currentNode.getState() != EntityEvent.SLEEPING)
                currentNode.finish();
        }
    }
    
    private void changeExecution(Node current, Node last){
        if(current != null){
            if(current instanceof ContentNode)
                ((ContentNode)current).execute();
        }
        
        if(last != null)
            last.finish();
    }
    
    public void next() throws NoSuchElementException{
        Node last = currentNode;
        currentNode = iNode.next();
        
        this.changeExecution(currentNode, last);
            
    }
    
    public void previus() throws NoSuchElementException{
        Node last = currentNode;
        currentNode = iNode.previous();
        
        this.changeExecution(currentNode, last);
    }
    
    @Override
    public void add(Node n){
        this.nodes.put(n.getId(), n);
    }
}
