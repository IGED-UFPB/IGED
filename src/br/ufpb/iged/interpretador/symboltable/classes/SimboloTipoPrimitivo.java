package br.ufpb.iged.interpretador.symboltable.classes;

public class SimboloTipoPrimitivo extends Simbolo implements Tipo {
	
	public static final String INTEIRO = "I";
	
    public SimboloTipoPrimitivo(String nome) { 
    	
    	super("");
    	
    	if (nome.equals(INTEIRO))
    		super.nome = nome;
    	
    }

	@Override
	public String obterNome() {
		
		return nome;
		
	}

    
}
