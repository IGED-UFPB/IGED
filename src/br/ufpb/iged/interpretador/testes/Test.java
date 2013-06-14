package br.ufpb.iged.interpretador.testes;

import org.antlr.runtime.*;

import br.ufpb.iged.interpretador.bytecodeassembler.asm.BytecodeAssembler;
import br.ufpb.iged.interpretador.bytecodeassembler.asm.Definicao;
import br.ufpb.iged.interpretador.parser.AssemblerLexer;
import br.ufpb.iged.interpretador.parser.AssemblerParser;

public class Test {
	
	private static Object o;
	
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
    	
    	//System.out.println(tabelaSimbolos(6));
    	
    	//b(o);
    	
    	/*String a = "a.root";
    	
    	String[] b = a.split("\\.");
    	
    	for (int i = 0; i < b.length; i++)
    		System.out.println(b[i]);*/
    	
    	/*for (int i = 0; i < 15; i++){
    	
	   		int n = (int) ((int) 1 + (Math.random() * 100)); 
	    	
	    	System.out.print(n+" ");
    	
    	}*/
    	//o = new Object();
    	
    	/*c(o);
    	
    	System.out.println(o);*/
    	
    	int vetor[] = {51, 100, 20, 93, 11, 65, 92, 76, 61, 40, 39, 52, 10, 62, 91};
    	
    	mergesort(vetor, 1, 15);
    	
    	for (int i = 0; i < vetor.length; i++)
    		System.out.print(vetor[i]+" ");
        
    }
    
    public static void merge(int A[], int p, int q, int r){

    	int n1 = q - p + 1;
    	int n2 = r - q;
    	int i, j, k;
    	
    	p--;
    	
    	int L[] = new int[n1];
    	int R[] = new int [n2];
    	
    	for (i = 0; i < n1; i++)
    		L[i] = A[p + i];
    		
    	for (i = 0; i < n2; i++)
    		R[i] = A[q + i];
    		
    	i = 0;
    	j = 0;
    	
    	for (k = p; k < r; k++) {
    	
    		if (i == n1 && j < n2) {
    		
    		    while (k < r) {
    				A[k] = R[j];
    				k++;
    				j++;
    			}
    			
            } else if (i < n1 && j == n2){
    		
    			while (k < r) {
    				A[k] = L[i];
    				k++;
    				i++;
    			}
    		
    		} else if (i < n1 && j < n2) {
    	
    			if (L[i] <= R[j]){
    				A[k] = L[i];
    				i++;
    			} else {
    				A[k] = R[j];
    				j++;
    			}
    		
    		}
    	
    	}

    }

    public static void mergesort(int A[], int p, int r) {
    	
    	if (p < r) {
    		int q = (p + r) / 2;
    		mergesort(A, p, q);
    		mergesort(A, q + 1, r);
    		merge(A, p, q, r);
    	}

    }
    
    public static void c(Object o){
    	
    	o = new Object();
    	
    	System.out.println(o);
    	
    }
    
    public void a(){
    	
    	Object o;
    	
    }
    
    public void a(int a){
    	
    }
    
    public void a(int a, int b){
    	
    }
    
    public void a(float a, int b){
    	
    }
    
    public static void b(Object a) {
    	
    	
    	
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
