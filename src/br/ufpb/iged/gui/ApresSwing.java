package br.ufpb.iged.gui;

import br.ufpb.iged.gui.event.TelaPlayerEvent;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.event.KeyListener;  
import java.awt.event.KeyEvent;  

public class ApresSwing extends TelaPlayer implements ActionListener, KeyListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JButton buttonNext;
    JButton buttonPrevius;

    public ApresSwing() {
        super();
        buttonNext = new JButton();
        buttonPrevius = new JButton();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init() {

        initComponente();
        initEvent();
        this.requestFocus();

    }

    private void initComponente() {
        this.setTitle("IGED");
        this.setLayout(null);
        this.setUndecorated(true);

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
        this.addKeyListener(this);
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

    @Override
    public void keyPressed(KeyEvent ke) {

        System.out.println("TTTTTTTT");

        TelaPlayerEvent ev = new TelaPlayerEvent(this);

        if (ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.out.println("Window Closed");

            ev.setAction(TelaPlayerEvent.CLOSE_PLAYER);

        } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("PREVIUS");

            ev.setAction(TelaPlayerEvent.SELECT_PREVIUS_NODE);

        } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("NEXT");

            ev.setAction(TelaPlayerEvent.SELECT_NEXT_NODE);
        }

        this.peh.sendEvent(ev);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    public static void main(String arg[]) {
        ApresSwing as = new ApresSwing();
        as.init();
    }
}
