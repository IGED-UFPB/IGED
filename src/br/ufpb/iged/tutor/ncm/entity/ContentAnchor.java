/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.gui.event.AnchorIconEvent;
import br.ufpb.iged.gui.event.TelaPlayerEvent;
import br.ufpb.iged.gui.event.TelaPlayerListener;
import br.ufpb.iged.tutor.ncm.event.EventStateMachine;
import br.ufpb.iged.tutor.ncm.event.SelectionEvent;
import java.awt.geom.Point2D;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ContentAnchor extends Anchor implements TelaPlayerListener{
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
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("area");       
        element.setAttribute("id", getId());
        element.setAttribute("x", String.valueOf(getPoint().getX()));
        element.setAttribute("y", String.valueOf(getPoint().getY()));
    
        return element;
    
    }
    
    public ContentAnchor toReadXML(NamedNodeMap namedNode){
        
        p = new Point2D.Double(Double.parseDouble(namedNode.getNamedItem("x").getNodeValue()), Double.parseDouble(namedNode.getNamedItem("y").getNodeValue()));
        this.setId(namedNode.getNamedItem("id").getNodeValue());
        this.setPoint(p);      
        
        return this;
    
    }

    @Override
    public void receiveEvent(TelaPlayerEvent ev) {
        if(ev instanceof AnchorIconEvent){
            if(ev.getAction() == AnchorIconEvent.SELECT_ANCHOR)
                this.selects();
        }
    }
}
