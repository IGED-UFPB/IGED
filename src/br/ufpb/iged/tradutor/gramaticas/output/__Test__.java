import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import br.ufpb.iged.tradutor.gramaticas.output.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        JediLexer lex = new JediLexer(new ANTLRFileStream("C:\\Users\\Tiago\\Git\\IGED\\IGED\\src\\br\\ufpb\\iged\\tradutor\\gramaticas\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        JediParser g = new JediParser(tokens, 49100, null);
        try {
            g.programa();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}