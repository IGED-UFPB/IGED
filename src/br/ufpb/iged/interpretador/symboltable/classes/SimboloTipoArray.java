package br.ufpb.iged.interpretador.symboltable.classes;

public class SimboloTipoArray extends Simbolo implements Tipo{
	
	public static final String INTEIROUMADIMENSAO = "[I";
	
	public SimboloTipoArray(String nome) {
		
		super("");
		
		if (nome.equals(INTEIROUMADIMENSAO))
			super.nome = nome;
		
	}

	@Override
	public String obterNome() {
		
		return nome;
		
	}
		

}
