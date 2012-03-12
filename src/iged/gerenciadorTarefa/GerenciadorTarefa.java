/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorTarefa;

/**
 *
 * @author Dorgi
 */
public class GerenciadorTarefa {

    Portifolio portifolio;
    private static GerenciadorTarefa ger = null;

    private GerenciadorTarefa() {
        portifolio = PortifolioXml.lerXml();
    }

    public void cadastrarTarefa(Tarefa t) {
        portifolio.adicionar(t.getMetadado());
        PortifolioXml.criarXml(portifolio);
        TarefaXml.criarXml(t);
    }

    public static GerenciadorTarefa getInstance() {
        if (ger == null) {
            ger = new GerenciadorTarefa();
        }
        return ger;
    }
}
