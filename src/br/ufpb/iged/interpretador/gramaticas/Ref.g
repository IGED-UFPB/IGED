tree grammar Ref;

options {
  tokenVocab = Assembler;
  ASTLabelType = BytecodesAST;
  filter = true;
}

@header{
    package br.ufpb.iged.interpretador.parser;
    
    import br.ufpb.iged.interpretador.symboltable.classes.Escopo;
    import br.ufpb.iged.interpretador.symboltable.classes.BytecodesAST;
    import br.ufpb.iged.interpretador.symboltable.classes.SimboloClasse;
    import br.ufpb.iged.interpretador.symboltable.classes.TabelaSimbolos;
    import br.ufpb.iged.interpretador.symboltable.classes.Tipo;
    import br.ufpb.iged.interpretador.bytecodeassembler.asm.BytecodeAssembler;
    import br.ufpb.iged.interpretador.symboltable.classes.SimboloVariavel;
    import br.ufpb.iged.interpretador.symboltable.classes.SimboloMetodo;
    import br.ufpb.iged.interpretador.symboltable.classes.SimboloLabel;
}

@members {
    
    TabelaSimbolos tabelaSimbolos;
    SimboloClasse simboloClasse;
    BytecodeAssembler assembler;
    Escopo escopoAtual;
    public Ref(TreeNodeStream input, TabelaSimbolos tabelaSimbolos,
      BytecodeAssembler assembler) {
        this(input);
        this.tabelaSimbolos = tabelaSimbolos;
        this.assembler = assembler;
    }
    
    private Tipo resolverTipo(String nomeTipo) {
    
      return (Tipo)simboloClasse.resolver(nomeTipo);
    
    }
    
    private void acessarCampo(String operacao, String nomeClasse, String nomeCampo) {
    
        assembler.escreverOpcode(operacao);
      
        SimboloClasse simboloClasse =
          (SimboloClasse)tabelaSimbolos.global.resolver(nomeClasse);
      
        if(!assembler.getConstantPool().contains(simboloClasse))
      
          assembler.getConstantPool().add(simboloClasse);
      
        SimboloVariavel simboloVariavel =
          (SimboloVariavel) simboloClasse.resolver(nomeCampo);
    
        if (!simboloClasse.getConstantPool().contains(simboloVariavel))
      
          simboloClasse.getConstantPool().add(simboloVariavel);
          
        if (operacao.equals("getstatic") || operacao.equals("putstatic"))
          
        	BytecodeAssembler.escreverInteiro(
          	  BytecodeAssembler.codigo, BytecodeAssembler.ip,
                  assembler.getConstantPool().indexOf(simboloClasse));
        
        BytecodeAssembler.escreverInteiro(
          BytecodeAssembler.codigo, BytecodeAssembler.ip,
          simboloClasse.obterIdentificadorVariavel(simboloVariavel));
    
    }
    
    private void chamarMetodo(String instrucao, String nomeClasse, String nomeMetodo, String args, String tipoRetorno) {
    
      assembler.escreverOpcode(instrucao);
       
      SimboloClasse simboloClasse =
          (SimboloClasse)tabelaSimbolos.global.resolver(nomeClasse);
    
      if(!assembler.getConstantPool().contains(simboloClasse))
      
          assembler.getConstantPool().add(simboloClasse);
          
       SimboloMetodo simboloMetodo =
          (SimboloMetodo) simboloClasse.resolver(nomeMetodo+"("+args+")"+tipoRetorno);
    
        if (!simboloClasse.getMethodArea().contains(simboloMetodo))
      
          simboloClasse.getMethodArea().add(simboloMetodo);
          
       BytecodeAssembler.escreverInteiro(
          BytecodeAssembler.codigo, BytecodeAssembler.ip,
          assembler.getConstantPool().indexOf(simboloClasse));
    
       BytecodeAssembler.escreverInteiro(
          BytecodeAssembler.codigo, BytecodeAssembler.ip,
          simboloClasse.getMethodArea().indexOf(simboloMetodo));
    
  }
  
  private void newClass(String operacao, String nomeClasse) {
  
     assembler.escreverOpcode(operacao);
       
      SimboloClasse simboloClasse =
          (SimboloClasse)tabelaSimbolos.global.resolver( nomeClasse);
    
      if(!assembler.getConstantPool().contains(simboloClasse))
      
          assembler.getConstantPool().add(simboloClasse);
    
       BytecodeAssembler.escreverInteiro(BytecodeAssembler.codigo,
          BytecodeAssembler.ip, assembler.getConstantPool().indexOf(simboloClasse));
  
  }
  
  private void newArray(String operacao, String tipo) throws RecognitionException{
  
  	assembler.escreverOpcode(operacao);
  	
  	int valor;
  	
  	if (tipo.equals("boolean"))
  		valor = 0;
  	else if (tipo.equals("float"))
  		valor = 1;
  	else if (tipo.equals("int"))
  		valor = 2;
  	else if (tipo.equals("char"))
  		valor = 3;
  	else if (tipo.equals("double"))
  		valor = 4;
  	else if (tipo.equals("long"))
  		valor = 5;
  	else if (tipo.equals("byte"))
  		valor = 6;
  	else if (tipo.equals("short"))
  		valor = 7;
  	else
  	      throw new RecognitionException();
  	      
  	BytecodeAssembler.escreverInteiro(BytecodeAssembler.codigo,
          BytecodeAssembler.ip, valor);
  
  }
    
}

topdown
    :   entraNaClasse
      | entraNoMetodo
      | entraNoConstrutor
      | declaracaoVariavel
      | field
      | invoke
      | novaClasse
      | novoArray
      | nenhumoperando
      | umoperando
    ;
    
