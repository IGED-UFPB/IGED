package br.ufpb.iged.tradutor.simbolos;

public class EscopoLocal extends EscopoBase {
	
    public EscopoLocal(Escopo parent) { 
    	super(parent); 
    }
    
    public String obterNomeEscopo() { 
    	return "local"; 
    }
    
}