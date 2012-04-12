/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gerenciadorIGEDlet;

import java.util.LinkedList;

public class GerenciadorAtividade {

    Portifolio portifolio;
    private static GerenciadorAtividade ger = null;

    private GerenciadorAtividade() {
        portifolio = PortifolioXml.lerXml();
    }

    public void cadastrar(IGEDletSubjetiva t) {
        portifolio.adicionar(t.getDAO().getMetadado());
        PortifolioXml.criarXml(portifolio);
        IGEDletXml.criarXml(t);
    }

    public LinkedList<Metadado> listarTarefas() {
        return portifolio.getTarefas();
    }
    
    public IGEDlet loadTarefa(Metadado mt){
        return IGEDletXml.lerXml(mt);
    }   

    public static GerenciadorAtividade getInstance() {
        if (ger == null) {
            ger = new GerenciadorAtividade();
        }
        return ger;
    }
}
