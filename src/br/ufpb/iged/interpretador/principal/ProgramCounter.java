package br.ufpb.iged.interpretador.principal;

import br.ufpb.iged.interpretador.bytecodeassembler.asm.BytecodeAssembler;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloMetodo;

public class ProgramCounter {
	
	private SimboloMetodo simboloMetodo;
	
	private int instrucao;
	
	public ProgramCounter(SimboloMetodo metodo) {
		
		this.simboloMetodo = metodo;
		
		instrucao = -1;
		
	}
	
	public void incrementar() {
		
		instrucao++;
		
	}
	
	public void pularOperando() {
		
		instrucao += 4;
		
	}
	
	public void jumpTo(int to) {
		
		instrucao = to;
		
	}
	
	public short obterOpcode() {
		
		return simboloMetodo.getCodigo()[instrucao];
		
	}
	
	public short obterInstrucao(int deslocamento){
		
		return simboloMetodo.getCodigo()[instrucao + deslocamento];
		
	}
	
	public int obterOperandoInteiro() {

		int op = BytecodeAssembler.obterInteiro(simboloMetodo.getCodigo(), instrucao + 1);

		pularOperando();

		return op;

	}

	public SimboloMetodo getSimboloMetodo() {
		return simboloMetodo;
	}

	public void setSimboloMetodo(SimboloMetodo simboloMetodo) {
		this.simboloMetodo = simboloMetodo;
	}

	public int getInstrucao() {
		return instrucao;
	}

	public void setInstrucao(int instrucao) {
		this.instrucao = instrucao;
	}
	
	public String toString() {
		return new Integer(instrucao).toString();
	}

}
