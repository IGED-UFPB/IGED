package br.ufpb.iged.tutor.players;

import br.ufpb.iged.gui.AnchorIcon;
import br.ufpb.iged.gui.ApresSwing;
import br.ufpb.iged.gui.event.TelaPlayerEvent;
import br.ufpb.iged.gui.event.TelaPlayerListener;
import br.ufpb.iged.tutor.ncm.entity.Anchor;
import br.ufpb.iged.tutor.ncm.entity.ContentAnchor;
import br.ufpb.iged.tutor.ncm.entity.ImageNode;
import br.ufpb.iged.tutor.ncm.entity.Node;
import br.ufpb.iged.tutor.players.event.ActionUserEvent;

public class ApressPlayer extends Player implements TelaPlayerListener {

    private boolean isRunning = false;
    private boolean isInit = false;
    private ApresSwing ti = null;
    private static ApressPlayer player = null;

    private ApressPlayer() {
    }

    public static synchronized ApressPlayer getInstance() {
        if (player == null) {
            player = new ApressPlayer();
        }
        return player;
    }

    @Override
    public void init() {
            this.ti = new ApresSwing();
            this.ti.init();
            this.ti.addListener(this);
    }

    @Override
    public void execute() {
        //if (!this.isRunning) {
            this.ti.execute();
            this.isRunning = true;
        //}
    }

    @Override
    public void resume() {
        //if (!this.isRunning) {
            System.out.println("Resume ApressPlayer");
            this.init();
            this.execute();
        //}
    }

    @Override
    public void pause() {
        //if (this.isRunning) {
            this.ti.pause();
            this.isRunning = false;
        //}
    }

    @Override
    public void finish() {
        this.ti.finish();
        this.ti.removeListener(this);
        this.isRunning = false;
    }

    @Override
    public void play(Node n) {
        if(n instanceof ImageNode){
            ImageNode in = (ImageNode)n;
            this.ti.setImage(in.getSource());
            
            for(Anchor a : in.getAnchors()){
                if(a instanceof ContentAnchor){
                    ContentAnchor ca = (ContentAnchor)a;
                    AnchorIcon ai = new AnchorIcon(ca.getPoint());
                    ai.addListener(ca);
                    this.ti.add(ai);
                }
            }
        }
    }

    
    @Override
    public void receiveEvent(TelaPlayerEvent ev) {

        ActionUserEvent aue;
        switch (ev.getAction()) {
            case TelaPlayerEvent.CLOSE_PLAYER:
                aue = new ActionUserEvent();
                aue.setAction(TelaPlayerEvent.CLOSE_PLAYER);
                break;

            case TelaPlayerEvent.INIT_PLAYER:
                aue = new ActionUserEvent();
                aue.setAction(TelaPlayerEvent.INIT_PLAYER);
                break;

            case TelaPlayerEvent.SELECT_ANCHOR:
                aue = new ActionUserEvent();
                aue.setAction(TelaPlayerEvent.SELECT_ANCHOR);
                break;

            case TelaPlayerEvent.SELECT_NEXT_NODE:
                aue = new ActionUserEvent();
                aue.setAction(TelaPlayerEvent.SELECT_NEXT_NODE);
                break;

            case TelaPlayerEvent.SELECT_PREVIUS_NODE:
                aue = new ActionUserEvent();
                aue.setAction(TelaPlayerEvent.SELECT_PREVIUS_NODE);
                break;

            case TelaPlayerEvent.UNKNOWN:
                aue = new ActionUserEvent();
                aue.setAction(TelaPlayerEvent.UNKNOWN);
                break;
            default:
                return;
        }
        super.sendEvent(aue);
    }

    public boolean isRunning() {
        return this.isRunning;
    }
}
