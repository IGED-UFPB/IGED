
package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.event.EntityEvent;
import br.ufpb.iged.tutor.players.Player;
import br.ufpb.iged.tutor.players.event.ActionUserEvent;
import br.ufpb.iged.tutor.players.event.PlayerEvent;
import br.ufpb.iged.tutor.players.event.PlayerListener;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author GILBERTO FARIAS
 */
public class Trail extends CompositeNode implements PlayerListener{
    List<Node> lista = null;
    ListIterator<Node> iNode = null;
    Node currentNode = null;
    
    //Player de slides
    Player player = null;  
    
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
        //if(this.player == null)
        //    this.player = new SlidePlayer();
        player.init();
        Port p = this.getPort(portID);
        this.home(p.getComponent());
        this.execute(p);
    }
    
    @Override
    public void pause(){
        if(this.getState() != EntityEvent.OCCURING)
            return;
        
        this.player.pause();
        super.pause();
    }
    
    @Override
    public void resume() {
        if((currentNode != null)
                    && (currentNode.getState() != EntityEvent.OCCURING))
                currentNode.resume();
        if(this.getState() != EntityEvent.OCCURING){
                this.player.resume();
                super.resume();
        }
    }
    
    @Override
    public void finish(){
        if((currentNode != null)
                    &&(currentNode.getState() != EntityEvent.SLEEPING))
                currentNode.finish();
        
        if(this.getState() != EntityEvent.SLEEPING){
                this.player.finish();
                super.finish();
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
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("trail");       
        element.setAttribute("id", getId());
    
        return element;
    
    }

    @Override
    public void receiveEvent(PlayerEvent e) {
        if(e instanceof ActionUserEvent){
            ActionUserEvent aue = (ActionUserEvent)e;
            switch(aue.getAction()){
                case ActionUserEvent.CLOSE_PLAYER:
                    this.finish();
                    break;
                    
                case ActionUserEvent.SELECT_NEXT_NODE: 
                    this.next();
                    break;
                    
                case ActionUserEvent.SELECT_PREVIUS_NODE: 
                    this.previus();
                    break;
            }
        }
    }
}
