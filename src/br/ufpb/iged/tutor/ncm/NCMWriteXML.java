package br.ufpb.iged.tutor.ncm;

import br.ufpb.iged.tutor.ncm.connector.*;
import br.ufpb.iged.tutor.ncm.entity.*;
import java.awt.geom.Point2D;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Renan Oliveira
 */
public class NCMWriteXML {
    
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document doc;
    private static Element root;
    private static Element body;
    private static Map<String, HypermediaConnector> connectors = null;



    private static void simulateConnector() {
        
        connectors = new HashMap<String, HypermediaConnector>();        
        HypermediaConnector hc = new CausalConnector();
        ConditionRole cr = new ConditionRole();

        hc.setId("onSelection1Start1");
        Element causalConnector = hc.toXML(doc);
        
        cr.setId("onSelection");
        cr.setEventType("selection");
        
        Element conditionRole = cr.toXML(doc);
        causalConnector.appendChild(conditionRole);
        
        EventStateTransitionCondition c = new EventStateTransitionCondition();
        c.setTransitionName("starts");
        
        conditionRole.appendChild(c.toXML(doc));        
      

        ActionRole ar = new ActionRole();
        ar.setId("start");
        ar.setEventType("presentation");
        Element actionRole = ar.toXML(doc);
        
        Action a = new Action();
        a.setActionType("start");
        Element action = a.toXML(doc);
        
        actionRole.appendChild(action);
        
        causalConnector.appendChild(actionRole);

        CausalGlue g = new CausalGlue();
        Element causalGlue = g.toXML(doc);
        
        SimpleTriggerExpression ste = new SimpleTriggerExpression();
        ste.setConditionRole("onSelection");
        Element steElement = ste.toXML(doc);
        
        causalGlue.appendChild(steElement);

        SimpleActionExpression sae = new SimpleActionExpression();
        sae.setActionRole("start");
        
        Element saeElement = sae.toXML(doc);
        causalGlue.appendChild(saeElement);

        causalConnector.appendChild(causalGlue);        
        root.appendChild(causalConnector);
        connectors.put(hc.getId(), hc);
        
        //Causal Connector II        

        hc = new CausalConnector();
        hc.setId("onStop1Resume1");
        
        causalConnector = hc.toXML(doc);

        cr = new ConditionRole();
        cr.setId("onStop");
        cr.setEventType("presentation");
        
        conditionRole = cr.toXML(doc);
        
        c = new EventStateTransitionCondition();
        c.setTransitionName("stops");
        
        Element eventState = c.toXML(doc);
        conditionRole.appendChild(eventState);
        
       causalConnector.appendChild(conditionRole);
        

        ar = new ActionRole();
        ar.setId("resume");
        ar.setEventType("presentation");
        actionRole = ar.toXML(doc);
        
        a = new Action();
        a.setActionType("resume");
        
        action = a.toXML(doc);      
        actionRole.appendChild(action);
        
        conditionRole.appendChild(actionRole);
        
        g = new CausalGlue();
        causalGlue = g.toXML(doc);
        
        ste = new SimpleTriggerExpression();
        ste.setConditionRole("onStop");        
        
        causalGlue.appendChild(ste.toXML(doc));

        sae = new SimpleActionExpression();
        sae.setActionRole("resume");
        
        causalGlue.appendChild(sae.toXML(doc));
        causalConnector.appendChild(causalGlue);
        
        root.appendChild(causalConnector);
        connectors.put(hc.getId(), hc);



    }

  
    private static void simulateNCL() {  
        
        //Porta inicial
        Port p = new Port();
        p.setId("pInicio");
        p.setComponent("ctxVetor");
        p.setIp("pInicio");
        
        Element port = p.toXML(doc);
        body.appendChild(port);
        

        //Contexto vetor
        ContextNode cn = new ContextNode();
        cn.setId("ctxVetor");
        Element contextNode = cn.toXML(doc);
        
        //Porta ctxVetor
        p = new Port();
        p.setId("pInicio");
        p.setComponent("vetor");
        p.setIp("pVetor");
        contextNode.appendChild(p.toXML(doc));

        //Trail
        Trail t = new Trail();
        t.setId("vetor");
        Element trail = t.toXML(doc);
        
        //Porta pVetor
        p = new Port();
        p.setId("pVetor");
        p.setComponent("slide2");
        
        trail.appendChild(p.toXML(doc));
        
        
        p = new Port();
        p.setId("pAtiv1");
        p.setComponent("slide2");
        p.setIp("aAtividade1");
        
        trail.appendChild(p.toXML(doc));

        p = new Port();
        p.setId("pAtiv2");
        p.setComponent("slide2");
        p.setIp("aAtividade2");
        
        trail.appendChild(p.toXML(doc));

        p = new Port();
        p.setId("pAnim1");
        p.setComponent("slide4");
        p.setIp("aAnimacao1");
        
        trail.appendChild(p.toXML(doc));

        //Medias
        ImageNode in = new ImageNode();
        in.setId("slide1");
        in.setSource("vetor/press/slide1.jpg");
        
        trail.appendChild(in.toXML(doc));

        in = new ImageNode();
        in.setId("slide2");
        in.setSource("vetor/press/slide2.jpg");        
        
        Element imageNode = in.toXML(doc);
        trail.appendChild(imageNode);
        
        
        //Ancora
        ContentAnchor a = new ContentAnchor();
        a = new ContentAnchor();
        a.setId("aAtividade1");
        a.setPoint(new Point2D.Double(100, 200));
        
        Element contentAnchor = a.toXML(doc);
        imageNode.appendChild(contentAnchor);
        

        a = new ContentAnchor();
        a.setId("aAtividade2");
        a.setPoint(new Point2D.Double(100, 230));
        
        contentAnchor = a.toXML(doc);
        imageNode.appendChild(contentAnchor);                       
        trail.appendChild(imageNode);

        in = new ImageNode();
        in.setId("slide3");
        in.setSource("vetor/press/slide3.jpg");
        
        trail.appendChild(in.toXML(doc));

        in = new ImageNode();
        in.setId("slide4");
        in.setSource("vetor/press/slide4.jpg");
        imageNode = in.toXML(doc);
        
        //Ancora
        a = new ContentAnchor();
        a.setId("aAnimacao1");
        a.setPoint(new Point2D.Double(100, 200));
        
        imageNode.appendChild(a.toXML(doc));
        trail.appendChild(imageNode);
        contextNode.appendChild(trail);

        //IGEDlets do contexto
        IGEDletNode ig = new IGEDletNode();
        ig.setId("atividade1");
        ig.setSource("vetor/iged/vetorAtiv1.igedlet");
        Element igedlet = ig.toXML(doc);
        contextNode.appendChild(igedlet);

        ig = new IGEDletNode();
        ig.setId("animacao1");
        ig.setSource("vetor/iged/vetorAnima.igedlet");
        
        igedlet = ig.toXML(doc);
        contextNode.appendChild(igedlet);

        ig = new IGEDletNode();
        ig.setId("atividade2");
        ig.setSource("vetor/iged/vetorAtiv2.igedlet");
        
        igedlet = ig.toXML(doc);
        contextNode.appendChild(igedlet);

        //Link do contexto
        //IGED Atividade 1
        CausalLink l = new CausalLink(connectors.get("onSelection1Start1"));
        l.setId("lSlide1IGEDlet1Start1");
        Element causalLink = l.toXML(doc);
        
        Bind b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAtiv1");
        b.setRole("onSelection");        
        causalLink.appendChild(b.toXML(doc));

        b = new Bind();
        b.setComponent("atividade1");
        b.setRole("start");
        
        causalLink.appendChild(b.toXML(doc));
        contextNode.appendChild(causalLink);

        l = new CausalLink(connectors.get("onStop1Resume1"));
        l.setId("lIGEDlet1Slide1Resume1");
        causalLink = l.toXML(doc);
        
        b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAtiv1");
        b.setRole("resume");
        
        causalLink.appendChild(b.toXML(doc));

        b = new Bind();
        b.setComponent("atividade1");
        b.setRole("onStop");
        
        causalLink.appendChild(b.toXML(doc));
        contextNode.appendChild(causalLink);

        //IGED Atividade 2
        l = new CausalLink(connectors.get("onSelection1Start1"));
        l.setId("lSlide1IGEDlet1Start2");
        causalLink = l.toXML(doc);
        
        b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAtiv2");
        b.setRole("onSelection");
        
        causalLink.appendChild(b.toXML(doc));

        b = new Bind();
        b.setComponent("atividade2");
        b.setRole("start");
        
        causalLink.appendChild(b.toXML(doc));
        contextNode.appendChild(causalLink);


        l = new CausalLink(connectors.get("onStop1Resume1"));
        l.setId("lIGEDlet1Slide1Resume2");
        causalLink = l.toXML(doc);
        
        b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAtiv2");
        b.setRole("resume");
        
        causalLink.appendChild(b.toXML(doc));

        b = new Bind();
        b.setComponent("atividade2");
        b.setRole("onStop");
        
        causalLink.appendChild(b.toXML(doc));
        contextNode.appendChild(causalLink);

        //IGED Animação 1
        l = new CausalLink(connectors.get("onSelection1Start1"));
        l.setId("lSlide1IGEDlet1Start2");
        causalLink = l.toXML(doc);
        
        b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAnim1");
        b.setRole("onSelection");
        causalLink.appendChild(b.toXML(doc));

        b = new Bind();
        b.setComponent("animacao1");
        b.setRole("start");
        
        causalLink.appendChild(b.toXML(doc));
        contextNode.appendChild(causalLink);

        l = new CausalLink(connectors.get("onStop1Resume1"));
        l.setId("lIGEDlet1Slide1Resume3");
        causalLink = l.toXML(doc);
        
        b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAnim1");
        b.setRole("resume");
        causalLink.appendChild(b.toXML(doc));

        b = new Bind();
        b.setComponent("animacao1");
        b.setRole("onStop");
        
        causalLink.appendChild(b.toXML(doc));
        contextNode.appendChild(causalLink);
        
        body.appendChild(contextNode);
    }

    public static void main(String args[]) throws ParserConfigurationException,
            TransformerConfigurationException, TransformerException, FileNotFoundException {
       
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        doc = builder.newDocument();        
        root = doc.createElement("document");
        
        doc.appendChild(root);

        //adicionando os dados do head
        simulateConnector();        
        
        body = doc.createElement("body");
        root.appendChild(body);
        
        simulateNCL();
        //adicionando os dados do body

        StreamResult result = new StreamResult(new FileOutputStream("vetorTest.xml"));
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.STANDALONE, "yes");
        trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.transform(new DOMSource(doc), result);



    }
}