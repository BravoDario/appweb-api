package com.miempresa.appweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.miempresa.appweb.dtos.LoginDTO;
import com.miempresa.appweb.model.Usuario;
import com.miempresa.appweb.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService us;

    @PostMapping("/login")
    public ResponseEntity<String> procesarLogin(@RequestBody LoginDTO loginDTO, HttpSession session) {
        Usuario usuario = us.iniciarSesion(loginDTO.getUsername(), loginDTO.getPassword());
        if (usuario != null) {
            int idRol = usuario.getRol().getIdRol();
            session.setAttribute("rol", idRol);
            return ResponseEntity.ok(new Gson().toJson(usuario));
        } else {
            return ResponseEntity.badRequest().body("Usuario o contraseña incorrectos");
        }
    }
}
