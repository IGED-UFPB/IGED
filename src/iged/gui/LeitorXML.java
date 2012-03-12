/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gui;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Dorgi
 */
public class LeitorXML {

    private String titulo;
    private String autor;
    private String ano;
    private String descricao;
    private String area;
    CadastroTutorial c = new CadastroTutorial();
    LinkedList<String> informacoes;
    LinkedList<String> dado;

    public LeitorXML() {
        informacoes = new LinkedList<String>();
        dado = new LinkedList<String>();
    }

    public LinkedList lerXML() {
        XStream x = new XStream(new DomDriver());
        TelaCadastradorDeTutorial tc = new TelaCadastradorDeTutorial();

        try {
            // carrega o arquivo XML
            //File f = new File("C:\\Tutoriais\\"+tc.getTituloStr()+"\\tutorial.xml");
            File f = new File("C:\\Tutoriais\\teste1\\tutorial.xml");
            FileInputStream input = new FileInputStream(f);
            // informa o nome do nó raiz do xml
            x.alias("pessoa", CadastroTutorial.class);
            // cria um objeto de Campos,
            // contendo os dados lidos no xml
            c = (CadastroTutorial) x.fromXML(input);
            // imprime os dados

            titulo = c.getTitulo();
            autor = c.getAutor();
            ano = c.getAno();
            descricao = c.getDescricao();
            area = c.getArea();

            System.out.println("Título: " + titulo);
            System.out.println("Autor: " + autor);
            System.out.println("Ano: " + ano);
            System.out.println("Descrição: " + descricao);
            System.out.println("Área: " + area);

            dado.add(titulo);
            dado.add(autor);
            dado.add(ano);
            dado.add(descricao);
            dado.add(area);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        informacoes = dado;
        return informacoes;
    }

    public LinkedList<String> getInformacoes() {
        return informacoes;
    }

    public String exibirInformacao() {
        /*ListIterator<String> iterador = informacoes.listIterator(0);
        String valorXML=null;
        while (iterador.hasNext()) {
            valorXML = iterador.next();
            System.out.println(valorXML);
        }*/
        String valorXML=null;
        //for (int i = 0; i < informacoes.size(); i++) {
            //c.setTitulo(informacoes.get(i).toString());
            valorXML = informacoes.toString();
            System.out.println(valorXML);
       // }
        
        return valorXML;
    }
    
    public String infoTitulo(){
        String valorTitulo;
        valorTitulo = informacoes.get(0).toString();
        return valorTitulo;
    }
    
    public String infoAutor(){
        String valorAutor;
        valorAutor = informacoes.get(1).toString();
        return valorAutor;
    }
       
    public String infoAno(){
        String valorAno;
        valorAno = informacoes.get(2).toString();
        return valorAno;
    }

    public String infoDescricao(){
        String valorDesc;
        valorDesc = informacoes.get(3).toString();
        return valorDesc;
    }
    
    public String infoArea(){
        String valorArea;
        valorArea = informacoes.get(4).toString();
        return valorArea;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
