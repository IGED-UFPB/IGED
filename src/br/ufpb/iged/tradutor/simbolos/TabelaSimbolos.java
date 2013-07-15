package br.ufpb.iged.tradutor.simbolos;

public class TabelaSimbolos {
	
    public EscopoGlobal global = new EscopoGlobal();
    SimboloClasse objetoRaiz;

    public TabelaSimbolos() { initTypeSystem(); }

    protected void initTypeSystem() {
        // if you wanted a predefined Object class hierarchy root
        // like Java, you'd define it here:
/*
        objetoRaiz = new ClassSymbol("Object", globals, null);
        MethodSymbol hashCode =
           new MethodSymbol("hashCode",new BuiltInTypeSymbol("int"),objetoRaiz);
        objetoRaiz.define(hashCode);
        globals.define(objetoRaiz);
*/
        // define predefined atomic types
        global.definir(new SimboloTipoPrimitivo("int"));
        global.definir(new SimboloTipoPrimitivo("void")); // pseudo-type
    }

    public static Simbolo resolverID(TradutorAST idAST) {
    	
        Simbolo s = idAST.escopo.resolver(idAST.getText());
        
        System.out.println("line "+idAST.getLine()+": resolve "+
                           idAST.getText()+" to "+s);
        if ( s.def==null ) return s; // must be predefined symbol
        // if resolves to local or global symbol, token index of definition
        // must be before token index of reference
        int idLocation = idAST.token.getTokenIndex();
        int defLocation = s.def.token.getTokenIndex();
        if ( idAST.escopo instanceof EscopoBase &&
             s.escopo instanceof EscopoBase &&
             idLocation < defLocation )
        {
            System.err.println("line "+idAST.getLine()+
                ": error: forward local var ref "+idAST.getText());
            return null;
        }
        
        return s;
        
    }

    /** 'this' and 'super' need to know about enclosing class */
    public static SimboloClasse getEnclosingClass(Escopo s) {
    	
        while ( s!=null ) { // walk upwards from s looking for a class
            if ( s instanceof SimboloClasse ) return (SimboloClasse)s;
            s = s.obterEscopoPai();
        }
        
        return null;
        
    }

    public String toString() { return global.toString(); }
}

