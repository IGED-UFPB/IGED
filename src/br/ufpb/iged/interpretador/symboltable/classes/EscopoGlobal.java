package br.ufpb.iged.interpretador.symboltable.classes;

public class EscopoGlobal extends EscopoBase {

	public byte[] codigo;

	public Object[] memoriaGlobal;
	
    public EscopoGlobal() { 
    	super(null); 
    }
    
    public String obterNomeEscopo() { 
    	return "global"; 
    }
     
    
}