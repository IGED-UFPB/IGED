<<<<<<< HEAD
package br.ufpb.iged.grafico.struct;

import br.ufpb.iged.IGEDConst;
import br.ufpb.iged.grafico.geometria.Retangulo;
import br.ufpb.iged.grafico.geometria.Label;
import java.awt.geom.Point2D;
import java.awt.Color;

import br.ufpb.iged.grafico.manager.Quadro;
import java.util.concurrent.Semaphore;

public class LinkedListNode extends Node {
    
    private LinkedListNode prox = null;
    private Point2D pp = null;
    private Retangulo rect = null;
    private Retangulo rectP = null;
    private Label valor = null;
    private Elemento next = null;

    public LinkedListNode(Point2D p, Quadro q) {
        super(q);
        this.type = IGEDConst.NODE;
        this.pp = new Point2D.Double();
        this.pi = new Point2D.Double();
        this.pr = new Point2D.Double();

        this.setPoint(p);

        rect = new Retangulo(new Point2D.Double(pb.getX() - 50, pb.getY() - 30), 100, 60);
        this.conteudo.add(rect);

        rectP = new Retangulo(new Point2D.Double(pb.getX() + 10, pb.getY() - 30), 40, 60);
        this.conteudo.add(rectP);

        valor = new Label("-", new Point2D.Double(pb.getX() - 25, pb.getY() + 10));
        this.textos.add(valor);

    }

    public Point2D getPointPB() {
        return this.pb;
    }

    public void setValue(String v) {
        this.valor.setText(v);
        this.rect.evidencia(Color.red, 4, quadro);
        this.rectP.evidencia(Color.red, 4, quadro);
    }

    public void setPoint(Point2D p) {
        super.setPoint(p);
        pp.setLocation(pb.getX() + 30, pb.getY());
        pi.setLocation(pb.getX() - 55, pb.getY());
        pr.setLocation(pb.getX() - 70, pb.getY() - 45);
    }

    public void clearNext() {
        if (next != null) {
            System.out.println("NODE: clear next");
            this.elementos.remove(next);
            quadro.remove(next);
            next = null;
            prox = null;
        }

    }

    public void setNext(LinkedListNode n) {
        if (n == null) {
            this.setNextNull();
            return;
        }
        if (next != null) {
            this.clearNext();
        }
        prox = n;
        next = new Seta(this.pp, n.getPointPI(), false, quadro);
        this.elementos.add(next);
        quadro.add(next);
        quadro.atualizar();
    }

    public void setNextNull() {
        if (next != null) {
            this.clearNext();
        }

        prox = null;
        next = new Null(this.pp, false, quadro);
        this.elementos.add(next);
        quadro.add(next);
        quadro.atualizar();
    }

    @Override
    public Point2D add(Referencia ref) {
        super.add(ref);
        return new Point2D.Double(this.pr.getX(), (this.pr.getY() - (15 * this.numRef)));
    }
    
    /*public void remove(String ref) {
        for (Referencia refe : this.referencias) {
            if (refe.getTextos().contains(ref)) {
                this.remove(refe);
                break;
            }
        }
    }*/

    //public boolean isAjustado = false;

    public synchronized void adjust(final Point2D p, final Semaphore semLista) {

        if (this.ajustado) {
            System.out.println("Node Ajustado");
            return;
        }
        //this.repintado = true;

        final LinkedListNode n = this;

        new Thread() {

            public void run() {
                //n.repintar();
                
                n.mover(p);
                n.ajustado = true;
                System.out.println("Node vai mover!");
                    n.bloqueiaMovendo();
                    System.out.println("Node n movido!");
                    //semLista.release();

                if (n.prox != null) {
                    System.out.println("n.prox != null");
                    if (n.prox.ajustado) {
                        n.setNext(n.prox);
                        semLista.release();
                        return;
                    }
                    Point2D pprox = new Point2D.Double((p.getX() + 150), p.getY());
                    n.prox.adjust(pprox, semLista);
                    
                    //n.prox.repintar();
                    n.prox.mover(pprox);
                    n.prox.ajustado = true;
                    n.setNext(n.prox);
                    semLista.release();
                    
                    //n.prox.repintado = true;
                    //n.prox.bloqueiaMovendo();
                    //System.out.println("Node prox movido!");
                    //semLista.release();
                    return;
                } else {
                    System.out.println("n.prox == null");
                    n.setNext(null);
                    semLista.release();
                    //return;
                }
            }
        }.start();

    }

