package br.ufpb.iged.gui.controller;

import br.ufpb.iged.IGEDProperties;
import br.ufpb.iged.gerenciadorIGEDlet.XmlPersistencia;
import br.ufpb.iged.model.Atividade;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class AtividadeController {

    private List<Atividade> atividades;

    public List<Atividade> lista(String filtro) {

        XStream x = new XStream(new DomDriver());

        int indice = Integer.parseInt(IGEDProperties.getInstance().getPropety("indicesAtividade"));
        String path = IGEDProperties.getInstance().getPropety("atividadePath");


        atividades = new ArrayList<Atividade>();

        if (filtro.equals("") || filtro == null) {
            try {

                for (int i = 1; i < indice; i++) {

                    FileInputStream input = new FileInputStream(path + "/atividade-" + i + ".xml");

                    x.alias("atividade", Atividade.class);

                    Atividade atividade = (Atividade) x.fromXML(input);

                    atividades.add(atividade);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return atividades;

    }

    public void salvar(Atividade atividade) {


        String path = IGEDProperties.getInstance().getPropety("atividadePath");

        int indice = Integer.parseInt(IGEDProperties.getInstance().getPropety("indicesAtividade"));

        System.out.println(indice);

        XStream xstream = new XStream(new DomDriver());

        xstream.alias("atividade", Atividade.class);

        String xmlAtividade = xstream.toXML(atividade);

        System.out.println(xmlAtividade);


        BufferedWriter writer = null;
        File arquivo = new File(path, "atividade-" + indice + ".xml");

        try {
            writer = new BufferedWriter(new FileWriter(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            writer.write(xmlAtividade); //salva fisicamente
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(SequenciaDidaticaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //ATUALIZANDO INDICE
        IGEDProperties.getInstance().setProperty("indicesAtividade", String.valueOf(indice + 1));

    }
}
