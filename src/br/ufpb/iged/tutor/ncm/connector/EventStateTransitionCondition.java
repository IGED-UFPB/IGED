
package br.ufpb.iged.tutor.ncm.connector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public class EventStateTransitionCondition extends SimpleCondition{
    private String transitionName = null;

    public String getTransitionName() {
        return transitionName;
    }

    public void setTransitionName(String transitionName) {
        this.transitionName = transitionName;
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("eventStateTransitionCondition");       
        element.setAttribute("transition", getTransitionName());
    
        return element;
    
    }
    
    public EventStateTransitionCondition toReadXML(NamedNodeMap nameNode){
    
        this.setTransitionName(nameNode.getNamedItem("transition").getNodeValue());
        
        return this;
    
    }

    @Override
    public String toString() {
        return "EventStateTransitionCondition{" + "transitionName=" + transitionName + '}';
    }
    
    
    
}
