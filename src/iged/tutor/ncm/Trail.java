
package iged.tutor.ncm;

/**
 *
 * @author GILBERTO FARIAS
 */
public class Trail extends CompositeNode{
    int currentNode = -1;

    public Node getCurrentNode() {
        if((currentNode >= 0) || (currentNode > this.nodes.size()))
                return null;
        return this.nodes.get(currentNode);
    }
    
    public void home(){
        currentNode = 0;
    }
    
    public void next(){
        currentNode = (currentNode + 1) % this.nodes.size();
    }
    
    public void previus(){
        --currentNode;
        if(currentNode < 0)
            currentNode = this.nodes.size() - 1;
    }
}
