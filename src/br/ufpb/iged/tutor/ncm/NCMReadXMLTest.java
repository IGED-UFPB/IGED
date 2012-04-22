package br.ufpb.iged.tutor.ncm;

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


        //fazer o parse do arquivo e criar o documento XML
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse("vetor.xml");

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
    }
}
