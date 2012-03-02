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
    CamposXML c = new CamposXML();

    public ConversorXmlTutorial() {
    }

    public void criarDiretorio() throws DiretorioExistenteException {
        TelaCadastradorXML tc = new TelaCadastradorXML();
        novoDir = new File("C:\\Tutoriais\\" + tc.getTituloStr());
        if (novoDir.exists()) {
            throw new DiretorioExistenteException("Diretório já existe! Digite outro título!");
        } else {
            novoDir.mkdir();
            System.out.println("Diretório criado em: " + novoDir.getAbsolutePath());
        }
    }

    public void converterStringXML() throws DiretorioExistenteException {
        XStream xstream = new XStream(new DomDriver());
        TelaCadastradorXML tc = new TelaCadastradorXML();
        xstream.alias("Cadastro de Apresentação", CamposXML.class);

        c.setTitulo(tc.getTituloStr());
        c.setAno(tc.getAnoStr());
        c.setAutor(tc.getAutorStr());
        c.setDescricao(tc.getDescricaoStr());
        c.setArea(tc.getAreaStr());

        xmlTutorial = xstream.toXML(c);
        System.out.println(xmlTutorial);


        //c.getCampos().add(xmlTutorial);
    }

    public void salvar() {
        XStream xstream = new XStream(new DomDriver());
        xmlTutorial = xstream.toXML(c);
        BufferedWriter writer = null;
        //Cria o arquivo já no sub-diretório
        File arquivo = new File(novoDir, "tutorial.xml");

        try {
            writer = new BufferedWriter(new FileWriter(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastradorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.write(xmlTutorial); //salva fisicamente
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastradorXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastradorXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
