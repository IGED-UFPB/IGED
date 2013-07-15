// $ANTLR 3.4 C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g 2012-07-15 17:30:15


  package br.ufpb.iged.interpretador.tradutor.intermediario.parser;
  
  import java.io.IOException;
    


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public abstract class IntermediarioParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "'ADD'", "'CREATE_INT'", "'DELETE_INT'", "'DIV'", "'MULT'", "'READ_INT'", "'READ_INTC'", "'SUB'", "'WRITE_INT'"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int ID=4;
    public static final int INT=5;
    public static final int WS=6;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public IntermediarioParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public IntermediarioParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return IntermediarioParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g"; }



      protected abstract void adicionarVariavel(Token op);
      protected abstract void traduzirLoad(Token opc, Token op) throws IOException;
      protected abstract void traduzirStore(Token opc, Token op) throws IOException;
      protected abstract void traduzirArimetica(Token opc) throws IOException;




    // $ANTLR start "programa"
    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:24:1: programa : ( instrucao )* ;
    public final void programa() throws RecognitionException, IOException {
        try {
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:24:10: ( ( instrucao )* )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:24:12: ( instrucao )*
            {
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:24:12: ( instrucao )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= 7 && LA1_0 <= 15)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:24:12: instrucao
            	    {
            	    pushFollow(FOLLOW_instrucao_in_programa29);
            	    instrucao();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "programa"



    // $ANTLR start "instrucao"
    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:26:1: instrucao : ( create | load | store | aritmetica ) ;
    public final void instrucao() throws RecognitionException, IOException {
        try {
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:26:11: ( ( create | load | store | aritmetica ) )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:26:13: ( create | load | store | aritmetica )
            {
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:26:13: ( create | load | store | aritmetica )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 8:
            case 9:
                {
                alt2=1;
                }
                break;
            case 12:
            case 13:
                {
                alt2=2;
                }
                break;
            case 15:
                {
                alt2=3;
                }
                break;
            case 7:
            case 10:
            case 11:
            case 14:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:26:14: create
                    {
                    pushFollow(FOLLOW_create_in_instrucao39);
                    create();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:26:23: load
                    {
                    pushFollow(FOLLOW_load_in_instrucao43);
                    load();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:26:30: store
                    {
                    pushFollow(FOLLOW_store_in_instrucao47);
                    store();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:26:38: aritmetica
                    {
                    pushFollow(FOLLOW_aritmetica_in_instrucao51);
                    aritmetica();

                    state._fsp--;


                    }
                    break;

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
    // $ANTLR end "instrucao"



    // $ANTLR start "create"
    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:28:1: create : ( 'CREATE_INT' a= ID | 'DELETE_INT' ID );
    public final void create() throws RecognitionException {
        Token a=null;

        try {
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:28:8: ( 'CREATE_INT' a= ID | 'DELETE_INT' ID )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==8) ) {
                alt3=1;
            }
            else if ( (LA3_0==9) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:28:10: 'CREATE_INT' a= ID
                    {
                    match(input,8,FOLLOW_8_in_create60); 

                    a=(Token)match(input,ID,FOLLOW_ID_in_create66); 

                    adicionarVariavel(a);

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:29:10: 'DELETE_INT' ID
                    {
                    match(input,9,FOLLOW_9_in_create79); 

                    match(input,ID,FOLLOW_ID_in_create81); 

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
    // $ANTLR end "create"



    // $ANTLR start "load"
    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:32:1: load : (a= 'READ_INT' b= ID |a= 'READ_INTC' INT );
    public final void load() throws RecognitionException, IOException {
        Token a=null;
        Token b=null;
        Token INT1=null;

        try {
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:32:6: (a= 'READ_INT' b= ID |a= 'READ_INTC' INT )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            else if ( (LA4_0==13) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:32:8: a= 'READ_INT' b= ID
                    {
                    a=(Token)match(input,12,FOLLOW_12_in_load101); 

                    b=(Token)match(input,ID,FOLLOW_ID_in_load107); 

                    traduzirLoad(a, b);

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:33:8: a= 'READ_INTC' INT
                    {
                    a=(Token)match(input,13,FOLLOW_13_in_load122); 

                    INT1=(Token)match(input,INT,FOLLOW_INT_in_load124); 

                    traduzirLoad(a, INT1);

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
    // $ANTLR end "load"



    // $ANTLR start "store"
    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:36:1: store : a= 'WRITE_INT' b= ID ;
    public final void store() throws RecognitionException, IOException {
        Token a=null;
        Token b=null;

        try {
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:36:7: (a= 'WRITE_INT' b= ID )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:36:9: a= 'WRITE_INT' b= ID
            {
            a=(Token)match(input,15,FOLLOW_15_in_store149); 

            b=(Token)match(input,ID,FOLLOW_ID_in_store155); 

            traduzirStore(a, b);

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
    // $ANTLR end "store"



    // $ANTLR start "aritmetica"
    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:38:1: aritmetica : (a= 'ADD' |a= 'SUB' |a= 'MULT' |a= 'DIV' );
    public final void aritmetica() throws RecognitionException, IOException {
        Token a=null;

        try {
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:38:12: (a= 'ADD' |a= 'SUB' |a= 'MULT' |a= 'DIV' )
            int alt5=4;
            switch ( input.LA(1) ) {
            case 7:
                {
                alt5=1;
                }
                break;
            case 14:
                {
                alt5=2;
                }
                break;
            case 11:
                {
                alt5=3;
                }
                break;
            case 10:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:38:14: a= 'ADD'
                    {
                    a=(Token)match(input,7,FOLLOW_7_in_aritmetica169); 

                    traduzirArimetica(a);

                    }
                    break;
                case 2 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:39:14: a= 'SUB'
                    {
                    a=(Token)match(input,14,FOLLOW_14_in_aritmetica190); 

                    traduzirArimetica(a);

                    }
                    break;
                case 3 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:40:14: a= 'MULT'
                    {
                    a=(Token)match(input,11,FOLLOW_11_in_aritmetica211); 

                    traduzirArimetica(a);

                    }
                    break;
                case 4 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:41:14: a= 'DIV'
                    {
                    a=(Token)match(input,10,FOLLOW_10_in_aritmetica232); 

                    traduzirArimetica(a);

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
    // $ANTLR end "aritmetica"

    // Delegated rules


 

    public static final BitSet FOLLOW_instrucao_in_programa29 = new BitSet(new long[]{0x000000000000FF82L});
    public static final BitSet FOLLOW_create_in_instrucao39 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_load_in_instrucao43 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_store_in_instrucao47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aritmetica_in_instrucao51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_create60 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_create66 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_create79 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_create81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_load101 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_load107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_load122 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INT_in_load124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_store149 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_store155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_aritmetica169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_aritmetica190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_aritmetica211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_aritmetica232 = new BitSet(new long[]{0x0000000000000002L});

}