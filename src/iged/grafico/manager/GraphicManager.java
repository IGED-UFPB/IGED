package iged.grafico.manager;

import iged.IGEDConst;
import iged.grafico.struct.BinaryTree;
import iged.grafico.struct.Vetor;
import iged.grafico.struct.LinkedList;
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

import java.util.concurrent.Semaphore;

public class GraphicManager {

    private Quadro quadro = null;
    
    private Map<String, WrapperStruct> structs;
    public Stack<WrapperStruct> pilha;
    public Stack<String> ints;
    private VarInteiroManager vi;
    
    private int regVet;
    private int referenciasVazias;
    private int nodesSoltos;
    private double boundsBinaryTree;
    
    public GraphicManager(){
        this.structs = new HashMap<String, WrapperStruct>();
        this.pilha = new Stack<WrapperStruct>();
        this.ints = new Stack<String>();
        this.quadro = new Quadro();
        
        this.vi = new VarInteiroManager(this.quadro);
        
        this.initPosition();
    }
    
    void initPosition(){
        this.regVet = 0;
        this.referenciasVazias = 0;
        this.nodesSoltos = 0;
        this.boundsBinaryTree = BinaryTree.BOUNDS;
    }
    
    public void createStruct(int type) {
        switch (type) {
            case IGEDConst.LISTA:
                LinkedList l = new LinkedList(quadro);
                l.setyBase(Quadro.YBASE);

                int y = Quadro.YBASE;
                for (WrapperStruct w : structs.values()) {
                    if (w.isDataStruct()) {
                        if (w.getStruct() != null) {
                            y += w.getStruct().getBond() + 35;
                        }
                    }
                }
                l.setyBase(y);

                pilha.push(new WrapperStruct(l, IGEDConst.LISTA, quadro));
                break;
            case IGEDConst.NODE:

                LinkedListNode n = new LinkedListNode(new Point2D.Double(getXNodeSoltos(), Quadro.YBASE_TRABALHO), quadro);

                pilha.push(new WrapperStruct(n, IGEDConst.NODE, quadro));
                quadro.add(n);
                this.nodesSoltos++;
                break;
                
            case IGEDConst.VETOR:
                int y2 = Quadro.YBASE;
                for (WrapperStruct w : structs.values()) {
                    if(w.isDataStruct()){
                        if (w.getStruct() != null) {
                            y2 += w.getStruct().getBond() + 35;
                        }
                    }
                }
                Vetor v = new Vetor(y2, quadro);
                v.setSize(this.regVet);
                pilha.push(new WrapperStruct(v, IGEDConst.VETOR, quadro));
                break;
                
           case IGEDConst.NODE_TREE:
               NodeTree nt = new NodeTree(new Point2D.Double(getXNodeSoltos(), 
            		   this.boundsBinaryTree+ESPACO_ESTRUTURAS), quadro);
               pilha.push(new WrapperStruct(nt, IGEDConst.NODE_TREE, quadro));
               quadro.add(nt);
               this.nodesSoltos++;
             
               break;
           case IGEDConst.BINARY_TREE:
        	   BinaryTree bt = new BinaryTree(quadro);
        	   
        	   pilha.push(new WrapperStruct(bt, IGEDConst.BINARY_TREE, quadro));
        	   
        	   break;

            default:
                break;
        }
    }

