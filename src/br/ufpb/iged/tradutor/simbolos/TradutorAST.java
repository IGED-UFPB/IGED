package br.ufpb.iged.tradutor.simbolos;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import br.ufpb.iged.tradutor.simbolos.Escopo;
import br.ufpb.iged.tradutor.simbolos.Simbolo;

public class TradutorAST extends CommonTree{

public Escopo escopo;   
    
    public Simbolo simbolo; 
    
    public TradutorAST(Token t) { 
    	super(t); 
    }
	
}
