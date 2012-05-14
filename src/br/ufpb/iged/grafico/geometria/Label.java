
package br.ufpb.iged.grafico.geometria;

import java.awt.geom.Point2D;
import java.awt.*;

public class Label{
	private String text = null;
	private Font font = null;
	private Point2D pb = null;

	public Label(String t, Point2D p){
		this.text = t;
		this.pb = p;
                this.setFont(new Font("Serif", Font.PLAIN, 20));
	}

	public void setText(String t){
		this.text = t;
	}

	public String getText(){
		return this.text;
	}

	public void setFont(Font f){
		this.font = f;
	}

	public Font getFont(){
		return this.font;
	}

	public Point2D getPoint(){
		return this.pb;
	}
        
        

	public void setPoint(Point2D p){
		this.pb = p;
	}

	public void mover(double dx, double dy) {
		this.pb.setLocation(pb.getX() + dx, pb.getY() + dy);
	}

}