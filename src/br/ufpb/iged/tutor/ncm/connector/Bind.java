
package br.ufpb.iged.tutor.ncm.connector;

<<<<<<< HEAD
import br.ufpb.iged.tutor.ncm.entity.Interface;
import br.ufpb.iged.tutor.ncm.entity.Node;

=======
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
/**
 *
 * @author GILBERTO FARIAS
 */
public class Bind {
    private String role = null;
<<<<<<< HEAD
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
=======
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
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
        this.inter = inter;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}
