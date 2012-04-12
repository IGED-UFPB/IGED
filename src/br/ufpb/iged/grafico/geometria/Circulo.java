package br.ufpb.iged.grafico.geometria;

import java.awt.geom.Point2D;

public class Circulo extends Poligono{
	private Point2D pcenter = null;
	private int radius = 0;

	public Circulo(Point2D pc, int r){
		this.pcenter = pc;
		this.radius = r;

		this.createCirclePoints();
	}

	private void createCirclePoints(){
		for (int a = 0 ; a < 361 ; a++ ) {
			double aRad = a*(Math.PI/180);
			double x = pcenter.getX() + (this.radius * Math.cos(aRad));
			double y = pcenter.getY() + (this.radius * Math.sin(aRad));

			this.add(new Point2D.Double(x, y));
		}
	}

	public void mover(int dx, int dy, int t){
		pcenter.setLocation(pcenter.getX() + dx, pcenter.getY() + dy);

		//super.mover(dx, dy, t);
	}

	public void zoom(double z){
		if(z < 0)
			return;

		this.points.clear();
		this.radius *= z;

		this.createCirclePoints();
	}
}