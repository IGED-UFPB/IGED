package br.ufpb.iged.tradutor.simbolos;

public class SimboloVariavel extends Simbolo {
	
	private int endereco;
	
	public SimboloVariavel(String nome, Tipo tipo) { 
		super(nome, tipo); 
	}
	
	public SimboloVariavel(String nome, Tipo tipo, int endereco) { 
		super(nome, tipo); 
		this.endereco = endereco;
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}
	
}
