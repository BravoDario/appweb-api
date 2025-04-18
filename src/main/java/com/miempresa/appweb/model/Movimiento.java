package com.miempresa.appweb.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private int idMovimiento;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(length = 20, nullable = false)
    private String accion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_inventario", nullable = false)
    private Inventario inventario;

    public Movimiento() {
    }

    public Movimiento(int idMovimiento, LocalDateTime fecha, String accion, Usuario usuario, Inventario inventario) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.accion = accion;
        this.usuario = usuario;
        this.inventario = inventario;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}
