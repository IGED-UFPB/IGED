/**
 * 
 */
package br.ufpb.iged.grafico.struct;

import br.ufpb.iged.grafico.geometria.Poligono;
import br.ufpb.iged.grafico.manager.PoligonoGrafico;

import br.ufpb.iged.grafico.manager.Quadro;
import java.awt.geom.Point2D;

/**
 * @author Smith
 *
 */
public class Traco extends Elemento {
    
	double deltaX;
    double deltaY;
    
	private Poligono linha = null;

	public Traco(Point2D pi, Point2D pf, boolean agrupado, Quadro q){
            super(q);
            this.agrupado = agrupado;

            this.deltaX = pf.getX() - pi.getX();
            this.deltaY = pf.getY() - pi.getY();

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
            
        
	}

	
	public Traco(Point2D pi, Point2D pf, boolean f,int t, Quadro q){
		this(pi, pf, f, q);
	}
    
    public void setPoints(Point2D pi, Point2D pf){

           	this.deltaX = pf.getX() - pi.getX();
            this.deltaY = pf.getY() - pi.getY();

            linha.clearPoints();
            if((deltaY == 0) && (deltaX < 0)){                       
                linha.setType(PoligonoGrafico.CURVE);
                    
                linha.add(pi);
                linha.add(new Point2D.Double(pi.getX()+60, pi.getY()+100));
                linha.add(new Point2D.Double(pf.getX()-60, pf.getY()+100));
                linha.add(pf);
            }else{
                linha.add(pi);
                linha.add(pf);
            }
                

    }

	
	

}
