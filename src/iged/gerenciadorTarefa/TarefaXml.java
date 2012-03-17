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
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dorgi
 */
public class TarefaXml {

    private static MetadadoTarefa tarefa;
    public static final File raiz = new File("./Tarefas");

    public static void criarXml(Tarefa tarefa) {
        XStream xstream = new XStream(new DomDriver());

        xstream.alias("tarefa", Tarefa.class);
        xstream.alias("metadados", MetadadoTarefa.class);

        String xmlTutorial = xstream.toXML(tarefa);
        System.out.println(xmlTutorial);
        XmlPersistencia.salvarXml(xmlTutorial, "tarefa" + tarefa.getMetadado().getId() + ".xml");
    }

    public static Tarefa lerXml(int id) {
        XStream x = new XStream(new DomDriver());
        //MetadadoTarefa metadado = new MetadadoTarefa();
        try {
            // carrega o arquivo XML
            FileInputStream input = new FileInputStream(new File(XmlPersistencia.DIRTAREFAS + "tarefa" + id + ".xml"));
            // informa o nome do nó raiz do xml
            x.alias("tarefa", Tarefa.class);
            x.alias("metadados", MetadadoTarefa.class);
            // cria um objeto da classe, contendo os dados lidos no xml
            Tarefa tf = (Tarefa) x.fromXML(input);

            System.out.println("Tarefa");
            System.out.println("Código de Inicialização: " + tf.getCodInicializacao());
            System.out.println("Código de Solução: " + tf.getCodSolucao());
            System.out.println("Descrição: " + tf.getDescricao());
            System.out.println("Área: " + tf.getMetadado().getArea());
            System.out.println("Autor: " + tf.getMetadado().getAutor());
            System.out.println("Título: " + tf.getMetadado().getTitulo());
            System.out.println("Id: " + tf.getMetadado().getId());

            return tf;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList buscarTitulo(String palavra, String caminhoInicial) {
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
    }

    public ArrayList buscar(File arquivo, String palavra, ArrayList lista) {
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
    }

    
}  

