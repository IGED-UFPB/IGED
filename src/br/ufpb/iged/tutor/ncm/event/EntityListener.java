/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.tutor.ncm.event;

/**
 *
 * @author GILBERTO FARIAS
 * A classe que quiser receber a trnasição de eventos de um Nó do NCM, 
 * tem que implementar a classe EntityListener e adicionar uma instância no
 * nó requerido.
 */
public interface EntityListener {
    public abstract void stateTransition(EntityEvent e);
}
