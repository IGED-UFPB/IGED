
package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.players.IGEDletPlayer;
import br.ufpb.iged.tutor.players.event.ActionUserEvent;
import br.ufpb.iged.tutor.players.event.PlayerEvent;
import br.ufpb.iged.tutor.players.event.PlayerListener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public class IGEDletNode extends ContentNode implements PlayerListener{
    IGEDletPlayer player = null;
    
    @Override
    public void run() {
        this.player = IGEDletPlayer.getInstance();
        
        if(!this.player.isRunning()){
            this.player.init();
            this.player.execute();
        }
        this.player.addListener(this);
        this.player.play(this);
        
    }
    
    @Override
    public void pause(){
        //Pausar a exibição do IGEDlet
        super.pause();
    }
    
    @Override
    public void resume(){
        //Retomar a exibição do IGEDlet
        super.resume();
    }
    
    @Override
    public void finish(){
        super.finish();
        this.player.finish();
        this.player.removeListener(this);
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("media");       
        element.setAttribute("id", getId());
        element.setAttribute("src", getSource());
        element.setAttribute("type", getType());
        
        return element;
    
    }
    
    public IGEDletNode toReadXML(NamedNodeMap namedNode){
        
        this.setId(namedNode.getNamedItem("id").getNodeValue());        
        this.setSource(namedNode.getNamedItem("src").getNodeValue());
        this.setType(namedNode.getNamedItem("type").getNodeValue());        
        
        return this;
    
    }
    
    public static void main(String argv[]){
        IGEDletPlayer ip = IGEDletPlayer.getInstance();
        ip.init();
        ip.execute();
        
        IGEDletNode img = new IGEDletNode();
        img.setSource("0");
        ip.play(img);
    }

    @Override
    public void receiveEvent(PlayerEvent e) {
        if(e instanceof ActionUserEvent){
            ActionUserEvent ae = (ActionUserEvent)e;
            if(ae.getAction() == ActionUserEvent.CLOSE_PLAYER)
                this.finish();
        }
    }
}
