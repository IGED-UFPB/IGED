/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

/**
 *
 * @author GILBERTO FARIAS
 */
public class AtividadeSubjetivaDAO extends AtividadeDAO{

    private String codInicializacao;
    private String codSolucao;

    public String getCodInicializacao() {
        return codInicializacao;
    }

    public void setCodInicializacao(String codInicializacao) {
        this.codInicializacao = codInicializacao;
    }
    
    public String getCodSolucao() {
        return codSolucao;
    }

    public void setCodSolucao(String codSolucao) {
        this.codSolucao = codSolucao;
    }
    
}