bottomup
 	:   saiDoMetodo
 	  | saiDoConstrutor
 	
 	;
    
entraNaClasse
    : ^('.class' nome=ID (^(EXTENDS sup = .))? .)
        {
        
          simboloClasse =(SimboloClasse)tabelaSimbolos.global.resolver("L" + $nome.getText());     
          if(!assembler.getConstantPool().contains(simboloClasse))   
          	assembler.getConstantPool().add(simboloClasse);
          if ( $sup!=null ) {
              $sup.simbolo = $sup.escopo.resolver("L"+$sup.getText());
              simboloClasse.superClasse =
                  (SimboloClasse)$sup.simbolo;
                  System.out.println("linha "+$nome.getLine()+": set "+$nome.text+
                  " super to "+((SimboloClasse)$nome.simbolo).superClasse.nome);
           }
           else {
              System.out.println("linha "+$nome.getLine()+": set "+$nome.text);
           }
        }
    ;
    
declaracaoVariavel
    : ^(FIELD_DECL .? ID tip =.)
        {
           if ($tip.getText().startsWith("L") || $tip.getText().startsWith("["))
           	$ID.simbolo.tipo = resolverTipo($tip.getText().substring(0, $tip.getText().length() - 1));
           else
           	$ID.simbolo.tipo = resolverTipo($tip.getText());
           System.out.println("linha "+$ID.getLine()+": set var type "+$ID.simbolo);
        }
    ;
    
entraNoConstrutor
	: ^(CONSTR_DECL INIT . ^(PARAMS .) (^(LIMIT lim=INTEIRO))? .)
	{
	  System.out.println("Ref: Entrou no construtor "+$INIT.text);
	  escopoAtual = (SimboloMetodo)$INIT.simbolo;
	  BytecodeAssembler.codigo = new byte[BytecodeAssembler.TAMANHO_INICIAL_MEMORIA_CODIGO];
	  BytecodeAssembler.ip = 0;
	  assembler.setMetodoAtual((SimboloMetodo)escopoAtual);
	}
	;
    
entraNoMetodo
	: ^(METHOD_DECL ID . ^(PARAMS .) (^(LIMIT lim=INTEIRO))? .)
	{
	  System.out.println("Ref: Entrou no metodo "+$ID.text);
	  escopoAtual = (SimboloMetodo)$ID.simbolo;
	  BytecodeAssembler.codigo = new byte[BytecodeAssembler.TAMANHO_INICIAL_MEMORIA_CODIGO];
	  BytecodeAssembler.ip = 0;
	  assembler.setMetodoAtual((SimboloMetodo)escopoAtual);
	}
	;

saiDoMetodo 
	:  METHOD_DECL
	{
	   System.out.println("Ref: Saindo do metodo... ");
	   ((SimboloMetodo)escopoAtual).setCodigo(assembler.obterCodigoMaquina());
	   ((SimboloMetodo)escopoAtual).setTamanhoMemoriaLocal(assembler.obterTamanhoMemoriaCodigo());
	}
	;
	
saiDoConstrutor
	:  CONSTR_DECL
	{
	    System.out.println("Ref: Saindo do construtor... ");
	   ((SimboloMetodo)escopoAtual).setCodigo(assembler.obterCodigoMaquina());
	   ((SimboloMetodo)escopoAtual).setTamanhoMemoriaLocal(assembler.obterTamanhoMemoriaCodigo());
	}
	;
	
field 	: ^((op = 'getfield' | op = 'getstatic' | op = 'putfield' | op = 'putstatic') ref = . tipo = .)
        {
    	   String[] tokens = $ref.getText().split("/");
    	   String campo = tokens[tokens.length - 1];
    	   String classe = "L";
    	
    	   int i;
    	
    	   for (i = 0; i < tokens.length - 1; i++){
    		if (i == tokens.length - 2)
    			classe += tokens[i];
    		else
        		classe += tokens[i]+"/";
    	   }
    	           
          acessarCampo($op.getText(), classe, campo);
        }
        ;
        
invoke 	:  ^((op = 'invokespecial' | op = 'invokestatic' | op = 'invokevirtual') ref = . ^(METHOD_CALL ^(PARAMS a = .) tipoRet = .))
        {   
           
           String[] tokens = $ref.getText().split("/");
    	   String nomeMetodo = tokens[tokens.length - 1];
    	   String classe = "L";
    	
    	   int i;
    	
    	   for (i = 0; i < tokens.length - 1; i++){
    		if (i == tokens.length - 2)
    			classe += tokens[i];
    		else
        		classe += tokens[i]+"/";
    	   }
        
           System.out.println("chamando metodo "+nomeMetodo+"("+$a.getText()+")"+$tipoRet.getText());
           chamarMetodo($op.getText(), classe, nomeMetodo, $a.getText(), $tipoRet.getText());
        }
        ;
    
novaClasse
  : ^(NEW operacao = . classe = .)
  {
    newClass($operacao.getText(), "L"+$classe.getText());
  }
  ;

novoArray
	: ^(NEWARRAY operacao = . tipo = .)	
	{
	  newArray($operacao.getText(), $tipo.getText());
	}
	;
 
nenhumoperando 
	: ^((RETURN | ARITMETICA | LOAD | STORE | LOGICA | PILHA) operacao = . )
	{
	 assembler.escreverOpcode($operacao.getText());
	}	
	;
	
umoperando
        : ^((DESVIO | LOAD | STORE) operacao = . operando = .)
        {
         assembler.escreverOpcode($operacao.token, $operando.token);
        }
        ;