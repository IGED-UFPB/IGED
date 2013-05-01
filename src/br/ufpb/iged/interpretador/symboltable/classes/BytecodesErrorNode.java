package br.ufpb.iged.interpretador.symboltable.classes;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

public class BytecodesErrorNode extends BytecodesAST {
    public BytecodesErrorNode(TokenStream input, Token start, Token stop,
                            RecognitionException e)
    {
	super(start); 
    }
}
