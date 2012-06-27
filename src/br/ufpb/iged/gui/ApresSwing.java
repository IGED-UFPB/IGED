package br.ufpb.iged.gui;


import br.ufpb.iged.gui.event.TelaPlayerEvent;
import br.ufpb.iged.tutor.ncm.entity.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Image;
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
    ImagePanel img = null;

    public ApresSwing() {
        super();
        buttonNext = new JButton();
        buttonPrevius = new JButton();
        this.img = new ImagePanel(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init() {

        initComponente();
        initEvent();
        this.requestFocus();

    }
    
        
    public void setImage(Node n){
    	
    	if(n instanceof ImageNode){
    		n = (ImageNode)n;  		
    		this.img.setImage(((ImageNode) n).getSource());
    		
    	}
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
        //this.add(buttonPrevius);
       //this.add(buttonNext);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
        
       // this.changeImage("TESTE.jpg");
        this.getContentPane().add(this.img);
        this.setVisible(true);
        
        
    }

    private void initEvent() {
       // this.buttonNext.addActionListener(this);
       // this.buttonPrevius.addActionListener(this);
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

      //  System.out.println("TTTTTTTT");

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

   
    class ImagePanel extends JPanel {

    	  private Image img = null;
    	  private JFrame pai = null;

    	  public ImagePanel(JFrame pai) {
    		  this.pai = pai;
    		  setLayout(null);
      	  }
    	  
    	  public void setImage(String i) {
    	    this.img = new ImageIcon(i).getImage();
    	        
    	    Dimension size = new Dimension(this.img.getWidth(null), this.img.getHeight(null));
   	    	setPreferredSize((size));
    	    setMinimumSize(size);
    	    setMaximumSize(size);
    	    setSize(size);
    	    
    	    this.centralizarContainer(this.pai, this);
    	      	    
    	  }

    	  public void paintComponent(Graphics g) {
    	    if(img != null)
    	    	g.drawImage(img, 0, 0, null);
    	  }
    	  
    	  public void centralizarContainer(Component pai, Component filho){  
        	  
    	        // obter dimensões do pai  
    	        int larguraPai = pai.getWidth();  
    	        int alturaPai = pai.getHeight();  
    	  
    	        // obter dimensões do filho  
    	        int larguraFilho = filho.getWidth();  
    	        int alturaFilho = filho.getHeight();  
    	        
    	        System.out.println(larguraPai);
    	        System.out.println(larguraFilho);
    	        System.out.println("-------");
    	        System.out.println(alturaPai);
    	        System.out.println(alturaFilho);
    	        
    	        // calcular novas coordenadas do filho    
    	        int novoX = (larguraPai - larguraFilho) /2 ;   
    	        int novoY = (alturaPai -alturaFilho) /2 ;  
    	  
    	        // centralizar filho  
    	        filho.getParent().setLayout(new GridBagLayout());  
    	        filho.setLocation(novoX, novoY);  
    	        filho.repaint();  
    	    }

    }
    
    public static void main(String arg[]) throws InterruptedException {
        ApresSwing as = new ApresSwing();
        as.init();
        
        ImageNode in = new ImageNode();
        in.setSource("TESTE.jpg");
        
        as.setImage(in);
        
        Thread.sleep(3000);
        
        in.setSource("image_preview.jpg");
        as.setImage(in);
    }
    
}
