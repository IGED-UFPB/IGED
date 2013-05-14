package br.ufpb.iged.interpretador.testes;

import org.antlr.runtime.*;

import br.ufpb.iged.interpretador.bytecodeassembler.asm.BytecodeAssembler;
import br.ufpb.iged.interpretador.bytecodeassembler.asm.Definicao;
import br.ufpb.iged.interpretador.parser.AssemblerLexer;
import br.ufpb.iged.interpretador.parser.AssemblerParser;

public class Test {

    public static void main(String[] args) throws Exception {
    
       /*CharStream entrada = new ANTLRFileStream("entrada.txt");
        
       AssemblerLexer lexer = new AssemblerLexer(entrada);
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        AssemblerParser parser = new BytecodeAssembler(tokens, Definicao.instrucoes);
        parser.programa();
        
        for (int i = 0; i < BytecodeAssembler.codigo.length ; i++) {
        
         System.out.print(BytecodeAssembler.codigo[i] + " ");
    
        
        }
    	
    	String a = "oieerere/fldlfkf/Classe/xyz";
    	String [] toks = a.split("/");
    	String campo = toks[toks.length - 1];
    	System.out.println(campo);
    	String classe = "L";
    	
    	int i;
    	
    	for (i = 0; i < toks.length - 1; i++){
    		if (i == toks.length - 2)
    			classe += toks[i];
    		else
        		classe += toks[i]+"/";
    	}
    	
    	System.out.println(classe);
    	
    	String b = "khklgh/Classe/";
    	String c = "L"+b.substring(0, b.length() - 1);
    	
    	System.out.println(c);*/
    	
    	/*String t1 = "uisos(III)I";
    	String t2 = " main(VOID)V";
    	String t3 = "<init>(VOID)V";
    	String t4 = "<init>(II)V";
    	String t5 = "kioeot(IIII)I";
    	String t6 = "refs(LClasse;LComposicao;IILHeranca;)I";
    	
    	System.out.println("Params 1: "+contarParametros(t1));
    	System.out.println("Params 2: "+contarParametros(t2));
    	System.out.println("Params 3: "+contarParametros(t3));
    	System.out.println("Params 4: "+contarParametros(t4));
    	System.out.println("Params 5: "+contarParametros(t5));
    	System.out.println("Params 6: "+contarParametros(t6));*/
    	
    	/*double a = 0.678;
    	int b = (int)a;
    	System.out.println(b);
    	double c = 2.99635;
    	int d = (int)c;
    	System.out.println(d);*/
    	
    	System.out.println(tabelaSimbolos(6));
        
    }
    
    public static String tabelaSimbolos(int endereco) {
		
		String id = "";
		String idRev = "";
		
		char[]alfabeto= {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z'};
		
		int div = endereco;
		do{
			int mod = div % 26;
			div = (int) div / 26;
			idRev += alfabeto[mod];
		}while(div > 0);
		
		for (int i = idRev.length() - 1; i >= 0; i--)
			id += idRev.charAt(i);
		
		return id;
		
    }
      
}
