/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorTarefa;

/**
 *
 * @author Dorgi
 */
public class MetadadoTarefa {
    
    String area;
    String autor;
    int id;
    String titulo;
    
    
    public MetadadoTarefa(){
        
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

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
