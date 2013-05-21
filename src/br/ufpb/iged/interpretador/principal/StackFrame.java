package br.ufpb.iged.interpretador.principal;

import java.util.HashMap;
import java.util.Map;

import br.ufpb.iged.IGEDConst;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloMetodo;

public class StackFrame {
	
	public static final int TAMANHO_INICIAL_PILHA = 100;
	
	public Valor[] pilhaOperandos = new Valor[TAMANHO_INICIAL_PILHA];
	
	public Valor[] variaveis;
				
	public int sp = -1;
	
	public ProgramCounter pc;
	
	private int nextParam;
	
	private SimboloMetodo metodo;
	
	private String proprietario;
	
	private boolean estatico;
	
	private Map<String, Integer> variaveisCriadas = new HashMap<String, Integer>();
		
	public StackFrame(String proprietario, SimboloMetodo metodo, boolean estatico) {
		
		this.setProprietario(proprietario);
		
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

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
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

	public Map<String, Integer> getVariaveisCriadas() {
		return variaveisCriadas;
	}

	public void setVariaveisCriadas(Map<String, Integer> variaveisCriadas) {
		this.variaveisCriadas = variaveisCriadas;
	}

}
