package br.ufpb.iged.tradutor.principal;

import java.io.File;
import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RuleReturnScope;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.runtime.tree.TreeAdaptor;

import br.ufpb.iged.interpretador.bytecodeassembler.asm.BytecodeAssembler;
import br.ufpb.iged.interpretador.bytecodeassembler.asm.Definicao;
import br.ufpb.iged.interpretador.excecoes.AcessoIndevidoMemoriaException;
import br.ufpb.iged.interpretador.excecoes.LabelException;
import br.ufpb.iged.interpretador.parser.AssemblerLexer;
import br.ufpb.iged.tradutor.parser.Def;
import br.ufpb.iged.tradutor.parser.Ref;
import br.ufpb.iged.interpretador.symboltable.classes.BytecodesAST;
import br.ufpb.iged.interpretador.symboltable.classes.BytecodesErrorNode;
import br.ufpb.iged.tradutor.simbolos.TabelaSimbolos;
import br.ufpb.iged.tradutor.simbolos.Tipo;
import br.ufpb.iged.tradutor.parser.JediLexer;
import br.ufpb.iged.tradutor.parser.JediParser;
import br.ufpb.iged.tradutor.simbolos.TradutorAST;

public class Tradutor {
	
	public static CommonTokenStream tokens = new CommonTokenStream();	
	public static CommonTree tree = new CommonTree();
	public static StringBuffer buffer;
	public static String tipoReferencia;
	public static Tipo tipoAtual;
	
	public static TabelaSimbolos tabelaSimbolos;
	
	public static void main(String args[]) {
		
		try {
			traduzir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LabelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AcessoIndevidoMemoriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static TreeAdaptor tradutorAdaptor = new CommonTreeAdaptor() {
		
        public Object create(Token token) {
            return new TradutorAST(token);
        }
        
        public Object dupNode(Object t) {
            if ( t==null ) {
                return null;
            }
            
            Object no = create(((TradutorAST)t).token);
            
            ((TradutorAST)no).escopo = ((TradutorAST)t).escopo;
            ((TradutorAST)no).simbolo = ((TradutorAST)t).simbolo;
            
            return no;
            
        }
        
        public Object errorNode(TokenStream input, Token start, Token stop,
                                RecognitionException e)
        {
            BytecodesErrorNode t = new BytecodesErrorNode(input, start, stop, e);
            return t;
        }
        
    };
	
	
	public static void traduzir() 
			throws IOException, LabelException, 
				AcessoIndevidoMemoriaException, RecognitionException {
		
			File file = new File(".");
		
			String[] arquivos = file.list();
			
		    int i;
		    
			for (i = 0; i < arquivos.length; i++){
			
				if (arquivos[i].endsWith(".jedi")) {
					
					ANTLRFileStream input = 
							new ANTLRFileStream("./"+arquivos[i]);
					
					//entrada.append(input.toString());
					
						
						System.err.println("Analisando arquivo "+arquivos[i]);
						
						parse(input);
						
					
				}
			
			}
			
			
	        tabelaSimbolos = new TabelaSimbolos(); 
            
            compilar();
		
	}
	
	
	public static void parse(ANTLRFileStream input) throws RecognitionException{
		
		StringBuffer entrada = new StringBuffer();
		entrada.append(input.toString());
		
		CharStream inputChar = new ANTLRStringStream(entrada.toString());
		
		JediLexer lexer = new JediLexer(inputChar);
		CommonTokenStream toks = new CommonTokenStream(lexer);
		JediParser parser = new JediParser(toks);
		parser.setTreeAdaptor(tradutorAdaptor);
		RuleReturnScope r = parser.programa(); 
		CommonTree arv = (CommonTree)r.getTree();
		tokens.getTokens().addAll(toks.getTokens());
		tree.addChild(arv);
		
	}
	
	public static void compilar() throws LabelException, AcessoIndevidoMemoriaException {
		
		    //assembler = new BytecodeAssembler(tokens, Definicao.instrucoes);
		
			CommonTreeNodeStream nos = new CommonTreeNodeStream(tradutorAdaptor, tree);
			nos.setTokenStream(tokens);
			Def def = new Def(nos, tabelaSimbolos);	
			def.downup(tree);
		    nos.reset();
		    Ref ref = new Ref(nos, tabelaSimbolos);
			ref.downup(tree);
		
	}
	
	

}
