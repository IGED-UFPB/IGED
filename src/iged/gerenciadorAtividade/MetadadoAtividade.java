/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iged.gerenciadorAtividade;

/**
 *
 * @author Dorgi
 */
public class MetadadoAtividade {
    
    String area;
    String autor;
    int id;
    String titulo;
    
    int type;
    
    public MetadadoAtividade(){
        
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

     public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
