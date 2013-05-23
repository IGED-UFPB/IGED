package br.ufpb.iged.interpretador.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import br.ufpb.iged.interpretador.bytecodeassembler.asm.Definicao;
import br.ufpb.iged.interpretador.excecoes.ClassNotFoundException;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloClasse;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloMetodo;

public class MaquinaVirtual {
	
	public static final int TAMANHO_PILHA = 100;
	
	private StackFrame[] pilha = new StackFrame[TAMANHO_PILHA];
	
	private StackFrame frameAtual;
	
	private int topoPilha = -1;
		
	public List<Objeto> heap = new ArrayList<Objeto>();
	
	private List<SimboloClasse> areaClasses = new ArrayList<SimboloClasse>();
	
	private int op1, op2;

	private short opcode;

	private boolean desvio = false;
	
	private int tamanhoCodigo;
	
	private boolean novoObjeto = false;
	
	private String idReferenciaAtual = "";
	
	private Scanner in = new Scanner(System.in);
	
	public MaquinaVirtual(List<SimboloClasse> areaClasses) {
		
		setAreaClasses(areaClasses);
		
	}
		
	public void cpu(){
		
		new Thread(){
            @Override
            public void run(){
            	while (frameAtual.pc.getInstrucao() < tamanhoCodigo && topoPilha > -1) {
    				
        			if (!desvio)

        				frameAtual.pc.incrementar();

        			try {
						executarInstrucao();
					} catch (ClassNotFoundException e) {
						System.out.println(e.getMessage());
					}
        				 
        			//exibirTela(frameAtual);
        				 
        		}
            	
            }
        }.start();
        
	}
	
	public void executarInstrucao() throws ClassNotFoundException {
		
		desvio = false;
		
		String id;

		opcode = frameAtual.pc.obterOpcode();

		if (opcode < 0)

			opcode = valorEmByte(opcode);

		switch (opcode) {

		// operações de pilha

		case Definicao.NOP:
			;
			break;

		case Definicao.POP: {
			frameAtual.sp-- ;
			frameAtual.getPilhaIdentificadores().pop();
		};
		break;

		case Definicao.POP2: {
			frameAtual.sp -= 2 ;
			frameAtual.getPilhaIdentificadores().pop();
			frameAtual.getPilhaIdentificadores().pop();
		};
		break;

		case Definicao.DUP: {
			
			Valor valor = frameAtual.pilhaOperandos[frameAtual.sp];
			
			frameAtual.pilhaOperandos[++frameAtual.sp] = null;
			
			frameAtual.pilhaOperandos[frameAtual.sp] = valor;
			
			String topo = frameAtual.getPilhaIdentificadores().peek();
			frameAtual.getPilhaIdentificadores().push(topo);

		}
		;
		break;

		// operações aritméticas

		case Definicao.INEG: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(0 - op1);
			
			Interpretador.con.readReferenceInt(String.valueOf(frameAtual.pilhaOperandos[frameAtual.sp].getValor()));

		};
		break;

		case Definicao.IADD: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp--;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(op1 + op2);
			
			Interpretador.con.readReferenceInt(String.valueOf(frameAtual.pilhaOperandos[frameAtual.sp].getValor()));
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.ISUB: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp--;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(op1 - op2);
			
			Interpretador.con.readReferenceInt(String.valueOf(frameAtual.pilhaOperandos[frameAtual.sp].getValor()));
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IMUL: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp--;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(op1 * op2);
			
			Interpretador.con.readReferenceInt(String.valueOf(frameAtual.pilhaOperandos[frameAtual.sp].getValor()));
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IDIV: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp--;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(op1 / op2);
			
			Interpretador.con.readReferenceInt(String.valueOf(frameAtual.pilhaOperandos[frameAtual.sp].getValor()));
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IREM: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp--;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(op1 % op2);
			
			Interpretador.con.readReferenceInt(String.valueOf(frameAtual.pilhaOperandos[frameAtual.sp].getValor()));
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IINC: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(++op1);
			
			Interpretador.con.readReferenceInt(String.valueOf(frameAtual.pilhaOperandos[frameAtual.sp].getValor()));

		}
		;
		break;

		// operações de empilhamento de constantes

		case Definicao.ICONST0: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(0);
			
			Interpretador.con.readReferenceInt("0");
			
