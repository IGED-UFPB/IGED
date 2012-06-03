
package br.ufpb.iged.tutor.ncm.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author GILBERTO FARIAS
 */
public class CausalLink extends Link{
    public CausalLink(HypermediaConnector conn){
        super(conn);
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("causalLink");       
        element.setAttribute("id", getId());
    
        return element;
    
    }
}
