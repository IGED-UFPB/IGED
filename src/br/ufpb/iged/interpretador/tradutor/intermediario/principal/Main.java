package br.ufpb.iged.interpretador.tradutor.intermediario.principal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import br.ufpb.iged.interpretador.tradutor.intermediario.parser.IntermediarioLexer;


public class Main {
	
	public static final String NOME_ARQUIVO_ENTRADA = "codigo_intermediario.txt";
	
	public static void main(String args[]) {
		
		try {
			
			InputStream entrada = new FileInputStream(NOME_ARQUIVO_ENTRADA);
			
			IntermediarioLexer lexer = new IntermediarioLexer(
					new ANTLRInputStream(entrada));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			
			TradutorIntermediario tradutor =  new TradutorIntermediario(tokens);
			
			tradutor.programa();
			
			tradutor.fecharArquivoSaida();
			
		} catch (FileNotFoundException e) {

			System.out.println("O arquivo de entrada n�o p�de aberto");
			
		} catch (IOException e) {

			System.out.println("Erro no arquivo de sa�da");
			
		} catch (RecognitionException e) {

			System.out.println("O c�digo cont�m erros e n�o pode ser traduzido");
			
		}
		
		
		
	}

}
