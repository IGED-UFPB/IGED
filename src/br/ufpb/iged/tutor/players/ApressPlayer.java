package br.ufpb.iged.tutor.players;

import br.ufpb.iged.gui.ApresSwing;
import br.ufpb.iged.gui.event.TelaPlayerEvent;
import br.ufpb.iged.gui.event.TelaPlayerListener;
import br.ufpb.iged.tutor.ncm.entity.Node;
import br.ufpb.iged.tutor.players.event.ActionUserEvent;

public class ApressPlayer extends Player implements TelaPlayerListener {
	
	ApresSwing apreSwing = new ApresSwing();
	
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
	
		this.apreSwing.addListener(this);
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play(Node n) {
		// TODO Auto-generated method stub
		
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
