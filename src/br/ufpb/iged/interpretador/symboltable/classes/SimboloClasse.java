package br.ufpb.iged.interpretador.symboltable.classes;

import java.util.*;

import br.ufpb.iged.interpretador.principal.Inteiro;
import br.ufpb.iged.interpretador.principal.Objeto;
import br.ufpb.iged.interpretador.principal.Referencia;
import br.ufpb.iged.interpretador.principal.Valor;

public class SimboloClasse extends SimboloComEscopo implements Tipo {
   
    public SimboloClasse superClasse;
    
    public Map<String,Simbolo> membros=new LinkedHashMap<String,Simbolo>();
    
    protected List<SimboloVariavel> constantPool = new ArrayList<SimboloVariavel> ();
    
    protected List<SimboloMetodo> methodArea = new ArrayList<SimboloMetodo>();
    
    private Valor[] fields = null;
    
    protected int proximoElementoConstPool = 0;

    public SimboloClasse(String nome, Escopo escopoEnvolvente, SimboloClasse superClasse) {
    	
        super(nome, escopoEnvolvente);
        
        this.superClasse = superClasse;
        
        fields = null;
        
    }

    public Escopo obterEscopoPai() {
    	
        if ( superClasse==null ) return escopoEnvolvente; 
        
        return superClasse; 
        
    }

    public Simbolo resolverMembro(String nome) {
    	
        Simbolo s = membros.get(nome);
        
        if ( s!=null ) return s;
        
        if ( superClasse != null ) {
            return superClasse.resolverMembro(nome);
        }
        return null;
        
    }
    
    public SimboloMetodo resolverMetodoVirtual(String nome) {
    	
        Simbolo m = membros.get(nome);
        
        if (m != null && !((SimboloMetodo)m).isEstatico())
        	return (SimboloMetodo)m;
        
        if (superClasse != null)
        	return superClasse.resolverMetodoVirtual(nome);
        
        return null;
        
    }
    
    public SimboloMetodo resolverMetodoEstatico(String nome) {
    	
        Simbolo m = membros.get(nome);
        
        if (m != null && ((SimboloMetodo)m).isEstatico())
        	return (SimboloMetodo)m;
        
        if (superClasse != null)
        	return superClasse.resolverMetodoEstatico(nome);
        
        return null;
        
    }
    
    
    public SimboloMetodo resolverMetodoEspecial(String nome){
    	
    	return (SimboloMetodo) obterMembros().get(nome);
    	
    }
    
    
    public boolean possuiMetodo(String assinatura) {
    	
        Simbolo metodo = (SimboloMetodo)resolver(assinatura);
        
        if (metodo != null)
        	return true;
        
        return false;
        
    }
    
    public void alocarMemoriaVariaveis(Objeto objeto, boolean estaticas) {
    	
    	if (!estaticas || (estaticas && (fields == null))) {
    		
    		Valor[] variaveis = new Valor[obterQuantidadeVariaveis(estaticas)];
	    	
	    	definirTiposVariaveis(variaveis, 0, estaticas);
	    	
	    	
	    	if (estaticas)
	    		fields = variaveis;
        	else {
        		objeto.setMemoriaLocal(variaveis);
        	}
	    	
    	
    	}
    	
    		
    }
    
    public int definirTiposVariaveis(Valor[] vars, int i, boolean estaticas) {
    	
    	for (SimboloVariavel variavel : constantPool) {
			
			if (variavel.isEstatico() == estaticas) {
				
				String nomeTipo = variavel.getTipo().obterNome();
				
				if(nomeTipo.equals("I")) {
					
					vars[i] = new Inteiro(0);
					
					i++;
				
				} else if (nomeTipo.startsWith("L")) {
					
					vars[i] = new Referencia(new Integer(0), nomeTipo);
					
					i++;
					
				}
				
			}
			
		}
    	
    	return i;
    	
    }
    
    public int obterIdentificadorVariavel(SimboloVariavel variavel) {
    	
    	int i = 0;
    	
    	boolean estatico = variavel.isEstatico();
    	
    	for (SimboloVariavel var : constantPool) {
    		
    		if (var.isEstatico() == estatico){
    			
    			if (var == variavel)
    			   return i;
    			else
    				i++;
    		}
    		
    	}
    	
    	return i;
    	
    }
    
    public String obterIdentificadorVariavel(int endereco, boolean estatica){
    	
    	int i = 0;
    	
    	for (SimboloVariavel var : constantPool){
    		
    		if (var.isEstatico() == estatica){
    			
    			if (i == endereco)
    				return var.getNome();
    			else
    				i++;
    			
    		}
    		
    	}
    	
    	return null;   	
    	
    }
    
    public void alocarMemoriaFields() {
    	
    	 	
    	fields = new Valor[constantPool.size()];
		
		int i;
		
		for (i = 0; i < constantPool.size(); i++) {
			
			String nomeTipo = constantPool.get(i).getTipo().obterNome();
			
			if(nomeTipo.equals("I"))
				
				fields[i] = new Inteiro(0);
			
			else if (nomeTipo.startsWith("L"))
				
				fields[i] = new Referencia(new Integer(0), nomeTipo);
				
			
		}
		
		SimboloClasse parent = superClasse;
		
		while(parent != null) {
			
			List<SimboloVariavel> constantPoolParent = parent.getConstantPool();
			
			fields = 
					Arrays.copyOf(
							fields, fields.length + constantPoolParent.size());
			
			int j;
			
			for (j = 0; j < constantPoolParent.size(); j++, i++) {
				
				String nomeTipo = constantPoolParent.get(j).getTipo().obterNome();
				
				if(nomeTipo.equals("I"))
					
					fields[i] = new Inteiro(0);
				
				else if (nomeTipo.startsWith("L"))
					
					fields[i] = new Referencia(new Integer(0), nomeTipo);
					
				
			}
			
			parent = parent.getSuperClasse();
			
		}
    	
    }
    
    public int obterQuantidadeVariaveis(boolean estaticas) {
    	
    	int c = 0;
    	
    	for (SimboloVariavel variavel : constantPool) {
    		
    		if (variavel.isEstatico() == estaticas)
    			c++;
    		
    	}
    	
    	return c;
    	
    }
    
    public void alterarCampo(int index, Valor valor) {
    	
    	fields[index] = valor;
    	
    }

    public Map<String, Simbolo> obterMembros() {
    	
    	return membros; 
    	
    }
        
    public String toString() {
        return "class "+nome+":{"+
        		eliminarParenteses(membros.keySet().toString())+"}";
    }

	@Override
	public String obterNome() {
		return nome;
	}
	
	public String obterNomeSimples() {
		
		return nome.substring(1);
		
	}

	public List<SimboloVariavel>  getConstantPool() {
		return constantPool;
	}

	public void setConstantPool(List<SimboloVariavel> constantPool) {
		this.constantPool = constantPool;
	}

	public SimboloClasse getSuperClasse() {
		return superClasse;
	}

	public void setSuperClasse(SimboloClasse superClasse) {
		this.superClasse = superClasse;
	}

	public Valor[] getFields() {
		return fields;
	}

	public void setFields(Valor[] fields) {
		
		this.fields = fields;
		
	}

	public List<SimboloMetodo> getMethodArea() {
		return methodArea;
	}

	public void setMethodArea(List<SimboloMetodo> methodArea) {
		this.methodArea = methodArea;
	}

	
    
}

