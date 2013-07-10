tree grammar Ref;
options {
  tokenVocab = Jedi;
  ASTLabelType = TradutorAST;
  filter = true;
}

@header{

    package br.ufpb.iged.tradutor.parser;
    
    import br.ufpb.iged.tradutor.excecoes.SyntacticException;
    import br.ufpb.iged.tradutor.simbolos.Escopo;
    import br.ufpb.iged.tradutor.simbolos.EscopoLocal;
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
    StringBuffer buffer;
    String classeAtual;
    String tipoMetodo;
    String linha;
    SimboloMetodo metodoAtual;
    
    public Ref(CommonTreeNodeStream input, TabelaSimbolos tabelaSimbolos) {
        this(input);
        this.tabelaSimbolos = tabelaSimbolos;
        escopoAtual = tabelaSimbolos.globals;
    }
    
    private void storeVar(SimboloVariavel simboloVariavel){
    
    	int num = simboloVariavel.getEndereco();	
	        
	String tipo = simboloVariavel.getTipo().getNome();
	        
	if (num >= 0 && num <= 3){
	        
	        if (tipo.equals("int"))
	        	buffer.append("istore_"+num+"\n");
		else
	        	buffer.append("astore_"+num+"\n");
	        
	} else {
	        	
	        if (tipo.equals("int"))
	        	buffer.append("istore "+num+"\n");
	        else
	        	buffer.append("astore "+num+"\n");
	        
	 }
    
    }
    
    private void loadVar(SimboloVariavel simboloVariavel){
    
    	int num = simboloVariavel.getEndereco();	
		        
	String tipo = simboloVariavel.getTipo().getNome();
			        
	if (num >= 0 && num <= 3){
			        
		if (tipo.equals("int"))
			buffer.append("iload_"+num+"\n");
		else
			buffer.append("aload_"+num+"\n");
			        
	} else {
			        	
		if (tipo.equals("int"))
			 buffer.append("iload "+num+"\n");
		else
			 buffer.append("aload "+num+"\n");
			        
	}
    
    
    }
    
    private void loadConst(String constante){
    
    	int num =  Integer.parseInt(constante);
			
	if (num >= 0 && num <= 5)
		buffer.append("iconst_"+num+"\n");
	else
		buffer.append("ldc "+num+"\n");
    
    }
    
    private boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch (NumberFormatException nfe) {}
	    return false;
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
    |   identificadorExpressao
    |   numeroExpressao
    |   atribuicao
    |   addMult
    |   subDivExit
    ;

enterClass
    :   ^(CLASSE nome = ID (^(EXTENDS sup = ID))? .+)
        { 
             classeAtual = $nome.getText(); 
	     buffer = new StringBuffer();
	     buffer.append(".class "+classeAtual+"\n");
	     
	     if (sup != null)
	       buffer.append(".super "+$sup.getText()+"\n");
	     
        }
    ;

exitClass
    :   CLASSE
        {
                try {
                        File file = new File("classesteste"); 
                        file.mkdir();
			FileWriter fw = new FileWriter("classesteste/"+classeAtual+".j");
			BufferedWriter bw =  new BufferedWriter(fw);
			buffer.append(".end class");
			bw.write(buffer.toString());
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
	    	
	    		buffer.append(".method ");
	        
	                if (st != null)
	        	   buffer.append("static ");
	        
	                buffer.append( $ID.text + "()");
	                
	                if (tipoMetodo.equals("void"))
				buffer.append("V");
			else if (tipoMetodo.equals("int"))
				buffer.append("I");
			else
				buffer.append("L"+tipoMetodo+";");
			
			buffer.append(linha+"\n");
		
			buffer.append(".limit locals "+metodoAtual.getQuantidadeVariaveis()+"\n");
	    	
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
	    	
	    		buffer.append(".method ");
	        
	                buffer.append("<init>()");
	                
			buffer.append("V");
			
			buffer.append(linha+"\n");
		
			buffer.append(".limit locals "+metodoAtual.getQuantidadeVariaveis()+"\n");
	    	
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
			buffer.append("return\n");
		else if (tipoMetodo.equals("int"))
			buffer.append("ireturn\n");
		else
			buffer.append("areturn\n") ;
			
		buffer.append(".end method\n");
		  
        }
    ;

exitConstructor
    :   CONSTR_DECL
        {
        	buffer.append("return\n");		
		buffer.append(".end method\n");    
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
			
		buffer.append(linha+"\n");
		
		buffer.append(".limit locals "+metodoAtual.getQuantidadeVariaveis()+"\n");
		
		linha = "";
			
		
	}
	;
	
enterField
    :   ^(FIELD_DECL st = .? tp = . ID vet = .?)
        {
	        buffer.append(".field ");
	        
	        if ($st != null)
	        	buffer.append("static ");
	        
	        buffer.append($ID.text+ " ");
	        
	        if ($tp.getText().equals("int"))
			buffer.append("I");
		else if ($tp.getText().equals("void"))
			throw new SyntacticException("Line: "+$tp.getLine()+"the type of a field cannot be void");
		else
			buffer.append("L"+$tp.getText()+";");
			
		buffer.append("\n");
	        
	        
        }
    ;
     
listaVarDeclAtribuicao 
    :   ^(LISTA_VAR_DECL ^(VAR_DECL tp = . ID vet =.? ^(EXPR .)) .*)
        {
        	
        	SimboloVariavel simboloVariavel = (SimboloVariavel) $ID.simbolo;
        	
	        storeVar(simboloVariavel);
	        	        
	        
        }
    ;
    
identificadorExpressao
	:       ^(EXPR ID)
		{
			if ($ID.text.equals("null"))
				buffer.append("aconst_null\n");
				
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
	;

atribuicao
	:	^('=' a = . b = .)
	{
		SimboloVariavel simboloVariavel;
			
		if ($b.getText().equals("null"))
			buffer.append("aconst_null\n");
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
	;
	
addMult
	:       ^((op = '+' | op = '*') a = . b = .)
		{
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
				buffer.append("iadd\n");
			else
				buffer.append("imul\n");
				
		}
	;
	
subDivEnter
	:	^((op = '-' | op = '/' | op = '%') a = . .)
		{
		
		        SimboloVariavel simboloVariavel;
			
			if ($a.escopo != null){
				simboloVariavel = (SimboloVariavel) $a.escopo.resolver($a.getText());
				if (simboloVariavel != null)
					loadVar(simboloVariavel);
			} else if (isInteger($a.getText()))
				loadConst($a.getText());
			
			
		}
	;

subDivExit
	:	 ^((op = '-' | op = '/' | op = '%') . b = .)
		{
		
			SimboloVariavel simboloVariavel;
		
			if ($b.escopo != null){
				simboloVariavel = (SimboloVariavel) $b.escopo.resolver($b.getText());
				if (simboloVariavel != null)
					loadVar(simboloVariavel);
			} else if (isInteger($b.getText()))
				loadConst($b.getText());
		
			if (op.getText().equals("-"))
				buffer.append("isub\n");
			else if (op.getText().equals("/"))
				buffer.append("idiv\n");
			else
				buffer.append("irem\n");
		}
	;