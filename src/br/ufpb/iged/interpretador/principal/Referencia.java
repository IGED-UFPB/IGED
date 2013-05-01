package br.ufpb.iged.interpretador.principal;

public class Referencia {
	
	protected Integer endereco;
	
	public Referencia(Integer endereco) {
		
		this.setEndereco(endereco);
		
	}

	public Integer getEndereco() {
		return endereco;
	}

	public void setEndereco(Integer endereco) {
		this.endereco = endereco;
	}
	
	public String toString() {
		
		return (endereco != null)? endereco.toString() : "null";
		
	}

}
