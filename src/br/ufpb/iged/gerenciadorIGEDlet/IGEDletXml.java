
package br.ufpb.iged.gerenciadorIGEDlet;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Dorgi
 */
public class IGEDletXml {

    private static Metadado atividade;
    public static final File raiz = new File("./Tarefas");

    public static void criarXml(IGEDletSubjetiva atividade) {
        XStream xstream = new XStream(new DomDriver());

        xstream.alias("atividade", IGEDletSubjetiva.class);
        xstream.alias("metadados", Metadado.class);

        String xmlTutorial = xstream.toXML(atividade);
        System.out.println(xmlTutorial);
        XmlPersistencia.salvarXml(xmlTutorial, "tarefa" + atividade.getDAO().getMetadado().getId() + ".xml");
    }

    static IGEDletSubjetiva lerXmlSubjetiva(int id) {
        XStream x = new XStream(new DomDriver());
        //MetadadoTarefa metadado = new Metadado();
        try {
            // carrega o arquivo XML
            FileInputStream input = new FileInputStream(new File(XmlPersistencia.DIRTAREFAS + "tarefa" + id + ".xml"));
            // informa o nome do nó raiz do xml
            x.alias("atividade", IGEDletSubjetivaDAO.class);
            x.alias("metadados", Metadado.class);
            // cria um objeto da classe, contendo os dados lidos no xml
            IGEDletSubjetivaDAO dao = (IGEDletSubjetivaDAO) x.fromXML(input);
            IGEDletSubjetiva as = new IGEDletSubjetiva();
            as.setDAO(dao);

            return as;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static IGEDlet lerXml(Metadado mt) {
        if(mt.getType() == IGEDlet.SUBJETIVA)
            return IGEDletXml.lerXmlSubjetiva(mt.getId());
        else
            return null;
    } 
    
}  

