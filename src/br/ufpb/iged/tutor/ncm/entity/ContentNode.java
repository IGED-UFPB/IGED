
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
    
    @Override
    public void execute(String interfaceID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void finish(){
        if(this.exec != null){
            this.presetationMachine.transitionStops();
            this.exec.interrupt();
        }
    }
    
    @Override
    public abstract void run();
   
}
