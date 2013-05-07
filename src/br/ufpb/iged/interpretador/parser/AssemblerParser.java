// $ANTLR 3.4 C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g 2013-05-06 22:23:22

  package br.ufpb.iged.interpretador.parser;
  
  import br.ufpb.iged.interpretador.excecoes.AcessoIndevidoMemoriaException;
  import br.ufpb.iged.interpretador.excecoes.LabelException;
  import br.ufpb.iged.interpretador.symboltable.classes.BytecodesAST;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public abstract class AssemblerParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARGS", "ARITMETICA", "BODY", "CONSTR_DECL", "DESVIO", "EXTENDS", "FIELD_DECL", "ID", "INIT", "INT", "INTEIRO", "LABEL", "LIMIT", "LOAD", "LOGICA", "MEMBRO_CLASSE", "METHOD_CALL", "METHOD_DECL", "NEW", "NEWLINE", "NULL", "PARAMS", "PILHA", "REF", "RETURN", "STORE", "TIPO_REF", "VOID", "WS", "'('", "'()'", "')'", "'.class'", "'.end class'", "'.end method'", "'.field'", "'.limit locals'", "'.method'", "'.super'", "':'", "'aconst_null'", "'aload'", "'aload_0'", "'aload_1'", "'aload_2'", "'aload_3'", "'areturn'", "'astore'", "'astore_0'", "'astore_1'", "'astore_2'", "'astore_3'", "'dup'", "'getfield'", "'getstatic'", "'goto'", "'iadd'", "'iand'", "'iconst_0'", "'iconst_1'", "'iconst_2'", "'iconst_3'", "'iconst_4'", "'iconst_5'", "'iconst_m1'", "'idiv'", "'if_icmpeq'", "'if_icmpge'", "'if_icmpgt'", "'if_icmple'", "'if_icmplt'", "'if_icmpne'", "'ifeq'", "'ifge'", "'ifgt'", "'ifle'", "'iflt'", "'ifne'", "'iinc'", "'iload'", "'iload_0'", "'iload_1'", "'iload_2'", "'iload_3'", "'imul'", "'ineg'", "'invokespecial'", "'invokestatic'", "'invokevirtual'", "'ior'", "'irem'", "'ireturn'", "'istore'", "'istore_0'", "'istore_1'", "'istore_2'", "'istore_3'", "'isub'", "'ixor'", "'ldc'", "'new'", "'nop'", "'pop'", "'pop2'", "'putfield'", "'putstatic'", "'return'", "'static'"
    };

    public static final int EOF=-1;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__73=73;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__90=90;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__99=99;
    public static final int T__100=100;
    public static final int T__101=101;
    public static final int T__102=102;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__110=110;
    public static final int T__111=111;
    public static final int ARGS=4;
    public static final int ARITMETICA=5;
    public static final int BODY=6;
    public static final int CONSTR_DECL=7;
    public static final int DESVIO=8;
    public static final int EXTENDS=9;
    public static final int FIELD_DECL=10;
    public static final int ID=11;
    public static final int INIT=12;
    public static final int INT=13;
    public static final int INTEIRO=14;
    public static final int LABEL=15;
    public static final int LIMIT=16;
    public static final int LOAD=17;
    public static final int LOGICA=18;
    public static final int MEMBRO_CLASSE=19;
    public static final int METHOD_CALL=20;
    public static final int METHOD_DECL=21;
    public static final int NEW=22;
    public static final int NEWLINE=23;
    public static final int NULL=24;
    public static final int PARAMS=25;
    public static final int PILHA=26;
    public static final int REF=27;
    public static final int RETURN=28;
    public static final int STORE=29;
    public static final int TIPO_REF=30;
    public static final int VOID=31;
    public static final int WS=32;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public AssemblerParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public AssemblerParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return AssemblerParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g"; }



      public abstract void escreverOpcode(String nomeInstrucao);
      public abstract void escreverOpcode(Token opc, Token op) throws LabelException;
      public abstract void verificarAumentoMemoriaGlobal(Token opc) throws AcessoIndevidoMemoriaException;
      public abstract void verificarAumentoMemoriaGlobal(Token opc, Token op) throws AcessoIndevidoMemoriaException, LabelException;
      


    public static class programa_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "programa"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:51:1: programa : ( instrucao )* ;
    public final AssemblerParser.programa_return programa() throws RecognitionException {
        AssemblerParser.programa_return retval = new AssemblerParser.programa_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        AssemblerParser.instrucao_return instrucao1 =null;



        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:51:10: ( ( instrucao )* )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:51:12: ( instrucao )*
            {
            root_0 = (BytecodesAST)adaptor.nil();


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:51:12: ( instrucao )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ID||LA1_0==NEWLINE||LA1_0==36||(LA1_0 >= 44 && LA1_0 <= 110)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:51:12: instrucao
            	    {
            	    pushFollow(FOLLOW_instrucao_in_programa152);
            	    instrucao1=instrucao();

            	    state._fsp--;

            	    adaptor.addChild(root_0, instrucao1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "programa"


    public static class instrucao_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instrucao"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:54:1: instrucao : ( operacao | definicaoClasse ( '.end class' )? );
    public final AssemblerParser.instrucao_return instrucao() throws RecognitionException {
        AssemblerParser.instrucao_return retval = new AssemblerParser.instrucao_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token string_literal4=null;
        AssemblerParser.operacao_return operacao2 =null;

        AssemblerParser.definicaoClasse_return definicaoClasse3 =null;


        BytecodesAST string_literal4_tree=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:54:11: ( operacao | definicaoClasse ( '.end class' )? )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ID||LA3_0==NEWLINE||(LA3_0 >= 44 && LA3_0 <= 110)) ) {
                alt3=1;
            }
            else if ( (LA3_0==36) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:54:13: operacao
                    {
                    root_0 = (BytecodesAST)adaptor.nil();


                    pushFollow(FOLLOW_operacao_in_instrucao180);
                    operacao2=operacao();

                    state._fsp--;

                    adaptor.addChild(root_0, operacao2.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:55:13: definicaoClasse ( '.end class' )?
                    {
                    root_0 = (BytecodesAST)adaptor.nil();


                    pushFollow(FOLLOW_definicaoClasse_in_instrucao194);
                    definicaoClasse3=definicaoClasse();

                    state._fsp--;

                    adaptor.addChild(root_0, definicaoClasse3.getTree());

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:55:29: ( '.end class' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==37) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:55:30: '.end class'
                            {
                            string_literal4=(Token)match(input,37,FOLLOW_37_in_instrucao197); 
                            string_literal4_tree = 
                            (BytecodesAST)adaptor.create(string_literal4)
                            ;
                            adaptor.addChild(root_0, string_literal4_tree);


                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "instrucao"


    public static class operacao_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "operacao"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:58:1: operacao : ( label comando | comando ) ;
    public final AssemblerParser.operacao_return operacao() throws RecognitionException {
        AssemblerParser.operacao_return retval = new AssemblerParser.operacao_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        AssemblerParser.label_return label5 =null;

        AssemblerParser.comando_return comando6 =null;

        AssemblerParser.comando_return comando7 =null;



        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:58:10: ( ( label comando | comando ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:58:12: ( label comando | comando )
            {
            root_0 = (BytecodesAST)adaptor.nil();


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:58:12: ( label comando | comando )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==NEWLINE||(LA4_0 >= 44 && LA4_0 <= 110)) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:58:13: label comando
                    {
                    pushFollow(FOLLOW_label_in_operacao219);
                    label5=label();

                    state._fsp--;

                    adaptor.addChild(root_0, label5.getTree());

                    pushFollow(FOLLOW_comando_in_operacao221);
                    comando6=comando();

                    state._fsp--;

                    adaptor.addChild(root_0, comando6.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:58:29: comando
                    {
                    pushFollow(FOLLOW_comando_in_operacao225);
                    comando7=comando();

                    state._fsp--;

                    adaptor.addChild(root_0, comando7.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "operacao"


    public static class label_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "label"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:60:1: label : a= ID ':' -> ^( LABEL $a) ;
    public final AssemblerParser.label_return label() throws RecognitionException {
        AssemblerParser.label_return retval = new AssemblerParser.label_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;
        Token char_literal8=null;

        BytecodesAST a_tree=null;
        BytecodesAST char_literal8_tree=null;
        RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:60:7: (a= ID ':' -> ^( LABEL $a) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:60:9: a= ID ':'
            {
            a=(Token)match(input,ID,FOLLOW_ID_in_label247);  
            stream_ID.add(a);


            char_literal8=(Token)match(input,43,FOLLOW_43_in_label249);  
            stream_43.add(char_literal8);


            // AST REWRITE
            // elements: a
            // token labels: a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 60:20: -> ^( LABEL $a)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:60:23: ^( LABEL $a)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(LABEL, "LABEL")
                , root_1);

                adaptor.addChild(root_1, stream_a.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "label"


    public static class comando_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "comando"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:62:1: comando : ( manipulacaoObjetos | aritmetica | load | loadint | store | storeint | desvio | logica | pilha | retorno | 'nop' )? NEWLINE ;
    public final AssemblerParser.comando_return comando() throws RecognitionException {
        AssemblerParser.comando_return retval = new AssemblerParser.comando_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token string_literal19=null;
        Token NEWLINE20=null;
        AssemblerParser.manipulacaoObjetos_return manipulacaoObjetos9 =null;

        AssemblerParser.aritmetica_return aritmetica10 =null;

        AssemblerParser.load_return load11 =null;

        AssemblerParser.loadint_return loadint12 =null;

        AssemblerParser.store_return store13 =null;

        AssemblerParser.storeint_return storeint14 =null;

        AssemblerParser.desvio_return desvio15 =null;

        AssemblerParser.logica_return logica16 =null;

        AssemblerParser.pilha_return pilha17 =null;

        AssemblerParser.retorno_return retorno18 =null;


        BytecodesAST string_literal19_tree=null;
        BytecodesAST NEWLINE20_tree=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:62:8: ( ( manipulacaoObjetos | aritmetica | load | loadint | store | storeint | desvio | logica | pilha | retorno | 'nop' )? NEWLINE )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:62:10: ( manipulacaoObjetos | aritmetica | load | loadint | store | storeint | desvio | logica | pilha | retorno | 'nop' )? NEWLINE
            {
            root_0 = (BytecodesAST)adaptor.nil();


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:62:10: ( manipulacaoObjetos | aritmetica | load | loadint | store | storeint | desvio | logica | pilha | retorno | 'nop' )?
            int alt5=12;
            switch ( input.LA(1) ) {
                case 57:
                case 58:
                case 90:
                case 91:
                case 92:
                case 104:
                case 108:
                case 109:
                    {
                    alt5=1;
                    }
                    break;
                case 60:
                case 69:
                case 82:
                case 88:
                case 89:
                case 94:
                case 101:
                    {
                    alt5=2;
                    }
                    break;
                case 44:
                case 46:
                case 47:
                case 48:
                case 49:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 84:
                case 85:
                case 86:
                case 87:
                    {
                    alt5=3;
                    }
                    break;
                case 45:
                case 83:
                case 103:
                    {
                    alt5=4;
                    }
                    break;
                case 52:
                case 53:
                case 54:
                case 55:
                case 97:
                case 98:
                case 99:
                case 100:
                    {
                    alt5=5;
                    }
                    break;
                case 51:
                case 96:
                    {
                    alt5=6;
                    }
                    break;
                case 59:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                    {
                    alt5=7;
                    }
                    break;
                case 61:
                case 93:
                case 102:
                    {
                    alt5=8;
                    }
                    break;
                case 56:
                case 106:
                case 107:
                    {
                    alt5=9;
                    }
                    break;
                case 50:
                case 95:
                case 110:
                    {
                    alt5=10;
                    }
                    break;
                case 105:
                    {
                    alt5=11;
                    }
                    break;
            }

            switch (alt5) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:62:12: manipulacaoObjetos
                    {
                    pushFollow(FOLLOW_manipulacaoObjetos_in_comando267);
                    manipulacaoObjetos9=manipulacaoObjetos();

                    state._fsp--;

                    adaptor.addChild(root_0, manipulacaoObjetos9.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:63:17: aritmetica
                    {
                    pushFollow(FOLLOW_aritmetica_in_comando285);
                    aritmetica10=aritmetica();

                    state._fsp--;

                    adaptor.addChild(root_0, aritmetica10.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:64:17: load
                    {
                    pushFollow(FOLLOW_load_in_comando303);
                    load11=load();

                    state._fsp--;

                    adaptor.addChild(root_0, load11.getTree());

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:65:17: loadint
                    {
                    pushFollow(FOLLOW_loadint_in_comando321);
                    loadint12=loadint();

                    state._fsp--;

                    adaptor.addChild(root_0, loadint12.getTree());

                    }
                    break;
                case 5 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:66:17: store
                    {
                    pushFollow(FOLLOW_store_in_comando339);
                    store13=store();

                    state._fsp--;

                    adaptor.addChild(root_0, store13.getTree());

                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:67:17: storeint
                    {
                    pushFollow(FOLLOW_storeint_in_comando357);
                    storeint14=storeint();

                    state._fsp--;

                    adaptor.addChild(root_0, storeint14.getTree());

                    }
                    break;
                case 7 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:68:17: desvio
                    {
                    pushFollow(FOLLOW_desvio_in_comando375);
                    desvio15=desvio();

                    state._fsp--;

                    adaptor.addChild(root_0, desvio15.getTree());

                    }
                    break;
                case 8 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:69:17: logica
                    {
                    pushFollow(FOLLOW_logica_in_comando393);
                    logica16=logica();

                    state._fsp--;

                    adaptor.addChild(root_0, logica16.getTree());

                    }
                    break;
                case 9 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:70:17: pilha
                    {
                    pushFollow(FOLLOW_pilha_in_comando411);
                    pilha17=pilha();

                    state._fsp--;

                    adaptor.addChild(root_0, pilha17.getTree());

                    }
                    break;
                case 10 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:71:17: retorno
                    {
                    pushFollow(FOLLOW_retorno_in_comando429);
                    retorno18=retorno();

                    state._fsp--;

                    adaptor.addChild(root_0, retorno18.getTree());

                    }
                    break;
                case 11 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:72:17: 'nop'
                    {
                    string_literal19=(Token)match(input,105,FOLLOW_105_in_comando447); 
                    string_literal19_tree = 
                    (BytecodesAST)adaptor.create(string_literal19)
                    ;
                    adaptor.addChild(root_0, string_literal19_tree);


                    }
                    break;

            }


            NEWLINE20=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_comando463); 
            NEWLINE20_tree = 
            (BytecodesAST)adaptor.create(NEWLINE20)
            ;
            adaptor.addChild(root_0, NEWLINE20_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "comando"


    public static class definicaoClasse_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "definicaoClasse"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:75:1: definicaoClasse : '.class' ID NEWLINE ( superClasse NEWLINE )? ( membroClasse NEWLINE )+ -> ^( '.class' ID ( superClasse )? ^( MEMBRO_CLASSE ( membroClasse )+ ) ) ;
    public final AssemblerParser.definicaoClasse_return definicaoClasse() throws RecognitionException {
        AssemblerParser.definicaoClasse_return retval = new AssemblerParser.definicaoClasse_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token string_literal21=null;
        Token ID22=null;
        Token NEWLINE23=null;
        Token NEWLINE25=null;
        Token NEWLINE27=null;
        AssemblerParser.superClasse_return superClasse24 =null;

        AssemblerParser.membroClasse_return membroClasse26 =null;


        BytecodesAST string_literal21_tree=null;
        BytecodesAST ID22_tree=null;
        BytecodesAST NEWLINE23_tree=null;
        BytecodesAST NEWLINE25_tree=null;
        BytecodesAST NEWLINE27_tree=null;
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
        RewriteRuleSubtreeStream stream_membroClasse=new RewriteRuleSubtreeStream(adaptor,"rule membroClasse");
        RewriteRuleSubtreeStream stream_superClasse=new RewriteRuleSubtreeStream(adaptor,"rule superClasse");
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:76:5: ( '.class' ID NEWLINE ( superClasse NEWLINE )? ( membroClasse NEWLINE )+ -> ^( '.class' ID ( superClasse )? ^( MEMBRO_CLASSE ( membroClasse )+ ) ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:76:7: '.class' ID NEWLINE ( superClasse NEWLINE )? ( membroClasse NEWLINE )+
            {
            string_literal21=(Token)match(input,36,FOLLOW_36_in_definicaoClasse486);  
            stream_36.add(string_literal21);


            ID22=(Token)match(input,ID,FOLLOW_ID_in_definicaoClasse488);  
            stream_ID.add(ID22);


            NEWLINE23=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_definicaoClasse490);  
            stream_NEWLINE.add(NEWLINE23);


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:76:27: ( superClasse NEWLINE )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==42) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:76:28: superClasse NEWLINE
                    {
                    pushFollow(FOLLOW_superClasse_in_definicaoClasse493);
                    superClasse24=superClasse();

                    state._fsp--;

                    stream_superClasse.add(superClasse24.getTree());

                    NEWLINE25=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_definicaoClasse495);  
                    stream_NEWLINE.add(NEWLINE25);


                    }
                    break;

            }


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:76:50: ( membroClasse NEWLINE )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==39||LA7_0==41) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:76:51: membroClasse NEWLINE
            	    {
            	    pushFollow(FOLLOW_membroClasse_in_definicaoClasse500);
            	    membroClasse26=membroClasse();

            	    state._fsp--;

            	    stream_membroClasse.add(membroClasse26.getTree());

            	    NEWLINE27=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_definicaoClasse502);  
            	    stream_NEWLINE.add(NEWLINE27);


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            // AST REWRITE
            // elements: membroClasse, ID, 36, superClasse
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 77:12: -> ^( '.class' ID ( superClasse )? ^( MEMBRO_CLASSE ( membroClasse )+ ) )
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:77:15: ^( '.class' ID ( superClasse )? ^( MEMBRO_CLASSE ( membroClasse )+ ) )
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                stream_36.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );

                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:77:29: ( superClasse )?
                if ( stream_superClasse.hasNext() ) {
                    adaptor.addChild(root_1, stream_superClasse.nextTree());

                }
                stream_superClasse.reset();

                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:77:42: ^( MEMBRO_CLASSE ( membroClasse )+ )
                {
                BytecodesAST root_2 = (BytecodesAST)adaptor.nil();
                root_2 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(MEMBRO_CLASSE, "MEMBRO_CLASSE")
                , root_2);

                if ( !(stream_membroClasse.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_membroClasse.hasNext() ) {
                    adaptor.addChild(root_2, stream_membroClasse.nextTree());

                }
                stream_membroClasse.reset();

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "definicaoClasse"


    public static class superClasse_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "superClasse"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:80:1: superClasse : '.super' (b= ID |b= REF ) -> ^( EXTENDS $b) ;
    public final AssemblerParser.superClasse_return superClasse() throws RecognitionException {
        AssemblerParser.superClasse_return retval = new AssemblerParser.superClasse_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token b=null;
        Token string_literal28=null;

        BytecodesAST b_tree=null;
        BytecodesAST string_literal28_tree=null;
        RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_REF=new RewriteRuleTokenStream(adaptor,"token REF");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:80:13: ( '.super' (b= ID |b= REF ) -> ^( EXTENDS $b) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:80:15: '.super' (b= ID |b= REF )
            {
            string_literal28=(Token)match(input,42,FOLLOW_42_in_superClasse563);  
            stream_42.add(string_literal28);


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:80:24: (b= ID |b= REF )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==REF) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:80:25: b= ID
                    {
                    b=(Token)match(input,ID,FOLLOW_ID_in_superClasse570);  
                    stream_ID.add(b);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:80:34: b= REF
                    {
                    b=(Token)match(input,REF,FOLLOW_REF_in_superClasse578);  
                    stream_REF.add(b);


                    }
                    break;

            }


            // AST REWRITE
            // elements: b
            // token labels: b
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 80:42: -> ^( EXTENDS $b)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:80:45: ^( EXTENDS $b)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(EXTENDS, "EXTENDS")
                , root_1);

                adaptor.addChild(root_1, stream_b.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "superClasse"


    public static class membroClasse_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "membroClasse"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:82:1: membroClasse : ( '.field' (st= 'static' )? ID tipo -> ^( FIELD_DECL ( $st)? ID tipo ) | '.method' INIT ( parametros | '(' parametros ')' ) ret= tipo NEWLINE ( limite NEWLINE )? ( operacao )* '.end method' -> ^( CONSTR_DECL INIT $ret parametros ( limite )? ^( BODY ( operacao )* ) ) | '.method' ( 'static' )? ID ( parametros | '(' parametros ')' ) ret= tipo NEWLINE ( limite NEWLINE )? ( operacao )* '.end method' -> ^( METHOD_DECL ID $ret parametros ( limite )? ^( BODY ( operacao )* ) ) );
    public final AssemblerParser.membroClasse_return membroClasse() throws RecognitionException {
        AssemblerParser.membroClasse_return retval = new AssemblerParser.membroClasse_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token st=null;
        Token string_literal29=null;
        Token ID30=null;
        Token string_literal32=null;
        Token INIT33=null;
        Token char_literal35=null;
        Token char_literal37=null;
        Token NEWLINE38=null;
        Token NEWLINE40=null;
        Token string_literal42=null;
        Token string_literal43=null;
        Token string_literal44=null;
        Token ID45=null;
        Token char_literal47=null;
        Token char_literal49=null;
        Token NEWLINE50=null;
        Token NEWLINE52=null;
        Token string_literal54=null;
        AssemblerParser.tipo_return ret =null;

        AssemblerParser.tipo_return tipo31 =null;

        AssemblerParser.parametros_return parametros34 =null;

        AssemblerParser.parametros_return parametros36 =null;

        AssemblerParser.limite_return limite39 =null;

        AssemblerParser.operacao_return operacao41 =null;

        AssemblerParser.parametros_return parametros46 =null;

        AssemblerParser.parametros_return parametros48 =null;

        AssemblerParser.limite_return limite51 =null;

        AssemblerParser.operacao_return operacao53 =null;


        BytecodesAST st_tree=null;
        BytecodesAST string_literal29_tree=null;
        BytecodesAST ID30_tree=null;
        BytecodesAST string_literal32_tree=null;
        BytecodesAST INIT33_tree=null;
        BytecodesAST char_literal35_tree=null;
        BytecodesAST char_literal37_tree=null;
        BytecodesAST NEWLINE38_tree=null;
        BytecodesAST NEWLINE40_tree=null;
        BytecodesAST string_literal42_tree=null;
        BytecodesAST string_literal43_tree=null;
        BytecodesAST string_literal44_tree=null;
        BytecodesAST ID45_tree=null;
        BytecodesAST char_literal47_tree=null;
        BytecodesAST char_literal49_tree=null;
        BytecodesAST NEWLINE50_tree=null;
        BytecodesAST NEWLINE52_tree=null;
        BytecodesAST string_literal54_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_INIT=new RewriteRuleTokenStream(adaptor,"token INIT");
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
        RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
        RewriteRuleSubtreeStream stream_limite=new RewriteRuleSubtreeStream(adaptor,"rule limite");
        RewriteRuleSubtreeStream stream_parametros=new RewriteRuleSubtreeStream(adaptor,"rule parametros");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        RewriteRuleSubtreeStream stream_operacao=new RewriteRuleSubtreeStream(adaptor,"rule operacao");
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:83:5: ( '.field' (st= 'static' )? ID tipo -> ^( FIELD_DECL ( $st)? ID tipo ) | '.method' INIT ( parametros | '(' parametros ')' ) ret= tipo NEWLINE ( limite NEWLINE )? ( operacao )* '.end method' -> ^( CONSTR_DECL INIT $ret parametros ( limite )? ^( BODY ( operacao )* ) ) | '.method' ( 'static' )? ID ( parametros | '(' parametros ')' ) ret= tipo NEWLINE ( limite NEWLINE )? ( operacao )* '.end method' -> ^( METHOD_DECL ID $ret parametros ( limite )? ^( BODY ( operacao )* ) ) )
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            else if ( (LA17_0==41) ) {
                int LA17_2 = input.LA(2);

                if ( (LA17_2==INIT) ) {
                    alt17=2;
                }
                else if ( (LA17_2==ID||LA17_2==111) ) {
                    alt17=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:83:7: '.field' (st= 'static' )? ID tipo
                    {
                    string_literal29=(Token)match(input,39,FOLLOW_39_in_membroClasse600);  
                    stream_39.add(string_literal29);


                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:83:19: (st= 'static' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==111) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:83:19: st= 'static'
                            {
                            st=(Token)match(input,111,FOLLOW_111_in_membroClasse606);  
                            stream_111.add(st);


                            }
                            break;

                    }


                    ID30=(Token)match(input,ID,FOLLOW_ID_in_membroClasse609);  
                    stream_ID.add(ID30);


                    pushFollow(FOLLOW_tipo_in_membroClasse611);
                    tipo31=tipo();

                    state._fsp--;

                    stream_tipo.add(tipo31.getTree());

                    // AST REWRITE
                    // elements: tipo, st, ID
                    // token labels: st
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_st=new RewriteRuleTokenStream(adaptor,"token st",st);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 83:39: -> ^( FIELD_DECL ( $st)? ID tipo )
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:83:42: ^( FIELD_DECL ( $st)? ID tipo )
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        (BytecodesAST)adaptor.create(FIELD_DECL, "FIELD_DECL")
                        , root_1);

                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:83:56: ( $st)?
                        if ( stream_st.hasNext() ) {
                            adaptor.addChild(root_1, stream_st.nextNode());

                        }
                        stream_st.reset();

                        adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        );

                        adaptor.addChild(root_1, stream_tipo.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:84:7: '.method' INIT ( parametros | '(' parametros ')' ) ret= tipo NEWLINE ( limite NEWLINE )? ( operacao )* '.end method'
                    {
                    string_literal32=(Token)match(input,41,FOLLOW_41_in_membroClasse633);  
                    stream_41.add(string_literal32);


                    INIT33=(Token)match(input,INIT,FOLLOW_INIT_in_membroClasse635);  
                    stream_INIT.add(INIT33);


                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:84:22: ( parametros | '(' parametros ')' )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==INT||LA10_0==TIPO_REF||LA10_0==34) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==33) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;

                    }
                    switch (alt10) {
                        case 1 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:84:23: parametros
                            {
                            pushFollow(FOLLOW_parametros_in_membroClasse638);
                            parametros34=parametros();

                            state._fsp--;

                            stream_parametros.add(parametros34.getTree());

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:84:36: '(' parametros ')'
                            {
                            char_literal35=(Token)match(input,33,FOLLOW_33_in_membroClasse642);  
                            stream_33.add(char_literal35);


                            pushFollow(FOLLOW_parametros_in_membroClasse644);
                            parametros36=parametros();

                            state._fsp--;

                            stream_parametros.add(parametros36.getTree());

                            char_literal37=(Token)match(input,35,FOLLOW_35_in_membroClasse646);  
                            stream_35.add(char_literal37);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_tipo_in_membroClasse653);
                    ret=tipo();

                    state._fsp--;

                    stream_tipo.add(ret.getTree());

                    NEWLINE38=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_membroClasse655);  
                    stream_NEWLINE.add(NEWLINE38);


                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:84:75: ( limite NEWLINE )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==40) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:84:76: limite NEWLINE
                            {
                            pushFollow(FOLLOW_limite_in_membroClasse658);
                            limite39=limite();

                            state._fsp--;

                            stream_limite.add(limite39.getTree());

                            NEWLINE40=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_membroClasse660);  
                            stream_NEWLINE.add(NEWLINE40);


                            }
                            break;

                    }


                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:84:93: ( operacao )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==ID||LA12_0==NEWLINE||(LA12_0 >= 44 && LA12_0 <= 110)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:84:93: operacao
                    	    {
                    	    pushFollow(FOLLOW_operacao_in_membroClasse664);
                    	    operacao41=operacao();

                    	    state._fsp--;

                    	    stream_operacao.add(operacao41.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    string_literal42=(Token)match(input,38,FOLLOW_38_in_membroClasse667);  
                    stream_38.add(string_literal42);


                    // AST REWRITE
                    // elements: operacao, limite, parametros, INIT, ret
                    // token labels: 
                    // rule labels: ret, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_ret=new RewriteRuleSubtreeStream(adaptor,"rule ret",ret!=null?ret.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 85:2: -> ^( CONSTR_DECL INIT $ret parametros ( limite )? ^( BODY ( operacao )* ) )
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:85:5: ^( CONSTR_DECL INIT $ret parametros ( limite )? ^( BODY ( operacao )* ) )
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        (BytecodesAST)adaptor.create(CONSTR_DECL, "CONSTR_DECL")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_INIT.nextNode()
                        );

                        adaptor.addChild(root_1, stream_ret.nextTree());

                        adaptor.addChild(root_1, stream_parametros.nextTree());

                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:85:40: ( limite )?
                        if ( stream_limite.hasNext() ) {
                            adaptor.addChild(root_1, stream_limite.nextTree());

                        }
                        stream_limite.reset();

                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:85:48: ^( BODY ( operacao )* )
                        {
                        BytecodesAST root_2 = (BytecodesAST)adaptor.nil();
                        root_2 = (BytecodesAST)adaptor.becomeRoot(
                        (BytecodesAST)adaptor.create(BODY, "BODY")
                        , root_2);

                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:85:55: ( operacao )*
                        while ( stream_operacao.hasNext() ) {
                            adaptor.addChild(root_2, stream_operacao.nextTree());

                        }
                        stream_operacao.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:86:7: '.method' ( 'static' )? ID ( parametros | '(' parametros ')' ) ret= tipo NEWLINE ( limite NEWLINE )? ( operacao )* '.end method'
                    {
                    string_literal43=(Token)match(input,41,FOLLOW_41_in_membroClasse699);  
                    stream_41.add(string_literal43);


                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:86:17: ( 'static' )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==111) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:86:17: 'static'
                            {
                            string_literal44=(Token)match(input,111,FOLLOW_111_in_membroClasse701);  
                            stream_111.add(string_literal44);


                            }
                            break;

                    }


                    ID45=(Token)match(input,ID,FOLLOW_ID_in_membroClasse704);  
                    stream_ID.add(ID45);


                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:86:30: ( parametros | '(' parametros ')' )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==INT||LA14_0==TIPO_REF||LA14_0==34) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==33) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;

                    }
                    switch (alt14) {
                        case 1 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:86:31: parametros
                            {
                            pushFollow(FOLLOW_parametros_in_membroClasse707);
                            parametros46=parametros();

                            state._fsp--;

                            stream_parametros.add(parametros46.getTree());

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:86:44: '(' parametros ')'
                            {
                            char_literal47=(Token)match(input,33,FOLLOW_33_in_membroClasse711);  
                            stream_33.add(char_literal47);


                            pushFollow(FOLLOW_parametros_in_membroClasse713);
                            parametros48=parametros();

                            state._fsp--;

                            stream_parametros.add(parametros48.getTree());

                            char_literal49=(Token)match(input,35,FOLLOW_35_in_membroClasse715);  
                            stream_35.add(char_literal49);


                            }
                            break;

                    }


                    pushFollow(FOLLOW_tipo_in_membroClasse722);
                    ret=tipo();

                    state._fsp--;

                    stream_tipo.add(ret.getTree());

                    NEWLINE50=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_membroClasse724);  
                    stream_NEWLINE.add(NEWLINE50);


                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:86:83: ( limite NEWLINE )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==40) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:86:84: limite NEWLINE
                            {
                            pushFollow(FOLLOW_limite_in_membroClasse727);
                            limite51=limite();

                            state._fsp--;

                            stream_limite.add(limite51.getTree());

                            NEWLINE52=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_membroClasse729);  
                            stream_NEWLINE.add(NEWLINE52);


                            }
                            break;

                    }


                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:86:101: ( operacao )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==ID||LA16_0==NEWLINE||(LA16_0 >= 44 && LA16_0 <= 110)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:86:101: operacao
                    	    {
                    	    pushFollow(FOLLOW_operacao_in_membroClasse733);
                    	    operacao53=operacao();

                    	    state._fsp--;

                    	    stream_operacao.add(operacao53.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    string_literal54=(Token)match(input,38,FOLLOW_38_in_membroClasse736);  
                    stream_38.add(string_literal54);


                    // AST REWRITE
                    // elements: ID, operacao, parametros, ret, limite
                    // token labels: 
                    // rule labels: ret, retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_ret=new RewriteRuleSubtreeStream(adaptor,"rule ret",ret!=null?ret.tree:null);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 87:9: -> ^( METHOD_DECL ID $ret parametros ( limite )? ^( BODY ( operacao )* ) )
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:87:12: ^( METHOD_DECL ID $ret parametros ( limite )? ^( BODY ( operacao )* ) )
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        (BytecodesAST)adaptor.create(METHOD_DECL, "METHOD_DECL")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_ID.nextNode()
                        );

                        adaptor.addChild(root_1, stream_ret.nextTree());

                        adaptor.addChild(root_1, stream_parametros.nextTree());

                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:87:45: ( limite )?
                        if ( stream_limite.hasNext() ) {
                            adaptor.addChild(root_1, stream_limite.nextTree());

                        }
                        stream_limite.reset();

                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:87:53: ^( BODY ( operacao )* )
                        {
                        BytecodesAST root_2 = (BytecodesAST)adaptor.nil();
                        root_2 = (BytecodesAST)adaptor.becomeRoot(
                        (BytecodesAST)adaptor.create(BODY, "BODY")
                        , root_2);

                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:87:60: ( operacao )*
                        while ( stream_operacao.hasNext() ) {
                            adaptor.addChild(root_2, stream_operacao.nextTree());

                        }
                        stream_operacao.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "membroClasse"


    public static class limite_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "limite"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:90:1: limite : '.limit locals' INTEIRO -> ^( LIMIT INTEIRO ) ;
    public final AssemblerParser.limite_return limite() throws RecognitionException {
        AssemblerParser.limite_return retval = new AssemblerParser.limite_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token string_literal55=null;
        Token INTEIRO56=null;

        BytecodesAST string_literal55_tree=null;
        BytecodesAST INTEIRO56_tree=null;
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_INTEIRO=new RewriteRuleTokenStream(adaptor,"token INTEIRO");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:90:8: ( '.limit locals' INTEIRO -> ^( LIMIT INTEIRO ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:90:11: '.limit locals' INTEIRO
            {
            string_literal55=(Token)match(input,40,FOLLOW_40_in_limite785);  
            stream_40.add(string_literal55);


            INTEIRO56=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_limite787);  
            stream_INTEIRO.add(INTEIRO56);


            // AST REWRITE
            // elements: INTEIRO
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 90:35: -> ^( LIMIT INTEIRO )
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:90:38: ^( LIMIT INTEIRO )
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(LIMIT, "LIMIT")
                , root_1);

                adaptor.addChild(root_1, 
                stream_INTEIRO.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "limite"


    public static class parametros_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parametros"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:92:1: parametros : ( '()' -> ^( PARAMS VOID ) | (a= INT |a= TIPO_REF ) -> ^( PARAMS $a) );
    public final AssemblerParser.parametros_return parametros() throws RecognitionException {
        AssemblerParser.parametros_return retval = new AssemblerParser.parametros_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;
        Token string_literal57=null;

        BytecodesAST a_tree=null;
        BytecodesAST string_literal57_tree=null;
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_TIPO_REF=new RewriteRuleTokenStream(adaptor,"token TIPO_REF");
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:93:2: ( '()' -> ^( PARAMS VOID ) | (a= INT |a= TIPO_REF ) -> ^( PARAMS $a) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==34) ) {
                alt19=1;
            }
            else if ( (LA19_0==INT||LA19_0==TIPO_REF) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:93:4: '()'
                    {
                    string_literal57=(Token)match(input,34,FOLLOW_34_in_parametros809);  
                    stream_34.add(string_literal57);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 93:9: -> ^( PARAMS VOID )
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:93:12: ^( PARAMS VOID )
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        (BytecodesAST)adaptor.create(PARAMS, "PARAMS")
                        , root_1);

                        adaptor.addChild(root_1, 
                        (BytecodesAST)adaptor.create(VOID, "VOID")
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:94:4: (a= INT |a= TIPO_REF )
                    {
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:94:4: (a= INT |a= TIPO_REF )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==INT) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==TIPO_REF) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;

                    }
                    switch (alt18) {
                        case 1 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:94:6: a= INT
                            {
                            a=(Token)match(input,INT,FOLLOW_INT_in_parametros828);  
                            stream_INT.add(a);


                            }
                            break;
                        case 2 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:94:16: a= TIPO_REF
                            {
                            a=(Token)match(input,TIPO_REF,FOLLOW_TIPO_REF_in_parametros836);  
                            stream_TIPO_REF.add(a);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: a
                    // token labels: a
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 95:4: -> ^( PARAMS $a)
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:95:7: ^( PARAMS $a)
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        (BytecodesAST)adaptor.create(PARAMS, "PARAMS")
                        , root_1);

                        adaptor.addChild(root_1, stream_a.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parametros"


    public static class retorno_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "retorno"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:98:1: retorno : (a= 'areturn' |a= 'ireturn' |a= 'return' ) -> ^( RETURN $a) ;
    public final AssemblerParser.retorno_return retorno() throws RecognitionException {
        AssemblerParser.retorno_return retval = new AssemblerParser.retorno_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;

        BytecodesAST a_tree=null;
        RewriteRuleTokenStream stream_95=new RewriteRuleTokenStream(adaptor,"token 95");
        RewriteRuleTokenStream stream_110=new RewriteRuleTokenStream(adaptor,"token 110");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:98:9: ( (a= 'areturn' |a= 'ireturn' |a= 'return' ) -> ^( RETURN $a) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:99:9: (a= 'areturn' |a= 'ireturn' |a= 'return' )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:99:9: (a= 'areturn' |a= 'ireturn' |a= 'return' )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 50:
                {
                alt20=1;
                }
                break;
            case 95:
                {
                alt20=2;
                }
                break;
            case 110:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }

            switch (alt20) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:99:13: a= 'areturn'
                    {
                    a=(Token)match(input,50,FOLLOW_50_in_retorno876);  
                    stream_50.add(a);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:100:13: a= 'ireturn'
                    {
                    a=(Token)match(input,95,FOLLOW_95_in_retorno894);  
                    stream_95.add(a);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:101:13: a= 'return'
                    {
                    a=(Token)match(input,110,FOLLOW_110_in_retorno912);  
                    stream_110.add(a);


                    }
                    break;

            }


            // AST REWRITE
            // elements: a
            // token labels: a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 103:10: -> ^( RETURN $a)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:103:13: ^( RETURN $a)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(RETURN, "RETURN")
                , root_1);

                adaptor.addChild(root_1, stream_a.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "retorno"


    public static class manipulacaoObjetos_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "manipulacaoObjetos"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:106:1: manipulacaoObjetos : (a= 'getfield' REF tipo -> ^( 'getfield' REF tipo ) |a= 'getstatic' REF tipo -> ^( 'getstatic' REF tipo ) |a= 'putfield' REF tipo -> ^( 'putfield' REF tipo ) |a= 'putstatic' REF tipo -> ^( 'putstatic' REF tipo ) |a= 'invokespecial' REF d= parametrosRetorno -> ^( 'invokespecial' REF $d) |a= 'invokestatic' REF d= parametrosRetorno -> ^( 'invokestatic' REF $d) |a= 'invokevirtual' REF d= parametrosRetorno -> ^( 'invokevirtual' REF $d) |a= 'new' (b= ID |b= REF ) -> ^( NEW $b) );
    public final AssemblerParser.manipulacaoObjetos_return manipulacaoObjetos() throws RecognitionException {
        AssemblerParser.manipulacaoObjetos_return retval = new AssemblerParser.manipulacaoObjetos_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;
        Token b=null;
        Token REF58=null;
        Token REF60=null;
        Token REF62=null;
        Token REF64=null;
        Token REF66=null;
        Token REF67=null;
        Token REF68=null;
        AssemblerParser.parametrosRetorno_return d =null;

        AssemblerParser.tipo_return tipo59 =null;

        AssemblerParser.tipo_return tipo61 =null;

        AssemblerParser.tipo_return tipo63 =null;

        AssemblerParser.tipo_return tipo65 =null;


        BytecodesAST a_tree=null;
        BytecodesAST b_tree=null;
        BytecodesAST REF58_tree=null;
        BytecodesAST REF60_tree=null;
        BytecodesAST REF62_tree=null;
        BytecodesAST REF64_tree=null;
        BytecodesAST REF66_tree=null;
        BytecodesAST REF67_tree=null;
        BytecodesAST REF68_tree=null;
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_109=new RewriteRuleTokenStream(adaptor,"token 109");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_92=new RewriteRuleTokenStream(adaptor,"token 92");
        RewriteRuleTokenStream stream_108=new RewriteRuleTokenStream(adaptor,"token 108");
        RewriteRuleTokenStream stream_91=new RewriteRuleTokenStream(adaptor,"token 91");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_90=new RewriteRuleTokenStream(adaptor,"token 90");
        RewriteRuleTokenStream stream_104=new RewriteRuleTokenStream(adaptor,"token 104");
        RewriteRuleTokenStream stream_REF=new RewriteRuleTokenStream(adaptor,"token REF");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        RewriteRuleSubtreeStream stream_parametrosRetorno=new RewriteRuleSubtreeStream(adaptor,"rule parametrosRetorno");
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:106:20: (a= 'getfield' REF tipo -> ^( 'getfield' REF tipo ) |a= 'getstatic' REF tipo -> ^( 'getstatic' REF tipo ) |a= 'putfield' REF tipo -> ^( 'putfield' REF tipo ) |a= 'putstatic' REF tipo -> ^( 'putstatic' REF tipo ) |a= 'invokespecial' REF d= parametrosRetorno -> ^( 'invokespecial' REF $d) |a= 'invokestatic' REF d= parametrosRetorno -> ^( 'invokestatic' REF $d) |a= 'invokevirtual' REF d= parametrosRetorno -> ^( 'invokevirtual' REF $d) |a= 'new' (b= ID |b= REF ) -> ^( NEW $b) )
            int alt22=8;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt22=1;
                }
                break;
            case 58:
                {
                alt22=2;
                }
                break;
            case 108:
                {
                alt22=3;
                }
                break;
            case 109:
                {
                alt22=4;
                }
                break;
            case 90:
                {
                alt22=5;
                }
                break;
            case 91:
                {
                alt22=6;
                }
                break;
            case 92:
                {
                alt22=7;
                }
                break;
            case 104:
                {
                alt22=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:106:22: a= 'getfield' REF tipo
                    {
                    a=(Token)match(input,57,FOLLOW_57_in_manipulacaoObjetos991);  
                    stream_57.add(a);


                    REF58=(Token)match(input,REF,FOLLOW_REF_in_manipulacaoObjetos993);  
                    stream_REF.add(REF58);


                    pushFollow(FOLLOW_tipo_in_manipulacaoObjetos995);
                    tipo59=tipo();

                    state._fsp--;

                    stream_tipo.add(tipo59.getTree());

                    // AST REWRITE
                    // elements: REF, tipo, 57
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 106:46: -> ^( 'getfield' REF tipo )
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:106:49: ^( 'getfield' REF tipo )
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        stream_57.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_REF.nextNode()
                        );

                        adaptor.addChild(root_1, stream_tipo.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:107:8: a= 'getstatic' REF tipo
                    {
                    a=(Token)match(input,58,FOLLOW_58_in_manipulacaoObjetos1018);  
                    stream_58.add(a);


                    REF60=(Token)match(input,REF,FOLLOW_REF_in_manipulacaoObjetos1020);  
                    stream_REF.add(REF60);


                    pushFollow(FOLLOW_tipo_in_manipulacaoObjetos1022);
                    tipo61=tipo();

                    state._fsp--;

                    stream_tipo.add(tipo61.getTree());

                    // AST REWRITE
                    // elements: tipo, REF, 58
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 107:33: -> ^( 'getstatic' REF tipo )
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:107:36: ^( 'getstatic' REF tipo )
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        stream_58.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_REF.nextNode()
                        );

                        adaptor.addChild(root_1, stream_tipo.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:108:22: a= 'putfield' REF tipo
                    {
                    a=(Token)match(input,108,FOLLOW_108_in_manipulacaoObjetos1059);  
                    stream_108.add(a);


                    REF62=(Token)match(input,REF,FOLLOW_REF_in_manipulacaoObjetos1061);  
                    stream_REF.add(REF62);


                    pushFollow(FOLLOW_tipo_in_manipulacaoObjetos1063);
                    tipo63=tipo();

                    state._fsp--;

                    stream_tipo.add(tipo63.getTree());

                    // AST REWRITE
                    // elements: tipo, REF, 108
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 108:46: -> ^( 'putfield' REF tipo )
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:108:49: ^( 'putfield' REF tipo )
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        stream_108.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_REF.nextNode()
                        );

                        adaptor.addChild(root_1, stream_tipo.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:109:22: a= 'putstatic' REF tipo
                    {
                    a=(Token)match(input,109,FOLLOW_109_in_manipulacaoObjetos1100);  
                    stream_109.add(a);


                    REF64=(Token)match(input,REF,FOLLOW_REF_in_manipulacaoObjetos1102);  
                    stream_REF.add(REF64);


                    pushFollow(FOLLOW_tipo_in_manipulacaoObjetos1104);
                    tipo65=tipo();

                    state._fsp--;

                    stream_tipo.add(tipo65.getTree());

                    // AST REWRITE
                    // elements: 109, REF, tipo
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 109:47: -> ^( 'putstatic' REF tipo )
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:109:50: ^( 'putstatic' REF tipo )
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        stream_109.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_REF.nextNode()
                        );

                        adaptor.addChild(root_1, stream_tipo.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 5 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:110:22: a= 'invokespecial' REF d= parametrosRetorno
                    {
                    a=(Token)match(input,90,FOLLOW_90_in_manipulacaoObjetos1141);  
                    stream_90.add(a);


                    REF66=(Token)match(input,REF,FOLLOW_REF_in_manipulacaoObjetos1143);  
                    stream_REF.add(REF66);


                    pushFollow(FOLLOW_parametrosRetorno_in_manipulacaoObjetos1149);
                    d=parametrosRetorno();

                    state._fsp--;

                    stream_parametrosRetorno.add(d.getTree());

                    // AST REWRITE
                    // elements: 90, REF, d
                    // token labels: 
                    // rule labels: retval, d
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_d=new RewriteRuleSubtreeStream(adaptor,"rule d",d!=null?d.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 111:23: -> ^( 'invokespecial' REF $d)
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:111:26: ^( 'invokespecial' REF $d)
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        stream_90.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_REF.nextNode()
                        );

                        adaptor.addChild(root_1, stream_d.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:112:22: a= 'invokestatic' REF d= parametrosRetorno
                    {
                    a=(Token)match(input,91,FOLLOW_91_in_manipulacaoObjetos1209);  
                    stream_91.add(a);


                    REF67=(Token)match(input,REF,FOLLOW_REF_in_manipulacaoObjetos1211);  
                    stream_REF.add(REF67);


                    pushFollow(FOLLOW_parametrosRetorno_in_manipulacaoObjetos1217);
                    d=parametrosRetorno();

                    state._fsp--;

                    stream_parametrosRetorno.add(d.getTree());

                    // AST REWRITE
                    // elements: d, 91, REF
                    // token labels: 
                    // rule labels: retval, d
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_d=new RewriteRuleSubtreeStream(adaptor,"rule d",d!=null?d.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 113:23: -> ^( 'invokestatic' REF $d)
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:113:26: ^( 'invokestatic' REF $d)
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        stream_91.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_REF.nextNode()
                        );

                        adaptor.addChild(root_1, stream_d.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 7 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:114:23: a= 'invokevirtual' REF d= parametrosRetorno
                    {
                    a=(Token)match(input,92,FOLLOW_92_in_manipulacaoObjetos1278);  
                    stream_92.add(a);


                    REF68=(Token)match(input,REF,FOLLOW_REF_in_manipulacaoObjetos1280);  
                    stream_REF.add(REF68);


                    pushFollow(FOLLOW_parametrosRetorno_in_manipulacaoObjetos1286);
                    d=parametrosRetorno();

                    state._fsp--;

                    stream_parametrosRetorno.add(d.getTree());

                    // AST REWRITE
                    // elements: 92, d, REF
                    // token labels: 
                    // rule labels: retval, d
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_d=new RewriteRuleSubtreeStream(adaptor,"rule d",d!=null?d.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 115:23: -> ^( 'invokevirtual' REF $d)
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:115:26: ^( 'invokevirtual' REF $d)
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        stream_92.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_REF.nextNode()
                        );

                        adaptor.addChild(root_1, stream_d.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 8 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:116:22: a= 'new' (b= ID |b= REF )
                    {
                    a=(Token)match(input,104,FOLLOW_104_in_manipulacaoObjetos1346);  
                    stream_104.add(a);


                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:116:32: (b= ID |b= REF )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==ID) ) {
                        alt21=1;
                    }
                    else if ( (LA21_0==REF) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 0, input);

                        throw nvae;

                    }
                    switch (alt21) {
                        case 1 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:116:33: b= ID
                            {
                            b=(Token)match(input,ID,FOLLOW_ID_in_manipulacaoObjetos1353);  
                            stream_ID.add(b);


                            }
                            break;
                        case 2 :
                            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:116:42: b= REF
                            {
                            b=(Token)match(input,REF,FOLLOW_REF_in_manipulacaoObjetos1361);  
                            stream_REF.add(b);


                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: b
                    // token labels: b
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (BytecodesAST)adaptor.nil();
                    // 116:51: -> ^( NEW $b)
                    {
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:116:54: ^( NEW $b)
                        {
                        BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                        root_1 = (BytecodesAST)adaptor.becomeRoot(
                        (BytecodesAST)adaptor.create(NEW, "NEW")
                        , root_1);

                        adaptor.addChild(root_1, stream_b.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "manipulacaoObjetos"


    public static class tipo_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tipo"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:120:1: tipo : ( INT | VOID | TIPO_REF );
    public final AssemblerParser.tipo_return tipo() throws RecognitionException {
        AssemblerParser.tipo_return retval = new AssemblerParser.tipo_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token set69=null;

        BytecodesAST set69_tree=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:120:6: ( INT | VOID | TIPO_REF )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:
            {
            root_0 = (BytecodesAST)adaptor.nil();


            set69=(Token)input.LT(1);

            if ( input.LA(1)==INT||(input.LA(1) >= TIPO_REF && input.LA(1) <= VOID) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (BytecodesAST)adaptor.create(set69)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tipo"


    public static class aritmetica_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aritmetica"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:122:1: aritmetica : (a= 'iadd' |a= 'isub' |a= 'imul' |a= 'idiv' |a= 'irem' |a= 'iinc' |a= 'ineg' ) -> ^( ARITMETICA $a) ;
    public final AssemblerParser.aritmetica_return aritmetica() throws RecognitionException {
        AssemblerParser.aritmetica_return retval = new AssemblerParser.aritmetica_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;

        BytecodesAST a_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleTokenStream stream_94=new RewriteRuleTokenStream(adaptor,"token 94");
        RewriteRuleTokenStream stream_82=new RewriteRuleTokenStream(adaptor,"token 82");
        RewriteRuleTokenStream stream_60=new RewriteRuleTokenStream(adaptor,"token 60");
        RewriteRuleTokenStream stream_101=new RewriteRuleTokenStream(adaptor,"token 101");
        RewriteRuleTokenStream stream_88=new RewriteRuleTokenStream(adaptor,"token 88");
        RewriteRuleTokenStream stream_89=new RewriteRuleTokenStream(adaptor,"token 89");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:122:12: ( (a= 'iadd' |a= 'isub' |a= 'imul' |a= 'idiv' |a= 'irem' |a= 'iinc' |a= 'ineg' ) -> ^( ARITMETICA $a) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:122:14: (a= 'iadd' |a= 'isub' |a= 'imul' |a= 'idiv' |a= 'irem' |a= 'iinc' |a= 'ineg' )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:122:14: (a= 'iadd' |a= 'isub' |a= 'imul' |a= 'idiv' |a= 'irem' |a= 'iinc' |a= 'ineg' )
            int alt23=7;
            switch ( input.LA(1) ) {
            case 60:
                {
                alt23=1;
                }
                break;
            case 101:
                {
                alt23=2;
                }
                break;
            case 88:
                {
                alt23=3;
                }
                break;
            case 69:
                {
                alt23=4;
                }
                break;
            case 94:
                {
                alt23=5;
                }
                break;
            case 82:
                {
                alt23=6;
                }
                break;
            case 89:
                {
                alt23=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }

            switch (alt23) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:122:16: a= 'iadd'
                    {
                    a=(Token)match(input,60,FOLLOW_60_in_aritmetica1440);  
                    stream_60.add(a);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:123:19: a= 'isub'
                    {
                    a=(Token)match(input,101,FOLLOW_101_in_aritmetica1464);  
                    stream_101.add(a);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:124:19: a= 'imul'
                    {
                    a=(Token)match(input,88,FOLLOW_88_in_aritmetica1488);  
                    stream_88.add(a);


                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:125:19: a= 'idiv'
                    {
                    a=(Token)match(input,69,FOLLOW_69_in_aritmetica1512);  
                    stream_69.add(a);


                    }
                    break;
                case 5 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:126:19: a= 'irem'
                    {
                    a=(Token)match(input,94,FOLLOW_94_in_aritmetica1536);  
                    stream_94.add(a);


                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:127:19: a= 'iinc'
                    {
                    a=(Token)match(input,82,FOLLOW_82_in_aritmetica1560);  
                    stream_82.add(a);


                    }
                    break;
                case 7 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:128:19: a= 'ineg'
                    {
                    a=(Token)match(input,89,FOLLOW_89_in_aritmetica1584);  
                    stream_89.add(a);


                    }
                    break;

            }


            // AST REWRITE
            // elements: a
            // token labels: a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 130:14: -> ^( ARITMETICA $a)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:130:17: ^( ARITMETICA $a)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(ARITMETICA, "ARITMETICA")
                , root_1);

                adaptor.addChild(root_1, stream_a.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "aritmetica"


    public static class load_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "load"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:133:1: load : (a= 'iconst_m1' |a= 'iconst_0' |a= 'iconst_1' |a= 'iconst_2' |a= 'iconst_3' |a= 'iconst_4' |a= 'iconst_5' |a= 'aconst_null' |a= 'iload_0' |a= 'iload_1' |a= 'iload_2' |a= 'iload_3' |a= 'aload_0' |a= 'aload_1' |a= 'aload_2' |a= 'aload_3' ) -> ^( LOAD $a) ;
    public final AssemblerParser.load_return load() throws RecognitionException {
        AssemblerParser.load_return retval = new AssemblerParser.load_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;

        BytecodesAST a_tree=null;
        RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
        RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
        RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
        RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:133:6: ( (a= 'iconst_m1' |a= 'iconst_0' |a= 'iconst_1' |a= 'iconst_2' |a= 'iconst_3' |a= 'iconst_4' |a= 'iconst_5' |a= 'aconst_null' |a= 'iload_0' |a= 'iload_1' |a= 'iload_2' |a= 'iload_3' |a= 'aload_0' |a= 'aload_1' |a= 'aload_2' |a= 'aload_3' ) -> ^( LOAD $a) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:133:8: (a= 'iconst_m1' |a= 'iconst_0' |a= 'iconst_1' |a= 'iconst_2' |a= 'iconst_3' |a= 'iconst_4' |a= 'iconst_5' |a= 'aconst_null' |a= 'iload_0' |a= 'iload_1' |a= 'iload_2' |a= 'iload_3' |a= 'aload_0' |a= 'aload_1' |a= 'aload_2' |a= 'aload_3' )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:133:8: (a= 'iconst_m1' |a= 'iconst_0' |a= 'iconst_1' |a= 'iconst_2' |a= 'iconst_3' |a= 'iconst_4' |a= 'iconst_5' |a= 'aconst_null' |a= 'iload_0' |a= 'iload_1' |a= 'iload_2' |a= 'iload_3' |a= 'aload_0' |a= 'aload_1' |a= 'aload_2' |a= 'aload_3' )
            int alt24=16;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt24=1;
                }
                break;
            case 62:
                {
                alt24=2;
                }
                break;
            case 63:
                {
                alt24=3;
                }
                break;
            case 64:
                {
                alt24=4;
                }
                break;
            case 65:
                {
                alt24=5;
                }
                break;
            case 66:
                {
                alt24=6;
                }
                break;
            case 67:
                {
                alt24=7;
                }
                break;
            case 44:
                {
                alt24=8;
                }
                break;
            case 84:
                {
                alt24=9;
                }
                break;
            case 85:
                {
                alt24=10;
                }
                break;
            case 86:
                {
                alt24=11;
                }
                break;
            case 87:
                {
                alt24=12;
                }
                break;
            case 46:
                {
                alt24=13;
                }
                break;
            case 47:
                {
                alt24=14;
                }
                break;
            case 48:
                {
                alt24=15;
                }
                break;
            case 49:
                {
                alt24=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:133:10: a= 'iconst_m1'
                    {
                    a=(Token)match(input,68,FOLLOW_68_in_load1658);  
                    stream_68.add(a);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:134:13: a= 'iconst_0'
                    {
                    a=(Token)match(input,62,FOLLOW_62_in_load1676);  
                    stream_62.add(a);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:135:13: a= 'iconst_1'
                    {
                    a=(Token)match(input,63,FOLLOW_63_in_load1694);  
                    stream_63.add(a);


                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:136:13: a= 'iconst_2'
                    {
                    a=(Token)match(input,64,FOLLOW_64_in_load1712);  
                    stream_64.add(a);


                    }
                    break;
                case 5 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:137:13: a= 'iconst_3'
                    {
                    a=(Token)match(input,65,FOLLOW_65_in_load1730);  
                    stream_65.add(a);


                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:138:13: a= 'iconst_4'
                    {
                    a=(Token)match(input,66,FOLLOW_66_in_load1748);  
                    stream_66.add(a);


                    }
                    break;
                case 7 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:139:13: a= 'iconst_5'
                    {
                    a=(Token)match(input,67,FOLLOW_67_in_load1766);  
                    stream_67.add(a);


                    }
                    break;
                case 8 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:140:13: a= 'aconst_null'
                    {
                    a=(Token)match(input,44,FOLLOW_44_in_load1784);  
                    stream_44.add(a);


                    }
                    break;
                case 9 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:141:13: a= 'iload_0'
                    {
                    a=(Token)match(input,84,FOLLOW_84_in_load1802);  
                    stream_84.add(a);


                    }
                    break;
                case 10 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:142:13: a= 'iload_1'
                    {
                    a=(Token)match(input,85,FOLLOW_85_in_load1820);  
                    stream_85.add(a);


                    }
                    break;
                case 11 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:143:13: a= 'iload_2'
                    {
                    a=(Token)match(input,86,FOLLOW_86_in_load1838);  
                    stream_86.add(a);


                    }
                    break;
                case 12 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:144:13: a= 'iload_3'
                    {
                    a=(Token)match(input,87,FOLLOW_87_in_load1856);  
                    stream_87.add(a);


                    }
                    break;
                case 13 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:145:13: a= 'aload_0'
                    {
                    a=(Token)match(input,46,FOLLOW_46_in_load1874);  
                    stream_46.add(a);


                    }
                    break;
                case 14 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:146:13: a= 'aload_1'
                    {
                    a=(Token)match(input,47,FOLLOW_47_in_load1892);  
                    stream_47.add(a);


                    }
                    break;
                case 15 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:147:13: a= 'aload_2'
                    {
                    a=(Token)match(input,48,FOLLOW_48_in_load1910);  
                    stream_48.add(a);


                    }
                    break;
                case 16 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:148:13: a= 'aload_3'
                    {
                    a=(Token)match(input,49,FOLLOW_49_in_load1928);  
                    stream_49.add(a);


                    }
                    break;

            }


            // AST REWRITE
            // elements: a
            // token labels: a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 150:8: -> ^( LOAD $a)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:150:11: ^( LOAD $a)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(LOAD, "LOAD")
                , root_1);

                adaptor.addChild(root_1, stream_a.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "load"


    public static class loadint_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "loadint"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:153:1: loadint : (a= 'iload' b= INTEIRO |a= 'ldc' b= INTEIRO |a= 'aload' b= INTEIRO ) -> ^( LOAD $a $b) ;
    public final AssemblerParser.loadint_return loadint() throws RecognitionException {
        AssemblerParser.loadint_return retval = new AssemblerParser.loadint_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;
        Token b=null;

        BytecodesAST a_tree=null;
        BytecodesAST b_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_83=new RewriteRuleTokenStream(adaptor,"token 83");
        RewriteRuleTokenStream stream_INTEIRO=new RewriteRuleTokenStream(adaptor,"token INTEIRO");
        RewriteRuleTokenStream stream_103=new RewriteRuleTokenStream(adaptor,"token 103");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:153:9: ( (a= 'iload' b= INTEIRO |a= 'ldc' b= INTEIRO |a= 'aload' b= INTEIRO ) -> ^( LOAD $a $b) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:153:11: (a= 'iload' b= INTEIRO |a= 'ldc' b= INTEIRO |a= 'aload' b= INTEIRO )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:153:11: (a= 'iload' b= INTEIRO |a= 'ldc' b= INTEIRO |a= 'aload' b= INTEIRO )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 83:
                {
                alt25=1;
                }
                break;
            case 103:
                {
                alt25=2;
                }
                break;
            case 45:
                {
                alt25=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:153:13: a= 'iload' b= INTEIRO
                    {
                    a=(Token)match(input,83,FOLLOW_83_in_loadint1978);  
                    stream_83.add(a);


                    b=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_loadint1984);  
                    stream_INTEIRO.add(b);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:154:15: a= 'ldc' b= INTEIRO
                    {
                    a=(Token)match(input,103,FOLLOW_103_in_loadint2004);  
                    stream_103.add(a);


                    b=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_loadint2010);  
                    stream_INTEIRO.add(b);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:155:15: a= 'aload' b= INTEIRO
                    {
                    a=(Token)match(input,45,FOLLOW_45_in_loadint2030);  
                    stream_45.add(a);


                    b=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_loadint2036);  
                    stream_INTEIRO.add(b);


                    }
                    break;

            }


            // AST REWRITE
            // elements: a, b
            // token labels: b, a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 157:11: -> ^( LOAD $a $b)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:157:14: ^( LOAD $a $b)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(LOAD, "LOAD")
                , root_1);

                adaptor.addChild(root_1, stream_a.nextNode());

                adaptor.addChild(root_1, stream_b.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "loadint"


    public static class store_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "store"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:160:1: store : (a= 'istore_0' |a= 'istore_1' |a= 'istore_2' |a= 'istore_3' |a= 'astore_0' |a= 'astore_1' |a= 'astore_2' |a= 'astore_3' ) -> ^( STORE $a) ;
    public final AssemblerParser.store_return store() throws RecognitionException {
        AssemblerParser.store_return retval = new AssemblerParser.store_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;

        BytecodesAST a_tree=null;
        RewriteRuleTokenStream stream_98=new RewriteRuleTokenStream(adaptor,"token 98");
        RewriteRuleTokenStream stream_97=new RewriteRuleTokenStream(adaptor,"token 97");
        RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
        RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
        RewriteRuleTokenStream stream_99=new RewriteRuleTokenStream(adaptor,"token 99");
        RewriteRuleTokenStream stream_100=new RewriteRuleTokenStream(adaptor,"token 100");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:160:7: ( (a= 'istore_0' |a= 'istore_1' |a= 'istore_2' |a= 'istore_3' |a= 'astore_0' |a= 'astore_1' |a= 'astore_2' |a= 'astore_3' ) -> ^( STORE $a) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:160:9: (a= 'istore_0' |a= 'istore_1' |a= 'istore_2' |a= 'istore_3' |a= 'astore_0' |a= 'astore_1' |a= 'astore_2' |a= 'astore_3' )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:160:9: (a= 'istore_0' |a= 'istore_1' |a= 'istore_2' |a= 'istore_3' |a= 'astore_0' |a= 'astore_1' |a= 'astore_2' |a= 'astore_3' )
            int alt26=8;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt26=1;
                }
                break;
            case 98:
                {
                alt26=2;
                }
                break;
            case 99:
                {
                alt26=3;
                }
                break;
            case 100:
                {
                alt26=4;
                }
                break;
            case 52:
                {
                alt26=5;
                }
                break;
            case 53:
                {
                alt26=6;
                }
                break;
            case 54:
                {
                alt26=7;
                }
                break;
            case 55:
                {
                alt26=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:160:11: a= 'istore_0'
                    {
                    a=(Token)match(input,97,FOLLOW_97_in_store2098);  
                    stream_97.add(a);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:161:13: a= 'istore_1'
                    {
                    a=(Token)match(input,98,FOLLOW_98_in_store2116);  
                    stream_98.add(a);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:162:13: a= 'istore_2'
                    {
                    a=(Token)match(input,99,FOLLOW_99_in_store2134);  
                    stream_99.add(a);


                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:163:13: a= 'istore_3'
                    {
                    a=(Token)match(input,100,FOLLOW_100_in_store2152);  
                    stream_100.add(a);


                    }
                    break;
                case 5 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:164:13: a= 'astore_0'
                    {
                    a=(Token)match(input,52,FOLLOW_52_in_store2170);  
                    stream_52.add(a);


                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:165:13: a= 'astore_1'
                    {
                    a=(Token)match(input,53,FOLLOW_53_in_store2188);  
                    stream_53.add(a);


                    }
                    break;
                case 7 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:166:13: a= 'astore_2'
                    {
                    a=(Token)match(input,54,FOLLOW_54_in_store2206);  
                    stream_54.add(a);


                    }
                    break;
                case 8 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:167:13: a= 'astore_3'
                    {
                    a=(Token)match(input,55,FOLLOW_55_in_store2224);  
                    stream_55.add(a);


                    }
                    break;

            }


            // AST REWRITE
            // elements: a
            // token labels: a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 169:9: -> ^( STORE $a)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:169:12: ^( STORE $a)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(STORE, "STORE")
                , root_1);

                adaptor.addChild(root_1, stream_a.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "store"


    public static class storeint_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "storeint"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:172:1: storeint : (a= 'istore' b= INTEIRO |a= 'astore' b= INTEIRO ) -> ^( STORE $a $b) ;
    public final AssemblerParser.storeint_return storeint() throws RecognitionException {
        AssemblerParser.storeint_return retval = new AssemblerParser.storeint_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;
        Token b=null;

        BytecodesAST a_tree=null;
        BytecodesAST b_tree=null;
        RewriteRuleTokenStream stream_96=new RewriteRuleTokenStream(adaptor,"token 96");
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
        RewriteRuleTokenStream stream_INTEIRO=new RewriteRuleTokenStream(adaptor,"token INTEIRO");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:172:10: ( (a= 'istore' b= INTEIRO |a= 'astore' b= INTEIRO ) -> ^( STORE $a $b) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:172:12: (a= 'istore' b= INTEIRO |a= 'astore' b= INTEIRO )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:172:12: (a= 'istore' b= INTEIRO |a= 'astore' b= INTEIRO )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==96) ) {
                alt27=1;
            }
            else if ( (LA27_0==51) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:172:14: a= 'istore' b= INTEIRO
                    {
                    a=(Token)match(input,96,FOLLOW_96_in_storeint2278);  
                    stream_96.add(a);


                    b=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_storeint2284);  
                    stream_INTEIRO.add(b);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:173:16: a= 'astore' b= INTEIRO
                    {
                    a=(Token)match(input,51,FOLLOW_51_in_storeint2305);  
                    stream_51.add(a);


                    b=(Token)match(input,INTEIRO,FOLLOW_INTEIRO_in_storeint2311);  
                    stream_INTEIRO.add(b);


                    }
                    break;

            }


            // AST REWRITE
            // elements: b, a
            // token labels: b, a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 175:12: -> ^( STORE $a $b)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:175:15: ^( STORE $a $b)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(STORE, "STORE")
                , root_1);

                adaptor.addChild(root_1, stream_a.nextNode());

                adaptor.addChild(root_1, stream_b.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "storeint"


    public static class logica_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "logica"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:178:1: logica : (a= 'iand' |a= 'ior' |a= 'ixor' ) -> ^( LOGICA $a) ;
    public final AssemblerParser.logica_return logica() throws RecognitionException {
        AssemblerParser.logica_return retval = new AssemblerParser.logica_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;

        BytecodesAST a_tree=null;
        RewriteRuleTokenStream stream_93=new RewriteRuleTokenStream(adaptor,"token 93");
        RewriteRuleTokenStream stream_102=new RewriteRuleTokenStream(adaptor,"token 102");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:178:8: ( (a= 'iand' |a= 'ior' |a= 'ixor' ) -> ^( LOGICA $a) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:178:10: (a= 'iand' |a= 'ior' |a= 'ixor' )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:178:10: (a= 'iand' |a= 'ior' |a= 'ixor' )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt28=1;
                }
                break;
            case 93:
                {
                alt28=2;
                }
                break;
            case 102:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:178:12: a= 'iand'
                    {
                    a=(Token)match(input,61,FOLLOW_61_in_logica2371);  
                    stream_61.add(a);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:179:14: a= 'ior'
                    {
                    a=(Token)match(input,93,FOLLOW_93_in_logica2390);  
                    stream_93.add(a);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:180:14: a= 'ixor'
                    {
                    a=(Token)match(input,102,FOLLOW_102_in_logica2409);  
                    stream_102.add(a);


                    }
                    break;

            }


            // AST REWRITE
            // elements: a
            // token labels: a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 182:10: -> ^( LOGICA $a)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:182:13: ^( LOGICA $a)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(LOGICA, "LOGICA")
                , root_1);

                adaptor.addChild(root_1, stream_a.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "logica"


    public static class desvio_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "desvio"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:185:1: desvio : (a= 'ifeq' b= ID |a= 'ifne' b= ID |a= 'iflt' b= ID |a= 'ifge' b= ID |a= 'ifgt' b= ID |a= 'ifle' b= ID |a= 'if_icmpeq' b= ID |a= 'if_icmpne' b= ID |a= 'if_icmplt' b= ID |a= 'if_icmpge' b= ID |a= 'if_icmpgt' b= ID |a= 'if_icmple' b= ID |a= 'goto' b= ID ) -> ^( DESVIO $a $b) ;
    public final AssemblerParser.desvio_return desvio() throws RecognitionException {
        AssemblerParser.desvio_return retval = new AssemblerParser.desvio_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;
        Token b=null;

        BytecodesAST a_tree=null;
        BytecodesAST b_tree=null;
        RewriteRuleTokenStream stream_79=new RewriteRuleTokenStream(adaptor,"token 79");
        RewriteRuleTokenStream stream_78=new RewriteRuleTokenStream(adaptor,"token 78");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_81=new RewriteRuleTokenStream(adaptor,"token 81");
        RewriteRuleTokenStream stream_73=new RewriteRuleTokenStream(adaptor,"token 73");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleTokenStream stream_75=new RewriteRuleTokenStream(adaptor,"token 75");
        RewriteRuleTokenStream stream_76=new RewriteRuleTokenStream(adaptor,"token 76");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:185:8: ( (a= 'ifeq' b= ID |a= 'ifne' b= ID |a= 'iflt' b= ID |a= 'ifge' b= ID |a= 'ifgt' b= ID |a= 'ifle' b= ID |a= 'if_icmpeq' b= ID |a= 'if_icmpne' b= ID |a= 'if_icmplt' b= ID |a= 'if_icmpge' b= ID |a= 'if_icmpgt' b= ID |a= 'if_icmple' b= ID |a= 'goto' b= ID ) -> ^( DESVIO $a $b) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:185:10: (a= 'ifeq' b= ID |a= 'ifne' b= ID |a= 'iflt' b= ID |a= 'ifge' b= ID |a= 'ifgt' b= ID |a= 'ifle' b= ID |a= 'if_icmpeq' b= ID |a= 'if_icmpne' b= ID |a= 'if_icmplt' b= ID |a= 'if_icmpge' b= ID |a= 'if_icmpgt' b= ID |a= 'if_icmple' b= ID |a= 'goto' b= ID )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:185:10: (a= 'ifeq' b= ID |a= 'ifne' b= ID |a= 'iflt' b= ID |a= 'ifge' b= ID |a= 'ifgt' b= ID |a= 'ifle' b= ID |a= 'if_icmpeq' b= ID |a= 'if_icmpne' b= ID |a= 'if_icmplt' b= ID |a= 'if_icmpge' b= ID |a= 'if_icmpgt' b= ID |a= 'if_icmple' b= ID |a= 'goto' b= ID )
            int alt29=13;
            switch ( input.LA(1) ) {
            case 76:
                {
                alt29=1;
                }
                break;
            case 81:
                {
                alt29=2;
                }
                break;
            case 80:
                {
                alt29=3;
                }
                break;
            case 77:
                {
                alt29=4;
                }
                break;
            case 78:
                {
                alt29=5;
                }
                break;
            case 79:
                {
                alt29=6;
                }
                break;
            case 70:
                {
                alt29=7;
                }
                break;
            case 75:
                {
                alt29=8;
                }
                break;
            case 74:
                {
                alt29=9;
                }
                break;
            case 71:
                {
                alt29=10;
                }
                break;
            case 72:
                {
                alt29=11;
                }
                break;
            case 73:
                {
                alt29=12;
                }
                break;
            case 59:
                {
                alt29=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }

            switch (alt29) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:185:12: a= 'ifeq' b= ID
                    {
                    a=(Token)match(input,76,FOLLOW_76_in_desvio2460);  
                    stream_76.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2466);  
                    stream_ID.add(b);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:186:14: a= 'ifne' b= ID
                    {
                    a=(Token)match(input,81,FOLLOW_81_in_desvio2485);  
                    stream_81.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2491);  
                    stream_ID.add(b);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:187:14: a= 'iflt' b= ID
                    {
                    a=(Token)match(input,80,FOLLOW_80_in_desvio2510);  
                    stream_80.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2516);  
                    stream_ID.add(b);


                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:188:14: a= 'ifge' b= ID
                    {
                    a=(Token)match(input,77,FOLLOW_77_in_desvio2535);  
                    stream_77.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2541);  
                    stream_ID.add(b);


                    }
                    break;
                case 5 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:189:14: a= 'ifgt' b= ID
                    {
                    a=(Token)match(input,78,FOLLOW_78_in_desvio2560);  
                    stream_78.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2566);  
                    stream_ID.add(b);


                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:190:14: a= 'ifle' b= ID
                    {
                    a=(Token)match(input,79,FOLLOW_79_in_desvio2585);  
                    stream_79.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2591);  
                    stream_ID.add(b);


                    }
                    break;
                case 7 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:191:14: a= 'if_icmpeq' b= ID
                    {
                    a=(Token)match(input,70,FOLLOW_70_in_desvio2610);  
                    stream_70.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2616);  
                    stream_ID.add(b);


                    }
                    break;
                case 8 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:192:14: a= 'if_icmpne' b= ID
                    {
                    a=(Token)match(input,75,FOLLOW_75_in_desvio2635);  
                    stream_75.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2641);  
                    stream_ID.add(b);


                    }
                    break;
                case 9 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:193:14: a= 'if_icmplt' b= ID
                    {
                    a=(Token)match(input,74,FOLLOW_74_in_desvio2660);  
                    stream_74.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2666);  
                    stream_ID.add(b);


                    }
                    break;
                case 10 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:194:14: a= 'if_icmpge' b= ID
                    {
                    a=(Token)match(input,71,FOLLOW_71_in_desvio2685);  
                    stream_71.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2691);  
                    stream_ID.add(b);


                    }
                    break;
                case 11 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:195:14: a= 'if_icmpgt' b= ID
                    {
                    a=(Token)match(input,72,FOLLOW_72_in_desvio2710);  
                    stream_72.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2716);  
                    stream_ID.add(b);


                    }
                    break;
                case 12 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:196:14: a= 'if_icmple' b= ID
                    {
                    a=(Token)match(input,73,FOLLOW_73_in_desvio2735);  
                    stream_73.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2741);  
                    stream_ID.add(b);


                    }
                    break;
                case 13 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:197:14: a= 'goto' b= ID
                    {
                    a=(Token)match(input,59,FOLLOW_59_in_desvio2760);  
                    stream_59.add(a);


                    b=(Token)match(input,ID,FOLLOW_ID_in_desvio2766);  
                    stream_ID.add(b);


                    }
                    break;

            }


            // AST REWRITE
            // elements: b, a
            // token labels: b, a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_b=new RewriteRuleTokenStream(adaptor,"token b",b);
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 199:10: -> ^( DESVIO $a $b)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:199:13: ^( DESVIO $a $b)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(DESVIO, "DESVIO")
                , root_1);

                adaptor.addChild(root_1, stream_a.nextNode());

                adaptor.addChild(root_1, stream_b.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "desvio"


    public static class pilha_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "pilha"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:202:1: pilha : (a= 'pop' |a= 'pop2' |a= 'dup' ) -> ^( PILHA $a) ;
    public final AssemblerParser.pilha_return pilha() throws RecognitionException {
        AssemblerParser.pilha_return retval = new AssemblerParser.pilha_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token a=null;

        BytecodesAST a_tree=null;
        RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
        RewriteRuleTokenStream stream_107=new RewriteRuleTokenStream(adaptor,"token 107");
        RewriteRuleTokenStream stream_106=new RewriteRuleTokenStream(adaptor,"token 106");

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:202:7: ( (a= 'pop' |a= 'pop2' |a= 'dup' ) -> ^( PILHA $a) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:202:9: (a= 'pop' |a= 'pop2' |a= 'dup' )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:202:9: (a= 'pop' |a= 'pop2' |a= 'dup' )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 106:
                {
                alt30=1;
                }
                break;
            case 107:
                {
                alt30=2;
                }
                break;
            case 56:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }

            switch (alt30) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:202:11: a= 'pop'
                    {
                    a=(Token)match(input,106,FOLLOW_106_in_pilha2827);  
                    stream_106.add(a);


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:203:13: a= 'pop2'
                    {
                    a=(Token)match(input,107,FOLLOW_107_in_pilha2845);  
                    stream_107.add(a);


                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:204:13: a= 'dup'
                    {
                    a=(Token)match(input,56,FOLLOW_56_in_pilha2863);  
                    stream_56.add(a);


                    }
                    break;

            }


            // AST REWRITE
            // elements: a
            // token labels: a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 206:9: -> ^( PILHA $a)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:206:12: ^( PILHA $a)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(PILHA, "PILHA")
                , root_1);

                adaptor.addChild(root_1, stream_a.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "pilha"


    public static class parametrosRetorno_return extends ParserRuleReturnScope {
        BytecodesAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parametrosRetorno"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:209:1: parametrosRetorno : ( parametros | '(' parametros ')' ) tip= tipo -> ^( METHOD_CALL parametros $tip) ;
    public final AssemblerParser.parametrosRetorno_return parametrosRetorno() throws RecognitionException {
        AssemblerParser.parametrosRetorno_return retval = new AssemblerParser.parametrosRetorno_return();
        retval.start = input.LT(1);


        BytecodesAST root_0 = null;

        Token char_literal71=null;
        Token char_literal73=null;
        AssemblerParser.tipo_return tip =null;

        AssemblerParser.parametros_return parametros70 =null;

        AssemblerParser.parametros_return parametros72 =null;


        BytecodesAST char_literal71_tree=null;
        BytecodesAST char_literal73_tree=null;
        RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
        RewriteRuleSubtreeStream stream_parametros=new RewriteRuleSubtreeStream(adaptor,"rule parametros");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:210:6: ( ( parametros | '(' parametros ')' ) tip= tipo -> ^( METHOD_CALL parametros $tip) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:210:10: ( parametros | '(' parametros ')' ) tip= tipo
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:210:10: ( parametros | '(' parametros ')' )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==INT||LA31_0==TIPO_REF||LA31_0==34) ) {
                alt31=1;
            }
            else if ( (LA31_0==33) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;

            }
            switch (alt31) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:210:11: parametros
                    {
                    pushFollow(FOLLOW_parametros_in_parametrosRetorno2918);
                    parametros70=parametros();

                    state._fsp--;

                    stream_parametros.add(parametros70.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:210:24: '(' parametros ')'
                    {
                    char_literal71=(Token)match(input,33,FOLLOW_33_in_parametrosRetorno2922);  
                    stream_33.add(char_literal71);


                    pushFollow(FOLLOW_parametros_in_parametrosRetorno2924);
                    parametros72=parametros();

                    state._fsp--;

                    stream_parametros.add(parametros72.getTree());

                    char_literal73=(Token)match(input,35,FOLLOW_35_in_parametrosRetorno2926);  
                    stream_35.add(char_literal73);


                    }
                    break;

            }


            pushFollow(FOLLOW_tipo_in_parametrosRetorno2934);
            tip=tipo();

            state._fsp--;

            stream_tipo.add(tip.getTree());

            // AST REWRITE
            // elements: parametros, tip
            // token labels: 
            // rule labels: retval, tip
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_tip=new RewriteRuleSubtreeStream(adaptor,"rule tip",tip!=null?tip.tree:null);

            root_0 = (BytecodesAST)adaptor.nil();
            // 211:12: -> ^( METHOD_CALL parametros $tip)
            {
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Assembler.g:211:15: ^( METHOD_CALL parametros $tip)
                {
                BytecodesAST root_1 = (BytecodesAST)adaptor.nil();
                root_1 = (BytecodesAST)adaptor.becomeRoot(
                (BytecodesAST)adaptor.create(METHOD_CALL, "METHOD_CALL")
                , root_1);

                adaptor.addChild(root_1, stream_parametros.nextTree());

                adaptor.addChild(root_1, stream_tip.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (BytecodesAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (BytecodesAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parametrosRetorno"

    // Delegated rules


 

    public static final BitSet FOLLOW_instrucao_in_programa152 = new BitSet(new long[]{0xFFFFF01000800802L,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_operacao_in_instrucao180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definicaoClasse_in_instrucao194 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_instrucao197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_label_in_operacao219 = new BitSet(new long[]{0xFFFFF00000800000L,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_comando_in_operacao221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comando_in_operacao225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_label247 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_43_in_label249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_manipulacaoObjetos_in_comando267 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_aritmetica_in_comando285 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_load_in_comando303 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_loadint_in_comando321 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_store_in_comando339 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_storeint_in_comando357 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_desvio_in_comando375 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_logica_in_comando393 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_pilha_in_comando411 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_retorno_in_comando429 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_105_in_comando447 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NEWLINE_in_comando463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_definicaoClasse486 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_definicaoClasse488 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NEWLINE_in_definicaoClasse490 = new BitSet(new long[]{0x0000068000000000L});
    public static final BitSet FOLLOW_superClasse_in_definicaoClasse493 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NEWLINE_in_definicaoClasse495 = new BitSet(new long[]{0x0000028000000000L});
    public static final BitSet FOLLOW_membroClasse_in_definicaoClasse500 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NEWLINE_in_definicaoClasse502 = new BitSet(new long[]{0x0000028000000002L});
    public static final BitSet FOLLOW_42_in_superClasse563 = new BitSet(new long[]{0x0000000008000800L});
    public static final BitSet FOLLOW_ID_in_superClasse570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REF_in_superClasse578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_membroClasse600 = new BitSet(new long[]{0x0000000000000800L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_membroClasse606 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_membroClasse609 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_tipo_in_membroClasse611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_membroClasse633 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_INIT_in_membroClasse635 = new BitSet(new long[]{0x0000000640002000L});
    public static final BitSet FOLLOW_parametros_in_membroClasse638 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_33_in_membroClasse642 = new BitSet(new long[]{0x0000000440002000L});
    public static final BitSet FOLLOW_parametros_in_membroClasse644 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_membroClasse646 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_tipo_in_membroClasse653 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NEWLINE_in_membroClasse655 = new BitSet(new long[]{0xFFFFF14000800800L,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_limite_in_membroClasse658 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NEWLINE_in_membroClasse660 = new BitSet(new long[]{0xFFFFF04000800800L,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_operacao_in_membroClasse664 = new BitSet(new long[]{0xFFFFF04000800800L,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_38_in_membroClasse667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_membroClasse699 = new BitSet(new long[]{0x0000000000000800L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_membroClasse701 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_membroClasse704 = new BitSet(new long[]{0x0000000640002000L});
    public static final BitSet FOLLOW_parametros_in_membroClasse707 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_33_in_membroClasse711 = new BitSet(new long[]{0x0000000440002000L});
    public static final BitSet FOLLOW_parametros_in_membroClasse713 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_membroClasse715 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_tipo_in_membroClasse722 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NEWLINE_in_membroClasse724 = new BitSet(new long[]{0xFFFFF14000800800L,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_limite_in_membroClasse727 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_NEWLINE_in_membroClasse729 = new BitSet(new long[]{0xFFFFF04000800800L,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_operacao_in_membroClasse733 = new BitSet(new long[]{0xFFFFF04000800800L,0x00007FFFFFFFFFFFL});
    public static final BitSet FOLLOW_38_in_membroClasse736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_limite785 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEIRO_in_limite787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_parametros809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_parametros828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TIPO_REF_in_parametros836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_retorno876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_retorno894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_110_in_retorno912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_manipulacaoObjetos991 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_REF_in_manipulacaoObjetos993 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_tipo_in_manipulacaoObjetos995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_manipulacaoObjetos1018 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_REF_in_manipulacaoObjetos1020 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_tipo_in_manipulacaoObjetos1022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_108_in_manipulacaoObjetos1059 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_REF_in_manipulacaoObjetos1061 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_tipo_in_manipulacaoObjetos1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_109_in_manipulacaoObjetos1100 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_REF_in_manipulacaoObjetos1102 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_tipo_in_manipulacaoObjetos1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_manipulacaoObjetos1141 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_REF_in_manipulacaoObjetos1143 = new BitSet(new long[]{0x0000000640002000L});
    public static final BitSet FOLLOW_parametrosRetorno_in_manipulacaoObjetos1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_91_in_manipulacaoObjetos1209 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_REF_in_manipulacaoObjetos1211 = new BitSet(new long[]{0x0000000640002000L});
    public static final BitSet FOLLOW_parametrosRetorno_in_manipulacaoObjetos1217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_92_in_manipulacaoObjetos1278 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_REF_in_manipulacaoObjetos1280 = new BitSet(new long[]{0x0000000640002000L});
    public static final BitSet FOLLOW_parametrosRetorno_in_manipulacaoObjetos1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_104_in_manipulacaoObjetos1346 = new BitSet(new long[]{0x0000000008000800L});
    public static final BitSet FOLLOW_ID_in_manipulacaoObjetos1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REF_in_manipulacaoObjetos1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_aritmetica1440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_101_in_aritmetica1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_aritmetica1488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_aritmetica1512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_aritmetica1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_aritmetica1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_89_in_aritmetica1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_load1658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_load1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_load1694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_load1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_load1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_load1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_load1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_load1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_load1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_load1820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_load1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_load1856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_load1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_load1892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_load1910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_load1928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_loadint1978 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEIRO_in_loadint1984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_103_in_loadint2004 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEIRO_in_loadint2010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_loadint2030 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEIRO_in_loadint2036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_97_in_store2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_98_in_store2116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_99_in_store2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_100_in_store2152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_store2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_store2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_store2206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_store2224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_96_in_storeint2278 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEIRO_in_storeint2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_storeint2305 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_INTEIRO_in_storeint2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_logica2371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_93_in_logica2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_102_in_logica2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_76_in_desvio2460 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_desvio2485 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_desvio2510 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_77_in_desvio2535 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_desvio2560 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_desvio2585 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_desvio2610 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_75_in_desvio2635 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_desvio2660 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_desvio2685 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_desvio2710 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_desvio2735 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_desvio2760 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ID_in_desvio2766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_106_in_pilha2827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_107_in_pilha2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_pilha2863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parametros_in_parametrosRetorno2918 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_33_in_parametrosRetorno2922 = new BitSet(new long[]{0x0000000440002000L});
    public static final BitSet FOLLOW_parametros_in_parametrosRetorno2924 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_parametrosRetorno2926 = new BitSet(new long[]{0x00000000C0002000L});
    public static final BitSet FOLLOW_tipo_in_parametrosRetorno2934 = new BitSet(new long[]{0x0000000000000002L});

}