package iged.grafico.struct;

import iged.grafico.geometria.Poligono;
import iged.grafico.geometria.Label;
import java.awt.geom.Point2D;
import java.util.*;

import iged.grafico.manager.Quadro;

public class Elemento{
	protected Point2D pb = null;
	protected List<Poligono> conteudo = new ArrayList<Poligono>();
	protected List<Label> textos = new ArrayList<Label>();
	protected List<Elemento> elementos = new ArrayList<Elemento>();

	protected boolean agrupado = false;

	public boolean estaAgrupado(){
		return agrupado;
	}

	public void setPoint(Point2D p){
		this.pb = p;
	}

	public List<Poligono> getConteudo(){
		return this.conteudo;
	}

	public List<Label> getTextos(){
		return this.textos;
	}

	public List<Elemento> getElementos(){
		return this.elementos;
	}

	public boolean  mover(Point2D pn){
		double dx = pn.getX() - pb.getX();
		double dy = pn.getY() - pb.getY();
		if((dx == 0) && (dy == 0))
			return false;

		this.setPoint(pn);
		this.mover(dx, dy, 1000);
		
		return  true;
	}

	//Move o objeto usando o deslocamento dx, dy, no tempo t (em milissegundos)
	public void mover(final double dx, final double dy, final int t) {
		final Elemento e = this;
		new Thread(){
			public void run(){
				int sampleTime = (int)1000/30;
				int samplerate = (int)t / sampleTime; //Quantidade de atualizacoes


				double x = dx / samplerate;
				double y = dy / samplerate;
				
				for(int i=0; i<samplerate; ++i){
					try{
						Thread.sleep(sampleTime);
					}catch(Exception e){}

					e.atualiza(x, y);

					Quadro.getInstance().atualizar();
				}
			}
			
		}.start();
	}

	protected void atualiza(double dx, double dy){
		for(Poligono p : conteudo)
			p.mover(dx, dy);
		for(Label l : textos)
			l.mover(dx, dy);
		for(Elemento el : elementos){
			if(el.estaAgrupado())
				el.atualiza(dx, dy);
		}

	}

}