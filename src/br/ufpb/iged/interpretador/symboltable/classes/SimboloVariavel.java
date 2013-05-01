package br.ufpb.iged.interpretador.symboltable.classes;

public class SimboloVariavel extends Simbolo {
	
	private boolean estatico;
	
	public SimboloVariavel(String nome, Tipo tipo) { 
		
		super(nome, tipo);
		
		this.estatico = false;
		
	}
		
	public SimboloVariavel(String nome, Tipo tipo, boolean estatico) { 
		
		super(nome, tipo);
		
		this.estatico = estatico;
		
	}

	public boolean isEstatico() {
		return estatico;
	}

	public void setEstatico(boolean estatico) {
		this.estatico = estatico;
	}
	
}
