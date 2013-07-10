package br.ufpb.iged.tradutor.simbolos;

public class Simbolo {
	
    String nome;      
    Tipo tipo;
    Escopo escopo;      
    public TradutorAST def;    
    
    public Simbolo(String nome) { 
    	this.nome = nome; 
    }
    public Simbolo(String nome, Tipo tipo) { 
    	this(nome); 
    	this.tipo = tipo; 
    }
    
    public String getNome() { 
    	return nome; 
    }
    
    public Tipo getTipo() {
    	return tipo;
    }

    public String toString() {
        String s = "";
        if ( escopo!=null ) s = escopo.obterNomeEscopo()+".";
        if ( tipo!=null ) return '<'+s+getNome()+":"+tipo+'>';
        return s+getNome();
    }

    public static String stripBrackets(String s) {
        return s.substring(1,s.length()-1);
    }
}
