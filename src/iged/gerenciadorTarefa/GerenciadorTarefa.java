/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorTarefa;

import iged.IGEDConst;
import iged.Interpretador;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author Dorgi
 */
public class GerenciadorTarefa {

    Interpretador iter = Interpretador.getInstance();
    Portifolio portifolio;
    private static GerenciadorTarefa ger = null;

    private GerenciadorTarefa() {
        portifolio = PortifolioXml.lerXml();
    }

    public void cadastrar(Tarefa t) {
        portifolio.adicionar(t.getMetadado());
        PortifolioXml.criarXml(portifolio);
        TarefaXml.criarXml(t);
    }

    public LinkedList<MetadadoTarefa> listarTarefas() {
        return portifolio.getTarefas();
    }

    public void executar(MetadadoTarefa mt) {
        Tarefa t = TarefaXml.lerXml(mt.getId());
        iter.setMode(IGEDConst.MODE_BOTH);
        String codigo = t.getCodInicializacao();
        execute(codigo);
        iter.setMode(IGEDConst.MODE_PROFESSOR);
        codigo = t.getCodSolucao();
        execute(codigo);
        iter.setMode(IGEDConst.MODE_STUDENT);
    }

    private void execute(String cod) {
        StringTokenizer st = new StringTokenizer(cod, "\n");
        while (st.hasMoreTokens()) {
            String c = st.nextToken();
            System.out.println(c);
            iter.interprete(c);
        }
    }

    public static GerenciadorTarefa getInstance() {
        if (ger == null) {
            ger = new GerenciadorTarefa();
        }
        return ger;
    }
}
