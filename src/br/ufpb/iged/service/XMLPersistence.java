package br.ufpb.iged.service;

import br.ufpb.iged.IGEDProperties;
import br.ufpb.iged.gerenciadorIGEDlet.IGEDletSubjetiva;
import br.ufpb.iged.gerenciadorIGEDlet.Metadado;
import br.ufpb.iged.gerenciadorIGEDlet.XmlPersistencia;
import br.ufpb.iged.model.Atividade;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan Oliveira   
 */
public class XMLPersistence {
    
    public void save(Object objeto, String pathPropert){
  
        String pathTmp = IGEDProperties.getInstance().getPropety(pathPropert);
      
        
        XStream xstream = new XStream(new DomDriver());

        xstream.alias("atividade", Object.class);

        String xmlTutorial = xstream.toXML(objeto);
        
        System.out.println(xmlTutorial);
        
   
    
        BufferedWriter writer = null;
        //Cria o arquivo já no sub-diretório
        File arquivo = new File(pathTmp, "tarefaTeste2.xml");

        try {
            writer = new BufferedWriter(new FileWriter(arquivo));
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            writer.write(xmlTutorial); //salva fisicamente
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(XmlPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static void main(String args[]){
    
        XMLPersistence persistence = new XMLPersistence();
        
        Atividade atividade = new Atividade();       
        
        atividade.setNome("Renan");

        persistence.save(atividade, "tarefasPath");
    
    }
    
}
