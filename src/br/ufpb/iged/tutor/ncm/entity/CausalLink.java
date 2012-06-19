
package br.ufpb.iged.tutor.ncm.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

/**
 *
 * @author GILBERTO FARIAS
 */
public class CausalLink extends Link{
    public CausalLink(HypermediaConnector conn){
        super(conn);
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("link");       
        element.setAttribute("id", getId());
        element.setAttribute("xconnector", super.getConnector().getId());
    
        return element;
    
    }    
  
    @Override
    public Link toReadXML(NamedNodeMap namedNode){
        
        setId(namedNode.getNamedItem("id").getNodeValue());  
        return this;
    }
}
