package br.ufpb.iged.interpretador.principal;

public class Valor{
	
	protected String tipo;
	
	protected Object valor;
	
			
	public Valor(Object valor, String tipo){
		
		this.setValor(valor);
		
		this.setTipo(tipo);
		
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
