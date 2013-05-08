package br.ufpb.iged.interpretador.principal;

import br.ufpb.iged.interpretador.symboltable.classes.SimboloClasse;

public class Objeto {
	
	private String nome;
	
	private Object[] memoriaLocal;
	
	public Objeto(SimboloClasse simboloClasse) {
		
		memoriaLocal = new Object[0];
		
		nome = simboloClasse.obterNome();
		
		simboloClasse.alocarMemoriaVariaveis(this, false);
				
	}	
	
	public Objeto(int qtdMemoriaLocal, String nome) {
		
		this.nome = nome;
		
		if (nome.equals("[I"))
			memoriaLocal = new Integer[qtdMemoriaLocal];
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Object[] getMemoriaLocal() {
		return memoriaLocal;
	}

	public void setMemoriaLocal(Object[] memoriaLocal) {
		this.memoriaLocal = memoriaLocal;
	}
	
	

}
