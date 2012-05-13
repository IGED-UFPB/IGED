package br.ufpb.iged.avaliador.AED;

public class WrapperStruct {

	private Struct s = null;
        
	
	
	public WrapperStruct(Struct s){
		this.s = s;
	}


	public Struct getStruct() {
		return s;
	}

	public void setStruct(Struct s) {
		this.s = s;
	}

	
	
}
