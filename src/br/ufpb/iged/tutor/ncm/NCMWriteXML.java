package br.ufpb.iged.tutor.ncm;

import br.ufpb.iged.tutor.ncm.connector.*;
import br.ufpb.iged.tutor.ncm.entity.*;
import java.awt.geom.Point2D;
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
 *
 * @author darkolyver
 */
public class NCMWriteXML {
    
    private static DocumentBuilderFactory factory;
    private static DocumentBuilder builder;
    private static Document doc;
    private static Element root;
    private static Element body;


    private static void simulateConnector() {

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


    }

    /*
    private static void simulateNCL() {
        this.main = new ContextNode();
        this.main.setId("main");
        //Porta inicial
        Port p = new Port();
        p.setId("pInicio");
        p.setComponent("ctxVetor");
        p.setIp("pInicio");
        this.main.add(p);

        //Contexto vetor
        ContextNode cn = new ContextNode();
        cn.setId("ctxVetor");
        //Porta ctxVetor
        p = new Port();
        p.setId("pInicio");
        p.setComponent("vetor");
        p.setIp("pVetor");
        cn.add(p);

        //Trail
        Trail t = new Trail();
        t.setId("vetor");
        //Porta pVetor
        p = new Port();
        p.setId("pVetor");
        p.setComponent("slide2");
        t.add(p);

        p = new Port();
        p.setId("pAtiv1");
        p.setComponent("slide2");
        p.setIp("aAtividade1");
        t.add(p);

        p = new Port();
        p.setId("pAtiv2");
        p.setComponent("slide2");
        p.setIp("aAtividade2");
        t.add(p);

        p = new Port();
        p.setId("pAnim1");
        p.setComponent("slide4");
        p.setIp("aAnimacao1");
        t.add(p);

        //Medias
        ImageNode in = new ImageNode();
        in.setId("slide1");
        in.setSource("vetor/press/slide1.jpg");
        t.add(in);

        in = new ImageNode();
        in.setId("slide2");
        in.setSource("vetor/press/slide2.jpg");
        //Ancora
        //Ancora
        ContentAnchor a = new ContentAnchor();
        a = new ContentAnchor();
        a.setId("aAtividade1");
        a.setPoint(new Point2D.Double(100, 200));
        in.add(a);

        a = new ContentAnchor();
        a.setId("aAtividade2");
        a.setPoint(new Point2D.Double(100, 230));
        in.add(a);
        t.add(in);

        in = new ImageNode();
        in.setId("slide3");
        in.setSource("vetor/press/slide3.jpg");
        t.add(in);

        in = new ImageNode();
        in.setId("slide4");
        in.setSource("vetor/press/slide4.jpg");
        //Ancora
        a = new ContentAnchor();
        a.setId("aAnimacao1");
        a.setPoint(new Point2D.Double(100, 200));
        in.add(a);
        t.add(in);

        cn.add(t);

        //IGEDlets do contexto
        IGEDletNode ig = new IGEDletNode();
        ig.setId("atividade1");
        ig.setSource("vetor/iged/vetorAtiv1.igedlet");
        cn.add(ig);

        ig = new IGEDletNode();
        ig.setId("animacao1");
        ig.setSource("vetor/iged/vetorAnima.igedlet");
        cn.add(ig);

        ig = new IGEDletNode();
        ig.setId("atividade2");
        ig.setSource("vetor/iged/vetorAtiv2.igedlet");
        cn.add(ig);

        //Link do contexto
        //IGED Atividade 1
        Link l = new CausalLink(this.connectors.get("onSelection1Start1"));
        l.setId("lSlide1IGEDlet1Start1");
        Bind b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAtiv1");
        b.setRole("onSelection");
        l.add(b);

        b = new Bind();
        b.setComponent("atividade1");
        b.setRole("start");
        l.add(b);
        cn.add(l);

        l = new CausalLink(this.connectors.get("onStop1Resume1"));
        l.setId("lIGEDlet1Slide1Resume1");
        b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAtiv1");
        b.setRole("resume");
        l.add(b);

        b = new Bind();
        b.setComponent("atividade1");
        b.setRole("onStop");
        l.add(b);
        cn.add(l);

        //IGED Atividade 2
        l = new CausalLink(this.connectors.get("onSelection1Start1"));
        l.setId("lSlide1IGEDlet1Start2");
        b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAtiv2");
        b.setRole("onSelection");
        l.add(b);

        b = new Bind();
        b.setComponent("atividade2");
        b.setRole("start");
        l.add(b);
        cn.add(l);

        l = new CausalLink(this.connectors.get("onStop1Resume1"));
        l.setId("lIGEDlet1Slide1Resume2");
        b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAtiv2");
        b.setRole("resume");
        l.add(b);

        b = new Bind();
        b.setComponent("atividade2");
        b.setRole("onStop");
        l.add(b);
        cn.add(l);

        //IGED Animação 1
        l = new CausalLink(this.connectors.get("onSelection1Start1"));
        l.setId("lSlide1IGEDlet1Start2");
        b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAnim1");
        b.setRole("onSelection");
        l.add(b);

        b = new Bind();
        b.setComponent("animacao1");
        b.setRole("start");
        l.add(b);
        cn.add(l);

        l = new CausalLink(this.connectors.get("onStop1Resume1"));
        l.setId("lIGEDlet1Slide1Resume3");
        b = new Bind();
        b.setComponent("vetor");
        b.setInterface("pAnim1");
        b.setRole("resume");
        l.add(b);

        b = new Bind();
        b.setComponent("animacao1");
        b.setRole("onStop");
        l.add(b);
        cn.add(l);

    }*/

    public static void main(String args[]) throws ParserConfigurationException,
            TransformerConfigurationException, TransformerException, FileNotFoundException {
       
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        doc = builder.newDocument();        
        root = doc.createElement("document");
        
        doc.appendChild(root);

        simulateConnector();        
        
        body = doc.createElement("body");
        root.appendChild(body);
        
        /*
        CausalConnector c = new CausalConnector();
        c.setId("test");

        Element item3 = doc.createElement("causalConnector");
        Element item1 = c.toXML(doc);

        root.appendChild(item1);
        item1.appendChild(item3);

        Element item2 = doc.createElement("causalConnector");
        item2.setAttribute("id", "carai");
        root.appendChild(item2);*/

        StreamResult result = new StreamResult(new FileOutputStream("vetorTest.xml"));
        Transformer trans = TransformerFactory.newInstance().newTransformer();
        trans.setOutputProperty(OutputKeys.STANDALONE, "yes");
        trans.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");
        trans.transform(new DOMSource(doc), result);



    }
}