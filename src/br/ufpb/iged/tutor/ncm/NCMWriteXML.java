package br.ufpb.iged.tutor.ncm;

import br.ufpb.iged.tutor.ncm.entity.CausalConnector;
import br.ufpb.iged.tutor.ncm.entity.HypermediaConnector;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * pensar em um método genérico
 * @author darkolyver
 */
public class NCMWriteXML {
    
    public static void main(String args[]) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, FileNotFoundException {

        
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.newDocument();
    
        Element root = doc.createElement("document");                       
        doc.appendChild(root);
        
        CausalConnector c = new CausalConnector();
        c.setId("test");
        
        Element item3 = doc.createElement("causalConnector");       
        Element item1 = c.toXML(doc);
        
        root.appendChild(item1);
        item1.appendChild(item3);
        
        Element item2 = doc.createElement("causalConnector");
        item2.setAttribute("id", "carai");
        root.appendChild(item2);
        
        StreamResult result = new StreamResult(new FileOutputStream("zell.xml"));                      
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.STANDALONE, "yes");
        trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.transform(new DOMSource(doc), result);
       


    }
}