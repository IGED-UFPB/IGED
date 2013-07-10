package br.ufpb.iged.tradutor.simbolos;

import java.util.*;

public class SimboloClasse extends SimboloComEscopo implements Escopo, Tipo {
  
    SimboloClasse superClasse;

    public Map<String,Simbolo> membros = new LinkedHashMap<String,Simbolo>();

    public SimboloClasse(String nome, Escopo escopoEnvolvente, SimboloClasse superClasse) {
        super(nome, escopoEnvolvente);
        this.superClasse = superClasse;
    }

    public Escopo obterEscopoPai() {
    	
        if ( superClasse==null )
        	return escopoEnvolvente; 
        
        return superClasse; 
        
    }

    /** For a.b, only look in a's class hierarchy to resolve b, not globals */
    public Simbolo resolverMembro(String nome) {
    	
        Simbolo s = membros.get(nome);
        
        if ( s!=null ) return s;
        if ( superClasse != null ) {
            return superClasse.resolverMembro(nome);
        }
        
        return null; 
        
    }

    public Map<String, Simbolo> obterMembros() { 
    	return membros; 
    }
    
    public String toString() {
        return "classe "+nome+":{"+
               stripBrackets(membros.keySet().toString())+"}";
    }
    
}
