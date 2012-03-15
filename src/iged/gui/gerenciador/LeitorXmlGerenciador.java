/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gui.gerenciador;

import iged.gui.TelaCadastroDeTarefaInterno;
import iged.gerenciadorTarefa.MetadadoTarefa;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 *
 * @author Dorgi
 */
public class LeitorXmlGerenciador {

    private static int cont;
    private static String titulo;
    private static String area;
    private static String id;
    private static String autor;
    private static String descricao;
    private static String codInicializacao;
    private static String codSolucao;
    static MetadadoTarefa tar = new MetadadoTarefa();
    static CadastroTarefa tarefa = new CadastroTarefa();
    
    static LinkedList<String> informacoes;
    static LinkedList<String> dado;
    File tarefas = new File("C:\\Tarefas\\tarefas.xml");
    
    public LeitorXmlGerenciador() {
        informacoes = new LinkedList<String>();
        dado = new LinkedList<String>();
    }

    public LinkedList lerXmlTarefa() {
        XStream x = new XStream(new DomDriver());
        TelaCadastroDeTarefa tc = new TelaCadastroDeTarefa();

        try {
            // carrega o arquivo XML
//            File f = new File("C:\\Tarefas\\tarefa" + tc.getIdStr() + ".xml");
            File f = new File("C:\\Tarefas\\tarefa10.xml");
            FileInputStream input = new FileInputStream(f);
            // informa o nome do nó raiz do xml
            x.alias("Tarefa", CadastroTarefa.class);
            // cria um objeto da classe, contendo os dados lidos no xml
            tarefa = (CadastroTarefa) x.fromXML(input);

            // imprime os dados
            titulo = tarefa.getTitulo();
            id = tarefa.getId();
            autor = tarefa.getAutor();
            descricao = tarefa.getDescricao();
            area = tarefa.getArea();
            codInicializacao = tarefa.getCodInicializacao();
            codSolucao = tarefa.getCodSolucao();

            System.out.println("Título: " + titulo);
            System.out.println("Id: " + id);
            System.out.println("Autor: " + autor);
            System.out.println("Descrição: " + descricao);
            System.out.println("Área: " + area);
            System.out.println("Código de Inicialização: " + codInicializacao);
            System.out.println("Código de Solução: " + codSolucao);

            dado.add(titulo);
            dado.add(id);
            dado.add(autor);
            dado.add(descricao);
            dado.add(area);
            dado.add(codInicializacao);
            dado.add(codSolucao);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        informacoes = dado;
        return informacoes;
    }

    
    public static LinkedList lerXmlGerTarefas(File tarefas) {
        XStream x = new XStream(new DomDriver());
        
        try {
            // carrega o arquivo XML
            FileInputStream input = new FileInputStream(tarefas);
            // informa o nome do nó raiz do xml
            x.alias("portifolio", MetadadoTarefa.class);
            // cria um objeto da classe, contendo os dados lidos no xml
            tar = (MetadadoTarefa) x.fromXML(input);
            // imprime os dados
            cont = tar.getCont();
            titulo = tar.getTitulo();
            area = tar.getArea();
            id = tar.getId();
            autor = tar.getAutor();

            System.out.println("Contador: " + cont);
            System.out.println("Título: " + titulo);
            System.out.println("Área: " + area);
            System.out.println("Id: " + id);
            System.out.println("Autor: " + autor);

            //dado.add(contador);
            dado.add(titulo);
            dado.add(area);
            dado.add(id);
            dado.add(autor);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        informacoes = dado;
        return informacoes;
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
    

    public LinkedList<String> getInformacoes() {
        return informacoes;
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

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodInicializacao() {
        return codInicializacao;
    }

    public void setCodInicializacao(String codInicializacao) {
        this.codInicializacao = codInicializacao;
    }

    public String getCodSolucao() {
        return codSolucao;
    }

    public void setCodSolucao(String codSolucao) {
        this.codSolucao = codSolucao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
