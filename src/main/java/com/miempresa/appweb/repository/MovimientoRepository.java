package com.miempresa.appweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miempresa.appweb.dtos.MovimientosHistorialDTO;
import com.miempresa.appweb.model.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    @Query(value="select CAST(m.fecha AS DATE) as fecha, CAST(m.fecha AS TIME) as hora, u.nombre, m.accion from movimiento m join usuario u on u.id_usuario = m.id_usuario where m.accion = 'ENTRADA'", nativeQuery = true)
    List<MovimientosHistorialDTO> getMovimientosEntradas();
    
    @Query(value="select CAST(m.fecha AS DATE) as fecha, CAST(m.fecha AS TIME) as hora, u.nombre, m.accion from movimiento m join usuario u on u.id_usuario = m.id_usuario where m.accion = 'SALIDA'", nativeQuery = true)
    List<MovimientosHistorialDTO> getMovimientosSalidas();
}