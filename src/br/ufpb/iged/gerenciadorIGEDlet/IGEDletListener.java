/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gerenciadorIGEDlet;

/**
 *
 * @author GILBERTO FARIAS
 */
public interface IGEDletListener {

    public abstract void atividadeIniciada(IGEDletEvent event);
    public abstract void atividadeResolvida(IGEDletEvent event);
    
}
