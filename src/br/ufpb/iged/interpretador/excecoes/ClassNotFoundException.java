package br.ufpb.iged.interpretador.excecoes;

public class ClassNotFoundException extends Exception{

	private static final long serialVersionUID = 6082261366668401927L;
	
	public ClassNotFoundException() {

		super("Classe n�o encontrada");

	}

	public ClassNotFoundException(String msg) {

		super(msg);

	}

}
