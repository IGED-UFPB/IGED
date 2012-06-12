
package br.ufpb.iged.tutor.ncm.connector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author GILBERTO FARIAS
 */
public class Action {
    private String actionType = null;

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("presentationAction");       
        element.setAttribute("actionType", getActionType());
    
        return element;
    
    }
    
    public Action toReadXML(Element element){
    
        this.setActionType(element.getAttribute("actionType"));
        
        return this;
    
    }
    
}
