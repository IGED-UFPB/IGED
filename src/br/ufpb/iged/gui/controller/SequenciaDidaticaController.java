package br.ufpb.iged.gui.controller;

import br.ufpb.iged.IGEDProperties;
import br.ufpb.iged.gerenciadorIGEDlet.XmlPersistencia;
import br.ufpb.iged.model.SequenciaDidatica;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Renan Oliveira
 */
public class SequenciaDidaticaController {

    private List<SequenciaDidatica> sequenciasDidatica;

    public List<SequenciaDidatica> listaDeSequenciaDidatica(String filtro) {

        XStream x = new XStream(new DomDriver());
        
        int indice = Integer.parseInt(IGEDProperties.getInstance().getPropety("indicesSequencia"));
        String path = IGEDProperties.getInstance().getPropety("sequenciaPath");


        sequenciasDidatica = new ArrayList<SequenciaDidatica>();

        if (filtro.equals("") || filtro == null) {
            try {

                for (int i = 1; i < indice; i++) {

                    FileInputStream input = new FileInputStream(path + "/sequencia-" + i + ".xml");

                    x.alias("sequenciaDidatica", SequenciaDidatica.class);

                    SequenciaDidatica sequencia = (SequenciaDidatica) x.fromXML(input);

                    sequenciasDidatica.add(sequencia);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sequenciasDidatica;

    }

    public void salvarSequenciaDidatica(SequenciaDidatica sequenciaDidatica) {


        String path = IGEDProperties.getInstance().getPropety("sequenciaPath");

        int indice = Integer.parseInt(IGEDProperties.getInstance().getPropety("indicesSequencia"));

        System.out.println(indice);

        XStream xstream = new XStream(new DomDriver());

        xstream.alias("sequenciaDidatica", SequenciaDidatica.class);

        String xmlSequencia = xstream.toXML(sequenciaDidatica);

        System.out.println(xmlSequencia);


        BufferedWriter writer = null;
        File arquivo = new File(path, "sequencia-" + indice + ".xml");

        try {
            writer = new BufferedWriter(new FileWriter(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            writer.write(xmlSequencia); //salva fisicamente
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
        IGEDProperties.getInstance().setProperty("indicesSequencia", String.valueOf(indice + 1));

    }
    /*
     * public static void main(String args[]) {
     *
     * SequenciaDidaticaController controller = new
     * SequenciaDidaticaController(); SequenciaDidatica sequencia = new
     * SequenciaDidatica(); sequencia.setNome("Renan 33");
     *
     * controller.salvarSequenciaDidatica(sequencia);
     *
     * List<SequenciaDidatica> sequencias =
     * controller.listaDeSequenciaDidatica(null);
     *
     * for(SequenciaDidatica s: sequencias){
     *
     * System.out.println(s.getNome()); }
     *
     * }
     */
}
