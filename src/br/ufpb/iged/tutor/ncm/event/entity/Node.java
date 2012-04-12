
package br.ufpb.iged.tutor.ncm.event.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class Node extends Entity{
    Map<String, Anchor> anchors;
    
    Node(){
        this.anchors = new HashMap<String, Anchor>();
    }
    
    public void add(Anchor a){
        this.anchors.put(a.getId(), a);
    }
    
    public void remove(Anchor a){
        this.anchors.remove(a.getId());
    }

    public Anchor getAnchor(String id){
        return this.anchors.get(id);
    }
    
    public Collection<Anchor> getAnchors() {
        return anchors.values();
    }
    
}
