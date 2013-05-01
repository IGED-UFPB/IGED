package br.ufpb.iged.interpretador.symboltable.classes;

public class EscopoLocal extends EscopoBase {
	
    public EscopoLocal(Escopo pai) { 
    	super(pai); 
    }
    
    public String obterNomeEscopo() { 
    	return "local"; 
    }
    
    
}
