package br.ufpb.iged.interpretador.symboltable.classes;

import java.util.*;

import br.ufpb.iged.interpretador.bytecodeassembler.asm.BytecodeAssembler;

public class SimboloLabel {
	String name;

	public int endereco;

	boolean isForwardRef = false;

	boolean isDefined = true;

	Vector<Integer> forwardReferences = null;

	public SimboloLabel(String name) {
		this.name = name;
	}

	public SimboloLabel(String name, int endereco) {
		this(name);
		this.endereco = endereco;
	}

	public SimboloLabel(String name, int endereco, boolean forward) {
		this(name);
		isForwardRef = forward;
		if (forward) {
			// if forward reference, then address is address to update
			addForwardReference(endereco);
		} else {
			this.endereco = endereco;
		}
	}

	public void addForwardReference(int address) {
		if (forwardReferences == null) {
			forwardReferences = new Vector<Integer>();
		}
		forwardReferences.addElement(new Integer(address));
	}

	public void resolveForwardReferences(byte[] code) {
		isForwardRef = false;
		
		Vector<Integer> opndsToPatch = forwardReferences;
		for (int addrToPatch : opndsToPatch) {
			
			BytecodeAssembler.escreverInteiro(code, addrToPatch, endereco);
			
		}
	}

	public String toString() {
		String refs = "";
		if (forwardReferences != null) {
			refs = "[refs=" + forwardReferences.toString() + "]";
		}
		return name + "@" + endereco + refs;
	}
}