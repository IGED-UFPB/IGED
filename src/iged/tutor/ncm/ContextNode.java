
package iged.tutor.ncm;

import java.util.List;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ContextNode extends CompositeNode{
    List<Link> links;
    
    public void add(Link l){
        this.links.add(l);
    }
    public void remove(Link l){
        this.links.remove(l);
    }
    
}