    public void createReference(String reference, int type) throws ReferenceExistingException{
        //feito acho
        if(this.structs.get(reference) != null)
            throw new ReferenceExistingException("Referencia: " + reference + " já foi criada.");
        WrapperStruct w = new WrapperStruct(null, type, quadro);
//        w.setReferenciaVazia(reference, new Point2D.Double(getXReferenciaSolta(), yBaseTrabalho + 60));
        w.setReferenciaVazia(reference, new Point2D.Double(getXReferenciaSolta(), 
        		this.boundsBinaryTree +ESPACO_ESTRUTURAS));
        pilha.push(w);
        this.structs.put(reference, w);
        referenciasVazias++;
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
        Struct s = wp.getStruct().readField(field);
        WrapperStruct w;
        if(s == null)
            w = new WrapperStruct(s, IGEDConst.VAZIA, quadro);
        else
            w = new WrapperStruct(s, s.getType(), quadro);
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
       WrapperStruct w = structs.remove(reference);
        if(w == null)
            return;
        
        System.out.println("Remove: " + reference);
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
            x = (nodesSoltos * ESPACO_NODES) + 100;
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
            x = (index * ESPACO_NODES) + 100;
        }
        return x;
    }

    public void clearStack() {
        pilha.clear();
    }

    public void regVet(int regVet) {
        this.regVet = regVet;
    }
    
    

    public void lixeiro(){
        quadro.limpar();
        for (WrapperStruct w : this.structs.values()) {
            System.out.println(w.getReferencia());
            w.startRepaint();
        }

        //Pintas as Estruturas diferentes de Nodes.
        List<WrapperStruct> nodes = new ArrayList<WrapperStruct>();
        for (WrapperStruct w : this.structs.values()) {
            if (w.isDataStruct()) {
                System.out.println("Repintar: " + w.getReferencia());
               
                /**Devido a particularidade da binarytree em crescer para baixo
                 * o código deste if calcula o limite inferior da árvore*/
                
                if(w.getType()==IGEDConst.BINARY_TREE && w.getStruct()!=null){
                	BinaryTree bt = ((BinaryTree)w.getStruct());
                	bt.adjust();
                	this.calculaBound(bt.readField(IGEDConst.NODE_TREE_ROOT), IGEDConst.BINARY_TREE);
                	System.out.println("o/");
                }
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
        			//Cria um semaphoro que bloquea a Thread equanto os nodes n forem desenhados.
        			LinkedListNode aux = n.getProx();
        			//Conta com o no atual n.
        			int count = 1;
        			while((aux != null)&&(!aux.isAjustado()) && (aux != n)){
        				++count;
        				aux = aux.getProx();
        			}
        			System.out.println("Noooode: " + count);
        			if(count > 0){
        				Semaphore sem = new Semaphore(0, true);
        				n.adjust(new Point2D.Double(getXNodeSoltos(), Quadro.YBASE_TRABALHO), sem);
        				try{
        					sem.acquire(count);
        				}catch(InterruptedException ie){}
        			}
        			nodesSoltos++;
        		}
        		else{
        			NodeTree nt = ((NodeTree)no.getStruct());
        			nt.mover(new Point2D.Double(getXNodeSoltos(), this.boundsBinaryTree+this.ESPACO_ESTRUTURAS));
        			nt.repintar();
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

        quadro.atualizar();
        clearStack();
        this.vi.repintar();
    }

    public Quadro getQuadro() {
        return quadro;
    }
    
    private void calculaBound(Struct s,int type){
    	switch(type){
    	case IGEDConst.BINARY_TREE:
    		NodeTree nt = ((NodeTree)s);
    		if(nt!=null){
    			
    			if(nt.getPB().getY() > this.boundsBinaryTree)
    				this.boundsBinaryTree = nt.getPB().getY();
    			
    			if(nt.readField(IGEDConst.LEFT_CHIELD)!=null)
    				this.calculaBound(nt.readField(IGEDConst.LEFT_CHIELD), type);
    			if(nt.readField(IGEDConst.RIGHT_CHIELD)!=null)
    				this.calculaBound(nt.readField(IGEDConst.RIGHT_CHIELD), type);
    		}
    		break;

    	default:
    		break;

    		
    		
    	}
    }
    
    public void clearAll(){
        this.ints.clear();
        this.structs.clear();
        this.vi.clear();
        this.initPosition();
    }
    
    static final int ESPACO_NODES = 150;
    static final int ESPACO_ESTRUTURAS = 200;
    
}
