package iged.grafico.struct;

import iged.IGEDConst;
import iged.grafico.geometria.Retangulo;
import iged.grafico.geometria.Label;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.util.*;

import iged.grafico.manager.Quadro;

public class LinkedListNode extends Elemento implements Node {

    public boolean repintado = false;
    private LinkedListNode prox = null;
    private List<Referencia> referencias = new ArrayList<Referencia>();
    private int numRef = -1;
    private Point2D pp = null;
    private Point2D pi = null;
    private Point2D pr = null;
    private Retangulo rect = null;
    private Retangulo rectP = null;
    private Label valor = null;
    private Elemento next = null;

    public LinkedListNode(Point2D p) {
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

    public Point2D getPointPI() {
        return this.pi;
    }

    public Point2D getPointPB() {
        return this.pb;
    }

    public void setValue(String v) {
        this.valor.setText(v);
        this.rect.evidencia(Color.red, 4);
        this.rectP.evidencia(Color.red, 4);
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
            Quadro.getInstance().remove(next);
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
        next = new Seta(this.pp, n.getPointPI(), false);
        this.elementos.add(next);
        Quadro.getInstance().add(next);
        Quadro.getInstance().atualizar();
    }

    public void setNextNull() {
        if (next != null) {
            this.clearNext();
        }

        prox = null;
        next = new Null(this.pp, false);
        this.elementos.add(next);
        Quadro.getInstance().add(next);
        Quadro.getInstance().atualizar();
    }

    public Point2D add(Referencia ref) {
        if (!this.referencias.contains(ref)) {
            this.referencias.add(ref);

        }
        if (!ref.isFixa()) {

            ++this.numRef;
        }
        return new Point2D.Double(this.pr.getX(), (this.pr.getY() - (15 * numRef)));
    }

    public void remove(Referencia ref) {
        if (this.referencias.contains(ref)) {
            int j = this.referencias.indexOf(ref);
            this.numRef = j - 1;
            this.referencias.remove(ref);

            for (int i = j; i < this.referencias.size(); ++i) {
                this.referencias.get(i).config(this);
            }
        }
    }

    public void remove(String ref) {
        for (Referencia refe : this.referencias) {
            if (refe.getTextos().contains(ref)) {
                this.remove(refe);
                break;
            }
        }
    }

    public void mover(final double dx, final double dy, final int t) {

        super.mover(dx, dy, t);

        for (Referencia r : this.referencias) {
            r.mover(dx, dy, t);
        }

    }
    public boolean isAjustado = false;

    public synchronized void adjust(final Point2D p) {

        if (isAjustado) {
            return;
        }
        isAjustado = true;

        final LinkedListNode n = this;


        new Thread() {

            public void run() {
                if (n.mover(p)) {
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                }


                if (n.prox != null) {
                    if (n.prox.isAjustado) {
                        n.setNext(n.prox);
                        return;
                    }
                    Point2D pprox = new Point2D.Double((p.getX() + 150), p.getY());

                    n.prox.mover(pprox);

                    n.setNext(n.prox);
                    n.prox.adjust(pprox);
                    n.prox.isAjustado = true;
                } else {
                    n.setNext(null);
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

            Quadro.getInstance().add(this);
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

    public void setRepintado(boolean state){
        this.repintado = state;
    }
    
    @Override
    public boolean isRepintado() {
        return this.repintado;

    }

    @Override
    public void startRepaint() {
        this.repintado = false;
        this.isAjustado = false;
        if (this.prox != null) {
            //this.prox.startRepaint(); , fiz isso para nao dar estouro de pilha
            LinkedListNode p = this.prox;
            while (p != null) {
                p.repintado = false;
                p.isAjustado = false;

                p = p.getProx();
                if (p == null || p.equals(this)) {
                    break;
                }
            }
        }
    }
}