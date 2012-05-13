package br.ufpb.iged.grafico.manager;

public interface AcaoUsuario{
	public abstract void init();
	public abstract void color();
	public abstract void move();
	public abstract void zoom();
	public abstract Quadro getQuadro();

}