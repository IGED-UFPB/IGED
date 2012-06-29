/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.players.ApressPlayer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ImageNode extends ContentNode{
    ApressPlayer player = null;
    
    @Override
    public void run() {
            this.player = ApressPlayer.getInstance();            
            this.player.play(this);
    }
    
    
    @Override
    public void execute(){
        this.player = ApressPlayer.getInstance();            
        this.player.play(this);
        System.out.println("Init PresentationMachine: " + this.getId());
        this.presetationMachine.transitionStarts();
    }
    
    /*@Override
    public void pause(){
        //Pausar a exibição do Image
        super.pause();
    }*/
    
    @Override
    public void resume(){
        //if(!player.isRunning())
        this.player.play(this);
        super.resume();
    }
    
    @Override
    public void finish(){
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
}
