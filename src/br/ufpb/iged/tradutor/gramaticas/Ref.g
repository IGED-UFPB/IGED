tree grammar Ref;
options {
  tokenVocab = Jedi;
  ASTLabelType = TradutorAST;
  filter = true;
}

@header{

    package br.ufpb.iged.tradutor.parser;
    
    import br.ufpb.iged.tradutor.excecoes.SyntacticException;
    import br.ufpb.iged.tradutor.principal.Tradutor;
    import br.ufpb.iged.tradutor.simbolos.Escopo;
    import br.ufpb.iged.tradutor.simbolos.EscopoLocal;
    import br.ufpb.iged.tradutor.simbolos.Simbolo;
    import br.ufpb.iged.tradutor.simbolos.SimboloClasse;
    import br.ufpb.iged.tradutor.simbolos.SimboloMetodo;
    import br.ufpb.iged.tradutor.simbolos.SimboloTipoPrimitivo;
    import br.ufpb.iged.tradutor.simbolos.SimboloTipoReferencia;
    import br.ufpb.iged.tradutor.simbolos.SimboloVariavel;
    import br.ufpb.iged.tradutor.simbolos.TabelaSimbolos;
    import br.ufpb.iged.tradutor.simbolos.TradutorAST;
    
    import java.io.BufferedWriter;
    import java.io.File;
    import java.io.FileWriter;
    import java.io.IOException;
    
}

@members {
    TabelaSimbolos tabelaSimbolos;
    Escopo escopoAtual;
    SimboloClasse classeAtual;
    String tipoMetodo;
    String linha;
    SimboloMetodo metodoAtual;
    Tree toStore;
    
    public Ref(CommonTreeNodeStream input, TabelaSimbolos tabelaSimbolos) {
        this(input);
        this.tabelaSimbolos = tabelaSimbolos;
        escopoAtual = tabelaSimbolos.global;
    }
    
    private void storeVar(SimboloVariavel simboloVariavel){
    
    	int num = simboloVariavel.getEndereco();	
	        
	String tipo = simboloVariavel.getTipo().getNome();
	        
	if (num >= 0 && num <= 3){
	        
	        if (tipo.equals("int"))
	        	Tradutor.buffer.append("istore_"+num+"\n");
		else
	        	Tradutor.buffer.append("astore_"+num+"\n");
	        
	} else {
	        	
	        if (tipo.equals("int"))
	        	Tradutor.buffer.append("istore "+num+"\n");
	        else
	        	Tradutor.buffer.append("astore "+num+"\n");
	        
	 }
    
    }
    
    private void loadVar(SimboloVariavel simboloVariavel){
    
    	int num = simboloVariavel.getEndereco();	
		        
	String tipo = simboloVariavel.getTipo().getNome();
			        
	if (num >= 0 && num <= 3){
			        
		if (tipo.equals("int"))
			Tradutor.buffer.append("iload_"+num+"\n");
		else
			Tradutor.buffer.append("aload_"+num+"\n");
			        
	} else {
			        	
		if (tipo.equals("int"))
			 Tradutor.buffer.append("iload "+num+"\n");
		else
			 Tradutor.buffer.append("aload "+num+"\n");
			        
	}
    
    
    }
    
    private void loadConst(String constante){
    
    	int num =  Integer.parseInt(constante);
			
	if (num >= 0 && num <= 5)
		Tradutor.buffer.append("iconst_"+num+"\n");
	else
		Tradutor.buffer.append("ldc "+num+"\n");
    
    }
    
    private boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {}
	    return false;
     }
     
     private void percorrerSubArvore(TradutorAST raiz){
     
     	CommonTree tree = (CommonTree)Tradutor.tradutorAdaptor.dupTree(raiz);
        CommonTreeNodeStream nos = new CommonTreeNodeStream(Tradutor.tradutorAdaptor, tree);
        nos.setTokenStream(Tradutor.tokens);
        Ref ref = new Ref(nos, Tradutor.tabelaSimbolos);
        ref.downup(tree);
     
     }
    
}

topdown
    :   enterClass
    |   enterMethod
    |   enterConstructor
    |   enterParam
    |   enterField
    |   subDivEnter
    ;

