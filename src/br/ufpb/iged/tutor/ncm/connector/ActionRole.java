
package br.ufpb.iged.tutor.ncm.connector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ActionRole extends Role{
    private Action action = null;

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("actionRole");       
        element.setAttribute("id", getId());
        element.setAttribute("eventType", getEventType());
    
        return element;
    
    }
    
    public ActionRole toReadXML(NamedNodeMap nameNode){
    
        this.setId(nameNode.getNamedItem("id").getNodeValue());
        this.setEventType(nameNode.getNamedItem("eventType").getNodeValue());
        
        return this;
    
    }
}
