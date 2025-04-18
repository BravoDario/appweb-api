package com.miempresa.appweb.service;

import com.miempresa.appweb.dtos.InventarioDetailsDTO;
import com.miempresa.appweb.dtos.InventarioGroupDTO;
import com.miempresa.appweb.dtos.MovimientosHistorialDTO;
import com.miempresa.appweb.model.Inventario;
import com.miempresa.appweb.model.Producto;
import java.util.List;

public interface ProductoService {
    List<Producto> obtenerTodos();

    Producto guardar(Producto producto);

    Producto actualizar(Producto producto);

    List<InventarioGroupDTO> obtenerGrupoInventario();

    List<InventarioDetailsDTO> obtenerInventario(int idProducto);

    Inventario registrarInventario(int idProducto, int idUsuario, int cantidad);

    Inventario eliminarInventario(int idInventario, int idUsuario, int cantidad);

    List<MovimientosHistorialDTO> obtenerMovimientosEntradas();
    
    List<MovimientosHistorialDTO> obtenerMovimientosSalidas();

    void registrarMovimiento(String accion, int idUsuario, int idInventario);
}