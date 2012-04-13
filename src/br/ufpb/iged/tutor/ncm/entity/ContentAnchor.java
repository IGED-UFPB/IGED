/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.entity;

import java.awt.geom.Point2D;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ContentAnchor extends Anchor{
    Point2D p = null;

    public Point2D getPoint() {
        return p;
    }

    public void setPoint(Point2D p) {
        this.p = p;
    }
}
