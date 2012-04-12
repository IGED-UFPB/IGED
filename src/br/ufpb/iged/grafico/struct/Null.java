package br.ufpb.iged.grafico.struct;

import java.awt.geom.Point2D;

import br.ufpb.iged.grafico.geometria.Poligono;
import br.ufpb.iged.grafico.manager.Quadro;

public class Null extends Elemento{
	private Poligono linha[] = new Poligono[5];

	public Null(Point2D pb, boolean agrupado, Quadro q){
            super(q);
		this.agrupado = agrupado;

		linha[0] = new Poligono();
		linha[0].add(pb);
		Point2D p1 = new Point2D.Double(pb.getX() + 50, pb.getY());
		linha[0].add(p1);
		this.conteudo.add(linha[0]);

		linha[1] = new Poligono();
		linha[1].add(p1);
		Point2D p2 = new Point2D.Double(p1.getX(), p1.getY() +15);
		linha[1].add(p2);
		this.conteudo.add(linha[1]);

		linha[2] = new Poligono();
		linha[2].add(new Point2D.Double(p2.getX() - 7, p2.getY()));
		linha[2].add(new Point2D.Double(p2.getX() + 7, p2.getY()));
		this.conteudo.add(linha[2]);

		linha[3] = new Poligono();
		linha[3].add(new Point2D.Double(p2.getX() - 3.5, p2.getY() +3));
		linha[3].add(new Point2D.Double(p2.getX() + 3.5, p2.getY() +3));
		this.conteudo.add(linha[3]);

	}

	public Null(Point2D pb, Quadro q){
		this(pb, true, q);
	}
}