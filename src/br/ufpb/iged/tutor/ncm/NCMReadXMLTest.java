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

            NodeList conditionRole = causalConnector.getElementsByTagName("conditionRole");

            Element conditionRoleElemento = (Element) conditionRole.item(0);
            
            System.out.println(conditionRoleElemento.getAttribute("id"));
            System.out.println(conditionRoleElemento.getAttribute("eventType"));


            NodeList actionRole = causalConnector.getElementsByTagName("actionRole");

            NodeList causalRole = causalConnector.getElementsByTagName("causalRole");








        }
    }
}
