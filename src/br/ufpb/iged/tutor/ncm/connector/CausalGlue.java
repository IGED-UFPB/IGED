
package br.ufpb.iged.tutor.ncm.connector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author GILBERTO FARIAS
 */
public class CausalGlue implements Glue{
    private TriggerExpression trigger;
    private ActionExpression action;

    public ActionExpression getAction() {
        return action;
    }

    public void setAction(ActionExpression action) {
        this.action = action;
    }

    public TriggerExpression getTrigger() {
        return trigger;
    }

    public void setTrigger(TriggerExpression trigger) {
        this.trigger = trigger;
    }
    
    public Element toXML(Document doc){
    
        Element element = doc.createElement("causalGlue");       
        
        return element;
    
    }
    
}
