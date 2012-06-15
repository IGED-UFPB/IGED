package br.ufpb.iged.tutor.players;

import br.ufpb.iged.gerenciadorIGEDlet.GerenciadorAtividade;
import br.ufpb.iged.gerenciadorIGEDlet.IGEDlet;
import br.ufpb.iged.gui.TelaIGEDlet;
import br.ufpb.iged.gui.event.ClosedTelaIGEDletEvent;
import br.ufpb.iged.gui.event.TelaIGEDletEvent;
import br.ufpb.iged.gui.event.TelaIGEDletListener;
import br.ufpb.iged.tutor.ncm.entity.IGEDletNode;
import br.ufpb.iged.tutor.ncm.entity.Node;
import br.ufpb.iged.tutor.players.event.ActionUserEvent;

/**
 *
 * @author GILBERTO FARIAS
 */
public class IGEDletPlayer extends Player implements TelaIGEDletListener{

    private boolean isRunning = false;
    private TelaIGEDlet ti = null;
    private static IGEDletPlayer player = null;
    
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
    public void receiveEvent(TelaIGEDletEvent ev) {
        if(ev instanceof ClosedTelaIGEDletEvent){
            ActionUserEvent aue = new ActionUserEvent();
            aue.setAction(ActionUserEvent.CLOSE_PLAYER);
            this.sendEvent(aue);
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }
}
