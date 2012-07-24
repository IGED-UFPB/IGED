/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpb.iged.gui.gerenciador;

import br.ufpb.iged.IGEDProperties;
import br.ufpb.iged.gui.TelaCadastroDeTarefaInterno;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;

/**
 *
 * @author Dorgi
 */
public class ConversorXmlTarefa {

    private File dir;
    private String xmlTutorial;
    
    private static IGEDProperties properties = IGEDProperties.getInstance();

    public ConversorXmlTarefa() {
        dir = new File(properties.getPropety("tarefasPath"));
        dir.mkdir();
    }
    CadastroTarefa t = new CadastroTarefa();

    public String converter() {
        XStream xstream = new XStream(new DomDriver());

        TelaCadastroDeTarefa tc = new TelaCadastroDeTarefa();
        xstream.alias("Tarefa", CadastroTarefa.class);

        t.setTitulo(tc.getTituloStr());
        t.setId(tc.getIdStr());
        t.setAutor(tc.getAutorStr());
        t.setDescricao(tc.getDescricaoStr());
        t.setArea(tc.getAreaStr());
        t.setCodInicializacao(tc.getInicializacaoStr());
        t.setCodSolucao(tc.getSolucaoStr());

        xmlTutorial = xstream.toXML(t);
        System.out.println(xmlTutorial);
        return xmlTutorial;
    }

    public File getDir() {
        return dir;
    }

    public void setDir(File dir) {
        this.dir = dir;
    }

    public String getXmlTutorial() {
        return xmlTutorial;
    }

    public void setXmlTutorial(String xmlTutorial) {
        this.xmlTutorial = xmlTutorial;
    }
}
