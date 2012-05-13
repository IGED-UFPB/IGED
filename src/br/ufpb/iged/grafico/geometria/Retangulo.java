package br.ufpb.iged.grafico.geometria;

import java.awt.geom.Point2D;
import java.awt.Color;

public class Retangulo extends Poligono{
	public int width = 0;
	public int height = 0;

	public Retangulo(Point2D pbase, int w, int h){
		this.width = w;
		this.height = h;

		double xb = (int)pbase.getX();
		double yb = (int)pbase.getY();

		this.add(pbase);
		this.add(new Point2D.Double(xb + w, yb));
		this.add(new Point2D.Double(xb + w, yb + h));
		this.add(new Point2D.Double(xb, yb + h));

	}
}