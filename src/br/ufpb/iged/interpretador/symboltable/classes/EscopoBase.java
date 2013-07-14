package br.ufpb.iged.interpretador.symboltable.classes;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class EscopoBase implements Escopo {
	
	private Escopo escopoEnvolvente; 
	
	public Map<String, Simbolo> simbolos = new LinkedHashMap<String, Simbolo>();

    public EscopoBase(Escopo parent) { this.escopoEnvolvente = parent;	}

    public Simbolo resolver(String nome) {
    	
    	Simbolo s = simbolos.get(nome);
    	
        if ( s!=null ) return s;
		if ( obterEscopoPai() != null ) return obterEscopoPai().resolver(nome);
		return null; 
		
	}

	public void definir(Simbolo simbolo) {
		
		simbolos.put(simbolo.nome, simbolo);
		
		simbolo.escopo = this; 
		
	}

    public Escopo obterEscopoPai() {
    	
    	return obterEscopoEnvolvente();
    	
    }
    
    public Escopo obterEscopoEnvolvente() {
    	
    	return escopoEnvolvente;
    	
    }

	public String toString() { return simbolos.keySet().toString(); }
}

