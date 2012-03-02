package iged.grafico.manager;

import iged.IGEDConst;
import iged.grafico.struct.Vetor;
import iged.grafico.struct.Lista;
import iged.grafico.struct.LinkedListNode;
import iged.grafico.struct.NodeTree;
import iged.grafico.struct.Struct;
import iged.grafico.struct.WrapperStruct;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.swing.JPanel;

public class GraphicManager {

    private Map<String, WrapperStruct> structs = new HashMap<String, WrapperStruct>();
    public Stack<WrapperStruct> pilha = new Stack<WrapperStruct>();
    public Stack<String> ints = new Stack<String>();
    private VarInteiroManager vi = VarInteiroManager.getInstance();
    
    private int regVet = 0;
    private int referenciasVazias = 0;
    private int nodesSoltos = 0;
    private int yBaseTrabalho = 170;
    private int espacoEntreNodes = 150;
    private int yBase = 200;

    public void createStruct(int type) {
        switch (type) {
            case IGEDConst.LISTA:
                Lista l = new Lista();
                l.setyBase(yBase);

                int y = yBase;
                for (WrapperStruct w : structs.values()) {
                    if (w.getType() != IGEDConst.NODE && w.getType() != IGEDConst.VAZIA) {
                        if (w.getStruct() != null) {
                            y += w.getStruct().getBond() + 35;
                        }
                    }
                }
                l.setyBase(y);

                pilha.push(new WrapperStruct(l, IGEDConst.LISTA));
                break;
            case IGEDConst.NODE:

                LinkedListNode n = new LinkedListNode(new Point2D.Double(getXNodeSoltos(), yBaseTrabalho));

                pilha.push(new WrapperStruct(n, IGEDConst.NODE));
                Quadro.getInstance().add(n);
                this.nodesSoltos++;
                break;
                
            case IGEDConst.VETOR:
                int y2 = yBase;
                for (WrapperStruct w : structs.values()) {
                    if (w.getType() != IGEDConst.NODE && w.getType() != IGEDConst.VAZIA) {
                        if (w.getStruct() != null) {
                            y2 += w.getStruct().getBond() + 35;
                        }
                    }
                }
                Vetor v = new Vetor(y2);
                v.setSize(this.regVet);
                pilha.push(new WrapperStruct(v, IGEDConst.VETOR));
                break;
                
           case IGEDConst.NODE_TREE:
               
               NodeTree nt = new NodeTree(new Point2D.Double(getXNodeSoltos(), yBaseTrabalho));
               pilha.push(new WrapperStruct(nt, IGEDConst.NODE_TREE));
               Quadro.getInstance().add(nt);
               this.nodesSoltos++;
             
               break;

            default:
                break;
        }
    }

    public void createReference(String reference, int type) {
        //feito acho
        switch (type) {
            case IGEDConst.LISTA:
                WrapperStruct w = new WrapperStruct(null, IGEDConst.LISTA);
                w.setReferenciaVazia(reference, new Point2D.Double(getXReferenciaSolta(), yBaseTrabalho + 60));
                pilha.push(w);
                this.structs.put(reference, w);
                referenciasVazias++;

                break;

            case IGEDConst.NODE:


                WrapperStruct w2 = new WrapperStruct(null, IGEDConst.NODE);
                w2.setReferenciaVazia(reference, new Point2D.Double(getXReferenciaSolta(), yBaseTrabalho + 60));
                this.structs.put(reference, w2);
                pilha.push(w2);
                referenciasVazias++;


                break;

            case IGEDConst.VETOR:
                WrapperStruct w3 = new WrapperStruct(null, IGEDConst.VETOR);
                w3.setReferencia(reference);
                this.structs.put(reference, w3);
                pilha.push(w3);

                break;
                
            case IGEDConst.NODE_TREE:
                
                WrapperStruct w4 = new WrapperStruct(null, IGEDConst.NODE_TREE);
		w4.setReferenciaVazia(reference, new Point2D.Double(getXReferenciaSolta(), yBaseTrabalho+60));
		this.structs.put(reference, w4);
		pilha.push(w4);
		referenciasVazias++;
                
                break;

            default:
                break;
        }
    }

    public void readReference(String reference) {
        pilha.push(structs.get(reference));
        //empilha o WrapperStruct que reference aponta no map structs
    }

    public void writeReference() {

        WrapperStruct w2 = pilha.pop();
        WrapperStruct w1 = pilha.pop();
        if ((w1 == null) || (w2 == null)) {
            return;
        }
        w1.setStruct(w2.getStruct());

    }

    public void readReferenceField(int field) {
        WrapperStruct wp = pilha.pop();
        if (wp == null) {
            return;
        }
        WrapperStruct w = new WrapperStruct(wp.getStruct().readField(field), IGEDConst.VAZIA);
        pilha.push(w);
        //retira o primeiro WrapperStruct da pilha e empilha o campo field como WrapperStruct apenas com esse struct
    }

