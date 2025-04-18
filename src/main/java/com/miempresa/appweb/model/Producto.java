package com.miempresa.appweb.model;

import jakarta.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int idProducto;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Byte estatus;

    public Producto() {}

    public Producto(int idProducto, String nombre, Double precio, Byte estatus) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.estatus = estatus;
    }

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Byte getEstatus() { return estatus; }
    public void setEstatus(Byte estatus) { this.estatus = estatus; }
}
