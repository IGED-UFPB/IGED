// $ANTLR 3.4 C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g 2013-07-10 17:24:32

  //package br.ufpb.iged.tradutor.parser;
  package br.ufpb.iged.tradutor.gramaticas.output;
  
  //import br.ufpb.iged.tradutor.simbolos.TradutorAST;
  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class JediParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLOCO", "CLASSE", "COND_FOR", "CONSTR_DECL", "DOWHILE", "EXPR", "EXTENDS", "FIELD_DECL", "FOR", "ID", "IF", "INC_FOR", "INIT_FOR", "INT", "LETRA", "LISTA_EXPR", "LISTA_VAR_DECL", "METHOD_CALL", "METHOD_DECL", "NEW", "PARAM", "PARAMS", "POS_DECREMENTO", "POS_INCREMENTO", "PRE_DECREMENTO", "PRE_INCREMENTO", "RETURN", "SL_COMMENT", "VAR_DECL", "VAR_DECL_LISTA", "VECT_EXPR", "WHILE", "WS", "'!='", "'%'", "'&&'", "'('", "')'", "'*'", "'+'", "'++'", "','", "'-'", "'--'", "'.'", "'/'", "';'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'['", "'[]'", "']'", "'^'", "'class'", "'do'", "'else'", "'extends'", "'for'", "'if'", "'int'", "'new'", "'return'", "'static'", "'while'", "'{'", "'||'", "'}'"
    };

    public static final int EOF=-1;
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
    public static final int BLOCO=4;
    public static final int CLASSE=5;
    public static final int COND_FOR=6;
    public static final int CONSTR_DECL=7;
    public static final int DOWHILE=8;
    public static final int EXPR=9;
    public static final int EXTENDS=10;
    public static final int FIELD_DECL=11;
    public static final int FOR=12;
    public static final int ID=13;
    public static final int IF=14;
    public static final int INC_FOR=15;
    public static final int INIT_FOR=16;
    public static final int INT=17;
    public static final int LETRA=18;
    public static final int LISTA_EXPR=19;
    public static final int LISTA_VAR_DECL=20;
    public static final int METHOD_CALL=21;
    public static final int METHOD_DECL=22;
    public static final int NEW=23;
    public static final int PARAM=24;
    public static final int PARAMS=25;
    public static final int POS_DECREMENTO=26;
    public static final int POS_INCREMENTO=27;
    public static final int PRE_DECREMENTO=28;
    public static final int PRE_INCREMENTO=29;
    public static final int RETURN=30;
    public static final int SL_COMMENT=31;
    public static final int VAR_DECL=32;
    public static final int VAR_DECL_LISTA=33;
    public static final int VECT_EXPR=34;
    public static final int WHILE=35;
    public static final int WS=36;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "varDeclLista", "programa", "instrucao", "inicializacaoFor", 
    "params", "methodDecl", "superClasse", "listaExpressoes", "listaVarDecl", 
    "doWhileStatement", "or", "synpred3_Jedi", "varDecl", "mult", "condicaoFor", 
    "tipo", "synpred6_Jedi", "whileStatement", "ifStatement", "fieldDecl", 
    "and", "param", "synpred1_Jedi", "constrDecl", "synpred7_Jedi", "incrementoFor", 
    "synpred2_Jedi", "chamadaMetodo", "xor", "atribuicao", "forStatement", 
    "classe", "novo", "elseIf", "expressao", "membroClasse", "incremento", 
    "igualdade", "relacional", "synpred4_Jedi", "returnStatement", "posfixa", 
    "primaria", "synpred5_Jedi", "add", "bloco"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, true, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public JediParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public JediParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this,port,adaptor);
        setDebugListener(proxy);
        setTokenStream(new DebugTokenStream(input,proxy));
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);
        proxy.setTreeAdaptor(adap);
    }

public JediParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg);
     
    TreeAdaptor adap = new CommonTreeAdaptor();
    setTreeAdaptor(adap);


}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

