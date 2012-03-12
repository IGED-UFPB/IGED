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

/**
 *
 * @author Dorgi
 */
public class TarefaXml {

    public static void criarXml(Tarefa tarefa) {
        XStream xstream = new XStream(new DomDriver());

        xstream.alias("tarefa", Portifolio.class);

        String xmlTutorial = xstream.toXML(tarefa);
        System.out.println(xmlTutorial);
        XmlPersistencia.salvarXml(xmlTutorial, "tarefa"+tarefa.getMetadado().getId()+".xml");
    }

    public static Tarefa lerXml(int id) {
        XStream x = new XStream(new DomDriver());
        //MetadadoTarefa metadado = new MetadadoTarefa();
        try {
            // carrega o arquivo XML
            FileInputStream input = new FileInputStream(new File(XmlPersistencia.DIRTAREFAS+"tarefa"+id+".xml"));
            // informa o nome do nó raiz do xml
            x.alias("tarefa", Portifolio.class);
            // cria um objeto da classe, contendo os dados lidos no xml
            Tarefa tf = (Tarefa) x.fromXML(input);

            return tf;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
