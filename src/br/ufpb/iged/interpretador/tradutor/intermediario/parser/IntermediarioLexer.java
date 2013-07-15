// $ANTLR 3.4 C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g 2012-07-15 17:30:16

  package br.ufpb.iged.interpretador.tradutor.intermediario.parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class IntermediarioLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public IntermediarioLexer() {} 
    public IntermediarioLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public IntermediarioLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g"; }

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:6:6: ( 'ADD' )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:6:8: 'ADD'
            {
            match("ADD"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:7:6: ( 'CREATE_INT' )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:7:8: 'CREATE_INT'
            {
            match("CREATE_INT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:8:6: ( 'DELETE_INT' )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:8:8: 'DELETE_INT'
            {
            match("DELETE_INT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:9:7: ( 'DIV' )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:9:9: 'DIV'
            {
            match("DIV"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:10:7: ( 'MULT' )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:10:9: 'MULT'
            {
            match("MULT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:11:7: ( 'READ_INT' )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:11:9: 'READ_INT'
            {
            match("READ_INT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:12:7: ( 'READ_INTC' )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:12:9: 'READ_INTC'
            {
            match("READ_INTC"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:13:7: ( 'SUB' )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:13:9: 'SUB'
            {
            match("SUB"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:14:7: ( 'WRITE_INT' )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:14:9: 'WRITE_INT'
            {
            match("WRITE_INT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:44:5: ( ( '-' )? ( '0' .. '9' )+ )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:44:7: ( '-' )? ( '0' .. '9' )+
            {
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:44:7: ( '-' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='-') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:44:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:44:12: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:46:3: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )* )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:46:5: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:46:27: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '.' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='.'||(LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:48:4: ( ( ' ' | '\\t' | '\\r' | '\\n' ) )
            // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:48:6: ( ' ' | '\\t' | '\\r' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:8: ( T__7 | T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | INT | ID | WS )
        int alt4=12;
        switch ( input.LA(1) ) {
        case 'A':
            {
            int LA4_1 = input.LA(2);

            if ( (LA4_1=='D') ) {
                int LA4_11 = input.LA(3);

                if ( (LA4_11=='D') ) {
                    int LA4_19 = input.LA(4);

                    if ( (LA4_19=='.'||(LA4_19 >= '0' && LA4_19 <= '9')||(LA4_19 >= 'A' && LA4_19 <= 'Z')||(LA4_19 >= 'a' && LA4_19 <= 'z')) ) {
                        alt4=11;
                    }
                    else {
                        alt4=1;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case 'C':
            {
            int LA4_2 = input.LA(2);

            if ( (LA4_2=='R') ) {
                int LA4_12 = input.LA(3);

                if ( (LA4_12=='E') ) {
                    int LA4_20 = input.LA(4);

                    if ( (LA4_20=='A') ) {
                        int LA4_28 = input.LA(5);

                        if ( (LA4_28=='T') ) {
                            int LA4_35 = input.LA(6);

                            if ( (LA4_35=='E') ) {
                                int LA4_40 = input.LA(7);

                                if ( (LA4_40=='_') ) {
                                    alt4=2;
                                }
                                else {
                                    alt4=11;
                                }
                            }
                            else {
                                alt4=11;
                            }
                        }
                        else {
                            alt4=11;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case 'D':
            {
            switch ( input.LA(2) ) {
            case 'E':
                {
                int LA4_13 = input.LA(3);

                if ( (LA4_13=='L') ) {
                    int LA4_21 = input.LA(4);

                    if ( (LA4_21=='E') ) {
                        int LA4_29 = input.LA(5);

                        if ( (LA4_29=='T') ) {
                            int LA4_36 = input.LA(6);

                            if ( (LA4_36=='E') ) {
                                int LA4_41 = input.LA(7);

                                if ( (LA4_41=='_') ) {
                                    alt4=3;
                                }
                                else {
                                    alt4=11;
                                }
                            }
                            else {
                                alt4=11;
                            }
                        }
                        else {
                            alt4=11;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
                }
                break;
            case 'I':
                {
                int LA4_14 = input.LA(3);

                if ( (LA4_14=='V') ) {
                    int LA4_22 = input.LA(4);

                    if ( (LA4_22=='.'||(LA4_22 >= '0' && LA4_22 <= '9')||(LA4_22 >= 'A' && LA4_22 <= 'Z')||(LA4_22 >= 'a' && LA4_22 <= 'z')) ) {
                        alt4=11;
                    }
                    else {
                        alt4=4;
                    }
                }
                else {
                    alt4=11;
                }
                }
                break;
            default:
                alt4=11;
            }

            }
            break;
        case 'M':
            {
            int LA4_4 = input.LA(2);

            if ( (LA4_4=='U') ) {
                int LA4_15 = input.LA(3);

                if ( (LA4_15=='L') ) {
                    int LA4_23 = input.LA(4);

                    if ( (LA4_23=='T') ) {
                        int LA4_31 = input.LA(5);

                        if ( (LA4_31=='.'||(LA4_31 >= '0' && LA4_31 <= '9')||(LA4_31 >= 'A' && LA4_31 <= 'Z')||(LA4_31 >= 'a' && LA4_31 <= 'z')) ) {
                            alt4=11;
                        }
                        else {
                            alt4=5;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case 'R':
            {
            int LA4_5 = input.LA(2);

            if ( (LA4_5=='E') ) {
                int LA4_16 = input.LA(3);

                if ( (LA4_16=='A') ) {
                    int LA4_24 = input.LA(4);

                    if ( (LA4_24=='D') ) {
                        int LA4_32 = input.LA(5);

                        if ( (LA4_32=='_') ) {
                            int LA4_38 = input.LA(6);

                            if ( (LA4_38=='I') ) {
                                int LA4_42 = input.LA(7);

                                if ( (LA4_42=='N') ) {
                                    int LA4_46 = input.LA(8);

                                    if ( (LA4_46=='T') ) {
                                        int LA4_47 = input.LA(9);

                                        if ( (LA4_47=='C') ) {
                                            alt4=7;
                                        }
                                        else {
                                            alt4=6;
                                        }
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 4, 46, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 4, 42, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 38, input);

                                throw nvae;

                            }
                        }
                        else {
                            alt4=11;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case 'S':
            {
            int LA4_6 = input.LA(2);

            if ( (LA4_6=='U') ) {
                int LA4_17 = input.LA(3);

                if ( (LA4_17=='B') ) {
                    int LA4_25 = input.LA(4);

                    if ( (LA4_25=='.'||(LA4_25 >= '0' && LA4_25 <= '9')||(LA4_25 >= 'A' && LA4_25 <= 'Z')||(LA4_25 >= 'a' && LA4_25 <= 'z')) ) {
                        alt4=11;
                    }
                    else {
                        alt4=8;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case 'W':
            {
            int LA4_7 = input.LA(2);

            if ( (LA4_7=='R') ) {
                int LA4_18 = input.LA(3);

                if ( (LA4_18=='I') ) {
                    int LA4_26 = input.LA(4);

                    if ( (LA4_26=='T') ) {
                        int LA4_34 = input.LA(5);

                        if ( (LA4_34=='E') ) {
                            int LA4_39 = input.LA(6);

                            if ( (LA4_39=='_') ) {
                                alt4=9;
                            }
                            else {
                                alt4=11;
                            }
                        }
                        else {
                            alt4=11;
                        }
                    }
                    else {
                        alt4=11;
                    }
                }
                else {
                    alt4=11;
                }
            }
            else {
                alt4=11;
            }
            }
            break;
        case '-':
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            {
            alt4=10;
            }
            break;
        case 'B':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'T':
        case 'U':
        case 'V':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt4=11;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt4=12;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;

        }

        switch (alt4) {
            case 1 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:10: T__7
                {
                mT__7(); 


                }
                break;
            case 2 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:15: T__8
                {
                mT__8(); 


                }
                break;
            case 3 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:20: T__9
                {
                mT__9(); 


                }
                break;
            case 4 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:25: T__10
                {
                mT__10(); 


                }
                break;
            case 5 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:31: T__11
                {
                mT__11(); 


                }
                break;
            case 6 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:37: T__12
                {
                mT__12(); 


                }
                break;
            case 7 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:43: T__13
                {
                mT__13(); 


                }
                break;
            case 8 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:49: T__14
                {
                mT__14(); 


                }
                break;
            case 9 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:55: T__15
                {
                mT__15(); 


                }
                break;
            case 10 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:61: INT
                {
                mINT(); 


                }
                break;
            case 11 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:65: ID
                {
                mID(); 


                }
                break;
            case 12 :
                // C:\\Users\\Tiago\\git\\interpretador\\src\\br\\ufpb\\iged\\interpretador\\gramaticas\\Intermediario.g:1:68: WS
                {
                mWS(); 


                }
                break;

        }

    }


 

}