package br.ufpb.iged.tradutor.simbolos;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class EscopoBase implements Escopo {
	
	Escopo escopoEnvolvente; 
	Map<String, Simbolo> simbolos = new LinkedHashMap<String, Simbolo>();
	
    public EscopoBase(Escopo pai) { 
    	this.escopoEnvolvente = pai;	
    }

    public Simbolo resolver(String nome) {
    	
		Simbolo s = simbolos.get(nome);
		
        if ( s!=null ) return s;
        
		if ( obterEscopoPai() != null ) 
			return obterEscopoPai().resolver(nome);
		
		return null; 
		
	}

	public void definir(Simbolo simb) {
		simbolos.put(simb.nome, simb);
		simb.escopo = this; // track the scope in each symbol
	}

    public Escopo obterEscopoPai() { 
    	return obterEscopoEnvolvente(); 
    }
    
    public Escopo obterEscopoEnvolvente() { 
    	return escopoEnvolvente; 
    }

	public String toString() { return simbolos.keySet().toString(); }
	
}
