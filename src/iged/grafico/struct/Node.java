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

    public abstract void setRepintado(boolean state);

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
        }
        if (!ref.isFixa()) {
            ++this.numRef;
        }
        return pi;
        
    }

    public void remove(Referencia ref) {
        if (this.referencias.contains(ref)) {
            int j = this.referencias.indexOf(ref);
            this.numRef = j - 1;
            this.referencias.remove(ref);

            for (int i = j; i < this.referencias.size(); ++i) {
                this.referencias.get(i).config(this);
            }
        }
    }
}
