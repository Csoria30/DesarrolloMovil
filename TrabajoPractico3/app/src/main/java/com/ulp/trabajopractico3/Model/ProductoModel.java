package com.ulp.trabajopractico3.model;

public class ProductoModel {
    private String descripcion, codigo;
    private double precio;

    public ProductoModel( String codigo, String descripcion, double precio) {
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
