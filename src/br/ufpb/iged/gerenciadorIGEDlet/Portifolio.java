/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gerenciadorIGEDlet;

import java.util.LinkedList;

/**
 *
 * @author Dorgi
 */
public class Portifolio {
    
    LinkedList<Metadado> tarefas;
    int cont=0;
            
    public Portifolio(){
        tarefas = new LinkedList<Metadado>();
    }

    public LinkedList<Metadado> getTarefas() {
        return tarefas;
    }

    public void setTarefas(LinkedList<Metadado> tarefas) {
        this.tarefas = tarefas;
    }
    
    public void adicionar(Metadado m){
        m.setId(cont);
        tarefas.add(m);
        cont++;
    }

    public int getCont() {
        return cont;
    }

    
    
}
