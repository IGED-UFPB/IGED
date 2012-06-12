package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.connector.*;
import br.ufpb.iged.tutor.ncm.event.EntityEvent;
import br.ufpb.iged.tutor.ncm.event.EntityListener;
import br.ufpb.iged.tutor.ncm.event.PresentationEvent;
import br.ufpb.iged.tutor.ncm.event.SelectionEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ContextNode extends CompositeNode {

    private Map<String, Link> links;

    public ContextNode() {
        this.links = new HashMap<String, Link>();
    }

    @Override
    public void execute(String portID) {
        this.loadLinks();
        super.execute(portID);
    }

    public void add(Link l) {
        this.links.put(l.getId(), l);
    }

    public void remove(Link l) {
        this.links.remove(l.getId());
    }

    @Override
    public void add(Node n) {
        this.nodes.put(n.getId(), n);
    }

    public Collection<Link> getLinks() {
        return links.values();
    }

    public Link getLink(String id) {
        return this.links.get(id);
    }

    public void loadLinks() {
        for (final Link l : this.getLinks()) {
            System.out.println("Carregando Link: " + l.getId());
            final HypermediaConnector hc = l.getConnector();
            for (Bind b : l.getBinds()) {
                System.out.println("Carregando Bind: " + b.getRole());
                System.out.println("Bind Component: " + b.getComponent());
                System.out.println("Bind Interface: " + b.getInterface());
                //Procura os conditions roles do connector do link
                final ConditionRole conditionRole = hc.getConditionRole(b.getRole());
                if (conditionRole == null) {
                    continue;
                }
                System.out.println("Carregando ConditionRole: " + conditionRole.getId());
                Entity c = this.nodes.get(b.getComponent());
                if ((b.getInterface() != null) && (c instanceof Node)) {
                    Node node = (Node) c;
                    c = node.getComponentByInterface(b.getInterface());
                }
                final Entity component = c;
                if (component instanceof ContentAnchor) {
                    System.out.println("ContentAnchor: " + component.getId());
                } else {
                    System.out.println("Não e um ContentAnchor: " + component.getId());
                }

                final ContextNode context = this;
                component.addListener(
                        new EntityListener() {

                            @Override
                            public void stateTransition(EntityEvent e) {
                                System.out.println("StateTransition");
                                //Testa se o evento eh do tipo selection
                                if ((conditionRole.getEventType().equals("selection")
                                        && (e instanceof SelectionEvent))
                                        || (conditionRole.getEventType().equals("presentation")
                                        && (e instanceof PresentationEvent))) {

                                    if (conditionRole.getCondition() instanceof EventStateTransitionCondition) {
                                        EventStateTransitionCondition condition = (EventStateTransitionCondition) conditionRole.getCondition();
                                        //Se a transicao do evento for "starts" testar se o evento esta ocorrendo
                                        //ou se a transicao do evento for "stopss" testar se o evento esta ocorrendo
                                        if ((condition.getTransitionName().equals("starts")
                                                && (e.getStaus() == EntityEvent.OCCURING))
                                                || (condition.getTransitionName().equals("stops")
                                                && (e.getStaus() == EntityEvent.SLEEPING))) {
                                            Glue g = hc.getGlue();
                                            if (g instanceof CausalGlue) {
                                                context.processCausalGlue(l, conditionRole, component);
                                            }
                                        }
                                    }

                                }
                            }
                        });
            }
        }
    }

    void processCausalGlue(Link l, ConditionRole conditionRole, Entity component) {
        CausalGlue glue = (CausalGlue) (l.getConnector()).getGlue();
        TriggerExpression t = glue.getTrigger();
        if (t instanceof SimpleTriggerExpression) {
            SimpleTriggerExpression trigger = (SimpleTriggerExpression) t;
            //Testa se a condition role atendida é o trigger da Glue
            if (trigger.getConditionRole().equals(conditionRole.getId())) {
                ActionExpression ae = glue.getAction();
                if (ae instanceof SimpleActionExpression) {
                    SimpleActionExpression action = (SimpleActionExpression) ae;
                    //Pega a action do Glue e procura o bind associado.
                    System.out.println("Get ActionRole: " + action.getActionRole());
                    ActionRole ar = l.getConnector().getActionRole(action.getActionRole());
                    if (ar == null) {
                        return;
                    }
                    Action a = ar.getAction();
                    if (ar.getEventType().equals("presentation")) {
                        //Pausar componente atual se estiver rodando
                        Node nlast = null;
                        if (component instanceof Anchor) {
                            nlast = ((Anchor) component).getContent();
                        } else {
                            nlast = (Node) component;
                        }
                        if (nlast.getState() == EntityEvent.OCCURING) {
                            nlast.pause();
                        }

                        System.out.println("Action: " + a.getActionType());
                        for (Bind ba : l.getBindsForRole(ar.getId())) {
                            this.processAction(a, ba);
                        }
                    }
                }
            }
        }
    }

    void processAction(Action a, Bind ba) {
        Node n = this.nodes.get(ba.getComponent());
        if (n != null) {
            if (a.getActionType().equals("start")) {
                if (ba.getInterface() == null) {
                    ((ContentNode) n).execute();
                } else {
                    n.execute(ba.getInterface());
                }
            } else if (a.getActionType().equals("resume")) {
                if (ba.getInterface() != null) {
                    n.resume(ba.getInterface());
                } else {
                    n.resume();
                }
            } else if (a.getActionType().equals("pause")) {
                if (ba.getInterface() != null) {
                    //n.pause(ba.getInterface());
                } else {
                    n.pause();
                }
            } else if (a.getActionType().equals("stop")) {
                if (ba.getInterface() != null) {
                    //n.pause(ba.getInterface());
                } else {
                    n.finish();
                }
            }
        }
    }
       
    public Element toXML(Document doc){
    
        Element element = doc.createElement("context");       
        element.setAttribute("id", getId());
    
        return element;
    
    }
    
    public ContextNode toReadXML(Element element){
    
        this.setId(element.getAttribute("id"));
        
        return this;
    
    }
}
