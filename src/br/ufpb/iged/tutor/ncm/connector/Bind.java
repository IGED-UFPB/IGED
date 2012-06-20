
package br.ufpb.iged.tutor.ncm.connector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public class Bind {
    private String role = null;
    private String component = null;
    private String inter = null;

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getInterface() {
        return inter;
    }

    public void setInterface(String inter) {
        this.inter = inter;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("bind");       
        element.setAttribute("component", getComponent());
        element.setAttribute("role", getRole());
        element.setAttribute("interface", getInterface());
    
        return element;
    
    }
    
    public Bind toReadXML(NamedNodeMap namedNode){
        
       this.setComponent(namedNode.getNamedItem("component").getNodeValue());  
       this.setInterface(namedNode.getNamedItem("role").getNodeValue());  
       if(namedNode.getNamedItem("interface") != null)
        this.setRole(namedNode.getNamedItem("interface").getNodeValue());  
       
       return this;
    
    }
}