bottomup
    :   exitClass
    |   exitMethod
    |   exitConstructor
    |   exitParams
    |   listaVarDeclAtribuicao
    |   atribuicao
    |   addMult
    |   subDivExit
    |   acessoCampo
    |   vetorExpr
    |   chamadaMetodo
    ;

enterClass
    :   ^(CLASSE nome = ID (^(EXTENDS sup = ID))? .+)
        { 
             classeAtual = (SimboloClasse)$nome.simbolo; 
	     Tradutor.buffer = new StringBuffer();
	     Tradutor.buffer.append(".class "+classeAtual.getNome()+"\n");
	     
	     if (sup != null)
	       Tradutor.buffer.append(".super "+$sup.getText()+"\n");
	     
        }
    ;

exitClass
    :   CLASSE
        {
                try {
                        File file = new File("classesteste"); 
                        file.mkdir();
			FileWriter fw = new FileWriter("classesteste/"+classeAtual.getNome()+".j");
			BufferedWriter bw =  new BufferedWriter(fw);
			Tradutor.buffer.append(".end class");
			bw.write(Tradutor.buffer.toString());
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		};
		    
        }
    ;
    
enterMethod
    :  ^(METHOD_DECL st = .? tp = . ID parm = .* ^(BLOCO .*))
        {
        	metodoAtual = (SimboloMetodo) $ID.simbolo;
	    
	    	tipoMetodo = $tp.getText(); 
	    	
	    	if (parm == null) {
	    	
	    		Tradutor.buffer.append(".method ");
	        
	                if (st != null)
	        	   Tradutor.buffer.append("static ");
	        
	                Tradutor.buffer.append( $ID.text + "()");
	                
	                if (tipoMetodo.equals("void"))
				Tradutor.buffer.append("V");
			else if (tipoMetodo.equals("int"))
				Tradutor.buffer.append("I");
			else
				Tradutor.buffer.append("L"+tipoMetodo+";");
			
			Tradutor.buffer.append(linha+"\n");
		
			Tradutor.buffer.append(".limit locals "+metodoAtual.getQuantidadeVariaveis()+"\n");
	    	
	    	} else {
	    	
	    	   linha = "";
	           linha += ".method ";
	        
	           if (st != null)
	        	linha += "static ";
	        
	           linha += $ID.text + "(";
	    	
	    	}
	    		   
	        
	        
        }
    ;
    
enterConstructor 
	:  ^(CONSTR_DECL ID parm = .* ^(BLOCO .*))
	 {
	        metodoAtual = (SimboloMetodo) $ID.simbolo;
	        
	        if (parm == null) {
	    	
	    		Tradutor.buffer.append(".method ");
	        
	                Tradutor.buffer.append("<init>()");
	                
			Tradutor.buffer.append("V");
			
			Tradutor.buffer.append(linha+"\n");
		
			Tradutor.buffer.append(".limit locals "+metodoAtual.getQuantidadeVariaveis()+"\n");
	    	
	    	} else {
	    	
	    	   linha = "";
	           linha += ".method ";
	        
	           linha += "<init>(";
	           
	           tipoMetodo = "void"; 
	    	
	    	}
	    
	    	 
	    	
        }
       ;
        
exitMethod
    :   METHOD_DECL
        {
	        if (tipoMetodo.equals("void"))
			Tradutor.buffer.append("return\n");
		else if (tipoMetodo.equals("int"))
			Tradutor.buffer.append("ireturn\n");
		else
			Tradutor.buffer.append("areturn\n") ;
			
		Tradutor.buffer.append(".end method\n");
		  
        }
    ;

exitConstructor
    :   CONSTR_DECL
        {
        	Tradutor.buffer.append("return\n");		
		Tradutor.buffer.append(".end method\n");    
        }
    ;
    
enterParam 	
    :	^(PARAM tp = . ID vet = .?)
	{
	        if ($vet != null) {
	        	if ($tp.getText().equals("int"))
			   linha += "[I;";
		        else if ($tp.getText().equals("void"))
			   throw new SyntacticException("Line: "+$tp.getLine()+"the type of a parameter cannot be void");
		        else
			   linha += "[L"+$tp.getText()+";";
	        } else {
	        	
			if ($tp.getText().equals("int"))
				linha += "I";
			else if ($tp.getText().equals("void"))
				throw new SyntacticException("Line: "+$tp.getLine()+"the type of a parameter cannot be void");
			else
				linha += "L"+$tp.getText()+";";
		}
				
	}
        ;
        
