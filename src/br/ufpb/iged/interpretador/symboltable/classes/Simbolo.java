package br.ufpb.iged.interpretador.symboltable.classes;

public class Simbolo {
	
	public String nome;
	
	public Tipo tipo;
	
	Escopo escopo;
	
	public BytecodesAST def;
	
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

    public String toString() {
        String s = "";
        if ( escopo!=null ) s = escopo.obterNomeEscopo()+".";
        if ( tipo!=null ) return '<'+s+getNome()+":"+tipo+'>';
        return s+getNome();
    }

    public static String eliminarParenteses(String s) {
        return s.substring(1,s.length()-1);
    }

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

}
