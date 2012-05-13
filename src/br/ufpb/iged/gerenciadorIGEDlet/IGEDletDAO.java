/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gerenciadorIGEDlet;

/**
 *
 * @author GILBERTO FARIAS
 */
public class IGEDletDAO {
    protected Metadado metadado;
    protected String descricao;
    
    public Metadado getMetadado() {
        return metadado;
    }

    public void setMetadado(Metadado metadado) {
        this.metadado = metadado;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
