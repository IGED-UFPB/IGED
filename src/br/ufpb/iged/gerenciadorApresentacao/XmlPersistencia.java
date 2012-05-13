/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gerenciadorApresentacao;

import br.ufpb.iged.gui.TelaCadastroDeTarefaInterno;
import br.ufpb.iged.gui.TelaCadastroDeTutorialInterno;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dorgi
 */
public class XmlPersistencia {
    
    public static final String DIRTAREFAS = "./Tutoriais/";
    private static File novoDir;
    static File dir;
    
    public XmlPersistencia() {
    }

    public static File criarDiretorio() throws DiretorioExistenteException {
        TelaCadastroDeTutorialInterno tc = new TelaCadastroDeTutorialInterno();
        novoDir = new File(DIRTAREFAS + tc.getTituloStr());
        //if (novoDir.exists()) {
           // throw new DiretorioExistenteException("Diretório já existe! Digite outro título!");
       // } else {
            novoDir.mkdir();
            System.out.println("Diretório criado em: " + novoDir.getAbsolutePath());
        //}
        return novoDir;
    }

    public static File getNovoDir() throws DiretorioExistenteException{
         dir = criarDiretorio();
        return dir;
    }
    
    static TutorialXml cxml = new TutorialXml();
    
    public static void salvarXml(String tutorial, String nomeArquivo) throws DiretorioExistenteException {
        BufferedWriter writer = null;
        //Cria o arquivo já no sub-diretório
        File arquivo = new File(getNovoDir(), "tutorial.xml");

        try {
            writer = new BufferedWriter(new FileWriter(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.write(tutorial);
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroDeTutorialInterno.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /*
    public static void salvarPortifolioXmlAtualizado() {
        BufferedWriter writer = null;
        //Cria o arquivo já no sub-diretório
        File arquivo = new File(cxml.getDir(), DIRTAREFAS+"tarefas.xml");

        try {
            writer = new BufferedWriter(new FileWriter(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroDeTarefaInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.write(cxml.atualizar()); //salva fisicamente
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroDeTarefaInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroDeTarefaInterno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
}
