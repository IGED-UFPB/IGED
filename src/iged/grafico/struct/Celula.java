package iged.grafico.struct;

import iged.grafico.geometria.Retangulo;
import iged.grafico.geometria.Label;
import java.awt.Color;
import java.awt.geom.Point2D;

public class Celula extends Elemento{
	Label valor = null;
	Retangulo r = null;
	Label indice = null;

	public Celula(Point2D p, int id){
		this.pb = p;
		this.r = new Retangulo(p, LARGURA, LARGURA);
		this.conteudo.add(this.r);

		Point2D pl = new Point2D.Double(p.getX() + 20, p.getY() + 35);
		this.valor = new Label("0", pl);

		this.textos.add(this.valor);

		Point2D pi = new Point2D.Double(p.getX() + LARGURA/2 - 5, p.getY() + LARGURA + 20);
		this.indice = new Label(String.valueOf(id), pi);

		this.textos.add(this.indice);
	}

	public void ler(){
		this.r.evidencia(Color.blue, 4);
	}

	public void escrever(String t){
		this.valor.setText(t);
		this.r.evidencia(Color.red, 4);
	}

	public static final int LARGURA = 60;
}