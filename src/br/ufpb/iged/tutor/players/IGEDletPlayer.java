package br.ufpb.iged.tutor.players;

import br.ufpb.iged.gerenciadorIGEDlet.GerenciadorAtividade;
import br.ufpb.iged.gerenciadorIGEDlet.IGEDlet;
import br.ufpb.iged.gui.TelaIGEDlet;
import br.ufpb.iged.gui.event.TelaPlayerEvent;
import br.ufpb.iged.gui.event.TelaPlayerListener;
import br.ufpb.iged.tutor.ncm.entity.IGEDletNode;
import br.ufpb.iged.tutor.ncm.entity.Node;
import br.ufpb.iged.tutor.players.event.ActionUserEvent;

/**
 *
 * @author GILBERTO FARIAS
 */
public class IGEDletPlayer extends Player implements TelaPlayerListener{

    private boolean isRunning = false;
    private TelaIGEDlet ti = null;
    private static IGEDletPlayer player = null;
    
    private IGEDletPlayer(){
    }
    
    public static synchronized IGEDletPlayer getInstance(){
        if(player == null)
            player = new IGEDletPlayer();
        return player;
    }
    
    @Override
    public void init() {
        if(!this.isRunning){
            this.ti = new TelaIGEDlet();
            this.ti.addListener(this);
        }
    }

    @Override
    public void execute() {
        if(!this.isRunning){
            this.ti.init();
            this.isRunning = true;
        }
    }

    @Override
    public void resume() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pause() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void finish() {
        if(this.isRunning){
            this.ti.finish();
            this.ti.removeListener(this);
            this.isRunning = false;
        }
    }

    @Override
    public void play(Node n) {
        if(this.isRunning){
            if(n instanceof IGEDletNode){
                IGEDletNode in = (IGEDletNode)n;
                GerenciadorAtividade gt = GerenciadorAtividade.getInstance();
                int igedID = Integer.parseInt(in.getSource());
                IGEDlet tf = gt.loadTarefa(igedID);
                this.ti.execute(tf);
            }
        }
        
    }

    @Override
    public void receiveEvent(TelaPlayerEvent ev) {
        if(ev.getAction() == TelaPlayerEvent.CLOSE_PLAYER){
            ActionUserEvent aue = new ActionUserEvent();
            aue.setAction(ActionUserEvent.CLOSE_PLAYER);
            this.sendEvent(aue);
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }
}
