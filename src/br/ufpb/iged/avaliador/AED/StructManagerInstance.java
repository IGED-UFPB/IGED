package br.ufpb.iged.avaliador.AED;

import br.ufpb.iged.IGEDConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class StructManagerInstance{

    Map<String, WrapperStruct> struct;
    private StructFactory factory = null;
    Stack<WrapperStruct> pilha;

    private int pos = 0;

    public StructManagerInstance() {
        struct = new HashMap<String, WrapperStruct>();
        factory = StructFactory.getInstance();
        pilha = new Stack<WrapperStruct>();
    }


    public boolean removeStruct(String id) {
        if (this.getStruct(id) != null) {
            this.struct.remove(id);
            return true;
        }
        return false;
    }

    public void set_LengthStruct(int lengthStruct) {
        factory.setLengthStruct(lengthStruct);
    }

    public void createStruct(int type) {
        Struct s = factory.createStruct(type);
        
        pilha.add(new WrapperStruct(s));
    }

    public void createReference(String id, int type) {
        this.insertStruct(id, null);
        this.read_reference_struct(id);
    }

    public void readReference(String id) {
        if (this.getStruct(id) != null) {
            this.read_reference_struct(id);
        }
    }

    private void read_reference_struct(String id) {
        pilha.push(this.getStruct(id));
    }

    public void writeReference() {
        if (pilha.isEmpty()) {
            //erro
            return;
        } else {
            WrapperStruct w2 = pilha.pop();
            WrapperStruct w1 = pilha.pop();
            w1.setStruct(w2.getStruct());
        }
    }

    private void write_reference_struct() {
        WrapperStruct w2 = pilha.pop();
        WrapperStruct w1 = pilha.pop();
        w1.setStruct(w2.getStruct());
    }

    public void readReferenceField(int field) {
        WrapperStruct w = new WrapperStruct(pilha.pop().getStruct().readField(field));
        pilha.push(w);
    }

    public void writeReferenceField(int field) {
        WrapperStruct w2 = pilha.pop();
        WrapperStruct w1 = pilha.pop();
        w1.getStruct().writeField(w2.getStruct(), field);

    }

    public void writeReferenceFieldNull(int field) {
        WrapperStruct w1 = pilha.pop();
        w1.getStruct().writeField(null, field);
    }

    public int readInfo() {        
        Struct s = pilha.pop().getStruct();
            if (s.getType() != IGEDConst.VETOR) {
                return s.readInfo();
            } else {
                ((Vector) s).setField(pos);
                return ((Vector) s).read(factory.getLengthStruct());
            }
    }

    public void writeInfo(int value) {
        Struct s = pilha.pop().getStruct();
        if (s instanceof Vector) {
            ((Vector) s).setField(pos);
        }
        s.writeInfo(value);

    }
    
    public void setSizeBT(int value) {
        Struct s = pilha.pop().getStruct();
        if (s instanceof BinaryTree) {
            BinaryTree bt = (BinaryTree)s;
            bt.setSize(value);
        }
        

    }

    public void setPosVector(int pos) {
        this.pos = pos;
    }

    public void insertStruct(String id, Struct s) {
        WrapperStruct ws = new WrapperStruct(s);
        
        this.struct.put(id, ws);
        pilha.push(ws);
        
    }

    public WrapperStruct getStruct(String id) {
        return this.struct.get(id);
    }

    public List<String> listStruct() {
        return new ArrayList<String>(this.struct.keySet());
    }

    public void endCommand() {
        pilha.clear();
        factory.setLengthStruct(10);
    }

    void clear() {
        this.struct.clear();
        this.pilha.clear();
    }
    
    public void setHeight(String h){
    	WrapperStruct w = pilha.pop();
    	NodeTree nt = (NodeTree)w.getStruct();
    	nt.setHeight(h);
    }
}

