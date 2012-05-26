
package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.connector.Action;
import br.ufpb.iged.tutor.ncm.connector.ActionExpression;
import br.ufpb.iged.tutor.ncm.connector.ActionRole;
import br.ufpb.iged.tutor.ncm.connector.Bind;
import br.ufpb.iged.tutor.ncm.connector.CausalGlue;
import br.ufpb.iged.tutor.ncm.connector.ConditionRole;
import br.ufpb.iged.tutor.ncm.connector.EventStateTransitionCondition;
import br.ufpb.iged.tutor.ncm.connector.Glue;
import br.ufpb.iged.tutor.ncm.connector.SimpleActionExpression;
import br.ufpb.iged.tutor.ncm.connector.SimpleTriggerExpression;
import br.ufpb.iged.tutor.ncm.connector.TriggerExpression;
import br.ufpb.iged.tutor.ncm.event.EntityEvent;
import br.ufpb.iged.tutor.ncm.event.EntityListener;
import br.ufpb.iged.tutor.ncm.event.SelectionEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GILBERTO FARIAS
 */
public class ContextNode extends CompositeNode{
    private Map<String, Link> links;
    
    public ContextNode(){
        this.links = new HashMap<String, Link>();
    }
    
    public void add(Link l){
        this.links.put(l.getId(), l);
    }
    public void remove(Link l){
        this.links.remove(l.getId());
    }
    
    @Override
    public void add(Node n){
        this.nodes.put(n.getId(), n);
    }

    public Collection<Link> getLinks() {
        return links.values();
    }
    public Link getLink(String id){
        return this.links.get(id);
    }
    
    public void loadLinks(){
        for(final Link l : this.getLinks()){
            final HypermediaConnector hc = l.getConnector();
            for(Bind b : l.getBinds()){
                //Procura os conditions roles do connector do link
                final ConditionRole conditionRole = hc.getConditionRole(b.getRole());
                if(conditionRole == null)
                    continue;
                Entity component = this.nodes.get(b.getComponent());
                if((b.getInterface() != null)&&(component instanceof Node)){
                    Node node = (Node)component;
                    component = node.getComponentByInterface(b.getInterface());
                }
                
                final ContextNode context = this;
                component.addListener(
                        new EntityListener(){
                            @Override
                            public void stateTransition(EntityEvent e) {
                                //Testa se o evento do tipo selection
                                if(conditionRole.getEventType().equals("selection") 
                                            && (e instanceof SelectionEvent)){
                                    if(conditionRole.getCondition() instanceof EventStateTransitionCondition){
                                        EventStateTransitionCondition condition = (EventStateTransitionCondition)conditionRole.getCondition();
                                        //Se a transicao do evento for "starts" testar se o evento esta ocorrendo
                                        if(condition.getTransitionName().equals("starts") 
                                                    && (e.getStaus() == EntityEvent.OCCURING)){
                                            Glue g = hc.getGlue();
                                            if(g instanceof CausalGlue){
                                                CausalGlue glue = (CausalGlue)g;
                                                TriggerExpression t = glue.getTrigger();
                                                if(t instanceof SimpleTriggerExpression){
                                                    SimpleTriggerExpression trigger = (SimpleTriggerExpression)t;                                             
                                                    //Testa se a condition role atendida é o trigger da Glue
                                                    if(trigger.getConditionRole().equals(conditionRole.getId())){
                                                        ActionExpression ae = glue.getAction();
                                                        if(ae instanceof SimpleActionExpression){
                                                            SimpleActionExpression action = (SimpleActionExpression) ae;
                                                            //Pega a action do Glue e procura o bind associado.
                                                            ActionRole ar = hc.getActionRole(action.getActionRole());
                                                            if(ar == null)
                                                                return;
                                                            Action a = ar.getAction();
                                                            if(ar.getEventType().equals("presentation")){
                                                                if(a.getActionType().equals("start")){
                                                                    for(Bind ba : l.getBindsForRole(ar.getId())){
                                                                        Node n = context.nodes.get(ba.getComponent());
                                                                        if(ba.getInterface() == null)
                                                                            ((ContentNode)n).execute();
                                                                        else
                                                                            n.execute(ba.getInterface());
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                        
                                }
                            }
                        }
                );
            }
        }
    }
}

