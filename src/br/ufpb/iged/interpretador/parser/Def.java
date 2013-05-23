// $ANTLR 3.4 C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g 2013-05-22 23:48:00

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARGS", "ARITMETICA", "BODY", "CONSTR_DECL", "DESVIO", "EXTENDS", "FIELD_DECL", "ID", "INIT", "INT", "INTEIRO", "LABEL", "LIMIT", "LOAD", "LOGICA", "MEMBRO_CLASSE", "METHOD_CALL", "METHOD_DECL", "NEW", "NEWARRAY", "NEWLINE", "NULL", "PARAMS", "PILHA", "REF", "RETURN", "STORE", "TIPOARRAY", "TIPO_REF", "VOID", "WS", "'('", "'()'", "')'", "'.class'", "'.end class'", "'.end method'", "'.field'", "'.limit locals'", "'.method'", "'.super'", "':'", "'aconst_null'", "'aload'", "'aload_0'", "'aload_1'", "'aload_2'", "'aload_3'", "'areturn'", "'astore'", "'astore_0'", "'astore_1'", "'astore_2'", "'astore_3'", "'dup'", "'getfield'", "'getstatic'", "'goto'", "'iadd'", "'iaload'", "'iand'", "'iastore'", "'iconst_0'", "'iconst_1'", "'iconst_2'", "'iconst_3'", "'iconst_4'", "'iconst_5'", "'iconst_m1'", "'idiv'", "'if_icmpeq'", "'if_icmpge'", "'if_icmpgt'", "'if_icmple'", "'if_icmplt'", "'if_icmpne'", "'ifeq'", "'ifge'", "'ifgt'", "'ifle'", "'iflt'", "'ifne'", "'iinc'", "'iload'", "'iload_0'", "'iload_1'", "'iload_2'", "'iload_3'", "'imul'", "'ineg'", "'invokespecial'", "'invokestatic'", "'invokevirtual'", "'ior'", "'irem'", "'ireturn'", "'istore'", "'istore_0'", "'istore_1'", "'istore_2'", "'istore_3'", "'isub'", "'ixor'", "'ldc'", "'new'", "'newarray'", "'nop'", "'pop'", "'pop2'", "'putfield'", "'putstatic'", "'return'", "'static'"
    };

    public static final int EOF=-1;
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
    public static final int T__112=112;
    public static final int T__113=113;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__116=116;
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
    public static final int NEWARRAY=23;
    public static final int NEWLINE=24;
    public static final int NULL=25;
    public static final int PARAMS=26;
    public static final int PILHA=27;
    public static final int REF=28;
    public static final int RETURN=29;
    public static final int STORE=30;
    public static final int TIPOARRAY=31;
    public static final int TIPO_REF=32;
    public static final int VOID=33;
    public static final int WS=34;

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
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:37:11: declaracaoVariavel
                    {
                    pushFollow(FOLLOW_declaracaoVariavel_in_topdown97);
                    declaracaoVariavel();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:38:11: field
                    {
                    pushFollow(FOLLOW_field_in_topdown109);
                    field();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:39:11: invoke
                    {
                    pushFollow(FOLLOW_invoke_in_topdown121);
                    invoke();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:40:11: nenhumoperando
                    {
                    pushFollow(FOLLOW_nenhumoperando_in_topdown133);
                    nenhumoperando();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:41:11: umoperando
                    {
                    pushFollow(FOLLOW_umoperando_in_topdown145);
                    umoperando();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:42:11: label
                    {
                    pushFollow(FOLLOW_label_in_topdown157);
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:45:1: bottomup : ( saiDoCorpoMetodo | saiDoMetodo | saiDoConstrutor | saiDaClasse );
    public final void bottomup() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:45:10: ( saiDoCorpoMetodo | saiDoMetodo | saiDoConstrutor | saiDaClasse )
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
            case 38:
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
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:45:12: saiDoCorpoMetodo
                    {
                    pushFollow(FOLLOW_saiDoCorpoMetodo_in_bottomup174);
                    saiDoCorpoMetodo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:46:12: saiDoMetodo
                    {
                    pushFollow(FOLLOW_saiDoMetodo_in_bottomup187);
                    saiDoMetodo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:47:12: saiDoConstrutor
                    {
                    pushFollow(FOLLOW_saiDoConstrutor_in_bottomup200);
                    saiDoConstrutor();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:48:12: saiDaClasse
                    {
                    pushFollow(FOLLOW_saiDaClasse_in_bottomup213);
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:51:1: entraNaClasse : ^( '.class' nome= ID ( ^( EXTENDS sup= . ) )? . ) ;
    public final void entraNaClasse() throws RecognitionException {
        BytecodesAST nome=null;
        BytecodesAST sup=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:52:5: ( ^( '.class' nome= ID ( ^( EXTENDS sup= . ) )? . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:52:7: ^( '.class' nome= ID ( ^( EXTENDS sup= . ) )? . )
            {
            match(input,38,FOLLOW_38_in_entraNaClasse245); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            nome=(BytecodesAST)match(input,ID,FOLLOW_ID_in_entraNaClasse249); if (state.failed) return ;

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:52:26: ( ^( EXTENDS sup= . ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==EXTENDS) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==DOWN) ) {
                    int LA3_3 = input.LA(3);

                    if ( ((LA3_3 >= ARGS && LA3_3 <= 116)) ) {
                        int LA3_4 = input.LA(4);

                        if ( (LA3_4==DOWN) ) {
                            alt3=1;
                        }
                        else if ( (LA3_4==UP) ) {
                            int LA3_6 = input.LA(5);

                            if ( ((LA3_6 >= ARGS && LA3_6 <= 116)) ) {
                                alt3=1;
                            }
                        }
                    }
                }
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:52:27: ^( EXTENDS sup= . )
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_entraNaClasse253); if (state.failed) return ;

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:66:1: declaracaoVariavel : ^( FIELD_DECL (st= . )? ID tipo= . ) ;
    public final Def.declaracaoVariavel_return declaracaoVariavel() throws RecognitionException {
        Def.declaracaoVariavel_return retval = new Def.declaracaoVariavel_return();
        retval.start = input.LT(1);


        BytecodesAST ID1=null;
        BytecodesAST st=null;
        BytecodesAST tipo=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:67:5: ( ^( FIELD_DECL (st= . )? ID tipo= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:67:7: ^( FIELD_DECL (st= . )? ID tipo= . )
            {
            match(input,FIELD_DECL,FOLLOW_FIELD_DECL_in_declaracaoVariavel293); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:67:20: (st= . )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ID) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==DOWN) ) {
                    alt4=1;
                }
                else if ( (LA4_1==ID) ) {
                    int LA4_3 = input.LA(3);

                    if ( ((LA4_3 >= ARGS && LA4_3 <= 116)) ) {
                        alt4=1;
                    }
                }
            }
            else if ( ((LA4_0 >= ARGS && LA4_0 <= FIELD_DECL)||(LA4_0 >= INIT && LA4_0 <= 116)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:67:21: st= .
                    {
                    st=(BytecodesAST)input.LT(1);

                    matchAny(input); if (state.failed) return retval;

                    }
                    break;

            }


            ID1=(BytecodesAST)match(input,ID,FOLLOW_ID_in_declaracaoVariavel303); if (state.failed) return retval;

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:80:1: entraNoConstrutor : ^( CONSTR_DECL INIT tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . ) ;
    public final void entraNoConstrutor() throws RecognitionException {
        BytecodesAST lim=null;
        BytecodesAST INIT2=null;
        BytecodesAST tipoRet=null;
        BytecodesAST a=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:81:2: ( ^( CONSTR_DECL INIT tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:81:4: ^( CONSTR_DECL INIT tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . )
            {
            match(input,CONSTR_DECL,FOLLOW_CONSTR_DECL_in_entraNoConstrutor338); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            INIT2=(BytecodesAST)match(input,INIT,FOLLOW_INIT_in_entraNoConstrutor340); if (state.failed) return ;

            tipoRet=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input,PARAMS,FOLLOW_PARAMS_in_entraNoConstrutor348); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:81:49: ( ^( LIMIT lim= INTEIRO ) )?
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

                            if ( ((LA5_5 >= ARGS && LA5_5 <= 116)) ) {
                                alt5=1;
                            }
                        }
                    }
                }
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:81:50: ^( LIMIT lim= INTEIRO )
                    {
                    match(input,LIMIT,FOLLOW_LIMIT_in_entraNoConstrutor358); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    lim=(BytecodesAST)match(input,INTEIRO,FOLLOW_INTEIRO_in_entraNoConstrutor362); if (state.failed) return ;

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
                       metodo.setEstatico(false);
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:98:1: entraNoMetodo : ^( METHOD_DECL (st= . )? ID tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . ) ;
    public final void entraNoMetodo() throws RecognitionException {
        BytecodesAST lim=null;
        BytecodesAST ID3=null;
        BytecodesAST st=null;
        BytecodesAST tipoRet=null;
        BytecodesAST a=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:99:2: ( ^( METHOD_DECL (st= . )? ID tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:99:4: ^( METHOD_DECL (st= . )? ID tipoRet= . ^( PARAMS a= . ) ( ^( LIMIT lim= INTEIRO ) )? . )
            {
            match(input,METHOD_DECL,FOLLOW_METHOD_DECL_in_entraNoMetodo384); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:99:18: (st= . )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==ID) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==DOWN) ) {
                    alt6=1;
                }
                else if ( (LA6_1==ID) ) {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==PARAMS) ) {
                        int LA6_5 = input.LA(4);

                        if ( (LA6_5==DOWN) ) {
                            int LA6_6 = input.LA(5);

                            if ( ((LA6_6 >= ARGS && LA6_6 <= 116)) ) {
                                int LA6_7 = input.LA(6);

                                if ( (LA6_7==UP) ) {
                                    int LA6_8 = input.LA(7);

                                    if ( (LA6_8==PARAMS) ) {
                                        int LA6_9 = input.LA(8);

                                        if ( (LA6_9==DOWN) ) {
                                            int LA6_10 = input.LA(9);

                                            if ( ((LA6_10 >= ARGS && LA6_10 <= 116)) ) {
                                                int LA6_11 = input.LA(10);

                                                if ( (LA6_11==DOWN) ) {
                                                    alt6=1;
                                                }
                                                else if ( (LA6_11==UP) ) {
                                                    int LA6_12 = input.LA(11);

                                                    if ( ((LA6_12 >= ARGS && LA6_12 <= 116)) ) {
                                                        alt6=1;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                else if ( ((LA6_7 >= ARGS && LA6_7 <= 116)) ) {
                                    alt6=1;
                                }
                            }
                        }
                        else if ( (LA6_5==PARAMS) ) {
                            alt6=1;
                        }
                    }
                    else if ( ((LA6_3 >= ARGS && LA6_3 <= NULL)||(LA6_3 >= PILHA && LA6_3 <= 116)) ) {
                        alt6=1;
                    }
                }
            }
            else if ( ((LA6_0 >= ARGS && LA6_0 <= FIELD_DECL)||(LA6_0 >= INIT && LA6_0 <= 116)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:99:19: st= .
                    {
                    st=(BytecodesAST)input.LT(1);

                    matchAny(input); if (state.failed) return ;

                    }
                    break;

            }


            ID3=(BytecodesAST)match(input,ID,FOLLOW_ID_in_entraNoMetodo394); if (state.failed) return ;

            tipoRet=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input,PARAMS,FOLLOW_PARAMS_in_entraNoMetodo402); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:99:56: ( ^( LIMIT lim= INTEIRO ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LIMIT) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==DOWN) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==INTEIRO) ) {
                        int LA7_4 = input.LA(4);

                        if ( (LA7_4==UP) ) {
                            int LA7_5 = input.LA(5);

                            if ( ((LA7_5 >= ARGS && LA7_5 <= 116)) ) {
                                alt7=1;
                            }
                        }
                    }
                }
            }
            switch (alt7) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:99:57: ^( LIMIT lim= INTEIRO )
                    {
                    match(input,LIMIT,FOLLOW_LIMIT_in_entraNoMetodo412); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    lim=(BytecodesAST)match(input,INTEIRO,FOLLOW_INTEIRO_in_entraNoMetodo416); if (state.failed) return ;

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
                       
                       if (st == null)
                       	metodo.setEstatico(false);
                       else
                       	metodo.setEstatico(true);
                       
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:121:1: entraNoCorpoMetodo : BODY ;
    public final void entraNoCorpoMetodo() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:122:5: ( BODY )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:122:9: BODY
            {
            match(input,BODY,FOLLOW_BODY_in_entraNoCorpoMetodo443); if (state.failed) return ;

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:125:1: saiDoCorpoMetodo : BODY ;
    public final void saiDoCorpoMetodo() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:126:5: ( BODY )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:126:9: BODY
            {
            match(input,BODY,FOLLOW_BODY_in_saiDoCorpoMetodo469); if (state.failed) return ;

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:133:1: saiDaClasse : '.class' ;
    public final void saiDaClasse() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:133:13: ( '.class' )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:133:15: '.class'
            {
            match(input,38,FOLLOW_38_in_saiDaClasse496); if (state.failed) return ;

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:140:1: saiDoMetodo : METHOD_DECL ;
    public final void saiDoMetodo() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:141:2: ( METHOD_DECL )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:141:5: METHOD_DECL
            {
            match(input,METHOD_DECL,FOLLOW_METHOD_DECL_in_saiDoMetodo546); if (state.failed) return ;

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:149:1: saiDoConstrutor : CONSTR_DECL ;
    public final void saiDoConstrutor() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:150:2: ( CONSTR_DECL )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:150:5: CONSTR_DECL
            {
            match(input,CONSTR_DECL,FOLLOW_CONSTR_DECL_in_saiDoConstrutor562); if (state.failed) return ;

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:158:1: field : ^( (a= 'getfield' |a= 'getstatic' |a= 'putfield' |a= 'putstatic' ) . . ) ;
    public final void field() throws RecognitionException {
        BytecodesAST a=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:158:7: ( ^( (a= 'getfield' |a= 'getstatic' |a= 'putfield' |a= 'putstatic' ) . . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:158:9: ^( (a= 'getfield' |a= 'getstatic' |a= 'putfield' |a= 'putstatic' ) . . )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:158:11: (a= 'getfield' |a= 'getstatic' |a= 'putfield' |a= 'putstatic' )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 59:
                {
                alt8=1;
                }
                break;
            case 60:
                {
                alt8=2;
                }
                break;
            case 113:
                {
                alt8=3;
                }
                break;
            case 114:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:158:12: a= 'getfield'
                    {
                    a=(BytecodesAST)match(input,59,FOLLOW_59_in_field584); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:158:29: a= 'getstatic'
                    {
                    a=(BytecodesAST)match(input,60,FOLLOW_60_in_field592); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:158:47: a= 'putfield'
                    {
                    a=(BytecodesAST)match(input,113,FOLLOW_113_in_field600); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:158:64: a= 'putstatic'
                    {
                    a=(BytecodesAST)match(input,114,FOLLOW_114_in_field608); if (state.failed) return ;

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:167:1: invoke : ^( ( 'invokespecial' | 'invokestatic' | 'invokevirtual' ) . ^( METHOD_CALL ^( PARAMS . ) . ) ) ;
    public final void invoke() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:167:9: ( ^( ( 'invokespecial' | 'invokestatic' | 'invokevirtual' ) . ^( METHOD_CALL ^( PARAMS . ) . ) ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:167:11: ^( ( 'invokespecial' | 'invokestatic' | 'invokevirtual' ) . ^( METHOD_CALL ^( PARAMS . ) . ) )
            {
            if ( (input.LA(1) >= 94 && input.LA(1) <= 96) ) {
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

            match(input,METHOD_CALL,FOLLOW_METHOD_CALL_in_invoke666); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,PARAMS,FOLLOW_PARAMS_in_invoke669); if (state.failed) return ;

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:173:1: nenhumoperando : ^( ( RETURN | ARITMETICA | LOAD | STORE | LOGICA | PILHA ) . ) ;
    public final void nenhumoperando() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:174:2: ( ^( ( RETURN | ARITMETICA | LOAD | STORE | LOGICA | PILHA ) . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:174:4: ^( ( RETURN | ARITMETICA | LOAD | STORE | LOGICA | PILHA ) . )
            {
            if ( input.LA(1)==ARITMETICA||(input.LA(1) >= LOAD && input.LA(1) <= LOGICA)||input.LA(1)==PILHA||(input.LA(1) >= RETURN && input.LA(1) <= STORE) ) {
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:180:1: umoperando : ^( ( DESVIO | LOAD | STORE | NEW | NEWARRAY ) . . ) ;
    public final void umoperando() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:181:9: ( ^( ( DESVIO | LOAD | STORE | NEW | NEWARRAY ) . . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:181:11: ^( ( DESVIO | LOAD | STORE | NEW | NEWARRAY ) . . )
            {
            if ( input.LA(1)==DESVIO||input.LA(1)==LOAD||(input.LA(1) >= NEW && input.LA(1) <= NEWARRAY)||input.LA(1)==STORE ) {
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:186:1: label : ^( LABEL id= . ) ;
    public final void label() throws RecognitionException {
        BytecodesAST id=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:187:4: ( ^( LABEL id= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Def.g:187:6: ^( LABEL id= . )
            {
            match(input,LABEL,FOLLOW_LABEL_in_label824); if (state.failed) return ;

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
        "\1\162\7\uffff\1\2\3\uffff\5\164";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\10\1\11\1\12\5\uffff";
    static final String DFA1_specialS =
        "\21\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\11\1\1\1\2\1\12\1\uffff\1\5\4\uffff\1\13\1\uffff\1\10\1\11"+
            "\2\uffff\1\3\2\12\3\uffff\1\11\1\uffff\1\11\1\10\7\uffff\1\4"+
            "\24\uffff\2\6\41\uffff\3\7\20\uffff\2\6",
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
            "\161\15",
            "\1\16\1\11\161\12",
            "\161\17",
            "\1\20\161\17",
            "\1\11\161\12"
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
    public static final BitSet FOLLOW_declaracaoVariavel_in_topdown97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_in_topdown109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invoke_in_topdown121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nenhumoperando_in_topdown133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_umoperando_in_topdown145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_label_in_topdown157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saiDoCorpoMetodo_in_bottomup174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saiDoMetodo_in_bottomup187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saiDoConstrutor_in_bottomup200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saiDaClasse_in_bottomup213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_entraNaClasse245 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_entraNaClasse249 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x001FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_EXTENDS_in_entraNaClasse253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FIELD_DECL_in_declaracaoVariavel293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_declaracaoVariavel303 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x001FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_CONSTR_DECL_in_entraNoConstrutor338 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INIT_in_entraNoConstrutor340 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x001FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_PARAMS_in_entraNoConstrutor348 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LIMIT_in_entraNoConstrutor358 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEIRO_in_entraNoConstrutor362 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_METHOD_DECL_in_entraNoMetodo384 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_entraNoMetodo394 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x001FFFFFFFFFFFFFL});
    public static final BitSet FOLLOW_PARAMS_in_entraNoMetodo402 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LIMIT_in_entraNoMetodo412 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEIRO_in_entraNoMetodo416 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BODY_in_entraNoCorpoMetodo443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_in_saiDoCorpoMetodo469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_saiDaClasse496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METHOD_DECL_in_saiDoMetodo546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTR_DECL_in_saiDoConstrutor562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_field584 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_60_in_field592 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_113_in_field600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_114_in_field608 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_invoke651 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_METHOD_CALL_in_invoke666 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PARAMS_in_invoke669 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_nenhumoperando714 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_umoperando764 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LABEL_in_label824 = new BitSet(new long[]{0x0000000000000004L});

}