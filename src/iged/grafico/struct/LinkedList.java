package iged.grafico.struct;

import iged.IGEDConst;
import java.awt.geom.Point2D;

import iged.grafico.geometria.Label;
import iged.grafico.manager.Quadro;
import java.util.concurrent.Semaphore;

public class LinkedList extends Struct {

    private int bond = 100;
    private String referencia;
    private String tamanho = "0";
    private Label l;
    private VarInteiro tam = null;
    private LinkedListNode ini = null;
    private int yBase = 0;
    private int espaco = 85;
    private Null n;

    public LinkedList(Quadro q){
        super(q);
        this.type = IGEDConst.LISTA;
    }
    
    public void desenhar(int yBase) {
        this.yBase = yBase;

        if (this.ini == null) {
            // desenhar lista vazia "referencia solta"
            if (n == null) {
                this.ref = new Referencia(new Point2D.Double(60, yBase + espaco
                        + 10), referencia + ".inicio", true, quadro);

                n = new Null(new Point2D.Double(
                        120 + (7 * referencia.length()), yBase + espaco + 5),
                        true, quadro);// apontando para null
                quadro.add(n);
                quadro.add(ref);
                quadro.atualizar();
            } else {
                quadro.remove(ref);
                quadro.remove(n);
                this.ref = new Referencia(new Point2D.Double(60, yBase + espaco
                        + 10), referencia + ".inicio", true, quadro);// apontando para
                // null
                n = new Null(new Point2D.Double(
                        120 + (7 * referencia.length()), yBase + espaco + 5),
                        true, quadro);
                quadro.add(n);
                quadro.add(ref);
                quadro.atualizar();
            }
        } else {

            if (n != null) {
                quadro.remove(n);
                n = null;
            }
            if (ref != null) {
                quadro.remove(ref);
                ini.remove(ref);
            }

            ref = new Referencia(ini, referencia + ".inicio",
                    new Point2D.Double(60, yBase + espaco + 10), quadro);
            ref.setFixa(true);

            quadro.add(ref);
            quadro.atualizar();
        }
        if (tam != null) {
            quadro.remove(tam);
            quadro.add(tam);
        } else {
            tam = new VarInteiro(new Point2D.Double(30, yBase + 100), "tamanho", quadro);
            tam.setValor(tamanho);
            quadro.add(tam);
        }
        quadro.atualizar();
    }

    public void setyBase(int yBase) {
        this.yBase = yBase;
    }

    public void setBond(int bond) {
        this.bond = bond;
    }

    @Override
    public int getBond() {
        return this.bond;
    }

    public String getReferencia() {
        return referencia;
    }
    @Override
    public void add(String referencia) {
        //Referencia reff = new Referencia(null, referencia, true);
        this.addReference(referencia);
        //reff.setNode(this);
        //super.add(reff);
        
        this.referencia = this.getNameReferencia();
        if(this.ref != null){
            this.ref.label.setText(this.referencia + ".inicio");
        }else
            this.desenhar(yBase);
    }
    
    @Override
     public void removeReference(String ref) {
        super.removeReference(ref);
        
        if(this.referenciasS.isEmpty()){
            if (this.ini != null) {
                this.ini.remove(this.ref);
            }else{
                quadro.remove(this.ref);
            }
        }else{
            this.referencia = this.getNameReferencia();
            if(this.ref != null){
                this.ref.label.setText(this.referencia + ".inicio");
            }
        }
    }

    public LinkedListNode getInit() {
        return ini;
    }

    public void setInit(Struct ini) {
        if (this.ini != null) {
            this.ini.remove(this.ref);
        }
        if (n != null) {
            quadro.remove(n);
        }
        this.ini = ((LinkedListNode) ini);
        this.desenhar(yBase);

    }

    public void adjust() {
        LinkedListNode aux = this.ini.getProx();
        int count = 1;
        
        if(aux == null){
            System.out.println("aux == null");
        }else{
            if(aux.ajustado)
                System.out.println("ajustado");
        }
        if(aux == this.ini)
            System.out.println("aux == ini");
        
        while((aux != null)&&(!aux.ajustado) && (aux != this.ini)){
            ++count;
            aux = aux.getProx();
        }
        final Semaphore sem = new Semaphore(0, true);
        System.out.println("Count: " + count);
        this.ini.adjust(this.getPInit(), sem);
        
        try {
            sem.acquire(count);
        } catch (InterruptedException ex) {
        }
        
        System.out.println("Lista liberada!");

    }

    public boolean isVista() {
        return this.repintado;
    }

    public void serVista(boolean vista) {
        this.repintado = vista;
    }

    public void setSize(String value) {
        this.tamanho = value;
        if (tam != null) {
            quadro.remove(tam);
            tam = new VarInteiro(new Point2D.Double(30, yBase + 100), referencia + ".tamanho", quadro);
            tam.setValor(tamanho);
            quadro.add(tam);
        } else {
            tam = new VarInteiro(new Point2D.Double(30, yBase + 100), referencia + ".tamanho", quadro);
            tam.setValor(tamanho);
            quadro.add(tam);
        }
        quadro.atualizar();
    }

    @Override
    public Point2D getPInit() {
        return new Point2D.Double(VarInteiro.LARGURA + 120, yBase + (bond + 30));
    }

    @Override
    public void repintar() {

// redesenhando

        if (!this.repintado) {
            this.desenhar(yBase);
            /*LinkedListNode n1 = this.ini;

            n1 = this.ini;

            while (n1 != null) {
                if (!n1.isRepintado()) {
                    n1.repintar();
                } else {
                    break;
                }

                n1 = n1.getProx();
                if (n1 != null && n1.equals(this.ini)) {
                    break;
                }
            }*/

            if (this.ini != null) {
                System.out.println("Repitando Lista");
                this.ini.repintar();
                System.out.println("Ajuntando Lista");
                this.adjust();
            }

            this.repintado = true;
        }

    }

    @Override
    public Struct readField(int field) {
        switch (field) {
            case IGEDConst.LISTA_INICIO:
                return this.ini;

        }
        return null;
    }

    @Override
    public void writeField(Struct s, int field) {
        switch (field) {
            case IGEDConst.LISTA_INICIO:
                this.setInit(((LinkedListNode) s));

        }

    }

    @Override
    public String readInfo() {
        return this.tamanho;
    }

    @Override
    public void writeInfo(String value) {
        this.tamanho = value;
        if (tam != null) {
            tam.setValor(tamanho);
        } else {
            tam = new VarInteiro(new Point2D.Double(30, yBase + 100),
                    referencia + ".tamanho", quadro);
            quadro.add(tam);
            tam.setValor(tamanho);
        }
    }

    @Override
    public void startRepaint() {
        this.repintado = false;
        this.ajustado = false;
        if(this.ini != null)
            this.ini.startRepaint();
        
    }

    @Override
    public String toString() {
        return "Lista " + referencia;
    }
}