exitParams
	: PARAMS
	{
		linha += ")";
		
		if (tipoMetodo.equals("void"))
			linha += "V";
		else if (tipoMetodo.equals("int"))
			linha += "I";
		else
			linha += "L"+tipoMetodo+";";
			
		Tradutor.buffer.append(linha+"\n");
		
		Tradutor.buffer.append(".limit locals "+metodoAtual.getQuantidadeVariaveis()+"\n");
		
		linha = "";
			
		
	}
	;
	
enterField
    :   ^(FIELD_DECL st = .? tp = . ID vet = .?)
        {
	        Tradutor.buffer.append(".field ");
	        
	        if ($st != null)
	        	Tradutor.buffer.append("static ");
	        
	        Tradutor.buffer.append($ID.text+ " ");
	        
	        if ($tp.getText().equals("int"))
			Tradutor.buffer.append("I");
		else if ($tp.getText().equals("void"))
			throw new SyntacticException("Line: "+$tp.getLine()+"the type of a field cannot be void");
		else
			Tradutor.buffer.append("L"+$tp.getText()+";");
			
		Tradutor.buffer.append("\n");
	        
	        
        }
    ;
     
listaVarDeclAtribuicao 
    :   ^(LISTA_VAR_DECL ^(VAR_DECL tp = . ID vet =.? ^(EXPR a = .)) .*)
        {
        
        	SimboloVariavel simboloVariavel;
        	
        	if ($a.escopo != null){
        	
        		simboloVariavel = (SimboloVariavel)$a.escopo.resolver($a.getText());
        		
        		loadVar(simboloVariavel);
        	
        	} else if (isInteger($a.getText()))
        	
        		loadConst($a.getText());
        		
        	
        	simboloVariavel = (SimboloVariavel) $ID.simbolo;
        	
	        storeVar(simboloVariavel);
	        	        
	        
        }
    ;
    
/*identificadorExpressao
	:       ^(EXPR ID)
		{
			if ($ID.text.equals("null"))
				Tradutor.buffer.append("aconst_null\n");
				
			else {
			
				SimboloVariavel simboloVariavel = (SimboloVariavel) $ID.escopo.resolver($ID.text);
							
				loadVar(simboloVariavel);
		        
		        }
			
		}
	;
	
numeroExpressao
	:       ^(EXPR INT)
		{
			loadConst($INT.text);
			
		}
	;*/

atribuicao
	:	^('=' a = . b = .)
	{
	
		if (!($a.hasAncestor(VECT_EXPR) || $a.hasAncestor(METHOD_CALL))){
		
			SimboloVariavel simboloVariavel;
				
			if ($b.getText().equals("null"))
				Tradutor.buffer.append("aconst_null\n");
			else if ($b.escopo != null){			
				simboloVariavel = (SimboloVariavel) $b.escopo.resolver($b.getText());
				loadVar(simboloVariavel);
			} else if (isInteger($b.getText())) 
				loadConst($b.getText());
				
			if ($a.escopo != null){
				simboloVariavel = (SimboloVariavel)$a.escopo.resolver($a.getText());
				storeVar(simboloVariavel);
			}
		
		}
		
	}
	;
	
addMult
	:       ^((op = '+' | op = '*') a = . b = .)
		{
		
			if (!($op.hasAncestor(VECT_EXPR) || $op.hasAncestor(METHOD_CALL))){
			
				SimboloVariavel simboloVariavel;
				
				if ($a.escopo != null){
					simboloVariavel = (SimboloVariavel) $a.escopo.resolver($a.getText());
					if (simboloVariavel != null)
						loadVar(simboloVariavel);
				} else if (isInteger($a.getText()))
					loadConst($a.getText());
				
				if ($b.escopo != null){
					simboloVariavel = (SimboloVariavel) $b.escopo.resolver($b.getText());
					if (simboloVariavel != null)
						loadVar(simboloVariavel);
				} else if (isInteger($b.getText()))
					loadConst($b.getText());
				
				if (op.getText().equals("+"))
					Tradutor.buffer.append("iadd\n");
				else
					Tradutor.buffer.append("imul\n");
					
			       Tradutor.tipoAtual = new SimboloTipoPrimitivo("int");

				
			}
			
				
		}
	;
	
