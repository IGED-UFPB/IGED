/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorTarefa;

import java.util.LinkedList;

/**
 *
 * @author Dorgi
 */
public class Portifolio {
    
    LinkedList<MetadadoTarefa> tarefas;
    int cont=0;
            
    public Portifolio(){
        tarefas = new LinkedList<MetadadoTarefa>();
    }

    public LinkedList<MetadadoTarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(LinkedList<MetadadoTarefa> tarefas) {
        this.tarefas = tarefas;
    }
    
    public void adicionar(MetadadoTarefa m){
        m.setId(cont);
        tarefas.add(m);
        cont++;
    }

    public int getCont() {
        return cont;
    }

    
    
}
