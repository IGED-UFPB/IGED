package br.ufpb.iged.tutor.ncm;

import java.util.List;

/**
 *
 * @author GILBERTO FARIAS
 */
public class HypermediaConnector {
    List<Role> roles;
    Glue glue;
    
    public void add(Role r){
        this.roles.add(r);
    }
    
    public void remove(Role r){
        this.roles.remove(r);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public Glue getGlue() {
        return glue;
    }

    public void setGlue(Glue glue) {
        this.glue = glue;
    }
    
}
