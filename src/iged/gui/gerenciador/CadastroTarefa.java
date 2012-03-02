/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gui.gerenciador;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Dorgi
 */
public class CadastroTarefa {
        
    private String titulo;
    private String id;
    private static int contador=0;
    private String autor;
    private String descricao;
    private String area;
    protected static ArrayList<File> itens = new ArrayList<File>();
    static String imagemArray;
    static ArrayList<String> selecionado = new ArrayList<String>();
    static File novoRaiz;
    static String nome;

    
    
    public CadastroTarefa(){
        
    }
   

    public static void listarTodasTarefas() {
        File raiz = new File("C:\\Tarefas");
        lerDiretorio(raiz);
    }

    public static int lerDiretorio(File raiz) {

        String item = raiz.getName();
        System.out.println(item);

        for (File f : raiz.listFiles()) {

                    if (f.isFile()) {
                        itens.add(f);
                        if (f.getName().contains("tarefa")){
                            contador++;
                        }
                    }
        }
        
        System.out.println(contador);
        return contador; 
    }
       
    
    public static int idIncrementado(){
        File raiz = new File("C:\\Tarefas");
        int idIncrementado = CadastroTarefa.lerDiretorio(raiz)+1;
        System.out.println("Contador do metodo id"+idIncrementado);
        return idIncrementado;
    }
 
    public int getIdIncrementado(){
        return idIncrementado();
    }
    
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public static int getContador() {
        return contador;
    }

    public void setContador(int cont) {
        this.contador = cont;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    public ArrayList<File> getItens() {
        return itens;
    }

}
