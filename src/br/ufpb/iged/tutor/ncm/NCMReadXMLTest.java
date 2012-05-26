package br.ufpb.iged.tutor.ncm;

import br.ufpb.iged.tutor.ncm.entity.ContentNode;
import br.ufpb.iged.tutor.ncm.entity.ImageNode;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author renanaoliveira
 */
public class NCMReadXMLTest {

    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {

        String pathXml = "vetor.xml";

        //fazer o parse do arquivo e criar o documento XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(pathXml);

        //Passo 1: obter o elemento raiz
        Element raiz = doc.getDocumentElement();
        System.out.println("O elemento raiz é: " + raiz.getNodeName());

        //Passo 2: localizar os elementos filhos da agenda
        NodeList listaCausalConnector = raiz.getElementsByTagName("causalConnector");


        for (int i = 0; i < listaCausalConnector.getLength(); i++) {

            //como cada elemento do NodeList é um nó, precisamos fazer o cast
            Element causalConnector = (Element) listaCausalConnector.item(i);
            //Passo 4: obter o atributo id do contato
            Attr id = causalConnector.getAttributeNode("id");

            System.out.println("CausalConnector id: " + id.getNodeValue());

            //DADOS CONDITION ROLE
            NodeList conditionRole = causalConnector.getElementsByTagName("conditionRole");

            Element conditionRoleElement = (Element) conditionRole.item(0);

            System.out.println(conditionRoleElement.getAttribute("id"));
            System.out.println(conditionRoleElement.getAttribute("eventType"));

            Element eventState = (Element) conditionRoleElement.getElementsByTagName("eventStateTransitionCondition").item(0);
            System.out.println(eventState.getAttribute("transition"));

            //DADOS ACTION ROLE
            NodeList actionRole = causalConnector.getElementsByTagName("actionRole");
            Element actionRoleElement = (Element) actionRole.item(0);
            Element presentationAction = (Element) actionRoleElement.getElementsByTagName("presentationAction").item(0);

            System.out.println(actionRoleElement.getAttribute("id"));
            System.out.println(actionRoleElement.getAttribute("eventType"));

            System.out.println(presentationAction.getAttribute("actionType"));

            //DADOS CAUSAL ROLE
            NodeList causalRole = causalConnector.getElementsByTagName("causalGlue");
            Element causalRoleElement = (Element) causalRole.item(0);

            Element simpleTriggerExpression = (Element) causalRoleElement.getElementsByTagName("simpleTriggerExpression").item(0);
            System.out.println(simpleTriggerExpression.getAttribute("conditionRole"));

            Element simpleActionExpression = (Element) causalRoleElement.getElementsByTagName("simpleActionExpression").item(0);
            System.out.println(simpleActionExpression.getAttribute("actionRole"));

        }

        //BODY
        NodeList listaBody = raiz.getElementsByTagName("body");

        Element bodyElement = (Element) listaBody.item(0);

        //PORT IN BODY
        System.out.println("SIZE: " + bodyElement.getChildNodes().getLength());
        NodeList nl = bodyElement.getChildNodes();
        for(int i=0; i<nl.getLength(); ++i)
            System.out.println("N: " + nl.item(i).getNodeName());
        Element portElement = (Element) bodyElement.getElementsByTagName("port").item(0);

        System.out.println(portElement.getAttribute("id"));
        System.out.println(portElement.getAttribute("component"));
        System.out.println(portElement.getAttribute("interface"));

        //CONTEXT IN BODY

        /*NodeList listCotext = bodyElement.getElementsByTagName("context");
        Element contextElement = (Element) listCotext.item(0);
        System.out.println(contextElement.getAttribute("id"));

        //PORT IN CONTEXT
        Element portElement2 = (Element) contextElement.getElementsByTagName("port").item(0);
        System.out.println(portElement2.getAttribute("id"));
        System.out.println(portElement2.getAttribute("component"));
        System.out.println(portElement2.getAttribute("interface"));

        //TRAIL IN CONTEXT
        NodeList listTrail = contextElement.getElementsByTagName("trail");
        Element trailElement = (Element) listTrail.item(0);
        System.out.println(trailElement.getAttribute("id"));


        //PORT IN TRAIL
        Element portElement3 = (Element) trailElement.getElementsByTagName("port").item(0);
        System.out.println(portElement3.getAttribute("id"));
        System.out.println(portElement3.getAttribute("component"));
        System.out.println(portElement3.getAttribute("interface"));

        //MEDIA IN TRAIL
        NodeList mediaElements = trailElement.getElementsByTagName("media");

        for (int i = 0; i < mediaElements.getLength(); i++) {

            Element mediaElement = (Element) mediaElements.item(i);

            System.out.println(mediaElement.getAttribute("type"));
            System.out.println(mediaElement.getAttribute("id"));
            System.out.println(mediaElement.getAttribute("src"));

            NodeList listArea = mediaElement.getElementsByTagName("area");

            if (listArea.getLength() > 1) {
                for (int j = 0; j < listArea.getLength(); j++) {
                    Element areaElement = (Element) listArea.item(i);
                    System.out.println(areaElement.getAttribute("id"));
                    System.out.println(areaElement.getAttribute("x"));
                    System.out.println(areaElement.getAttribute("y"));

                }

            }
            if (listArea.getLength() == 1) {

                Element areaElement = (Element) listArea.item(0);
                System.out.println(areaElement.getAttribute("id"));
                System.out.println(areaElement.getAttribute("x"));
                System.out.println(areaElement.getAttribute("y"));
            }
        }

        //MEDIA IN CONTEXT DISCUTIR COM O PROFESSOR

        NodeList listLink = contextElement.getElementsByTagName("link");

        for (int i = 0; i < listCotext.getLength(); i++) {

            Element linkElement = (Element) listCotext.item(i);
            System.out.println(linkElement.getAttribute("id"));
            System.out.println(linkElement.getAttribute("xconnector"));

            NodeList listBind = linkElement.getElementsByTagName("bind");
            for (int j = 0; j < listBind.getLength(); j++) {
                Element bindElement = (Element) listBind.item(j);
                System.out.println(bindElement.getAttribute("component"));
                System.out.println(bindElement.getAttribute("interface"));
                System.out.println(bindElement.getAttribute("role"));
            }
        }
    }
    public static ContentNode createMedia(Element media){
    
        if(media.getAttribute("type").equals("imagem")){
            ImageNode in = new ImageNode();
            in.setId(media.getAttribute("id"));
            in.setSource(media.getAttribute("src"));
            return in;
        }
        return null;*/
    }
    
    /*public static Port createPort(Element port){
        Port p = new Port();
        p.setId(port.getAttribute("id"));
        p.setComponent(port.getAttribute("id"));
        p.setIp(port.getAttribute("id"));
    }*/
}
/*
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();	
DocumentBuilder builder = factory.newDocumentBuilder(); 

Document doc = builder.newDocument();	
// Cria o elemento Root pessoa	
Element root = doc.createElement("pessoa");	
// Cria o elemento nome	
Element item = doc.createElement("nome");	
item.appendChild(doc.createTextNode("fulado de tal"));	
root.appendChild(item);	
item = doc.createElement("nascimento");	
item.appendChild(doc.createTextNode("22-07-1983"));	
root.appendChild(item); 
item = doc.createElement("idade");	
item.appendChild(doc.createTextNode("28"));	
root.appendChild(item);	
doc.appendChild(root);	
Transformer trans = 
TransformerFactory.newInstance().newTransformer();	
trans.setOutputProperty(OutputKeys.STANDALONE,"yes");	
trans.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");	
trans.setOutputProperty(OutputKeys.INDENT,"yes");	
trans.transform(new javax.xml.transform.dom.DOMSource(doc), 
new StreamResult(System.out)); 
 */
