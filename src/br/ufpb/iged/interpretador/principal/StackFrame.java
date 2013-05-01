package br.ufpb.iged.interpretador.principal;

public class StackFrame {
	
	public static final int TAMANHO_INICIAL_PILHA = 100;
	
	public Object[] pilhaOperandos = new Object[TAMANHO_INICIAL_PILHA];
	
	public Object[] variaveis;
		
	public int sp = -1;
	
	public ProgramCounter pc;
	
	private int nextParam;
	
	public StackFrame(int tamanhoMemoriaLocalVars, boolean estatico) {
		
		
		if (estatico)
			nextParam = 0;
		else {
			nextParam = 1;
			tamanhoMemoriaLocalVars++;
		}
		
		this.variaveis = new Object[tamanhoMemoriaLocalVars];
		
	}
	
	public void inserirValorParametro(Object valor) {
		
		variaveis[nextParam++] = valor;
		
	}
	
	public void inserirThis(Object valor) {
		
		variaveis[0] = valor;
		
	}
	

}