subDivEnter
	:	^((op = '-' | op = '/' | op = '%') a = . .)
		{
		
			if (!($op.hasAncestor(VECT_EXPR) || $op.hasAncestor(METHOD_CALL))){
				
			        SimboloVariavel simboloVariavel;
				
				if ($a.escopo != null){
					simboloVariavel = (SimboloVariavel) $a.escopo.resolver($a.getText());
					if (simboloVariavel != null)
						loadVar(simboloVariavel);
				} else if (isInteger($a.getText()))
					loadConst($a.getText());
					
			       Tradutor.tipoAtual = new SimboloTipoPrimitivo("int");

				
			}
			
					
		}
	;

subDivExit
	:	 ^((op = '-' | op = '/' | op = '%') . b = .)
		{
		
			if (!($op.hasAncestor(VECT_EXPR) || $op.hasAncestor(METHOD_CALL))){
		
				SimboloVariavel simboloVariavel;
			
				if ($b.escopo != null){
					simboloVariavel = (SimboloVariavel) $b.escopo.resolver($b.getText());
					if (simboloVariavel != null)
						loadVar(simboloVariavel);
				} else if (isInteger($b.getText()))
					loadConst($b.getText());
			
				if (op.getText().equals("-"))
					Tradutor.buffer.append("isub\n");
				else if (op.getText().equals("/"))
					Tradutor.buffer.append("idiv\n");
				else
					Tradutor.buffer.append("irem\n");
					
				Tradutor.tipoAtual = new SimboloTipoPrimitivo("int");

				
			}
			
			
		}
	;
	
acessoCampo 
	:	^('.' a = . b = . )
	{
	
		if (!($a.hasAncestor(VECT_EXPR) || $a.hasAncestor(METHOD_CALL))){
	
			SimboloClasse simboloClasse;
			String instrucao = "";
			
			if ($a.getText().equals(".")){
            			simboloClasse = (SimboloClasse)tabelaSimbolos.global.resolver(Tradutor.tipoAtual.getNome());
				instrucao += "getfield "+simboloClasse.getNome()+"/"+$b.getText();
				SimboloVariavel simboloVariavel = simboloClasse.resolverCampo($b.getText());
				if (simboloVariavel.getTipo().getNome().equals("int")){
					Tradutor.tipoAtual = simboloVariavel.getTipo();
					instrucao += " I";
				} else if (simboloVariavel.getTipo().getNome().equals("int[]")){
					Tradutor.tipoAtual = simboloVariavel.getTipo();
					instrucao += " [I;";
				} else {
					Tradutor.tipoAtual = simboloVariavel.getTipo();
					instrucao += " L"+simboloVariavel.getTipo().getNome()+";";
				}
			} else if ($b.getText().equals(".")){
            			simboloClasse = (SimboloClasse)tabelaSimbolos.global.resolver(Tradutor.tipoAtual.getNome());
				instrucao += "getfield "+simboloClasse.getNome()+"/"+$a.getText();
				SimboloVariavel simboloVariavel = simboloClasse.resolverCampo($a.getText());
				if (simboloVariavel.getTipo().getNome().equals("int")){
					Tradutor.tipoAtual = simboloVariavel.getTipo();
					instrucao += " I";
				} else if (simboloVariavel.getTipo().getNome().equals("int[]")){
					Tradutor.tipoAtual = simboloVariavel.getTipo();
					instrucao += " [I;";
				} else {
					Tradutor.tipoAtual = simboloVariavel.getTipo();
					instrucao += " L"+simboloVariavel.getTipo().getNome()+";";
				}
			} else if ($a.escopo != null && $b.escopo != null){
				simboloClasse = (SimboloClasse)tabelaSimbolos.global.resolver($a.getText());
				if (simboloClasse != null){
					instrucao += "getstatic "+simboloClasse.getNome()+"/"+$b.getText();
					SimboloVariavel simboloVariavel = simboloClasse.resolverCampo($b.getText());
					if (simboloVariavel.getTipo().getNome().equals("int")){
						Tradutor.tipoAtual = simboloVariavel.getTipo();
						instrucao += " I";
					} else if (simboloVariavel.getTipo().getNome().equals("int[]")){
						Tradutor.tipoAtual = simboloVariavel.getTipo();
						instrucao += " [I;";
					} else {
						Tradutor.tipoAtual = simboloVariavel.getTipo();
						instrucao += " L"+simboloVariavel.getTipo().getNome()+";";
					}
				} else {
					loadVar((SimboloVariavel)$a.escopo.resolver($a.getText()));
					simboloClasse = (SimboloClasse)tabelaSimbolos.global.resolver($a.escopo.resolver($a.getText()).getTipo().getNome());
					instrucao += "getfield "+simboloClasse.getNome()+"/"+$b.getText();
					SimboloVariavel simboloVariavel = simboloClasse.resolverCampo($b.getText());
					if (simboloVariavel.getTipo().getNome().equals("int")){
						Tradutor.tipoAtual = simboloVariavel.getTipo();
						instrucao += " I";
					} else if (simboloVariavel.getTipo().getNome().equals("int[]")){
						Tradutor.tipoAtual = simboloVariavel.getTipo();
						instrucao += " [I;";
					} else {
						Tradutor.tipoAtual = simboloVariavel.getTipo();
						instrucao += " L"+simboloVariavel.getTipo().getNome()+";";
					}
				}
			}
			
			Tradutor.buffer.append(instrucao+"\n");
		
		}
	
	}
	;
	
