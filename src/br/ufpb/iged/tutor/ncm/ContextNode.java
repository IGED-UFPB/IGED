
package br.ufpb.iged.tutor.ncm;

import java.util.List;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ContextNode extends CompositeNode{
    private List<Link> links;
    
    public void add(Link l){
        this.links.add(l);
    }
    public void remove(Link l){
        this.links.remove(l);
    }
    
    @Override
    public void add(Node n){
        this.nodes.add(n);
    }

    public List<Link> getLinks() {
        return links;
    }
}
