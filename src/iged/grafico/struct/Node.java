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
public interface Node extends Struct  {
    
    public Point2D getPointPI();
    public Point2D add(Referencia ref);
    public void remove(Referencia ref);
    public boolean isRepintado();
    public void setRepintado(boolean state);

    
}
