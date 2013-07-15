package br.ufpb.iged.tradutor.simbolos;

import java.util.*;

public class SimboloClasse extends SimboloComEscopo implements Escopo, Tipo {
  
    SimboloClasse superClasse;

    public Map<String,Simbolo> membros = new LinkedHashMap<String,Simbolo>();
    public Map<String, SimboloVariavel> campos = new LinkedHashMap<String,SimboloVariavel>();
    
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
    
    public SimboloVariavel resolverCampo(String nome) {
    	
    	SimboloVariavel f = campos.get(nome);
        
        if ( f!=null ) return f;
        if ( superClasse != null ) {
            return superClasse.resolverCampo(nome);
        }
        
        return null; 
    	
    }
    
    public void definirCampo(SimboloVariavel field) {
        campos.put(field.nome, field);
        field.escopo = this; 
    }

    public Map<String, Simbolo> obterMembros() { 
    	return membros; 
    }
    
    public String toString() {
        return "classe "+nome+":{"+
               stripBrackets(membros.keySet().toString())+"}";
    }
    
}
