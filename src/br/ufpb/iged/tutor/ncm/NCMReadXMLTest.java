package br.ufpb.iged.tutor.ncm;

import br.ufpb.iged.tutor.ncm.connector.*;
import br.ufpb.iged.tutor.ncm.entity.*;
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

        String pathXml = "connectors.xml";

        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(pathXml);

        
        Element raiz = doc.getDocumentElement();
        
        System.out.println("O elemento raiz é: " + raiz.getNodeName());


        Map<String, HypermediaConnector> connectors = new HashMap<String, HypermediaConnector>();
        HypermediaConnector hc = null;
        ConditionRole cr = null;

        NodeList document = raiz.getChildNodes();

        //CABECALHO        
        for (int i = 0; i < document.getLength(); i++) {            
            
            //DADOS CAUSAL CONNECTOR                      
            if (document.item(i).getNodeName().equals("causalConnector")) {
                
                hc = new CausalConnector();

                hc.toReadXML(document.item(i).getAttributes());                

                NodeList causalConnectorNodes = document.item(i).getChildNodes();                
                
                for (int j = 0; j < causalConnectorNodes.getLength(); j++) {
                    
                    //CONDITION ROLE
                    if(causalConnectorNodes.item(j).getNodeName().equals("conditionRole")){
                        
                        cr = new ConditionRole();
                        cr.toReadXML(causalConnectorNodes.item(j).getAttributes());
                        
                        System.out.println(cr.toString());
                        
                        EventStateTransitionCondition c = new EventStateTransitionCondition();
                        c.toReadXML(causalConnectorNodes.item(j).getChildNodes().item(j).getAttributes());
                        
                        System.out.println(c.toString());
                        cr.setCondition(c);
                        hc.add(cr);          
                        
                    }                    
                    
                     //ACTION ROLE
                    if (causalConnectorNodes.item(j).getNodeName().equals("actionRole")) {
                        
                        ActionRole ar = new ActionRole();
                        ar.toReadXML(causalConnectorNodes.item(j).getAttributes());                             
                        
                        NodeList actionRoles = causalConnectorNodes.item(j).getChildNodes();
                        
                        for(int k = 0; k < actionRoles.getLength();k++){                            
                            
                            if(actionRoles.item(k).getNodeName().equals("presentationAction")){
                                Action a = new Action();                            
                                a.toReadXML(actionRoles.item(k).getAttributes());
                                ar.setAction(a);                                                    
                            }
                        }                                                               
                        
                        hc.add(ar);
                        
                    }                 
                    
                    //CAUSAL GLUE
                    if (causalConnectorNodes.item(j).getNodeName().equals("causalGlue")) {
                     
                        NodeList nodesCausalGlue = causalConnectorNodes.item(j).getChildNodes();
                        
                        CausalGlue g = new CausalGlue();

                        SimpleTriggerExpression ste = null;
                        SimpleActionExpression sae = null;
                        
                        for(int k = 0; k < nodesCausalGlue.getLength();k++){
                            
                            ste = new SimpleTriggerExpression();

                            if (nodesCausalGlue.item(k).getNodeName().equals("simpleTriggerExpression")) {
                                ste.toReadXML(nodesCausalGlue.item(k).getAttributes());
                                g.setTrigger(ste);

                                System.out.println(ste.toString());
                            }

                            
                            sae = new SimpleActionExpression();

                            if (nodesCausalGlue.item(k).getNodeName().equals("simpleActionExpression")) {
                                sae.toReadXML(nodesCausalGlue.item(k).getAttributes());
                                g.setAction(sae);
                                System.out.println(sae.toString());
                            }
                        
                            
                            
                        }
                        
        

                        hc.setGlue(g);
                        
                    }
                    
                    
                }
                
                connectors.put(hc.getId(), hc);
                System.out.println(hc.getGlue().toString());
            }
        }
       
        
        
        System.out.println(connectors.get("onSelection1Start1"));
        System.out.println(connectors.get("onStop1Resume1"));
        
        System.out.println("CABECALHO - FINALIZADO");
        System.out.println("");
        
        
        System.out.println("//--BODY--\\");
        //--- BODY ---
        
        pathXml = "vetor.xml";

        
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        doc = db.parse(pathXml);
        
        raiz = doc.getDocumentElement();
        
        Stack<ContextNode> stackContext = new Stack<ContextNode>();
        ContextNode main = new ContextNode();
        ContextNode cn = null;
        main.setId("main");
        
        NodeList body = raiz.getChildNodes();
        
        Port port = null;
        
        for(int i = 0; i < body.getLength();i++){
        
            if(body.item(i).getNodeName().equals("port")){
                port = new Port();
                port.toReadXML(body.item(i).getAttributes());
                main.add(port);
            }
            
            if(body.item(i).getNodeName().equals("context")){
                
                cn = new ContextNode();
                cn.toReadXML(body.item(i).getAttributes());
                
                NodeList contexts = body.item(i).getChildNodes();
                for(int j = 0; j < contexts.getLength();j++){
                    
                    if(contexts.item(j).getNodeName().equals("port")){
                        port = new Port();
                        port.toReadXML(contexts.item(j).getAttributes());
                        cn.add(port);
                    }
                    
                    
                    if(contexts.item(j).getNodeName().equals("trail")){
                        
                        Trail t = new Trail();                        
                        t.toReadXML(contexts.item(j).getAttributes());
                        
                        NodeList trails = contexts.item(j).getChildNodes();
                        
                        for(int k = 0; k < trails.getLength();k++){
                            
                            if(trails.item(k).getNodeName().equals("port")){
                                
                                port = new Port();
                                port.toReadXML(trails.item(k).getAttributes());
                                t.add(port);
                                
                            }
                            
                            if(trails.item(k).getNodeName().equals("media")){
                                
                                ImageNode in = new ImageNode();
                                in.toReadXML(trails.item(k).getAttributes());
                                
                                NodeList listaNodesArea = trails.item(k).getChildNodes();
                                
                                for(int l = 0; l < listaNodesArea.getLength();l++){
                                    
                                    if(listaNodesArea.item(l).getNodeName().equals("area")){
                                        
                                        ContentAnchor a = new ContentAnchor();
                                        a.toReadXML(listaNodesArea.item(l).getAttributes());
                                        in.add(a);                                                                          
                                    }
                                
                                }
                                
                                t.add(in);
                                
                            }
                            
                        }           
                        
                       cn.add(t);
                    }
                    
                    
                    if(contexts.item(j).getNodeName().equals("media")){
                        
                        IGEDletNode ig = new IGEDletNode();
                        ig.toReadXML(contexts.item(j).getAttributes());
                        cn.add(ig);

                    }
                    
                    
                    if(contexts.item(j).getNodeName().equals("link")){                        
                        System.out.println("XCONNECTOR "+connectors.get(contexts.item(j).getAttributes().getNamedItem("xconnector").getNodeValue()));
                        Link l = new CausalLink(connectors.get(contexts.item(j).getAttributes().getNamedItem("xconnector").getNodeValue()));
                        l.toReadXML(contexts.item(j).getAttributes());
                        
                        NodeList listaBinds = contexts.item(j).getChildNodes();
                        for(int k = 0; k < listaBinds.getLength();k++){
                            
                            if(listaBinds.item(k).getNodeName().equals("bind")){
                                Bind b = new Bind();
                                b.toReadXML(listaBinds.item(k).getAttributes());
                                l.add(b);
                            }
                            
                        }
                            
                        cn.add(l);
                    }                   
                    
                }
                
            }       
        }    
        
        
            System.out.println(cn.getLinks().size());
            System.out.println(cn.getAnchors().toString());
            System.out.println(cn.getId());
            System.out.println(cn.getPorts().size());
            System.out.println(cn.getNodes().size());
            main.add(cn);            
            stackContext.push(main); 
            
            ContextNode cns = stackContext.peek();
            cns.execute("pInicio");
    }
    
    
    public static void readConnectors(){}
    public static void readBody(){}
    
}