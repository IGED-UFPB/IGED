package br.ufpb.iged.tutor.ncm;

import br.ufpb.iged.tutor.ncm.entity.*;
import br.ufpb.iged.tutor.ncm.connector.*;
import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
*
* @author GILBERTO FARIAS
*/
public class NCMFormatter {
    private ContextNode main = null;
    private Map<String, HypermediaConnector> connectors = null;
    private Stack<ContextNode> stackContext = null;
    
    NCMFormatter(){
        this.connectors = new HashMap<String, HypermediaConnector>();
        this.stackContext = new Stack<ContextNode>();
    }
    
    public void play(){
        while(!this.stackContext.empty()){
            ContextNode cn = this.stackContext.peek();
            
            for(Node n : cn.getNodes()){
                
            }
        }
    }
    
    private void simulateConnector(){
        HypermediaConnector hc = new CausalConnector();
        hc.setId("onSelection1Start1");
        
        ConditionRole cr = new ConditionRole();
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
        this.main.setName("main");
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
        p.setComponent("slide1");
        t.add(p);
        
        //Medias
        ImageNode in = new ImageNode();
        in.setId("slide1");
        in.setSource("vetor/press/slide1.jpg");
        //Ancora
        ContentAnchor a = new ContentAnchor();
        a.setId("aAnimacao1");
        a.setPoint(new Point2D.Double(100, 200));
        in.add(a);
        t.add(in);
        
        in = new ImageNode();
        in.setId("slide2");
        in.setSource("vetor/press/slide2.jpg");
        //Ancora
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
        Link l = new CausalLink(this.connectors.get("onSelection1Start1"));
        l.setId("lSlide1IGEDlet1Start2");
        Bind b = new Bind();
        b.setComponent("slide1");
        b.setInterface("aAnimacao1");
        b.setRole("onSelection");
        l.add(b);
        
        b = new Bind();
        b.setComponent("animaca1");
        b.setRole("start");
        l.add(b);
        cn.add(l);
        
        l = new CausalLink(this.connectors.get("onStop1Resume1"));
        l.setId("lIGEDlet1Slide1Resume2");
        b = new Bind();
        b.setComponent("slide1");
        b.setRole("resume");
        l.add(b);
        
        b = new Bind();
        b.setComponent("animaca1");
        b.setRole("OnStop");
        l.add(b);
        cn.add(l);
        
        l = new CausalLink(this.connectors.get("onSelection1Start1"));
        l.setId("lSlide1IGEDlet1Start1");
        b = new Bind();
        b.setComponent("slide2");
        b.setInterface("aAtividade1");
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
        b.setComponent("slide2");
        b.setRole("resume");
        l.add(b);
        
        b = new Bind();
        b.setComponent("atividade1");
        b.setRole("OnStop");
        l.add(b);
        cn.add(l);
        
        this.main.add(cn);
        this.stackContext.push(this.main);
    }
}