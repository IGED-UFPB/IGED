package iged.grafico.manager;


import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import iged.grafico.geometria.Label;
import iged.grafico.struct.LinkedListNode;
import iged.grafico.struct.Node;
import iged.grafico.struct.Referencia;

public class Apontadores {
	
	private Quadro quadro = Quadro.getInstance();
	
	private Map<String, Referencia> referencias = new HashMap<String,Referencia> ();
	private Map<Node, List<String>> ponteiros = new HashMap<Node, List<String>>();
	private Map<String ,Label> vazias = new HashMap<String,Label> ();
	private Map<Node, Node> nn = new HashMap<Node, Node>();
	
	
	public void setNextNode(Node n , Node next){
		nn.put(n, next);
	}
	
	public void setNextNull(Node n){
		nn.remove(n);
	}
	
	public void addReferencia(String referencia, Node n ){
		try{
			ponteiros.get(n).add(referencia);
		}catch (NullPointerException e) {
			ponteiros.put(n, new ArrayList<String>());
			ponteiros.get(n).add(referencia);
		}
		Referencia r = new Referencia(n,referencia);
		referencias.put(referencia, r);
		quadro.add(r);
		quadro.atualizar();
	}
	
	public void addReferencia(String referencia , Point2D pn){
		Label l = new Label(referencia+";",pn);
		vazias.put(referencia, l);
		quadro.add(l);
		quadro.atualizar();
	}
	
	public void atribuirReferencia(String referencia, Node n){
		if(this.vazias.containsKey(referencia)){
			this.addReferencia(referencia, n);
			Label l = this.vazias.remove(referencia);
			this.referencias.get(referencia).setRef(n);
			quadro.remove(l);
			quadro.atualizar();
		}else{
			Node remove = null;
			for(Node pes : ponteiros.keySet()){
				if(this.getReferencias(pes).contains(referencia)){
					remove = pes;
					break;
				}
			}
			if(remove != null){
				this.ponteiros.get(n).remove(referencia);
				this.addReferencia(referencia, remove);
				this.referencias.get(referencia).setRef(n);
				quadro.atualizar();
			}
		}
	}
	
	public void removeReferencia(String referencia){
		if(this.vazias.containsKey(referencia)){
			Label l = this.vazias.remove(referencia);
			quadro.remove(l);
			quadro.atualizar();
			return;
		}
		for(Node n : ponteiros.keySet() ){
			if(ponteiros.get(n).contains(referencia)){
				ponteiros.get(n).remove(referencia);
				Referencia r = this.referencias.remove(referencia);
				Node n2 = r.getNode();
				n2.remove(r);
				quadro.remove(r);
				quadro.atualizar();
				return;
			}
		}
	}
	
	public int sizeReferenciasSoltas(){
		return this.vazias.size();
	}
	
	public List<String> getReferencias(Node n){
		return ponteiros.get(n);
	}
	
	private boolean NodeIsProcimo(Node n){
		return nn.containsValue(n);
	}
	
	public List<Node> lixeiro(){
		List<Node> listAux = new ArrayList<Node>(ponteiros.keySet());
		List<Node> perdidos = new ArrayList<Node>();
		for(Node n : listAux){
			if(ponteiros.get(n).isEmpty() && !this.NodeIsProcimo(n)){
				perdidos.add(n);
				ponteiros.remove(n);
			}
		}
		return perdidos;
	}
	
        
        // Analisar uma solulção para o acoplamento com a classe LinkedListNode
        
	void repintar(){
		//preparando para repintar
		
		for(Referencia r : this.referencias.values()){
			LinkedListNode n  = (LinkedListNode)r.getNode();
			LinkedListNode ini = n;
                        
	    	while(n != null){
	    			n.setRepintado(true);
	    		n = n.getProx();
	    		if(ini == n){
	    			break;
	    		}
	    	}
		}
		
		
		//repintando
		for(Referencia r : this.referencias.values()){
			this.quadro.add(r);
			LinkedListNode n  = (LinkedListNode)r.getNode();
			LinkedListNode ini = n;
	    	while(n != null){
	    		if( n.isRepintado()){
	    			n.setRepintado(false);
					this.quadro.add(n);
	    		}
	    		n = n.getProx();
	    		if(ini == n){
	    			break;
	    		}
	    	}
		}
		
		for(Label l : this.vazias.values()){
			this.quadro.add(l);
		}
		
		
		
	}
	
}
