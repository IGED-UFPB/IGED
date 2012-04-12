
package br.ufpb.iged.tutor.ncm.event.entity.connector;

import br.ufpb.iged.tutor.ncm.event.entity.Interface;
import br.ufpb.iged.tutor.ncm.event.entity.Node;

/**
 *
 * @author GILBERTO FARIAS
 */
public class Bind {
    private String role = null;
    private Node component = null;
    private Interface inter = null;

    public Node getComponent() {
        return component;
    }

    void setComponent(Node component) {
        this.component = component;
    }
    
    public Interface getInter() {
        return inter;
    }

    public void setInter(Interface inter) {
        this.inter = inter;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
