package com.miempresa.appweb.service;

import com.miempresa.appweb.dtos.InventarioDetailsDTO;
import com.miempresa.appweb.dtos.InventarioGroupDTO;
import com.miempresa.appweb.dtos.MovimientosHistorialDTO;
import com.miempresa.appweb.model.Inventario;
import com.miempresa.appweb.model.Movimiento;
import com.miempresa.appweb.model.Producto;
import com.miempresa.appweb.model.Usuario;
import com.miempresa.appweb.repository.InventarioRepository;
import com.miempresa.appweb.repository.MovimientoRepository;
import com.miempresa.appweb.repository.ProductoRepository;
import com.miempresa.appweb.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        Producto productoOld = productoRepository.findById(producto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productoOld.setNombre(producto.getNombre());
        productoOld.setPrecio(producto.getPrecio());
        productoOld.setEstatus(producto.getEstatus());
        return productoRepository.save(productoOld);
    }

    @Override
    public List<InventarioGroupDTO> obtenerGrupoInventario() {
        return productoRepository.getGrupoInventario();
    }

    @Override
    public List<InventarioDetailsDTO> obtenerInventario(int idProducto) {
        return productoRepository.getInventarioDetails(idProducto);
    }

    @Override
    public Inventario registrarInventario(int idProducto, int idUsuario, int cantidad) {
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Inventario inventario = new Inventario();
        String folio = producto.getNombre().substring(0, 3) + "-00"
                + String.format("%03d", inventarioRepository.count() + 1);
        inventario.setFolio(folio);
        inventario.setProducto(producto);
        inventario.setCantidad(cantidad);

        inventarioRepository.save(inventario);

        registrarMovimiento("ENTRADA", usuario.getIdUsuario(), inventario.getIdInventario());

        return inventario;
    }

    @Override
    public Inventario eliminarInventario(int idInventario, int idUsuario, int cantidad) {
        Inventario inventario = inventarioRepository.findById(idInventario)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (inventario.getCantidad() < cantidad) {
            throw new RuntimeException("Cantidad insuficiente");
        }

        inventario.setCantidad(inventario.getCantidad() - cantidad);

        inventarioRepository.save(inventario);

        registrarMovimiento("SALIDA", usuario.getIdUsuario(), inventario.getIdInventario());

        return inventario;
    }

    @Override 
    public List<MovimientosHistorialDTO> obtenerMovimientosEntradas() {
        return movimientoRepository.getMovimientosEntradas();
    }

    @Override 
    public List<MovimientosHistorialDTO> obtenerMovimientosSalidas() {
        return movimientoRepository.getMovimientosSalidas();
    }

    @Override
    public void registrarMovimiento(String accion, int idUsuario, int idInventario) {
        Inventario inventario = inventarioRepository.findById(idInventario)
                .orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Movimiento movimiento = new Movimiento();

        movimiento.setFecha(LocalDateTime.now());
        movimiento.setAccion(accion);
        movimiento.setUsuario(usuario);
        movimiento.setInventario(inventario);

        movimientoRepository.save(movimiento);
    }
}
