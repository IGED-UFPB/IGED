package br.ufpb.iged.interpretador.principal;

import br.ufpb.iged.interpretador.symboltable.classes.SimboloClasse;

public class Objeto {
	
	private String nome;
	
	private Valor[] memoriaLocal;
		
	public Objeto(SimboloClasse simboloClasse) {
		
		memoriaLocal = new Valor[0];
		
		nome = simboloClasse.obterNome();
		
		simboloClasse.alocarMemoriaVariaveis(this, false);
						
	}	
	
	public Objeto(int qtdMemoriaLocal, String nome) {
		
		this.nome = nome;
		
		if (nome.equals("[I"))
			memoriaLocal = new Inteiro[qtdMemoriaLocal];
				
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Valor[] getMemoriaLocal() {
		return memoriaLocal;
	}

	public void setMemoriaLocal(Valor[] memoriaLocal) {
		this.memoriaLocal = memoriaLocal;
	}
	

}
