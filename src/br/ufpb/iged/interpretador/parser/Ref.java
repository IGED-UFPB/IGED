// $ANTLR 3.4 C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g 2013-05-01 17:32:33

    package br.ufpb.iged.interpretador.parser;
    
    import br.ufpb.iged.interpretador.symboltable.classes.Escopo;
import br.ufpb.iged.interpretador.symboltable.classes.BytecodesAST;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloClasse;
import br.ufpb.iged.interpretador.symboltable.classes.TabelaSimbolos;
import br.ufpb.iged.interpretador.symboltable.classes.Tipo;
import br.ufpb.iged.interpretador.bytecodeassembler.asm.BytecodeAssembler;
import br.ufpb.iged.interpretador.excecoes.LabelException;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloVariavel;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloMetodo;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloLabel;


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


    public Ref(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public Ref(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return Ref.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g"; }


        
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
      
      private void newClass(String nomeClasse) {
      
         assembler.escreverOpcode("new");
           
          SimboloClasse simboloClasse =
              (SimboloClasse)tabelaSimbolos.global.resolver( nomeClasse);
        
          if(!assembler.getConstantPool().contains(simboloClasse))
          
              assembler.getConstantPool().add(simboloClasse);
        
           BytecodeAssembler.escreverInteiro(BytecodeAssembler.codigo,
              BytecodeAssembler.ip, assembler.getConstantPool().indexOf(simboloClasse));
      
      }
        



    // $ANTLR start "topdown"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:118:1: topdown : ( entraNaClasse | entraNoMetodo | entraNoConstrutor | declaracaoVariavel | field | invoke | novaClasse | nenhumoperando | umoperando );
    public final void topdown() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:119:5: ( entraNaClasse | entraNoMetodo | entraNoConstrutor | declaracaoVariavel | field | invoke | novaClasse | nenhumoperando | umoperando )
            int alt1=9;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:119:9: entraNaClasse
                    {
                    pushFollow(FOLLOW_entraNaClasse_in_topdown61);
                    entraNaClasse();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:120:9: entraNoMetodo
                    {
                    pushFollow(FOLLOW_entraNoMetodo_in_topdown71);
                    entraNoMetodo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:121:9: entraNoConstrutor
                    {
                    pushFollow(FOLLOW_entraNoConstrutor_in_topdown81);
                    entraNoConstrutor();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:122:9: declaracaoVariavel
                    {
                    pushFollow(FOLLOW_declaracaoVariavel_in_topdown91);
                    declaracaoVariavel();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:123:9: field
                    {
                    pushFollow(FOLLOW_field_in_topdown101);
                    field();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:124:9: invoke
                    {
                    pushFollow(FOLLOW_invoke_in_topdown111);
                    invoke();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:125:9: novaClasse
                    {
                    pushFollow(FOLLOW_novaClasse_in_topdown121);
                    novaClasse();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:126:9: nenhumoperando
                    {
                    pushFollow(FOLLOW_nenhumoperando_in_topdown131);
                    nenhumoperando();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:127:9: umoperando
                    {
                    pushFollow(FOLLOW_umoperando_in_topdown141);
                    umoperando();

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:130:1: bottomup : ( saiDoMetodo | saiDoConstrutor );
    public final void bottomup() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:131:3: ( saiDoMetodo | saiDoConstrutor )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==METHOD_DECL) ) {
                alt2=1;
            }
            else if ( (LA2_0==CONSTR_DECL) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:131:7: saiDoMetodo
                    {
                    pushFollow(FOLLOW_saiDoMetodo_in_bottomup162);
                    saiDoMetodo();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:132:7: saiDoConstrutor
                    {
                    pushFollow(FOLLOW_saiDoConstrutor_in_bottomup170);
                    saiDoConstrutor();

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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:136:1: entraNaClasse : ^( '.class' nome= ID ( ^( EXTENDS sup= . ) )? . ) ;
    public final void entraNaClasse() throws RecognitionException {
        BytecodesAST nome=null;
        BytecodesAST sup=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:137:5: ( ^( '.class' nome= ID ( ^( EXTENDS sup= . ) )? . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:137:7: ^( '.class' nome= ID ( ^( EXTENDS sup= . ) )? . )
            {
            match(input,36,FOLLOW_36_in_entraNaClasse193); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            nome=(BytecodesAST)match(input,ID,FOLLOW_ID_in_entraNaClasse197); if (state.failed) return ;

            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:137:26: ( ^( EXTENDS sup= . ) )?
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
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:137:27: ^( EXTENDS sup= . )
                    {
                    match(input,EXTENDS,FOLLOW_EXTENDS_in_entraNaClasse201); if (state.failed) return ;

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
                    
                      simboloClasse =(SimboloClasse)tabelaSimbolos.global.resolver("L" + nome.getText());     
                      if(!assembler.getConstantPool().contains(simboloClasse))   
                      	assembler.getConstantPool().add(simboloClasse);
                      if ( sup!=null ) {
                          sup.simbolo = sup.escopo.resolver("L"+sup.getText());
                          simboloClasse.superClasse =
                              (SimboloClasse)sup.simbolo;
                              System.out.println("linha "+nome.getLine()+": set "+(nome!=null?nome.getText():null)+
                              " super to "+((SimboloClasse)nome.simbolo).superClasse.nome);
                       }
                       else {
                          System.out.println("linha "+nome.getLine()+": set "+(nome!=null?nome.getText():null));
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
    // $ANTLR end "entraNaClasse"



    // $ANTLR start "declaracaoVariavel"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:156:1: declaracaoVariavel : ^( FIELD_DECL ( . )? ID tip= . ) ;
    public final void declaracaoVariavel() throws RecognitionException {
        BytecodesAST ID1=null;
        BytecodesAST tip=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:157:5: ( ^( FIELD_DECL ( . )? ID tip= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:157:7: ^( FIELD_DECL ( . )? ID tip= . )
            {
            match(input,FIELD_DECL,FOLLOW_FIELD_DECL_in_declaracaoVariavel245); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:157:20: ( . )?
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
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:157:20: .
                    {
                    matchAny(input); if (state.failed) return ;

                    }
                    break;

            }


            ID1=(BytecodesAST)match(input,ID,FOLLOW_ID_in_declaracaoVariavel250); if (state.failed) return ;

            tip=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
                       if (tip.getText().startsWith("L"))
                       	ID1.simbolo.tipo = resolverTipo(tip.getText().substring(0, tip.getText().length() - 1));
                       else
                       	ID1.simbolo.tipo = resolverTipo(tip.getText());
                       System.out.println("linha "+ID1.getLine()+": set var type "+ID1.simbolo);
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
    // $ANTLR end "declaracaoVariavel"



    // $ANTLR start "entraNoConstrutor"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:167:1: entraNoConstrutor : ^( CONSTR_DECL INIT . ^( PARAMS . ) ( ^( LIMIT lim= INTEIRO ) )? . ) ;
    public final void entraNoConstrutor() throws RecognitionException {
        BytecodesAST lim=null;
        BytecodesAST INIT2=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:168:2: ( ^( CONSTR_DECL INIT . ^( PARAMS . ) ( ^( LIMIT lim= INTEIRO ) )? . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:168:4: ^( CONSTR_DECL INIT . ^( PARAMS . ) ( ^( LIMIT lim= INTEIRO ) )? . )
            {
            match(input,CONSTR_DECL,FOLLOW_CONSTR_DECL_in_entraNoConstrutor285); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            INIT2=(BytecodesAST)match(input,INIT,FOLLOW_INIT_in_entraNoConstrutor287); if (state.failed) return ;

            matchAny(input); if (state.failed) return ;

            match(input,PARAMS,FOLLOW_PARAMS_in_entraNoConstrutor292); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:168:37: ( ^( LIMIT lim= INTEIRO ) )?
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
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:168:38: ^( LIMIT lim= INTEIRO )
                    {
                    match(input,LIMIT,FOLLOW_LIMIT_in_entraNoConstrutor299); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    lim=(BytecodesAST)match(input,INTEIRO,FOLLOW_INTEIRO_in_entraNoConstrutor303); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;

            }


            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            	  System.out.println("Ref: Entrou no construtor "+(INIT2!=null?INIT2.getText():null));
            	  escopoAtual = (SimboloMetodo)INIT2.simbolo;
            	  BytecodeAssembler.codigo = new byte[BytecodeAssembler.TAMANHO_INICIAL_MEMORIA_CODIGO];
            	  BytecodeAssembler.ip = 0;
            	  assembler.setMetodoAtual((SimboloMetodo)escopoAtual);
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:178:1: entraNoMetodo : ^( METHOD_DECL ID . ^( PARAMS . ) ( ^( LIMIT lim= INTEIRO ) )? . ) ;
    public final void entraNoMetodo() throws RecognitionException {
        BytecodesAST lim=null;
        BytecodesAST ID3=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:179:2: ( ^( METHOD_DECL ID . ^( PARAMS . ) ( ^( LIMIT lim= INTEIRO ) )? . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:179:4: ^( METHOD_DECL ID . ^( PARAMS . ) ( ^( LIMIT lim= INTEIRO ) )? . )
            {
            match(input,METHOD_DECL,FOLLOW_METHOD_DECL_in_entraNoMetodo328); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            ID3=(BytecodesAST)match(input,ID,FOLLOW_ID_in_entraNoMetodo330); if (state.failed) return ;

            matchAny(input); if (state.failed) return ;

            match(input,PARAMS,FOLLOW_PARAMS_in_entraNoMetodo335); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:179:35: ( ^( LIMIT lim= INTEIRO ) )?
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
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:179:36: ^( LIMIT lim= INTEIRO )
                    {
                    match(input,LIMIT,FOLLOW_LIMIT_in_entraNoMetodo342); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    lim=(BytecodesAST)match(input,INTEIRO,FOLLOW_INTEIRO_in_entraNoMetodo346); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;

            }


            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            	  System.out.println("Ref: Entrou no metodo "+(ID3!=null?ID3.getText():null));
            	  escopoAtual = (SimboloMetodo)ID3.simbolo;
            	  BytecodeAssembler.codigo = new byte[BytecodeAssembler.TAMANHO_INICIAL_MEMORIA_CODIGO];
            	  BytecodeAssembler.ip = 0;
            	  assembler.setMetodoAtual((SimboloMetodo)escopoAtual);
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



    // $ANTLR start "saiDoMetodo"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:189:1: saiDoMetodo : METHOD_DECL ;
    public final void saiDoMetodo() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:190:2: ( METHOD_DECL )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:190:5: METHOD_DECL
            {
            match(input,METHOD_DECL,FOLLOW_METHOD_DECL_in_saiDoMetodo368); if (state.failed) return ;

            if ( state.backtracking==1 ) {
            	   System.out.println("Ref: Saindo do metodo... ");
            	   ((SimboloMetodo)escopoAtual).setCodigo(assembler.obterCodigoMaquina());
            	   ((SimboloMetodo)escopoAtual).setTamanhoMemoriaLocal(assembler.obterTamanhoMemoriaCodigo());
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:198:1: saiDoConstrutor : CONSTR_DECL ;
    public final void saiDoConstrutor() throws RecognitionException {
        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:199:2: ( CONSTR_DECL )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:199:5: CONSTR_DECL
            {
            match(input,CONSTR_DECL,FOLLOW_CONSTR_DECL_in_saiDoConstrutor384); if (state.failed) return ;

            if ( state.backtracking==1 ) {
            	    System.out.println("Ref: Saindo do construtor... ");
            	   ((SimboloMetodo)escopoAtual).setCodigo(assembler.obterCodigoMaquina());
            	   ((SimboloMetodo)escopoAtual).setTamanhoMemoriaLocal(assembler.obterTamanhoMemoriaCodigo());
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:207:1: field : ^( (op= 'getfield' |op= 'getstatic' |op= 'putfield' |op= 'putstatic' ) ref= . tipo= . ) ;
    public final void field() throws RecognitionException {
        BytecodesAST op=null;
        BytecodesAST ref=null;
        BytecodesAST tipo=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:207:8: ( ^( (op= 'getfield' |op= 'getstatic' |op= 'putfield' |op= 'putstatic' ) ref= . tipo= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:207:10: ^( (op= 'getfield' |op= 'getstatic' |op= 'putfield' |op= 'putstatic' ) ref= . tipo= . )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:207:12: (op= 'getfield' |op= 'getstatic' |op= 'putfield' |op= 'putstatic' )
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
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:207:13: op= 'getfield'
                    {
                    op=(BytecodesAST)match(input,57,FOLLOW_57_in_field405); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:207:31: op= 'getstatic'
                    {
                    op=(BytecodesAST)match(input,58,FOLLOW_58_in_field413); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:207:50: op= 'putfield'
                    {
                    op=(BytecodesAST)match(input,108,FOLLOW_108_in_field421); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:207:68: op= 'putstatic'
                    {
                    op=(BytecodesAST)match(input,109,FOLLOW_109_in_field429); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return ;
            ref=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            tipo=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
                	   String[] tokens = ref.getText().split("/");
                	   String campo = tokens[tokens.length - 1];
                	   String classe = "L";
                	
                	   int i;
                	
                	   for (i = 0; i < tokens.length - 1; i++){
                		if (i == tokens.length - 2)
                			classe += tokens[i];
                		else
                    		classe += tokens[i]+"/";
                	   }
                	           
                      acessarCampo(op.getText(), classe, campo);
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:226:1: invoke : ^( (op= 'invokespecial' |op= 'invokestatic' |op= 'invokevirtual' ) ref= . ^( METHOD_CALL ^( PARAMS a= . ) tipoRet= . ) ) ;
    public final void invoke() throws RecognitionException {
        BytecodesAST op=null;
        BytecodesAST ref=null;
        BytecodesAST a=null;
        BytecodesAST tipoRet=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:226:9: ( ^( (op= 'invokespecial' |op= 'invokestatic' |op= 'invokevirtual' ) ref= . ^( METHOD_CALL ^( PARAMS a= . ) tipoRet= . ) ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:226:12: ^( (op= 'invokespecial' |op= 'invokestatic' |op= 'invokevirtual' ) ref= . ^( METHOD_CALL ^( PARAMS a= . ) tipoRet= . ) )
            {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:226:14: (op= 'invokespecial' |op= 'invokestatic' |op= 'invokevirtual' )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 90:
                {
                alt8=1;
                }
                break;
            case 91:
                {
                alt8=2;
                }
                break;
            case 92:
                {
                alt8=3;
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
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:226:15: op= 'invokespecial'
                    {
                    op=(BytecodesAST)match(input,90,FOLLOW_90_in_invoke486); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:226:38: op= 'invokestatic'
                    {
                    op=(BytecodesAST)match(input,91,FOLLOW_91_in_invoke494); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:226:60: op= 'invokevirtual'
                    {
                    op=(BytecodesAST)match(input,92,FOLLOW_92_in_invoke502); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.DOWN, null); if (state.failed) return ;
            ref=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input,METHOD_CALL,FOLLOW_METHOD_CALL_in_invoke512); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,PARAMS,FOLLOW_PARAMS_in_invoke515); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            a=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            tipoRet=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {   
                       
                       String[] tokens = ref.getText().split("/");
                	   String nomeMetodo = tokens[tokens.length - 1];
                	   String classe = "L";
                	
                	   int i;
                	
                	   for (i = 0; i < tokens.length - 1; i++){
                		if (i == tokens.length - 2)
                			classe += tokens[i];
                		else
                    		classe += tokens[i]+"/";
                	   }
                    
                       System.out.println("chamando metodo "+nomeMetodo+"("+a.getText()+")"+tipoRet.getText());
                       chamarMetodo(op.getText(), classe, nomeMetodo, a.getText(), tipoRet.getText());
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



    // $ANTLR start "novaClasse"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:247:1: novaClasse : ^( NEW classe= . ) ;
    public final void novaClasse() throws RecognitionException {
        BytecodesAST classe=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:248:3: ( ^( NEW classe= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:248:5: ^( NEW classe= . )
            {
            match(input,NEW,FOLLOW_NEW_in_novaClasse564); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            classe=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
                newClass("L"+classe.getText());
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
    // $ANTLR end "novaClasse"



    // $ANTLR start "nenhumoperando"
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:254:1: nenhumoperando : ^( ( RETURN | ARITMETICA | LOAD | STORE | LOGICA | PILHA ) operacao= . ) ;
    public final void nenhumoperando() throws RecognitionException {
        BytecodesAST operacao=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:255:2: ( ^( ( RETURN | ARITMETICA | LOAD | STORE | LOGICA | PILHA ) operacao= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:255:4: ^( ( RETURN | ARITMETICA | LOAD | STORE | LOGICA | PILHA ) operacao= . )
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
            operacao=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
            	 assembler.escreverOpcode(operacao.getText());
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
    // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:261:1: umoperando : ^( ( DESVIO | LOAD | STORE ) operacao= . operando= . ) ;
    public final void umoperando() throws RecognitionException {
        BytecodesAST operacao=null;
        BytecodesAST operando=null;

        try {
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:262:9: ( ^( ( DESVIO | LOAD | STORE ) operacao= . operando= . ) )
            // C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Ref.g:262:11: ^( ( DESVIO | LOAD | STORE ) operacao= . operando= . )
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
            operacao=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            operando=(BytecodesAST)input.LT(1);

            matchAny(input); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==1 ) {
                     assembler.escreverOpcode(operacao.token, operando.token);
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
    // $ANTLR end "umoperando"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\20\uffff";
    static final String DFA1_eofS =
        "\20\uffff";
    static final String DFA1_minS =
        "\1\5\7\uffff\1\2\2\uffff\1\4\1\2\1\4\2\3";
    static final String DFA1_maxS =
        "\1\155\7\uffff\1\2\2\uffff\5\157";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\10\1\11\5\uffff";
    static final String DFA1_specialS =
        "\20\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\11\1\uffff\1\3\1\12\1\uffff\1\4\6\uffff\1\10\1\11\2\uffff"+
            "\1\2\1\7\3\uffff\1\11\1\uffff\1\11\1\10\6\uffff\1\1\24\uffff"+
            "\2\5\37\uffff\3\6\17\uffff\2\5",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13",
            "",
            "",
            "\154\14",
            "\1\15\1\11\154\12",
            "\154\16",
            "\1\17\154\16",
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
            return "118:1: topdown : ( entraNaClasse | entraNoMetodo | entraNoConstrutor | declaracaoVariavel | field | invoke | novaClasse | nenhumoperando | umoperando );";
        }
    }
 

    public static final BitSet FOLLOW_entraNaClasse_in_topdown61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entraNoMetodo_in_topdown71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entraNoConstrutor_in_topdown81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaracaoVariavel_in_topdown91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_field_in_topdown101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_invoke_in_topdown111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_novaClasse_in_topdown121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nenhumoperando_in_topdown131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_umoperando_in_topdown141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saiDoMetodo_in_bottomup162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_saiDoConstrutor_in_bottomup170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_entraNaClasse193 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_entraNaClasse197 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_EXTENDS_in_entraNaClasse201 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FIELD_DECL_in_declaracaoVariavel245 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_declaracaoVariavel250 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_CONSTR_DECL_in_entraNoConstrutor285 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INIT_in_entraNoConstrutor287 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_PARAMS_in_entraNoConstrutor292 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LIMIT_in_entraNoConstrutor299 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEIRO_in_entraNoConstrutor303 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_METHOD_DECL_in_entraNoMetodo328 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_entraNoMetodo330 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x0000FFFFFFFFFFFFL});
    public static final BitSet FOLLOW_PARAMS_in_entraNoMetodo335 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LIMIT_in_entraNoMetodo342 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_INTEIRO_in_entraNoMetodo346 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_METHOD_DECL_in_saiDoMetodo368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTR_DECL_in_saiDoConstrutor384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_field405 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_58_in_field413 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_108_in_field421 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_109_in_field429 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_90_in_invoke486 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_91_in_invoke494 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_92_in_invoke502 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_METHOD_CALL_in_invoke512 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_PARAMS_in_invoke515 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NEW_in_novaClasse564 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_nenhumoperando591 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_umoperando645 = new BitSet(new long[]{0x0000000000000004L});

}