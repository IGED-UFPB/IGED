package br.ufpb.iged.tutor.ncm;

import br.ufpb.iged.tutor.ncm.connector.*;
import br.ufpb.iged.tutor.ncm.entity.CausalConnector;
import br.ufpb.iged.tutor.ncm.entity.ContextNode;
import br.ufpb.iged.tutor.ncm.entity.HypermediaConnector;
import br.ufpb.iged.tutor.ncm.entity.Port;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

        NodeList listaCausalConnector = raiz.getElementsByTagName("causalConnector");

        Map<String, HypermediaConnector> connectors = new HashMap<String, HypermediaConnector>();
        HypermediaConnector hc = new CausalConnector();
        ConditionRole cr = new ConditionRole();




        for (int i = 0; i < listaCausalConnector.getLength(); i++) {

            //como cada elemento do NodeList é um nó, precisamos fazer o cast
            Element causalConnector = (Element) listaCausalConnector.item(i);
            //Passo 4: obter o atributo id do contato

            NCMFormatter.createCausalConnector(causalConnector);

            //DADOS CONDITION ROLE
            NodeList conditionRole = causalConnector.getElementsByTagName("conditionRole");
            Element conditionRoleElement = (Element) conditionRole.item(0);


            hc.toReadXML(causalConnector);

            cr.toReadXML(conditionRoleElement);

            Element eventState = (Element) conditionRoleElement.getElementsByTagName("eventStateTransitionCondition").item(0);


            EventStateTransitionCondition c = new EventStateTransitionCondition();
            c.toReadXML(eventState);
            cr.setCondition(c);
            hc.add(cr);


            //DADOS ACTION ROLE
            NodeList actionRole = causalConnector.getElementsByTagName("actionRole");

            Element actionRoleElement = (Element) actionRole.item(0);
            Element presentationAction = (Element) actionRoleElement.getElementsByTagName("presentationAction").item(0);

            ActionRole ar = new ActionRole();
            ar.toReadXML(actionRoleElement);
            Action a = new Action();
            a.toReadXML(presentationAction);
            ar.setAction(a);
            hc.add(ar);



            //DADOS CAUSAL ROLE
            NodeList causalGlue = causalConnector.getElementsByTagName("causalGlue");
            Element causalGlueElement = (Element) causalGlue.item(0);
            Element simpleTriggerExpression = (Element) causalGlueElement.getElementsByTagName("simpleTriggerExpression").item(0);
            Element simpleActionExpression = (Element) causalGlueElement.getElementsByTagName("simpleActionExpression").item(0);

            CausalGlue g = new CausalGlue();
            SimpleTriggerExpression ste = new SimpleTriggerExpression();
            ste.toReadXML(simpleTriggerExpression);
            g.setTrigger(ste);

            SimpleActionExpression sae = new SimpleActionExpression();
            sae.toReadXML(simpleActionExpression);
            g.setAction(sae);

            hc.setGlue(g);
            connectors.put(hc.getId(), hc);

        }

        Stack<ContextNode> stackContext = new Stack<ContextNode>();
        //ContextNode cn = stackContext.peek();
        //cn.execute("pInicio");
        ContextNode main = new ContextNode();

        //BODY
        NodeList listaBody = raiz.getElementsByTagName("body");
        Element bodyElement = (Element) listaBody.item(0);


        System.out.println("SIZE: " + bodyElement.getChildNodes().getLength());

        Port p = new Port();

        //LEITURA DOS FILHOS DO BODY
        NodeList nl = bodyElement.getChildNodes();
        for (int i = 0; i < nl.getLength(); ++i) {
            
            if (!nl.item(i).getNodeName().equals("#text")) {
                System.out.println("Body: "+ i + nl.item(i).getNodeName());
            }
            
            if (nl.item(i).getNodeName().equals("port")) {
                //PORT IN BODY                
                System.out.println("passou ak"+i);                
                Element portElement = (Element) bodyElement.getElementsByTagName("port").item(0);
                p.toReadXML(portElement);
                
            }
        }

        System.out.println(p.getComponent() + p.getId() + p.getIp());


        //CONTEXT IN BODY        
        NodeList listCotext = bodyElement.getElementsByTagName("context");       
        
        Element contextElement = (Element) listCotext.item(0);

        NodeList teste = contextElement.getChildNodes();

        System.out.println(teste.getLength());
        
        for (int i = 0; i < teste.getLength(); i++) {          
            
            
            if (teste.item(i).getNodeName().equals("port")) {
                System.out.println("Context port > " + teste.item(i).getNodeName());
                System.out.println(teste.item(i).getAttributes().getNamedItem("id"));    
                        
            }
            
            if (teste.item(i).getNodeName().equals("trail")) {
                System.out.println("Context trail > " + teste.item(i).getNodeName());
            }        
            
            if (teste.item(i).getNodeName().equals("link")) {
                System.out.println("Context link > " + teste.item(i).getNodeName());
            }

        }

        NodeList listTrail = contextElement.getElementsByTagName("trail");
        Element trailElement = (Element) listTrail.item(0);

        NodeList listaTrail = trailElement.getChildNodes();

        for (int i = 0; i < listaTrail.getLength(); i++) {

            if (!listaTrail.item(i).getNodeName().equals("#text")) {
                System.out.println("Trail > " + listaTrail.item(i).getNodeName());
            }

        }




    }
}