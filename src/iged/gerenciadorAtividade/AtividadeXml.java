/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author Dorgi
 */
public class AtividadeXml {

    private static MetadadoAtividade atividade;
    public static final File raiz = new File("./Tarefas");

    public static void criarXml(AtividadeSubjetiva atividade) {
        XStream xstream = new XStream(new DomDriver());

        xstream.alias("tarefa", AtividadeSubjetiva.class);
        xstream.alias("metadados", MetadadoAtividade.class);

        String xmlTutorial = xstream.toXML(atividade);
        System.out.println(xmlTutorial);
        XmlPersistencia.salvarXml(xmlTutorial, "tarefa" + atividade.getDAO().getMetadado().getId() + ".xml");
    }

    static AtividadeSubjetiva lerXmlSubjetiva(int id) {
        XStream x = new XStream(new DomDriver());
        //MetadadoTarefa metadado = new MetadadoAtividade();
        try {
            // carrega o arquivo XML
            FileInputStream input = new FileInputStream(new File(XmlPersistencia.DIRTAREFAS + "tarefa" + id + ".xml"));
            // informa o nome do nó raiz do xml
            x.alias("atividade", AtividadeSubjetivaDAO.class);
            x.alias("metadados", MetadadoAtividade.class);
            // cria um objeto da classe, contendo os dados lidos no xml
            AtividadeSubjetivaDAO dao = (AtividadeSubjetivaDAO) x.fromXML(input);
            AtividadeSubjetiva as = new AtividadeSubjetiva();
            as.setDAO(dao);

            return as;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Atividade lerXml(MetadadoAtividade mt) {
        if(mt.getType() == Atividade.SUBJETIVA)
            return AtividadeXml.lerXmlSubjetiva(mt.getId());
        else
            return null;
    }

    /*public ArrayList buscarTitulo(String palavra, String caminhoInicial) {
        ArrayList lista = new ArrayList();
        caminhoInicial = "./Tarefas";
        try {
            File arquivo = new File(caminhoInicial);
            lista = buscar(arquivo, palavra, lista);
            JOptionPane.showMessageDialog(null, "Encontrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Caminho Inválido");
        }
        return lista;
    }*/

    /*public ArrayList buscar(File arquivo, String palavra, ArrayList lista) {
        LinkedList<File> arquivos = new LinkedList<File>();
        String leitor = null;
        if (arquivo.isFile()) {
            arquivos.add(arquivo);
            for (int i = 0; i < arquivos.size(); i++) {
                leitor = lerXml(i).getMetadado().getTitulo();
            }

            lista.add(arquivo.getAbsolutePath());
        }
        if (arquivo.isDirectory()) {
            File[] subPastas = arquivo.listFiles();
            for (int i = 0; i < subPastas.length; i++) {
                lista = buscar(subPastas[i], palavra, lista);
                if (arquivo.getName().equalsIgnoreCase(palavra)) {
                    lista.add(arquivo.getAbsolutePath());
                } else if (arquivo.getName().indexOf(palavra) > -1) {
                    lista.add(arquivo.getAbsolutePath());
                }
            }
        } else if (arquivo.getName().equalsIgnoreCase(palavra)) {
            lista.add(arquivo.getAbsolutePath());
        } else if (arquivo.getName().indexOf(palavra) > -1) {
            lista.add(arquivo.getAbsolutePath());
        }
        return lista;
    }*/

    
}  

