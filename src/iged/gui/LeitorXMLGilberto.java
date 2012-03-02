/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package iged.gui;

import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.*;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



/**
 *
 * @author Dorgi
 */
public class LeitorXMLGilberto {

    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

    public static void main(String[] args) {
        //leitor("tutorial.xml");
    }

    List<TutorialXML> tutoriais = new LinkedList<TutorialXML>();

    public List<TutorialXML> getTutorials(){
        return tutoriais;
    }

    public void initTutorials(){
        File dir = new File(LeitorXMLGilberto.dirTutorials);

        String tutorialsDir[] = dir.list();
        for(String d : tutorialsDir){
            System.out.println("DIR: "+d);

            this.leitorTutorial(dir.getAbsolutePath() + "\\" + d,  "tutorial.xml");
        }
    }

    public void leitorTutorial(String dir, String fileName) {
    try {

        File file = new File(dir + "\\" + fileName);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);

        NodeList nodes = doc.getElementsByTagName("tutorial");

        for (int i = 0; i < nodes.getLength(); i++) {
            TutorialXML txml = new TutorialXML();
            Element tutorial = (Element) nodes.item(i);

            txml.titulo = tutorial.getAttribute("titulo");
            System.out.println("Título: " + txml.titulo);

            txml.dir = dir;
            System.out.println("Dir: " + txml.dir);

            txml.autor = tutorial.getAttribute("autor");
            System.out.println("Autor: " + txml.autor);

            txml.desc = tutorial.getAttribute("descricao");
            System.out.println("Descrição: " + txml.desc);

            NodeList exercicios = tutorial.getElementsByTagName("exercicio");

            for (int j = 0; j < exercicios.getLength(); j++) {
                ExercicioXML exl = new ExercicioXML();
                Element exe = (Element) exercicios.item(j);

                exl.id = Integer.parseInt(exe.getAttribute("id"));
                System.out.println("Exercicio: " + exl.id);

                exl.slide = Integer.parseInt(exe.getAttribute("slide"));
                System.out.println("No slide: " + exl.slide);

                exl.idIGED = exe.getAttribute("atividade");
                System.out.println("Título: " + exl.idIGED);

                txml.add(exl);
            }
            this.tutoriais.add(txml);
        }
    } catch (Exception e) {
        System.out.println("Erro na leitura : " + e.getMessage());
    }



  }

    private static final String dirTutorials = "tutorial";

}
class TutorialXML{
    String titulo;
    String autor;
    String desc;
    String dir;
    Date data;

       List<ExercicioXML> exercicios = new LinkedList<ExercicioXML>();

    public void add(ExercicioXML e){
        exercicios.add(e);
    }
}

class ExercicioXML{
    int id;
    int slide;
    String idIGED;
}
