package com.miempresa.appweb.dtos;

public class InventarioDetailsDTO {
    int idInventario;
    String folio;
    int cantidad;
    String nombre;

    public InventarioDetailsDTO() {
    }

    public InventarioDetailsDTO(int idInventario, String folio, int cantidad, String nombre) {
        this.idInventario = idInventario;
        this.folio = folio;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
