package com.miempresa.appweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.miempresa.appweb.dtos.EliminarInventarioDTO;
import com.miempresa.appweb.dtos.RegistrarInventarioDTO;
import com.miempresa.appweb.model.Inventario;
import com.miempresa.appweb.model.Producto;
import com.miempresa.appweb.repository.ProductoRepository;
import com.miempresa.appweb.service.ProductoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductoApiController {

    @Autowired
    private ProductoService ps;

    @Autowired
    private ProductoRepository pr;

    @PostMapping("/agregarProducto")
    public ResponseEntity<String> agregarProducto(@RequestBody Producto producto, HttpSession session) {
        int rol = (int) session.getAttribute("rol");
        if (rol != 1)
            return ResponseEntity.badRequest().body("No tienes permisos para realizar esta acción");

        producto.setEstatus((byte) 1);
        Producto nuevoProducto = ps.guardar(producto);
        return ResponseEntity.ok(new Gson().toJson(nuevoProducto));
    }

    @PostMapping("/desactivarProducto")
    public ResponseEntity<String> desactivarProducto(@RequestBody Producto producto, HttpSession session) {
        int rol = (int) session.getAttribute("rol");
        if (rol != 1)
            return ResponseEntity.badRequest().body("No tienes permisos para realizar esta acción");

        Producto viejoProducto = pr.findById(producto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        viejoProducto.setEstatus((byte) 0);
        Producto nuevoProducto = ps.actualizar(viejoProducto);
        return ResponseEntity.ok(new Gson().toJson(nuevoProducto));
    }

    @PostMapping("/activarProducto")
    public ResponseEntity<String> activarProducto(@RequestBody Producto producto, HttpSession session) {
        int rol = (int) session.getAttribute("rol");
        if (rol != 1)
            return ResponseEntity.badRequest().body("No tienes permisos para realizar esta acción");

        Producto viejoProducto = pr.findById(producto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        viejoProducto.setEstatus((byte) 1);
        Producto nuevoProducto = ps.actualizar(viejoProducto);
        return ResponseEntity.ok(new Gson().toJson(nuevoProducto));
    }

    @PostMapping("/registrarInventario")
    public ResponseEntity<String> registrarInventario(@RequestBody RegistrarInventarioDTO regInvDTO,
            HttpSession session) {
        int rol = (int) session.getAttribute("rol");
        System.out.println(new Gson().toJson(regInvDTO));
        if (rol != 1)
            return ResponseEntity.badRequest().body("No tienes permisos para realizar esta acción");

        Inventario inventario = ps.registrarInventario(regInvDTO.getIdProducto(), regInvDTO.getIdUsuario(),
                regInvDTO.getCantidad());

        return ResponseEntity.ok(new Gson().toJson(inventario));
    }

    @PostMapping("/eliminarInventario")
    public ResponseEntity<String> eliminarInventario(@RequestBody EliminarInventarioDTO elInvDTO, HttpSession session) {
        int rol = (int) session.getAttribute("rol");

        if (rol != 2)
            return ResponseEntity.badRequest().body("No tienes permisos para realizar esta acción");

        Inventario inventario = ps.eliminarInventario(elInvDTO.getIdInventario(), elInvDTO.getIdUsuario(),
                elInvDTO.getCantidad());

        return ResponseEntity.ok(new Gson().toJson(inventario));
    }

}
