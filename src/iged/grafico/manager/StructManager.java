package iged.grafico.manager;

import iged.IGEDConst;
import iged.grafico.struct.Lista;
import iged.grafico.struct.LinkedListNode;
import iged.grafico.struct.Struct;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StructManager {
	
	private Stack<Struct> pilha = new Stack<Struct>();
	private Map<String,Struct> structs = new HashMap<String, Struct>();
	private Map<String,Integer> referencias = new HashMap<String, Integer>();
	private Struct reg = null;
	private int yBase = 200;
	private static NodesManager nm;
	private static StructManager sm;
	
	private StructManager(){}
	
	public static StructManager getIntance(){
		if(sm == null){
			sm = new StructManager();
			nm = NodesManager.getIntance();
		}
		
		return sm;
	}
	
	public void createStruct(int tipo){
		
		switch (tipo) {
		case IGEDConst.LISTA:
			reg = new Lista();
			break;

		default:
			break;
		}
		
	}
	
	public void createReferenciaStruct(String referencia, int tipo){
		referencias.put(referencia, tipo);
	}
	
	public void setValue(String value){
		//pilha.pop().setSize(value);
	}
	
	public void setReferenciaStruct(String referencia){
		//reg.setReferencia(referencia);
		int  y = yBase;
		for(Struct s : structs.values()){
			y+=s.getBond()+35;
		}
		//reg.desenhar(y);
		
		referencias.remove(referencia);
		structs.put(referencia, reg);
	}
	
	public void readRef(String referencia){
		pilha.push(this.structs.get(referencia));
	}
	
	
	public void readStructField(int field){
    	Struct s = pilha.pop();
    	//nm.pilha.push(s.getField(INIT));    	
    }
	
	public void writeRef(){
		Struct s2 = pilha.pop();
		Struct s1 = pilha.pop();
		s1 = s2;
	}
	
	public void writeStructRef(int field){
		switch(field){
		case IGEDConst.LISTA_INICIO:
			Struct s = pilha.pop();
			LinkedListNode n = nm.pilha.pop();
			//s.setInit(n);
			
			break;
    	}
	}
	
	public void setInitNode(String struct, String referenciaNode){
		//structs.get(struct).setInit(nm.getNode(referenciaNode));
		//structs.get(struct).repintar();
		nm.setNodeInit(struct, referenciaNode,structs.get(struct).getPInit());
	}
	
	public void setSize(String struct,String value){
		//structs.get(struct).setSize(value);
	}

	Struct getStruct(String referencia){
		return this.structs.get(referencia);
	}
	
	public void repintar(){
		Quadro.getInstance().limpar();
		for(Struct s : this.structs.values()){
			s.repintar();
		}
		nm.repintar();
		VarInteiroManager.getInstance().repintar();
		Quadro.getInstance().atualizar();
	}
}
