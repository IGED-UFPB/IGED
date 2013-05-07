package br.ufpb.iged.interpretador.principal;

import br.ufpb.iged.IGEDConst;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloMetodo;

public class StackFrame {
	
	public static final int TAMANHO_INICIAL_PILHA = 100;
	
	public Object[] pilhaOperandos = new Object[TAMANHO_INICIAL_PILHA];
	
	public Object[] variaveis;
	
	private boolean[] variaveisCriadas;
	
	private int proximaVariavelNaoCriada = 0;
		
	public int sp = -1;
	
	public ProgramCounter pc;
	
	private int nextParam;
	
	private SimboloMetodo metodo;
	
	public StackFrame(SimboloMetodo metodo, boolean estatico) {
		
		this.setMetodo(metodo);
		
		int tamanhoMemoriaLocalVars = metodo.getTamanhoMemoriaLocalVariaveis();
		
		if (estatico)
			nextParam = 0;
		else {
			nextParam = 1;
			tamanhoMemoriaLocalVars++;
		}
		
		this.variaveis = new Object[tamanhoMemoriaLocalVars];
		this.setVariaveisCriadas(new boolean[tamanhoMemoriaLocalVars]);
				
	}
	
	public void inserirValorParametro(Object valor) {
		
		variaveis[nextParam++] = valor;
		
	}
	
	public void inserirThis(Object valor) {
		
		variaveis[0] = valor;
		
	}
	
	public void criarVariavelInteiro(int endereco) {
		
		if (endereco == proximaVariavelNaoCriada) {
			Interpretador.con.creat_Int(""+endereco);
			variaveisCriadas[endereco] = true;
			proximaVariavelNaoCriada++;
		}
		
	}
	
	public void criarVariavelReferencia(int endereco, String tipo) {
		
		if (endereco == proximaVariavelNaoCriada) {
			if (tipo.equals("LList"))
				Interpretador.con.createReference(""+endereco, IGEDConst.LISTA);
			else if (tipo.equals("LNodeList"))
				Interpretador.con.createReference(""+endereco, IGEDConst.NODE);
			else if (tipo.equals("LNodeTree"))
				Interpretador.con.createReference(""+endereco, IGEDConst.NODE_TREE);
			else if (tipo.equals("LIntVector"))
				Interpretador.con.createReference(""+endereco, IGEDConst.VETOR);
			else if (tipo.equals("LBinaryTree"))
				Interpretador.con.createReference(""+endereco, IGEDConst.BINARY_TREE);
			else
				Interpretador.con.creat_Int(""+endereco);
			
			variaveisCriadas[endereco] = true;
			proximaVariavelNaoCriada++;
		}
		
	}

	public boolean[] getVariaveisCriadas() {
		return variaveisCriadas;
	}

	public void setVariaveisCriadas(boolean[] variaveisCriadas) {
		this.variaveisCriadas = variaveisCriadas;
	}

	public int getProximaVariavelNaoCriada() {
		return proximaVariavelNaoCriada;
	}

	public void setProximaVariavelNaoCriada(int proximaVariavelNaoCriada) {
		this.proximaVariavelNaoCriada = proximaVariavelNaoCriada;
	}

	public SimboloMetodo getMetodo() {
		return metodo;
	}

	public void setMetodo(SimboloMetodo metodo) {
		this.metodo = metodo;
	}
	

}
