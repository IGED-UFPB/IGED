package br.ufpb.iged.gui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import br.ufpb.iged.gui.event.TelaPlayerEvent;

public class ApresSwing extends TelaPlayer implements ActionListener {

    JButton buttonNext;
    JButton buttonPrevius;

    public ApresSwing() {
        super();
        buttonNext = new JButton();
        buttonPrevius = new JButton();
    }

    public void init() {

        initComponente();
        initEvent();

    }

    private void initComponente() {


        this.setTitle("IGED");
        this.setLayout(null);

        buttonPrevius.setLocation(580, 670);
        buttonPrevius.setSize(100, 50);
        buttonPrevius.setText("PREVIUS");

        buttonNext.setLocation(720, 670);
        buttonNext.setSize(100, 50);
        buttonNext.setText("NEXT");

        //frame.add(buttonPlay);
        this.add(buttonPrevius);
        this.add(buttonNext);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
        this.setVisible(true);
    }

    private void initEvent() {
        this.buttonNext.addActionListener(this);
        this.buttonPrevius.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TelaPlayerEvent ev = new TelaPlayerEvent(this);

        if (e.getSource().equals(this.buttonNext)) {
            System.out.println("NEXT");
            ev.setAction(TelaPlayerEvent.SELECT_NEXT_NODE);

        } else if (e.getSource().equals(this.buttonPrevius)) {
            System.out.println("PREVIUS");
            ev.setAction(TelaPlayerEvent.SELECT_PREVIUS_NODE);
        }
        this.peh.sendEvent(ev);
    }
    
    public static void main(String arg[]){
        ApresSwing as = new ApresSwing();
        as.init();
    }
}
