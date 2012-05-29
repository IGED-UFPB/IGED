
package br.ufpb.iged.tutor.ncm.entity;

import br.ufpb.iged.tutor.ncm.event.EventStateMachine;
import br.ufpb.iged.tutor.ncm.event.PresentationEvent;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class ContentNode extends Node implements Runnable{
    protected String source;
    protected Thread exec = null;
    
    ContentNode(){
        super();
        PresentationEvent pe = new PresentationEvent();
        pe.setSource(this);
        this.presetationMachine = new EventStateMachine(pe);
    }
    
    @Override
    public void add(Anchor a){
        if(a instanceof ContentAnchor){
            super.add(a);
            ((ContentAnchor)a).setContent(this);
        }
        
    }
    
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void execute(){
        System.out.println("Init PresentationMachine: " + this.getId());
        if(this.exec == null){
            this.exec = new Thread(this);
            this.exec.start();
        }
        this.presetationMachine.transitionStarts();
    }
    
    @Override
    public void pause(){
        System.out.println("Pause PresentationMachine: " + this.getId());
        if(this.exec != null){
            this.exec.interrupt();
            this.exec = null;
        }
        this.presetationMachine.transitionPauses();
    }
    
    @Override
    public void resume(){
        System.out.println("Resume PresentationMachine: " + this.getId());
        if(this.exec == null){
            this.exec = new Thread(this);
            this.exec.start();
        }
        this.presetationMachine.transitionResumes();
    }
    
    @Override
    public void execute(String interfaceID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void resume(String interfaceID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void finish(){
        System.out.println("Finish PresentationMachine: " + this.getId());
        if(this.exec != null){
            this.presetationMachine.transitionStops();
            this.exec.interrupt();
            this.exec = null;
        }
    }
    
    @Override
    public abstract void run();
   
}
