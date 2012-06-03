/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.entity;

import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ImageNode extends ContentNode{

    @Override
    public void run() {
        try {
            System.out.println("Digite");
            System.in.read();
        } catch (IOException ex) {
            
        }
        System.out.println("Selects Anchor.");
        ((ContentAnchor)(this.getAnchor("aAtividade1"))).selects();
        //throw new UnsupportedOperationException("Not supported yet.");
        try {
            while(true){
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            System.out.println("Fim Image");
        }
    }
    
    @Override
    public void pause(){
        //Pausar a exibição do Image
        super.pause();
    }
    
    @Override
    public void resume(){
        //Retomar a exibição do Image
        super.resume();
    }
    
    @Override
    public void finish(){
        //Finalizar a exibição do Image
        super.finish();
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("media");       
        element.setAttribute("id", getId());
        element.setAttribute("src", getSource());
        element.setAttribute("type", getType());
    
        return element;
    
    }
}
