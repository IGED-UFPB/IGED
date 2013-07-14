package br.ufpb.iged.tradutor.simbolos;

public interface Escopo {
	
    public String obterNomeEscopo();

    public Escopo obterEscopoPai();

    public Escopo obterEscopoEnvolvente();

    public void definir(Simbolo simbolo);

    public Simbolo resolver(String nome);
    
}
