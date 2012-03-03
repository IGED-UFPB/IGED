package iged.grafico.struct;

import iged.grafico.geometria.Label;
import java.awt.geom.Point2D;

import iged.grafico.manager.Quadro;

public class Referencia extends Elemento {

    private Struct node = null;
    Label label = null;
    private Seta ref = null;
    private boolean fixa = false;

    public Referencia(Node n, String nome) {
        Point2D pn = n.add(this);
        this.setPoint(pn);


        label = new Label(nome, new Point2D.Double((pb.getX() - 4 * nome.length()), (pb.getY() - 3)));
        this.textos.add(label);
        Point2D pf = new Point2D.Double(n.getPointPI().getX(), n.getPointPI().getY() - 10);

        ref = new Seta(this.pb, pf);
        this.elementos.add(ref);

        this.setRef(n);
    }

    public Referencia(Node n, String nome, Point2D p) {
        this.fixa = true;
        Point2D pn = n.add(this);
        this.setPoint(p);


        label = new Label(nome, new Point2D.Double((pb.getX() - 4 * nome.length()), (pb.getY() - 3)));
        this.textos.add(label);

        Point2D pf = new Point2D.Double(n.getPInit().getX(), n.getPInit().getY());

        ref = new Seta(this.pb, pf);
        this.elementos.add(ref);

        this.setRef(n);
    }

    public Referencia(Point2D pn, String nome, boolean fixa) {
        this.fixa = fixa;
        this.setPoint(pn);
        label = new Label(nome, pn);


        this.textos.add(label);
        Quadro.getInstance();
    }

    public Referencia(Point2D pn, String nome) {
        this.setPoint(pn);
        label = new Label(nome + ";", pn);

        this.textos.add(label);
        Quadro.getInstance();
    }

    public void config(Node n) {

        Point2D pn = n.add(this);
        this.setPoint(pn);


        label.setPoint(new Point2D.Double((pb.getX() - 5), (pb.getY() - 3)));


        Point2D pf = new Point2D.Double(n.getPointPI().getX(), n.getPointPI().getY() - 10);
        if (ref != null) {
            ref.setPoints(this.pb, pf);
            //Quadro.getInstance().remove(ref);
            //this.elementos.remove(ref);
        } else {
            ref = new Seta(this.pb, pf);
            this.elementos.add(ref);
            Quadro.getInstance().add(ref);
        }

    }

    protected void atualiza(double dx, double dy) {
        if (this.isFixa()) {
            if (ref != null) {
                //ref.atualiza(dx, dy);
                //this.label.mover(dx, dy);
                ref.setPoints(this.pb, node.getPointPI());
            }else{
                ref = new Seta(this.pb, node.getPointPI());
                Quadro.getInstance().add(ref);
            }

        } else {
            this.label.mover(dx, dy);
            this.ref.atualiza(dx, dy);

        }
    }
    
    

    public Struct getNode() {
        return node;
    }
    public void setNode(Struct s) {
        this.node = s;
    }
    
    public boolean isFixa() {
        return fixa;
    }

    public void setFixa(boolean fixa) {
        this.fixa = fixa;
    }

    public void setRef(Node n) {
        if (this.node == null) {
            this.textos.add(label);
            this.elementos.add(ref);
        } else {
            this.elementos.remove(ref);
            Quadro.getInstance().remove(ref);
            node.remove(this);
            if (n != null) {
                this.config(n);
            }
        }
        this.node = n;
        Quadro.getInstance();
    }
}