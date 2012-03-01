package iged.grafico.struct;

import iged.IGEDConst;
import java.awt.geom.Point2D;

import iged.grafico.geometria.Label;
import iged.grafico.manager.Quadro;

public class WrapperStruct implements Comparable<WrapperStruct> {

    private Struct s;
    private Referencia ref;
    private String referencia;
    private int type = -1;

    public WrapperStruct(Struct s, int type) {
        this.s = s;
        this.type = type;
        //Quadro.getInstance();
        // add no WrapperStruct no quadro

    }

    public WrapperStruct(String reference, Struct s, int type) {
        this.s = s;
        this.type = type;
        this.setReferencia(reference);
    }

    public void setReferenciaVazia(String reference, Point2D pn) {
        //lembrar de repintar quando o esta referencia deixar de ser vazia

        switch (type) {
            /*case Struct.LISTA:
            this.ref = new Referencia( pn,reference);
            Quadro.getInstance().add(ref);
            break;
             */
            case IGEDConst.NODE:
                this.ref = new Referencia(pn, reference);
                Quadro.getInstance().add(ref);
                break;
                
            case IGEDConst.NODE_TREE:
                this.ref = new Referencia(pn, reference);
		Quadro.getInstance().add(ref);
		break;

            default:
                break;
        }
        this.referencia = reference;
    }

    public void removerReferencia() {
        switch (type) {
            case IGEDConst.LISTA:
                LinkedListNode l = ((Lista) s).getInit();
                System.out.println("CLEAR NEXT");
                //l.clearNext();
                l.remove(ref);
                Quadro.getInstance().remove((Lista)s);
                Quadro.getInstance().atualizar();
                break;

            case IGEDConst.NODE:
                if (ref != null && ref.getNode() != null) {
                    Quadro.getInstance().remove(this.ref);
                    LinkedListNode n = ((LinkedListNode) s);
                    n.clearNext();
                    n.remove(ref);
                }
                break;

            default:
                break;
        }
    }

    public void setReferencia(String reference) {

        switch (type) {

            /*case Struct.LISTA:
            Node l = ((Lista)s).getInit();
            ref = new Referencia( l ,reference);
            break;
             */
            case IGEDConst.NODE:
                LinkedListNode n = ((LinkedListNode) s);
                ref = new Referencia(n, reference);
                Quadro.getInstance().add(ref);
                break;

        }


        this.referencia = reference;
    }

    public int getType() {
        return type;
    }

    public Struct getStruct() {
        return s;
    }

    public void setStruct(Struct s) {

        switch (type) {
            case IGEDConst.LISTA:
                ((Lista) s).setReferencia(this.referencia);
                break;

            case IGEDConst.NODE:
                if (this.s != null) {
                    LinkedListNode n = ((LinkedListNode) this.s);
                    n.remove(ref);
                }
                ref = new Referencia(((LinkedListNode) s), this.referencia);
                Quadro.getInstance().add(ref);
                break;
            case IGEDConst.VETOR:
                ((Vetor) s).setNome(this.referencia);
                break;
                
            case IGEDConst.NODE_TREE:
                if(this.s!=null){
                    NodeTree nt = ((NodeTree)s);
                    nt.remove(this.ref);
		}
		this.ref = new Referencia(((NodeTree)s), this.referencia);
		Quadro.getInstance().add(this.ref);
			
		break;

            default:
                break;
        }

        this.s = s;
    }

    public void startRepaint() {
        if (s != null) {
            s.startRepaint();
        }
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void repintar() {
        if (ref != null && this.type != IGEDConst.LISTA) {
            Quadro.getInstance().add(ref);
        }
        if (s != null) {
            this.s.repintar();
        }
    }

    public String toString() {
        return this.referencia;
    }

    @Override
    public int compareTo(WrapperStruct w) {
        if (this.getType() == w.getType() && s != null && w.getStruct() != null) {

            switch (type) {

                case IGEDConst.NODE:
                    if (this.getStruct().getPInit().getX() < w.getStruct().getPInit().getX()) {
                        return -1;
                    } else {
                        return 1;
                    }

                case IGEDConst.LISTA:
                    if (this.getStruct().getPInit().getY() < w.getStruct().getPInit().getY()) {
                        return -1;
                    } else {
                        return 1;
                    }
                default:
                    break;
            }


        }
        return 0;
    }
}
