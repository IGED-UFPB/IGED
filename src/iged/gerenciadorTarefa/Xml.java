/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorTarefa;

import iged.gui.ConversorXmlTutorial;
import iged.gui.DiretorioExistenteException;
import iged.gui.TelaCadastradorDeTutorial;
import iged.gui.gerenciador.ConversorXmlTarefa;
import iged.gui.TelaCadastroDeTarefa;
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
public class Xml {
    
    public Xml(){
        
    }
    /*
    public static void salvarXmlTarefa() {
        TelaCadastroDeTarefa tc = new TelaCadastroDeTarefa();
        ConversorXmlTarefa cxml = new ConversorXmlTarefa();
        BufferedWriter writer = null;
        //Cria o arquivo já no sub-diretório
        File arquivo = new File(cxml.getDir(), "tarefa" + tc.getIdStr() + ".xml");
        
        try {
            writer = new BufferedWriter(new FileWriter(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.write(cxml.converter()); //salva fisicamente
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    */
}
