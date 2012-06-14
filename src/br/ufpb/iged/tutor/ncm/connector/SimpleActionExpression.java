
package br.ufpb.iged.tutor.ncm.connector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public class SimpleActionExpression extends ActionExpression{
    private String actionRole = null;

    public String getActionRole() {
        return actionRole;
    }

    public void setActionRole(String actionRole) {
        this.actionRole = actionRole;
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("simpleActionExpression");       
        element.setAttribute("actionRole", getActionRole());
    
        return element;
    
    }
    
    public SimpleActionExpression toReadXML(NamedNodeMap nameNode){
    
        this.setActionRole(nameNode.getNamedItem("actionRole").getNodeValue());
        
        return this;
    
    }
    
}
