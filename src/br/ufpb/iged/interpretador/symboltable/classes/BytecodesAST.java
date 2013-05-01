package br.ufpb.iged.interpretador.symboltable.classes;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.Token;

public class BytecodesAST extends CommonTree {
	
    public Escopo escopo;   
    
    public Simbolo simbolo; 
    
    public BytecodesAST(Token t) { 
    	super(t); 
    }
    
}
