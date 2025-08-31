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
    private String portadaUrl;

    public LibroModel(int id, String titulo, String autor, String genero, int anio, int paginas, String descripcion, String portadaUrl) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio = anio;
        this.paginas = paginas;
        this.descripcion = descripcion;
        this.portadaUrl = portadaUrl;
    }

    //GETTERS
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getGenero() { return genero; }
    public int getAnio() { return anio; }
    public int getPaginas() { return paginas; }
    public String getDescripcion() { return descripcion; }
    public String getPortadaUrl() { return portadaUrl; }

    //SETTERS
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setPaginas(int paginas) { this.paginas = paginas; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPortadaUrl(String portadaUrl) { this.portadaUrl = portadaUrl; }
}
