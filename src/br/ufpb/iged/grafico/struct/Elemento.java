package br.ufpb.iged.grafico.struct;

import br.ufpb.iged.grafico.geometria.Poligono;
import br.ufpb.iged.grafico.geometria.Label;
import java.awt.geom.Point2D;
import java.util.*;

import br.ufpb.iged.grafico.manager.Quadro;
import java.util.concurrent.Semaphore;


public class Elemento {

    protected Quadro quadro;
    
    protected Point2D pb = null;
    protected List<Poligono> conteudo = new ArrayList<Poligono>();
    protected List<Label> textos = new ArrayList<Label>();
    protected List<Elemento> elementos = new ArrayList<Elemento>();
    protected boolean agrupado = false;
    private Semaphore sem = new Semaphore(0, true);

    public Elemento(Quadro q){
        this.quadro = q;
    }
    
    public void bloqueiaMovendo() {
        try {
            sem.acquire();
        } catch (InterruptedException ex) {
        }
    }
    
    public void liberaMovido(){
        sem.release();
    }
    
    public void initSemaphore(){
        try {
            this.sem.acquire(this.sem.availablePermits());
        } catch (InterruptedException ex) {
        }
    }

    public boolean estaAgrupado() {
        return agrupado;
    }

    public void setPoint(Point2D p) {
        this.pb = p;
    }

    public List<Poligono> getConteudo() {
        return this.conteudo;
    }

    public List<Label> getTextos() {
        return this.textos;
    }

    public List<Elemento> getElementos() {
        return this.elementos;
    }

    public boolean mover(Point2D pn) {
        double dx = pn.getX() - pb.getX();
        double dy = pn.getY() - pb.getY();
        if ((dx == 0) && (dy == 0)) {
            this.liberaMovido();
            return false;
        }

        this.setPoint(pn);
        this.mover(dx, dy, 1000);

        return true;
    }

    //Move o objeto usando o deslocamento dx, dy, no tempo t (em milissegundos)
    public void mover(final double dx, final double dy, final int t) {
        final Elemento e = this;
        new Thread() {

            public void run() {
                int sampleTime = (int) 1000 / 30;
                int samplerate = (int) t / sampleTime; //Quantidade de atualizacoes


                double x = dx / samplerate;
                double y = dy / samplerate;

                for (int i = 0; i < samplerate; ++i) {
                    try {
                        Thread.sleep(sampleTime);
                    } catch (Exception e) {
                    }

                    e.atualiza(x, y);

                    quadro.atualizar();
                }
                e.liberaMovido();
            }
        }.start();
    }

    protected void atualiza(double dx, double dy) {
        for (Poligono p : conteudo) {
            p.mover(dx, dy);
        }
        for (Label l : textos) {
            l.mover(dx, dy);
        }
        for (Elemento el : elementos) {
            if (el.estaAgrupado()) {
                el.atualiza(dx, dy);
            }
        }

    }
    
    public Point2D getPB(){
    	return this.pb;
    }
}