package br.ufpb.iged.interpretador.principal;

import java.util.List;

import br.ufpb.iged.interpretador.excecoes.ClassNotFoundException;
import br.ufpb.iged.interpretador.symboltable.classes.SimboloClasse;

public class ClassLoader {
		
	private static final String METODO_MAIN = "main(VOID)V";
	
	public static SimboloClasse carregarClasse(String nome) throws ClassNotFoundException{
		
		List<SimboloClasse> classes = Interpretador.getVm().getAreaClasses();
    	    	
    	for(SimboloClasse classe: classes){
    		  			
    			if (classe.nome.equals(nome)){
    				classe.alocarMemoriaVariaveis(null, true);
    				return classe;
    			}
    			
    		
    	}
    	
		throw new ClassNotFoundException("A classe "+nome+" não foi encontrada");
    	
    }
	
	public static SimboloClasse carregarClasse(int index) throws ClassNotFoundException {
		
		SimboloClasse classe = Interpretador.getVm().getAreaClasses().get(index);
		
		if (classe != null){
			classe.alocarMemoriaVariaveis(null, true);
			return classe;
		}
		
		throw new ClassNotFoundException("A classe referenciada não pôde ser encontrada");
		
	}
	
	public static SimboloClasse carregarClasseMain() throws ClassNotFoundException{
    	
		List<SimboloClasse> classes = Interpretador.getVm().getAreaClasses();
    	
		for(SimboloClasse classe: classes){
    			
    			if (classe.possuiMetodo(METODO_MAIN)){
    				classe.alocarMemoriaVariaveis(null, true);
    				return classe;
    			}
    		
    	}
    	
    	throw new ClassNotFoundException("Não foi encontrada nenhuma classe que possua um método main");
    	
    }

}
