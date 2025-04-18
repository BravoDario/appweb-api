package com.miempresa.appweb.dtos;

public class EliminarInventarioDTO {
    
    private int idInventario;
    private int idUsuario;
    private int cantidad;

    public EliminarInventarioDTO() {}

    public EliminarInventarioDTO(int idInventario, int idUsuario, int cantidad) {
        this.idInventario = idInventario;
        this.idUsuario = idUsuario;
        this.cantidad = cantidad;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