    public LinkedListNode getProx() {
        return prox;
    }

    public void setProx(LinkedListNode prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "Node " + this.valor.getText();
    }

    @Override
    public Point2D getPInit() {
        return this.pi;
    }

    @Override
    public void repintar() {
        if (!this.repintado) {

            quadro.add(this);
            this.repintado = true;
            if (this.prox != null && !this.prox.isRepintado()) {
                this.prox.repintar();
            }

        }
    }

    @Override
    public Struct readField(int field) {
        switch (field) {
            case IGEDConst.NODE_PROX:
                return this.prox;

            default:
                return null;
        }
    }

    @Override
    public void writeField(Struct s, int field) {
        switch (field) {
            case IGEDConst.NODE_PROX:
                this.setNext(((LinkedListNode) s));
                break;
            default:
                break;
        }

    }

    @Override
    public String readInfo() {
        return this.valor.getText();
    }

    @Override
    public void writeInfo(String value) {
        this.valor.setText(value);
        this.repintar();
    }

    @Override
    public int getBond() {
        return 0;
    }

    @Override
    public void startRepaint() {
        if(!this.isRepintado())
            return;
        super.startRepaint();
        //this.repintado = false;
        //this.ajustado = false;
        if (this.prox != null){
            this.prox.startRepaint(); //, fiz isso para nao dar estouro de pilha
            /*LinkedListNode p = this.prox;
            while (p != null) {
                //p.repintado = false;
                //p.ajustado = false;

                p = p.getProx();
                if (p == null || !p.isRepintado()) {
                    break;
                }
            }*/
        }
    }
=======
package br.ufpb.iged.grafico.struct;

import br.ufpb.iged.IGEDConst;
import br.ufpb.iged.grafico.geometria.Retangulo;
import br.ufpb.iged.grafico.geometria.Label;
import java.awt.geom.Point2D;
import java.awt.Color;

import br.ufpb.iged.grafico.manager.Quadro;
import java.util.concurrent.Semaphore;

public class LinkedListNode extends Node {
    
    private LinkedListNode prox = null;
    private Point2D pp = null;
    private Retangulo rect = null;
    private Retangulo rectP = null;
    private Label valor = null;
    private Elemento next = null;

    public LinkedListNode(Point2D p, Quadro q) {
        super(q);
        this.type = IGEDConst.NODE;
        this.pp = new Point2D.Double();
        this.pi = new Point2D.Double();
        this.pr = new Point2D.Double();

        this.setPoint(p);

        rect = new Retangulo(new Point2D.Double(pb.getX() - 50, pb.getY() - 30), 100, 60);
        this.conteudo.add(rect);

        rectP = new Retangulo(new Point2D.Double(pb.getX() + 10, pb.getY() - 30), 40, 60);
        this.conteudo.add(rectP);

        valor = new Label("-", new Point2D.Double(pb.getX() - 25, pb.getY() + 10));
        this.textos.add(valor);

    }

    public Point2D getPointPB() {
        return this.pb;
    }

    public void setValue(String v) {
        this.valor.setText(v);
        this.rect.evidencia(Color.red, 4, quadro);
        this.rectP.evidencia(Color.red, 4, quadro);
    }

    public void setPoint(Point2D p) {
        super.setPoint(p);
        pp.setLocation(pb.getX() + 30, pb.getY());
        pi.setLocation(pb.getX() - 55, pb.getY());
        pr.setLocation(pb.getX() - 70, pb.getY() - 45);
    }

    public void clearNext() {
        if (next != null) {
            System.out.println("NODE: clear next");
            this.elementos.remove(next);
            quadro.remove(next);
            next = null;
            prox = null;
        }

    }

