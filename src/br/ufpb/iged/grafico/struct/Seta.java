package br.ufpb.iged.grafico.struct;

import java.awt.geom.Point2D;

import br.ufpb.iged.grafico.geometria.Poligono;
import br.ufpb.iged.grafico.manager.PoligonoGrafico;
import br.ufpb.iged.grafico.manager.Quadro;

public class Seta extends Traco{
    
        public static final int FRENTE = 0;
        public static final int ATRAS = 1;
        
        private int type;
        
	private Poligono ponta = null;

	public Seta(Point2D pi, Point2D pf, boolean agrupado, int t, Quadro q){
		super(pi,pf,agrupado,t, q);
                this.type = t;
               
                if(type == Seta.FRENTE){
                
                    double h = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
                    double sen = deltaX / h;
                    double cos = deltaY / h;

                    double dx = 5 * sen;
                    double dy = 5 * cos;

                    ponta = new Poligono();
                    ponta.add(new Point2D.Double(pf.getX() - dy, pf.getY() + dx));
                    ponta.add(new Point2D.Double(pf.getX() + dy, pf.getY() - dx));
                    ponta.add(new Point2D.Double(pf.getX() + 8 * sen, pf.getY() + 8 * cos));
                    this.conteudo.add(ponta);
                }
                
	}

	public Seta(Point2D pi, Point2D pf, int type, Quadro q){
		this(pi, pf, true, type, q);
	}
        

	public Seta(Point2D pi, Point2D pf, Quadro q){
		this(pi, pf, Seta.FRENTE, q);
	}
        
        
	public Seta(Point2D pi, Point2D pf, boolean f, Quadro q){
		this(pi, pf, f, Seta.FRENTE, q);
	}
        
        
	public void setPoints(Point2D pi, Point2D pf){
        	super.setPoints(pi, pf);
                
                if(type == Seta.FRENTE){
                
                    double h = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
                    double sen = deltaX / h;
                    double cos = deltaY / h;

                    double dx = 5 * sen;
                    double dy = 5 * cos;

                    ponta.clearPoints();
                    ponta.add(new Point2D.Double(pf.getX() - dy, pf.getY() + dx));
                    ponta.add(new Point2D.Double(pf.getX() + dy, pf.getY() - dx));
                    ponta.add(new Point2D.Double(pf.getX() + 8 * sen, pf.getY() + 8 * cos));
                }
	}
        
}