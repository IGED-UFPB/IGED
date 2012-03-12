/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorTarefa;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 *
 * @author Dorgi
 */
public class PortifolioXml {


    public static void criarXml(Portifolio portifolio) {
        XStream xstream = new XStream(new DomDriver());

        xstream.alias("portifolio", Portifolio.class);

        String xmlTutorial = xstream.toXML(portifolio);
        System.out.println(xmlTutorial);
        XmlPersistencia.salvarXml(xmlTutorial, "tarefas.xml");
    }

    public static Portifolio lerXml() {
       /*
        XStream x = new XStream(new DomDriver());
        //MetadadoTarefa metadado = new MetadadoTarefa();
        try {
            // carrega o arquivo XML
            FileInputStream input = new FileInputStream(new File(XmlPersistencia.DIRTAREFAS+"tarefas.xml"));
            // informa o nome do nó raiz do xml
            x.alias("portifolio", Portifolio.class);
            // cria um objeto da classe, contendo os dados lidos no xml
            Portifolio pf = (Portifolio) x.fromXML(input);

            return pf;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        return new Portifolio();


    }
}
