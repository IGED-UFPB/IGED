/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

/**
 *
 * @author GILBERTO FARIAS
 */
public class AtividadeDAO {
    protected MetadadoAtividade metadado;
    protected String descricao;
    
    public MetadadoAtividade getMetadado() {
        return metadado;
    }

    public void setMetadado(MetadadoAtividade metadado) {
        this.metadado = metadado;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
