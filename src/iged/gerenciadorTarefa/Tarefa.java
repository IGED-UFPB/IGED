/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorTarefa;

/**
 *
 * @author Dorgi
 */
public class Tarefa {
    
    private MetadadoTarefa metadado;
    private String codInicializacao;
    private String codSolucao;
    private String descricao;

    public Tarefa(){
    }

    public String getCodInicializacao() {
        return codInicializacao;
    }

    public void setCodInicializacao(String codInicializacao) {
        this.codInicializacao = codInicializacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getCodSolucao() {
        return codSolucao;
    }

    public void setCodSolucao(String codSolucao) {
        this.codSolucao = codSolucao;
    }

    public MetadadoTarefa getMetadado() {
        return metadado;
    }

    public void setMetadado(MetadadoTarefa metadado) {
        this.metadado = metadado;
    }
    
    
}
