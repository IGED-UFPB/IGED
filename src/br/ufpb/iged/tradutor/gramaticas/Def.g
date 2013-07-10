tree grammar Def;
options {
  tokenVocab = Jedi;
  ASTLabelType = TradutorAST;
  filter = true;
}

@header{

    package br.ufpb.iged.tradutor.parser;
    
    import br.ufpb.iged.tradutor.simbolos.Escopo;
    import br.ufpb.iged.tradutor.simbolos.EscopoLocal;
    import br.ufpb.iged.tradutor.simbolos.SimboloClasse;
    import br.ufpb.iged.tradutor.simbolos.SimboloMetodo;
    import br.ufpb.iged.tradutor.simbolos.SimboloTipoPrimitivo;
    import br.ufpb.iged.tradutor.simbolos.SimboloTipoReferencia;
    import br.ufpb.iged.tradutor.simbolos.SimboloVariavel;
    import br.ufpb.iged.tradutor.simbolos.TabelaSimbolos;
    import br.ufpb.iged.tradutor.simbolos.TradutorAST;
    
}

@members {
    TabelaSimbolos tabelaSimbolos;
    Escopo escopoAtual;
    SimboloMetodo metodoAtual;
    SimboloClasse classeAtual;
    public Def(CommonTreeNodeStream input, TabelaSimbolos tabelaSimbolos) {
        this(input);
        this.tabelaSimbolos = tabelaSimbolos;
        escopoAtual = tabelaSimbolos.globals;
    }
}

topdown
    :   enterBlock
    |   enterMethod
    |   enterClass
    |   enterConstructor
    |   fieldDecl
    |   listaVarDecl
    |   varDeclFor
    |   varDeclLista
    |   paramDecl
    |   atoms
    ;

bottomup
    :   exitBlock
    |   exitMethod
    |   exitClass
    |   exitConstructor
    ;


enterBlock
    :   BLOCO {escopoAtual = new EscopoLocal(escopoAtual);} 
    ;
exitBlock
    :   BLOCO
        {
	        System.out.println("locals: "+escopoAtual);
	        escopoAtual = escopoAtual.obterEscopoEnvolvente();    
        }
    ;

enterClass
    :   ^(CLASSE nome = ID (^(EXTENDS sup = ID))? .+)
        { 
	        System.out.println("line "+$nome.getLine()+
	                           ": def class "+$nome.text);
	        
	        if ( $sup!=null )
	           $sup.escopo = escopoAtual; 
	        SimboloClasse simboloClasse = new SimboloClasse($nome.text,escopoAtual,null);
	        simboloClasse.def = $nome;           
	        $nome.simbolo = simboloClasse;        
	        escopoAtual.definir(simboloClasse);  
	        escopoAtual = simboloClasse;
	        classeAtual = simboloClasse;        
        }
    ;

exitClass
    :   CLASSE
        {
	        System.out.println("members: "+escopoAtual);
	        escopoAtual = escopoAtual.obterEscopoEnvolvente();    
        }
    ;

enterMethod
    :  ^(METHOD_DECL st = .? tp = . ID (^(PARAMS .+))* ^(BLOCO .*))
        {
	        System.out.println("line "+$ID.getLine()+": def method "+$ID.text);
	        $tp.escopo = escopoAtual;
	        boolean estatico = $st != null;
	        SimboloMetodo simboloMetodo = new SimboloMetodo($ID.text,null,escopoAtual, estatico);
	        simboloMetodo.def = $ID;            
	        $ID.simbolo = simboloMetodo;         
	        escopoAtual.definir(simboloMetodo); 
	        escopoAtual = simboloMetodo;
	        metodoAtual = simboloMetodo; 
	        
	        if ($st == null){
	        
	        	System.out.println("line "+$ID.getLine()+": def this");
	                
	                SimboloVariavel simboloVariavel = new SimboloVariavel("this", new SimboloTipoReferencia(classeAtual.getNome()), 0);
	                metodoAtual.definir(simboloVariavel);
	                
	        	metodoAtual.incrementarQuantidadeVariaveis(); 
	        }   
	           
        }
    ;
    
enterConstructor 
	:  ^(CONSTR_DECL ID (^(PARAMS .+))* ^(BLOCO .*))
	 {
	        System.out.println("line "+$ID.getLine()+": def method "+$ID.text);
	        SimboloMetodo simboloMetodo = new SimboloMetodo($ID.text,null,escopoAtual, false);
	        simboloMetodo.def = $ID;           
	        $ID.simbolo = simboloMetodo;         
	        escopoAtual.definir(simboloMetodo); 
	        escopoAtual = simboloMetodo;
	        metodoAtual = simboloMetodo; 
	        System.out.println("line "+$ID.getLine()+": def this");
	        SimboloVariavel simboloVariavel = new SimboloVariavel("this", new SimboloTipoReferencia(classeAtual.getNome()), 0);
	        metodoAtual.definir(simboloVariavel);
                metodoAtual.incrementarQuantidadeVariaveis();        
        }
       ;
        
exitMethod
    :   METHOD_DECL
        {
	        System.out.println("args: "+escopoAtual);
	        escopoAtual = escopoAtual.obterEscopoEnvolvente();    
        }
    ;

exitConstructor
    :   CONSTR_DECL
        {
	        System.out.println("args: "+escopoAtual);
	        escopoAtual = escopoAtual.obterEscopoEnvolvente();    
        }
    ;

