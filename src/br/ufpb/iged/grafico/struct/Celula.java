package br.ufpb.iged.grafico.struct;

import br.ufpb.iged.IGEDConst;
import br.ufpb.iged.grafico.geometria.Retangulo;
import br.ufpb.iged.grafico.geometria.Label;
import br.ufpb.iged.grafico.manager.Quadro;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Point2D;

public class Celula extends Elemento{
	Label valor = null;
	Retangulo r = null;
	Label indice = null;

	public Celula(Point2D p, int id, Quadro q){
		this(p,id,q,IGEDConst.VETOR);
	}
	
	public Celula(Point2D p, int id, Quadro q,int typeVector){
                super(q);
		this.pb = p;
		this.r = new Retangulo(p, LARGURA, (typeVector==IGEDConst.VECTOR_ADJACENCY_LIST)?HEIGHT:LARGURA);
		this.conteudo.add(this.r);

		Point2D pl = new Point2D.Double(pb.getX() + 20, pb.getY() + ((typeVector==IGEDConst.VECTOR_ADJACENCY_LIST)?50:35));
		this.valor = new Label("0", pl);

		this.textos.add(this.valor);

		Point2D pi = getIndexPosition(typeVector);
		this.indice = new Label(String.valueOf(id), pi);
                this.indice.setFont(new Font("Serif", Font.PLAIN, 12));

		this.textos.add(this.indice);
	}
	
	private Point2D getIndexPosition(int typeVector){
		switch(typeVector){
			case IGEDConst.VECTOR_ADJACENCY_LIST:
				return new Point2D.Double(pb.getX() - 15, pb.getY()+ (HEIGHT/2) + 5);
			case IGEDConst.VETOR:
				return new Point2D.Double(pb.getX() + LARGURA/2 - 5, pb.getY() + LARGURA + 20);
		default:
			return null;
		}
		
	}

	public void ler(){
		this.r.evidencia(Color.blue, 4, quadro);
	}

	public void escrever(String t){
		this.valor.setText(t);
		this.r.evidencia(Color.red, 4, quadro);
	}

	public static final int HEIGHT = 80;
	public static final int LARGURA = 60;
}