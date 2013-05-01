package br.ufpb.iged.interpretador.symboltable.classes;

public class SimboloTipoPrimitvo extends Simbolo implements Tipo {
	
    public SimboloTipoPrimitvo(String nome) { 
    	
    	super(nome); 
    	
    }

	@Override
	public String obterNome() {
		return nome;
		
	}

    
}
