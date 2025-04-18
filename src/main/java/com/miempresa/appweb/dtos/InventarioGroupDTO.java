package com.miempresa.appweb.dtos;

public class InventarioGroupDTO {
    int idProducto;
    String nombre;
    int cantidad;
    byte estatus;

    public InventarioGroupDTO(int idProducto, String nombre, int cantidad, byte estatus) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.estatus = estatus;
    }

    public InventarioGroupDTO() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public byte getEstatus() {
        return estatus;
    }

    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }
}
