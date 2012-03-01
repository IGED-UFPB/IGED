package iged.grafico.struct;

import java.awt.geom.Point2D;

import iged.grafico.geometria.Poligono;
import iged.grafico.manager.PoligonoGrafico;

public class Seta extends Elemento{
    
        public static final int FRENTE = 0;
        public static final int ATRAS = 1;
        
        private int type;
        
	private Poligono ponta = null;
	private Poligono linha = null;

	public Seta(Point2D pi, Point2D pf, boolean agrupado, int t){
		this.agrupado = agrupado;
                this.type = t;

                
                double deltaX = pf.getX() - pi.getX();
                double deltaY = pf.getY() - pi.getY();

                if((deltaY == 0) && (deltaX < 0)){                       
                    linha = new Poligono();
                    linha.setType(PoligonoGrafico.CURVE);
                        
                    linha.add(pi);
                    linha.add(new Point2D.Double(pi.getX()+60, pi.getY()+100));
                    linha.add(new Point2D.Double(pf.getX()-60, pf.getY()+100));
                    linha.add(pf);
                }else{
                    
                    linha = new Poligono();
                    linha.add(pi);
                    linha.add(pf);
                }
                    
                this.conteudo.add(linha);
                
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

	public Seta(Point2D pi, Point2D pf, int type){
		this(pi, pf, true, type);
	}
        public Seta(Point2D pi, Point2D pf){
		this(pi, pf, Seta.FRENTE);
	}
        
        public Seta(Point2D pi, Point2D pf, boolean f){
		this(pi, pf, f, Seta.FRENTE);
	}
}