vetorExpr
	:	^(VECT_EXPR a = . ^(EXPR b = .))
		{
		
			if (toStore != $VECT_EXPR) {
			
				CommonTree tree;
				SimboloVariavel simboloVariavel;
				
				if ($a.escopo != null) {
					simboloVariavel = (SimboloVariavel) $a.escopo.resolver($a.getText());
					loadVar(simboloVariavel);						
				} else if ($a.getText().equals(".")){
					percorrerSubArvore($a);	
				}
				
				if ($b.escopo != null) {
					simboloVariavel = (SimboloVariavel) $b.escopo.resolver($b.getText());
					loadVar(simboloVariavel);	
				} else if (isInteger($b.getText()))
					loadConst($b.getText());
				else{				
				        percorrerSubArvore($b);
				}
				
				Tradutor.buffer.append("iaload\n");
				
				Tradutor.tipoAtual = new SimboloTipoReferencia("int[]");
				
			}
		
		}
	;
	
chamadaMetodo
	:	^(METHOD_CALL a = . ^(LISTA_EXPR exprs += .+))
	{
		
		SimboloVariavel simboloVariavel;
		SimboloMetodo simboloMetodo;
		SimboloClasse simboloClasse;
		String nomeMetodo;
		
		if ($a.getText().equals(".")){
			nomeMetodo = ((Tree)$a.getChildren().get(1)).getText();
			if (((Tree)$a.getChildren().get(0)).getText().equals(".")){
				percorrerSubArvore((TradutorAST)$a.getChildren().get(0));
				simboloClasse = (SimboloClasse)Tradutor.tipoAtual;
			}else {
				simboloVariavel = (SimboloVariavel)((TradutorAST)$a.getChildren().get(0)).escopo.resolver(((Tree)$a.getChildren().get(0)).getText());
				loadVar(simboloVariavel);
				simboloClasse = (SimboloClasse)tabelaSimbolos.global.resolver(simboloVariavel.getTipo().getNome());
			}
		} else {
			Tradutor.buffer.append("aload_0\n");
			simboloClasse = classeAtual;
			nomeMetodo = $a.getText();
		}
		
		List<String> tiposParams = new ArrayList<String>();
		
		for (Object expr : list_exprs){
			percorrerSubArvore((TradutorAST)expr);
			tiposParams.add(Tradutor.tipoAtual.getNome());
		}
		
		String assinaturaMetodo = nomeMetodo+"(";
		
		for(String tipoParam : tiposParams)
			assinaturaMetodo += tipoParam+",";
		
		assinaturaMetodo += ")";
		
		System.out.println(assinaturaMetodo);
		
		String call = "";
		
		//irá resolver o método por assinatura                
                /*SimboloMetodo simboloMetodo = (SimboloMetodo)simboloClasse.resolver(nomeMetodo);
		
		if (simboloMetodo.isEstatico())
			call = "invokestatic ";
		else if ($METHOD_CALL.getParent().getText().equals("new"))
			call = "invokespecial ";
		else
			call = "invokevirtual ";
		
		
		//call += Tradutor.tipoReferencia+"/"+nomeMetodo;*/
	
	}
	;