    public void writeReferenceField(int field) {
        WrapperStruct w2 = pilha.pop();
        WrapperStruct w1 = pilha.pop();
        if ((w1 == null) || (w2 == null)) {
            return;
        }
        w1.getStruct().writeField(w2.getStruct(), field);
        // retira o WrapperStruct da pilha e set ele no field do segundo no da pilha
    }

    public void writeReferenceFieldNull(int field) {
        WrapperStruct w1 = pilha.pop();
        if (w1 == null) {
            return;
        }
        w1.getStruct().writeField(null, field);
    }

    public void readInfo() {
        WrapperStruct ws = pilha.pop();
        if (ws == null) {
            return;
        }
        if (ws.getType() != IGEDConst.VETOR) {
            ws.getStruct().readInfo();
        } else {
            ((Vetor) ws.getStruct()).ler(this.regVet);
        }
        //apenas ler o info
    }

    private void readInfoVet() {
        WrapperStruct ws = pilha.pop();
        if (ws == null) {
            return;
        }
        ((Vetor) ws.getStruct()).ler(this.regVet);
        //apenas ler o info do vetor
    }

    public void writeInfo(String value) {
        WrapperStruct w = pilha.pop();
        if(w == null)
            return;
        if (w.getType() == IGEDConst.VETOR) {
            ((Vetor) w.getStruct()).escrever(this.regVet, value);
            return;
        }
        w.getStruct().writeInfo(value);
        //apenas escreve um lavor
    }

    public void removeReference(String reference) {
        System.out.println("Remove: " + reference);
        WrapperStruct w = structs.remove(reference);
        if(w == null)
            return;
        w.removerReferencia();
    }

    public void create_Int(String referencia) {
        vi.createVarInteiro(referencia);
    }

    public void remove_int(String referencia) {
        vi.remover(referencia);
    }

    public void readReferenceInt(String referencia) {
        ints.push(referencia);
    }

    public void setValue(String value) {
        vi.setValor(ints.pop(), value);
    }

    public void read_Int(String referencia) {
        vi.ler(referencia);
    }

    private int getXNodeSoltos() {
        int x = 0;
        if (nodesSoltos == 0) {
            x = 100;
        } else {
            x = (nodesSoltos * espacoEntreNodes) + 100;
        }
        return x;
    }

    private int getXReferenciaSolta() {
        int x = 0;
        if (referenciasVazias == 0) {
            x = 30;
        } else {
            x = ((referenciasVazias + 1) * 50) + 30;
        }
        return x;
    }

    private int getXReferenciaSolta(int index) {
        int x = 0;
        if (index == 0) {
            x = 100;
        } else {
            x = (index * espacoEntreNodes) + 100;
        }
        return x;
    }

    public void clearStack() {
        pilha.clear();
    }

    public void regVet(int regVet) {
        this.regVet = regVet;
    }

    public void lixeiro() {
        Quadro.getInstance().limpar();
        for (WrapperStruct w : this.structs.values()) {
            System.out.println(w.getReferencia());
            w.startRepaint();
        }

        //Pintas as Estruturas diferentes de Nodes.
        List<WrapperStruct> nodes = new ArrayList<WrapperStruct>();
        for (WrapperStruct w : this.structs.values()) {
            if (w.getType() != IGEDConst.NODE && w.getType()!= IGEDConst.NODE_TREE) {
                System.out.println("Repintar: " + w.getReferencia());
                w.repintar();
            } else {
                System.out.println("Nodes add: " + w.getReferencia());
                nodes.add(w);
            }
        }

        this.nodesSoltos = 0;
        Collections.sort(nodes);

        for (WrapperStruct no : nodes) {
            if (no.getStruct() != null && !no.getStruct().isRepintado()) {
                no.repintar();
                
                
                
                System.out.println("HHHHHHH");
                if(no.getType() == IGEDConst.NODE){
                    LinkedListNode n = ((LinkedListNode)no.getStruct());
                    n.adjust(new Point2D.Double(getXNodeSoltos(), yBaseTrabalho));
                    nodesSoltos++;
		}
		else{
                    NodeTree nt = ((NodeTree)no.getStruct());
                    nt.adjust(new Point2D.Double(getXNodeSoltos(), yBaseTrabalho));
                    nodesSoltos++;
		}
                
                
//                
//                LinkedListNode n = ((LinkedListNode) no.getStruct());
//
//                ((LinkedListNode) no.getStruct()).adjust(new Point2D.Double(getXNodeSoltos(), yBaseTrabalho));
//                nodesSoltos++;

            } else {
                no.repintar();
            }
        }

        Quadro.getInstance().atualizar();
        clearStack();
        vi.getInstance().repintar();
    }

    public JPanel getQuadro() {
        return Quadro.getInstance();
    }
}