			frameAtual.getPilhaIdentificadores().push("");

		}
		;
		break;

		case Definicao.ICONST1: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(1);
			
			Interpretador.con.readReferenceInt("1");
			
			frameAtual.getPilhaIdentificadores().push("");

		}
		;
		break;

		case Definicao.ICONST2: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(2);
			
			Interpretador.con.readReferenceInt("2");
			
			frameAtual.getPilhaIdentificadores().push("");

		}
		;
		break;

		case Definicao.ICONST3: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(3);
			
			Interpretador.con.readReferenceInt("3");
			
			frameAtual.getPilhaIdentificadores().push("");

		}
		;
		break;

		case Definicao.ICONST4: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(4);
			
			Interpretador.con.readReferenceInt("4");
			
			frameAtual.getPilhaIdentificadores().push("");

		}
		;
		break;

		case Definicao.ICONST5: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(5);
			
			Interpretador.con.readReferenceInt("5");
			
			frameAtual.getPilhaIdentificadores().push("");

		}
		;
		break;

		case Definicao.ICONSTM1: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(-1);
			
			Interpretador.con.readReferenceInt("-1");
			
			frameAtual.getPilhaIdentificadores().push("");

		}
		;
		break;

		case Definicao.ACONSTNULL: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = new Referencia(null, null);
			
			frameAtual.getPilhaIdentificadores().push("");

		}
		;
		break;

		case Definicao.LDC: {

			frameAtual.sp++;

			op1 = frameAtual.pc.obterOperandoInteiro();

			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(op1);
			
			Interpretador.con.readReferenceInt(""+op1);
			
			frameAtual.getPilhaIdentificadores().push("");

		}
		;
		break;

		// operações de load

		case Definicao.ILOAD0: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = frameAtual.variaveis[0];
			
			id = obterIdentificadorVariavel(0);
			
			Interpretador.con.ler_Int(id);
			
			frameAtual.getPilhaIdentificadores().push(id);

		}
		;
		break;

		case Definicao.ILOAD1: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = frameAtual.variaveis[1];
			
			id = obterIdentificadorVariavel(1);
			
			Interpretador.con.ler_Int(id);
			
			frameAtual.getPilhaIdentificadores().push(id);

		}
		;
		break;

		case Definicao.ILOAD2: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = frameAtual.variaveis[2];
			
			id = obterIdentificadorVariavel(2);
			
			Interpretador.con.ler_Int(id);
			
			frameAtual.getPilhaIdentificadores().push(id);

		}
		;
		break;

		case Definicao.ILOAD3: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = frameAtual.variaveis[3];
			
			id = obterIdentificadorVariavel(3);
			
			Interpretador.con.ler_Int(id);
			
			frameAtual.getPilhaIdentificadores().push(id);
			

		}
		;
		break;

		case Definicao.ILOAD: {

			frameAtual.sp++;

			op1 = frameAtual.pc.obterOperandoInteiro();

			frameAtual.pilhaOperandos[frameAtual.sp] = frameAtual.variaveis[op1];
			
			id = obterIdentificadorVariavel(op1);
			
			Interpretador.con.ler_Int(id);
			
			frameAtual.getPilhaIdentificadores().push(id);

		}
		;
		break;

		case Definicao.ALOAD0: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = frameAtual.variaveis[0];
			
			idReferenciaAtual = obterIdentificadorVariavel(0);
			
			id = obterIdentificadorVariavel(0);
			
			Interpretador.con.readReference(id);
			
			frameAtual.getPilhaIdentificadores().push(id);

		}
		;
		break;

		case Definicao.ALOAD1: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = frameAtual.variaveis[1];
			
			idReferenciaAtual = obterIdentificadorVariavel(1);
			
			id = obterIdentificadorVariavel(1);
			
			Interpretador.con.readReference(id);
			
			frameAtual.getPilhaIdentificadores().push(id);

		}
		;
		break;

		case Definicao.ALOAD2: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = frameAtual.variaveis[2];
			
			id = obterIdentificadorVariavel(2);
			
			Interpretador.con.readReference(id);
			
			frameAtual.getPilhaIdentificadores().push(id);


		}
		;
		break;

		case Definicao.ALOAD3: {

			frameAtual.sp++;

			frameAtual.pilhaOperandos[frameAtual.sp] = frameAtual.variaveis[3];
			
			id = obterIdentificadorVariavel(3);
			
			Interpretador.con.readReference(id);
			
			frameAtual.getPilhaIdentificadores().push(id);


		}
		;
		break;

		case Definicao.ALOAD: {

			frameAtual.sp++;

			op1 = frameAtual.pc.obterOperandoInteiro();

			frameAtual.pilhaOperandos[frameAtual.sp] = frameAtual.variaveis[op1];
			
			id = obterIdentificadorVariavel(op1);
			
			Interpretador.con.readReference(id);
			
			frameAtual.getPilhaIdentificadores().push(id);

		}
		;
		break;
		
		case Definicao.IALOAD: {
			
			int indice = (Integer)frameAtual.pilhaOperandos[frameAtual.sp--].getValor();
			Referencia referencia = (Referencia)frameAtual.pilhaOperandos[frameAtual.sp--];
			
			Objeto objeto = heap.get((Integer)referencia.getValor());
			frameAtual.pilhaOperandos[++frameAtual.sp] = new Inteiro((Integer)objeto.getMemoriaLocal()[indice].getValor());
			
			frameAtual.getPilhaIdentificadores().pop();
			frameAtual.getPilhaIdentificadores().pop();
			
			frameAtual.getPilhaIdentificadores().push("");
			
		}
		;
		break;

		// operações de store

		case Definicao.ISTORE0: {

			frameAtual.variaveis[0] = frameAtual.pilhaOperandos[frameAtual.sp];

			frameAtual.sp--;
			
			salvarInteiro(obterIdentificadorVariavel(0), 0, false, frameAtual.variaveis[0]);

			frameAtual.getPilhaIdentificadores().pop();
			
		}
		;
		break;

		case Definicao.ISTORE1: {

			frameAtual.variaveis[1] = frameAtual.pilhaOperandos[frameAtual.sp];

			frameAtual.sp--;
			
			salvarInteiro(obterIdentificadorVariavel(1), 1, false, frameAtual.variaveis[1]);
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.ISTORE2: {

			frameAtual.variaveis[2] = frameAtual.pilhaOperandos[frameAtual.sp];

			frameAtual.sp--;
			
			salvarInteiro(obterIdentificadorVariavel(2), 2, false, frameAtual.variaveis[2]);
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.ISTORE3: {

			frameAtual.variaveis[3] = frameAtual.pilhaOperandos[frameAtual.sp];

			frameAtual.sp--;
			
			salvarInteiro(obterIdentificadorVariavel(3), 3, false, frameAtual.variaveis[3]);
			
			frameAtual.getPilhaIdentificadores().pop();
			
		}
		;
		break;

		case Definicao.ISTORE: {

			op1 = frameAtual.pc.obterOperandoInteiro();

			frameAtual.variaveis[op1] = frameAtual.pilhaOperandos[frameAtual.sp];

			frameAtual.sp--;
			
			salvarInteiro(obterIdentificadorVariavel(op1), op1, false, frameAtual.variaveis[op1]);
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.ASTORE0: {
			
			Referencia referencia = (Referencia)frameAtual.pilhaOperandos[frameAtual.sp];
									
			salvarReferencia(obterIdentificadorVariavel(0), 0, false, frameAtual.variaveis[0], referencia);

			frameAtual.variaveis[0] = frameAtual.pilhaOperandos[frameAtual.sp];
			
			frameAtual.sp--;
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.ASTORE1: {
			
			Referencia referencia = (Referencia)frameAtual.pilhaOperandos[frameAtual.sp];
			
			salvarReferencia(obterIdentificadorVariavel(1), 1, false, frameAtual.variaveis[1], referencia);

			frameAtual.variaveis[1] = frameAtual.pilhaOperandos[frameAtual.sp];

			frameAtual.sp--;
			
			frameAtual.getPilhaIdentificadores().pop();
		
		}
		;
		break;

		case Definicao.ASTORE2: {
			
			Referencia referencia = (Referencia)frameAtual.pilhaOperandos[frameAtual.sp];
			
			salvarReferencia(obterIdentificadorVariavel(2), 2, false, frameAtual.variaveis[2], referencia);

			frameAtual.variaveis[2] = frameAtual.pilhaOperandos[frameAtual.sp];

			frameAtual.sp--;
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.ASTORE3: {
			
			Referencia referencia = (Referencia)frameAtual.pilhaOperandos[frameAtual.sp];

			salvarReferencia(obterIdentificadorVariavel(3), 3, false, frameAtual.variaveis[3], referencia);
			
			frameAtual.variaveis[3] = frameAtual.pilhaOperandos[frameAtual.sp];

			frameAtual.sp--;
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.ASTORE: {

			op1 = frameAtual.pc.obterOperandoInteiro();
			
			Referencia referencia = (Referencia)frameAtual.pilhaOperandos[frameAtual.sp];
			
			salvarReferencia(obterIdentificadorVariavel(op1), op1, false, frameAtual.variaveis[op1], referencia);

			frameAtual.variaveis[op1] = frameAtual.pilhaOperandos[frameAtual.sp];

			frameAtual.sp--;
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;
		
		case Definicao.IASTORE: {
			
			int valor = (Integer)frameAtual.pilhaOperandos[frameAtual.sp--].getValor();
			int indice = (Integer)frameAtual.pilhaOperandos[frameAtual.sp--].getValor();
			Referencia referencia = (Referencia)frameAtual.pilhaOperandos[frameAtual.sp--];
			
			Objeto objeto = heap.get((Integer)referencia.getValor());
			
			objeto.getMemoriaLocal()[indice] = new Inteiro(valor);
			
        	Interpretador.con.setPosVector(indice);
        	Interpretador.con.writeStructInfo(valor);
        	
        	Interpretador.con.endCommand();
        	
        	frameAtual.getPilhaIdentificadores().pop();
        	frameAtual.getPilhaIdentificadores().pop();
        	frameAtual.getPilhaIdentificadores().pop();
			
		}
		;
		break;

		// operações lógicas

		case Definicao.IAND: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			op1 = op1 & op2;

			frameAtual.pilhaOperandos[--frameAtual.sp] = new Inteiro(op1);
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IOR: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			op1 = op1 | op2;

			frameAtual.pilhaOperandos[--frameAtual.sp] = new Inteiro(op1);
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IXOR: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			op1 = op1 ^ op2;

			frameAtual.pilhaOperandos[--frameAtual.sp] = new Inteiro(op1);
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		// operações de desvio condicional

		case Definicao.IFEQ: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();
			
			frameAtual.sp--;

			if (op1 == 0) {

				desviar(frameAtual);

				desvio = true;

			} else 

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IFNE: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();
			
			frameAtual.sp--;

			if (op1 != 0) {

				desviar(frameAtual);

				desvio = true;

			} else 

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();


		}
		;
		break;

		case Definicao.IFLT: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp--;
			
			if (op1 > 0) {

				desviar(frameAtual);

				desvio = true;

			} else 

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IFGE: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();
			
			frameAtual.sp--;
			
			if (op1 >= 0) {

				desviar(frameAtual);

				desvio = true;

			} else 

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IFGT: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();
			
			frameAtual.sp--;

			if (op1 > 0) {

				desviar(frameAtual);

				desvio = true;

			} else 

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IFLE: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp--;
			
			if (op1 <= 0) {

				desviar(frameAtual);

				desvio = true;

			} else 

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();


		}
		;
		break;

		case Definicao.IF_ICMPEQ: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp -= 2;

			if (op1 == op2) {

				desviar(frameAtual);

				desvio = true;

			} else 

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IF_ICMPNE: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp -= 2;

			if (op1 != op2) {

				desviar(frameAtual);

				desvio = true;

			} else 

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IF_ICMPLT: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp -= 2;

			if (op1 < op2) {

				desviar(frameAtual);

				desvio = true;

			} else

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();
			frameAtual.getPilhaIdentificadores().pop();


		}
		;
		break;

		case Definicao.IF_ICMPGE: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp -= 2;

			if (op1 >= op2) {

				desviar(frameAtual);

				desvio = true;

			} else 

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();
			frameAtual.getPilhaIdentificadores().pop();


		}
		;
		break;

		case Definicao.IF_ICMPGT: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp -= 2;

			if (op1 > op2) {

				desviar(frameAtual);

				desvio = true;

			} else 

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		case Definicao.IF_ICMPLE: {

			op1 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp - 1].getValor();

			op2 = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();

			frameAtual.sp -= 2;

			if (op1 <= op2) {

				desviar(frameAtual);

				desvio = true;

			} else

				frameAtual.pc.pularOperando();
			
			frameAtual.getPilhaIdentificadores().pop();
			frameAtual.getPilhaIdentificadores().pop();

		}
		;
		break;

		// desvio incondicional
		case Definicao.GOTO: {

			op1 = frameAtual.pc.obterOperandoInteiro();

			frameAtual.pc.jumpTo(op1);

			desvio = true;

		}
		;
		break;

		//manipulação de objetos

		case Definicao.NEW: {

			op1 = frameAtual.pc.obterOperandoInteiro();

			SimboloClasse simboloClasse = ClassLoader.carregarClasse(op1);
			
			Objeto objeto = new Objeto(simboloClasse);

			heap.add(objeto);

			frameAtual.pilhaOperandos[++frameAtual.sp] = new Referencia(heap.indexOf(objeto), objeto.getNome());
			
			novoObjeto = true;
			
			frameAtual.getPilhaIdentificadores().push("");
			
		}

		;
		break;
		
		case Definicao.NEWARRAY: {
			
			op1 = frameAtual.pc.obterOperandoInteiro();
			int tamArray = (Integer)frameAtual.pilhaOperandos[frameAtual.sp].getValor();
			Objeto objeto = null;
			
			if (op1 == 2)
				objeto = new Objeto(tamArray, "[I");
			
			heap.add(objeto);
			
			Referencia referencia = new Referencia(heap.indexOf(objeto), objeto.getNome());
			
			frameAtual.pilhaOperandos[frameAtual.sp] = referencia;
			
			novoObjeto = true;

		}
		
		;
		break;
		
		case Definicao.INVOKEVIRTUAL: {
			
			op1 = frameAtual.pc.obterOperandoInteiro();
			
			op2 = frameAtual.pc.obterOperandoInteiro();
			
			SimboloClasse simboloClasse = ClassLoader.carregarClasse(op1);
			
			SimboloMetodo simboloMetodo = simboloClasse.getMethodArea().get(op2);
			
			Referencia referencia = (Referencia)frameAtual.pilhaOperandos[0];
			
			Objeto objeto = heap.get((Integer)referencia.getValor());
						
			if (!objeto.getNome().equals(simboloClasse.getNome())){
				simboloClasse = (SimboloClasse)Interpretador.tabelaSimbolos.global.resolver(objeto.getNome());
				simboloMetodo = (SimboloMetodo)simboloClasse.resolverMetodoVirtual(simboloMetodo.getNome());				
			}
									
			List<String> params = new ArrayList<String>();
			
			while(!frameAtual.getPilhaIdentificadores().isEmpty())
				params.add(frameAtual.getPilhaIdentificadores().pop());
			
			Collections.reverse(params);
			
			iniciarNovoMetodo(params, simboloMetodo, false);

		}
		
		;
		break;

		case Definicao.INVOKESPECIAL: {

			op1 = frameAtual.pc.obterOperandoInteiro();
			
			op2 = frameAtual.pc.obterOperandoInteiro();
			
			SimboloClasse simboloClasse = ClassLoader.carregarClasse(op1);
			
			SimboloMetodo simboloMetodo = (SimboloMetodo) simboloClasse.getMethodArea().get(op2);
			
			boolean estatico = simboloMetodo.isEstatico();
			List<String> params = new ArrayList<String>();
								
			while(!frameAtual.getPilhaIdentificadores().isEmpty())
				params.add(frameAtual.getPilhaIdentificadores().pop());
							
			Collections.reverse(params);
			
			iniciarNovoMetodo(params, simboloMetodo, estatico);

		}

		;
		break;

		case Definicao.GETFIELD: {

			Referencia referencia = (Referencia)frameAtual.pilhaOperandos[frameAtual.sp];

			Objeto objeto = heap.get((Integer)referencia.getValor());

			op1 = frameAtual.pc.obterOperandoInteiro();
			
			SimboloClasse simboloClasse = (SimboloClasse)Interpretador.tabelaSimbolos.global.resolver(objeto.getNome());
			String idField = simboloClasse.obterIdentificadorVariavel(op1, false);
			
			String idRef = frameAtual.getPilhaIdentificadores().pop();
			
			String idCampo = idRef+"."+idField+obterSufixoVariavel(idRef+"."+idField);
			
			frameAtual.getPilhaIdentificadores().push(idCampo);
			
			if (!Interpretador.ehTipoEstruturaDeDadosReferencia(objeto.getNome())){
			
				if (objeto.getMemoriaLocal()[op1].getTipo().equals("I"))				
					Interpretador.con.ler_Int(idCampo);		
				else 
					Interpretador.con.readReference(idCampo);
			
			}

			frameAtual.pilhaOperandos[frameAtual.sp] = null;

			frameAtual.pilhaOperandos[frameAtual.sp] = objeto.getMemoriaLocal()[op1];
			
			if (objeto.getNome().equals("LList")) {				
				if (op1 == 0)
					Interpretador.con.readReferenceField(Interpretador.referenceField("init"));				
			} else if (objeto.getNome().equals("LNodeList")) {				
				if (op1 == 0)
					Interpretador.con.readStructInfo();
				else if (op1 == 1)
					Interpretador.con.readReferenceField(Interpretador.referenceField("next"));
			} else if (objeto.getNome().equals("LTree")) {
				if (op1 == 0)
					Interpretador.con.readReferenceField(Interpretador.referenceField("init"));									
			} else if (objeto.getNome().equals("LNodeTree")) {				
				if (op1 == 0)
					Interpretador.con.readReferenceField(Interpretador.referenceField("node_root"));									
				else if (op1 == 1)
					Interpretador.con.readReferenceField(Interpretador.referenceField("left_chield"));									
				else if (op1 == 2)
					Interpretador.con.readReferenceField(Interpretador.referenceField("right_chield"));
				else if (op1 == 3)
					Interpretador.con.readStructInfo();					
			}
			

		}

		;
		break;

		case Definicao.PUTFIELD: {

			Referencia referencia = (Referencia)frameAtual.pilhaOperandos[frameAtual.sp - 1];

			Objeto objeto = heap.get((Integer)referencia.getValor());

			op1 = frameAtual.pc.obterOperandoInteiro();
			
			//SimboloClasse classe = (SimboloClasse)Interpretador.tabelaSimbolos.global.resolver(objeto.getNome());
			
			Valor valorAntigo = objeto.getMemoriaLocal()[op1];
			
			objeto.getMemoriaLocal()[op1] = frameAtual.pilhaOperandos[frameAtual.sp--];
			
			frameAtual.sp--;
				
			if (objeto.getNome().equals("LList")) {				
				if (op1 == 0) {
					if (((Referencia)objeto.getMemoriaLocal()[op1]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("init"));
					else {
						Interpretador.con.writeReferenceField(Interpretador.referenceField("init"));
						Interpretador.con.endCommand();
					}
				} else if (op1 == 1)
					Interpretador.con.writeStructLength((Integer)objeto.getMemoriaLocal()[op1].getValor());				
			} else if (objeto.getNome().equals("LNodeList")) {				
				if (op1 == 0)
					Interpretador.con.writeStructInfo((Integer)objeto.getMemoriaLocal()[op1].getValor());
				else if (op1 == 1){					
					if (((Referencia)objeto.getMemoriaLocal()[op1]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("next"));
					else {
						Interpretador.con.writeReferenceField(Interpretador.referenceField("next"));
						Interpretador.con.endCommand();
					}
				}				
			} else if (objeto.getNome().equals("LVector")) {
				if (op1 == 0)
					Interpretador.con.setPosVector((Integer)objeto.getMemoriaLocal()[op1].getValor());
				else if (op1 == 1)
					Interpretador.con.writeStructLength((Integer)objeto.getMemoriaLocal()[op1].getValor());
			} else if (objeto.getNome().equals("LTree")) {
				if (op1 == 0){
					if (((Referencia)objeto.getMemoriaLocal()[op1]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("init"));
					else
						Interpretador.con.writeReferenceField(Interpretador.referenceField("init"));
				} else if (op1 == 1)
					Interpretador.con.writeStructLength((Integer)objeto.getMemoriaLocal()[op1].getValor());
				else if (op1 == 2)
					Interpretador.con.SetHeight(((Integer)objeto.getMemoriaLocal()[op1].getValor()).toString());					
			} else if (objeto.getNome().equals("LNodeTree")) {				
				if (op1 == 0){					
					if (((Referencia)objeto.getMemoriaLocal()[op1]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("node_root"));
					else
						Interpretador.con.writeReferenceField(Interpretador.referenceField("node_root"));					
				} else if (op1 == 1) {
					if (((Referencia)objeto.getMemoriaLocal()[op1]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("left_chield"));
					else
						Interpretador.con.writeReferenceField(Interpretador.referenceField("left_chield"));
				} else if (op1 == 2){
					if (((Referencia)objeto.getMemoriaLocal()[op1]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("right_chield"));
					else
						Interpretador.con.writeReferenceField(Interpretador.referenceField("right_chield"));
				} else if (op1 == 3)
					Interpretador.con.writeStructInfo((Integer)objeto.getMemoriaLocal()[op1].getValor());
					
			}
			
			int sp = frameAtual.sp + 2;
			
			String tipo = frameAtual.pilhaOperandos[sp].getTipo();
			
			String tipoRef = frameAtual.pilhaOperandos[sp -1].getTipo();
			
			frameAtual.getPilhaIdentificadores().pop();
			
			SimboloClasse simboloClasse = (SimboloClasse)Interpretador.tabelaSimbolos.global.resolver(objeto.getNome());
			String idField = simboloClasse.obterIdentificadorVariavel(op1, false);
			
			String idRef = frameAtual.getPilhaIdentificadores().pop();
			
			String idCampo = idRef+"."+idField+obterSufixoVariavel(idRef+"."+idField);
						
			if (!Interpretador.ehTipoEstruturaDeDadosReferencia(tipoRef)) {
			
				if (tipo != null){
					if (tipo.equals("I"))
						salvarInteiro(idCampo, op1, true, valorAntigo);
					else
						salvarReferencia(idCampo, op1, true, valorAntigo, (Referencia)frameAtual.pilhaOperandos[sp]);
				}
			
			}

		}

		;
		break;
		
		//métodos e variáveis estáticas
		
		case Definicao.INVOKESTATIC: {
			
			op1 = frameAtual.pc.obterOperandoInteiro();
			
			op2 = frameAtual.pc.obterOperandoInteiro();
			
			SimboloClasse simboloClasse =  ClassLoader.carregarClasse(op1);
			
			SimboloMetodo simboloMetodo = (SimboloMetodo) simboloClasse.getMethodArea().get(op2);
			
			List<String> params = new ArrayList<String>();
			
			while(!frameAtual.getPilhaIdentificadores().isEmpty())
				params.add(frameAtual.getPilhaIdentificadores().pop());
											
			Collections.reverse(params);
					
			iniciarNovoMetodo(params, simboloMetodo, true);			
			
		}
		
		;
		break;
		
		case Definicao.GETSTATIC: {
			
			op1 = frameAtual.pc.obterOperandoInteiro();
			
			op2 = frameAtual.pc.obterOperandoInteiro();
						
			SimboloClasse simboloClasse =  ClassLoader.carregarClasse(op1);
			String idField = simboloClasse.obterIdentificadorVariavel(op2, true);
			
			String idCampo = simboloClasse.obterNomeSimples()+"."+idField+obterSufixoVariavel(simboloClasse.obterNomeSimples()+"."+idField);

			
			frameAtual.getPilhaIdentificadores().push(idCampo);
			
			if (!Interpretador.ehTipoEstruturaDeDadosReferencia(simboloClasse.getNome())){
			
				if (simboloClasse.getFields()[op2].getTipo().equals("I"))				
					Interpretador.con.ler_Int(idCampo);		
				else 
					Interpretador.con.readReference(idCampo);
			
			}

			frameAtual.pilhaOperandos[frameAtual.sp] = null;
			
			frameAtual.pilhaOperandos[frameAtual.sp] = simboloClasse.getFields()[op2];
			
			if (simboloClasse.getNome().equals("LList")) {				
				if (op2 == 0)
					Interpretador.con.readReferenceField(Interpretador.referenceField("init"));				
			} else if (simboloClasse.getNome().equals("LNodeList")) {				
				if (op2 == 0)
					Interpretador.con.readStructInfo();
				else if (op2 == 1)
					Interpretador.con.readReferenceField(Interpretador.referenceField("next"));
			} else if (simboloClasse.getNome().equals("LTree")) {
				if (op2 == 0)
					Interpretador.con.readReferenceField(Interpretador.referenceField("init"));									
			} else if (simboloClasse.getNome().equals("LNodeTree")) {				
				if (op2 == 0)
					Interpretador.con.readReferenceField(Interpretador.referenceField("node_root"));									
				else if (op2 == 1)
					Interpretador.con.readReferenceField(Interpretador.referenceField("left_chield"));									
				else if (op2 == 2)
					Interpretador.con.readReferenceField(Interpretador.referenceField("right_chield"));
				else if (op2 == 3)
					Interpretador.con.readStructInfo();					
			}
			
			
		}
		
		;
		break;
		
		case Definicao.PUTSTATIC: {
			
			op1 = frameAtual.pc.obterOperandoInteiro();
			
			op2 = frameAtual.pc.obterOperandoInteiro();
			
			SimboloClasse simboloClasse =  ClassLoader.carregarClasse(op1);
						
			Valor valorAntigo = simboloClasse.getFields()[op2];
			
			simboloClasse.alterarCampo(op2, frameAtual.pilhaOperandos[frameAtual.sp--]);
							
			if (simboloClasse.getNome().equals("LList")) {				
				if (op2 == 0) {
					if (((Referencia)simboloClasse.getFields()[op2]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("init"));
					else {
						Interpretador.con.writeReferenceField(Interpretador.referenceField("init"));
						Interpretador.con.endCommand();
					}
				} else if (op2 == 1)
					Interpretador.con.writeStructLength((Integer)simboloClasse.getFields()[op2].getValor());				
			} else if (simboloClasse.getNome().equals("LNodeList")) {				
				if (op2 == 0)
					Interpretador.con.writeStructInfo((Integer)simboloClasse.getFields()[op2].getValor());
				else if (op2 == 1){					
					if (((Referencia)simboloClasse.getFields()[op2]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("next"));
					else {
						Interpretador.con.writeReferenceField(Interpretador.referenceField("next"));
						Interpretador.con.endCommand();
					}
				}				
			} else if (simboloClasse.getNome().equals("LVector")) {
				if (op2 == 0)
					Interpretador.con.setPosVector((Integer)simboloClasse.getFields()[op2].getValor());
				else if (op2 == 1)
					Interpretador.con.writeStructLength((Integer)simboloClasse.getFields()[op2].getValor());
			} else if (simboloClasse.getNome().equals("LTree")) {
				if (op2 == 0){
					if (((Referencia)simboloClasse.getFields()[op2]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("init"));
					else
						Interpretador.con.writeReferenceField(Interpretador.referenceField("init"));
				} else if (op2 == 1)
					Interpretador.con.writeStructLength((Integer)simboloClasse.getFields()[op2].getValor());
				else if (op2 == 2)
					Interpretador.con.SetHeight(((Integer)simboloClasse.getFields()[op2].getValor()).toString());					
			} else if (simboloClasse.getNome().equals("LNodeTree")) {				
				if (op2 == 0){					
					if (((Referencia)simboloClasse.getFields()[op2]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("node_root"));
					else
						Interpretador.con.writeReferenceField(Interpretador.referenceField("node_root"));					
				} else if (op2 == 1) {
					if (((Referencia)simboloClasse.getFields()[op2]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("left_chield"));
					else
						Interpretador.con.writeReferenceField(Interpretador.referenceField("left_chield"));
				} else if (op2 == 2){
					if (((Referencia)simboloClasse.getFields()[op2]).isNull())
						Interpretador.con.writeReferenceFieldNull(Interpretador.referenceField("right_chield"));
					else
						Interpretador.con.writeReferenceField(Interpretador.referenceField("right_chield"));
				} else if (op2 == 3)
					Interpretador.con.writeStructInfo((Integer)simboloClasse.getFields()[op2].getValor());
					
			}
			
			int sp = frameAtual.sp + 2;
			
			String tipo = frameAtual.pilhaOperandos[sp].getTipo();
						
			frameAtual.getPilhaIdentificadores().pop();
			
			String idField = simboloClasse.obterIdentificadorVariavel(op2, true);
			
			String idCampo = simboloClasse.obterNomeSimples()+"."+idField + obterSufixoVariavel(simboloClasse.obterNomeSimples()+"."+idField);
						
			if (!Interpretador.ehTipoEstruturaDeDadosReferencia(simboloClasse.getNome())) {
			
				if (tipo != null){
					if (tipo.equals("I"))
						salvarInteiro(idCampo, op2, true, valorAntigo);
					else
						salvarReferencia(idCampo, op2, true, valorAntigo, (Referencia)frameAtual.pilhaOperandos[sp]);
				}
			
			}
									
		}
		
		;
		break;
		
		//retorno de métodos
		case Definicao.RETURN: {
			
			if (topoPilha > 0)
				removerVariaveisGraficas();
			
			SimboloMetodo metodo = frameAtual.getMetodo();
			
			topoPilha--;
			
			if (topoPilha > -1) {
			
				frameAtual = pilha[topoPilha];
			
				for (int i = 0; i < metodo.contarParametros(); i++)
					frameAtual.sp--;
				
				frameAtual.sp--;
				
			}
			
		}
		
		;
		break;
		
		case Definicao.IRETURN: {
			
			if (topoPilha > 0)
				removerVariaveisGraficas();
						
			Integer valor = (Integer) frameAtual.pilhaOperandos[frameAtual.sp].getValor();
			
			int qtdParametros = frameAtual.getMetodo().contarParametros();
			
			frameAtual = pilha[--topoPilha];
			
			for (int i = 0; i < qtdParametros; i++)
				frameAtual.sp--;
			
			frameAtual.pilhaOperandos[frameAtual.sp] = new Inteiro(valor);
			
		}
		
		;
		break;
		
		case Definicao.ARETURN: {
			
			if (topoPilha > 0)
				removerVariaveisGraficas();
			
			Referencia valor = (Referencia) frameAtual.pilhaOperandos[frameAtual.sp];
			
			int qtdParametros = frameAtual.getMetodo().contarParametros();
			
			frameAtual = pilha[--topoPilha];
			
			for (int i = 0; i < qtdParametros; i++)
				frameAtual.sp--;
			
			frameAtual.pilhaOperandos[frameAtual.sp] = valor;
			
		}
		
		;
		break;

		}
		
	}
	
	public void iniciarNovoMetodo(List<String> idsParams, SimboloMetodo metodo, boolean estatico) {
		
		pilha[++topoPilha] =  new StackFrame(metodo, estatico);
		
		pilha[topoPilha].pc = new ProgramCounter(metodo);
		
		tamanhoCodigo = metodo.obterTamanhoCodigo();
		
		frameAtual = pilha[topoPilha];
		
		int i;
		
		int qtdParams = metodo.contarParametros();
		
		Valor v;
		
		for (i = 0; i < qtdParams; i++) {
			
			v = pilha[topoPilha - 1].pilhaOperandos[pilha[topoPilha - 1].sp - i];
			
			int endereco = frameAtual.getNextParam();
			
			if (v.getTipo().equals("I")){
				frameAtual.variaveis[endereco] = new Inteiro(0);
				salvarInteiro(obterIdentificadorVariavel(endereco), endereco, false, frameAtual.variaveis[endereco]);
			} else {
				frameAtual.variaveis[endereco] = new Referencia(new Integer(0), v.getTipo());
				salvarReferencia(obterIdentificadorVariavel(endereco), endereco, false, frameAtual.variaveis[endereco], (Referencia)v);
				frameAtual.getReferenciasRecebidas().put(endereco, idsParams.get(endereco));
			}
			
			frameAtual.inserirValorParametro(v);

			
		}
				
		if (!estatico) {
		
			frameAtual.inserirThis(pilha[topoPilha - 1].pilhaOperandos[pilha[topoPilha - 1].sp - i]);
			frameAtual.getReferenciasRecebidas().put(0, idsParams.get(0));
			
		}
				
		tamanhoCodigo = frameAtual.pc.getSimboloMetodo().obterTamanhoCodigo();
		
	}
	
	protected void desviar(StackFrame frame) {

		int op = frame.pc.obterOperandoInteiro();

		frame.pc.jumpTo(op);

	}
	
	protected short valorEmByte(short a) {

		return (short) (128 + (128 + a));

	}
	
	private void salvarReferencia(String identificador, int endereco, boolean ehCampo, Valor toSave, Referencia referencia){
		
		Objeto objeto = heap.get((Integer)referencia.getValor());
		
		if (!frameAtual.getVariaveisCriadas().containsKey(identificador) && !frameAtual.getReferenciasRecebidas().containsKey(identificador)){
			
			Interpretador.criarVariavelGrafica(frameAtual, identificador, referencia.getTipo());
			
			if (objeto.getNome().equals("[I"))					
				Interpretador.criarEstrutura(objeto.getNome(), objeto.getMemoriaLocal().length);				
			else 					
				Interpretador.criarEstrutura(objeto.getNome(), 0);
		
		} else if (referencia.getValor() != ((Referencia)toSave).getValor()) {
			
			if (novoObjeto)
				Interpretador.con.readReference(identificador);
				
			if (objeto.getNome().equals("[I"))					
				Interpretador.criarEstrutura(objeto.getNome(), objeto.getMemoriaLocal().length);				
			else 					
				Interpretador.criarEstrutura(objeto.getNome(), 0);
			
		}
		
		if (!objeto.getNome().equals("LVector"))
			
			Interpretador.con.writeReference();
		
		Interpretador.con.endCommand();
		
		novoObjeto = false;
		
	}
	
	private void salvarInteiro(String identificador, int endereco, boolean ehCampo, Valor toSave){
				
		if (!frameAtual.getVariaveisCriadas().containsKey(identificador))
			
			Interpretador.criarVariavelGrafica(frameAtual, identificador, toSave.getTipo());
			
		Interpretador.con.setValueInt(identificador);
		
		Interpretador.con.endCommand();
		
	}
	
	public String obterIdentificadorVariavel(int endereco) {
		
		String id = frameAtual.getReferenciasRecebidas().get(endereco);
		
		if (id != null)
			return id;
		
		id = "";
		String idRev = "";
		
		char[]alfabeto= {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z'};
		
		int div = endereco;
		do{
			int mod = div % 26;
			div = (int) div / 26;
			idRev += alfabeto[mod];
		}while(div > 0);
		
		for (int i = idRev.length() - 1; i >= 0; i--)
			id += idRev.charAt(i);
		
		//return obterPrefixoVariavel(frameAtual)+id;
		
		return id + obterSufixoVariavel(id);
		
    }
	
/*	public String obterIdentificadorCampo(boolean put, boolean estatico, int sp, int endereco) { 
					
		String id;
		
		if (put)
			id = obterIdentificadorCampoPut(estatico, sp, endereco, false);
		else
			id = obterIdentificadorCampoGet(estatico, sp, endereco, false);
		
		return id + obterSufixoVariavel(id);
		
	}
	
	private String obterIdentificadorCampoPut(boolean estatico, int sp, int endereco, boolean fim){
		
		String formId = "";
		
		if (sp == 0)
			fim = true;
		
		if (!fim) {
			
			Valor valor = frameAtual.pilhaOperandos[sp - 1];
		
			if ((sp - 1) > 0){
				
				Valor referenciaDeBaixo = frameAtual.pilhaOperandos[sp - 2];
				
				if (referenciaDeBaixo.getTipo().equals("I"))
					return obterIdentificadorCampoPut(estatico,  sp , endereco, true);
				
				if (valor != referenciaDeBaixo) {
				
					Objeto objetoDeBaixo = heap.get((Integer)referenciaDeBaixo.getValor());
									
					Objeto objeto = heap.get((Integer)valor.getValor());
					
					SimboloClasse classe = (SimboloClasse)Interpretador.tabelaSimbolos.global.resolver(objeto.getNome());
					
					formId = classe.obterIdentificadorVariavel(endereco, estatico);
					
					int end = Arrays.asList(objetoDeBaixo.getMemoriaLocal()).indexOf(valor);
					
					if (end == -1)
						return obterIdentificadorCampoPut(estatico,  sp, endereco, true);
					else
						endereco = end;
					
					
				} else
					
					formId = ""; 
			
			} else if ((sp - 1) == 0) {
							
				Objeto objeto = heap.get((Integer)valor.getValor());
				
				SimboloClasse classe = (SimboloClasse)Interpretador.tabelaSimbolos.global.resolver(objeto.getNome());
						
				formId = classe.obterIdentificadorVariavel(endereco, estatico);
				
				endereco = Arrays.asList(frameAtual.variaveis).indexOf(valor);
			
			}
			
		} else {
			
			formId = obterIdentificadorVariavel(endereco);

			return formId;
		}

		
		formId = obterIdentificadorCampoPut(estatico,  sp - 1, endereco, false) + "."+formId;
			
		return formId;
	}
	
	private String obterIdentificadorCampoGet(boolean estatico, int sp, int endereco, boolean fim){
		
		Referencia referencia = (Referencia)frameAtual.pilhaOperandos[sp];

		Objeto objeto = heap.get((Integer)referencia.getValor());
		
		SimboloClasse classe = (SimboloClasse)Interpretador.tabelaSimbolos.global.resolver(objeto.getNome());

		String formId = classe.obterIdentificadorVariavel(endereco, estatico);
		
		if (sp == 0)
			fim = true;
		
		if (!fim){
			
			Valor referenciaDeBaixo = frameAtual.pilhaOperandos[sp - 1];
			
			if (referenciaDeBaixo.getTipo().equals("I"))
				return obterIdentificadorCampoGet(estatico, sp, endereco, true);
			
			if (referencia != referenciaDeBaixo){
			
				Objeto objetoDeBaixo = heap.get((Integer)referenciaDeBaixo.getValor());
	
				int end = Arrays.asList(objetoDeBaixo.getMemoriaLocal()).indexOf(referencia);
				
				if (end == -1)
					return obterIdentificadorCampoGet(estatico, sp, endereco, true);
				else
					endereco = end;
	
				formId = obterIdentificadorCampoGet(estatico,  sp - 1, endereco, false) + "."+formId;
				
			} else {
				
				formId = "";
				
				formId = obterIdentificadorCampoGet(estatico,  sp - 1, endereco, false);
				
			}
							
			
		} else {
			
			endereco = Arrays.asList(frameAtual.variaveis).indexOf(referencia);
			
			formId = obterIdentificadorVariavel(endereco) + "." + formId;
			
		}
					
		return formId;
		
	}
	
	private String obterPrefixoVariavel(){
		
		if (frameAtual.getProprietario().equals("Main"))
			return "";
		
		return frameAtual.getProprietario()+"."+frameAtual.getMetodo().obterNomeSimples()+".";
		
	}*/
	
	private String obterSufixoVariavel(String identificador){
		
		int i = 0, qtd = 0;
		
		StackFrame frame = null;
		
		while (i <= topoPilha){
			
			frame = pilha[i];
			
			String p = (i > 0)? "(" : "";
			
			Set<String> ids = frame.getVariaveisCriadas().keySet();
			
			for (String id : ids){
				
				if (id.startsWith(identificador+p)){
					
					if (i == topoPilha)
						qtd--;
					
					qtd++;
					
				}
				
			}
			
			i++;
					
		}
		
		if (qtd > 0)
			return "("+(qtd+1)+")";
		
		return "";
		
	}
	
	public void removerVariaveisGraficas(){
		
		Set<String> ids = frameAtual.getVariaveisCriadas().keySet();
		
		for (String id : ids){
			
			if (!id.contains(".")) {
			
				if (frameAtual.getVariaveisCriadas().get(id).equals("I"))
					Interpretador.con.remove_int(id);
				else
					Interpretador.con.removeReference(id);
			
			}
			
		}
		
	}
	
	
	protected void exibirTela(StackFrame frame) {

		int i;

		System.out.println("frameAtual.pc: " + frame.pc);

		System.out.println("frameAtual.sp: " + frame.sp);

		System.out.print("Memória do código: ");

		for (i = 0; i < frame.pc.getSimboloMetodo().getCodigo().length; i++)

			System.out.print(frame.pc.getSimboloMetodo().getCodigo()[i] + " ");

		System.out.print("\n");

		System.out.print("Memória das variáveis: ");

		for (i = 0; i < frame.variaveis.length; i++)

			System.out.print(frame.variaveis[i] + " ");

		System.out.print("\n");
		
		System.out.println("Tamanho da memória local das variáveis: "+frame.pc.getSimboloMetodo().getTamanhoMemoriaLocalVariaveis());

		System.out.print("Pilha: ");

		for (i = 0; i < frame.pilhaOperandos.length; i++)

			System.out.print(frame.pilhaOperandos[i] + " ");

		System.out.print("\n\n");

		System.out
				.print("Pressione qualquer tecla para ir para a próxima instrução: ");

		in.next();


	}

	public StackFrame getFrameAtual() {
		return frameAtual;
	}

	public void setFrameAtual(StackFrame frameAtual) {
		this.frameAtual = frameAtual;
	}

	public StackFrame[] getPilha() {
		return pilha;
	}

	public void setPilha(StackFrame[] pilha) {
		this.pilha = pilha;
	}

	public int getTopoPilha() {
		return topoPilha;
	}

	public void setTopoPilha(int topoPilha) {
		this.topoPilha = topoPilha;
	}

	public int getTamanhoCodigo() {
		return tamanhoCodigo;
	}

	public void setTamanhoCodigo(int tamanhoCodigo) {
		this.tamanhoCodigo = tamanhoCodigo;
	}

	public List<SimboloClasse> getAreaClasses() {
		return areaClasses;
	}

	public void setAreaClasses(List<SimboloClasse> areaClasses) {
		this.areaClasses = areaClasses;
	}
	

}
