/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gui;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Dorgi
 */
public class ConversorXmlTutorial {

    private File novoDir;
    private String xmlTutorial;
    CadastroTutorial c = new CadastroTutorial();

    public ConversorXmlTutorial() {
    }

    public File criarDiretorio() throws DiretorioExistenteException {
        TelaCadastradorDeTutorial tc = new TelaCadastradorDeTutorial();
        novoDir = new File("C:\\Tutoriais\\" + tc.getTituloStr());
        if (novoDir.exists()) {
            throw new DiretorioExistenteException("Diretório já existe! Digite outro título!");
        } else {
            novoDir.mkdir();
            System.out.println("Diretório criado em: " + novoDir.getAbsolutePath());
        }
        return novoDir;
    }

    public String converterStringXML(){
        XStream xstream = new XStream(new DomDriver());
        TelaCadastradorDeTutorial tc = new TelaCadastradorDeTutorial();
        xstream.alias("Cadastro de Apresentação", CadastroTutorial.class);

        c.setTitulo(tc.getTituloStr());
        c.setAno(tc.getAnoStr());
        c.setAutor(tc.getAutorStr());
        c.setDescricao(tc.getDescricaoStr());
        c.setArea(tc.getAreaStr());

        xmlTutorial = xstream.toXML(c);
        System.out.println(xmlTutorial);

        return xmlTutorial;
        //c.getCampos().add(xmlTutorial);
    }

    
    public void salvarXmlTutorial() {
        ConversorXmlTutorial tutorial = new ConversorXmlTutorial();
        BufferedWriter writer = null;
        //Cria o arquivo já no sub-diretório
        File arquivo = new File(novoDir, "tutorial.xml");

        try {
            writer = new BufferedWriter(new FileWriter(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.write(xmlTutorial); //salva fisicamente
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastradorDeTutorial.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public File getNovoDir() {
        return novoDir;
    }

    public void setNovoDir(File novoDir) {
        this.novoDir = novoDir;
    }

    public String getXmlTutorial() {
        return xmlTutorial;
    }

    public void setXmlTutorial(String xmlTutorial) {
        this.xmlTutorial = xmlTutorial;
    }

    

    
}
