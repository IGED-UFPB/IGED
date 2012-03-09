package iged.AED;

import iged.IGEDConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class StructManager {

    //Map<String, WrapperStruct> nodeOriginal;
    //Map<String, WrapperStruct> nodeReplica;
    Map<String, WrapperStruct> structOriginal;
    Map<String, WrapperStruct> structReplica;
    private StructFactory factory = new StructFactory();
    //private static NodeFactory nFactory = new NodeFactory();
    //Pilha de estruturas nao no
    public static Stack<WrapperStruct> pilha = new Stack<WrapperStruct>();
    //Pilha de estruturas no
    //public static Stack<WrapperStruct> pilhaN = new Stack<WrapperStruct>();
    private int mode;
    private static StructManager sm;
    private int pos = 0;

    private StructManager() {
        structOriginal = new HashMap<String, WrapperStruct>();
        structReplica = new HashMap<String, WrapperStruct>();
        //nodeOriginal = new HashMap<String, WrapperStruct>();
        //nodeReplica = new HashMap<String, WrapperStruct>();
        mode = IGEDConst.MODE_BOTH;
    }

    public static StructManager getIntance() {
        if (sm == null) {
            sm = new StructManager();
        }
        return sm;
    }

    public boolean removeStruct(String id) {

        /*if(this.getNode(id)!= null){
        switch(mode){
        case IGEDConst.MODE_PROFESSOR:
        this.nodeReplica.remove(id);
        return true;
        case IGEDConst.MODE_BOTH:
        this.nodeOriginal.remove(id);
        this.nodeReplica.remove(id);
        return true;
        case IGEDConst.MODE_STUDENT:
        this.nodeOriginal.remove(id);
        return true;
        default:
        return false;
        }
        }else*/
        if (this.getStruct(id) != null) {
            switch (mode) {
                case IGEDConst.MODE_PROFESSOR:
                    this.structReplica.remove(id);
                    return true;
                case IGEDConst.MODE_BOTH:
                    this.structOriginal.remove(id);
                    this.structReplica.remove(id);
                    return true;
                case IGEDConst.MODE_STUDENT:
                    this.structOriginal.remove(id);
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }

    public void setMode(int m) {
        if (m <= 2 && m >= 0) {
            this.mode = m;
        }
    }

    public void set_LengthStruct(int lengthStruct) {
        this.factory.setLengthStruct(lengthStruct);
    }

    public void createStruct(int type) {
        factory.createStruct(type);
    }

    public void createReference(String id, int type) {
        this.insertStruct(id, null);
        this.read_reference_struct(id);


        /*switch(type){
        case Struct.LINKEDLIST:
        this.create_reference_struct(id);
        break;
        case Struct.VECTOR:	
        this.create_reference_struct(id);
        break;
        case Node.LINKEDLISTNODE:
        this.create_reference_node(id);
        break;
        }*/

    }

    /*private void create_reference_node(String id){
    this.insertNode(id, null);
    read_reference_node(id);
    }*/
    /*private void create_reference_struct(String id){
    this.insertStruct(id, null);
    this.read_reference_struct(id);
    }*/
    public void readReference(String id) {
        /*if(this.getNode(id)!= null){
        this.read_reference_node(id);
        }else*/
        if (this.getStruct(id) != null) {
            this.read_reference_struct(id);
        }
    }

    /*private void read_reference_node(String id){
    this.pilhaN.push(this.getNode(id));
    }*/
    private void read_reference_struct(String id) {
        this.pilha.push(this.getStruct(id));
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

        /*else if(pilhaN.size()>=2){
        this.write_reference_node();
        }else{
        this.write_reference_struct();
        }*/
    }

    private void write_reference_struct() {
        WrapperStruct w2 = pilha.pop();
        WrapperStruct w1 = pilha.pop();
        w1.setStruct(w2.getStruct());
    }

    /*private void write_reference_node() {
    WrapperStruct w2 = pilhaN.pop();
    WrapperStruct w1 = pilhaN.pop();
    w1.setStruct(w2.getStruct());
    }*/
    public void readReferenceField(int field) {
        WrapperStruct w = new WrapperStruct(pilha.pop().getStruct().readField(field));
        pilha.push(w);
        //pilhaN.push(w);

        /*switch(field){
        
        case LinkedList.START_LINKEDLIST:
        this.read_reference_field_struct(field);
        break;
        case LinkedListNode.NEXT_LINKEDLISTNODE:
        this.read_reference_field_node(field);
        break;
        }*/
    }

    /*private void read_reference_field_node(int field) {
    WrapperStruct w = new WrapperStruct(pilhaN.pop().getStruct().readField(field));
    pilhaN.push(w);
    }
    
    private void read_reference_field_struct(int field) {
    WrapperStruct w = new WrapperStruct(pilha.pop().getStruct().readField(field));
    pilhaN.push(w);
    }*/
    public void writeReferenceField(int field) {
        WrapperStruct w2 = pilha.pop();
        WrapperStruct w1 = pilha.pop();
        w1.getStruct().writeField(w2.getStruct(), field);

        /*switch(field){
        
        case LinkedList.START_LINKEDLIST:
        this.write_reference_field_struct(field);
        break;
        case LinkedListNode.NEXT_LINKEDLISTNODE:
        this.write_reference_field_node(field);
        break;
        }*/
    }

    /*private void write_reference_field_node(int field) {
    WrapperStruct w2 = pilhaN.pop();
    WrapperStruct w1 = pilhaN.pop();
    w1.getStruct().writeField(w2.getStruct(), field);	
    }*/
    /*private void write_reference_field_struct(int field) {
    WrapperStruct w2 = pilhaN.pop();
    WrapperStruct w1 = pilha.pop();
    w1.getStruct().writeField(w2.getStruct(), field);	
    }*/
    public void writeReferenceFieldNull(int field) {
        WrapperStruct w1 = pilha.pop();
        w1.getStruct().writeField(null, field);
        /*switch(field){
        
        case LinkedList.START_LINKEDLIST:
        this.write_reference_field_struct_null(field);
        break;
        case LinkedListNode.NEXT_LINKEDLISTNODE:
        this.write_reference_field_node_null(field);
        break;
        }*/
    }

    /*private void write_reference_field_struct_null(int field) {
    WrapperStruct w1 = pilha.pop();
    w1.getStruct().writeField(null, field);
    }*/
    /*private void write_reference_field_node_null(int field) {
    WrapperStruct w1 = pilhaN.pop();
    w1.getStruct().writeField(null, field);
    }*/
    public int readInfo() {
        /*if (pilhaN.isEmpty() && pilha.isEmpty()) {
            //erro
            return 0;
        } else if (pilha.isEmpty()) {
            return pilhaN.pop().getStruct().readInfo();
        } else {
            Struct s = pilha.pop().getStruct();
            if (s.getType() != Struct.VECTOR) {
                return s.readInfo();
            } else {
                ((Vector) s).setField(pos);
                return ((Vector) s).read(this.factory.getLengthStruct());
            }
        }*/
        
        Struct s = pilha.pop().getStruct();
            if (s.getType() != IGEDConst.VETOR) {
                return s.readInfo();
            } else {
                ((Vector) s).setField(pos);
                return ((Vector) s).read(this.factory.getLengthStruct());
            }
    }

    public void writeInfo(int value) {
        // olhar se dar certo quando misturar node e lista em uma unica linha de codigo
        /*if (pilhaN.isEmpty() && pilha.isEmpty()) {
        //erro
        return;
        } else if (!pilhaN.isEmpty()) {
        pilhaN.pop().getStruct().readInfo();
        } else {
        Struct s = pilha.pop().getStruct();
        if (s instanceof Vector) {
        ((Vector) s).setField(pos);
        }
        s.writeInfo(value);
        }*/

        Struct s = pilha.pop().getStruct();
        if (s instanceof Vector) {
            ((Vector) s).setField(pos);
        }
        s.writeInfo(value);

    }

    public void setPosVector(int pos) {
        this.pos = pos;
    }

    public void insertStruct(String id, Struct s) {
        WrapperStruct ws = new WrapperStruct(s);
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                this.structReplica.put(id, ws);
                break;
            case IGEDConst.MODE_BOTH:
                this.structOriginal.put(id, ws);
                this.structReplica.put(id, factory.duplicateStruct(s));
                break;
            case IGEDConst.MODE_STUDENT:
                this.structOriginal.put(id, ws);
                break;
            default:
                break;
        }
        this.pilha.push(ws);

    }

    /*public void insertNode(String id, Node n){
    WrapperStruct wn = new WrapperStruct(n);
    switch(mode){
    case IGEDConst.MODE_PROFESSOR:
    this.nodeReplica.put(id, wn);
    break;
    case IGEDConst.MODE_BOTH:
    this.nodeOriginal.put(id, wn);
    this.nodeReplica.put(id,factory.duplicateStruct(n));
    break;
    case IGEDConst.MODE_STUDENT:
    this.nodeOriginal.put(id, wn);
    break;
    }
    this.pilhaN.push(wn);
    }*/
    public WrapperStruct getStruct(String id) {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                return this.structReplica.get(id);
            case IGEDConst.MODE_BOTH:
                return this.structOriginal.get(id);
            case IGEDConst.MODE_STUDENT:
                return this.structOriginal.get(id);
            default:
                return null;
        }

    }

    /*public WrapperStruct getNode(String id){
    switch(mode){
    case IGEDConst.MODE_PROFESSOR:
    return this.nodeReplica.get(id);
    case IGEDConst.MODE_BOTH:
    return this.nodeOriginal.get(id);
    case IGEDConst.MODE_STUDENT:
    return this.nodeOriginal.get(id);
    default:
    return null;
    }
    }*/
    public List<String> listStruct() {
        switch (mode) {
            case IGEDConst.MODE_PROFESSOR:
                return new ArrayList<String>(this.structReplica.keySet());
            case IGEDConst.MODE_BOTH:
                return new ArrayList<String>(this.structOriginal.keySet());
            case IGEDConst.MODE_STUDENT:
                return new ArrayList<String>(this.structOriginal.keySet());
            default:
                return null;
        }
    }

    /*public List<String> listNode(){
    switch(mode){
    case IGEDConst.MODE_PROFESSOR:
    return new ArrayList<String>(this.nodeReplica.keySet());
    case IGEDConst.MODE_BOTH:
    return new ArrayList<String>(this.nodeOriginal.keySet());
    case IGEDConst.MODE_STUDENT:
    return new ArrayList<String>(this.nodeOriginal.keySet());
    default:
    return null;
    }
    }*/
    public void endCommand() {
        //pilhaN.clear();
        pilha.clear();
        factory.setLengthStruct(10);
    }
}
