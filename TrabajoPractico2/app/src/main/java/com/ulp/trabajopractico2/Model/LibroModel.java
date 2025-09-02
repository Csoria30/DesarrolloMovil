package com.ulp.trabajopractico2.Model;

import java.io.Serializable;

public class LibroModel implements Serializable {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private int anio;
    private int paginas;
    private String descripcion;
    private int imagen;

    public LibroModel(int id, String titulo, String autor, String genero, int anio, int paginas, String descripcion, int imagen) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.paginas = paginas;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    // Getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAnio() { return anio; }
    public int getPaginas() {  return paginas; }
    public String getDescripcion() { return descripcion; }
    public int getImagen() { return imagen; }

    //Setters

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setPaginas(int paginas) { this.paginas = paginas; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setImagen(int imagen) { this.imagen = imagen; }
}
