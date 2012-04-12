package br.ufpb.iged.grafico.manager;

import br.ufpb.iged.grafico.struct.Elemento;
import br.ufpb.iged.grafico.geometria.Poligono;
import br.ufpb.iged.grafico.geometria.Label;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Point2D;
import java.util.*;


import javax.swing.JPanel;

public class Quadro extends JPanel {

  private java.util.List<Poligono> desenhaveis = null;
  private java.util.List<Label> textos = null;

  private Poligono linhaNode = null;
  private Poligono linhaStruct = null;
  
  public Quadro(){
	  this.desenhaveis = new LinkedList<Poligono>();
	  this.textos = new LinkedList<Label>();
          
          this.initLinhas();
  }
  
  private void initLinhas(){
      this.linhaNode = new Poligono();
      this.linhaNode.add(new Point2D.Double(10, YBASE_NODE));
      this.linhaNode.add(new Point2D.Double(2000, YBASE_NODE));
      this.linhaNode.setStroke((float)0.2);
      this.desenhaveis.add(linhaNode);
      
      this.linhaStruct = new Poligono();
      this.linhaStruct.add(new Point2D.Double(10, YBASE_STRUCT));
      this.linhaStruct.add(new Point2D.Double(2000, YBASE_STRUCT));
      this.linhaStruct.setStroke((float)0.2);
      this.desenhaveis.add(linhaStruct);
  }

  /*public static Quadro getInstance(){
      if(sc == null)
      	sc = new Quadro();
      return sc;
  }*/

  public synchronized void add(Poligono desenhavel){
		if(!this.desenhaveis.contains(desenhavel))
			this.desenhaveis.add(desenhavel);
  }

  public synchronized void remove(Poligono desenhavel){
  	if(this.desenhaveis.contains(desenhavel))
  		this.desenhaveis.remove(desenhavel);
  }

  public synchronized void add(Label texto){
	if(!this.textos.contains(texto))
            this.textos.add(texto);
  }

  public synchronized void remove(Label texto){
  	if(this.textos.contains(texto))
  		this.textos.remove(texto);
  }


  public void add(Elemento e){
  		List<Poligono> conteudo = e.getConteudo();
  		for(Poligono p : conteudo)
			this.add(p);

		List<Label> textos = e.getTextos();
		for(Label l : textos)
			this.add(l);

		List<Elemento> elementos = e.getElementos();
		for(Elemento el : elementos)
			this.add(el);
  }

  public void remove(Elemento e){
		List<Poligono> conteudo = e.getConteudo();
		for(Poligono p : conteudo)
			this.remove(p);

		List<Label> textos = e.getTextos();
		for(Label l : textos)
			this.remove(l);

		List<Elemento> elementos = e.getElementos();
		for(Elemento el : elementos)
			this.remove(el);
  }

  public void atualizar(){
  	this.repaint();
  }

  public void paintComponent(Graphics g) {
    synchronized(this){
    	clear(g);
    	Graphics2D g2d = (Graphics2D)g;

		for(Poligono pg : desenhaveis){
			Shape s = (Shape)pg.getPrint();
			g2d.setStroke (new BasicStroke(pg.getStroke()));
			g2d.setColor(pg.getStrokeColor());
                        g2d.draw(s);
			g2d.setColor(pg.getColor());
			//g2d.fill(s);
		}

		for(Label l : textos){
			g2d.setPaint(Color.black);
			Point2D p = l.getPoint();
                        if(p == null)
                            continue;
			Font f = l.getFont();

			if(f != null)
				g2d.setFont(f);
			else
				g2d.setFont(null);
			g2d.drawString(l.getText(), (float)p.getX(), (float)p.getY());
		}
	 }
  }

  // super.paintComponent clears offscreen pixmap,
  // since we're using double buffering by default.

  protected void clear(Graphics g) {
    super.paintComponent(g);
  }
  
  public void limpar(){
	  this.desenhaveis = new LinkedList<Poligono>();
	  this.textos = new LinkedList<Label>();
          
          this.desenhaveis.add(linhaNode);
          this.desenhaveis.add(linhaStruct);
  }
  
  static final int YBASE_TRABALHO = 190;
  static final int YBASE = 200;
  
  static final int YBASE_NODE = 115;
  static final int YBASE_STRUCT = 250;
}
