/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gui;

import br.ufpb.iged.gui.event.AnchorIconEvent;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author GILBERTO FARIAS
 */
public class AnchorIcon extends TelaPlayer implements MouseListener
{
    private JLabel anchor;
    private double x, y;
    
    public AnchorIcon(double x, double y)
    {
        this.setXY(x, y);
        this.anchor = new JLabel();
        ImageIcon i = new ImageIcon("imagens/play.png");
        this.anchor.setIcon(i);
        this.anchor.setSize(new Dimension(i.getImage().getWidth(null), i.getImage().getHeight(null))); 
        this.anchor.setLocation((int)this.x, (int)this.y);
        this.anchor.addMouseListener(this);
    }

    public AnchorIcon(Point2D point) {
        this(point.getX(), point.getY());
    }
    
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    JLabel getIcon(){
        return this.anchor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        AnchorIconEvent aie = new AnchorIconEvent(this);
        aie.setAction(AnchorIconEvent.SELECT_ANCHOR);
        this.peh.sendEvent(aie);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
