
package br.ufpb.iged.tutor.ncm.entity;

/**
 *
 * @author GILBERTO FARIAS
 */
public abstract class ContentNode extends Node implements Runnable{
    protected String source;
    protected Thread exec = null;
    
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void execute(){
        this.presetationMachine.transitionStarts();
        this.exec = new Thread(this);
        this.exec.start();
    }
    
    public void pause(){
        this.presetationMachine.transitionPauses();
    }
    
    public void resume(){
        this.presetationMachine.transitionResumes();
    }
    
    @Override
    public void execute(String interfaceID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void finish(){
        if(this.exec != null){
            this.presetationMachine.transitionStops();
            this.exec.interrupt();
            this.exec = null;
        }
    }
    
    @Override
    public abstract void run();
   
}
