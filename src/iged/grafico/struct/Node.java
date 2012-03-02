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
public abstract class Node extends Struct  {
    
    public abstract Point2D getPointPI();
    public abstract Point2D add(Referencia ref);
    public abstract void remove(Referencia ref);
    public abstract boolean isRepintado();
    public abstract void setRepintado(boolean state);

    
}
