package br.ufpb.iged.interpretador.principal;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import br.ufpb.iged.interpretador.symboltable.classes.SimboloMetodo;

public class StackFrame {
	
	public static final int TAMANHO_INICIAL_PILHA = 100;
	
	public Valor[] pilhaOperandos = new Valor[TAMANHO_INICIAL_PILHA];
	
	public Valor[] variaveis;
				
	public int sp = -1;
	
	public ProgramCounter pc;
	
	private int nextParam;
	
	private SimboloMetodo metodo;
		
	private boolean estatico;
	
	private Map<String, String> variaveisCriadas = new HashMap<String, String>();
	
	private Map<Integer, String> referenciasRecebidas = new HashMap<Integer, String>();
	
	private Stack<String> pilhaIdentificadores = new Stack<String>();
		
	public StackFrame(SimboloMetodo metodo, boolean estatico) {
				
		this.setEstatico(estatico);
		
		this.setMetodo(metodo);
		
		int tamanhoMemoriaLocalVars = metodo.getTamanhoMemoriaLocalVariaveis();
		
		if (estatico)
			nextParam = 0;
		else {
			nextParam = 1;
			tamanhoMemoriaLocalVars++;
		}
		
		this.variaveis = new Valor[tamanhoMemoriaLocalVars];
				
	}
	
	public void inserirValorParametro(Valor valor) {
		
		variaveis[nextParam++] = valor;
		
	}
	
	public void inserirThis(Valor valor) {
		
		variaveis[0] = valor;
		
	}

	public SimboloMetodo getMetodo() {
		return metodo;
	}

	public void setMetodo(SimboloMetodo metodo) {
		this.metodo = metodo;
	}

	public boolean isEstatico() {
		return estatico;
	}

	public void setEstatico(boolean estatico) {
		this.estatico = estatico;
	}

	public int getNextParam() {
		return nextParam;
	}

	public void setNextParam(int nextParam) {
		this.nextParam = nextParam;
	}

	public Map<String, String> getVariaveisCriadas() {
		return variaveisCriadas;
	}

	public void setVariaveisCriadas(Map<String, String> variaveisCriadas) {
		this.variaveisCriadas = variaveisCriadas;
	}

	public Map<Integer, String> getReferenciasRecebidas() {
		return referenciasRecebidas;
	}

	public void setReferenciasRecebidas(Map<Integer, String> referenciasRecebidas) {
		this.referenciasRecebidas = referenciasRecebidas;
	}

	public Stack<String> getPilhaIdentificadores() {
		return pilhaIdentificadores;
	}

	public void setPilhaIdentificadores(Stack<String> pilhaIdentificadores) {
		this.pilhaIdentificadores = pilhaIdentificadores;
	}

}
