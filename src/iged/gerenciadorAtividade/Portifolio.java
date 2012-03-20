/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

import java.util.LinkedList;

/**
 *
 * @author Dorgi
 */
public class Portifolio {
    
    LinkedList<MetadadoAtividade> tarefas;
    int cont=0;
            
    public Portifolio(){
        tarefas = new LinkedList<MetadadoAtividade>();
    }

    public LinkedList<MetadadoAtividade> getTarefas() {
        return tarefas;
    }

    public void setTarefas(LinkedList<MetadadoAtividade> tarefas) {
        this.tarefas = tarefas;
    }
    
    public void adicionar(MetadadoAtividade m){
        m.setId(cont);
        tarefas.add(m);
        cont++;
    }

    public int getCont() {
        return cont;
    }

    
    
}
