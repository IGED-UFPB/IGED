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
    
    public IGEDlet loadTarefa(int igedID) {
        Metadado m = this.portifolio.getTarefa(igedID);
        if(m != null)
            return this.loadTarefa(m);
        else
            return null;
    }

    public static GerenciadorAtividade getInstance() {
        if (ger == null) {
            ger = new GerenciadorAtividade();
        }
        return ger;
    }

}
