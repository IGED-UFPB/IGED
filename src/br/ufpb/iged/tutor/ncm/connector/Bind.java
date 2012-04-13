
package br.ufpb.iged.tutor.ncm.connector;

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
    
}
