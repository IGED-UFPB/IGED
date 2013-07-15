package br.ufpb.iged.interpretador.principal;

public class Referencia extends Valor{
	
	public Referencia(Integer endereco, String tipo) {
		
		super(endereco, tipo);
		
	}
	
	/*public String toString() {
		
		return (valor != null)? String.valueOf(((Integer)valor).intValue()) : "null";
		
	}*/
	
	public boolean isNull() {
		
		return valor == null;
		
	}


}
