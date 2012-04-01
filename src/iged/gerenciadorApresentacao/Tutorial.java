/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorApresentacao;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dorgi
 */
public class Tutorial {

    private String titulo;
    private String autor;
    private String ano;
    private String descricao;
    private String area;
    private LinkedList<File> slides;

    public Tutorial() {
        slides = new LinkedList<File>();
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LinkedList<File> getSlides() {
        return slides;
    }

    public void setSlides(LinkedList<File> slides) {
        this.slides = slides;
    }
    
    
}