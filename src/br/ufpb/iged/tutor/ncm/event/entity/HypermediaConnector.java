package br.ufpb.iged.tutor.ncm.event.entity;

import br.ufpb.iged.tutor.ncm.event.entity.connector.Glue;
import br.ufpb.iged.tutor.ncm.event.entity.connector.Role;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GILBERTO FARIAS
 */
public class HypermediaConnector {
    private Map<String, Role> roles;
    private Glue glue;
    
    HypermediaConnector(){
        this.roles = new HashMap<String, Role>();
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

    public Glue getGlue() {
        return glue;
    }

    public void setGlue(Glue glue) {
        this.glue = glue;
    }
    
}
