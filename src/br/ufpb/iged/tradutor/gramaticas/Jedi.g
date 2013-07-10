grammar Jedi;

options {
  output = AST;              
  //ASTLabelType = TradutorAST;
}

tokens{
  EXPR;
  VAR_DECL;
  VAR_DECL_LISTA;
  PRE_INCREMENTO;
  PRE_DECREMENTO;
  POS_INCREMENTO;
  POS_DECREMENTO;
  BLOCO;
  IF;
  WHILE;
  FOR;
  INIT_FOR;
  COND_FOR;
  INC_FOR;
  DOWHILE;
  METHOD_CALL;
  LISTA_EXPR;
  LISTA_VAR_DECL;
  VECT_EXPR;
  RETURN;
  FIELD_DECL;
  PARAM;
  PARAMS;
  METHOD_DECL;
  CONSTR_DECL;
  EXTENDS;
  CLASSE;
  NEW;
}

@header{
  //package br.ufpb.iged.tradutor.parser;
  package br.ufpb.iged.tradutor.gramaticas.output;
  
  //import br.ufpb.iged.tradutor.simbolos.TradutorAST;
  
}

@lexer::header{
  //package br.ufpb.iged.tradutor.parser;
  package br.ufpb.iged.tradutor.gramaticas.output;
}

programa : classe+;

classe	: 'class' ID  superClasse? '{' membroClasse+ '}' 
        -> ^(CLASSE ID superClasse? membroClasse+)
        ;

superClasse
	:  'extends' ID -> ^(EXTENDS ID)
	;

membroClasse : fieldDecl | constrDecl | methodDecl;

fieldDecl : a = 'static'? tipo ID vet ='[]'? ';' 
	-> ^(FIELD_DECL $a? tipo ID $vet?)	
	;	
	
methodDecl : a = 'static'? tipo ID '(' params* ')' bloco
           -> ^(METHOD_DECL $a? tipo ID params* bloco)
	   ;
	   
constrDecl :  ID '(' params* ')' bloco
           -> ^(CONSTR_DECL ID params* bloco)
	   ; 
	   
params	:  param (',' param)* -> ^(PARAMS param+);

param	:  tipo ID vet ='[]'? -> ^(PARAM tipo ID $vet?);

instrucao  : ';'
	| expressao ';'
	| listaVarDecl ';'
	| bloco
	| ifStatement
	| whileStatement
	| doWhileStatement ';'
	| forStatement
	| returnStatement ';'
	;

//Expressões

expressao  : atribuicao -> ^(EXPR atribuicao);	

atribuicao : or (('='^) or)* ; 	

or :  and (('||'^) and)* ;

and : xor (('&&'^) xor)* ;

xor  :   igualdade (('^'^) igualdade)* ;

igualdade  :   relacional (('=='^ |'!='^) relacional)* ;

relacional : add (('<'^ | '>'^ | '>='^ | '<='^ )add)* ;

add:   mult (('+'^ |'-'^) mult)* ;

mult: novo (('*'^ | '/'^ | '%'^) novo)* ;

novo	:  posfixa | (('new'^) posfixa) ; 

posfixa
    :   (primaria->primaria)
    	(	options {backtrack=true;}
		:	'.' ID '(' listaExpressoes ')' -> ^(METHOD_CALL ^('.' $posfixa ID ) listaExpressoes)
		|	'.' ID						  -> ^('.' $posfixa ID)
		|	'(' listaExpressoes ')'        -> ^(METHOD_CALL $posfixa listaExpressoes)
		|       '.' ID '[' expressao ']' -> ^(VECT_EXPR ^('.' $posfixa ID ) expressao)
		|       '[' expressao ']'  -> ^(VECT_EXPR $posfixa expressao)
	)*
    ;

listaExpressoes
    :   expressao (',' expressao)* -> ^(LISTA_EXPR expressao+)
    ;


primaria
    :   INT   
    |   ID -> ID
    |   'int' -> 'int'
    //|   'new' ID -> ^(NEW ID)
    //|   'new' a = 'int' -> ^(NEW $a)
    |   '-'^ ID
    | incremento
    |   '(' expressao')' -> expressao
    ;

//Instruções

incremento :  '--' ID ('.'ID)* -> ^(PRE_DECREMENTO ID+)
    	   |  '++' ID ('.'ID)* -> ^(PRE_INCREMENTO ID+)
           |   ID ('.'ID)* '--' -> ^(POS_DECREMENTO ID+)
           |   ID ('.'ID)* '++' -> ^(POS_INCREMENTO ID+)
	   ;
	   
chamadaMetodo
    :   ID
    	(	options {backtrack=true;}
		:	'.' ID '(' listaExpressoes ')' -> ^(METHOD_CALL ^('.' $chamadaMetodo ID ) listaExpressoes)
		|	'(' listaExpressoes ')'        -> ^(METHOD_CALL $chamadaMetodo listaExpressoes)
	)+
    ;
	
varDecl
    :   tipo ID vet ='[]'? ('=' expressao)? 
    -> ^(VAR_DECL tipo ID $vet? expressao?) 
    ;
    
    
listaVarDecl :	varDecl (varDeclLista )* 
	     -> ^(LISTA_VAR_DECL varDecl varDeclLista*)
	     ;
	     
varDeclLista : ',' ID vet = '[]'? ('=' expressao)?
	     -> ^(VAR_DECL_LISTA ID $vet? expressao?)
	     ;
    
tipo:   'int'
    |	 ID 
    ;	  
    
ifStatement  :	'if' '(' expressao ')' instrucao elseIf?
	     -> ^(IF expressao instrucao elseIf?)
	     ;

elseIf	:  ('else' instrucao) -> ^('else' instrucao) ;

bloco 
	:  '{' instrucao* '}' -> ^(BLOCO instrucao*)
	;
        

whileStatement : 'while' '(' expressao ')' instrucao 
               -> ^(WHILE expressao instrucao)
               ;

doWhileStatement  : 'do' instrucao 'while' '(' expressao ')'
                  -> ^(DOWHILE expressao instrucao) 
		  ;
		  
		  
forStatement : 'for' '('inicializacaoFor?';' condicaoFor?';' incrementoFor? ')' instrucao
	     -> ^(FOR inicializacaoFor? condicaoFor? incrementoFor? instrucao)
             ;	
             
inicializacaoFor :  varDecl (',' atribuicao)*  -> ^(INIT_FOR varDecl atribuicao*)
		 |  atribuicao (',' atribuicao)*  -> ^(INIT_FOR atribuicao+)
                 ; 

condicaoFor :  expressao
            -> ^(COND_FOR expressao)
	    ;
	    
incrementoFor : incremento (',' incremento)*
              -> ^(INC_FOR incremento+)
              ;	
              
returnStatement :  'return' expressao? -> ^(RETURN expressao?);

ID  :   (LETRA | '_' )(LETRA | '_'| '0'..'9')*
    ;
    
fragment
LETRA  :   ('a'..'z' | 'A'..'Z')
    ;

INT :   ('-')? '0'..'9'+
    ;

WS  :   (' '|'\r'|'\t'|'\n') {$channel=HIDDEN;}
    ;

SL_COMMENT
    :   '//' ~('\r'|'\n')* '\r'? '\n' {$channel=HIDDEN;}
    ;
