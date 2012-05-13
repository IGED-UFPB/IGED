
package br.ufpb.iged.tutor.ncm.event.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ContextNode extends CompositeNode{
    private Map<String, Link> links;
    
    ContextNode(){
        this.links = new HashMap<String, Link>();
    }
    
    public void add(Link l){
        this.links.put(l.getId(), l);
    }
    public void remove(Link l){
        this.links.remove(l.getId());
    }
    
    @Override
    public void add(Node n){
        this.nodes.put(n.getId(), n);
    }

    public Collection<Link> getLinks() {
        return links.values();
    }
    public Link getLink(String id){
        return this.links.get(id);
    }
}

