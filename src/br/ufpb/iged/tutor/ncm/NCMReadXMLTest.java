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
                
        
        Map<String, HypermediaConnector> connectors = new HashMap<String, HypermediaConnector>();
        HypermediaConnector hc = null;
        ConditionRole cr = null;       
        EventStateTransitionCondition c = null;
        
        NodeList document = raiz.getChildNodes();
        
        //CABECALHO
        for(int i = 0; i < document.getLength();i++){          
            
            hc = new CausalConnector();
            
            //DADOS CAUSAL CONNECTOR          
            if(document.item(i).getNodeName().equals("causalConnector")){
                               
                hc.toReadXML(document.item(i).getAttributes());
                
                NodeList causalConnectorNodes = document.item(i).getChildNodes();               
                
                for(int j = 0; j < causalConnectorNodes.getLength(); j++){
                    //CONDITION ROLE
                    System.out.println(causalConnectorNodes.item(i).getNodeName());
                    
                    if (causalConnectorNodes.item(i).getNodeName().equals("conditionRole")) {
                        
                        NodeList nodesConnectors = causalConnectorNodes.item(i).getChildNodes();
                    //system.out.println(causalConnectorNodes.item(i).getChildNodes());
                        cr = new ConditionRole();
                        cr.toReadXML(causalConnectorNodes.item(i).getAttributes());
                        c = new EventStateTransitionCondition();
                        if(nodesConnectors.item(i).equals("eventStateTransitionCondition"))
                            c.toReadXML(nodesConnectors.item(i).getAttributes());
                        cr.setCondition(c);
                        hc.add(cr);   
                        
                    }
                    
                    //ACTION ROLE
                    if (causalConnectorNodes.item(i).getNodeName().equals("actionRole")) {
                        ActionRole ar = new ActionRole();                        
                        ar.toReadXML(causalConnectorNodes.item(i).getAttributes());                        
                        Action a = new Action();
                        if(causalConnectorNodes.item(i).getChildNodes().equals("presentationAction"))
                            a.toReadXML(causalConnectorNodes.item(i).getChildNodes().item(i).getAttributes());                        
                        ar.setAction(a);
                        hc.add(ar);
                    }
                    //CAUSAL GLUE
                    if (causalConnectorNodes.item(i).getNodeName().equals("causalGlue")) {
                        NodeList nodesCausalGlue = causalConnectorNodes.item(i).getChildNodes();
                        CausalGlue g = new CausalGlue();
                        
                        SimpleTriggerExpression ste = new SimpleTriggerExpression();
                        if(nodesCausalGlue.equals("simpleTriggerExpression")){
                            ste.toReadXML(nodesCausalGlue.item(i).getAttributes());
                        }
                        g.setTrigger(ste);
                        SimpleActionExpression sae = new SimpleActionExpression();
                        
                        if(nodesCausalGlue.equals("simpleActionExpression")){
                            sae.toReadXML(nodesCausalGlue.item(i).getAttributes());
                        }
                        
                        g.setAction(sae);

                        hc.setGlue(g);
                        
                    }
                    
                    connectors.put(hc.getId(), hc);             
                }               
                
            }             
                               
        }

        System.out.println("connectos  >  "+connectors.size());
        System.out.println("//BODY\\");

        //--- BODY ---
        
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
                p.toReadXML(nl.item(i).getAttributes());
                
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
                System.out.println(teste.item(i).getAttributes().getNamedItem("id").getNodeName());    
                        
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