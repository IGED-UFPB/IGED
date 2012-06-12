package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.connector.ActionRole;
import br.ufpb.iged.tutor.ncm.connector.ConditionRole;
import br.ufpb.iged.tutor.ncm.connector.Glue;
import br.ufpb.iged.tutor.ncm.connector.Role;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author GILBERTO FARIAS
 */
public class HypermediaConnector {
    private String id;
    private Map<String, Role> roles;
    private Glue glue;
    
    HypermediaConnector(){
        this.roles = new HashMap<String, Role>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void add(Role r){
        this.roles.put(r.getId(), r);
    }
    
    public void remove(Role r){
        this.roles.remove(r);
    }

    public Collection<Role> getRoles() {
        return roles.values();
    }
    
    public Role getRole(String role) {
        return roles.get(role);
    }

    public Glue getGlue() {
        return glue;
    }

    public void setGlue(Glue glue) {
        this.glue = glue;
    }

    ConditionRole getConditionRole(String role) {
        Role r = this.getRole(role);
        if((r != null) && (r instanceof ConditionRole))
            return (ConditionRole)r;
        else
            return null;
    }
    
    ActionRole getActionRole(String role) {
        Role r = this.getRole(role);
        if((r != null) && (r instanceof ActionRole))
            return (ActionRole)r;
        else
            return null;
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("causalConnector");       
        element.setAttribute("id", getId());
    
        return element;
    
    }
    
    public HypermediaConnector toReadXML(Element element){
    
        this.setId(element.getAttribute("id"));
        
        return this;
    
    }
    
    
}
