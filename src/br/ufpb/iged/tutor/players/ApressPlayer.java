package br.ufpb.iged.tutor.players;

import br.ufpb.iged.gui.ApresSwing;
import br.ufpb.iged.gui.TelaIGEDlet;
import br.ufpb.iged.gui.event.TelaPlayerEvent;
import br.ufpb.iged.gui.event.TelaPlayerListener;
import br.ufpb.iged.tutor.ncm.entity.Node;
import br.ufpb.iged.tutor.players.event.ActionUserEvent;

public class ApressPlayer extends Player implements TelaPlayerListener {
	
	
	 private boolean isRunning = false;
	 private ApresSwing ti = null;
	 private static ApressPlayer player = null;
	
	private ApressPlayer(){
		
	}
	
	public static synchronized ApressPlayer getInstance(){
	       if(player == null)
	            player = new ApressPlayer();
	       
	        return player;
	}

	@Override
	public void init() {
		if(!this.isRunning){
            this.ti = new ApresSwing();
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
		if(this.isRunning){
            //this.finish();
            //this.ti.removeListener(this);
            this.ti.setVisible(true);
            this.isRunning = false;
        }
	}

	@Override
	public void pause() {
		if(this.isRunning){
            //this.finish();
            this.ti.removeListener(this);
            this.ti.setVisible(false);
            this.isRunning = false;
        }
		
	}

	@Override
	public void finish() {
		if(this.isRunning){
            //this.finish();
			this.ti.remove(ti);
            this.ti.removeListener(this);
            this.isRunning = false;
        }
	}

	@Override
	public void play(Node n) {
		
		
		
		
	}

    public String getSelectAnchor() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

	@Override
	public void receiveEvent(TelaPlayerEvent ev) {
			
			ActionUserEvent aue = new ActionUserEvent();
		
		if ( ev.getAction() == TelaPlayerEvent.CLOSE_PLAYER){ 
			
			aue.setAction(TelaPlayerEvent.CLOSE_PLAYER);
			
		}else if( ev.getAction() == TelaPlayerEvent.INIT_PLAYER){
			
			aue.setAction(TelaPlayerEvent.INIT_PLAYER);
			
		}else if(ev.getAction() == TelaPlayerEvent.SELECT_ANCHOR){
			
			aue.setAction(TelaPlayerEvent.SELECT_ANCHOR);
			
		}else if(ev.getAction() == TelaPlayerEvent.SELECT_NEXT_NODE){
			
			aue.setAction(TelaPlayerEvent.SELECT_NEXT_NODE);
			
		}else if(ev.getAction() == TelaPlayerEvent.SELECT_PREVIUS_NODE){
			
			aue.setAction(TelaPlayerEvent.SELECT_PREVIUS_NODE);
				
		}else if(ev.getAction() == TelaPlayerEvent.UNKNOWN){
		
			aue.setAction(TelaPlayerEvent.UNKNOWN);
		}
			
		super.sendEvent(aue);
		
		
	}

}
