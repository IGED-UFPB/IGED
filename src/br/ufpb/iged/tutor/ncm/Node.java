
package br.ufpb.iged.tutor.ncm;

import java.util.List;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class Node extends Entity{
    List<Anchor> anchors;
    
    public void add(Anchor a){
        this.anchors.add(a);
    }
    
    public void remove(Anchor a){
        this.anchors.remove(a);
    }

    public List<Anchor> getAnchors() {
        return anchors;
    }
    
}
