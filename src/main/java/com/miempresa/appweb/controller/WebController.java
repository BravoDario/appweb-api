package com.miempresa.appweb.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miempresa.appweb.dtos.InventarioDetailsDTO;
import com.miempresa.appweb.dtos.InventarioGroupDTO;
import com.miempresa.appweb.dtos.MovimientosHistorialDTO;
import com.miempresa.appweb.service.ProductoService;

import jakarta.servlet.http.HttpSession;

@Controller
public class WebController {

    @Autowired
    private ProductoService ps;

    @GetMapping("/")
    public String mostrarDashboard(Model model, HttpSession session) {
        Object rolObj = session.getAttribute("rol");

        if (rolObj == null) {
            return "redirect:/login";
        }

        int rol = Integer.parseInt(rolObj.toString());
        List<InventarioGroupDTO> productosGrupo = ps.obtenerGrupoInventario();

        model.addAttribute("isAdmin", rol == 1);
        model.addAttribute("isAlmac", rol == 2);
        model.addAttribute("productosGrupo", rol == 1 ? productosGrupo
                : productosGrupo.stream()
                        .filter(item -> item.getEstatus() == 1)
                        .collect(Collectors.toList()));

        return "index";
    }
    
    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @GetMapping("/productoDetalle")
    public String mostrarProducto(@RequestParam("idProducto") int idProducto, @RequestParam("np") String nombreProducto,
            Model model, HttpSession session) {
        Object rolObj = session.getAttribute("rol");

        if (rolObj == null) {
            return "redirect:/login";
        }

        int rol = Integer.parseInt(rolObj.toString());
        List<InventarioDetailsDTO> productos = ps.obtenerInventario(idProducto);
        model.addAttribute("isAdmin", rol == 1);
        model.addAttribute("isAlmac", rol == 2);
        model.addAttribute("idProducto", idProducto);
        model.addAttribute("productos", productos);
        model.addAttribute("nombreProducto", nombreProducto);

        return "productoDetalle";
    }

    @GetMapping("/historico")
    public String mostrarHistorico(Model model, HttpSession session) {
        Object rolObj = session.getAttribute("rol");

        if (rolObj == null) {
            return "redirect:/";
        }

        int rol = Integer.parseInt(rolObj.toString());
        
        List<MovimientosHistorialDTO> historicoEntradas = ps.obtenerMovimientosEntradas();

        List<MovimientosHistorialDTO> historicoSalidas = ps.obtenerMovimientosSalidas();

        for (MovimientosHistorialDTO historicoSalida : historicoSalidas) {
            historicoSalida.setAccion("Salida");
        }

        model.addAttribute("isAdmin", rol == 1);
        model.addAttribute("isAlmac", rol == 2);
        model.addAttribute("historicoEntradas", historicoEntradas);
        model.addAttribute("historicoSalidas", historicoSalidas);

        return "historico";
    }
}
