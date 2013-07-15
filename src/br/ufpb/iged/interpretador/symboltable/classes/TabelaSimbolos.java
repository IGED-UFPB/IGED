package br.ufpb.iged.interpretador.symboltable.classes;

public class TabelaSimbolos {
	
	public EscopoGlobal global = new EscopoGlobal();
	
	public TabelaSimbolos() {
		
		global.definir(new SimboloTipoPrimitivo(SimboloTipoPrimitivo.INTEIRO));
		global.definir(new SimboloTipoArray(SimboloTipoArray.INTEIROUMADIMENSAO));
		
	}
	
	

}
