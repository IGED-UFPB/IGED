tree grammar Def;

options {
  tokenVocab=Assembler;
  ASTLabelType=BytecodesAST;
  filter=true;
}

@header{
    package br.ufpb.iged.interpretador.parser;
    
    import br.ufpb.iged.interpretador.symboltable.classes.BytecodesAST;
    import br.ufpb.iged.interpretador.symboltable.classes.Escopo;
    import br.ufpb.iged.interpretador.symboltable.classes.SimboloClasse;
    import br.ufpb.iged.interpretador.symboltable.classes.SimboloVariavel;
    import br.ufpb.iged.interpretador.symboltable.classes.SimboloMetodo;
    import br.ufpb.iged.interpretador.symboltable.classes.TabelaSimbolos;
    import br.ufpb.iged.interpretador.symboltable.classes.EscopoLocal;
    import br.ufpb.iged.interpretador.principal.Interpretador;
}

@members {
    TabelaSimbolos tabelaSimbolos;
    Escopo escopoAtual;
    int contador;
    public Def(TreeNodeStream input, TabelaSimbolos tabelaSimbolos) {
        this(input);
        this.tabelaSimbolos = tabelaSimbolos;
        escopoAtual = tabelaSimbolos.global;
    }
}

topdown : entraNoCorpoMetodo
        | entraNoConstrutor
        | entraNoMetodo
        | entraNaClasse
        | declaracaoVariavel
        | field
        | invoke
        | nenhumoperando
        | umoperando
        | label
        ;

bottomup : saiDoCorpoMetodo
         | saiDoMetodo
         | saiDoConstrutor
         | saiDaClasse
         ;
         
entraNaClasse
    : ^('.class' nome=ID (^(EXTENDS sup = .))? .)
        {
           System.out.println("linha "+$nome.getLine()+
                          ": def class "+$nome.text);
           if ( $sup!=null )
             $sup.escopo = escopoAtual;
           SimboloClasse classe = new SimboloClasse("L" + $nome.text,escopoAtual,null);
           classe.def = $nome;
           $nome.simbolo = classe;
           escopoAtual.definir(classe);
           escopoAtual = classe;
        }
    ;

declaracaoVariavel
    : ^(FIELD_DECL (st =.)? ID tipo =.)
        {
          System.out.println("linha "+$ID.getLine()+": def "+$ID.text);
          $tipo.escopo = escopoAtual;
          boolean estatico = $st != null;
          SimboloVariavel variavel = new SimboloVariavel($ID.text,null,estatico);
          variavel.def = $ID;
          $ID.simbolo = variavel;
          escopoAtual.definir(variavel);
          ((SimboloClasse)escopoAtual).getConstantPool().add(variavel);
        }
    ;
    
entraNoConstrutor
	: ^(CONSTR_DECL INIT tipoRet =. ^(PARAMS a =.) (^(LIMIT lim=INTEIRO))? .)
	{
	   System.out.println("linha "+$INIT.getLine()+
                          ": def method init ");
           SimboloMetodo metodo = new SimboloMetodo($INIT.text+"("+a.getText()+")"+tipoRet.getText(), null, escopoAtual);
           metodo.setEstatico(false);
           if (lim != null)
           	metodo.setTamanhoMemoriaLocalVariaveis(new Integer(lim.getText()));
           metodo.setRetorno($tipoRet.getText());
           metodo.def = $INIT;
           $INIT.simbolo = metodo;
           escopoAtual.definir(metodo);
           escopoAtual = metodo;
           contador = 0;
        }
	;
	
entraNoMetodo
	: ^(METHOD_DECL (st =.)? ID tipoRet =. ^(PARAMS a =.) (^(LIMIT lim=INTEIRO))? .)
	{
	   System.out.println("linha "+$ID.getLine()+
                          ": def method "+$ID.text);
           SimboloMetodo metodo = new SimboloMetodo($ID.text+"("+a.getText()+")"+tipoRet.getText(), null, escopoAtual);
           
           if (st == null)
           	metodo.setEstatico(false);
           else
           	metodo.setEstatico(true);
           
           if (lim != null)
           	metodo.setTamanhoMemoriaLocalVariaveis(new Integer(lim.getText()));
           metodo.setRetorno($tipoRet.getText());
           metodo.def = $ID;
           $ID.simbolo = metodo;
           escopoAtual.definir(metodo);
           escopoAtual = metodo;
           contador = 0;
        }
	;
		
entraNoCorpoMetodo
    :   BODY {escopoAtual = new EscopoLocal(escopoAtual);} 
    ;
    
saiDoCorpoMetodo
    :   BODY
        {
        System.out.println("locals: "+escopoAtual);
        escopoAtual = escopoAtual.obterEscopoEnvolvente();    
        }
    ;
    
saiDaClasse : '.class'
            {
              System.out.println("Saindo da classe.. membros: "+escopoAtual);
              escopoAtual = escopoAtual.obterEscopoEnvolvente(); 
            }
            ;
            
saiDoMetodo 
	:  METHOD_DECL
	{
	   System.out.println("Saindo do metodo: "+escopoAtual);
	   escopoAtual = escopoAtual.obterEscopoEnvolvente(); 
           
	}
	;
	
saiDoConstrutor
	:  CONSTR_DECL
	{
	   System.out.println("Saindo do construtor: "+escopoAtual);
           escopoAtual = escopoAtual.obterEscopoEnvolvente(); 
	}
	
	;
	
field	: ^((a = 'getfield' | a = 'getstatic' | a = 'putfield' | a = 'putstatic') . .)
        {           
           if ($a.getText().equals("getstatic") || $a.getText().equals("putstatic"))
           	contador += 9;
           else
              contador += 5;
        }
        ;
        
invoke 	: ^(('invokespecial' | 'invokestatic' | 'invokevirtual') . ^(METHOD_CALL ^(PARAMS .) .))
        {
          contador += 9;
        }
        ;
        
nenhumoperando 
	: ^((RETURN | ARITMETICA | LOAD | STORE | LOGICA | PILHA) . )
	{
	   contador++;
	}	
	;
	
umoperando
        : ^((DESVIO | LOAD | STORE | NEW | NEWARRAY) . .)
        {
          contador += 5;
        }
        ;       
label
   : ^(LABEL id = .)
   {
      System.out.println("Definindo label "+id.getText()+" no endereço "+contador);
      SimboloMetodo metodo = (SimboloMetodo) escopoAtual.obterEscopoEnvolvente();
      metodo.definirLabel($id.token, contador);
   }
   ;     