/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.event.EventStateMachine;
import br.ufpb.iged.tutor.ncm.event.SelectionEvent;
import java.awt.geom.Point2D;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ContentAnchor extends Anchor{
    Point2D p = null;
    EventStateMachine selectionMachine = null;

    public ContentAnchor(){
        SelectionEvent se = new SelectionEvent();
        se.setSource(this);
        this.selectionMachine = new EventStateMachine(se);
    }
    
    void selects(){
        System.out.println("SelectionMachine starts");
        this.selectionMachine.transitionStarts();
    }
    
    void setContent(ContentNode cn){
        this.content = cn;
    }
    
    public Point2D getPoint() {
        return p;
    }

    public void setPoint(Point2D p) {
        this.p = p;
    }
}
