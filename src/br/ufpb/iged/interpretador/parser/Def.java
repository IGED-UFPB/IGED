// $ANTLR 3.4 C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g 2013-05-06 22:23:23

    package br.ufpb.iged.interpretador.parser;
    
    import br.ufpb.iged.interpretador.symboltable.classes.BytecodesAST;
import br.ufpb.iged.interpretador.symboltable.classes.Escopo;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloClasse;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloVariavel;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloMetodo;
import br.ufpb.iged.interpretador.symboltable.classes.TabelaSimbolos;
import br.ufpb.iged.interpretador.symboltable.classes.EscopoLocal;
import br.ufpb.iged.interpretador.excecoes.LabelException;
import br.ufpb.iged.interpretador.principal.Interpretador;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Def extends TreeFilter {
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
    public TreeFilter[] getDelegates() {
        return new TreeFilter[] {};
    }

    // delegators


    public Def(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public Def(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return Def.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g"; }


        TabelaSimbolos tabelaSimbolos;
        Escopo escopoAtual;
        int contador;
        public Def(TreeNodeStream input, TabelaSimbolos tabelaSimbolos) {
            this(input);
            this.tabelaSimbolos = tabelaSimbolos;
            escopoAtual = tabelaSimbolos.global;
        }



    // $ANTLR start "topdown"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:33:1: topdown : ( entraNoCorpoMetodo | entraNoConstrutor | entraNoMetodo | entraNaClasse | declaracaoVariavel | field | invoke | nenhumoperando | umoperando | label );
    public final void topdown() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:33:9: ( entraNoCorpoMetodo | entraNoConstrutor | entraNoMetodo | entraNaClasse | declaracaoVariavel | field | invoke | nenhumoperando | umoperando | label )
            int alt1=10;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:33:11: entraNoCorpoMetodo
                    {
                    pushFollow(FOLLOW_entraNoCorpoMetodo_in_topdown49);
                    entraNoCorpoMetodo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:34:11: entraNoConstrutor
                    {
                    pushFollow(FOLLOW_entraNoConstrutor_in_topdown61);
                    entraNoConstrutor();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:35:11: entraNoMetodo
                    {
                    pushFollow(FOLLOW_entraNoMetodo_in_topdown73);
                    entraNoMetodo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:36:11: entraNaClasse
                    {
                    pushFollow(FOLLOW_entraNaClasse_in_topdown85);
                    entraNaClasse();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:38:11: declaracaoVariavel
                    {
                    pushFollow(FOLLOW_declaracaoVariavel_in_topdown106);
                    declaracaoVariavel();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:39:11: field
                    {
                    pushFollow(FOLLOW_field_in_topdown118);
                    field();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:40:11: invoke
                    {
                    pushFollow(FOLLOW_invoke_in_topdown130);
                    invoke();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:41:11: nenhumoperando
                    {
                    pushFollow(FOLLOW_nenhumoperando_in_topdown142);
                    nenhumoperando();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:42:11: umoperando
                    {
                    pushFollow(FOLLOW_umoperando_in_topdown154);
                    umoperando();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:43:11: label
                    {
                    pushFollow(FOLLOW_label_in_topdown166);
                    label();

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
    // $ANTLR end "topdown"



    // $ANTLR start "bottomup"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:46:1: bottomup : ( saiDoCorpoMetodo | saiDoMetodo | saiDoConstrutor | saiDaClasse );
    public final void bottomup() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:46:10: ( saiDoCorpoMetodo | saiDoMetodo | saiDoConstrutor | saiDaClasse )
            int alt2=4;
            switch ( input.LA(1) ) {
            case BODY:
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
            case 36:
                {
                alt2=4;
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
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:46:12: saiDoCorpoMetodo
                    {
                    pushFollow(FOLLOW_saiDoCorpoMetodo_in_bottomup183);
                    saiDoCorpoMetodo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:47:12: saiDoMetodo
                    {
                    pushFollow(FOLLOW_saiDoMetodo_in_bottomup196);
                    saiDoMetodo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:48:12: saiDoConstrutor
                    {
                    pushFollow(FOLLOW_saiDoConstrutor_in_bottomup209);
                    saiDoConstrutor();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:49:12: saiDaClasse
                    {
                    pushFollow(FOLLOW_saiDaClasse_in_bottomup222);
                    saiDaClasse();

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



    // $ANTLR start "entraNaClasse"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:52:1: entraNaClasse : ^( '.class' nome= ID ( ^( EXTENDS sup= . ) )? . ) ;
    public final void entraNaClasse() throws RecognitionException {
        BytecodesAST nome=null;
        BytecodesAST sup=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:53:5: ( ^( '.class' nome= ID ( ^( EXTENDS sup= . ) )? . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:53:7: ^( '.class' nome= ID ( ^( EXTENDS sup= . ) )? . )
            {
            match(input,36,FOLLOW_36_in_entraNaClasse254); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            nome=(BytecodesAST)match(input,ID,FOLLOW_ID_in_entraNaClasse258); if (state.failed) return ;

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:53:26: ( ^( EXTENDS sup= . ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==EXTENDS) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==DOWN) ) {
                    int LA3_3 = input.LA(3);

                    if ( ((LA3_3 >= ARGS && LA3_3 <= 111)) ) {
                        int LA3_4 = input.LA(4);

                        if ( (LA3_4==DOWN) ) {
                            alt3=1;
                        }
                        else if ( (LA3_4==UP) ) {
                            int LA3_6 = input.LA(5);

                            if ( ((LA3_6 >= ARGS && LA3_6 <= 111)) ) {
                                alt3=1;
                            }
                        }
                    }
                }
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:53:27: ^( EXTENDS sup= . )
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_entraNaClasse262); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    sup=(BytecodesAST)input.LT(1);

                    matchAny(input); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;

            }


            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
                       System.out.println("linha "+nome.getLine()+
                                      ": def class "+(nome!=null?nome.getText():null));
                       if ( sup!=null )
                         sup.escopo = escopoAtual;
                       SimboloClasse classe = new SimboloClasse("L" + (nome!=null?nome.getText():null),escopoAtual,null);
                       classe.def = nome;
                       nome.simbolo = classe;
                       escopoAtual.definir(classe);
                       escopoAtual = classe;
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
    // $ANTLR end "entraNaClasse"


    public static class declaracaoVariavel_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "declaracaoVariavel"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:67:1: declaracaoVariavel : ^( FIELD_DECL (st= . )? ID tipo= . ) ;
    public final Def.declaracaoVariavel_return declaracaoVariavel() throws RecognitionException {
        Def.declaracaoVariavel_return retval = new Def.declaracaoVariavel_return();
        retval.start = input.LT(1);


        BytecodesAST ID1=null;
        BytecodesAST st=null;
        BytecodesAST tipo=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:68:5: ( ^( FIELD_DECL (st= . )? ID tipo= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:68:7: ^( FIELD_DECL (st= . )? ID tipo= . )
            {
            match(input,FIELD_DECL,FOLLOW_FIELD_DECL_in_declaracaoVariavel302); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:68:20: (st= . )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==DOWN) ) {
                    alt4=1;
                }
                else if ( (LA4_1==ID) ) {
                    int LA4_3 = input.LA(3);

                    if ( ((LA4_3 >= ARGS && LA4_3 <= 111)) ) {
                        alt4=1;
                    }
                }
            }
            else if ( ((LA4_0 >= ARGS && LA4_0 <= FIELD_DECL)||(LA4_0 >= INIT && LA4_0 <= 111)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:68:21: st= .
                    {
                    st=(BytecodesAST)input.LT(1);

                    matchAny(input); if (state.failed) return retval;

                    }
                    break;

            }


            ID1=(BytecodesAST)match(input,ID,FOLLOW_ID_in_declaracaoVariavel312); if (state.failed) return retval;

            tipo=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;


            if ( state.backtracking==1 ) {
                      System.out.println("linha "+ID1.getLine()+": def "+(ID1!=null?ID1.getText():null));
                      tipo.escopo = escopoAtual;
                      boolean estatico = st != null;
                      SimboloVariavel variavel = new SimboloVariavel((ID1!=null?ID1.getText():null),null,estatico);
                      variavel.def = ID1;
                      ID1.simbolo = variavel;
                      escopoAtual.definir(variavel);
                      ((SimboloClasse)escopoAtual).getConstantPool().add(variavel);
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
    // $ANTLR end "declaracaoVariavel"



    // $ANTLR start "entraNoConstrutor"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:81:1: entraNoConstrutor : ^( CONSTR_DECL INIT tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . ) ;
    public final void entraNoConstrutor() throws RecognitionException {
        BytecodesAST lim=null;
        BytecodesAST INIT2=null;
        BytecodesAST tipoRet=null;
        BytecodesAST a=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:82:2: ( ^( CONSTR_DECL INIT tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:82:4: ^( CONSTR_DECL INIT tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . )
            {
            match(input,CONSTR_DECL,FOLLOW_CONSTR_DECL_in_entraNoConstrutor347); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            INIT2=(BytecodesAST)match(input,INIT,FOLLOW_INIT_in_entraNoConstrutor349); if (state.failed) return ;

            tipoRet=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input,PARAMS,FOLLOW_PARAMS_in_entraNoConstrutor357); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:82:49: ( ^( LIMIT lim= INTEIRO ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LIMIT) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==DOWN) ) {
                    int LA5_3 = input.LA(3);

                    if ( (LA5_3==INTEIRO) ) {
                        int LA5_4 = input.LA(4);

                        if ( (LA5_4==UP) ) {
                            int LA5_5 = input.LA(5);

                            if ( ((LA5_5 >= ARGS && LA5_5 <= 111)) ) {
                                alt5=1;
                            }
                        }
                    }
                }
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:82:50: ^( LIMIT lim= INTEIRO )
                    {
                    match(input,LIMIT,FOLLOW_LIMIT_in_entraNoConstrutor367); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    lim=(BytecodesAST)match(input,INTEIRO,FOLLOW_INTEIRO_in_entraNoConstrutor371); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;

            }


            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            	   System.out.println("linha "+INIT2.getLine()+
                                      ": def method init ");
                       SimboloMetodo metodo = new SimboloMetodo((INIT2!=null?INIT2.getText():null)+"("+a.getText()+")"+tipoRet.getText(), null, escopoAtual);
                       if (lim != null)
                       	metodo.setTamanhoMemoriaLocalVariaveis(new Integer(lim.getText()));
                       metodo.setRetorno(tipoRet.getText());
                       metodo.def = INIT2;
                       INIT2.simbolo = metodo;
                       escopoAtual.definir(metodo);
                       escopoAtual = metodo;
                       contador = 0;
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
    // $ANTLR end "entraNoConstrutor"



    // $ANTLR start "entraNoMetodo"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:98:1: entraNoMetodo : ^( METHOD_DECL ID tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . ) ;
    public final void entraNoMetodo() throws RecognitionException {
        BytecodesAST lim=null;
        BytecodesAST ID3=null;
        BytecodesAST tipoRet=null;
        BytecodesAST a=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:99:2: ( ^( METHOD_DECL ID tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:99:4: ^( METHOD_DECL ID tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . )
            {
            match(input,METHOD_DECL,FOLLOW_METHOD_DECL_in_entraNoMetodo393); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            ID3=(BytecodesAST)match(input,ID,FOLLOW_ID_in_entraNoMetodo395); if (state.failed) return ;

            tipoRet=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input,PARAMS,FOLLOW_PARAMS_in_entraNoMetodo403); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:99:47: ( ^( LIMIT lim= INTEIRO ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LIMIT) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==DOWN) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==INTEIRO) ) {
                        int LA6_4 = input.LA(4);

                        if ( (LA6_4==UP) ) {
                            int LA6_5 = input.LA(5);

                            if ( ((LA6_5 >= ARGS && LA6_5 <= 111)) ) {
                                alt6=1;
                            }
                        }
                    }
                }
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:99:48: ^( LIMIT lim= INTEIRO )
                    {
                    match(input,LIMIT,FOLLOW_LIMIT_in_entraNoMetodo413); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    lim=(BytecodesAST)match(input,INTEIRO,FOLLOW_INTEIRO_in_entraNoMetodo417); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;

            }


            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            	   System.out.println("linha "+ID3.getLine()+
                                      ": def method "+(ID3!=null?ID3.getText():null));
                       SimboloMetodo metodo = new SimboloMetodo((ID3!=null?ID3.getText():null)+"("+a.getText()+")"+tipoRet.getText(), null, escopoAtual);
                       if (lim != null)
                       	metodo.setTamanhoMemoriaLocalVariaveis(new Integer(lim.getText()));
                       metodo.setRetorno(tipoRet.getText());
                       metodo.def = ID3;
                       ID3.simbolo = metodo;
                       escopoAtual.definir(metodo);
                       escopoAtual = metodo;
                       contador = 0;
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
    // $ANTLR end "entraNoMetodo"



    // $ANTLR start "entraNoCorpoMetodo"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:115:1: entraNoCorpoMetodo : BODY ;
    public final void entraNoCorpoMetodo() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:116:5: ( BODY )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:116:9: BODY
            {
            match(input,BODY,FOLLOW_BODY_in_entraNoCorpoMetodo444); if (state.failed) return ;

            if ( state.backtracking==1 ) {escopoAtual = new EscopoLocal(escopoAtual);}

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
    // $ANTLR end "entraNoCorpoMetodo"



    // $ANTLR start "saiDoCorpoMetodo"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:119:1: saiDoCorpoMetodo : BODY ;
    public final void saiDoCorpoMetodo() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:120:5: ( BODY )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:120:9: BODY
            {
            match(input,BODY,FOLLOW_BODY_in_saiDoCorpoMetodo470); if (state.failed) return ;

            if ( state.backtracking==1 ) {
                    System.out.println("locals: "+escopoAtual);
                    escopoAtual = escopoAtual.obterEscopoEnvolvente();    
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
    // $ANTLR end "saiDoCorpoMetodo"



    // $ANTLR start "saiDaClasse"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:127:1: saiDaClasse : '.class' ;
    public final void saiDaClasse() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:127:13: ( '.class' )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:127:15: '.class'
            {
            match(input,36,FOLLOW_36_in_saiDaClasse497); if (state.failed) return ;

            if ( state.backtracking==1 ) {
                          System.out.println("Saindo da classe.. membros: "+escopoAtual);
                          escopoAtual = escopoAtual.obterEscopoEnvolvente(); 
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
    // $ANTLR end "saiDaClasse"



    // $ANTLR start "saiDoMetodo"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:134:1: saiDoMetodo : METHOD_DECL ;
    public final void saiDoMetodo() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:135:2: ( METHOD_DECL )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:135:5: METHOD_DECL
            {
            match(input,METHOD_DECL,FOLLOW_METHOD_DECL_in_saiDoMetodo547); if (state.failed) return ;

            if ( state.backtracking==1 ) {
            	   System.out.println("Saindo do metodo: "+escopoAtual);
            	   escopoAtual = escopoAtual.obterEscopoEnvolvente(); 
                       
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
    // $ANTLR end "saiDoMetodo"



    // $ANTLR start "saiDoConstrutor"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:143:1: saiDoConstrutor : CONSTR_DECL ;
    public final void saiDoConstrutor() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:144:2: ( CONSTR_DECL )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:144:5: CONSTR_DECL
            {
            match(input,CONSTR_DECL,FOLLOW_CONSTR_DECL_in_saiDoConstrutor563); if (state.failed) return ;

            if ( state.backtracking==1 ) {
            	   System.out.println("Saindo do construtor: "+escopoAtual);
                       escopoAtual = escopoAtual.obterEscopoEnvolvente(); 
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
    // $ANTLR end "saiDoConstrutor"



    // $ANTLR start "field"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:152:1: field : ^( (a= 'getfield' |a= 'getstatic' |a= 'putfield' |a= 'putstatic' ) . . ) ;
    public final void field() throws RecognitionException {
        BytecodesAST a=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:152:7: ( ^( (a= 'getfield' |a= 'getstatic' |a= 'putfield' |a= 'putstatic' ) . . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:152:9: ^( (a= 'getfield' |a= 'getstatic' |a= 'putfield' |a= 'putstatic' ) . . )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:152:11: (a= 'getfield' |a= 'getstatic' |a= 'putfield' |a= 'putstatic' )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt7=1;
                }
                break;
            case 58:
                {
                alt7=2;
                }
                break;
            case 108:
                {
                alt7=3;
                }
                break;
            case 109:
                {
                alt7=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:152:12: a= 'getfield'
                    {
                    a=(BytecodesAST)match(input,57,FOLLOW_57_in_field585); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:152:29: a= 'getstatic'
                    {
                    a=(BytecodesAST)match(input,58,FOLLOW_58_in_field593); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:152:47: a= 'putfield'
                    {
                    a=(BytecodesAST)match(input,108,FOLLOW_108_in_field601); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:152:64: a= 'putstatic'
                    {
                    a=(BytecodesAST)match(input,109,FOLLOW_109_in_field609); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return ;
            matchAny(input); if (state.failed) return ;

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {           
                       if (a.equals("getstatic") || a.equals("putstatic"))
                       	contador += 9;
                       else
                          contador += 5;
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
    // $ANTLR end "field"



    // $ANTLR start "invoke"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:161:1: invoke : ^( ( 'invokespecial' | 'invokestatic' | 'invokevirtual' ) . ^( METHOD_CALL ^( PARAMS . ) . ) ) ;
    public final void invoke() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:161:9: ( ^( ( 'invokespecial' | 'invokestatic' | 'invokevirtual' ) . ^( METHOD_CALL ^( PARAMS . ) . ) ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:161:11: ^( ( 'invokespecial' | 'invokestatic' | 'invokevirtual' ) . ^( METHOD_CALL ^( PARAMS . ) . ) )
            {
            if ( (input.LA(1) >= 90 && input.LA(1) <= 92) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return ;
            matchAny(input); if (state.failed) return ;

            match(input,METHOD_CALL,FOLLOW_METHOD_CALL_in_invoke667); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,PARAMS,FOLLOW_PARAMS_in_invoke670); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
                      contador += 9;
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
    // $ANTLR end "invoke"



    // $ANTLR start "nenhumoperando"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:167:1: nenhumoperando : ^( ( RETURN | ARITMETICA | NEW | LOAD | STORE | LOGICA | PILHA ) . ) ;
    public final void nenhumoperando() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:168:2: ( ^( ( RETURN | ARITMETICA | NEW | LOAD | STORE | LOGICA | PILHA ) . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:168:4: ^( ( RETURN | ARITMETICA | NEW | LOAD | STORE | LOGICA | PILHA ) . )
            {
            if ( input.LA(1)==ARITMETICA||(input.LA(1) >= LOAD && input.LA(1) <= LOGICA)||input.LA(1)==NEW||input.LA(1)==PILHA||(input.LA(1) >= RETURN && input.LA(1) <= STORE) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return ;
            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            	   contador++;
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
    // $ANTLR end "nenhumoperando"



    // $ANTLR start "umoperando"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:174:1: umoperando : ^( ( DESVIO | LOAD | STORE ) . . ) ;
    public final void umoperando() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:175:9: ( ^( ( DESVIO | LOAD | STORE ) . . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:175:11: ^( ( DESVIO | LOAD | STORE ) . . )
            {
            if ( input.LA(1)==DESVIO||input.LA(1)==LOAD||input.LA(1)==STORE ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); if (state.failed) return ;
            matchAny(input); if (state.failed) return ;

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
                      contador += 5;
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
    // $ANTLR end "umoperando"



    // $ANTLR start "label"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:180:1: label : ^( LABEL id= . ) ;
    public final void label() throws RecognitionException {
        BytecodesAST id=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:181:4: ( ^( LABEL id= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:181:6: ^( LABEL id= . )
            {
            match(input,LABEL,FOLLOW_LABEL_in_label821); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            id=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
                  System.out.println("Definindo label "+id.getText()+" no endereço "+contador);
                  SimboloMetodo metodo = (SimboloMetodo) escopoAtual.obterEscopoEnvolvente();
                  metodo.definirLabel(id.token, contador);
               }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        } catch (LabelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "label"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\21\uffff";
    static final String DFA1_eofS =
        "\21\uffff";
    static final String DFA1_minS =
        "\1\5\7\uffff\1\2\3\uffff\1\4\1\2\1\4\2\3";
    static final String DFA1_maxS =
        "\1\155\7\uffff\1\2\3\uffff\5\157";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\10\1\11\1\12\5\uffff";
    static final String DFA1_specialS =
        "\21\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\11\1\1\1\2\1\12\1\uffff\1\5\4\uffff\1\13\1\uffff\1\10\1\11"+
            "\2\uffff\1\3\1\11\3\uffff\1\11\1\uffff\1\11\1\10\6\uffff\1\4"+
            "\24\uffff\2\6\37\uffff\3\7\17\uffff\2\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14",
            "",
            "",
            "",
            "\154\15",
            "\1\16\1\11\154\12",
            "\154\17",
            "\1\20\154\17",
            "\1\11\154\12"
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "33:1: topdown : ( entraNoCorpoMetodo | entraNoConstrutor | entraNoMetodo | entraNaClasse | declaracaoVariavel | field | invoke | nenhumoperando | umoperando | label );";
        }
    }
 

    public static final BitSet FOLLOW_entraNoCorpoMetodo_in_topdown49 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entraNoConstrutor_in_topdown61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entraNoMetodo_in_topdown73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entraNaClasse_in_topdown85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoVariavel_in_topdown106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_in_topdown118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invoke_in_topdown130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nenhumoperando_in_topdown142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_umoperando_in_topdown154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_label_in_topdown166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saiDoCorpoMetodo_in_bottomup183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saiDoMetodo_in_bottomup196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saiDoConstrutor_in_bottomup209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saiDaClasse_in_bottomup222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_entraNaClasse254 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_entraNaClasse258 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_EXTENDS_in_entraNaClasse262 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FIELD_DECL_in_declaracaoVariavel302 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_declaracaoVariavel312 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_CONSTR_DECL_in_entraNoConstrutor347 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INIT_in_entraNoConstrutor349 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_PARAMS_in_entraNoConstrutor357 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LIMIT_in_entraNoConstrutor367 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEIRO_in_entraNoConstrutor371 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_METHOD_DECL_in_entraNoMetodo393 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_entraNoMetodo395 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_PARAMS_in_entraNoMetodo403 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LIMIT_in_entraNoMetodo413 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEIRO_in_entraNoMetodo417 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BODY_in_entraNoCorpoMetodo444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_in_saiDoCorpoMetodo470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_saiDaClasse497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METHOD_DECL_in_saiDoMetodo547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTR_DECL_in_saiDoConstrutor563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_field585 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_58_in_field593 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_108_in_field601 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_109_in_field609 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_invoke652 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_METHOD_CALL_in_invoke667 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PARAMS_in_invoke670 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_nenhumoperando715 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_umoperando769 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LABEL_in_label821 = new BitSet(new long[]{0x0000000000000004L});

}