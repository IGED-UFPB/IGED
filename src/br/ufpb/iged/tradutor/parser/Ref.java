// $ANTLR 3.4 C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g 2013-07-14 18:43:08


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
    


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Ref extends TreeFilter {
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
    public TreeFilter[] getDelegates() {
        return new TreeFilter[] {};
    }

    // delegators


    public Ref(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public Ref(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return Ref.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g"; }


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
        



    // $ANTLR start "topdown"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:127:1: topdown : ( enterClass | enterMethod | enterConstructor | enterParam | enterField | subDivEnter );
    public final void topdown() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:128:5: ( enterClass | enterMethod | enterConstructor | enterParam | enterField | subDivEnter )
            int alt1=6;
            switch ( input.LA(1) ) {
            case CLASSE:
                {
                alt1=1;
                }
                break;
            case METHOD_DECL:
                {
                alt1=2;
                }
                break;
            case CONSTR_DECL:
                {
                alt1=3;
                }
                break;
            case PARAM:
                {
                alt1=4;
                }
                break;
            case FIELD_DECL:
                {
                alt1=5;
                }
                break;
            case 38:
            case 46:
            case 49:
                {
                alt1=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:128:9: enterClass
                    {
                    pushFollow(FOLLOW_enterClass_in_topdown60);
                    enterClass();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:129:9: enterMethod
                    {
                    pushFollow(FOLLOW_enterMethod_in_topdown70);
                    enterMethod();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:130:9: enterConstructor
                    {
                    pushFollow(FOLLOW_enterConstructor_in_topdown80);
                    enterConstructor();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:131:9: enterParam
                    {
                    pushFollow(FOLLOW_enterParam_in_topdown90);
                    enterParam();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:132:9: enterField
                    {
                    pushFollow(FOLLOW_enterField_in_topdown100);
                    enterField();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:133:9: subDivEnter
                    {
                    pushFollow(FOLLOW_subDivEnter_in_topdown110);
                    subDivEnter();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        } catch (SyntacticException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "topdown"



    // $ANTLR start "bottomup"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:136:1: bottomup : ( exitClass | exitMethod | exitConstructor | exitParams | listaVarDeclAtribuicao | atribuicao | addMult | subDivExit | acessoCampo | vetorExpr | chamadaMetodo );
    public final void bottomup() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:137:5: ( exitClass | exitMethod | exitConstructor | exitParams | listaVarDeclAtribuicao | atribuicao | addMult | subDivExit | acessoCampo | vetorExpr | chamadaMetodo )
            int alt2=11;
            switch ( input.LA(1) ) {
            case CLASSE:
                {
                alt2=1;
                }
                break;
            case METHOD_DECL:
                {
                alt2=2;
                }
                break;
            case CONSTR_DECL:
                {
                alt2=3;
                }
                break;
            case PARAMS:
                {
                alt2=4;
                }
                break;
            case LISTA_VAR_DECL:
                {
                alt2=5;
                }
                break;
            case 53:
                {
                alt2=6;
                }
                break;
            case 42:
            case 43:
                {
                alt2=7;
                }
                break;
            case 38:
            case 46:
            case 49:
                {
                alt2=8;
                }
                break;
            case 48:
                {
                alt2=9;
                }
                break;
            case VECT_EXPR:
                {
                alt2=10;
                }
                break;
            case METHOD_CALL:
                {
                alt2=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:137:9: exitClass
                    {
                    pushFollow(FOLLOW_exitClass_in_bottomup129);
                    exitClass();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:138:9: exitMethod
                    {
                    pushFollow(FOLLOW_exitMethod_in_bottomup139);
                    exitMethod();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:139:9: exitConstructor
                    {
                    pushFollow(FOLLOW_exitConstructor_in_bottomup149);
                    exitConstructor();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:140:9: exitParams
                    {
                    pushFollow(FOLLOW_exitParams_in_bottomup159);
                    exitParams();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:141:9: listaVarDeclAtribuicao
                    {
                    pushFollow(FOLLOW_listaVarDeclAtribuicao_in_bottomup169);
                    listaVarDeclAtribuicao();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:142:9: atribuicao
                    {
                    pushFollow(FOLLOW_atribuicao_in_bottomup179);
                    atribuicao();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:143:9: addMult
                    {
                    pushFollow(FOLLOW_addMult_in_bottomup189);
                    addMult();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:144:9: subDivExit
                    {
                    pushFollow(FOLLOW_subDivExit_in_bottomup199);
                    subDivExit();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:145:9: acessoCampo
                    {
                    pushFollow(FOLLOW_acessoCampo_in_bottomup209);
                    acessoCampo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:146:9: vetorExpr
                    {
                    pushFollow(FOLLOW_vetorExpr_in_bottomup219);
                    vetorExpr();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:147:9: chamadaMetodo
                    {
                    pushFollow(FOLLOW_chamadaMetodo_in_bottomup229);
                    chamadaMetodo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "bottomup"



    // $ANTLR start "enterClass"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:150:1: enterClass : ^( CLASSE nome= ID ( ^( EXTENDS sup= ID ) )? ( . )+ ) ;
    public final void enterClass() throws RecognitionException {
        TradutorAST nome=null;
        TradutorAST sup=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:151:5: ( ^( CLASSE nome= ID ( ^( EXTENDS sup= ID ) )? ( . )+ ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:151:9: ^( CLASSE nome= ID ( ^( EXTENDS sup= ID ) )? ( . )+ )
            {
            match(input,CLASSE,FOLLOW_CLASSE_in_enterClass249); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            nome=(TradutorAST)match(input,ID,FOLLOW_ID_in_enterClass255); if (state.failed) return ;

            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:151:28: ( ^( EXTENDS sup= ID ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==EXTENDS) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==DOWN) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==ID) ) {
                        int LA3_4 = input.LA(4);

                        if ( (LA3_4==UP) ) {
                            alt3=1;
                        }
                    }
                }
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:151:29: ^( EXTENDS sup= ID )
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_enterClass259); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    sup=(TradutorAST)match(input,ID,FOLLOW_ID_in_enterClass265); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;

            }


            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:151:51: ( . )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= BLOCO && LA4_0 <= 74)) ) {
                    alt4=1;
                }
                else if ( (LA4_0==UP) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:151:51: .
            	    {
            	    matchAny(input); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) { 
                         classeAtual = (SimboloClasse)nome.simbolo; 
            	     Tradutor.buffer = new StringBuffer();
            	     Tradutor.buffer.append(".class "+classeAtual.getNome()+"\n");
            	     
            	     if (sup != null)
            	       Tradutor.buffer.append(".super "+sup.getText()+"\n");
            	     
                    }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "enterClass"



    // $ANTLR start "exitClass"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:163:1: exitClass : CLASSE ;
    public final void exitClass() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:164:5: ( CLASSE )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:164:9: CLASSE
            {
            match(input,CLASSE,FOLLOW_CLASSE_in_exitClass301); if (state.failed) return ;

            if ( state.backtracking==1 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exitClass"



    // $ANTLR start "enterMethod"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:182:1: enterMethod : ^( METHOD_DECL (st= . )? tp= . ID (parm= . )* ^( BLOCO ( . )* ) ) ;
    public final void enterMethod() throws RecognitionException {
        TradutorAST ID1=null;
        TradutorAST st=null;
        TradutorAST tp=null;
        TradutorAST parm=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:183:5: ( ^( METHOD_DECL (st= . )? tp= . ID (parm= . )* ^( BLOCO ( . )* ) ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:183:8: ^( METHOD_DECL (st= . )? tp= . ID (parm= . )* ^( BLOCO ( . )* ) )
            {
            match(input,METHOD_DECL,FOLLOW_METHOD_DECL_in_enterMethod334); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:183:25: (st= . )?
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:183:25: st= .
                    {
                    st=(TradutorAST)input.LT(1);

                    matchAny(input); if (state.failed) return ;

                    }
                    break;

            }


            tp=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            ID1=(TradutorAST)match(input,ID,FOLLOW_ID_in_enterMethod349); if (state.failed) return ;

            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:183:45: (parm= . )*
            loop6:
            do {
                int alt6=2;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:183:45: parm= .
            	    {
            	    parm=(TradutorAST)input.LT(1);

            	    matchAny(input); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            match(input,BLOCO,FOLLOW_BLOCO_in_enterMethod359); if (state.failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return ;
                // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:183:58: ( . )*
                loop7:
                do {
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( ((LA7_0 >= BLOCO && LA7_0 <= 74)) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==UP) ) {
                        alt7=2;
                    }


                    switch (alt7) {
                	case 1 :
                	    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:183:58: .
                	    {
                	    matchAny(input); if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop7;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return ;
            }


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
                    	metodoAtual = (SimboloMetodo) ID1.simbolo;
            	    
            	    	tipoMetodo = tp.getText(); 
            	    	
            	    	if (parm == null) {
            	    	
            	    		Tradutor.buffer.append(".method ");
            	        
            	                if (st != null)
            	        	   Tradutor.buffer.append("static ");
            	        
            	                Tradutor.buffer.append( (ID1!=null?ID1.getText():null) + "()");
            	                
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
            	        
            	           linha += (ID1!=null?ID1.getText():null) + "(";
            	    	
            	    	}
            	    		   
            	        
            	        
                    }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "enterMethod"



    // $ANTLR start "enterConstructor"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:226:1: enterConstructor : ^( CONSTR_DECL ID (parm= . )* ^( BLOCO ( . )* ) ) ;
    public final void enterConstructor() throws RecognitionException {
        TradutorAST ID2=null;
        TradutorAST parm=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:227:2: ( ^( CONSTR_DECL ID (parm= . )* ^( BLOCO ( . )* ) ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:227:5: ^( CONSTR_DECL ID (parm= . )* ^( BLOCO ( . )* ) )
            {
            match(input,CONSTR_DECL,FOLLOW_CONSTR_DECL_in_enterConstructor395); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            ID2=(TradutorAST)match(input,ID,FOLLOW_ID_in_enterConstructor397); if (state.failed) return ;

            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:227:27: (parm= . )*
            loop8:
            do {
                int alt8=2;
                alt8 = dfa8.predict(input);
                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:227:27: parm= .
            	    {
            	    parm=(TradutorAST)input.LT(1);

            	    matchAny(input); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            match(input,BLOCO,FOLLOW_BLOCO_in_enterConstructor407); if (state.failed) return ;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return ;
                // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:227:40: ( . )*
                loop9:
                do {
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( ((LA9_0 >= BLOCO && LA9_0 <= 74)) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==UP) ) {
                        alt9=2;
                    }


                    switch (alt9) {
                	case 1 :
                	    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:227:40: .
                	    {
                	    matchAny(input); if (state.failed) return ;

                	    }
                	    break;

                	default :
                	    break loop9;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return ;
            }


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            	        metodoAtual = (SimboloMetodo) ID2.simbolo;
            	        
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "enterConstructor"



    // $ANTLR start "exitMethod"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:259:1: exitMethod : METHOD_DECL ;
    public final void exitMethod() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:260:5: ( METHOD_DECL )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:260:9: METHOD_DECL
            {
            match(input,METHOD_DECL,FOLLOW_METHOD_DECL_in_exitMethod446); if (state.failed) return ;

            if ( state.backtracking==1 ) {
            	        if (tipoMetodo.equals("void"))
            			Tradutor.buffer.append("return\n");
            		else if (tipoMetodo.equals("int"))
            			Tradutor.buffer.append("ireturn\n");
            		else
            			Tradutor.buffer.append("areturn\n") ;
            			
            		Tradutor.buffer.append(".end method\n");
            		  
                    }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exitMethod"



    // $ANTLR start "exitConstructor"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:274:1: exitConstructor : CONSTR_DECL ;
    public final void exitConstructor() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:275:5: ( CONSTR_DECL )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:275:9: CONSTR_DECL
            {
            match(input,CONSTR_DECL,FOLLOW_CONSTR_DECL_in_exitConstructor475); if (state.failed) return ;

            if ( state.backtracking==1 ) {
                    	Tradutor.buffer.append("return\n");		
            		Tradutor.buffer.append(".end method\n");    
                    }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exitConstructor"



    // $ANTLR start "enterParam"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:282:1: enterParam : ^( PARAM tp= . ID (vet= . )? ) ;
    public final void enterParam() throws RecognitionException, SyntacticException {
        TradutorAST tp=null;
        TradutorAST vet=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:283:5: ( ^( PARAM tp= . ID (vet= . )? ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:283:7: ^( PARAM tp= . ID (vet= . )? )
            {
            match(input,PARAM,FOLLOW_PARAM_in_enterParam509); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            tp=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input,ID,FOLLOW_ID_in_enterParam517); if (state.failed) return ;

            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:283:29: (vet= . )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0 >= BLOCO && LA10_0 <= 74)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:283:29: vet= .
                    {
                    vet=(TradutorAST)input.LT(1);

                    matchAny(input); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            	        if (vet != null) {
            	        	if (tp.getText().equals("int"))
            			   linha += "[I;";
            		        else if (tp.getText().equals("void"))
            			   throw new SyntacticException("Line: "+tp.getLine()+"the type of a parameter cannot be void");
            		        else
            			   linha += "[L"+tp.getText()+";";
            	        } else {
            	        	
            			if (tp.getText().equals("int"))
            				linha += "I";
            			else if (tp.getText().equals("void"))
            				throw new SyntacticException("Line: "+tp.getLine()+"the type of a parameter cannot be void");
            			else
            				linha += "L"+tp.getText()+";";
            		}
            				
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "enterParam"



    // $ANTLR start "exitParams"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:305:1: exitParams : PARAMS ;
    public final void exitParams() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:306:2: ( PARAMS )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:306:4: PARAMS
            {
            match(input,PARAMS,FOLLOW_PARAMS_in_exitParams554); if (state.failed) return ;

            if ( state.backtracking==1 ) {
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exitParams"


    public static class enterField_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "enterField"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:327:1: enterField : ^( FIELD_DECL (st= . )? tp= . ID (vet= . )? ) ;
    public final Ref.enterField_return enterField() throws RecognitionException, SyntacticException {
        Ref.enterField_return retval = new Ref.enterField_return();
        retval.start = input.LT(1);


        TradutorAST ID3=null;
        TradutorAST st=null;
        TradutorAST tp=null;
        TradutorAST vet=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:328:5: ( ^( FIELD_DECL (st= . )? tp= . ID (vet= . )? ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:328:9: ^( FIELD_DECL (st= . )? tp= . ID (vet= . )? )
            {
            match(input,FIELD_DECL,FOLLOW_FIELD_DECL_in_enterField575); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:328:25: (st= . )?
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:328:25: st= .
                    {
                    st=(TradutorAST)input.LT(1);

                    matchAny(input); if (state.failed) return retval;

                    }
                    break;

            }


            tp=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return retval;

            ID3=(TradutorAST)match(input,ID,FOLLOW_ID_in_enterField590); if (state.failed) return retval;

            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:328:44: (vet= . )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0 >= BLOCO && LA12_0 <= 74)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:328:44: vet= .
                    {
                    vet=(TradutorAST)input.LT(1);

                    matchAny(input); if (state.failed) return retval;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;


            if ( state.backtracking==1 ) {
            	        Tradutor.buffer.append(".field ");
            	        
            	        if (st != null)
            	        	Tradutor.buffer.append("static ");
            	        
            	        Tradutor.buffer.append((ID3!=null?ID3.getText():null)+ " ");
            	        
            	        if (tp.getText().equals("int"))
            			Tradutor.buffer.append("I");
            		else if (tp.getText().equals("void"))
            			throw new SyntacticException("Line: "+tp.getLine()+"the type of a field cannot be void");
            		else
            			Tradutor.buffer.append("L"+tp.getText()+";");
            			
            		Tradutor.buffer.append("\n");
            	        
            	        
                    }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "enterField"



    // $ANTLR start "listaVarDeclAtribuicao"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:350:1: listaVarDeclAtribuicao : ^( LISTA_VAR_DECL ^( VAR_DECL tp= . ID (vet= . )? ^( EXPR a= . ) ) ( . )* ) ;
    public final void listaVarDeclAtribuicao() throws RecognitionException {
        TradutorAST ID4=null;
        TradutorAST tp=null;
        TradutorAST vet=null;
        TradutorAST a=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:351:5: ( ^( LISTA_VAR_DECL ^( VAR_DECL tp= . ID (vet= . )? ^( EXPR a= . ) ) ( . )* ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:351:9: ^( LISTA_VAR_DECL ^( VAR_DECL tp= . ID (vet= . )? ^( EXPR a= . ) ) ( . )* )
            {
            match(input,LISTA_VAR_DECL,FOLLOW_LISTA_VAR_DECL_in_listaVarDeclAtribuicao634); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,VAR_DECL,FOLLOW_VAR_DECL_in_listaVarDeclAtribuicao637); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            tp=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            ID4=(TradutorAST)match(input,ID,FOLLOW_ID_in_listaVarDeclAtribuicao645); if (state.failed) return ;

            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:351:51: (vet= . )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==EXPR) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==DOWN) ) {
                    int LA13_3 = input.LA(3);

                    if ( ((LA13_3 >= BLOCO && LA13_3 <= 74)) ) {
                        int LA13_4 = input.LA(4);

                        if ( (LA13_4==UP) ) {
                            int LA13_6 = input.LA(5);

                            if ( (LA13_6==EXPR) ) {
                                alt13=1;
                            }
                        }
                        else if ( ((LA13_4 >= BLOCO && LA13_4 <= 74)) ) {
                            alt13=1;
                        }
                    }
                }
                else if ( (LA13_1==EXPR) ) {
                    alt13=1;
                }
            }
            else if ( ((LA13_0 >= BLOCO && LA13_0 <= DOWHILE)||(LA13_0 >= EXTENDS && LA13_0 <= 74)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:351:51: vet= .
                    {
                    vet=(TradutorAST)input.LT(1);

                    matchAny(input); if (state.failed) return ;

                    }
                    break;

            }


            match(input,EXPR,FOLLOW_EXPR_in_listaVarDeclAtribuicao654); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            match(input, Token.UP, null); if (state.failed) return ;


            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:351:70: ( . )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= BLOCO && LA14_0 <= 74)) ) {
                    alt14=1;
                }
                else if ( (LA14_0==UP) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:351:70: .
            	    {
            	    matchAny(input); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
                    
                    	SimboloVariavel simboloVariavel;
                    	
                    	if (a.escopo != null){
                    	
                    		simboloVariavel = (SimboloVariavel)a.escopo.resolver(a.getText());
                    		
                    		loadVar(simboloVariavel);
                    	
                    	} else if (isInteger(a.getText()))
                    	
                    		loadConst(a.getText());
                    		
                    	
                    	simboloVariavel = (SimboloVariavel) ID4.simbolo;
                    	
            	        storeVar(simboloVariavel);
            	        	        
            	        
                    }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "listaVarDeclAtribuicao"



    // $ANTLR start "atribuicao"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:400:1: atribuicao : ^( '=' a= . b= . ) ;
    public final void atribuicao() throws RecognitionException {
        TradutorAST a=null;
        TradutorAST b=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:401:2: ( ^( '=' a= . b= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:401:4: ^( '=' a= . b= . )
            {
            match(input,53,FOLLOW_53_in_atribuicao698); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            b=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            	
            		if (!(a.hasAncestor(VECT_EXPR) || a.hasAncestor(METHOD_CALL))){
            		
            			SimboloVariavel simboloVariavel;
            				
            			if (b.getText().equals("null"))
            				Tradutor.buffer.append("aconst_null\n");
            			else if (b.escopo != null){			
            				simboloVariavel = (SimboloVariavel) b.escopo.resolver(b.getText());
            				loadVar(simboloVariavel);
            			} else if (isInteger(b.getText())) 
            				loadConst(b.getText());
            				
            			if (a.escopo != null){
            				simboloVariavel = (SimboloVariavel)a.escopo.resolver(a.getText());
            				storeVar(simboloVariavel);
            			}
            		
            		}
            		
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "atribuicao"



    // $ANTLR start "addMult"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:426:1: addMult : ^( (op= '+' |op= '*' ) a= . b= . ) ;
    public final void addMult() throws RecognitionException {
        TradutorAST op=null;
        TradutorAST a=null;
        TradutorAST b=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:427:2: ( ^( (op= '+' |op= '*' ) a= . b= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:427:10: ^( (op= '+' |op= '*' ) a= . b= . )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:427:12: (op= '+' |op= '*' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==43) ) {
                alt15=1;
            }
            else if ( (LA15_0==42) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:427:13: op= '+'
                    {
                    op=(TradutorAST)match(input,43,FOLLOW_43_in_addMult738); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:427:24: op= '*'
                    {
                    op=(TradutorAST)match(input,42,FOLLOW_42_in_addMult746); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            b=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            		
            			if (!(op.hasAncestor(VECT_EXPR) || op.hasAncestor(METHOD_CALL))){
            			
            				SimboloVariavel simboloVariavel;
            				
            				if (a.escopo != null){
            					simboloVariavel = (SimboloVariavel) a.escopo.resolver(a.getText());
            					if (simboloVariavel != null)
            						loadVar(simboloVariavel);
            				} else if (isInteger(a.getText()))
            					loadConst(a.getText());
            				
            				if (b.escopo != null){
            					simboloVariavel = (SimboloVariavel) b.escopo.resolver(b.getText());
            					if (simboloVariavel != null)
            						loadVar(simboloVariavel);
            				} else if (isInteger(b.getText()))
            					loadConst(b.getText());
            				
            				if (op.getText().equals("+"))
            					Tradutor.buffer.append("iadd\n");
            				else
            					Tradutor.buffer.append("imul\n");
            					
            			       Tradutor.tipoAtual = new SimboloTipoPrimitivo("int");

            				
            			}
            			
            				
            		}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "addMult"



    // $ANTLR start "subDivEnter"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:462:1: subDivEnter : ^( (op= '-' |op= '/' |op= '%' ) a= . . ) ;
    public final void subDivEnter() throws RecognitionException {
        TradutorAST op=null;
        TradutorAST a=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:463:2: ( ^( (op= '-' |op= '/' |op= '%' ) a= . . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:463:4: ^( (op= '-' |op= '/' |op= '%' ) a= . . )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:463:6: (op= '-' |op= '/' |op= '%' )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt16=1;
                }
                break;
            case 49:
                {
                alt16=2;
                }
                break;
            case 38:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }

            switch (alt16) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:463:7: op= '-'
                    {
                    op=(TradutorAST)match(input,46,FOLLOW_46_in_subDivEnter782); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:463:18: op= '/'
                    {
                    op=(TradutorAST)match(input,49,FOLLOW_49_in_subDivEnter790); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:463:29: op= '%'
                    {
                    op=(TradutorAST)match(input,38,FOLLOW_38_in_subDivEnter798); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            		
            			if (!(op.hasAncestor(VECT_EXPR) || op.hasAncestor(METHOD_CALL))){
            				
            			        SimboloVariavel simboloVariavel;
            				
            				if (a.escopo != null){
            					simboloVariavel = (SimboloVariavel) a.escopo.resolver(a.getText());
            					if (simboloVariavel != null)
            						loadVar(simboloVariavel);
            				} else if (isInteger(a.getText()))
            					loadConst(a.getText());
            					
            			       Tradutor.tipoAtual = new SimboloTipoPrimitivo("int");

            				
            			}
            			
            					
            		}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "subDivEnter"



    // $ANTLR start "subDivExit"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:486:1: subDivExit : ^( (op= '-' |op= '/' |op= '%' ) . b= . ) ;
    public final void subDivExit() throws RecognitionException {
        TradutorAST op=null;
        TradutorAST b=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:487:2: ( ^( (op= '-' |op= '/' |op= '%' ) . b= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:487:5: ^( (op= '-' |op= '/' |op= '%' ) . b= . )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:487:7: (op= '-' |op= '/' |op= '%' )
            int alt17=3;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt17=1;
                }
                break;
            case 49:
                {
                alt17=2;
                }
                break;
            case 38:
                {
                alt17=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:487:8: op= '-'
                    {
                    op=(TradutorAST)match(input,46,FOLLOW_46_in_subDivExit830); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:487:19: op= '/'
                    {
                    op=(TradutorAST)match(input,49,FOLLOW_49_in_subDivExit838); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:487:30: op= '%'
                    {
                    op=(TradutorAST)match(input,38,FOLLOW_38_in_subDivExit846); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return ;
            matchAny(input); if (state.failed) return ;

            b=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            		
            			if (!(op.hasAncestor(VECT_EXPR) || op.hasAncestor(METHOD_CALL))){
            		
            				SimboloVariavel simboloVariavel;
            			
            				if (b.escopo != null){
            					simboloVariavel = (SimboloVariavel) b.escopo.resolver(b.getText());
            					if (simboloVariavel != null)
            						loadVar(simboloVariavel);
            				} else if (isInteger(b.getText()))
            					loadConst(b.getText());
            			
            				if (op.getText().equals("-"))
            					Tradutor.buffer.append("isub\n");
            				else if (op.getText().equals("/"))
            					Tradutor.buffer.append("idiv\n");
            				else
            					Tradutor.buffer.append("irem\n");
            					
            				Tradutor.tipoAtual = new SimboloTipoPrimitivo("int");

            				
            			}
            			
            			
            		}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "subDivExit"



    // $ANTLR start "acessoCampo"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:517:1: acessoCampo : ^( '.' a= . b= . ) ;
    public final void acessoCampo() throws RecognitionException {
        TradutorAST a=null;
        TradutorAST b=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:518:2: ( ^( '.' a= . b= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:518:4: ^( '.' a= . b= . )
            {
            match(input,48,FOLLOW_48_in_acessoCampo874); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            b=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            	
            		if (!(a.hasAncestor(VECT_EXPR) || a.hasAncestor(METHOD_CALL))){
            	
            			SimboloClasse simboloClasse;
            			String instrucao = "";
            			
            			if (a.getText().equals(".")){
                        			simboloClasse = (SimboloClasse)tabelaSimbolos.global.resolver(Tradutor.tipoAtual.getNome());
            				instrucao += "getfield "+simboloClasse.getNome()+"/"+b.getText();
            				SimboloVariavel simboloVariavel = simboloClasse.resolverCampo(b.getText());
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
            			} else if (b.getText().equals(".")){
                        			simboloClasse = (SimboloClasse)tabelaSimbolos.global.resolver(Tradutor.tipoAtual.getNome());
            				instrucao += "getfield "+simboloClasse.getNome()+"/"+a.getText();
            				SimboloVariavel simboloVariavel = simboloClasse.resolverCampo(a.getText());
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
            			} else if (a.escopo != null && b.escopo != null){
            				simboloClasse = (SimboloClasse)tabelaSimbolos.global.resolver(a.getText());
            				if (simboloClasse != null){
            					instrucao += "getstatic "+simboloClasse.getNome()+"/"+b.getText();
            					SimboloVariavel simboloVariavel = simboloClasse.resolverCampo(b.getText());
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
            					loadVar((SimboloVariavel)a.escopo.resolver(a.getText()));
            					simboloClasse = (SimboloClasse)tabelaSimbolos.global.resolver(a.escopo.resolver(a.getText()).getTipo().getNome());
            					instrucao += "getfield "+simboloClasse.getNome()+"/"+b.getText();
            					SimboloVariavel simboloVariavel = simboloClasse.resolverCampo(b.getText());
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

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "acessoCampo"



    // $ANTLR start "vetorExpr"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:594:1: vetorExpr : ^( VECT_EXPR a= . ^( EXPR b= . ) ) ;
    public final void vetorExpr() throws RecognitionException {
        TradutorAST VECT_EXPR5=null;
        TradutorAST a=null;
        TradutorAST b=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:595:2: ( ^( VECT_EXPR a= . ^( EXPR b= . ) ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:595:4: ^( VECT_EXPR a= . ^( EXPR b= . ) )
            {
            VECT_EXPR5=(TradutorAST)match(input,VECT_EXPR,FOLLOW_VECT_EXPR_in_vetorExpr904); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input,EXPR,FOLLOW_EXPR_in_vetorExpr913); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            b=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            		
            			if (toStore != VECT_EXPR5) {
            			
            				CommonTree tree;
            				SimboloVariavel simboloVariavel;
            				
            				if (a.escopo != null) {
            					simboloVariavel = (SimboloVariavel) a.escopo.resolver(a.getText());
            					loadVar(simboloVariavel);						
            				} else if (a.getText().equals(".")){
            					percorrerSubArvore(a);	
            				}
            				
            				if (b.escopo != null) {
            					simboloVariavel = (SimboloVariavel) b.escopo.resolver(b.getText());
            					loadVar(simboloVariavel);	
            				} else if (isInteger(b.getText()))
            					loadConst(b.getText());
            				else{				
            				        percorrerSubArvore(b);
            				}
            				
            				Tradutor.buffer.append("iaload\n");
            				
            				Tradutor.tipoAtual = new SimboloTipoReferencia("int[]");
            				
            			}
            		
            		}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "vetorExpr"



    // $ANTLR start "chamadaMetodo"
    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:628:1: chamadaMetodo : ^( METHOD_CALL a= . ^( LISTA_EXPR (exprs+= . )+ ) ) ;
    public final void chamadaMetodo() throws RecognitionException {
        TradutorAST METHOD_CALL6=null;
        TradutorAST a=null;
        TradutorAST exprs=null;
        List list_exprs=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:629:2: ( ^( METHOD_CALL a= . ^( LISTA_EXPR (exprs+= . )+ ) ) )
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:629:4: ^( METHOD_CALL a= . ^( LISTA_EXPR (exprs+= . )+ ) )
            {
            METHOD_CALL6=(TradutorAST)match(input,METHOD_CALL,FOLLOW_METHOD_CALL_in_chamadaMetodo938); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(TradutorAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input,LISTA_EXPR,FOLLOW_LISTA_EXPR_in_chamadaMetodo947); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:629:43: (exprs+= . )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= BLOCO && LA18_0 <= 74)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // C:\\Users\\Tiago\\Git\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\Ref.g:629:43: exprs+= .
            	    {
            	    exprs=(TradutorAST)input.LT(1);

            	    matchAny(input); if (state.failed) return ;
            	    if (list_exprs==null) list_exprs=new ArrayList();
            	    list_exprs.add(exprs);


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            		
            		SimboloVariavel simboloVariavel;
            		SimboloMetodo simboloMetodo;
            		SimboloClasse simboloClasse;
            		String nomeMetodo;
            		
            		if (a.getText().equals(".")){
            			nomeMetodo = ((Tree)a.getChildren().get(1)).getText();
            			if (((Tree)a.getChildren().get(0)).getText().equals(".")){
            				percorrerSubArvore((TradutorAST)a.getChildren().get(0));
            				simboloClasse = (SimboloClasse)Tradutor.tipoAtual;
            			}else {
            				simboloVariavel = (SimboloVariavel)((TradutorAST)a.getChildren().get(0)).escopo.resolver(((Tree)a.getChildren().get(0)).getText());
            				loadVar(simboloVariavel);
            				simboloClasse = (SimboloClasse)tabelaSimbolos.global.resolver(simboloVariavel.getTipo().getNome());
            			}
            		} else {
            			Tradutor.buffer.append("aload_0\n");
            			simboloClasse = classeAtual;
            			nomeMetodo = a.getText();
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
            		else if (METHOD_CALL6.getParent().getText().equals("new"))
            			call = "invokespecial ";
            		else
            			call = "invokevirtual ";
            		
            		
            		//call += Tradutor.tipoReferencia+"/"+nomeMetodo;*/
            	
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "chamadaMetodo"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA5_eotS =
        "\11\uffff";
    static final String DFA5_eofS =
        "\11\uffff";
    static final String DFA5_minS =
        "\1\4\1\2\1\4\1\2\1\uffff\1\3\2\uffff\1\4";
    static final String DFA5_maxS =
        "\4\112\1\uffff\1\112\2\uffff\1\112";
    static final String DFA5_acceptS =
        "\4\uffff\1\1\1\uffff\1\1\1\2\1\uffff";
    static final String DFA5_specialS =
        "\11\uffff}>";
    static final String[] DFA5_transitionS = {
            "\107\1",
            "\1\2\1\uffff\11\4\1\3\75\4",
            "\107\5",
            "\1\4\1\uffff\11\7\1\6\75\7",
            "",
            "\1\10\107\5",
            "",
            "",
            "\11\4\1\3\75\4"
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "183:25: (st= . )?";
        }
    }
    static final String DFA6_eotS =
        "\7\uffff";
    static final String DFA6_eofS =
        "\7\uffff";
    static final String DFA6_minS =
        "\1\4\1\2\1\uffff\1\3\1\2\1\uffff\1\3";
    static final String DFA6_maxS =
        "\2\112\1\uffff\2\112\1\uffff\1\112";
    static final String DFA6_acceptS =
        "\2\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA6_specialS =
        "\7\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\106\2",
            "\1\3\1\uffff\107\2",
            "",
            "\1\5\107\4",
            "\1\5\1\6\107\4",
            "",
            "\1\5\107\2"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "()* loopback of 183:45: (parm= . )*";
        }
    }
    static final String DFA8_eotS =
        "\7\uffff";
    static final String DFA8_eofS =
        "\7\uffff";
    static final String DFA8_minS =
        "\1\4\1\2\1\uffff\1\3\1\2\1\uffff\1\3";
    static final String DFA8_maxS =
        "\2\112\1\uffff\2\112\1\uffff\1\112";
    static final String DFA8_acceptS =
        "\2\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA8_specialS =
        "\7\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\106\2",
            "\1\3\1\uffff\107\2",
            "",
            "\1\5\107\4",
            "\1\5\1\6\107\4",
            "",
            "\1\5\107\2"
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()* loopback of 227:27: (parm= . )*";
        }
    }
    static final String DFA11_eotS =
        "\11\uffff";
    static final String DFA11_eofS =
        "\11\uffff";
    static final String DFA11_minS =
        "\1\4\1\2\1\4\1\2\1\uffff\1\3\2\uffff\1\4";
    static final String DFA11_maxS =
        "\4\112\1\uffff\1\112\2\uffff\1\112";
    static final String DFA11_acceptS =
        "\4\uffff\1\1\1\uffff\1\1\1\2\1\uffff";
    static final String DFA11_specialS =
        "\11\uffff}>";
    static final String[] DFA11_transitionS = {
            "\107\1",
            "\1\2\1\uffff\11\4\1\3\75\4",
            "\107\5",
            "\1\4\12\7\1\6\75\7",
            "",
            "\1\10\107\5",
            "",
            "",
            "\11\4\1\3\75\4"
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "328:25: (st= . )?";
        }
    }
 

    public static final BitSet FOLLOW_enterClass_in_topdown60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enterMethod_in_topdown70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enterConstructor_in_topdown80 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enterParam_in_topdown90 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_enterField_in_topdown100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subDivEnter_in_topdown110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitClass_in_bottomup129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitMethod_in_bottomup139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitConstructor_in_bottomup149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitParams_in_bottomup159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listaVarDeclAtribuicao_in_bottomup169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atribuicao_in_bottomup179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addMult_in_bottomup189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subDivExit_in_bottomup199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_acessoCampo_in_bottomup209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vetorExpr_in_bottomup219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_chamadaMetodo_in_bottomup229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CLASSE_in_enterClass249 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_enterClass255 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000007FFL});
    public static final BitSet FOLLOW_EXTENDS_in_enterClass259 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_enterClass265 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLASSE_in_exitClass301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METHOD_DECL_in_enterMethod334 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_enterMethod349 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000007FFL});
    public static final BitSet FOLLOW_BLOCO_in_enterMethod359 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CONSTR_DECL_in_enterConstructor395 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_enterConstructor397 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000007FFL});
    public static final BitSet FOLLOW_BLOCO_in_enterConstructor407 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_METHOD_DECL_in_exitMethod446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTR_DECL_in_exitConstructor475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARAM_in_enterParam509 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_enterParam517 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF8L,0x00000000000007FFL});
    public static final BitSet FOLLOW_PARAMS_in_exitParams554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FIELD_DECL_in_enterField575 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_enterField590 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF8L,0x00000000000007FFL});
    public static final BitSet FOLLOW_LISTA_VAR_DECL_in_listaVarDeclAtribuicao634 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VAR_DECL_in_listaVarDeclAtribuicao637 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_listaVarDeclAtribuicao645 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000000000007FFL});
    public static final BitSet FOLLOW_EXPR_in_listaVarDeclAtribuicao654 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_53_in_atribuicao698 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_43_in_addMult738 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_42_in_addMult746 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_46_in_subDivEnter782 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_49_in_subDivEnter790 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_38_in_subDivEnter798 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_46_in_subDivExit830 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_49_in_subDivExit838 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_38_in_subDivExit846 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_48_in_acessoCampo874 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_VECT_EXPR_in_vetorExpr904 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EXPR_in_vetorExpr913 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_METHOD_CALL_in_chamadaMetodo938 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LISTA_EXPR_in_chamadaMetodo947 = new BitSet(new long[]{0x0000000000000004L});

}