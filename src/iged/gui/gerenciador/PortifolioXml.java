/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gui.gerenciador;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Dorgi
 */
public class PortifolioXml {

    private static File dir;
    private static String xmlTutorial;
    static Portifolio p = new Portifolio();
    static Portifolio t = new Portifolio();
    static File tarefas = new File("C:\\Tarefas\\tarefas.xml");

    public PortifolioXml() {
        dir = new File("C:\\Tarefas");
        dir.mkdir();
    }

    public static String converter() {
        XStream xstream = new XStream(new DomDriver());

        TelaCadastroDeTarefa tc = new TelaCadastroDeTarefa();
        xstream.alias("portifolio", Portifolio.class);

        t.setCont(Integer.parseInt(tc.getIdStr()));
        t.setTitulo(tc.getTituloStr());
        t.setId(tc.getIdStr());
        t.setAutor(tc.getAutorStr());
        t.setArea(tc.getAreaStr());

        xmlTutorial = xstream.toXML(t);
        System.out.println(xmlTutorial);
        //reconstruir um objeto a partir de um xml
        //Portifolio newPortifolio = (Portifolio) xstream.fromXML(xmlTutorial); 
        return xmlTutorial;
    }

    public static String atualizar() {
        
        return xmlTutorial;
    }

    public File getDir() {
        return dir;
    }

    public void setDir(File dir) {
        this.dir = dir;
    }

    public static String getXmlTutorial() {
        return xmlTutorial;
    }

    public void setXmlTutorial(String xmlTutorial) {
        this.xmlTutorial = xmlTutorial;
    }
}
