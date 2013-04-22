package br.ufpb.iged.avaliador.medidorEficiencia.efficiency;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTxt {

	  	// File diretorio = new 
	   File arquivo;  
	   FileWriter escreve;  
	   String nomeArquivo = "arquivosQuiz/repostasQuiz.txt";  
	     
	   public WriteTxt(String nArquivo) {  
	     
		   
	      arquivo = new File(nArquivo);  
	      nomeArquivo = nArquivo;  
	      this.criarTXT();  
	        
	   }  
	   
	   public WriteTxt(){
		   
	   }
	     
	   // método para criar o txt  
	   private void criarTXT(){  
	              
	      if(arquivo.exists()== false){  
	         try {  
	            arquivo.createNewFile();  
	         } catch (IOException e) {  
	              
	            e.printStackTrace();  
	         }  
	      } else{
	    	  arquivo.delete();
	    	  try {
				arquivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
	    	  
	        
	   }  
	   // método para escrever no TXT  
	   public void escreve(String conteudo){  
	        
	      try {  
	         escreve = new FileWriter(this.nomeArquivo, true);  
	         //conteudo += "\n\r"; // pular linha  
	         escreve.write(conteudo); // escrever o conteúdo 
	         
	         System.out.println();
	         escreve.close();  
	      } catch (IOException e) {
	    	  System.out.println("Não Abriu");
	         // TODO Auto-generated catch block  
	         e.printStackTrace();  
	      }  
	   }  
	
}
