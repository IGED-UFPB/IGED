/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.grafico.struct;

import java.awt.geom.Point2D;

/**
 *
 * @author smith
 */
public abstract class Node extends Struct {

    protected int numRef = -1;
    
    
    public void add(String ref) {
    }

    public void mover(final double dx, final double dy, final int t) {

        super.mover(dx, dy, t);

        for (Referencia r : this.referencias) {
            if (!r.isFixa()) {
                r.mover(dx, dy, t);
            } else {
                r.atualiza(dx, dy);
            }
        }

    }

    public Point2D add(Referencia ref) {
        if (!this.referencias.contains(ref)) {
            System.out.println("ADDDDDD");
            this.referencias.add(ref);
            this.elementos.add(ref);
        }
        if (!ref.isFixa()) {
            ++this.numRef;
        }
        return pi;
    }

    @Override
    public void remove(Referencia ref) {
        if (this.referencias.contains(ref)) {
            System.out.println("Node contém a referencia");
            int j = this.referencias.indexOf(ref);
            this.numRef = j - 1;
            this.referencias.remove(ref);
            System.out.println("Node tem " + this.elementos.size());
            this.elementos.remove(ref);
            //Quadro.getInstance().remove(ref);
            System.out.println("Node agora tem " + this.elementos.size());
            
            for (int i = j; i < this.referencias.size(); ++i) {
                this.referencias.get(i).config(this);
            }
        }else{
            System.out.println("Node não contém a referencia");
        }
    }
}
