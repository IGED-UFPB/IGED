package br.ufpb.iged.gui;


import br.ufpb.iged.gui.event.TelaPlayerEvent;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import java.awt.event.KeyListener;  
import java.awt.event.KeyEvent;  
import java.util.LinkedList;
import java.util.List;

public class ApresSwing extends TelaPlayer implements ActionListener, KeyListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    JButton buttonNext;
    JButton buttonPrevius;
    ImagePanel img = null;
    List<AnchorIcon> anchors = null;
    private boolean isRunning = false;
    private boolean isFullScreen = false;

    public ApresSwing() {
        super();
        buttonNext = new JButton();
        buttonPrevius = new JButton();
        this.img = new ImagePanel(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.anchors = new LinkedList<AnchorIcon>();

    }

    public void init() 
    {
        initComponent();
        initEvent();
        this.img.init();
        
    }
    
    public void execute()
    {
        //if(!isRunning){
            if(!isFullScreen){
                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                gd.setFullScreenWindow(this);
                this.img.showImage();
                isFullScreen = true;
            }
        
            this.requestFocus();
            this.setVisible(true);
            this.isRunning = true;
        //}
    }
    
    public void pause()
    {
        this.setVisible(false);
        this.isRunning = false;
    }
    
    public void resume()
    {
        this.execute();
    }
    
     public void finish()
    {
        this.setVisible(false);
        this.isRunning = false;
    }
    
    //Atualiza a imagem do slide atual, limpando os icones de ancoras da tela.
    public void setImage(String source)
    {
        this.clearAnchor();
    	this.img.setImage(source);
        if(this.isRunning){
            this.img.showImage();
            //this.repaint();
        }
    }
    
    public void add(AnchorIcon ai){
        this.anchors.add(ai);
        ai.getIcon().setLocation(ai.getX() + this.img.x, ai.getY() + this.img.y);
        this.add(ai.getIcon(), new Integer(1), 0);
        this.repaint();
    }
    
    private void clearAnchor(){
        if(!this.anchors.isEmpty()){
            for(AnchorIcon ai : this.anchors)
                this.remove(ai.getIcon());
            this.repaint();
            this.anchors.clear();
        }
    }

    private void initComponent() {    	
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
        
    }

    private void initEvent() {
       // this.buttonNext.addActionListener(this);
       // this.buttonPrevius.addActionListener(this);
        this.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TelaPlayerEvent ev;

        if (e.getSource().equals(this.buttonNext)) {
            System.out.println("NEXT");
            ev = new TelaPlayerEvent(this);
            ev.setAction(TelaPlayerEvent.SELECT_NEXT_NODE);

        } else if (e.getSource().equals(this.buttonPrevius)) {
            System.out.println("PREVIUS");
            ev = new TelaPlayerEvent(this);
            ev.setAction(TelaPlayerEvent.SELECT_PREVIUS_NODE);
        }else
            return;
        this.peh.sendEvent(ev);
    }

    @Override
    public void keyPressed(KeyEvent ke) {

        TelaPlayerEvent ev;

        switch(ke.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                System.out.println("Window Closed");
                ev = new TelaPlayerEvent(this);
                ev.setAction(TelaPlayerEvent.CLOSE_PLAYER);
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("PREVIUS");
                ev = new TelaPlayerEvent(this);
                ev.setAction(TelaPlayerEvent.SELECT_PREVIUS_NODE);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("NEXT");
                ev = new TelaPlayerEvent(this);
                ev.setAction(TelaPlayerEvent.SELECT_NEXT_NODE);
                break;
            default:
                return;
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

   
    class ImagePanel{

    	  private JLabel img = null;
    	  private JFrame pai = null;
          private int x, y;

    	  public ImagePanel(JFrame pai) {
    		  this.pai = pai;
                  this.img = new JLabel(); 
          }
          
          public void init(){
                  this.pai.add(this.img, new Integer(0), 0);
      	  }
    	  
    	  public void setImage(String i) {
    	    
            ImageIcon ii = new ImageIcon(i);
    	        
    	    Dimension size = new Dimension(ii.getImage().getWidth(null), ii.getImage().getHeight(null));
   	    this.img.setPreferredSize((size));
    	    this.img.setMinimumSize(size);
    	    this.img.setMaximumSize(size);
    	    this.img.setSize(size);
            this.img.setIcon(ii);
          }
          
          public void showImage(){
    	    this.centralizarContainer(this.pai, this.img);
    	  }
    	  
    	  public void centralizarContainer(Component pai, Component filho){  
        	  
    	        // obter dimens�es do pai  
    	        int larguraPai = pai.getWidth();  
    	        int alturaPai = pai.getHeight();  
    	  
    	        // obter dimens�es do filho  
    	        int larguraFilho = filho.getWidth();  
    	        int alturaFilho = filho.getHeight();  
    	        
    	        // calcular novas coordenadas do filho    
    	        this.x = (larguraPai - larguraFilho) /2 ;   
    	        this.y = (alturaPai -alturaFilho) /2 ;  
    	  
    	        // centralizar filho   
    	        filho.setLocation(this.x, this.y);    
    	 } 

    }
}
