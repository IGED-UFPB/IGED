
package br.ufpb.iged.tutor.ncm.connector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

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
    
    public Action toReadXML(NamedNodeMap nameNode){
    
        this.setActionType(nameNode.getNamedItem("actionType").getNodeValue());
        
        return this;
    
    }
    
}
