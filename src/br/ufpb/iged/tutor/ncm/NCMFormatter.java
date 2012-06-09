package br.ufpb.iged.tutor.ncm;

import br.ufpb.iged.tutor.ncm.connector.*;
import br.ufpb.iged.tutor.ncm.entity.*;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
*
* @author GILBERTO FARIAS
*/
public class NCMFormatter {
    private ContextNode main = null;
    private Map<String, HypermediaConnector> connectors = null;
    private Stack<ContextNode> stackContext = null;
    
    NCMFormatter(String pathXml) throws ParserConfigurationException, SAXException, IOException{        
       
        this.connectors = new HashMap<String, HypermediaConnector>();
        this.stackContext = new Stack<ContextNode>();
    }
    
    NCMFormatter(){
        this.connectors = new HashMap<String, HypermediaConnector>();
        this.stackContext = new Stack<ContextNode>();
    }
    
    public void play(){
        //while(!this.stackContext.empty()){
            ContextNode cn = this.stackContext.peek();
            //for(Node n : cn.getNodes()){
                cn.execute("pInicio");
            //}
        //}
    }
    
    //esse método irá preencher os dados do arquivo xml para os objetos
    public void fillXMLToObject(){
    }
    
    private void simulateConnector(){
        
        HypermediaConnector hc = new CausalConnector();
        ConditionRole cr = new ConditionRole();

        
        hc.setId("onSelection1Start1");
        cr.setId("onSelection");
        cr.setEventType("selection");
        EventStateTransitionCondition c = new EventStateTransitionCondition();
        c.setTransitionName("starts");
        cr.setCondition(c);
        hc.add(cr);
        
        ActionRole ar = new ActionRole();
        ar.setId("start");
        ar.setEventType("presentation");
        Action a = new Action();
        a.setActionType("start");
        ar.setAction(a);
        hc.add(ar);
        
        CausalGlue g = new CausalGlue();
        SimpleTriggerExpression ste = new SimpleTriggerExpression();
        ste.setConditionRole("onSelection");
        g.setTrigger(ste);
        
        SimpleActionExpression sae = new SimpleActionExpression();
        sae.setActionRole("start");
        g.setAction(sae);
        
        hc.setGlue(g);
        this.connectors.put(hc.getId(), hc);
        
        hc = new CausalConnector();
        hc.setId("onStop1Resume1");
        
        cr = new ConditionRole();
        cr.setId("onStop");
        cr.setEventType("presentation");
        c = new EventStateTransitionCondition();
        c.setTransitionName("stops");
        cr.setCondition(c);
        hc.add(cr);
        
        ar = new ActionRole();
        ar.setId("resume");
        ar.setEventType("presentation");
        a = new Action();
        a.setActionType("resume");
        ar.setAction(a);
        hc.add(ar);
        
        g = new CausalGlue();
        ste = new SimpleTriggerExpression();
        ste.setConditionRole("onStop");
        g.setTrigger(ste);
        
        sae = new SimpleActionExpression();
        sae.setActionRole("resume");
        g.setAction(sae);
        
        hc.setGlue(g);
        this.connectors.put(hc.getId(), hc);
    }
    
    private void simulateNCL(){
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
        
        this.main.add(cn);
        this.stackContext.push(this.main);
    }
    
    public static SimpleCondition createSimpleCondition(Element element){
        
        return null;
    
    }
    
    
    public static Role createRole(Element element){
        
        return null;
    
    }
    
    public static IGEDletNode  createIGEDletNode(Element element){
        
        return null;
    
    } 
    
    public static Glue createGlue(Element element){
        
        return null;
    
    }
    
    public static Trail createTrail(Element element){
        Trail trail = new Trail();
        trail.setId(element.getAttribute("id"));
        return trail;
        
    }
    
    public static ContextNode createContextNode(Element element){
        
        ContextNode cn = new ContextNode();
        cn.setId(element.getAttribute("id"));
        
        return cn;
    } 
    
    public static CausalLink createCausalLink(Element element){
    
        return null;
    }
    
    //verificar
    public static Link createLink(Element element, Element causalConnector){
        HypermediaConnector hc = new CausalConnector();
        hc.setId(causalConnector.getAttribute("id"));
        Link link = new CausalLink(hc);
        link.setId(element.getAttribute("id"));              
        
        return null;
    }
    
    public static Bind createBind(Element element){
        Bind b = new Bind();
        
        b.setComponent(element.getAttribute("component"));
        b.setRole(element.getAttribute("role"));
        b.setInterface(element.getAttribute("interface"));

        return b;     
    }
    
    
    public static CausalConnector createCausalConnector(Element element){
        
        CausalConnector c = new CausalConnector();
        
        c.setId(element.getAttribute("id"));
    
        return c;
    }
    
    public static ConditionRole createConditionRole(Element element){
        
        ConditionRole c = new ConditionRole();
        
        c.setId(element.getAttribute("id"));
        c.setEventType(element.getAttribute("eventType"));
    
        return c;
    }
    
    public static EventStateTransitionCondition createEventStateTransitionCondition(Element element){
        EventStateTransitionCondition e = new EventStateTransitionCondition();
        
        e.setTransitionName(element.getAttribute("starts"));
        return e;
    }
    
    public static ActionRole createActionRole(Element element){
        
        ActionRole ar = new ActionRole();
        
        ar.setId(element.getAttribute("id"));
        ar.setEventType(element.getAttribute("eventType"));
    
        return ar;
    }
    
    public static Action createAction(Element element){
        
        Action action = new Action();
        action.setActionType(element.getAttribute("actionType"));
        return action;
    
    }
    
  
            
    
    public static CausalGlue createCausalGlue(Element element){
    
        CausalGlue cg = new CausalGlue();
        return cg;
    }
    
    public static SimpleTriggerExpression createSimpleTriggerExpression(Element element){
        SimpleTriggerExpression ste = new SimpleTriggerExpression();
        
        ste.setConditionRole(element.getAttribute("conditionRole"));
        
        return ste;
    
    }
    
    public static SimpleActionExpression createSimpleActionExpression(Element element){
        SimpleActionExpression sae = new SimpleActionExpression();
        sae.setActionRole(element.getAttribute("actionRole"));        
        return sae;
    
    }
    
    public static ContentNode createMedia(Element media) {
        ContentNode cn = null;
        if (media.getAttribute("type").equals("imagem")) {
            cn = new ImageNode();
            cn.setId(media.getAttribute("id"));
            cn.setSource(media.getAttribute("src"));
            return cn;
        }else if(media.getAttribute("type").equals("igedlet")){
            cn = new IGEDletNode();           
        }
        return cn;
    }
    
    public static Port createPort(Element element){
    
        Port p = new Port();
        p.setId(element.getAttribute("id"));
        p.setComponent(element.getAttribute("component"));
        p.setIp(element.getAttribute("interface"));
        
        return p;
    
    }    
   
    
    public static void main(String arg[])
    {
        NCMFormatter ncm = new NCMFormatter();
        ncm.simulateConnector();
        ncm.simulateNCL();
        ncm.play();
    }
    
}