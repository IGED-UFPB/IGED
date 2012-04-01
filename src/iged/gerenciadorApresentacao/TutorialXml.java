/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorApresentacao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import iged.gui.TelaCadastroDeTutorialInterno;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Dorgi
 */
public class TutorialXml {
    
    //private static Tutorial tutorial;
    private static XmlPersistencia p;
    public static final File raiz = new File("./Tutoriais");

    public static void criarXml(Tutorial tutorial) throws DiretorioExistenteException {
        XStream xstream = new XStream(new DomDriver());

        xstream.alias("tutorial", Tutorial.class);

        String xmlTutorial = xstream.toXML(tutorial);
        System.out.println(xmlTutorial);
        XmlPersistencia.salvarXml(xmlTutorial, "tutorial.xml");
        
    }

   public static Tutorial lerXml() {
        XStream x = new XStream(new DomDriver());
        //MetadadoTarefa metadado = new MetadadoAtividade();
        try {
            // carrega o arquivo XML
            FileInputStream input = new FileInputStream(new File(p.getNovoDir()+"/tutorial.xml"));
            // informa o nome do nó raiz do xml
            x.alias("tutorial", Tutorial.class);
            // cria um objeto da classe, contendo os dados lidos no xml
            Tutorial tut = (Tutorial) x.fromXML(input);

                System.out.println("Área: "+tut.getArea());
                System.out.println("Autor: "+tut.getAutor());
                System.out.println("Ano: "+tut.getAno());
                System.out.println("Título: "+tut.getTitulo());
                System.out.println("Descrição: "+tut.getDescricao());
                System.out.println("Slides: "+tut.getSlides());
           
            return tut;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

 
}
