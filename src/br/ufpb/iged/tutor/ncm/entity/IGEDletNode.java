
package br.ufpb.iged.tutor.ncm.entity;

import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author GILBERTO FARIAS
 */
public class IGEDletNode extends ContentNode{
    @Override
    public void run() {
        System.out.println("Iniciado IGEDlet: " + this.getId());
        
        try {
            System.out.println("Digite IGED");
            System.in.read();
        } catch (IOException ex) {
        }
        final IGEDletNode iged = this;
        new Thread(){
            public void run(){
                iged.finish();
            }
        }.start();
        
        try {
            while(true){
                Thread.sleep(1000);
            }
        } catch (Exception ex) {
            System.out.println("Fim IGElet");
            //ex.printStackTrace();
        }
        
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("media");       
        element.setAttribute("id", getId());
        element.setAttribute("src", getSource());
        element.setAttribute("type", getType());
        
        return element;
    
    }
}
