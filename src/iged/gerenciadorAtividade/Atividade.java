/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

import javax.swing.JPanel;

public abstract class Atividade {    
    
    protected MetadadoAtividade metadado;
    protected String descricao;
    
    public abstract void inicio();
    public abstract void resolve(String response);
    public abstract void reinicio();
    public abstract boolean estaCorreta();
    public abstract JPanel getQuadro();
    
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
    
    public static final int SUBJETIVA = 0;
    public static final int OBJETIVA = 1;

}
