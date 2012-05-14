/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.entity;

/**
 *
 * @author GILBERTO FARIAS
 */
public class Port extends Interface{
<<<<<<< HEAD
    private Node node;
    private Interface ip;

    public Interface getIp() {
        return ip;
    }

    public void setIp(Interface ip) {
        this.ip = ip;
    }
    

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
=======
    private String component;
    private String ip;

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

   
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
}
