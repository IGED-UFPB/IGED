
package br.ufpb.iged.tutor.ncm.entity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author GILBERTO FARIAS
 */
public class CausalConnector extends HypermediaConnector{

    public Element toXML(Document doc){
    
        Element element = doc.createElement("causalConnector");       
        element.setAttribute("id", getId());
    
        return element;
    
    }
    
}
