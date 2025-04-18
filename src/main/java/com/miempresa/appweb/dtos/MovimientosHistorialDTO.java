package com.miempresa.appweb.dtos;

import java.sql.Date;
import java.sql.Time;

public class MovimientosHistorialDTO {
    
    private Date fecha;
    private Time hora;
    private String nombre;
    private String accion;
    
    public MovimientosHistorialDTO(Date fecha, Time hora, String nombre, String accion) {
        this.fecha = fecha;
        this.hora = hora;
        this.nombre = nombre;
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
