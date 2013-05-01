package br.ufpb.iged.interpretador.symboltable.classes;

public class TabelaSimbolos {
	
	public EscopoGlobal global = new EscopoGlobal();
	
	public TabelaSimbolos() {
		
		global.definir(new SimboloTipoPrimitvo("I"));
		
	}
	
	

}
