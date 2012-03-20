package iged.grafico.struct;

import iged.grafico.geometria.Retangulo;
import iged.grafico.geometria.Label;
import iged.grafico.manager.Quadro;
import java.awt.Color;
import java.awt.geom.Point2D;

public class VarInteiro extends Elemento{
	public boolean desenhado = true;
	Label valor = null;
	Retangulo r = null;
	Label nome = null;

	public VarInteiro(Point2D p, String n, Quadro q){
                super(q);
		this.pb = p;
		this.r = new Retangulo(p, LARGURA, LARGURA);
		this.conteudo.add(0, this.r);

		Point2D pl = new Point2D.Double(p.getX() + 20, p.getY() + 35 );
		this.valor = new Label("-", pl);

		this.textos.add(this.valor);

		Point2D pn = new Point2D.Double(p.getX() + LARGURA/2 - 4*n.length(), p.getY() +LARGURA+ 20);
		this.nome = new Label(n, pn);

		this.textos.add(this.nome);
	}

	public void ler(){
		this.r.evidencia(Color.blue, 4, quadro);
	}

	public void setValor(String t){
		this.valor.setText(t);
		this.r.evidencia(Color.red, 4, quadro);
	}

	public static final int LARGURA = 60;
}