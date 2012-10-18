package br.ufpb.iged.grafico.struct;

import br.ufpb.iged.IGEDConst;
import java.awt.geom.Point2D;
import java.util.*;

import br.ufpb.iged.grafico.geometria.Label;
import br.ufpb.iged.grafico.manager.Quadro;

public class VetorAdjacencyList extends Struct {

    private static int bond = 100;
    private static int x = 60;
    private Label nome = null;
    private List<Celula> celulas = null;
    private int size = 10;

    public VetorAdjacencyList(int yBase, Quadro q) {
        super(q);
        this.type = IGEDConst.VETOR;
        this.pb = new Point2D.Double(x, yBase + 80);
        this.pi = new Point2D.Double(pb.getX() - 10, pb.getY() - 5);
    }

    public void setNome(String nome) {
        if (this.nome != null) {
            this.nome.setText(nome);
            //Quadro.getInstance().remove(this.nome);
        } else {
            this.nome = new Label(nome, this.pi);
            this.textos.add(this.nome);
        }
    }

    public void setSize(int size) {
        if (size > 0) {
            this.size = size;
        }
    }

    public void ler(int pos) {
        if (pos >= celulas.size()) {
            return;
        }
        this.celulas.get(pos).ler();
    }

    public void escrever(int pos, String valor) {
        if (pos >= celulas.size()) {
            return;
        }
        this.celulas.get(pos).escrever(valor);
    }

    @Override
    public int getBond() {
        return VetorAdjacencyList.bond;
    }

    @Override
    public Point2D getPInit() {
        return this.pb;
    }

    @Override
    public void repintar() {
        if (this.celulas == null) {
            this.celulas = new ArrayList<Celula>(size);
            for (int i = 0; i < size; ++i) {
                Point2D pc = new Point2D.Double(pb.getX(), pb.getY()+ i * (Celula.HEIGHT + 2));
                Celula c = new Celula(pc, i, quadro,IGEDConst.VECTOR_ADJACENCY_LIST);
                this.celulas.add(c);
                this.elementos.add(c);
            }
        }

        quadro.add(this);
    }

    @Override
    public Struct readField(int field) {
        return null;
    }

    @Override
    public void writeField(Struct s, int field) {
    }

    @Override
    public String readInfo() {
        return null;
    }

    @Override
    public void writeInfo(String value) {
    }

    @Override
    public boolean isRepintado() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void startRepaint() {
        // TODO Auto-generated method stub
    }

    @Override
    public void add(String referencia) {
        //Referencia reff = new Referencia(null, referencia, true);
        //this.add(reff);
        //reff.setNode(this);
        
        //super.add(reff);
        
        this.addReference(referencia);
        this.setNome(this.getNameReferencia());
    }

    public void remove(String ref) {
        this.removeReference(ref);
        this.setNome(this.getNameReferencia());
    }
}