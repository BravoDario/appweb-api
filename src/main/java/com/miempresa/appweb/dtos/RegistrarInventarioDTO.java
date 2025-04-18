package com.miempresa.appweb.dtos;

public class RegistrarInventarioDTO {

    private int idProducto;
    private int idUsuario;
    private int cantidad;

    public RegistrarInventarioDTO() {}

    public RegistrarInventarioDTO(int idProducto, int idUsuario, int cantidad) {
        this.idProducto = idProducto;
        this.idUsuario = idUsuario;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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
