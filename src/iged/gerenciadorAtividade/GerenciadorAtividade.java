/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

import java.util.LinkedList;

public class GerenciadorAtividade {

    Portifolio portifolio;
    private static GerenciadorAtividade ger = null;

    private GerenciadorAtividade() {
        portifolio = PortifolioXml.lerXml();
    }

    public void cadastrar(AtividadeSubjetiva t) {
        portifolio.adicionar(t.getDAO().getMetadado());
        PortifolioXml.criarXml(portifolio);
        AtividadeXml.criarXml(t);
    }

    public LinkedList<MetadadoAtividade> listarTarefas() {
        return portifolio.getTarefas();
    }
    
    public Atividade loadTarefa(MetadadoAtividade mt){
        return AtividadeXml.lerXml(mt);
    }   

    public static GerenciadorAtividade getInstance() {
        if (ger == null) {
            ger = new GerenciadorAtividade();
        }
        return ger;
    }
}
