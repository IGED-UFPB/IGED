/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.connector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public class SimpleTriggerExpression extends TriggerExpression{
    private String conditionRole;
    private String roleQualifier;

    public String getConditionRole() {
        return conditionRole;
    }

    public void setConditionRole(String conditionRole) {
        this.conditionRole = conditionRole;
    }

    public String getRoleQualifier() {
        return roleQualifier;
    }

    public void setRoleQualifier(String roleQualifier) {
        this.roleQualifier = roleQualifier;
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("simpleTriggerExpression");       
        element.setAttribute("conditionRole", getConditionRole());
    
        return element;
    
    }
    
    public SimpleTriggerExpression toReadXML(NamedNodeMap nameNode){
    
        this.setConditionRole(nameNode.getNamedItem("conditionRole").getNodeValue());
        
        return this;
    
    }

    @Override
    public String toString() {
        return "SimpleTriggerExpression{" + "conditionRole=" + conditionRole + ", roleQualifier=" + roleQualifier + '}';
    }
    
    
    
}