atoms
@init {TradutorAST t = (TradutorAST)input.LT(1);}
    :  {t.hasAncestor(FIELD_DECL) || t.hasAncestor(PARAM) || t.hasAncestor(EXPR) || t.hasAncestor(PRE_DECREMENTO)
    	|| t.hasAncestor(PRE_INCREMENTO) || t.hasAncestor(POS_DECREMENTO) || t.hasAncestor(POS_INCREMENTO)
    	|| t.hasAncestor(VAR_DECL) || t.hasAncestor(INIT_FOR)}? (ID)
       {t.escopo = escopoAtual;}
    ;

//^(FIELD_DECL $a? tipo ID)
//^(PARAM tipo ID $vet?)
//^(VAR_DECL tipo ID $a? expressao?)
//^(VAR_DECL ID $a? expressao?)
//^(INIT_FOR varDecl atribuicao*)
//^(INIT_FOR atribuicao+)


    
fieldDecl
    :   ^(FIELD_DECL st = .? tp = . ID vet = .?)
        {
	        System.out.println("line "+$ID.getLine()+": def "+$ID.text);
	        $tp.escopo = escopoAtual;
	        SimboloVariavel simboloVariavel;
	        if ($tp.getText().equals("int"))
	        	simboloVariavel = new SimboloVariavel($ID.text,new SimboloTipoPrimitivo("int"));
	        else
	        	simboloVariavel = new SimboloVariavel($ID.text,new SimboloTipoReferencia($tp.getText()));
	        simboloVariavel.def = $ID;            
	        $ID.simbolo = simboloVariavel;         
	        escopoAtual.definir(simboloVariavel);
        }
    ;
    
paramDecl 
    :   ^(PARAM tp = . ID vet = .?)
        {
	        System.out.println("line "+$ID.getLine()+": def "+$ID.text);
	        $tp.escopo = escopoAtual;
	        SimboloVariavel simboloVariavel;
	        if ($tp.getText().equals("int"))
	        	simboloVariavel = new SimboloVariavel($ID.text,new SimboloTipoPrimitivo("int"), metodoAtual.getQuantidadeVariaveis());
	        else
	        	simboloVariavel = new SimboloVariavel($ID.text,new SimboloTipoReferencia($tp.getText()), metodoAtual.getQuantidadeVariaveis());
	        simboloVariavel.def = $ID;            
	        $ID.simbolo = simboloVariavel;         
	        escopoAtual.definir(simboloVariavel);
	        
	        metodoAtual.incrementarQuantidadeVariaveis();
	        
        }
    ;
    
listaVarDecl 
    :   ^(LISTA_VAR_DECL ^(VAR_DECL tp = . ID vet =.? .?) .*)
        {
        	System.out.println("line "+$ID.getLine()+": def "+$ID.text);
	        $tp.escopo = escopoAtual;
	        SimboloVariavel simboloVariavel;
	        if ($tp.getText().equals("int"))
	        	simboloVariavel = new SimboloVariavel($ID.text, new SimboloTipoPrimitivo("int"), metodoAtual.getQuantidadeVariaveis());
	        else
	        	simboloVariavel = new SimboloVariavel($ID.text, new SimboloTipoReferencia($tp.getText()), metodoAtual.getQuantidadeVariaveis());
	        simboloVariavel.def = $ID;            
	        $ID.simbolo = simboloVariavel;         
	        escopoAtual.definir(simboloVariavel);
	        TradutorAST var = (TradutorAST) $tp.getAncestor(LISTA_VAR_DECL);        
	        if (var != null)
	          var.simbolo = simboloVariavel;
	          
	        metodoAtual.incrementarQuantidadeVariaveis();
	        	
	        
        }
    ;


varDeclFor 
    :   ^(INIT_FOR ^(VAR_DECL tp = . ID vet =.? .?) .*)
        {
        	System.out.println("line "+$ID.getLine()+": def "+$ID.text);
	        $tp.escopo = escopoAtual;
	        SimboloVariavel simboloVariavel;
	        if ($tp.getText().equals("int"))
	        	simboloVariavel = new SimboloVariavel($ID.text, new SimboloTipoPrimitivo("int"), metodoAtual.getQuantidadeVariaveis());
	        else
	        	simboloVariavel = new SimboloVariavel($ID.text, new SimboloTipoReferencia($tp.getText()), metodoAtual.getQuantidadeVariaveis());
	        simboloVariavel.def = $ID;            
	        $ID.simbolo = simboloVariavel;         
	        escopoAtual.definir(simboloVariavel);

	        metodoAtual.incrementarQuantidadeVariaveis();
	        	
	        
        }
    ;
        
varDeclLista 
    :   ^(VAR_DECL_LISTA ID vet = .? .?)
        {
        	SimboloVariavel primeiraVar = (SimboloVariavel) ((TradutorAST) $ID.getAncestor(LISTA_VAR_DECL)).simbolo;
	        System.out.println("line "+$ID.getLine()+": def "+$ID.text);
	        SimboloVariavel simboloVariavel = new SimboloVariavel($ID.text,primeiraVar.getTipo(), metodoAtual.getQuantidadeVariaveis());
	        simboloVariavel.def = $ID;            
	        $ID.simbolo = simboloVariavel;         
	        escopoAtual.definir(simboloVariavel); 
	        
	        metodoAtual.incrementarQuantidadeVariaveis();
	               	        
        }
    ;
    
	