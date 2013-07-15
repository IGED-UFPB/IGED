package br.ufpb.iged.tradutor.simbolos;

import java.util.Map;

public abstract class SimboloComEscopo extends Simbolo implements Escopo {
	
    Escopo escopoEnvolvente;

    public SimboloComEscopo(String nome, Tipo tipo, Escopo escopoEnvolvente) {
        super(nome, tipo);
        this.escopoEnvolvente = escopoEnvolvente;
    }
    
    public SimboloComEscopo(String nome, Escopo escopoEnvolvente) {
        super(nome);
        this.escopoEnvolvente = escopoEnvolvente;
    }

    public Simbolo resolver(String nome) {
    	
        Simbolo s = obterMembros().get(nome);
        
        if ( s!=null ) return s;
        
        if ( obterEscopoPai() != null ) {
            return obterEscopoPai().resolver(nome);
        }
        
        return null;
        
    }

    public void definir(Simbolo simb) {
        obterMembros().put(simb.nome, simb);
        simb.escopo = this; 
    }

    public Escopo obterEscopoPai() { 
    	return obterEscopoEnvolvente(); 
    }
    
    public Escopo obterEscopoEnvolvente() { 
    	return escopoEnvolvente; 
    }    

    public String obterNomeEscopo() { 
    	return nome; 
    }

    public abstract Map<String, Simbolo> obterMembros();
    
}
