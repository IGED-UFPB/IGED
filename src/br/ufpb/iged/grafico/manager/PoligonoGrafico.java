package br.ufpb.iged.grafico.manager;

import java.awt.Color;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.util.LinkedList;
import java.awt.geom.Point2D;

public class PoligonoGrafico{
	
        public static final int LINEAR = 0;
        public static final int CURVE = 1;
    
        protected java.util.List<Point2D> points = null;
	protected Color color = Color.white;
	protected float stroke = 2;
	protected Color strokeColor = Color.black;
        
        int type;

	public PoligonoGrafico(){
		this.points = new LinkedList<Point2D>();
                type = LINEAR;
	}

        //adiciona um poligono já constuido
        public void setType(int t){
            this.type = t;
        }
        
	//Adiciona um vertice do poligono
	public void add(Point2D p){
		this.points.add(p);
	}

	//Adciona todos os pontos da List
	public void addAll(java.util.List<Point2D> ps){
		this.points.addAll(ps);
	}

	//Limpa todos os pontos do desenho.
	public void clearPoints(){
		this.points.clear();
	}

	public Color getColor(){
		return this.color;
	}
	public void setColor(Color c){
		this.color = c;
	}

	public Color getStrokeColor(){
		return this.strokeColor;
	}
	public void setStrokeColor(Color c){
		this.strokeColor = c;
	}

	public float getStroke(){
		return this.stroke;
	}
	public void setStroke(float st){
		this.stroke = st;
	}

	public Object getPrint(){		               
                if(type == LINEAR){
                    GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
			                                              this.points.size());
                
                    Point2D pto = this.points.get(0);
                    polygon.moveTo(pto.getX(), pto.getY());
                    for ( int index = 1; index < this.points.size(); index++ ) {
                        pto = this.points.get(index);
                        polygon.lineTo(pto.getX(), pto.getY());
                    }
                
                    polygon.closePath();
                    return polygon;
                }else{
                    
                    CubicCurve2D c = new CubicCurve2D.Double();
                    // Define suas coordenadas e a desenha
                    
                    Point2D p0 = this.points.get(0);
                    Point2D p1 = this.points.get(1);
                    Point2D p2 = this.points.get(2);
                    Point2D p3 = this.points.get(3);
                    
                    c.setCurve(p0.getX(), p0.getY(), p1.getX(), p1.getY(),
                               p2.getX(), p2.getY(), p3.getX(), p3.getY());
                    
                    return c;
                    
                    /*polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 3);
                    
                    Point2D pto = this.points.get(0);
                    polygon.moveTo(pto.getX(), pto.getY());
                    pto = this.points.get(1);
                    polygon.lineTo(pto.getX(), pto.getY());
                    
                    
                    
                    polygon.curveTo(p1.getX(), p1.getY(),
                                    p2.getX(), p2.getY(),
                                    p3.getX(), p3.getY());
                    */
                    //polygon
                }
                
                //return polygon;
	}

	public Point2D getBasePoint(){
		return this.points.get(0);
	}

}