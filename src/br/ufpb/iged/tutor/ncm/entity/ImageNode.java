/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.players.ApressPlayer;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import br.ufpb.iged.tutor.players.event.ActionUserEvent;
import br.ufpb.iged.tutor.players.event.PlayerEvent;
import br.ufpb.iged.tutor.players.event.PlayerListener;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ImageNode extends ContentNode implements PlayerListener{

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
    
    public ImageNode toReadXML(NamedNodeMap namedNode){
    
        this.setId(namedNode.getNamedItem("id").getNodeValue());
        this.setSource(namedNode.getNamedItem("src").getNodeValue());
        this.setType(namedNode.getNamedItem("type").getNodeValue());
        
        return this;
    
    }
    @Override
    public void receiveEvent(PlayerEvent e) {
        if(e instanceof ActionUserEvent){
            ActionUserEvent aue = (ActionUserEvent)e;
            switch(aue.getAction()){    
                case ActionUserEvent.SELECT_ANCHOR: 
                    if(aue.getSource() instanceof ApressPlayer){
                        ApressPlayer ap = (ApressPlayer) aue.getSource(); 
                        ((ContentAnchor)this.anchors.get(ap.getSelectAnchor())).selects();
                    }
                    break;
            }
        }
    }
}
