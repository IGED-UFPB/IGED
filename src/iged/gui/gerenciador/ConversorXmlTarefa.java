/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gui.gerenciador;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
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
public class ConversorXmlTarefa {
    
    private File dir;
    private String xmlTutorial;
    
    public ConversorXmlTarefa(){
        dir = new File("C:\\Tarefas");
        dir.mkdir(); 
    }
    
    CadastroTarefa t = new CadastroTarefa();
    
    public void converter(){
        XStream xstream = new XStream(new DomDriver());
        
        TelaCadastroDeTarefa tc = new TelaCadastroDeTarefa();
        xstream.alias("Cadastro de Tarefa",CadastroTarefa.class);
        
        t.setTitulo(tc.getTituloStr());
        t.setId(tc.getIdStr());
        t.setAutor(tc.getAutorStr());
        t.setDescricao(tc.getDescricaoStr());
        t.setArea(tc.getAreaStr());
        
        xmlTutorial = xstream.toXML(t);
        System.out.println(xmlTutorial);
    }
    
    public void salvarXML(){
        TelaCadastroDeTarefa tc = new TelaCadastroDeTarefa();
        BufferedWriter writer = null;
        //Cria o arquivo já no sub-diretório
        File arquivo = new File(dir,"tarefa"+tc.getIdStr()+".xml");

        try {
               writer = new BufferedWriter(new FileWriter(arquivo));
            } catch (IOException ex) {
                Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                writer.write(xmlTutorial); //salva fisicamente
            } catch (IOException ex) {
                Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                writer.close();
                } catch (IOException ex) {
                Logger.getLogger(TelaCadastroDeTarefa.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
   
}
