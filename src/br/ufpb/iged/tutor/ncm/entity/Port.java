/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author GILBERTO FARIAS
 */
public class Port extends Interface{
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
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("port");       
        element.setAttribute("id", getId());    
        element.setAttribute("component", getComponent());
        element.setAttribute("ip", getIp());

        return element;
    
    }
}