protected DebugTreeAdaptor adaptor;
public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = new DebugTreeAdaptor(dbg,adaptor);


}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}

    public String[] getTokenNames() { return JediParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g"; }


    public static class programa_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "programa"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:52:1: programa : ( classe )+ ;
    public final JediParser.programa_return programa() throws RecognitionException {
        JediParser.programa_return retval = new JediParser.programa_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        JediParser.classe_return classe1 =null;



        try { dbg.enterRule(getGrammarFileName(), "programa");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(52, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:52:10: ( ( classe )+ )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:52:12: ( classe )+
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(52,12);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:52:12: ( classe )+
            int cnt1=0;
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==61) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:52:12: classe
            	    {
            	    dbg.location(52,12);
            	    pushFollow(FOLLOW_classe_in_programa199);
            	    classe1=classe();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, classe1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt1++;
            } while (true);
            } finally {dbg.exitSubRule(1);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(52, 18);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "programa");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "programa"


    public static class classe_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "classe"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:54:1: classe : 'class' ID ( superClasse )? '{' ( membroClasse )+ '}' -> ^( CLASSE ID ( superClasse )? ( membroClasse )+ ) ;
    public final JediParser.classe_return classe() throws RecognitionException {
        JediParser.classe_return retval = new JediParser.classe_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal2=null;
        Token ID3=null;
        Token char_literal5=null;
        Token char_literal7=null;
        JediParser.superClasse_return superClasse4 =null;

        JediParser.membroClasse_return membroClasse6 =null;


        Object string_literal2_tree=null;
        Object ID3_tree=null;
        Object char_literal5_tree=null;
        Object char_literal7_tree=null;
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_membroClasse=new RewriteRuleSubtreeStream(adaptor,"rule membroClasse");
        RewriteRuleSubtreeStream stream_superClasse=new RewriteRuleSubtreeStream(adaptor,"rule superClasse");
        try { dbg.enterRule(getGrammarFileName(), "classe");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(54, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:54:8: ( 'class' ID ( superClasse )? '{' ( membroClasse )+ '}' -> ^( CLASSE ID ( superClasse )? ( membroClasse )+ ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:54:10: 'class' ID ( superClasse )? '{' ( membroClasse )+ '}'
            {
            dbg.location(54,10);
            string_literal2=(Token)match(input,61,FOLLOW_61_in_classe208); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_61.add(string_literal2);

            dbg.location(54,18);
            ID3=(Token)match(input,ID,FOLLOW_ID_in_classe210); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID3);

            dbg.location(54,22);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:54:22: ( superClasse )?
            int alt2=2;
            try { dbg.enterSubRule(2);
            try { dbg.enterDecision(2, decisionCanBacktrack[2]);

            int LA2_0 = input.LA(1);

            if ( (LA2_0==64) ) {
                alt2=1;
            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:54:22: superClasse
                    {
                    dbg.location(54,22);
                    pushFollow(FOLLOW_superClasse_in_classe213);
                    superClasse4=superClasse();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_superClasse.add(superClasse4.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(2);}

            dbg.location(54,35);
            char_literal5=(Token)match(input,72,FOLLOW_72_in_classe216); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal5);

            dbg.location(54,39);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:54:39: ( membroClasse )+
            int cnt3=0;
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==ID||LA3_0==67||LA3_0==70) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:54:39: membroClasse
            	    {
            	    dbg.location(54,39);
            	    pushFollow(FOLLOW_membroClasse_in_classe218);
            	    membroClasse6=membroClasse();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_membroClasse.add(membroClasse6.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt3++;
            } while (true);
            } finally {dbg.exitSubRule(3);}

            dbg.location(54,53);
            char_literal7=(Token)match(input,74,FOLLOW_74_in_classe221); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(char_literal7);


            // AST REWRITE
            // elements: superClasse, membroClasse, ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 55:9: -> ^( CLASSE ID ( superClasse )? ( membroClasse )+ )
            {
                dbg.location(55,12);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:55:12: ^( CLASSE ID ( superClasse )? ( membroClasse )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(55,14);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CLASSE, "CLASSE")
                , root_1);

                dbg.location(55,21);
                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );
                dbg.location(55,24);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:55:24: ( superClasse )?
                if ( stream_superClasse.hasNext() ) {
                    dbg.location(55,24);
                    adaptor.addChild(root_1, stream_superClasse.nextTree());

                }
                stream_superClasse.reset();
                dbg.location(55,37);
                if ( !(stream_membroClasse.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_membroClasse.hasNext() ) {
                    dbg.location(55,37);
                    adaptor.addChild(root_1, stream_membroClasse.nextTree());

                }
                stream_membroClasse.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(56, 8);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "classe");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "classe"


    public static class superClasse_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "superClasse"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:58:1: superClasse : 'extends' ID -> ^( EXTENDS ID ) ;
    public final JediParser.superClasse_return superClasse() throws RecognitionException {
        JediParser.superClasse_return retval = new JediParser.superClasse_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal8=null;
        Token ID9=null;

        Object string_literal8_tree=null;
        Object ID9_tree=null;
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try { dbg.enterRule(getGrammarFileName(), "superClasse");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(58, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:59:2: ( 'extends' ID -> ^( EXTENDS ID ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:59:5: 'extends' ID
            {
            dbg.location(59,5);
            string_literal8=(Token)match(input,64,FOLLOW_64_in_superClasse263); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_64.add(string_literal8);

            dbg.location(59,15);
            ID9=(Token)match(input,ID,FOLLOW_ID_in_superClasse265); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID9);


            // AST REWRITE
            // elements: ID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 59:18: -> ^( EXTENDS ID )
            {
                dbg.location(59,21);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:59:21: ^( EXTENDS ID )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(59,23);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(EXTENDS, "EXTENDS")
                , root_1);

                dbg.location(59,31);
                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(60, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "superClasse");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "superClasse"


    public static class membroClasse_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "membroClasse"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:62:1: membroClasse : ( fieldDecl | constrDecl | methodDecl );
    public final JediParser.membroClasse_return membroClasse() throws RecognitionException {
        JediParser.membroClasse_return retval = new JediParser.membroClasse_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        JediParser.fieldDecl_return fieldDecl10 =null;

        JediParser.constrDecl_return constrDecl11 =null;

        JediParser.methodDecl_return methodDecl12 =null;



        try { dbg.enterRule(getGrammarFileName(), "membroClasse");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(62, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:62:14: ( fieldDecl | constrDecl | methodDecl )
            int alt4=3;
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            switch ( input.LA(1) ) {
            case 70:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==ID||LA4_1==67) ) {
                    int LA4_3 = input.LA(3);

                    if ( (LA4_3==ID) ) {
                        int LA4_5 = input.LA(4);

                        if ( (LA4_5==40) ) {
                            alt4=3;
                        }
                        else if ( (LA4_5==50||LA4_5==58) ) {
                            alt4=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 5, input);

                            dbg.recognitionException(nvae);
                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 3, input);

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case ID:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==40) ) {
                    alt4=2;
                }
                else if ( (LA4_2==ID) ) {
                    int LA4_5 = input.LA(3);

                    if ( (LA4_5==40) ) {
                        alt4=3;
                    }
                    else if ( (LA4_5==50||LA4_5==58) ) {
                        alt4=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 5, input);

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case 67:
                {
                int LA4_3 = input.LA(2);

                if ( (LA4_3==ID) ) {
                    int LA4_5 = input.LA(3);

                    if ( (LA4_5==40) ) {
                        alt4=3;
                    }
                    else if ( (LA4_5==50||LA4_5==58) ) {
                        alt4=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 5, input);

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:62:16: fieldDecl
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(62,16);
                    pushFollow(FOLLOW_fieldDecl_in_membroClasse283);
                    fieldDecl10=fieldDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fieldDecl10.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:62:28: constrDecl
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(62,28);
                    pushFollow(FOLLOW_constrDecl_in_membroClasse287);
                    constrDecl11=constrDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constrDecl11.getTree());

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:62:41: methodDecl
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(62,41);
                    pushFollow(FOLLOW_methodDecl_in_membroClasse291);
                    methodDecl12=methodDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, methodDecl12.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(62, 50);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "membroClasse");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "membroClasse"


    public static class fieldDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "fieldDecl"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:64:1: fieldDecl : (a= 'static' )? tipo ID (vet= '[]' )? ';' -> ^( FIELD_DECL ( $a)? tipo ID ( $vet)? ) ;
    public final JediParser.fieldDecl_return fieldDecl() throws RecognitionException {
        JediParser.fieldDecl_return retval = new JediParser.fieldDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token a=null;
        Token vet=null;
        Token ID14=null;
        Token char_literal15=null;
        JediParser.tipo_return tipo13 =null;


        Object a_tree=null;
        Object vet_tree=null;
        Object ID14_tree=null;
        Object char_literal15_tree=null;
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        try { dbg.enterRule(getGrammarFileName(), "fieldDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(64, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:64:11: ( (a= 'static' )? tipo ID (vet= '[]' )? ';' -> ^( FIELD_DECL ( $a)? tipo ID ( $vet)? ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:64:13: (a= 'static' )? tipo ID (vet= '[]' )? ';'
            {
            dbg.location(64,15);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:64:15: (a= 'static' )?
            int alt5=2;
            try { dbg.enterSubRule(5);
            try { dbg.enterDecision(5, decisionCanBacktrack[5]);

            int LA5_0 = input.LA(1);

            if ( (LA5_0==70) ) {
                alt5=1;
            }
            } finally {dbg.exitDecision(5);}

            switch (alt5) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:64:15: a= 'static'
                    {
                    dbg.location(64,15);
                    a=(Token)match(input,70,FOLLOW_70_in_fieldDecl303); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_70.add(a);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(5);}

            dbg.location(64,27);
            pushFollow(FOLLOW_tipo_in_fieldDecl306);
            tipo13=tipo();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tipo.add(tipo13.getTree());
            dbg.location(64,32);
            ID14=(Token)match(input,ID,FOLLOW_ID_in_fieldDecl308); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID14);

            dbg.location(64,39);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:64:39: (vet= '[]' )?
            int alt6=2;
            try { dbg.enterSubRule(6);
            try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            int LA6_0 = input.LA(1);

            if ( (LA6_0==58) ) {
                alt6=1;
            }
            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:64:39: vet= '[]'
                    {
                    dbg.location(64,39);
                    vet=(Token)match(input,58,FOLLOW_58_in_fieldDecl313); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(vet);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(6);}

            dbg.location(64,46);
            char_literal15=(Token)match(input,50,FOLLOW_50_in_fieldDecl316); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(char_literal15);


            // AST REWRITE
            // elements: ID, vet, tipo, a
            // token labels: a, vet
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleTokenStream stream_vet=new RewriteRuleTokenStream(adaptor,"token vet",vet);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 65:2: -> ^( FIELD_DECL ( $a)? tipo ID ( $vet)? )
            {
                dbg.location(65,5);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:65:5: ^( FIELD_DECL ( $a)? tipo ID ( $vet)? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(65,7);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(FIELD_DECL, "FIELD_DECL")
                , root_1);

                dbg.location(65,19);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:65:19: ( $a)?
                if ( stream_a.hasNext() ) {
                    dbg.location(65,19);
                    adaptor.addChild(root_1, stream_a.nextNode());

                }
                stream_a.reset();
                dbg.location(65,22);
                adaptor.addChild(root_1, stream_tipo.nextTree());
                dbg.location(65,27);
                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );
                dbg.location(65,31);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:65:31: ( $vet)?
                if ( stream_vet.hasNext() ) {
                    dbg.location(65,31);
                    adaptor.addChild(root_1, stream_vet.nextNode());

                }
                stream_vet.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(66, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "fieldDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "fieldDecl"


    public static class methodDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "methodDecl"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:68:1: methodDecl : (a= 'static' )? tipo ID '(' ( params )* ')' bloco -> ^( METHOD_DECL ( $a)? tipo ID ( params )* bloco ) ;
    public final JediParser.methodDecl_return methodDecl() throws RecognitionException {
        JediParser.methodDecl_return retval = new JediParser.methodDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token a=null;
        Token ID17=null;
        Token char_literal18=null;
        Token char_literal20=null;
        JediParser.tipo_return tipo16 =null;

        JediParser.params_return params19 =null;

        JediParser.bloco_return bloco21 =null;


        Object a_tree=null;
        Object ID17_tree=null;
        Object char_literal18_tree=null;
        Object char_literal20_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_70=new RewriteRuleTokenStream(adaptor,"token 70");
        RewriteRuleSubtreeStream stream_bloco=new RewriteRuleSubtreeStream(adaptor,"rule bloco");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        RewriteRuleSubtreeStream stream_params=new RewriteRuleSubtreeStream(adaptor,"rule params");
        try { dbg.enterRule(getGrammarFileName(), "methodDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(68, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:68:12: ( (a= 'static' )? tipo ID '(' ( params )* ')' bloco -> ^( METHOD_DECL ( $a)? tipo ID ( params )* bloco ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:68:14: (a= 'static' )? tipo ID '(' ( params )* ')' bloco
            {
            dbg.location(68,16);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:68:16: (a= 'static' )?
            int alt7=2;
            try { dbg.enterSubRule(7);
            try { dbg.enterDecision(7, decisionCanBacktrack[7]);

            int LA7_0 = input.LA(1);

            if ( (LA7_0==70) ) {
                alt7=1;
            }
            } finally {dbg.exitDecision(7);}

            switch (alt7) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:68:16: a= 'static'
                    {
                    dbg.location(68,16);
                    a=(Token)match(input,70,FOLLOW_70_in_methodDecl353); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_70.add(a);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(7);}

            dbg.location(68,28);
            pushFollow(FOLLOW_tipo_in_methodDecl356);
            tipo16=tipo();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tipo.add(tipo16.getTree());
            dbg.location(68,33);
            ID17=(Token)match(input,ID,FOLLOW_ID_in_methodDecl358); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID17);

            dbg.location(68,36);
            char_literal18=(Token)match(input,40,FOLLOW_40_in_methodDecl360); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal18);

            dbg.location(68,40);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:68:40: ( params )*
            try { dbg.enterSubRule(8);

            loop8:
            do {
                int alt8=2;
                try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                int LA8_0 = input.LA(1);

                if ( (LA8_0==ID||LA8_0==67) ) {
                    alt8=1;
                }


                } finally {dbg.exitDecision(8);}

                switch (alt8) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:68:40: params
            	    {
            	    dbg.location(68,40);
            	    pushFollow(FOLLOW_params_in_methodDecl362);
            	    params19=params();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_params.add(params19.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);
            } finally {dbg.exitSubRule(8);}

            dbg.location(68,48);
            char_literal20=(Token)match(input,41,FOLLOW_41_in_methodDecl365); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal20);

            dbg.location(68,52);
            pushFollow(FOLLOW_bloco_in_methodDecl367);
            bloco21=bloco();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_bloco.add(bloco21.getTree());

            // AST REWRITE
            // elements: ID, params, a, tipo, bloco
            // token labels: a
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_a=new RewriteRuleTokenStream(adaptor,"token a",a);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 69:12: -> ^( METHOD_DECL ( $a)? tipo ID ( params )* bloco )
            {
                dbg.location(69,15);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:69:15: ^( METHOD_DECL ( $a)? tipo ID ( params )* bloco )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(69,17);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(METHOD_DECL, "METHOD_DECL")
                , root_1);

                dbg.location(69,30);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:69:30: ( $a)?
                if ( stream_a.hasNext() ) {
                    dbg.location(69,30);
                    adaptor.addChild(root_1, stream_a.nextNode());

                }
                stream_a.reset();
                dbg.location(69,33);
                adaptor.addChild(root_1, stream_tipo.nextTree());
                dbg.location(69,38);
                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );
                dbg.location(69,41);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:69:41: ( params )*
                while ( stream_params.hasNext() ) {
                    dbg.location(69,41);
                    adaptor.addChild(root_1, stream_params.nextTree());

                }
                stream_params.reset();
                dbg.location(69,49);
                adaptor.addChild(root_1, stream_bloco.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(70, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "methodDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "methodDecl"


    public static class constrDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "constrDecl"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:72:1: constrDecl : ID '(' ( params )* ')' bloco -> ^( CONSTR_DECL ID ( params )* bloco ) ;
    public final JediParser.constrDecl_return constrDecl() throws RecognitionException {
        JediParser.constrDecl_return retval = new JediParser.constrDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ID22=null;
        Token char_literal23=null;
        Token char_literal25=null;
        JediParser.params_return params24 =null;

        JediParser.bloco_return bloco26 =null;


        Object ID22_tree=null;
        Object char_literal23_tree=null;
        Object char_literal25_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_bloco=new RewriteRuleSubtreeStream(adaptor,"rule bloco");
        RewriteRuleSubtreeStream stream_params=new RewriteRuleSubtreeStream(adaptor,"rule params");
        try { dbg.enterRule(getGrammarFileName(), "constrDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(72, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:72:12: ( ID '(' ( params )* ')' bloco -> ^( CONSTR_DECL ID ( params )* bloco ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:72:15: ID '(' ( params )* ')' bloco
            {
            dbg.location(72,15);
            ID22=(Token)match(input,ID,FOLLOW_ID_in_constrDecl415); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID22);

            dbg.location(72,18);
            char_literal23=(Token)match(input,40,FOLLOW_40_in_constrDecl417); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal23);

            dbg.location(72,22);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:72:22: ( params )*
            try { dbg.enterSubRule(9);

            loop9:
            do {
                int alt9=2;
                try { dbg.enterDecision(9, decisionCanBacktrack[9]);

                int LA9_0 = input.LA(1);

                if ( (LA9_0==ID||LA9_0==67) ) {
                    alt9=1;
                }


                } finally {dbg.exitDecision(9);}

                switch (alt9) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:72:22: params
            	    {
            	    dbg.location(72,22);
            	    pushFollow(FOLLOW_params_in_constrDecl419);
            	    params24=params();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_params.add(params24.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);
            } finally {dbg.exitSubRule(9);}

            dbg.location(72,30);
            char_literal25=(Token)match(input,41,FOLLOW_41_in_constrDecl422); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal25);

            dbg.location(72,34);
            pushFollow(FOLLOW_bloco_in_constrDecl424);
            bloco26=bloco();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_bloco.add(bloco26.getTree());

            // AST REWRITE
            // elements: ID, bloco, params
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 73:12: -> ^( CONSTR_DECL ID ( params )* bloco )
            {
                dbg.location(73,15);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:73:15: ^( CONSTR_DECL ID ( params )* bloco )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(73,17);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(CONSTR_DECL, "CONSTR_DECL")
                , root_1);

                dbg.location(73,29);
                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );
                dbg.location(73,32);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:73:32: ( params )*
                while ( stream_params.hasNext() ) {
                    dbg.location(73,32);
                    adaptor.addChild(root_1, stream_params.nextTree());

                }
                stream_params.reset();
                dbg.location(73,40);
                adaptor.addChild(root_1, stream_bloco.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(74, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "constrDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "constrDecl"


    public static class params_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "params"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:76:1: params : param ( ',' param )* -> ^( PARAMS ( param )+ ) ;
    public final JediParser.params_return params() throws RecognitionException {
        JediParser.params_return retval = new JediParser.params_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal28=null;
        JediParser.param_return param27 =null;

        JediParser.param_return param29 =null;


        Object char_literal28_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleSubtreeStream stream_param=new RewriteRuleSubtreeStream(adaptor,"rule param");
        try { dbg.enterRule(getGrammarFileName(), "params");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(76, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:76:8: ( param ( ',' param )* -> ^( PARAMS ( param )+ ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:76:11: param ( ',' param )*
            {
            dbg.location(76,11);
            pushFollow(FOLLOW_param_in_params467);
            param27=param();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_param.add(param27.getTree());
            dbg.location(76,17);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:76:17: ( ',' param )*
            try { dbg.enterSubRule(10);

            loop10:
            do {
                int alt10=2;
                try { dbg.enterDecision(10, decisionCanBacktrack[10]);

                int LA10_0 = input.LA(1);

                if ( (LA10_0==45) ) {
                    alt10=1;
                }


                } finally {dbg.exitDecision(10);}

                switch (alt10) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:76:18: ',' param
            	    {
            	    dbg.location(76,18);
            	    char_literal28=(Token)match(input,45,FOLLOW_45_in_params470); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_45.add(char_literal28);

            	    dbg.location(76,22);
            	    pushFollow(FOLLOW_param_in_params472);
            	    param29=param();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_param.add(param29.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);
            } finally {dbg.exitSubRule(10);}


            // AST REWRITE
            // elements: param
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 76:30: -> ^( PARAMS ( param )+ )
            {
                dbg.location(76,33);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:76:33: ^( PARAMS ( param )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(76,35);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PARAMS, "PARAMS")
                , root_1);

                dbg.location(76,42);
                if ( !(stream_param.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_param.hasNext() ) {
                    dbg.location(76,42);
                    adaptor.addChild(root_1, stream_param.nextTree());

                }
                stream_param.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(76, 48);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "params");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "params"


    public static class param_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "param"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:78:1: param : tipo ID (vet= '[]' )? -> ^( PARAM tipo ID ( $vet)? ) ;
    public final JediParser.param_return param() throws RecognitionException {
        JediParser.param_return retval = new JediParser.param_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token vet=null;
        Token ID31=null;
        JediParser.tipo_return tipo30 =null;


        Object vet_tree=null;
        Object ID31_tree=null;
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        try { dbg.enterRule(getGrammarFileName(), "param");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(78, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:78:7: ( tipo ID (vet= '[]' )? -> ^( PARAM tipo ID ( $vet)? ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:78:10: tipo ID (vet= '[]' )?
            {
            dbg.location(78,10);
            pushFollow(FOLLOW_tipo_in_param492);
            tipo30=tipo();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tipo.add(tipo30.getTree());
            dbg.location(78,15);
            ID31=(Token)match(input,ID,FOLLOW_ID_in_param494); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID31);

            dbg.location(78,22);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:78:22: (vet= '[]' )?
            int alt11=2;
            try { dbg.enterSubRule(11);
            try { dbg.enterDecision(11, decisionCanBacktrack[11]);

            int LA11_0 = input.LA(1);

            if ( (LA11_0==58) ) {
                alt11=1;
            }
            } finally {dbg.exitDecision(11);}

            switch (alt11) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:78:22: vet= '[]'
                    {
                    dbg.location(78,22);
                    vet=(Token)match(input,58,FOLLOW_58_in_param499); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(vet);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(11);}


            // AST REWRITE
            // elements: ID, vet, tipo
            // token labels: vet
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_vet=new RewriteRuleTokenStream(adaptor,"token vet",vet);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 78:29: -> ^( PARAM tipo ID ( $vet)? )
            {
                dbg.location(78,32);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:78:32: ^( PARAM tipo ID ( $vet)? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(78,34);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(PARAM, "PARAM")
                , root_1);

                dbg.location(78,40);
                adaptor.addChild(root_1, stream_tipo.nextTree());
                dbg.location(78,45);
                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );
                dbg.location(78,49);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:78:49: ( $vet)?
                if ( stream_vet.hasNext() ) {
                    dbg.location(78,49);
                    adaptor.addChild(root_1, stream_vet.nextNode());

                }
                stream_vet.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(78, 53);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "param");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "param"


    public static class instrucao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "instrucao"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:80:1: instrucao : ( ';' | expressao ';' | listaVarDecl ';' | bloco | ifStatement | whileStatement | doWhileStatement ';' | forStatement | returnStatement ';' );
    public final JediParser.instrucao_return instrucao() throws RecognitionException {
        JediParser.instrucao_return retval = new JediParser.instrucao_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal32=null;
        Token char_literal34=null;
        Token char_literal36=null;
        Token char_literal41=null;
        Token char_literal44=null;
        JediParser.expressao_return expressao33 =null;

        JediParser.listaVarDecl_return listaVarDecl35 =null;

        JediParser.bloco_return bloco37 =null;

        JediParser.ifStatement_return ifStatement38 =null;

        JediParser.whileStatement_return whileStatement39 =null;

        JediParser.doWhileStatement_return doWhileStatement40 =null;

        JediParser.forStatement_return forStatement42 =null;

        JediParser.returnStatement_return returnStatement43 =null;


        Object char_literal32_tree=null;
        Object char_literal34_tree=null;
        Object char_literal36_tree=null;
        Object char_literal41_tree=null;
        Object char_literal44_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "instrucao");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(80, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:80:12: ( ';' | expressao ';' | listaVarDecl ';' | bloco | ifStatement | whileStatement | doWhileStatement ';' | forStatement | returnStatement ';' )
            int alt12=9;
            try { dbg.enterDecision(12, decisionCanBacktrack[12]);

            switch ( input.LA(1) ) {
            case 50:
                {
                alt12=1;
                }
                break;
            case INT:
            case 40:
            case 44:
            case 46:
            case 47:
            case 68:
                {
                alt12=2;
                }
                break;
            case ID:
                {
                int LA12_3 = input.LA(2);

                if ( ((LA12_3 >= 37 && LA12_3 <= 40)||(LA12_3 >= 42 && LA12_3 <= 44)||(LA12_3 >= 46 && LA12_3 <= 57)||LA12_3==60||LA12_3==73) ) {
                    alt12=2;
                }
                else if ( (LA12_3==ID) ) {
                    alt12=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 3, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case 67:
                {
                int LA12_4 = input.LA(2);

                if ( ((LA12_4 >= 37 && LA12_4 <= 40)||(LA12_4 >= 42 && LA12_4 <= 43)||LA12_4==46||(LA12_4 >= 48 && LA12_4 <= 57)||LA12_4==60||LA12_4==73) ) {
                    alt12=2;
                }
                else if ( (LA12_4==ID) ) {
                    alt12=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 4, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case 72:
                {
                alt12=4;
                }
                break;
            case 66:
                {
                alt12=5;
                }
                break;
            case 71:
                {
                alt12=6;
                }
                break;
            case 62:
                {
                alt12=7;
                }
                break;
            case 65:
                {
                alt12=8;
                }
                break;
            case 69:
                {
                alt12=9;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(12);}

            switch (alt12) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:80:14: ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(80,14);
                    char_literal32=(Token)match(input,50,FOLLOW_50_in_instrucao523); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal32_tree = 
                    (Object)adaptor.create(char_literal32)
                    ;
                    adaptor.addChild(root_0, char_literal32_tree);
                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:81:4: expressao ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(81,4);
                    pushFollow(FOLLOW_expressao_in_instrucao528);
                    expressao33=expressao();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expressao33.getTree());
                    dbg.location(81,14);
                    char_literal34=(Token)match(input,50,FOLLOW_50_in_instrucao530); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal34_tree = 
                    (Object)adaptor.create(char_literal34)
                    ;
                    adaptor.addChild(root_0, char_literal34_tree);
                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:82:4: listaVarDecl ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(82,4);
                    pushFollow(FOLLOW_listaVarDecl_in_instrucao535);
                    listaVarDecl35=listaVarDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, listaVarDecl35.getTree());
                    dbg.location(82,17);
                    char_literal36=(Token)match(input,50,FOLLOW_50_in_instrucao537); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal36_tree = 
                    (Object)adaptor.create(char_literal36)
                    ;
                    adaptor.addChild(root_0, char_literal36_tree);
                    }

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:83:4: bloco
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(83,4);
                    pushFollow(FOLLOW_bloco_in_instrucao542);
                    bloco37=bloco();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bloco37.getTree());

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:84:4: ifStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(84,4);
                    pushFollow(FOLLOW_ifStatement_in_instrucao547);
                    ifStatement38=ifStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStatement38.getTree());

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:85:4: whileStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(85,4);
                    pushFollow(FOLLOW_whileStatement_in_instrucao552);
                    whileStatement39=whileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStatement39.getTree());

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:86:4: doWhileStatement ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(86,4);
                    pushFollow(FOLLOW_doWhileStatement_in_instrucao557);
                    doWhileStatement40=doWhileStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, doWhileStatement40.getTree());
                    dbg.location(86,21);
                    char_literal41=(Token)match(input,50,FOLLOW_50_in_instrucao559); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal41_tree = 
                    (Object)adaptor.create(char_literal41)
                    ;
                    adaptor.addChild(root_0, char_literal41_tree);
                    }

                    }
                    break;
                case 8 :
                    dbg.enterAlt(8);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:87:4: forStatement
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(87,4);
                    pushFollow(FOLLOW_forStatement_in_instrucao564);
                    forStatement42=forStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, forStatement42.getTree());

                    }
                    break;
                case 9 :
                    dbg.enterAlt(9);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:88:4: returnStatement ';'
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(88,4);
                    pushFollow(FOLLOW_returnStatement_in_instrucao569);
                    returnStatement43=returnStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, returnStatement43.getTree());
                    dbg.location(88,20);
                    char_literal44=(Token)match(input,50,FOLLOW_50_in_instrucao571); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal44_tree = 
                    (Object)adaptor.create(char_literal44)
                    ;
                    adaptor.addChild(root_0, char_literal44_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(89, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "instrucao");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "instrucao"


    public static class expressao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expressao"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:93:1: expressao : atribuicao -> ^( EXPR atribuicao ) ;
    public final JediParser.expressao_return expressao() throws RecognitionException {
        JediParser.expressao_return retval = new JediParser.expressao_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        JediParser.atribuicao_return atribuicao45 =null;


        RewriteRuleSubtreeStream stream_atribuicao=new RewriteRuleSubtreeStream(adaptor,"rule atribuicao");
        try { dbg.enterRule(getGrammarFileName(), "expressao");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(93, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:93:12: ( atribuicao -> ^( EXPR atribuicao ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:93:14: atribuicao
            {
            dbg.location(93,14);
            pushFollow(FOLLOW_atribuicao_in_expressao584);
            atribuicao45=atribuicao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_atribuicao.add(atribuicao45.getTree());

            // AST REWRITE
            // elements: atribuicao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 93:25: -> ^( EXPR atribuicao )
            {
                dbg.location(93,28);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:93:28: ^( EXPR atribuicao )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(93,30);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(EXPR, "EXPR")
                , root_1);

                dbg.location(93,35);
                adaptor.addChild(root_1, stream_atribuicao.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(93, 45);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expressao");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "expressao"


    public static class atribuicao_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atribuicao"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:95:1: atribuicao : or ( ( '=' ^) or )* ;
    public final JediParser.atribuicao_return atribuicao() throws RecognitionException {
        JediParser.atribuicao_return retval = new JediParser.atribuicao_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal47=null;
        JediParser.or_return or46 =null;

        JediParser.or_return or48 =null;


        Object char_literal47_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "atribuicao");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(95, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:95:12: ( or ( ( '=' ^) or )* )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:95:14: or ( ( '=' ^) or )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(95,14);
            pushFollow(FOLLOW_or_in_atribuicao601);
            or46=or();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, or46.getTree());
            dbg.location(95,17);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:95:17: ( ( '=' ^) or )*
            try { dbg.enterSubRule(13);

            loop13:
            do {
                int alt13=2;
                try { dbg.enterDecision(13, decisionCanBacktrack[13]);

                int LA13_0 = input.LA(1);

                if ( (LA13_0==53) ) {
                    alt13=1;
                }


                } finally {dbg.exitDecision(13);}

                switch (alt13) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:95:18: ( '=' ^) or
            	    {
            	    dbg.location(95,18);
            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:95:18: ( '=' ^)
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:95:19: '=' ^
            	    {
            	    dbg.location(95,22);
            	    char_literal47=(Token)match(input,53,FOLLOW_53_in_atribuicao605); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal47_tree = 
            	    (Object)adaptor.create(char_literal47)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(char_literal47_tree, root_0);
            	    }

            	    }

            	    dbg.location(95,25);
            	    pushFollow(FOLLOW_or_in_atribuicao609);
            	    or48=or();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, or48.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);
            } finally {dbg.exitSubRule(13);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(95, 29);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "atribuicao");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "atribuicao"


    public static class or_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "or"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:97:1: or : and ( ( '||' ^) and )* ;
    public final JediParser.or_return or() throws RecognitionException {
        JediParser.or_return retval = new JediParser.or_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal50=null;
        JediParser.and_return and49 =null;

        JediParser.and_return and51 =null;


        Object string_literal50_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "or");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(97, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:97:4: ( and ( ( '||' ^) and )* )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:97:7: and ( ( '||' ^) and )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(97,7);
            pushFollow(FOLLOW_and_in_or623);
            and49=and();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, and49.getTree());
            dbg.location(97,11);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:97:11: ( ( '||' ^) and )*
            try { dbg.enterSubRule(14);

            loop14:
            do {
                int alt14=2;
                try { dbg.enterDecision(14, decisionCanBacktrack[14]);

                int LA14_0 = input.LA(1);

                if ( (LA14_0==73) ) {
                    alt14=1;
                }


                } finally {dbg.exitDecision(14);}

                switch (alt14) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:97:12: ( '||' ^) and
            	    {
            	    dbg.location(97,12);
            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:97:12: ( '||' ^)
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:97:13: '||' ^
            	    {
            	    dbg.location(97,17);
            	    string_literal50=(Token)match(input,73,FOLLOW_73_in_or627); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal50_tree = 
            	    (Object)adaptor.create(string_literal50)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(string_literal50_tree, root_0);
            	    }

            	    }

            	    dbg.location(97,20);
            	    pushFollow(FOLLOW_and_in_or631);
            	    and51=and();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, and51.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);
            } finally {dbg.exitSubRule(14);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(97, 25);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "or");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "or"


    public static class and_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "and"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:99:1: and : xor ( ( '&&' ^) xor )* ;
    public final JediParser.and_return and() throws RecognitionException {
        JediParser.and_return retval = new JediParser.and_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal53=null;
        JediParser.xor_return xor52 =null;

        JediParser.xor_return xor54 =null;


        Object string_literal53_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "and");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(99, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:99:5: ( xor ( ( '&&' ^) xor )* )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:99:7: xor ( ( '&&' ^) xor )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(99,7);
            pushFollow(FOLLOW_xor_in_and642);
            xor52=xor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, xor52.getTree());
            dbg.location(99,11);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:99:11: ( ( '&&' ^) xor )*
            try { dbg.enterSubRule(15);

            loop15:
            do {
                int alt15=2;
                try { dbg.enterDecision(15, decisionCanBacktrack[15]);

                int LA15_0 = input.LA(1);

                if ( (LA15_0==39) ) {
                    alt15=1;
                }


                } finally {dbg.exitDecision(15);}

                switch (alt15) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:99:12: ( '&&' ^) xor
            	    {
            	    dbg.location(99,12);
            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:99:12: ( '&&' ^)
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:99:13: '&&' ^
            	    {
            	    dbg.location(99,17);
            	    string_literal53=(Token)match(input,39,FOLLOW_39_in_and646); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    string_literal53_tree = 
            	    (Object)adaptor.create(string_literal53)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(string_literal53_tree, root_0);
            	    }

            	    }

            	    dbg.location(99,20);
            	    pushFollow(FOLLOW_xor_in_and650);
            	    xor54=xor();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, xor54.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);
            } finally {dbg.exitSubRule(15);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(99, 25);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "and");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "and"


    public static class xor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "xor"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:101:1: xor : igualdade ( ( '^' ^) igualdade )* ;
    public final JediParser.xor_return xor() throws RecognitionException {
        JediParser.xor_return retval = new JediParser.xor_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal56=null;
        JediParser.igualdade_return igualdade55 =null;

        JediParser.igualdade_return igualdade57 =null;


        Object char_literal56_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "xor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(101, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:101:6: ( igualdade ( ( '^' ^) igualdade )* )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:101:10: igualdade ( ( '^' ^) igualdade )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(101,10);
            pushFollow(FOLLOW_igualdade_in_xor664);
            igualdade55=igualdade();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, igualdade55.getTree());
            dbg.location(101,20);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:101:20: ( ( '^' ^) igualdade )*
            try { dbg.enterSubRule(16);

            loop16:
            do {
                int alt16=2;
                try { dbg.enterDecision(16, decisionCanBacktrack[16]);

                int LA16_0 = input.LA(1);

                if ( (LA16_0==60) ) {
                    alt16=1;
                }


                } finally {dbg.exitDecision(16);}

                switch (alt16) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:101:21: ( '^' ^) igualdade
            	    {
            	    dbg.location(101,21);
            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:101:21: ( '^' ^)
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:101:22: '^' ^
            	    {
            	    dbg.location(101,25);
            	    char_literal56=(Token)match(input,60,FOLLOW_60_in_xor668); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal56_tree = 
            	    (Object)adaptor.create(char_literal56)
            	    ;
            	    root_0 = (Object)adaptor.becomeRoot(char_literal56_tree, root_0);
            	    }

            	    }

            	    dbg.location(101,28);
            	    pushFollow(FOLLOW_igualdade_in_xor672);
            	    igualdade57=igualdade();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, igualdade57.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);
            } finally {dbg.exitSubRule(16);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(101, 39);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "xor");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "xor"


    public static class igualdade_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "igualdade"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:103:1: igualdade : relacional ( ( '==' ^| '!=' ^) relacional )* ;
    public final JediParser.igualdade_return igualdade() throws RecognitionException {
        JediParser.igualdade_return retval = new JediParser.igualdade_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal59=null;
        Token string_literal60=null;
        JediParser.relacional_return relacional58 =null;

        JediParser.relacional_return relacional61 =null;


        Object string_literal59_tree=null;
        Object string_literal60_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "igualdade");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(103, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:103:12: ( relacional ( ( '==' ^| '!=' ^) relacional )* )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:103:16: relacional ( ( '==' ^| '!=' ^) relacional )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(103,16);
            pushFollow(FOLLOW_relacional_in_igualdade686);
            relacional58=relacional();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relacional58.getTree());
            dbg.location(103,27);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:103:27: ( ( '==' ^| '!=' ^) relacional )*
            try { dbg.enterSubRule(18);

            loop18:
            do {
                int alt18=2;
                try { dbg.enterDecision(18, decisionCanBacktrack[18]);

                int LA18_0 = input.LA(1);

                if ( (LA18_0==37||LA18_0==54) ) {
                    alt18=1;
                }


                } finally {dbg.exitDecision(18);}

                switch (alt18) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:103:28: ( '==' ^| '!=' ^) relacional
            	    {
            	    dbg.location(103,28);
            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:103:28: ( '==' ^| '!=' ^)
            	    int alt17=2;
            	    try { dbg.enterSubRule(17);
            	    try { dbg.enterDecision(17, decisionCanBacktrack[17]);

            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0==54) ) {
            	        alt17=1;
            	    }
            	    else if ( (LA17_0==37) ) {
            	        alt17=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 17, 0, input);

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }
            	    } finally {dbg.exitDecision(17);}

            	    switch (alt17) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:103:29: '==' ^
            	            {
            	            dbg.location(103,33);
            	            string_literal59=(Token)match(input,54,FOLLOW_54_in_igualdade690); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal59_tree = 
            	            (Object)adaptor.create(string_literal59)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(string_literal59_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:103:36: '!=' ^
            	            {
            	            dbg.location(103,40);
            	            string_literal60=(Token)match(input,37,FOLLOW_37_in_igualdade694); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal60_tree = 
            	            (Object)adaptor.create(string_literal60)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(string_literal60_tree, root_0);
            	            }

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(17);}

            	    dbg.location(103,43);
            	    pushFollow(FOLLOW_relacional_in_igualdade698);
            	    relacional61=relacional();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relacional61.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);
            } finally {dbg.exitSubRule(18);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(103, 55);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "igualdade");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "igualdade"


    public static class relacional_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "relacional"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:105:1: relacional : add ( ( '<' ^| '>' ^| '>=' ^| '<=' ^) add )* ;
    public final JediParser.relacional_return relacional() throws RecognitionException {
        JediParser.relacional_return retval = new JediParser.relacional_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal63=null;
        Token char_literal64=null;
        Token string_literal65=null;
        Token string_literal66=null;
        JediParser.add_return add62 =null;

        JediParser.add_return add67 =null;


        Object char_literal63_tree=null;
        Object char_literal64_tree=null;
        Object string_literal65_tree=null;
        Object string_literal66_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "relacional");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(105, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:105:12: ( add ( ( '<' ^| '>' ^| '>=' ^| '<=' ^) add )* )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:105:14: add ( ( '<' ^| '>' ^| '>=' ^| '<=' ^) add )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(105,14);
            pushFollow(FOLLOW_add_in_relacional709);
            add62=add();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, add62.getTree());
            dbg.location(105,18);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:105:18: ( ( '<' ^| '>' ^| '>=' ^| '<=' ^) add )*
            try { dbg.enterSubRule(20);

            loop20:
            do {
                int alt20=2;
                try { dbg.enterDecision(20, decisionCanBacktrack[20]);

                int LA20_0 = input.LA(1);

                if ( ((LA20_0 >= 51 && LA20_0 <= 52)||(LA20_0 >= 55 && LA20_0 <= 56)) ) {
                    alt20=1;
                }


                } finally {dbg.exitDecision(20);}

                switch (alt20) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:105:19: ( '<' ^| '>' ^| '>=' ^| '<=' ^) add
            	    {
            	    dbg.location(105,19);
            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:105:19: ( '<' ^| '>' ^| '>=' ^| '<=' ^)
            	    int alt19=4;
            	    try { dbg.enterSubRule(19);
            	    try { dbg.enterDecision(19, decisionCanBacktrack[19]);

            	    switch ( input.LA(1) ) {
            	    case 51:
            	        {
            	        alt19=1;
            	        }
            	        break;
            	    case 55:
            	        {
            	        alt19=2;
            	        }
            	        break;
            	    case 56:
            	        {
            	        alt19=3;
            	        }
            	        break;
            	    case 52:
            	        {
            	        alt19=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }

            	    } finally {dbg.exitDecision(19);}

            	    switch (alt19) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:105:20: '<' ^
            	            {
            	            dbg.location(105,23);
            	            char_literal63=(Token)match(input,51,FOLLOW_51_in_relacional713); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal63_tree = 
            	            (Object)adaptor.create(char_literal63)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal63_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:105:27: '>' ^
            	            {
            	            dbg.location(105,30);
            	            char_literal64=(Token)match(input,55,FOLLOW_55_in_relacional718); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal64_tree = 
            	            (Object)adaptor.create(char_literal64)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal64_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            dbg.enterAlt(3);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:105:34: '>=' ^
            	            {
            	            dbg.location(105,38);
            	            string_literal65=(Token)match(input,56,FOLLOW_56_in_relacional723); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal65_tree = 
            	            (Object)adaptor.create(string_literal65)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(string_literal65_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            dbg.enterAlt(4);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:105:42: '<=' ^
            	            {
            	            dbg.location(105,46);
            	            string_literal66=(Token)match(input,52,FOLLOW_52_in_relacional728); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal66_tree = 
            	            (Object)adaptor.create(string_literal66)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(string_literal66_tree, root_0);
            	            }

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(19);}

            	    dbg.location(105,49);
            	    pushFollow(FOLLOW_add_in_relacional732);
            	    add67=add();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, add67.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);
            } finally {dbg.exitSubRule(20);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(105, 54);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "relacional");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "relacional"


    public static class add_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "add"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:107:1: add : mult ( ( '+' ^| '-' ^) mult )* ;
    public final JediParser.add_return add() throws RecognitionException {
        JediParser.add_return retval = new JediParser.add_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal69=null;
        Token char_literal70=null;
        JediParser.mult_return mult68 =null;

        JediParser.mult_return mult71 =null;


        Object char_literal69_tree=null;
        Object char_literal70_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "add");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(107, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:107:4: ( mult ( ( '+' ^| '-' ^) mult )* )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:107:8: mult ( ( '+' ^| '-' ^) mult )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(107,8);
            pushFollow(FOLLOW_mult_in_add744);
            mult68=mult();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult68.getTree());
            dbg.location(107,13);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:107:13: ( ( '+' ^| '-' ^) mult )*
            try { dbg.enterSubRule(22);

            loop22:
            do {
                int alt22=2;
                try { dbg.enterDecision(22, decisionCanBacktrack[22]);

                int LA22_0 = input.LA(1);

                if ( (LA22_0==43||LA22_0==46) ) {
                    alt22=1;
                }


                } finally {dbg.exitDecision(22);}

                switch (alt22) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:107:14: ( '+' ^| '-' ^) mult
            	    {
            	    dbg.location(107,14);
            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:107:14: ( '+' ^| '-' ^)
            	    int alt21=2;
            	    try { dbg.enterSubRule(21);
            	    try { dbg.enterDecision(21, decisionCanBacktrack[21]);

            	    int LA21_0 = input.LA(1);

            	    if ( (LA21_0==43) ) {
            	        alt21=1;
            	    }
            	    else if ( (LA21_0==46) ) {
            	        alt21=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 21, 0, input);

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }
            	    } finally {dbg.exitDecision(21);}

            	    switch (alt21) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:107:15: '+' ^
            	            {
            	            dbg.location(107,18);
            	            char_literal69=(Token)match(input,43,FOLLOW_43_in_add748); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal69_tree = 
            	            (Object)adaptor.create(char_literal69)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal69_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:107:21: '-' ^
            	            {
            	            dbg.location(107,24);
            	            char_literal70=(Token)match(input,46,FOLLOW_46_in_add752); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal70_tree = 
            	            (Object)adaptor.create(char_literal70)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal70_tree, root_0);
            	            }

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(21);}

            	    dbg.location(107,27);
            	    pushFollow(FOLLOW_mult_in_add756);
            	    mult71=mult();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult71.getTree());

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);
            } finally {dbg.exitSubRule(22);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(107, 33);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "add");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "add"


    public static class mult_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mult"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:109:1: mult : novo ( ( '*' ^| '/' ^| '%' ^) novo )* ;
    public final JediParser.mult_return mult() throws RecognitionException {
        JediParser.mult_return retval = new JediParser.mult_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal73=null;
        Token char_literal74=null;
        Token char_literal75=null;
        JediParser.novo_return novo72 =null;

        JediParser.novo_return novo76 =null;


        Object char_literal73_tree=null;
        Object char_literal74_tree=null;
        Object char_literal75_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "mult");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(109, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:109:5: ( novo ( ( '*' ^| '/' ^| '%' ^) novo )* )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:109:7: novo ( ( '*' ^| '/' ^| '%' ^) novo )*
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(109,7);
            pushFollow(FOLLOW_novo_in_mult766);
            novo72=novo();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, novo72.getTree());
            dbg.location(109,12);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:109:12: ( ( '*' ^| '/' ^| '%' ^) novo )*
            try { dbg.enterSubRule(24);

            loop24:
            do {
                int alt24=2;
                try { dbg.enterDecision(24, decisionCanBacktrack[24]);

                int LA24_0 = input.LA(1);

                if ( (LA24_0==38||LA24_0==42||LA24_0==49) ) {
                    alt24=1;
                }


                } finally {dbg.exitDecision(24);}

                switch (alt24) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:109:13: ( '*' ^| '/' ^| '%' ^) novo
            	    {
            	    dbg.location(109,13);
            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:109:13: ( '*' ^| '/' ^| '%' ^)
            	    int alt23=3;
            	    try { dbg.enterSubRule(23);
            	    try { dbg.enterDecision(23, decisionCanBacktrack[23]);

            	    switch ( input.LA(1) ) {
            	    case 42:
            	        {
            	        alt23=1;
            	        }
            	        break;
            	    case 49:
            	        {
            	        alt23=2;
            	        }
            	        break;
            	    case 38:
            	        {
            	        alt23=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 23, 0, input);

            	        dbg.recognitionException(nvae);
            	        throw nvae;

            	    }

            	    } finally {dbg.exitDecision(23);}

            	    switch (alt23) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:109:14: '*' ^
            	            {
            	            dbg.location(109,17);
            	            char_literal73=(Token)match(input,42,FOLLOW_42_in_mult770); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal73_tree = 
            	            (Object)adaptor.create(char_literal73)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal73_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            dbg.enterAlt(2);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:109:21: '/' ^
            	            {
            	            dbg.location(109,24);
            	            char_literal74=(Token)match(input,49,FOLLOW_49_in_mult775); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal74_tree = 
            	            (Object)adaptor.create(char_literal74)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal74_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            dbg.enterAlt(3);

            	            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:109:28: '%' ^
            	            {
            	            dbg.location(109,31);
            	            char_literal75=(Token)match(input,38,FOLLOW_38_in_mult780); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal75_tree = 
            	            (Object)adaptor.create(char_literal75)
            	            ;
            	            root_0 = (Object)adaptor.becomeRoot(char_literal75_tree, root_0);
            	            }

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(23);}

            	    dbg.location(109,34);
            	    pushFollow(FOLLOW_novo_in_mult784);
            	    novo76=novo();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, novo76.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);
            } finally {dbg.exitSubRule(24);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(109, 40);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "mult");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "mult"


    public static class novo_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "novo"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:111:1: novo : ( posfixa | ( ( 'new' ^) posfixa ) );
    public final JediParser.novo_return novo() throws RecognitionException {
        JediParser.novo_return retval = new JediParser.novo_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal78=null;
        JediParser.posfixa_return posfixa77 =null;

        JediParser.posfixa_return posfixa79 =null;


        Object string_literal78_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "novo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(111, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:111:6: ( posfixa | ( ( 'new' ^) posfixa ) )
            int alt25=2;
            try { dbg.enterDecision(25, decisionCanBacktrack[25]);

            int LA25_0 = input.LA(1);

            if ( (LA25_0==ID||LA25_0==INT||LA25_0==40||LA25_0==44||(LA25_0 >= 46 && LA25_0 <= 47)||LA25_0==67) ) {
                alt25=1;
            }
            else if ( (LA25_0==68) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(25);}

            switch (alt25) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:111:9: posfixa
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(111,9);
                    pushFollow(FOLLOW_posfixa_in_novo796);
                    posfixa77=posfixa();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, posfixa77.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:111:19: ( ( 'new' ^) posfixa )
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(111,19);
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:111:19: ( ( 'new' ^) posfixa )
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:111:20: ( 'new' ^) posfixa
                    {
                    dbg.location(111,20);
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:111:20: ( 'new' ^)
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:111:21: 'new' ^
                    {
                    dbg.location(111,26);
                    string_literal78=(Token)match(input,68,FOLLOW_68_in_novo802); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal78_tree = 
                    (Object)adaptor.create(string_literal78)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(string_literal78_tree, root_0);
                    }

                    }

                    dbg.location(111,29);
                    pushFollow(FOLLOW_posfixa_in_novo806);
                    posfixa79=posfixa();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, posfixa79.getTree());

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(111, 37);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "novo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "novo"


    public static class posfixa_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "posfixa"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:113:1: posfixa : ( primaria -> primaria ) ( options {backtrack=true; } : '.' ID '(' listaExpressoes ')' -> ^( METHOD_CALL ^( '.' $posfixa ID ) listaExpressoes ) | '.' ID -> ^( '.' $posfixa ID ) | '(' listaExpressoes ')' -> ^( METHOD_CALL $posfixa listaExpressoes ) | '.' ID '[' expressao ']' -> ^( VECT_EXPR ^( '.' $posfixa ID ) expressao ) | '[' expressao ']' -> ^( VECT_EXPR $posfixa expressao ) )* ;
    public final JediParser.posfixa_return posfixa() throws RecognitionException {
        JediParser.posfixa_return retval = new JediParser.posfixa_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal81=null;
        Token ID82=null;
        Token char_literal83=null;
        Token char_literal85=null;
        Token char_literal86=null;
        Token ID87=null;
        Token char_literal88=null;
        Token char_literal90=null;
        Token char_literal91=null;
        Token ID92=null;
        Token char_literal93=null;
        Token char_literal95=null;
        Token char_literal96=null;
        Token char_literal98=null;
        JediParser.primaria_return primaria80 =null;

        JediParser.listaExpressoes_return listaExpressoes84 =null;

        JediParser.listaExpressoes_return listaExpressoes89 =null;

        JediParser.expressao_return expressao94 =null;

        JediParser.expressao_return expressao97 =null;


        Object char_literal81_tree=null;
        Object ID82_tree=null;
        Object char_literal83_tree=null;
        Object char_literal85_tree=null;
        Object char_literal86_tree=null;
        Object ID87_tree=null;
        Object char_literal88_tree=null;
        Object char_literal90_tree=null;
        Object char_literal91_tree=null;
        Object ID92_tree=null;
        Object char_literal93_tree=null;
        Object char_literal95_tree=null;
        Object char_literal96_tree=null;
        Object char_literal98_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
        RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_primaria=new RewriteRuleSubtreeStream(adaptor,"rule primaria");
        RewriteRuleSubtreeStream stream_listaExpressoes=new RewriteRuleSubtreeStream(adaptor,"rule listaExpressoes");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try { dbg.enterRule(getGrammarFileName(), "posfixa");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(113, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:114:5: ( ( primaria -> primaria ) ( options {backtrack=true; } : '.' ID '(' listaExpressoes ')' -> ^( METHOD_CALL ^( '.' $posfixa ID ) listaExpressoes ) | '.' ID -> ^( '.' $posfixa ID ) | '(' listaExpressoes ')' -> ^( METHOD_CALL $posfixa listaExpressoes ) | '.' ID '[' expressao ']' -> ^( VECT_EXPR ^( '.' $posfixa ID ) expressao ) | '[' expressao ']' -> ^( VECT_EXPR $posfixa expressao ) )* )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:114:9: ( primaria -> primaria ) ( options {backtrack=true; } : '.' ID '(' listaExpressoes ')' -> ^( METHOD_CALL ^( '.' $posfixa ID ) listaExpressoes ) | '.' ID -> ^( '.' $posfixa ID ) | '(' listaExpressoes ')' -> ^( METHOD_CALL $posfixa listaExpressoes ) | '.' ID '[' expressao ']' -> ^( VECT_EXPR ^( '.' $posfixa ID ) expressao ) | '[' expressao ']' -> ^( VECT_EXPR $posfixa expressao ) )*
            {
            dbg.location(114,9);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:114:9: ( primaria -> primaria )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:114:10: primaria
            {
            dbg.location(114,10);
            pushFollow(FOLLOW_primaria_in_posfixa824);
            primaria80=primaria();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_primaria.add(primaria80.getTree());

            // AST REWRITE
            // elements: primaria
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 114:18: -> primaria
            {
                dbg.location(114,20);
                adaptor.addChild(root_0, stream_primaria.nextTree());

            }


            retval.tree = root_0;
            }

            }

            dbg.location(115,6);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:115:6: ( options {backtrack=true; } : '.' ID '(' listaExpressoes ')' -> ^( METHOD_CALL ^( '.' $posfixa ID ) listaExpressoes ) | '.' ID -> ^( '.' $posfixa ID ) | '(' listaExpressoes ')' -> ^( METHOD_CALL $posfixa listaExpressoes ) | '.' ID '[' expressao ']' -> ^( VECT_EXPR ^( '.' $posfixa ID ) expressao ) | '[' expressao ']' -> ^( VECT_EXPR $posfixa expressao ) )*
            try { dbg.enterSubRule(26);

            loop26:
            do {
                int alt26=6;
                try { dbg.enterDecision(26, decisionCanBacktrack[26]);

                switch ( input.LA(1) ) {
                case 48:
                    {
                    int LA26_20 = input.LA(2);

                    if ( (synpred1_Jedi()) ) {
                        alt26=1;
                    }
                    else if ( (synpred2_Jedi()) ) {
                        alt26=2;
                    }
                    else if ( (synpred4_Jedi()) ) {
                        alt26=4;
                    }


                    }
                    break;
                case 40:
                    {
                    alt26=3;
                    }
                    break;
                case 57:
                    {
                    alt26=5;
                    }
                    break;

                }

                } finally {dbg.exitDecision(26);}

                switch (alt26) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:116:5: '.' ID '(' listaExpressoes ')'
            	    {
            	    dbg.location(116,5);
            	    char_literal81=(Token)match(input,48,FOLLOW_48_in_posfixa847); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_48.add(char_literal81);

            	    dbg.location(116,9);
            	    ID82=(Token)match(input,ID,FOLLOW_ID_in_posfixa849); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID82);

            	    dbg.location(116,12);
            	    char_literal83=(Token)match(input,40,FOLLOW_40_in_posfixa851); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_40.add(char_literal83);

            	    dbg.location(116,16);
            	    pushFollow(FOLLOW_listaExpressoes_in_posfixa853);
            	    listaExpressoes84=listaExpressoes();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_listaExpressoes.add(listaExpressoes84.getTree());
            	    dbg.location(116,32);
            	    char_literal85=(Token)match(input,41,FOLLOW_41_in_posfixa855); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_41.add(char_literal85);


            	    // AST REWRITE
            	    // elements: 48, posfixa, listaExpressoes, ID
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {

            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 116:36: -> ^( METHOD_CALL ^( '.' $posfixa ID ) listaExpressoes )
            	    {
            	        dbg.location(116,39);
            	        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:116:39: ^( METHOD_CALL ^( '.' $posfixa ID ) listaExpressoes )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        dbg.location(116,41);
            	        root_1 = (Object)adaptor.becomeRoot(
            	        (Object)adaptor.create(METHOD_CALL, "METHOD_CALL")
            	        , root_1);

            	        dbg.location(116,53);
            	        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:116:53: ^( '.' $posfixa ID )
            	        {
            	        Object root_2 = (Object)adaptor.nil();
            	        dbg.location(116,55);
            	        root_2 = (Object)adaptor.becomeRoot(
            	        stream_48.nextNode()
            	        , root_2);

            	        dbg.location(116,60);
            	        adaptor.addChild(root_2, stream_retval.nextTree());
            	        dbg.location(116,68);
            	        adaptor.addChild(root_2, 
            	        stream_ID.nextNode()
            	        );

            	        adaptor.addChild(root_1, root_2);
            	        }
            	        dbg.location(116,73);
            	        adaptor.addChild(root_1, stream_listaExpressoes.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }


            	    retval.tree = root_0;
            	    }

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:117:5: '.' ID
            	    {
            	    dbg.location(117,5);
            	    char_literal86=(Token)match(input,48,FOLLOW_48_in_posfixa879); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_48.add(char_literal86);

            	    dbg.location(117,9);
            	    ID87=(Token)match(input,ID,FOLLOW_ID_in_posfixa881); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID87);


            	    // AST REWRITE
            	    // elements: ID, posfixa, 48
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {

            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 117:19: -> ^( '.' $posfixa ID )
            	    {
            	        dbg.location(117,22);
            	        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:117:22: ^( '.' $posfixa ID )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        dbg.location(117,24);
            	        root_1 = (Object)adaptor.becomeRoot(
            	        stream_48.nextNode()
            	        , root_1);

            	        dbg.location(117,29);
            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        dbg.location(117,37);
            	        adaptor.addChild(root_1, 
            	        stream_ID.nextNode()
            	        );

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }


            	    retval.tree = root_0;
            	    }

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:118:5: '(' listaExpressoes ')'
            	    {
            	    dbg.location(118,5);
            	    char_literal88=(Token)match(input,40,FOLLOW_40_in_posfixa905); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_40.add(char_literal88);

            	    dbg.location(118,9);
            	    pushFollow(FOLLOW_listaExpressoes_in_posfixa907);
            	    listaExpressoes89=listaExpressoes();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_listaExpressoes.add(listaExpressoes89.getTree());
            	    dbg.location(118,25);
            	    char_literal90=(Token)match(input,41,FOLLOW_41_in_posfixa909); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_41.add(char_literal90);


            	    // AST REWRITE
            	    // elements: listaExpressoes, posfixa
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {

            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 118:36: -> ^( METHOD_CALL $posfixa listaExpressoes )
            	    {
            	        dbg.location(118,39);
            	        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:118:39: ^( METHOD_CALL $posfixa listaExpressoes )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        dbg.location(118,41);
            	        root_1 = (Object)adaptor.becomeRoot(
            	        (Object)adaptor.create(METHOD_CALL, "METHOD_CALL")
            	        , root_1);

            	        dbg.location(118,54);
            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        dbg.location(118,62);
            	        adaptor.addChild(root_1, stream_listaExpressoes.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }


            	    retval.tree = root_0;
            	    }

            	    }
            	    break;
            	case 4 :
            	    dbg.enterAlt(4);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:119:11: '.' ID '[' expressao ']'
            	    {
            	    dbg.location(119,11);
            	    char_literal91=(Token)match(input,48,FOLLOW_48_in_posfixa939); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_48.add(char_literal91);

            	    dbg.location(119,15);
            	    ID92=(Token)match(input,ID,FOLLOW_ID_in_posfixa941); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID92);

            	    dbg.location(119,18);
            	    char_literal93=(Token)match(input,57,FOLLOW_57_in_posfixa943); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_57.add(char_literal93);

            	    dbg.location(119,22);
            	    pushFollow(FOLLOW_expressao_in_posfixa945);
            	    expressao94=expressao();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expressao.add(expressao94.getTree());
            	    dbg.location(119,32);
            	    char_literal95=(Token)match(input,59,FOLLOW_59_in_posfixa947); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_59.add(char_literal95);


            	    // AST REWRITE
            	    // elements: posfixa, 48, ID, expressao
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {

            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 119:36: -> ^( VECT_EXPR ^( '.' $posfixa ID ) expressao )
            	    {
            	        dbg.location(119,39);
            	        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:119:39: ^( VECT_EXPR ^( '.' $posfixa ID ) expressao )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        dbg.location(119,41);
            	        root_1 = (Object)adaptor.becomeRoot(
            	        (Object)adaptor.create(VECT_EXPR, "VECT_EXPR")
            	        , root_1);

            	        dbg.location(119,51);
            	        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:119:51: ^( '.' $posfixa ID )
            	        {
            	        Object root_2 = (Object)adaptor.nil();
            	        dbg.location(119,53);
            	        root_2 = (Object)adaptor.becomeRoot(
            	        stream_48.nextNode()
            	        , root_2);

            	        dbg.location(119,58);
            	        adaptor.addChild(root_2, stream_retval.nextTree());
            	        dbg.location(119,66);
            	        adaptor.addChild(root_2, 
            	        stream_ID.nextNode()
            	        );

            	        adaptor.addChild(root_1, root_2);
            	        }
            	        dbg.location(119,71);
            	        adaptor.addChild(root_1, stream_expressao.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }


            	    retval.tree = root_0;
            	    }

            	    }
            	    break;
            	case 5 :
            	    dbg.enterAlt(5);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:120:11: '[' expressao ']'
            	    {
            	    dbg.location(120,11);
            	    char_literal96=(Token)match(input,57,FOLLOW_57_in_posfixa977); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_57.add(char_literal96);

            	    dbg.location(120,15);
            	    pushFollow(FOLLOW_expressao_in_posfixa979);
            	    expressao97=expressao();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expressao.add(expressao97.getTree());
            	    dbg.location(120,25);
            	    char_literal98=(Token)match(input,59,FOLLOW_59_in_posfixa981); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_59.add(char_literal98);


            	    // AST REWRITE
            	    // elements: posfixa, expressao
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {

            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 120:30: -> ^( VECT_EXPR $posfixa expressao )
            	    {
            	        dbg.location(120,33);
            	        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:120:33: ^( VECT_EXPR $posfixa expressao )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        dbg.location(120,35);
            	        root_1 = (Object)adaptor.becomeRoot(
            	        (Object)adaptor.create(VECT_EXPR, "VECT_EXPR")
            	        , root_1);

            	        dbg.location(120,46);
            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        dbg.location(120,54);
            	        adaptor.addChild(root_1, stream_expressao.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }


            	    retval.tree = root_0;
            	    }

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);
            } finally {dbg.exitSubRule(26);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(122, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "posfixa");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "posfixa"


    public static class listaExpressoes_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaExpressoes"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:124:1: listaExpressoes : expressao ( ',' expressao )* -> ^( LISTA_EXPR ( expressao )+ ) ;
    public final JediParser.listaExpressoes_return listaExpressoes() throws RecognitionException {
        JediParser.listaExpressoes_return retval = new JediParser.listaExpressoes_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal100=null;
        JediParser.expressao_return expressao99 =null;

        JediParser.expressao_return expressao101 =null;


        Object char_literal100_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try { dbg.enterRule(getGrammarFileName(), "listaExpressoes");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(124, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:125:5: ( expressao ( ',' expressao )* -> ^( LISTA_EXPR ( expressao )+ ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:125:9: expressao ( ',' expressao )*
            {
            dbg.location(125,9);
            pushFollow(FOLLOW_expressao_in_listaExpressoes1016);
            expressao99=expressao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expressao.add(expressao99.getTree());
            dbg.location(125,19);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:125:19: ( ',' expressao )*
            try { dbg.enterSubRule(27);

            loop27:
            do {
                int alt27=2;
                try { dbg.enterDecision(27, decisionCanBacktrack[27]);

                int LA27_0 = input.LA(1);

                if ( (LA27_0==45) ) {
                    alt27=1;
                }


                } finally {dbg.exitDecision(27);}

                switch (alt27) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:125:20: ',' expressao
            	    {
            	    dbg.location(125,20);
            	    char_literal100=(Token)match(input,45,FOLLOW_45_in_listaExpressoes1019); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_45.add(char_literal100);

            	    dbg.location(125,24);
            	    pushFollow(FOLLOW_expressao_in_listaExpressoes1021);
            	    expressao101=expressao();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_expressao.add(expressao101.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);
            } finally {dbg.exitSubRule(27);}


            // AST REWRITE
            // elements: expressao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 125:36: -> ^( LISTA_EXPR ( expressao )+ )
            {
                dbg.location(125,39);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:125:39: ^( LISTA_EXPR ( expressao )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(125,41);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(LISTA_EXPR, "LISTA_EXPR")
                , root_1);

                dbg.location(125,52);
                if ( !(stream_expressao.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_expressao.hasNext() ) {
                    dbg.location(125,52);
                    adaptor.addChild(root_1, stream_expressao.nextTree());

                }
                stream_expressao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(126, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "listaExpressoes");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "listaExpressoes"


    public static class primaria_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "primaria"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:129:1: primaria : ( INT | ID -> ID | 'int' -> 'int' | '-' ^ ID | incremento | '(' expressao ')' -> expressao );
    public final JediParser.primaria_return primaria() throws RecognitionException {
        JediParser.primaria_return retval = new JediParser.primaria_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token INT102=null;
        Token ID103=null;
        Token string_literal104=null;
        Token char_literal105=null;
        Token ID106=null;
        Token char_literal108=null;
        Token char_literal110=null;
        JediParser.incremento_return incremento107 =null;

        JediParser.expressao_return expressao109 =null;


        Object INT102_tree=null;
        Object ID103_tree=null;
        Object string_literal104_tree=null;
        Object char_literal105_tree=null;
        Object ID106_tree=null;
        Object char_literal108_tree=null;
        Object char_literal110_tree=null;
        RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try { dbg.enterRule(getGrammarFileName(), "primaria");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(129, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:130:5: ( INT | ID -> ID | 'int' -> 'int' | '-' ^ ID | incremento | '(' expressao ')' -> expressao )
            int alt28=6;
            try { dbg.enterDecision(28, decisionCanBacktrack[28]);

            try {
                isCyclicDecision = true;
                alt28 = dfa28.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(28);}

            switch (alt28) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:130:9: INT
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(130,9);
                    INT102=(Token)match(input,INT,FOLLOW_INT_in_primaria1052); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INT102_tree = 
                    (Object)adaptor.create(INT102)
                    ;
                    adaptor.addChild(root_0, INT102_tree);
                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:131:9: ID
                    {
                    dbg.location(131,9);
                    ID103=(Token)match(input,ID,FOLLOW_ID_in_primaria1065); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID103);


                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 131:12: -> ID
                    {
                        dbg.location(131,15);
                        adaptor.addChild(root_0, 
                        stream_ID.nextNode()
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:132:9: 'int'
                    {
                    dbg.location(132,9);
                    string_literal104=(Token)match(input,67,FOLLOW_67_in_primaria1079); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_67.add(string_literal104);


                    // AST REWRITE
                    // elements: 67
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 132:15: -> 'int'
                    {
                        dbg.location(132,18);
                        adaptor.addChild(root_0, 
                        stream_67.nextNode()
                        );

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:135:9: '-' ^ ID
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(135,12);
                    char_literal105=(Token)match(input,46,FOLLOW_46_in_primaria1103); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal105_tree = 
                    (Object)adaptor.create(char_literal105)
                    ;
                    root_0 = (Object)adaptor.becomeRoot(char_literal105_tree, root_0);
                    }
                    dbg.location(135,14);
                    ID106=(Token)match(input,ID,FOLLOW_ID_in_primaria1106); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ID106_tree = 
                    (Object)adaptor.create(ID106)
                    ;
                    adaptor.addChild(root_0, ID106_tree);
                    }

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:136:7: incremento
                    {
                    root_0 = (Object)adaptor.nil();


                    dbg.location(136,7);
                    pushFollow(FOLLOW_incremento_in_primaria1114);
                    incremento107=incremento();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, incremento107.getTree());

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:137:9: '(' expressao ')'
                    {
                    dbg.location(137,9);
                    char_literal108=(Token)match(input,40,FOLLOW_40_in_primaria1124); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_40.add(char_literal108);

                    dbg.location(137,13);
                    pushFollow(FOLLOW_expressao_in_primaria1126);
                    expressao109=expressao();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expressao.add(expressao109.getTree());
                    dbg.location(137,22);
                    char_literal110=(Token)match(input,41,FOLLOW_41_in_primaria1127); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_41.add(char_literal110);


                    // AST REWRITE
                    // elements: expressao
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 137:26: -> expressao
                    {
                        dbg.location(137,29);
                        adaptor.addChild(root_0, stream_expressao.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(138, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "primaria");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "primaria"


    public static class incremento_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "incremento"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:142:1: incremento : ( '--' ID ( '.' ID )* -> ^( PRE_DECREMENTO ( ID )+ ) | '++' ID ( '.' ID )* -> ^( PRE_INCREMENTO ( ID )+ ) | ID ( '.' ID )* '--' -> ^( POS_DECREMENTO ( ID )+ ) | ID ( '.' ID )* '++' -> ^( POS_INCREMENTO ( ID )+ ) );
    public final JediParser.incremento_return incremento() throws RecognitionException {
        JediParser.incremento_return retval = new JediParser.incremento_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal111=null;
        Token ID112=null;
        Token char_literal113=null;
        Token ID114=null;
        Token string_literal115=null;
        Token ID116=null;
        Token char_literal117=null;
        Token ID118=null;
        Token ID119=null;
        Token char_literal120=null;
        Token ID121=null;
        Token string_literal122=null;
        Token ID123=null;
        Token char_literal124=null;
        Token ID125=null;
        Token string_literal126=null;

        Object string_literal111_tree=null;
        Object ID112_tree=null;
        Object char_literal113_tree=null;
        Object ID114_tree=null;
        Object string_literal115_tree=null;
        Object ID116_tree=null;
        Object char_literal117_tree=null;
        Object ID118_tree=null;
        Object ID119_tree=null;
        Object char_literal120_tree=null;
        Object ID121_tree=null;
        Object string_literal122_tree=null;
        Object ID123_tree=null;
        Object char_literal124_tree=null;
        Object ID125_tree=null;
        Object string_literal126_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");

        try { dbg.enterRule(getGrammarFileName(), "incremento");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(142, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:142:12: ( '--' ID ( '.' ID )* -> ^( PRE_DECREMENTO ( ID )+ ) | '++' ID ( '.' ID )* -> ^( PRE_INCREMENTO ( ID )+ ) | ID ( '.' ID )* '--' -> ^( POS_DECREMENTO ( ID )+ ) | ID ( '.' ID )* '++' -> ^( POS_INCREMENTO ( ID )+ ) )
            int alt33=4;
            try { dbg.enterDecision(33, decisionCanBacktrack[33]);

            try {
                isCyclicDecision = true;
                alt33 = dfa33.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(33);}

            switch (alt33) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:142:15: '--' ID ( '.' ID )*
                    {
                    dbg.location(142,15);
                    string_literal111=(Token)match(input,47,FOLLOW_47_in_incremento1147); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal111);

                    dbg.location(142,20);
                    ID112=(Token)match(input,ID,FOLLOW_ID_in_incremento1149); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID112);

                    dbg.location(142,23);
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:142:23: ( '.' ID )*
                    try { dbg.enterSubRule(29);

                    loop29:
                    do {
                        int alt29=2;
                        try { dbg.enterDecision(29, decisionCanBacktrack[29]);

                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==48) ) {
                            int LA29_1 = input.LA(2);

                            if ( (LA29_1==ID) ) {
                                alt29=1;
                            }


                        }


                        } finally {dbg.exitDecision(29);}

                        switch (alt29) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:142:24: '.' ID
                    	    {
                    	    dbg.location(142,24);
                    	    char_literal113=(Token)match(input,48,FOLLOW_48_in_incremento1152); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_48.add(char_literal113);

                    	    dbg.location(142,27);
                    	    ID114=(Token)match(input,ID,FOLLOW_ID_in_incremento1153); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID114);


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(29);}


                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 142:32: -> ^( PRE_DECREMENTO ( ID )+ )
                    {
                        dbg.location(142,35);
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:142:35: ^( PRE_DECREMENTO ( ID )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(142,37);
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(PRE_DECREMENTO, "PRE_DECREMENTO")
                        , root_1);

                        dbg.location(142,52);
                        if ( !(stream_ID.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_ID.hasNext() ) {
                            dbg.location(142,52);
                            adaptor.addChild(root_1, 
                            stream_ID.nextNode()
                            );

                        }
                        stream_ID.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:143:12: '++' ID ( '.' ID )*
                    {
                    dbg.location(143,12);
                    string_literal115=(Token)match(input,44,FOLLOW_44_in_incremento1177); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(string_literal115);

                    dbg.location(143,17);
                    ID116=(Token)match(input,ID,FOLLOW_ID_in_incremento1179); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID116);

                    dbg.location(143,20);
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:143:20: ( '.' ID )*
                    try { dbg.enterSubRule(30);

                    loop30:
                    do {
                        int alt30=2;
                        try { dbg.enterDecision(30, decisionCanBacktrack[30]);

                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==48) ) {
                            int LA30_1 = input.LA(2);

                            if ( (LA30_1==ID) ) {
                                alt30=1;
                            }


                        }


                        } finally {dbg.exitDecision(30);}

                        switch (alt30) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:143:21: '.' ID
                    	    {
                    	    dbg.location(143,21);
                    	    char_literal117=(Token)match(input,48,FOLLOW_48_in_incremento1182); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_48.add(char_literal117);

                    	    dbg.location(143,24);
                    	    ID118=(Token)match(input,ID,FOLLOW_ID_in_incremento1183); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID118);


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(30);}


                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 143:29: -> ^( PRE_INCREMENTO ( ID )+ )
                    {
                        dbg.location(143,32);
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:143:32: ^( PRE_INCREMENTO ( ID )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(143,34);
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(PRE_INCREMENTO, "PRE_INCREMENTO")
                        , root_1);

                        dbg.location(143,49);
                        if ( !(stream_ID.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_ID.hasNext() ) {
                            dbg.location(143,49);
                            adaptor.addChild(root_1, 
                            stream_ID.nextNode()
                            );

                        }
                        stream_ID.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:144:16: ID ( '.' ID )* '--'
                    {
                    dbg.location(144,16);
                    ID119=(Token)match(input,ID,FOLLOW_ID_in_incremento1211); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID119);

                    dbg.location(144,19);
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:144:19: ( '.' ID )*
                    try { dbg.enterSubRule(31);

                    loop31:
                    do {
                        int alt31=2;
                        try { dbg.enterDecision(31, decisionCanBacktrack[31]);

                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==48) ) {
                            alt31=1;
                        }


                        } finally {dbg.exitDecision(31);}

                        switch (alt31) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:144:20: '.' ID
                    	    {
                    	    dbg.location(144,20);
                    	    char_literal120=(Token)match(input,48,FOLLOW_48_in_incremento1214); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_48.add(char_literal120);

                    	    dbg.location(144,23);
                    	    ID121=(Token)match(input,ID,FOLLOW_ID_in_incremento1215); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID121);


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(31);}

                    dbg.location(144,28);
                    string_literal122=(Token)match(input,47,FOLLOW_47_in_incremento1219); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_47.add(string_literal122);


                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 144:33: -> ^( POS_DECREMENTO ( ID )+ )
                    {
                        dbg.location(144,36);
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:144:36: ^( POS_DECREMENTO ( ID )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(144,38);
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(POS_DECREMENTO, "POS_DECREMENTO")
                        , root_1);

                        dbg.location(144,53);
                        if ( !(stream_ID.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_ID.hasNext() ) {
                            dbg.location(144,53);
                            adaptor.addChild(root_1, 
                            stream_ID.nextNode()
                            );

                        }
                        stream_ID.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:145:16: ID ( '.' ID )* '++'
                    {
                    dbg.location(145,16);
                    ID123=(Token)match(input,ID,FOLLOW_ID_in_incremento1245); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ID.add(ID123);

                    dbg.location(145,19);
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:145:19: ( '.' ID )*
                    try { dbg.enterSubRule(32);

                    loop32:
                    do {
                        int alt32=2;
                        try { dbg.enterDecision(32, decisionCanBacktrack[32]);

                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==48) ) {
                            alt32=1;
                        }


                        } finally {dbg.exitDecision(32);}

                        switch (alt32) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:145:20: '.' ID
                    	    {
                    	    dbg.location(145,20);
                    	    char_literal124=(Token)match(input,48,FOLLOW_48_in_incremento1248); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_48.add(char_literal124);

                    	    dbg.location(145,23);
                    	    ID125=(Token)match(input,ID,FOLLOW_ID_in_incremento1249); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_ID.add(ID125);


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(32);}

                    dbg.location(145,28);
                    string_literal126=(Token)match(input,44,FOLLOW_44_in_incremento1253); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_44.add(string_literal126);


                    // AST REWRITE
                    // elements: ID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 145:33: -> ^( POS_INCREMENTO ( ID )+ )
                    {
                        dbg.location(145,36);
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:145:36: ^( POS_INCREMENTO ( ID )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(145,38);
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(POS_INCREMENTO, "POS_INCREMENTO")
                        , root_1);

                        dbg.location(145,53);
                        if ( !(stream_ID.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_ID.hasNext() ) {
                            dbg.location(145,53);
                            adaptor.addChild(root_1, 
                            stream_ID.nextNode()
                            );

                        }
                        stream_ID.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(146, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "incremento");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "incremento"


    public static class chamadaMetodo_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "chamadaMetodo"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:148:1: chamadaMetodo : ID ( options {backtrack=true; } : '.' ID '(' listaExpressoes ')' -> ^( METHOD_CALL ^( '.' $chamadaMetodo ID ) listaExpressoes ) | '(' listaExpressoes ')' -> ^( METHOD_CALL $chamadaMetodo listaExpressoes ) )+ ;
    public final JediParser.chamadaMetodo_return chamadaMetodo() throws RecognitionException {
        JediParser.chamadaMetodo_return retval = new JediParser.chamadaMetodo_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token ID127=null;
        Token char_literal128=null;
        Token ID129=null;
        Token char_literal130=null;
        Token char_literal132=null;
        Token char_literal133=null;
        Token char_literal135=null;
        JediParser.listaExpressoes_return listaExpressoes131 =null;

        JediParser.listaExpressoes_return listaExpressoes134 =null;


        Object ID127_tree=null;
        Object char_literal128_tree=null;
        Object ID129_tree=null;
        Object char_literal130_tree=null;
        Object char_literal132_tree=null;
        Object char_literal133_tree=null;
        Object char_literal135_tree=null;
        RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleSubtreeStream stream_listaExpressoes=new RewriteRuleSubtreeStream(adaptor,"rule listaExpressoes");
        try { dbg.enterRule(getGrammarFileName(), "chamadaMetodo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(148, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:149:5: ( ID ( options {backtrack=true; } : '.' ID '(' listaExpressoes ')' -> ^( METHOD_CALL ^( '.' $chamadaMetodo ID ) listaExpressoes ) | '(' listaExpressoes ')' -> ^( METHOD_CALL $chamadaMetodo listaExpressoes ) )+ )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:149:9: ID ( options {backtrack=true; } : '.' ID '(' listaExpressoes ')' -> ^( METHOD_CALL ^( '.' $chamadaMetodo ID ) listaExpressoes ) | '(' listaExpressoes ')' -> ^( METHOD_CALL $chamadaMetodo listaExpressoes ) )+
            {
            dbg.location(149,9);
            ID127=(Token)match(input,ID,FOLLOW_ID_in_chamadaMetodo1285); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID127);

            dbg.location(150,6);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:150:6: ( options {backtrack=true; } : '.' ID '(' listaExpressoes ')' -> ^( METHOD_CALL ^( '.' $chamadaMetodo ID ) listaExpressoes ) | '(' listaExpressoes ')' -> ^( METHOD_CALL $chamadaMetodo listaExpressoes ) )+
            int cnt34=0;
            try { dbg.enterSubRule(34);

            loop34:
            do {
                int alt34=3;
                try { dbg.enterDecision(34, decisionCanBacktrack[34]);

                int LA34_0 = input.LA(1);

                if ( (LA34_0==48) ) {
                    alt34=1;
                }
                else if ( (LA34_0==40) ) {
                    alt34=2;
                }


                } finally {dbg.exitDecision(34);}

                switch (alt34) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:151:5: '.' ID '(' listaExpressoes ')'
            	    {
            	    dbg.location(151,5);
            	    char_literal128=(Token)match(input,48,FOLLOW_48_in_chamadaMetodo1305); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_48.add(char_literal128);

            	    dbg.location(151,9);
            	    ID129=(Token)match(input,ID,FOLLOW_ID_in_chamadaMetodo1307); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_ID.add(ID129);

            	    dbg.location(151,12);
            	    char_literal130=(Token)match(input,40,FOLLOW_40_in_chamadaMetodo1309); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_40.add(char_literal130);

            	    dbg.location(151,16);
            	    pushFollow(FOLLOW_listaExpressoes_in_chamadaMetodo1311);
            	    listaExpressoes131=listaExpressoes();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_listaExpressoes.add(listaExpressoes131.getTree());
            	    dbg.location(151,32);
            	    char_literal132=(Token)match(input,41,FOLLOW_41_in_chamadaMetodo1313); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_41.add(char_literal132);


            	    // AST REWRITE
            	    // elements: 48, chamadaMetodo, ID, listaExpressoes
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {

            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 151:36: -> ^( METHOD_CALL ^( '.' $chamadaMetodo ID ) listaExpressoes )
            	    {
            	        dbg.location(151,39);
            	        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:151:39: ^( METHOD_CALL ^( '.' $chamadaMetodo ID ) listaExpressoes )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        dbg.location(151,41);
            	        root_1 = (Object)adaptor.becomeRoot(
            	        (Object)adaptor.create(METHOD_CALL, "METHOD_CALL")
            	        , root_1);

            	        dbg.location(151,53);
            	        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:151:53: ^( '.' $chamadaMetodo ID )
            	        {
            	        Object root_2 = (Object)adaptor.nil();
            	        dbg.location(151,55);
            	        root_2 = (Object)adaptor.becomeRoot(
            	        stream_48.nextNode()
            	        , root_2);

            	        dbg.location(151,60);
            	        adaptor.addChild(root_2, stream_retval.nextTree());
            	        dbg.location(151,74);
            	        adaptor.addChild(root_2, 
            	        stream_ID.nextNode()
            	        );

            	        adaptor.addChild(root_1, root_2);
            	        }
            	        dbg.location(151,79);
            	        adaptor.addChild(root_1, stream_listaExpressoes.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }


            	    retval.tree = root_0;
            	    }

            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:152:5: '(' listaExpressoes ')'
            	    {
            	    dbg.location(152,5);
            	    char_literal133=(Token)match(input,40,FOLLOW_40_in_chamadaMetodo1337); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_40.add(char_literal133);

            	    dbg.location(152,9);
            	    pushFollow(FOLLOW_listaExpressoes_in_chamadaMetodo1339);
            	    listaExpressoes134=listaExpressoes();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_listaExpressoes.add(listaExpressoes134.getTree());
            	    dbg.location(152,25);
            	    char_literal135=(Token)match(input,41,FOLLOW_41_in_chamadaMetodo1341); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_41.add(char_literal135);


            	    // AST REWRITE
            	    // elements: chamadaMetodo, listaExpressoes
            	    // token labels: 
            	    // rule labels: retval
            	    // token list labels: 
            	    // rule list labels: 
            	    // wildcard labels: 
            	    if ( state.backtracking==0 ) {

            	    retval.tree = root_0;
            	    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            	    root_0 = (Object)adaptor.nil();
            	    // 152:36: -> ^( METHOD_CALL $chamadaMetodo listaExpressoes )
            	    {
            	        dbg.location(152,39);
            	        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:152:39: ^( METHOD_CALL $chamadaMetodo listaExpressoes )
            	        {
            	        Object root_1 = (Object)adaptor.nil();
            	        dbg.location(152,41);
            	        root_1 = (Object)adaptor.becomeRoot(
            	        (Object)adaptor.create(METHOD_CALL, "METHOD_CALL")
            	        , root_1);

            	        dbg.location(152,54);
            	        adaptor.addChild(root_1, stream_retval.nextTree());
            	        dbg.location(152,68);
            	        adaptor.addChild(root_1, stream_listaExpressoes.nextTree());

            	        adaptor.addChild(root_0, root_1);
            	        }

            	    }


            	    retval.tree = root_0;
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt34++;
            } while (true);
            } finally {dbg.exitSubRule(34);}


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(154, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "chamadaMetodo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "chamadaMetodo"


    public static class varDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "varDecl"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:156:1: varDecl : tipo ID (vet= '[]' )? ( '=' expressao )? -> ^( VAR_DECL tipo ID ( $vet)? ( expressao )? ) ;
    public final JediParser.varDecl_return varDecl() throws RecognitionException {
        JediParser.varDecl_return retval = new JediParser.varDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token vet=null;
        Token ID137=null;
        Token char_literal138=null;
        JediParser.tipo_return tipo136 =null;

        JediParser.expressao_return expressao139 =null;


        Object vet_tree=null;
        Object ID137_tree=null;
        Object char_literal138_tree=null;
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_tipo=new RewriteRuleSubtreeStream(adaptor,"rule tipo");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try { dbg.enterRule(getGrammarFileName(), "varDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(156, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:157:5: ( tipo ID (vet= '[]' )? ( '=' expressao )? -> ^( VAR_DECL tipo ID ( $vet)? ( expressao )? ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:157:9: tipo ID (vet= '[]' )? ( '=' expressao )?
            {
            dbg.location(157,9);
            pushFollow(FOLLOW_tipo_in_varDecl1383);
            tipo136=tipo();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tipo.add(tipo136.getTree());
            dbg.location(157,14);
            ID137=(Token)match(input,ID,FOLLOW_ID_in_varDecl1385); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID137);

            dbg.location(157,21);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:157:21: (vet= '[]' )?
            int alt35=2;
            try { dbg.enterSubRule(35);
            try { dbg.enterDecision(35, decisionCanBacktrack[35]);

            int LA35_0 = input.LA(1);

            if ( (LA35_0==58) ) {
                alt35=1;
            }
            } finally {dbg.exitDecision(35);}

            switch (alt35) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:157:21: vet= '[]'
                    {
                    dbg.location(157,21);
                    vet=(Token)match(input,58,FOLLOW_58_in_varDecl1390); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(vet);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(35);}

            dbg.location(157,28);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:157:28: ( '=' expressao )?
            int alt36=2;
            try { dbg.enterSubRule(36);
            try { dbg.enterDecision(36, decisionCanBacktrack[36]);

            int LA36_0 = input.LA(1);

            if ( (LA36_0==53) ) {
                alt36=1;
            }
            } finally {dbg.exitDecision(36);}

            switch (alt36) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:157:29: '=' expressao
                    {
                    dbg.location(157,29);
                    char_literal138=(Token)match(input,53,FOLLOW_53_in_varDecl1394); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(char_literal138);

                    dbg.location(157,33);
                    pushFollow(FOLLOW_expressao_in_varDecl1396);
                    expressao139=expressao();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expressao.add(expressao139.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(36);}


            // AST REWRITE
            // elements: vet, tipo, ID, expressao
            // token labels: vet
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_vet=new RewriteRuleTokenStream(adaptor,"token vet",vet);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 158:5: -> ^( VAR_DECL tipo ID ( $vet)? ( expressao )? )
            {
                dbg.location(158,8);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:158:8: ^( VAR_DECL tipo ID ( $vet)? ( expressao )? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(158,10);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(VAR_DECL, "VAR_DECL")
                , root_1);

                dbg.location(158,19);
                adaptor.addChild(root_1, stream_tipo.nextTree());
                dbg.location(158,24);
                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );
                dbg.location(158,28);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:158:28: ( $vet)?
                if ( stream_vet.hasNext() ) {
                    dbg.location(158,28);
                    adaptor.addChild(root_1, stream_vet.nextNode());

                }
                stream_vet.reset();
                dbg.location(158,33);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:158:33: ( expressao )?
                if ( stream_expressao.hasNext() ) {
                    dbg.location(158,33);
                    adaptor.addChild(root_1, stream_expressao.nextTree());

                }
                stream_expressao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(159, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "varDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "varDecl"


    public static class listaVarDecl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "listaVarDecl"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:162:1: listaVarDecl : varDecl ( varDeclLista )* -> ^( LISTA_VAR_DECL varDecl ( varDeclLista )* ) ;
    public final JediParser.listaVarDecl_return listaVarDecl() throws RecognitionException {
        JediParser.listaVarDecl_return retval = new JediParser.listaVarDecl_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        JediParser.varDecl_return varDecl140 =null;

        JediParser.varDeclLista_return varDeclLista141 =null;


        RewriteRuleSubtreeStream stream_varDeclLista=new RewriteRuleSubtreeStream(adaptor,"rule varDeclLista");
        RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");
        try { dbg.enterRule(getGrammarFileName(), "listaVarDecl");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(162, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:162:14: ( varDecl ( varDeclLista )* -> ^( LISTA_VAR_DECL varDecl ( varDeclLista )* ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:162:16: varDecl ( varDeclLista )*
            {
            dbg.location(162,16);
            pushFollow(FOLLOW_varDecl_in_listaVarDecl1443);
            varDecl140=varDecl();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_varDecl.add(varDecl140.getTree());
            dbg.location(162,24);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:162:24: ( varDeclLista )*
            try { dbg.enterSubRule(37);

            loop37:
            do {
                int alt37=2;
                try { dbg.enterDecision(37, decisionCanBacktrack[37]);

                int LA37_0 = input.LA(1);

                if ( (LA37_0==45) ) {
                    alt37=1;
                }


                } finally {dbg.exitDecision(37);}

                switch (alt37) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:162:25: varDeclLista
            	    {
            	    dbg.location(162,25);
            	    pushFollow(FOLLOW_varDeclLista_in_listaVarDecl1446);
            	    varDeclLista141=varDeclLista();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_varDeclLista.add(varDeclLista141.getTree());

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);
            } finally {dbg.exitSubRule(37);}


            // AST REWRITE
            // elements: varDecl, varDeclLista
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 163:7: -> ^( LISTA_VAR_DECL varDecl ( varDeclLista )* )
            {
                dbg.location(163,10);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:163:10: ^( LISTA_VAR_DECL varDecl ( varDeclLista )* )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(163,12);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(LISTA_VAR_DECL, "LISTA_VAR_DECL")
                , root_1);

                dbg.location(163,27);
                adaptor.addChild(root_1, stream_varDecl.nextTree());
                dbg.location(163,35);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:163:35: ( varDeclLista )*
                while ( stream_varDeclLista.hasNext() ) {
                    dbg.location(163,35);
                    adaptor.addChild(root_1, stream_varDeclLista.nextTree());

                }
                stream_varDeclLista.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(164, 6);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "listaVarDecl");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "listaVarDecl"


    public static class varDeclLista_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "varDeclLista"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:166:1: varDeclLista : ',' ID (vet= '[]' )? ( '=' expressao )? -> ^( VAR_DECL_LISTA ID ( $vet)? ( expressao )? ) ;
    public final JediParser.varDeclLista_return varDeclLista() throws RecognitionException {
        JediParser.varDeclLista_return retval = new JediParser.varDeclLista_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token vet=null;
        Token char_literal142=null;
        Token ID143=null;
        Token char_literal144=null;
        JediParser.expressao_return expressao145 =null;


        Object vet_tree=null;
        Object char_literal142_tree=null;
        Object ID143_tree=null;
        Object char_literal144_tree=null;
        RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
        RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try { dbg.enterRule(getGrammarFileName(), "varDeclLista");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(166, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:166:14: ( ',' ID (vet= '[]' )? ( '=' expressao )? -> ^( VAR_DECL_LISTA ID ( $vet)? ( expressao )? ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:166:16: ',' ID (vet= '[]' )? ( '=' expressao )?
            {
            dbg.location(166,16);
            char_literal142=(Token)match(input,45,FOLLOW_45_in_varDeclLista1488); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_45.add(char_literal142);

            dbg.location(166,20);
            ID143=(Token)match(input,ID,FOLLOW_ID_in_varDeclLista1490); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ID.add(ID143);

            dbg.location(166,27);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:166:27: (vet= '[]' )?
            int alt38=2;
            try { dbg.enterSubRule(38);
            try { dbg.enterDecision(38, decisionCanBacktrack[38]);

            int LA38_0 = input.LA(1);

            if ( (LA38_0==58) ) {
                alt38=1;
            }
            } finally {dbg.exitDecision(38);}

            switch (alt38) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:166:27: vet= '[]'
                    {
                    dbg.location(166,27);
                    vet=(Token)match(input,58,FOLLOW_58_in_varDeclLista1496); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_58.add(vet);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(38);}

            dbg.location(166,35);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:166:35: ( '=' expressao )?
            int alt39=2;
            try { dbg.enterSubRule(39);
            try { dbg.enterDecision(39, decisionCanBacktrack[39]);

            int LA39_0 = input.LA(1);

            if ( (LA39_0==53) ) {
                alt39=1;
            }
            } finally {dbg.exitDecision(39);}

            switch (alt39) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:166:36: '=' expressao
                    {
                    dbg.location(166,36);
                    char_literal144=(Token)match(input,53,FOLLOW_53_in_varDeclLista1500); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_53.add(char_literal144);

                    dbg.location(166,40);
                    pushFollow(FOLLOW_expressao_in_varDeclLista1502);
                    expressao145=expressao();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expressao.add(expressao145.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(39);}


            // AST REWRITE
            // elements: expressao, vet, ID
            // token labels: vet
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleTokenStream stream_vet=new RewriteRuleTokenStream(adaptor,"token vet",vet);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 167:7: -> ^( VAR_DECL_LISTA ID ( $vet)? ( expressao )? )
            {
                dbg.location(167,10);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:167:10: ^( VAR_DECL_LISTA ID ( $vet)? ( expressao )? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(167,12);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(VAR_DECL_LISTA, "VAR_DECL_LISTA")
                , root_1);

                dbg.location(167,27);
                adaptor.addChild(root_1, 
                stream_ID.nextNode()
                );
                dbg.location(167,31);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:167:31: ( $vet)?
                if ( stream_vet.hasNext() ) {
                    dbg.location(167,31);
                    adaptor.addChild(root_1, stream_vet.nextNode());

                }
                stream_vet.reset();
                dbg.location(167,36);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:167:36: ( expressao )?
                if ( stream_expressao.hasNext() ) {
                    dbg.location(167,36);
                    adaptor.addChild(root_1, stream_expressao.nextTree());

                }
                stream_expressao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(168, 6);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "varDeclLista");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "varDeclLista"


    public static class tipo_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tipo"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:170:1: tipo : ( 'int' | ID );
    public final JediParser.tipo_return tipo() throws RecognitionException {
        JediParser.tipo_return retval = new JediParser.tipo_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token set146=null;

        Object set146_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "tipo");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(170, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:170:5: ( 'int' | ID )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:
            {
            root_0 = (Object)adaptor.nil();


            dbg.location(170,5);
            set146=(Token)input.LT(1);

            if ( input.LA(1)==ID||input.LA(1)==67 ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (Object)adaptor.create(set146)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(172, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "tipo");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "tipo"


    public static class ifStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStatement"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:174:1: ifStatement : 'if' '(' expressao ')' instrucao ( elseIf )? -> ^( IF expressao instrucao ( elseIf )? ) ;
    public final JediParser.ifStatement_return ifStatement() throws RecognitionException {
        JediParser.ifStatement_return retval = new JediParser.ifStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal147=null;
        Token char_literal148=null;
        Token char_literal150=null;
        JediParser.expressao_return expressao149 =null;

        JediParser.instrucao_return instrucao151 =null;

        JediParser.elseIf_return elseIf152 =null;


        Object string_literal147_tree=null;
        Object char_literal148_tree=null;
        Object char_literal150_tree=null;
        RewriteRuleTokenStream stream_66=new RewriteRuleTokenStream(adaptor,"token 66");
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleSubtreeStream stream_elseIf=new RewriteRuleSubtreeStream(adaptor,"rule elseIf");
        RewriteRuleSubtreeStream stream_instrucao=new RewriteRuleSubtreeStream(adaptor,"rule instrucao");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try { dbg.enterRule(getGrammarFileName(), "ifStatement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(174, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:174:14: ( 'if' '(' expressao ')' instrucao ( elseIf )? -> ^( IF expressao instrucao ( elseIf )? ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:174:16: 'if' '(' expressao ')' instrucao ( elseIf )?
            {
            dbg.location(174,16);
            string_literal147=(Token)match(input,66,FOLLOW_66_in_ifStatement1576); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_66.add(string_literal147);

            dbg.location(174,21);
            char_literal148=(Token)match(input,40,FOLLOW_40_in_ifStatement1578); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal148);

            dbg.location(174,25);
            pushFollow(FOLLOW_expressao_in_ifStatement1580);
            expressao149=expressao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expressao.add(expressao149.getTree());
            dbg.location(174,35);
            char_literal150=(Token)match(input,41,FOLLOW_41_in_ifStatement1582); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal150);

            dbg.location(174,39);
            pushFollow(FOLLOW_instrucao_in_ifStatement1584);
            instrucao151=instrucao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_instrucao.add(instrucao151.getTree());
            dbg.location(174,49);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:174:49: ( elseIf )?
            int alt40=2;
            try { dbg.enterSubRule(40);
            try { dbg.enterDecision(40, decisionCanBacktrack[40]);

            int LA40_0 = input.LA(1);

            if ( (LA40_0==63) ) {
                alt40=1;
            }
            } finally {dbg.exitDecision(40);}

            switch (alt40) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:174:49: elseIf
                    {
                    dbg.location(174,49);
                    pushFollow(FOLLOW_elseIf_in_ifStatement1586);
                    elseIf152=elseIf();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elseIf.add(elseIf152.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(40);}


            // AST REWRITE
            // elements: elseIf, expressao, instrucao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 175:7: -> ^( IF expressao instrucao ( elseIf )? )
            {
                dbg.location(175,10);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:175:10: ^( IF expressao instrucao ( elseIf )? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(175,12);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(IF, "IF")
                , root_1);

                dbg.location(175,15);
                adaptor.addChild(root_1, stream_expressao.nextTree());
                dbg.location(175,25);
                adaptor.addChild(root_1, stream_instrucao.nextTree());
                dbg.location(175,35);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:175:35: ( elseIf )?
                if ( stream_elseIf.hasNext() ) {
                    dbg.location(175,35);
                    adaptor.addChild(root_1, stream_elseIf.nextTree());

                }
                stream_elseIf.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(176, 6);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "ifStatement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "ifStatement"


    public static class elseIf_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elseIf"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:178:1: elseIf : ( 'else' instrucao ) -> ^( 'else' instrucao ) ;
    public final JediParser.elseIf_return elseIf() throws RecognitionException {
        JediParser.elseIf_return retval = new JediParser.elseIf_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal153=null;
        JediParser.instrucao_return instrucao154 =null;


        Object string_literal153_tree=null;
        RewriteRuleTokenStream stream_63=new RewriteRuleTokenStream(adaptor,"token 63");
        RewriteRuleSubtreeStream stream_instrucao=new RewriteRuleSubtreeStream(adaptor,"rule instrucao");
        try { dbg.enterRule(getGrammarFileName(), "elseIf");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(178, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:178:8: ( ( 'else' instrucao ) -> ^( 'else' instrucao ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:178:11: ( 'else' instrucao )
            {
            dbg.location(178,11);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:178:11: ( 'else' instrucao )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:178:12: 'else' instrucao
            {
            dbg.location(178,12);
            string_literal153=(Token)match(input,63,FOLLOW_63_in_elseIf1623); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_63.add(string_literal153);

            dbg.location(178,19);
            pushFollow(FOLLOW_instrucao_in_elseIf1625);
            instrucao154=instrucao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_instrucao.add(instrucao154.getTree());

            }


            // AST REWRITE
            // elements: instrucao, 63
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 178:30: -> ^( 'else' instrucao )
            {
                dbg.location(178,33);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:178:33: ^( 'else' instrucao )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(178,35);
                root_1 = (Object)adaptor.becomeRoot(
                stream_63.nextNode()
                , root_1);

                dbg.location(178,42);
                adaptor.addChild(root_1, stream_instrucao.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(178, 52);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "elseIf");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "elseIf"


    public static class bloco_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bloco"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:180:1: bloco : '{' ( instrucao )* '}' -> ^( BLOCO ( instrucao )* ) ;
    public final JediParser.bloco_return bloco() throws RecognitionException {
        JediParser.bloco_return retval = new JediParser.bloco_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal155=null;
        Token char_literal157=null;
        JediParser.instrucao_return instrucao156 =null;


        Object char_literal155_tree=null;
        Object char_literal157_tree=null;
        RewriteRuleTokenStream stream_72=new RewriteRuleTokenStream(adaptor,"token 72");
        RewriteRuleTokenStream stream_74=new RewriteRuleTokenStream(adaptor,"token 74");
        RewriteRuleSubtreeStream stream_instrucao=new RewriteRuleSubtreeStream(adaptor,"rule instrucao");
        try { dbg.enterRule(getGrammarFileName(), "bloco");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(180, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:181:2: ( '{' ( instrucao )* '}' -> ^( BLOCO ( instrucao )* ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:181:5: '{' ( instrucao )* '}'
            {
            dbg.location(181,5);
            char_literal155=(Token)match(input,72,FOLLOW_72_in_bloco1646); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_72.add(char_literal155);

            dbg.location(181,9);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:181:9: ( instrucao )*
            try { dbg.enterSubRule(41);

            loop41:
            do {
                int alt41=2;
                try { dbg.enterDecision(41, decisionCanBacktrack[41]);

                int LA41_0 = input.LA(1);

                if ( (LA41_0==ID||LA41_0==INT||LA41_0==40||LA41_0==44||(LA41_0 >= 46 && LA41_0 <= 47)||LA41_0==50||LA41_0==62||(LA41_0 >= 65 && LA41_0 <= 69)||(LA41_0 >= 71 && LA41_0 <= 72)) ) {
                    alt41=1;
                }


                } finally {dbg.exitDecision(41);}

                switch (alt41) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:181:9: instrucao
            	    {
            	    dbg.location(181,9);
            	    pushFollow(FOLLOW_instrucao_in_bloco1648);
            	    instrucao156=instrucao();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_instrucao.add(instrucao156.getTree());

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);
            } finally {dbg.exitSubRule(41);}

            dbg.location(181,20);
            char_literal157=(Token)match(input,74,FOLLOW_74_in_bloco1651); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_74.add(char_literal157);


            // AST REWRITE
            // elements: instrucao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 181:24: -> ^( BLOCO ( instrucao )* )
            {
                dbg.location(181,27);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:181:27: ^( BLOCO ( instrucao )* )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(181,29);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(BLOCO, "BLOCO")
                , root_1);

                dbg.location(181,35);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:181:35: ( instrucao )*
                while ( stream_instrucao.hasNext() ) {
                    dbg.location(181,35);
                    adaptor.addChild(root_1, stream_instrucao.nextTree());

                }
                stream_instrucao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(182, 1);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "bloco");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "bloco"


    public static class whileStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "whileStatement"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:185:1: whileStatement : 'while' '(' expressao ')' instrucao -> ^( WHILE expressao instrucao ) ;
    public final JediParser.whileStatement_return whileStatement() throws RecognitionException {
        JediParser.whileStatement_return retval = new JediParser.whileStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal158=null;
        Token char_literal159=null;
        Token char_literal161=null;
        JediParser.expressao_return expressao160 =null;

        JediParser.instrucao_return instrucao162 =null;


        Object string_literal158_tree=null;
        Object char_literal159_tree=null;
        Object char_literal161_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleSubtreeStream stream_instrucao=new RewriteRuleSubtreeStream(adaptor,"rule instrucao");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try { dbg.enterRule(getGrammarFileName(), "whileStatement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(185, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:185:16: ( 'while' '(' expressao ')' instrucao -> ^( WHILE expressao instrucao ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:185:18: 'while' '(' expressao ')' instrucao
            {
            dbg.location(185,18);
            string_literal158=(Token)match(input,71,FOLLOW_71_in_whileStatement1679); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal158);

            dbg.location(185,26);
            char_literal159=(Token)match(input,40,FOLLOW_40_in_whileStatement1681); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal159);

            dbg.location(185,30);
            pushFollow(FOLLOW_expressao_in_whileStatement1683);
            expressao160=expressao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expressao.add(expressao160.getTree());
            dbg.location(185,40);
            char_literal161=(Token)match(input,41,FOLLOW_41_in_whileStatement1685); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal161);

            dbg.location(185,44);
            pushFollow(FOLLOW_instrucao_in_whileStatement1687);
            instrucao162=instrucao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_instrucao.add(instrucao162.getTree());

            // AST REWRITE
            // elements: instrucao, expressao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 186:16: -> ^( WHILE expressao instrucao )
            {
                dbg.location(186,19);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:186:19: ^( WHILE expressao instrucao )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(186,21);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(WHILE, "WHILE")
                , root_1);

                dbg.location(186,27);
                adaptor.addChild(root_1, stream_expressao.nextTree());
                dbg.location(186,37);
                adaptor.addChild(root_1, stream_instrucao.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(187, 15);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "whileStatement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "whileStatement"


    public static class doWhileStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "doWhileStatement"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:189:1: doWhileStatement : 'do' instrucao 'while' '(' expressao ')' -> ^( DOWHILE expressao instrucao ) ;
    public final JediParser.doWhileStatement_return doWhileStatement() throws RecognitionException {
        JediParser.doWhileStatement_return retval = new JediParser.doWhileStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal163=null;
        Token string_literal165=null;
        Token char_literal166=null;
        Token char_literal168=null;
        JediParser.instrucao_return instrucao164 =null;

        JediParser.expressao_return expressao167 =null;


        Object string_literal163_tree=null;
        Object string_literal165_tree=null;
        Object char_literal166_tree=null;
        Object char_literal168_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
        RewriteRuleSubtreeStream stream_instrucao=new RewriteRuleSubtreeStream(adaptor,"rule instrucao");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try { dbg.enterRule(getGrammarFileName(), "doWhileStatement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(189, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:189:19: ( 'do' instrucao 'while' '(' expressao ')' -> ^( DOWHILE expressao instrucao ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:189:21: 'do' instrucao 'while' '(' expressao ')'
            {
            dbg.location(189,21);
            string_literal163=(Token)match(input,62,FOLLOW_62_in_doWhileStatement1738); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_62.add(string_literal163);

            dbg.location(189,26);
            pushFollow(FOLLOW_instrucao_in_doWhileStatement1740);
            instrucao164=instrucao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_instrucao.add(instrucao164.getTree());
            dbg.location(189,36);
            string_literal165=(Token)match(input,71,FOLLOW_71_in_doWhileStatement1742); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_71.add(string_literal165);

            dbg.location(189,44);
            char_literal166=(Token)match(input,40,FOLLOW_40_in_doWhileStatement1744); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal166);

            dbg.location(189,48);
            pushFollow(FOLLOW_expressao_in_doWhileStatement1746);
            expressao167=expressao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expressao.add(expressao167.getTree());
            dbg.location(189,58);
            char_literal168=(Token)match(input,41,FOLLOW_41_in_doWhileStatement1748); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal168);


            // AST REWRITE
            // elements: instrucao, expressao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 190:19: -> ^( DOWHILE expressao instrucao )
            {
                dbg.location(190,22);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:190:22: ^( DOWHILE expressao instrucao )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(190,24);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(DOWHILE, "DOWHILE")
                , root_1);

                dbg.location(190,32);
                adaptor.addChild(root_1, stream_expressao.nextTree());
                dbg.location(190,42);
                adaptor.addChild(root_1, stream_instrucao.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(191, 4);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "doWhileStatement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "doWhileStatement"


    public static class forStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "forStatement"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:194:1: forStatement : 'for' '(' ( inicializacaoFor )? ';' ( condicaoFor )? ';' ( incrementoFor )? ')' instrucao -> ^( FOR ( inicializacaoFor )? ( condicaoFor )? ( incrementoFor )? instrucao ) ;
    public final JediParser.forStatement_return forStatement() throws RecognitionException {
        JediParser.forStatement_return retval = new JediParser.forStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal169=null;
        Token char_literal170=null;
        Token char_literal172=null;
        Token char_literal174=null;
        Token char_literal176=null;
        JediParser.inicializacaoFor_return inicializacaoFor171 =null;

        JediParser.condicaoFor_return condicaoFor173 =null;

        JediParser.incrementoFor_return incrementoFor175 =null;

        JediParser.instrucao_return instrucao177 =null;


        Object string_literal169_tree=null;
        Object char_literal170_tree=null;
        Object char_literal172_tree=null;
        Object char_literal174_tree=null;
        Object char_literal176_tree=null;
        RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
        RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
        RewriteRuleTokenStream stream_65=new RewriteRuleTokenStream(adaptor,"token 65");
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
        RewriteRuleSubtreeStream stream_condicaoFor=new RewriteRuleSubtreeStream(adaptor,"rule condicaoFor");
        RewriteRuleSubtreeStream stream_instrucao=new RewriteRuleSubtreeStream(adaptor,"rule instrucao");
        RewriteRuleSubtreeStream stream_inicializacaoFor=new RewriteRuleSubtreeStream(adaptor,"rule inicializacaoFor");
        RewriteRuleSubtreeStream stream_incrementoFor=new RewriteRuleSubtreeStream(adaptor,"rule incrementoFor");
        try { dbg.enterRule(getGrammarFileName(), "forStatement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(194, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:194:14: ( 'for' '(' ( inicializacaoFor )? ';' ( condicaoFor )? ';' ( incrementoFor )? ')' instrucao -> ^( FOR ( inicializacaoFor )? ( condicaoFor )? ( incrementoFor )? instrucao ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:194:16: 'for' '(' ( inicializacaoFor )? ';' ( condicaoFor )? ';' ( incrementoFor )? ')' instrucao
            {
            dbg.location(194,16);
            string_literal169=(Token)match(input,65,FOLLOW_65_in_forStatement1799); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_65.add(string_literal169);

            dbg.location(194,22);
            char_literal170=(Token)match(input,40,FOLLOW_40_in_forStatement1801); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_40.add(char_literal170);

            dbg.location(194,25);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:194:25: ( inicializacaoFor )?
            int alt42=2;
            try { dbg.enterSubRule(42);
            try { dbg.enterDecision(42, decisionCanBacktrack[42]);

            int LA42_0 = input.LA(1);

            if ( (LA42_0==ID||LA42_0==INT||LA42_0==40||LA42_0==44||(LA42_0 >= 46 && LA42_0 <= 47)||(LA42_0 >= 67 && LA42_0 <= 68)) ) {
                alt42=1;
            }
            } finally {dbg.exitDecision(42);}

            switch (alt42) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:194:25: inicializacaoFor
                    {
                    dbg.location(194,25);
                    pushFollow(FOLLOW_inicializacaoFor_in_forStatement1802);
                    inicializacaoFor171=inicializacaoFor();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_inicializacaoFor.add(inicializacaoFor171.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(42);}

            dbg.location(194,42);
            char_literal172=(Token)match(input,50,FOLLOW_50_in_forStatement1804); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(char_literal172);

            dbg.location(194,46);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:194:46: ( condicaoFor )?
            int alt43=2;
            try { dbg.enterSubRule(43);
            try { dbg.enterDecision(43, decisionCanBacktrack[43]);

            int LA43_0 = input.LA(1);

            if ( (LA43_0==ID||LA43_0==INT||LA43_0==40||LA43_0==44||(LA43_0 >= 46 && LA43_0 <= 47)||(LA43_0 >= 67 && LA43_0 <= 68)) ) {
                alt43=1;
            }
            } finally {dbg.exitDecision(43);}

            switch (alt43) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:194:46: condicaoFor
                    {
                    dbg.location(194,46);
                    pushFollow(FOLLOW_condicaoFor_in_forStatement1806);
                    condicaoFor173=condicaoFor();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_condicaoFor.add(condicaoFor173.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(43);}

            dbg.location(194,58);
            char_literal174=(Token)match(input,50,FOLLOW_50_in_forStatement1808); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(char_literal174);

            dbg.location(194,62);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:194:62: ( incrementoFor )?
            int alt44=2;
            try { dbg.enterSubRule(44);
            try { dbg.enterDecision(44, decisionCanBacktrack[44]);

            int LA44_0 = input.LA(1);

            if ( (LA44_0==ID||LA44_0==44||LA44_0==47) ) {
                alt44=1;
            }
            } finally {dbg.exitDecision(44);}

            switch (alt44) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:194:62: incrementoFor
                    {
                    dbg.location(194,62);
                    pushFollow(FOLLOW_incrementoFor_in_forStatement1810);
                    incrementoFor175=incrementoFor();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_incrementoFor.add(incrementoFor175.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(44);}

            dbg.location(194,77);
            char_literal176=(Token)match(input,41,FOLLOW_41_in_forStatement1813); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_41.add(char_literal176);

            dbg.location(194,81);
            pushFollow(FOLLOW_instrucao_in_forStatement1815);
            instrucao177=instrucao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_instrucao.add(instrucao177.getTree());

            // AST REWRITE
            // elements: inicializacaoFor, instrucao, incrementoFor, condicaoFor
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 195:7: -> ^( FOR ( inicializacaoFor )? ( condicaoFor )? ( incrementoFor )? instrucao )
            {
                dbg.location(195,10);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:195:10: ^( FOR ( inicializacaoFor )? ( condicaoFor )? ( incrementoFor )? instrucao )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(195,12);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(FOR, "FOR")
                , root_1);

                dbg.location(195,16);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:195:16: ( inicializacaoFor )?
                if ( stream_inicializacaoFor.hasNext() ) {
                    dbg.location(195,16);
                    adaptor.addChild(root_1, stream_inicializacaoFor.nextTree());

                }
                stream_inicializacaoFor.reset();
                dbg.location(195,34);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:195:34: ( condicaoFor )?
                if ( stream_condicaoFor.hasNext() ) {
                    dbg.location(195,34);
                    adaptor.addChild(root_1, stream_condicaoFor.nextTree());

                }
                stream_condicaoFor.reset();
                dbg.location(195,47);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:195:47: ( incrementoFor )?
                if ( stream_incrementoFor.hasNext() ) {
                    dbg.location(195,47);
                    adaptor.addChild(root_1, stream_incrementoFor.nextTree());

                }
                stream_incrementoFor.reset();
                dbg.location(195,62);
                adaptor.addChild(root_1, stream_instrucao.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(196, 13);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "forStatement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "forStatement"


    public static class inicializacaoFor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "inicializacaoFor"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:198:1: inicializacaoFor : ( varDecl ( ',' atribuicao )* -> ^( INIT_FOR varDecl ( atribuicao )* ) | atribuicao ( ',' atribuicao )* -> ^( INIT_FOR ( atribuicao )+ ) );
    public final JediParser.inicializacaoFor_return inicializacaoFor() throws RecognitionException {
        JediParser.inicializacaoFor_return retval = new JediParser.inicializacaoFor_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal179=null;
        Token char_literal182=null;
        JediParser.varDecl_return varDecl178 =null;

        JediParser.atribuicao_return atribuicao180 =null;

        JediParser.atribuicao_return atribuicao181 =null;

        JediParser.atribuicao_return atribuicao183 =null;


        Object char_literal179_tree=null;
        Object char_literal182_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleSubtreeStream stream_atribuicao=new RewriteRuleSubtreeStream(adaptor,"rule atribuicao");
        RewriteRuleSubtreeStream stream_varDecl=new RewriteRuleSubtreeStream(adaptor,"rule varDecl");
        try { dbg.enterRule(getGrammarFileName(), "inicializacaoFor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(198, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:198:18: ( varDecl ( ',' atribuicao )* -> ^( INIT_FOR varDecl ( atribuicao )* ) | atribuicao ( ',' atribuicao )* -> ^( INIT_FOR ( atribuicao )+ ) )
            int alt47=2;
            try { dbg.enterDecision(47, decisionCanBacktrack[47]);

            switch ( input.LA(1) ) {
            case ID:
                {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==ID) ) {
                    alt47=1;
                }
                else if ( ((LA47_1 >= 37 && LA47_1 <= 40)||(LA47_1 >= 42 && LA47_1 <= 57)||LA47_1==60||LA47_1==73) ) {
                    alt47=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            case INT:
            case 40:
            case 44:
            case 46:
            case 47:
            case 68:
                {
                alt47=2;
                }
                break;
            case 67:
                {
                int LA47_3 = input.LA(2);

                if ( (LA47_3==ID) ) {
                    alt47=1;
                }
                else if ( ((LA47_3 >= 37 && LA47_3 <= 40)||(LA47_3 >= 42 && LA47_3 <= 43)||(LA47_3 >= 45 && LA47_3 <= 46)||(LA47_3 >= 48 && LA47_3 <= 57)||LA47_3==60||LA47_3==73) ) {
                    alt47=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 3, input);

                    dbg.recognitionException(nvae);
                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(47);}

            switch (alt47) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:198:21: varDecl ( ',' atribuicao )*
                    {
                    dbg.location(198,21);
                    pushFollow(FOLLOW_varDecl_in_inicializacaoFor1875);
                    varDecl178=varDecl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_varDecl.add(varDecl178.getTree());
                    dbg.location(198,29);
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:198:29: ( ',' atribuicao )*
                    try { dbg.enterSubRule(45);

                    loop45:
                    do {
                        int alt45=2;
                        try { dbg.enterDecision(45, decisionCanBacktrack[45]);

                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==45) ) {
                            alt45=1;
                        }


                        } finally {dbg.exitDecision(45);}

                        switch (alt45) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:198:30: ',' atribuicao
                    	    {
                    	    dbg.location(198,30);
                    	    char_literal179=(Token)match(input,45,FOLLOW_45_in_inicializacaoFor1878); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_45.add(char_literal179);

                    	    dbg.location(198,34);
                    	    pushFollow(FOLLOW_atribuicao_in_inicializacaoFor1880);
                    	    atribuicao180=atribuicao();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_atribuicao.add(atribuicao180.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(45);}


                    // AST REWRITE
                    // elements: varDecl, atribuicao
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 198:48: -> ^( INIT_FOR varDecl ( atribuicao )* )
                    {
                        dbg.location(198,51);
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:198:51: ^( INIT_FOR varDecl ( atribuicao )* )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(198,53);
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(INIT_FOR, "INIT_FOR")
                        , root_1);

                        dbg.location(198,62);
                        adaptor.addChild(root_1, stream_varDecl.nextTree());
                        dbg.location(198,70);
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:198:70: ( atribuicao )*
                        while ( stream_atribuicao.hasNext() ) {
                            dbg.location(198,70);
                            adaptor.addChild(root_1, stream_atribuicao.nextTree());

                        }
                        stream_atribuicao.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:199:7: atribuicao ( ',' atribuicao )*
                    {
                    dbg.location(199,7);
                    pushFollow(FOLLOW_atribuicao_in_inicializacaoFor1902);
                    atribuicao181=atribuicao();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_atribuicao.add(atribuicao181.getTree());
                    dbg.location(199,18);
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:199:18: ( ',' atribuicao )*
                    try { dbg.enterSubRule(46);

                    loop46:
                    do {
                        int alt46=2;
                        try { dbg.enterDecision(46, decisionCanBacktrack[46]);

                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==45) ) {
                            alt46=1;
                        }


                        } finally {dbg.exitDecision(46);}

                        switch (alt46) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:199:19: ',' atribuicao
                    	    {
                    	    dbg.location(199,19);
                    	    char_literal182=(Token)match(input,45,FOLLOW_45_in_inicializacaoFor1905); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_45.add(char_literal182);

                    	    dbg.location(199,23);
                    	    pushFollow(FOLLOW_atribuicao_in_inicializacaoFor1907);
                    	    atribuicao183=atribuicao();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_atribuicao.add(atribuicao183.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(46);}


                    // AST REWRITE
                    // elements: atribuicao
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 199:37: -> ^( INIT_FOR ( atribuicao )+ )
                    {
                        dbg.location(199,40);
                        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:199:40: ^( INIT_FOR ( atribuicao )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        dbg.location(199,42);
                        root_1 = (Object)adaptor.becomeRoot(
                        (Object)adaptor.create(INIT_FOR, "INIT_FOR")
                        , root_1);

                        dbg.location(199,51);
                        if ( !(stream_atribuicao.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_atribuicao.hasNext() ) {
                            dbg.location(199,51);
                            adaptor.addChild(root_1, stream_atribuicao.nextTree());

                        }
                        stream_atribuicao.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(200, 17);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "inicializacaoFor");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "inicializacaoFor"


    public static class condicaoFor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "condicaoFor"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:202:1: condicaoFor : expressao -> ^( COND_FOR expressao ) ;
    public final JediParser.condicaoFor_return condicaoFor() throws RecognitionException {
        JediParser.condicaoFor_return retval = new JediParser.condicaoFor_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        JediParser.expressao_return expressao184 =null;


        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try { dbg.enterRule(getGrammarFileName(), "condicaoFor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(202, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:202:13: ( expressao -> ^( COND_FOR expressao ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:202:16: expressao
            {
            dbg.location(202,16);
            pushFollow(FOLLOW_expressao_in_condicaoFor1947);
            expressao184=expressao();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expressao.add(expressao184.getTree());

            // AST REWRITE
            // elements: expressao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 203:13: -> ^( COND_FOR expressao )
            {
                dbg.location(203,16);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:203:16: ^( COND_FOR expressao )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(203,18);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(COND_FOR, "COND_FOR")
                , root_1);

                dbg.location(203,27);
                adaptor.addChild(root_1, stream_expressao.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(204, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "condicaoFor");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "condicaoFor"


    public static class incrementoFor_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "incrementoFor"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:206:1: incrementoFor : incremento ( ',' incremento )* -> ^( INC_FOR ( incremento )+ ) ;
    public final JediParser.incrementoFor_return incrementoFor() throws RecognitionException {
        JediParser.incrementoFor_return retval = new JediParser.incrementoFor_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token char_literal186=null;
        JediParser.incremento_return incremento185 =null;

        JediParser.incremento_return incremento187 =null;


        Object char_literal186_tree=null;
        RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
        RewriteRuleSubtreeStream stream_incremento=new RewriteRuleSubtreeStream(adaptor,"rule incremento");
        try { dbg.enterRule(getGrammarFileName(), "incrementoFor");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(206, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:206:15: ( incremento ( ',' incremento )* -> ^( INC_FOR ( incremento )+ ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:206:17: incremento ( ',' incremento )*
            {
            dbg.location(206,17);
            pushFollow(FOLLOW_incremento_in_incrementoFor1986);
            incremento185=incremento();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_incremento.add(incremento185.getTree());
            dbg.location(206,28);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:206:28: ( ',' incremento )*
            try { dbg.enterSubRule(48);

            loop48:
            do {
                int alt48=2;
                try { dbg.enterDecision(48, decisionCanBacktrack[48]);

                int LA48_0 = input.LA(1);

                if ( (LA48_0==45) ) {
                    alt48=1;
                }


                } finally {dbg.exitDecision(48);}

                switch (alt48) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:206:29: ',' incremento
            	    {
            	    dbg.location(206,29);
            	    char_literal186=(Token)match(input,45,FOLLOW_45_in_incrementoFor1989); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_45.add(char_literal186);

            	    dbg.location(206,33);
            	    pushFollow(FOLLOW_incremento_in_incrementoFor1991);
            	    incremento187=incremento();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_incremento.add(incremento187.getTree());

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);
            } finally {dbg.exitSubRule(48);}


            // AST REWRITE
            // elements: incremento
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 207:15: -> ^( INC_FOR ( incremento )+ )
            {
                dbg.location(207,18);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:207:18: ^( INC_FOR ( incremento )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(207,20);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(INC_FOR, "INC_FOR")
                , root_1);

                dbg.location(207,28);
                if ( !(stream_incremento.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_incremento.hasNext() ) {
                    dbg.location(207,28);
                    adaptor.addChild(root_1, stream_incremento.nextTree());

                }
                stream_incremento.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(208, 14);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "incrementoFor");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "incrementoFor"


    public static class returnStatement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "returnStatement"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:210:1: returnStatement : 'return' ( expressao )? -> ^( RETURN ( expressao )? ) ;
    public final JediParser.returnStatement_return returnStatement() throws RecognitionException {
        JediParser.returnStatement_return retval = new JediParser.returnStatement_return();
        retval.start = input.LT(1);


        Object root_0 = null;

        Token string_literal188=null;
        JediParser.expressao_return expressao189 =null;


        Object string_literal188_tree=null;
        RewriteRuleTokenStream stream_69=new RewriteRuleTokenStream(adaptor,"token 69");
        RewriteRuleSubtreeStream stream_expressao=new RewriteRuleSubtreeStream(adaptor,"rule expressao");
        try { dbg.enterRule(getGrammarFileName(), "returnStatement");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(210, 0);

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:210:17: ( 'return' ( expressao )? -> ^( RETURN ( expressao )? ) )
            dbg.enterAlt(1);

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:210:20: 'return' ( expressao )?
            {
            dbg.location(210,20);
            string_literal188=(Token)match(input,69,FOLLOW_69_in_returnStatement2055); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_69.add(string_literal188);

            dbg.location(210,29);
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:210:29: ( expressao )?
            int alt49=2;
            try { dbg.enterSubRule(49);
            try { dbg.enterDecision(49, decisionCanBacktrack[49]);

            int LA49_0 = input.LA(1);

            if ( (LA49_0==ID||LA49_0==INT||LA49_0==40||LA49_0==44||(LA49_0 >= 46 && LA49_0 <= 47)||(LA49_0 >= 67 && LA49_0 <= 68)) ) {
                alt49=1;
            }
            } finally {dbg.exitDecision(49);}

            switch (alt49) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:210:29: expressao
                    {
                    dbg.location(210,29);
                    pushFollow(FOLLOW_expressao_in_returnStatement2057);
                    expressao189=expressao();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_expressao.add(expressao189.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(49);}


            // AST REWRITE
            // elements: expressao
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 210:40: -> ^( RETURN ( expressao )? )
            {
                dbg.location(210,43);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:210:43: ^( RETURN ( expressao )? )
                {
                Object root_1 = (Object)adaptor.nil();
                dbg.location(210,45);
                root_1 = (Object)adaptor.becomeRoot(
                (Object)adaptor.create(RETURN, "RETURN")
                , root_1);

                dbg.location(210,52);
                // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:210:52: ( expressao )?
                if ( stream_expressao.hasNext() ) {
                    dbg.location(210,52);
                    adaptor.addChild(root_1, stream_expressao.nextTree());

                }
                stream_expressao.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        dbg.location(210, 62);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "returnStatement");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "returnStatement"

    // $ANTLR start synpred1_Jedi
    public final void synpred1_Jedi_fragment() throws RecognitionException {
        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:116:5: ( '.' ID '(' listaExpressoes ')' )
        dbg.enterAlt(1);

        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:116:5: '.' ID '(' listaExpressoes ')'
        {
        dbg.location(116,5);
        match(input,48,FOLLOW_48_in_synpred1_Jedi847); if (state.failed) return ;
        dbg.location(116,9);
        match(input,ID,FOLLOW_ID_in_synpred1_Jedi849); if (state.failed) return ;
        dbg.location(116,12);
        match(input,40,FOLLOW_40_in_synpred1_Jedi851); if (state.failed) return ;
        dbg.location(116,16);
        pushFollow(FOLLOW_listaExpressoes_in_synpred1_Jedi853);
        listaExpressoes();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(116,32);
        match(input,41,FOLLOW_41_in_synpred1_Jedi855); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_Jedi

    // $ANTLR start synpred2_Jedi
    public final void synpred2_Jedi_fragment() throws RecognitionException {
        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:117:5: ( '.' ID )
        dbg.enterAlt(1);

        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:117:5: '.' ID
        {
        dbg.location(117,5);
        match(input,48,FOLLOW_48_in_synpred2_Jedi879); if (state.failed) return ;
        dbg.location(117,9);
        match(input,ID,FOLLOW_ID_in_synpred2_Jedi881); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_Jedi

    // $ANTLR start synpred4_Jedi
    public final void synpred4_Jedi_fragment() throws RecognitionException {
        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:119:11: ( '.' ID '[' expressao ']' )
        dbg.enterAlt(1);

        // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Jedi.g:119:11: '.' ID '[' expressao ']'
        {
        dbg.location(119,11);
        match(input,48,FOLLOW_48_in_synpred4_Jedi939); if (state.failed) return ;
        dbg.location(119,15);
        match(input,ID,FOLLOW_ID_in_synpred4_Jedi941); if (state.failed) return ;
        dbg.location(119,18);
        match(input,57,FOLLOW_57_in_synpred4_Jedi943); if (state.failed) return ;
        dbg.location(119,22);
        pushFollow(FOLLOW_expressao_in_synpred4_Jedi945);
        expressao();

        state._fsp--;
        if (state.failed) return ;
        dbg.location(119,32);
        match(input,59,FOLLOW_59_in_synpred4_Jedi947); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_Jedi

    // Delegated rules

    public final boolean synpred2_Jedi() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred2_Jedi_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Jedi() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred4_Jedi_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Jedi() {
        state.backtracking++;
        dbg.beginBacktrack(state.backtracking);
        int start = input.mark();
        try {
            synpred1_Jedi_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        dbg.endBacktrack(state.backtracking, success);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA28 dfa28 = new DFA28(this);
    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA28_eotS =
        "\12\uffff";
    static final String DFA28_eofS =
        "\12\uffff";
    static final String DFA28_minS =
        "\1\15\1\uffff\1\45\4\uffff\1\15\1\uffff\1\45";
    static final String DFA28_maxS =
        "\1\103\1\uffff\1\111\4\uffff\1\15\1\uffff\1\111";
    static final String DFA28_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\1\uffff\1\2\1\uffff";
    static final String DFA28_specialS =
        "\12\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\2\3\uffff\1\1\26\uffff\1\6\3\uffff\1\5\1\uffff\1\4\1\5\23"+
            "\uffff\1\3",
            "",
            "\7\10\1\5\2\10\1\5\1\7\11\10\1\uffff\2\10\14\uffff\1\10",
            "",
            "",
            "",
            "",
            "\1\11",
            "",
            "\7\10\1\5\2\10\1\5\1\7\11\10\1\uffff\2\10\14\uffff\1\10"
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "129:1: primaria : ( INT | ID -> ID | 'int' -> 'int' | '-' ^ ID | incremento | '(' expressao ')' -> expressao );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
    static final String DFA33_eotS =
        "\10\uffff";
    static final String DFA33_eofS =
        "\10\uffff";
    static final String DFA33_minS =
        "\1\15\2\uffff\1\54\1\15\2\uffff\1\54";
    static final String DFA33_maxS =
        "\1\57\2\uffff\1\60\1\15\2\uffff\1\60";
    static final String DFA33_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\3\1\4\1\uffff";
    static final String DFA33_specialS =
        "\10\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\3\36\uffff\1\2\2\uffff\1\1",
            "",
            "",
            "\1\6\2\uffff\1\5\1\4",
            "\1\7",
            "",
            "",
            "\1\6\2\uffff\1\5\1\4"
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "142:1: incremento : ( '--' ID ( '.' ID )* -> ^( PRE_DECREMENTO ( ID )+ ) | '++' ID ( '.' ID )* -> ^( PRE_INCREMENTO ( ID )+ ) | ID ( '.' ID )* '--' -> ^( POS_DECREMENTO ( ID )+ ) | ID ( '.' ID )* '++' -> ^( POS_INCREMENTO ( ID )+ ) );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_classe_in_programa199 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61_in_classe208 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_classe210 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000101L});
    public static final BitSet FOLLOW_superClasse_in_classe213 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_classe216 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000048L});
    public static final BitSet FOLLOW_membroClasse_in_classe218 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000448L});
    public static final BitSet FOLLOW_74_in_classe221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_superClasse263 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_superClasse265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fieldDecl_in_membroClasse283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constrDecl_in_membroClasse287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_methodDecl_in_membroClasse291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_fieldDecl303 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_tipo_in_fieldDecl306 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_fieldDecl308 = new BitSet(new long[]{0x0404000000000000L});
    public static final BitSet FOLLOW_58_in_fieldDecl313 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_fieldDecl316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_methodDecl353 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_tipo_in_methodDecl356 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_methodDecl358 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_methodDecl360 = new BitSet(new long[]{0x0000020000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_params_in_methodDecl362 = new BitSet(new long[]{0x0000020000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_41_in_methodDecl365 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_bloco_in_methodDecl367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_constrDecl415 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_constrDecl417 = new BitSet(new long[]{0x0000020000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_params_in_constrDecl419 = new BitSet(new long[]{0x0000020000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_41_in_constrDecl422 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_bloco_in_constrDecl424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_param_in_params467 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_params470 = new BitSet(new long[]{0x0000000000002000L,0x0000000000000008L});
    public static final BitSet FOLLOW_param_in_params472 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_tipo_in_param492 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_param494 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_param499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_instrucao523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expressao_in_instrucao528 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_instrucao530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaVarDecl_in_instrucao535 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_instrucao537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bloco_in_instrucao542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStatement_in_instrucao547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStatement_in_instrucao552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_doWhileStatement_in_instrucao557 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_instrucao559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_forStatement_in_instrucao564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_returnStatement_in_instrucao569 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_instrucao571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atribuicao_in_expressao584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_or_in_atribuicao601 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_atribuicao605 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_or_in_atribuicao609 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_and_in_or623 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_or627 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_and_in_or631 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_xor_in_and642 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_and646 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_xor_in_and650 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_igualdade_in_xor664 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_xor668 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_igualdade_in_xor672 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_relacional_in_igualdade686 = new BitSet(new long[]{0x0040002000000002L});
    public static final BitSet FOLLOW_54_in_igualdade690 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_37_in_igualdade694 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_relacional_in_igualdade698 = new BitSet(new long[]{0x0040002000000002L});
    public static final BitSet FOLLOW_add_in_relacional709 = new BitSet(new long[]{0x0198000000000002L});
    public static final BitSet FOLLOW_51_in_relacional713 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_55_in_relacional718 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_56_in_relacional723 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_52_in_relacional728 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_add_in_relacional732 = new BitSet(new long[]{0x0198000000000002L});
    public static final BitSet FOLLOW_mult_in_add744 = new BitSet(new long[]{0x0000480000000002L});
    public static final BitSet FOLLOW_43_in_add748 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_46_in_add752 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_mult_in_add756 = new BitSet(new long[]{0x0000480000000002L});
    public static final BitSet FOLLOW_novo_in_mult766 = new BitSet(new long[]{0x0002044000000002L});
    public static final BitSet FOLLOW_42_in_mult770 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_49_in_mult775 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_38_in_mult780 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_novo_in_mult784 = new BitSet(new long[]{0x0002044000000002L});
    public static final BitSet FOLLOW_posfixa_in_novo796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_novo802 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000008L});
    public static final BitSet FOLLOW_posfixa_in_novo806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaria_in_posfixa824 = new BitSet(new long[]{0x0201010000000002L});
    public static final BitSet FOLLOW_48_in_posfixa847 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_posfixa849 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_posfixa851 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_listaExpressoes_in_posfixa853 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_posfixa855 = new BitSet(new long[]{0x0201010000000002L});
    public static final BitSet FOLLOW_48_in_posfixa879 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_posfixa881 = new BitSet(new long[]{0x0201010000000002L});
    public static final BitSet FOLLOW_40_in_posfixa905 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_listaExpressoes_in_posfixa907 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_posfixa909 = new BitSet(new long[]{0x0201010000000002L});
    public static final BitSet FOLLOW_48_in_posfixa939 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_posfixa941 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_posfixa943 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_posfixa945 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_posfixa947 = new BitSet(new long[]{0x0201010000000002L});
    public static final BitSet FOLLOW_57_in_posfixa977 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_posfixa979 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_posfixa981 = new BitSet(new long[]{0x0201010000000002L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes1016 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_listaExpressoes1019 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_listaExpressoes1021 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_INT_in_primaria1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_primaria1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_primaria1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_primaria1103 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_primaria1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incremento_in_primaria1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_primaria1124 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_primaria1126 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_primaria1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_incremento1147 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_incremento1149 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_incremento1152 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_incremento1153 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_44_in_incremento1177 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_incremento1179 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_incremento1182 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_incremento1183 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_ID_in_incremento1211 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_48_in_incremento1214 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_incremento1215 = new BitSet(new long[]{0x0001800000000000L});
    public static final BitSet FOLLOW_47_in_incremento1219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_incremento1245 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_48_in_incremento1248 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_incremento1249 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_44_in_incremento1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_chamadaMetodo1285 = new BitSet(new long[]{0x0001010000000000L});
    public static final BitSet FOLLOW_48_in_chamadaMetodo1305 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_chamadaMetodo1307 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_chamadaMetodo1309 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_listaExpressoes_in_chamadaMetodo1311 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_chamadaMetodo1313 = new BitSet(new long[]{0x0001010000000002L});
    public static final BitSet FOLLOW_40_in_chamadaMetodo1337 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_listaExpressoes_in_chamadaMetodo1339 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_chamadaMetodo1341 = new BitSet(new long[]{0x0001010000000002L});
    public static final BitSet FOLLOW_tipo_in_varDecl1383 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_varDecl1385 = new BitSet(new long[]{0x0420000000000002L});
    public static final BitSet FOLLOW_58_in_varDecl1390 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_varDecl1394 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_varDecl1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_listaVarDecl1443 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_varDeclLista_in_listaVarDecl1446 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_varDeclLista1488 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_varDeclLista1490 = new BitSet(new long[]{0x0420000000000002L});
    public static final BitSet FOLLOW_58_in_varDeclLista1496 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_varDeclLista1500 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_varDeclLista1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ifStatement1576 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ifStatement1578 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_ifStatement1580 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ifStatement1582 = new BitSet(new long[]{0x4004D10000022000L,0x00000000000001BEL});
    public static final BitSet FOLLOW_instrucao_in_ifStatement1584 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_elseIf_in_ifStatement1586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_elseIf1623 = new BitSet(new long[]{0x4004D10000022000L,0x00000000000001BEL});
    public static final BitSet FOLLOW_instrucao_in_elseIf1625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_bloco1646 = new BitSet(new long[]{0x4004D10000022000L,0x00000000000005BEL});
    public static final BitSet FOLLOW_instrucao_in_bloco1648 = new BitSet(new long[]{0x4004D10000022000L,0x00000000000005BEL});
    public static final BitSet FOLLOW_74_in_bloco1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_whileStatement1679 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_whileStatement1681 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_whileStatement1683 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_whileStatement1685 = new BitSet(new long[]{0x4004D10000022000L,0x00000000000001BEL});
    public static final BitSet FOLLOW_instrucao_in_whileStatement1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_doWhileStatement1738 = new BitSet(new long[]{0x4004D10000022000L,0x00000000000001BEL});
    public static final BitSet FOLLOW_instrucao_in_doWhileStatement1740 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_doWhileStatement1742 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_doWhileStatement1744 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_doWhileStatement1746 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_doWhileStatement1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_forStatement1799 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_forStatement1801 = new BitSet(new long[]{0x0004D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_inicializacaoFor_in_forStatement1802 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_forStatement1804 = new BitSet(new long[]{0x0004D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_condicaoFor_in_forStatement1806 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_forStatement1808 = new BitSet(new long[]{0x0000920000002000L});
    public static final BitSet FOLLOW_incrementoFor_in_forStatement1810 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_forStatement1813 = new BitSet(new long[]{0x4004D10000022000L,0x00000000000001BEL});
    public static final BitSet FOLLOW_instrucao_in_forStatement1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_varDecl_in_inicializacaoFor1875 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_inicializacaoFor1878 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_atribuicao_in_inicializacaoFor1880 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_atribuicao_in_inicializacaoFor1902 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_inicializacaoFor1905 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_atribuicao_in_inicializacaoFor1907 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_expressao_in_condicaoFor1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incremento_in_incrementoFor1986 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_incrementoFor1989 = new BitSet(new long[]{0x0000900000002000L});
    public static final BitSet FOLLOW_incremento_in_incrementoFor1991 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_69_in_returnStatement2055 = new BitSet(new long[]{0x0000D10000022002L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_returnStatement2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred1_Jedi847 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_synpred1_Jedi849 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_synpred1_Jedi851 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_listaExpressoes_in_synpred1_Jedi853 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_synpred1_Jedi855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred2_Jedi879 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_synpred2_Jedi881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_synpred4_Jedi939 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ID_in_synpred4_Jedi941 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_synpred4_Jedi943 = new BitSet(new long[]{0x0000D10000022000L,0x0000000000000018L});
    public static final BitSet FOLLOW_expressao_in_synpred4_Jedi945 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_synpred4_Jedi947 = new BitSet(new long[]{0x0000000000000002L});

}