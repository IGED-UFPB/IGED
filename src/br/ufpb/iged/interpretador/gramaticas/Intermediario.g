grammar Intermediario;

@header{

  package br.ufpb.iged.interpretador.tradutor.intermediario.parser;
  
  import java.io.IOException;
    
}

@lexer::header{
  package br.ufpb.iged.interpretador.tradutor.intermediario.parser;
}

@members {

  protected void adicionarVariavel(Token op);
  protected void traduzirLoad(Token opc, Token op) throws IOException;
  protected void traduzirStore(Token opc, Token op) throws IOException;
  protected void traduzirArimetica(Token opc) throws IOException;

}

programa : instrucao*;

instrucao : (create | load | store | aritmetica);

create : 'CREATE_INT' a = ID {adicionarVariavel($a);}
       | 'DELETE_INT' ID
       ;

load : a = 'READ_INT' b = ID {traduzirLoad($a, $b);}
     | a = 'READ_INTC' INT {traduzirLoad($a, $INT);}
     ;
     
store : a = 'WRITE_INT' b = ID {traduzirStore($a, $b);};

aritmetica : a = 'ADD' {traduzirArimetica($a);}
           | a = 'SUB' {traduzirArimetica($a);}
           | a = 'MULT' {traduzirArimetica($a);}
           | a = 'DIV' {traduzirArimetica($a);}
           ;

INT : '-'? '0'..'9'+ ;

ID: ('a'..'z' | 'A'..'Z') ('a'..'z' | 'A'..'Z' | '0'..'9' | '.')* ;

WS : (' ' | '\t' | '\r' | '\n') {skip();} ;