package br.ufpb.iged.interpretador.testes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.runtime.*;

import br.ufpb.iged.interpretador.bytecodeassembler.asm.BytecodeAssembler;
import br.ufpb.iged.interpretador.bytecodeassembler.asm.Definicao;
import br.ufpb.iged.interpretador.parser.AssemblerLexer;
import br.ufpb.iged.interpretador.parser.AssemblerParser;

public class Test {
	
	private static Object o;
	
	int a;
	
	Test(int a){
		
		this.a = a;
		
	}
	
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
    	
    	/*int vetor[] = {51, 100, 20, 93, 11, 65, 92, 76, 61, 40, 39, 52, 10, 62, 91};
    	
    	mergesort(vetor, 1, 15);
    	
    	for (int i = 0; i < vetor.length; i++)
    		System.out.print(vetor[i]+" ");*/
    	
    	/*int y = 5;
    	
    	int z = 9;
    	
    	boolean x = 6+7*5 > y-8;
    	
    	int w = 9 * 5 / 4 - y++;
    	
    	int p = 5 - (y = y - 1);
    	
    	w = 5+ 3 * a(2);
    	
    	if (w > y){
    		
    	}
    	
    	do{
    		x = 6+7*5 > y-8;
  		  	w = 9 * 5 / 4 - y++;
  		  	p = 5 - (y = y - 1);
    	}while(y > 8);
    	
    	do
    		x = 6+7*5 > y-8;
    	while(y > 8);
    	
		int hdf;
    	
    	{
            int hghg;
    		x = 6+7*5 > y-8;
  		  	w = 9 * 5 / 4 - y++;
  		    hghg = 5 - (hdf = hdf - 1);
    	}
    	
    	{
    		int g;
    		x = 6+7*5 > y-8;
  		  	w = 9 * 5 / 4 - y++;
  		  	p = 5 - (g = y - 1);
  		    p = 5 - hdf = hdf - 1;
    		
    	}
    	
    	int hhh;
    	
    	hhh = y - 1;
    	
    	int i = 8+23, int j, k = i;
    	
    	/*if (x>y) {
    		   int x = 6+7*5 > y-8;
    		   w = 9 * 5 / 4 - y++;
    		   p = 5 - (y = y - 1);
    		   a(6, c);
    		   a.b.c(o, l, t);
    		} else if (a > b) {
    		   w = 9 * 5 / 4 - y++;
    		   p = 5 - (y = y - 1);

    		} else {
    		   a = 2;
    		   x = 5 + b(8);
    		}*/
    	
    	/*int i, j, k;
		
for (i = 1; i < n; i++) {
			
    k = v.data[i];
			
    j = i - 1;
			
    while  (j >= 0 && v.data[j] > k) {
      v.data[j + 1] = v.data[j];
      j--;
    }
			
    v.data[j + 1] = k;
			
}*/
    	
    	/*for (int q = 8, t = 6+7*5, hfhf = 3;;);
    	
    	for(p = 6+7*5, int u = 2, w = 2;w<2 && p<4 && w < 3;)
    	
    	/*while(5 - (y = y - 1)){
    		
    		
    		
    	}*/
    	
    	/*if (x > y) {
    		  int x = 6+7*5 > y-8;
    		  w = 9 * 5 / 4 - y++;
    		  p = 5 - (y = y - 1);
    		}
    	
    	int k = ((1 || (2 ^ ((3 * 2) && 13))) || 2);
    	
    	-x;*/
    	
    	/*int k = 5;
    	
    	int j = 4 + k++;
    	
    	System.out.println(k);
    	
    	k = 5;
    	
    	int m = 4 + (k++);
    	
    	System.out.println(k);
    	
    	System.out.println(j);
    	System.out.println(m);*/
    	
    	/*int derw;
    	
    	int djdf = 8;
    	
    	djdf = 5 - (derw = djdf + 4);
    	
    	System.out.println(derw);
    	
    	System.out.println(djdf);
    	
    	int kgkg[] = new int [5];
    	
    	for(kgkg[0] = 2;;);*/
    	
    	//int jhjhh, float hajshas;
    	
    	int kgkg[] = new int [5];
    	
    	kgkg[0] = 5;
    	
    	System.out.println(kgkg[0]);
    	
    	StringBuffer buffer = new StringBuffer();
    	
           
            
            try {
            	 File file = new File("dir"); 
                 file.mkdir();
	FileWriter fw = new FileWriter("dir/A.j");
	BufferedWriter bw =  new BufferedWriter(fw);
	bw.write(buffer.toString());
	bw.close();
	fw.close();
} catch (IOException e) {
	e.printStackTrace();
};

   o = new Object();
   
   int x = 0;
   
   int ppp[] = new int[8];
   
   
   kgkg[ppp[8] + x - 2 + 6] = 3;
  
        
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
    
    public static int a(int a){
    	
    	return 5;
    	
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
