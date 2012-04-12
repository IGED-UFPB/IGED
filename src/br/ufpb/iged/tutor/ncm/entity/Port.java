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
}
