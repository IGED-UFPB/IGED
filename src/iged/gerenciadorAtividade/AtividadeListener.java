/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

/**
 *
 * @author GILBERTO FARIAS
 */
public interface AtividadeListener {

    public abstract void atividadeIniciada(AtividadeEvent event);
    public abstract void atividadeResolvida(AtividadeEvent event);
    
}
