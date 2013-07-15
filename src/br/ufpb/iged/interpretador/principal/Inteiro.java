package br.ufpb.iged.interpretador.principal;

public class Inteiro extends Valor{
	
	public Inteiro(Object valor, String tipo) {
		super(valor, tipo);
	}
	
	public Inteiro(Integer valor) {
		
		super(valor, "I");
		
	}


}
