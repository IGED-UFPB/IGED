package br.ufpb.iged.grafico.struct;

import br.ufpb.iged.IGEDConst;
import java.awt.geom.Point2D;
import br.ufpb.iged.grafico.manager.Quadro;

public class WrapperStruct implements Comparable<WrapperStruct> {
    private Quadro quadro;
    private Struct s;
    private Referencia ref;
    private String referencia;
    private int type = -1;

    public WrapperStruct(Struct s, int type, Quadro q) {
        this.quadro = q;
        this.s = s;
        this.type = type;
        //Quadro.getInstance();
        // add no WrapperStruct no quadro

    }

    public WrapperStruct(String reference, Struct s, int type, Quadro q) {
        this.quadro = q;
        this.s = s;
        this.type = type;
        //this.setReferencia(reference);
    }

    public void setReferenciaVazia(String reference, Point2D pn) {
        //lembrar de repintar quando o esta referencia deixar de ser vazia
        this.ref = new Referencia(pn, reference, quadro);
        quadro.add(this.ref);        
        this.referencia = reference;
    }

    public void removerReferencia() {
    	
    	//Desta forma NodeTree e linkedListNode ficam no mesmo Case
    	int compareType;
    	if(this.type == IGEDConst.NODE_TREE)compareType = IGEDConst.NODE;
    	else compareType = this.type;
    	
    	
        switch (compareType) {
            case IGEDConst.LISTA:
                //LinkedListNode l = ((Lista) s).getInit();
                //System.out.println("CLEAR NEXT");
                //if(l != null)
                //    l.remove(ref);
                
                s.removeReference(referencia);
                //s.remove(ref);
                //Quadro.getInstance().remove((Lista)s);
                //Quadro.getInstance().atualizar();
                break;
                
                
                /**Agora este c�digo pode ser utilizado pelas estruturas Node (linkedListNode e NodeTree)
                 * */
            case IGEDConst.NODE:
                if (ref != null && ref.getNode() != null) {
                    quadro.remove(this.ref);
                    Node n = ((Node) s);
                    //n.clearNext();
                    n.remove(ref);
                }
                break;
//            case IGEDConst.NODE:
//                if (ref != null && ref.getNode() != null) {
//                    quadro.remove(this.ref);
//                    LinkedListNode n = ((LinkedListNode) s);
//                    //n.clearNext();
//                    n.remove(ref);
//                }
//                break;
            case IGEDConst.VETOR:
                //if (ref != null && ref.getNode() != null) {
                    Vetor v = ((Vetor) s);
                    //n.clearNext();
                    //v.remove(ref);
                    v.remove(referencia);
                //}
                break;
//                
//            case IGEDConst.NODE_TREE:
//            	if (ref != null && ref.getNode() != null) {
//                    quadro.remove(this.ref);
//                    NodeTree nt = ((NodeTree) s);
//                    nt.remove(ref);
//                }
//                break;

            default:
                break;
        }
    }

    /*public void setReferencia(String reference) {

        switch (type) {

            //case Struct.LISTA:
            //Node l = ((Lista)s).getInit();
            //ref = new Referencia( l ,reference);
            //break;
          
            case IGEDConst.NODE:
                LinkedListNode n = ((LinkedListNode) s);
                ref = new Referencia(n, reference);
                Quadro.getInstance().add(ref);
                break;
            case IGEDConst.VETOR:
                Vetor v = ((Vetor) s);
                ref = new Referencia(null, reference, true);
                ref.setNode(s);
                v.add(ref);
                break;

        }

        this.referencia = reference;
    }*/

    public int getType() {
        return type;
    }

    public Struct getStruct() {
        return s;
    }

    public void setStruct(Struct s) {

        switch (type) {
            case IGEDConst.LISTA:
                //s.add(this.referencia);
                //break;
                
            case IGEDConst.VETOR:
                if(ref != null){
                    quadro.remove(ref);
                    ref = null;
                }
                s.add(this.referencia);
                break;

            case IGEDConst.NODE:
                if (this.s != null) {
                    this.ref.setRef((Node)s);
                    //break;
                    //LinkedListNode n = ((LinkedListNode) this.s);
                    //n.remove(ref);
                    break;
                }
                ref = new Referencia(((LinkedListNode) s), this.referencia, quadro);
                quadro.add(ref);
                break;
            
            case IGEDConst.NODE_TREE:
                if(this.s!=null){
                    this.s.remove(this.ref);
				}
				this.ref = new Referencia(((NodeTree)s), this.referencia, quadro);
				quadro.add(this.ref);
				break;
           
            case IGEDConst.BINARY_TREE:
            	((BinaryTree)s).setReferencia(this.referencia);
            	this.s = s;
            	quadro.remove(this.ref); 
            	this.ref = null;
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
        if (ref != null) {
        //if (ref != null && this.type != IGEDConst.LISTA) {
            quadro.add(ref);
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
    	
    	/**Para o caso de e estrutura ser do tipo nodeTree
    	 * Proporciona reuso de c�digo
    	 * Ent�o a estrutura assume um tipo mais gen�rico
    	 * 
    	 * Desta forma ainda � poss�vel comparar os dois tipos de node*/
    	
    	int compareType,compareTypeStruct;
    	if(type == IGEDConst.NODE_TREE) compareType=IGEDConst.NODE;
    	else compareType = this.getType();
    	
    	if(w.getType()==IGEDConst.NODE_TREE)compareTypeStruct = IGEDConst.NODE;
		else compareTypeStruct = w.getType();
			 
    /**---------------------------------------------------------------*/
        if (compareType == compareTypeStruct && s != null && w.getStruct() != null) {
        	
        	switch (compareType) {

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
                case IGEDConst.BINARY_TREE:
                    if (this.getStruct().getPInit().getX() < w.getStruct().getPInit().getX()) {
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

    public boolean isDataStruct() {
        return (this.getType() != IGEDConst.NODE &&
                this.getType() != IGEDConst.VAZIA &&
                this.getType() != IGEDConst.NODE_TREE &&
                this.getType() != IGEDConst.NODE_TREE_ROOT);
    }
}