    public void setNext(LinkedListNode n) {
        if (n == null) {
            this.setNextNull();
            return;
        }
        if (next != null) {
            this.clearNext();
        }
        prox = n;
        next = new Seta(this.pp, n.getPointPI(), false, quadro);
        this.elementos.add(next);
        quadro.add(next);
        quadro.atualizar();
    }

    public void setNextNull() {
        if (next != null) {
            this.clearNext();
        }

        prox = null;
        next = new Null(this.pp, false, quadro);
        this.elementos.add(next);
        quadro.add(next);
        quadro.atualizar();
    }

    @Override
    public Point2D add(Referencia ref) {
        super.add(ref);
        return new Point2D.Double(this.pr.getX(), (this.pr.getY() - (15 * this.numRef)));
    }
    
    /*public void remove(String ref) {
        for (Referencia refe : this.referencias) {
            if (refe.getTextos().contains(ref)) {
                this.remove(refe);
                break;
            }
        }
    }*/

    //public boolean isAjustado = false;

    public synchronized void adjust(final Point2D p, final Semaphore semLista) {

        if (this.ajustado) {
            System.out.println("Node Ajustado");
            return;
        }
        //this.repintado = true;

        final LinkedListNode n = this;

        new Thread() {

            public void run() {
                //n.repintar();
                
                n.mover(p);
                n.ajustado = true;
                System.out.println("Node vai mover!");
                    n.bloqueiaMovendo();
                    System.out.println("Node n movido!");
                    //semLista.release();

                if (n.prox != null) {
                    System.out.println("n.prox != null");
                    if (n.prox.ajustado) {
                        n.setNext(n.prox);
                        semLista.release();
                        return;
                    }
                    Point2D pprox = new Point2D.Double((p.getX() + 150), p.getY());
                    n.prox.adjust(pprox, semLista);
                    
                    //n.prox.repintar();
                    n.prox.mover(pprox);
                    n.prox.ajustado = true;
                    n.setNext(n.prox);
                    semLista.release();
                    
                    //n.prox.repintado = true;
                    //n.prox.bloqueiaMovendo();
                    //System.out.println("Node prox movido!");
                    //semLista.release();
                    return;
                } else {
                    System.out.println("n.prox == null");
                    n.setNext(null);
                    semLista.release();
                    //return;
                }
            }
        }.start();

    }

    public LinkedListNode getProx() {
        return prox;
    }

    public void setProx(LinkedListNode prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return "Node " + this.valor.getText();
    }

    @Override
    public Point2D getPInit() {
        return this.pi;
    }

    @Override
    public void repintar() {
        if (!this.repintado) {

            quadro.add(this);
            this.repintado = true;
            if (this.prox != null && !this.prox.isRepintado()) {
                this.prox.repintar();
            }

        }
    }

    @Override
    public Struct readField(int field) {
        switch (field) {
            case IGEDConst.NODE_PROX:
                return this.prox;

            default:
                return null;
        }
    }

    @Override
    public void writeField(Struct s, int field) {
        switch (field) {
            case IGEDConst.NODE_PROX:
                this.setNext(((LinkedListNode) s));
                break;
            default:
                break;
        }

    }

    @Override
    public String readInfo() {
        return this.valor.getText();
    }

    @Override
    public void writeInfo(String value) {
        this.valor.setText(value);
        this.repintar();
    }

    @Override
    public int getBond() {
        return 0;
    }

    @Override
    public void startRepaint() {
        if(!this.isRepintado())
            return;
        super.startRepaint();
        //this.repintado = false;
        //this.ajustado = false;
        if (this.prox != null){
            this.prox.startRepaint(); //, fiz isso para nao dar estouro de pilha
            /*LinkedListNode p = this.prox;
            while (p != null) {
                //p.repintado = false;
                //p.ajustado = false;

                p = p.getProx();
                if (p == null || !p.isRepintado()) {
                    break;
                }
            }*/
        }
    }
>>>>>>> 9aedc6753128e3a6a1af6db5fd1d6cd07efa304b
}