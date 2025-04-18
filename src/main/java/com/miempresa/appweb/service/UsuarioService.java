package com.miempresa.appweb.service;

import com.miempresa.appweb.model.Usuario;

public interface UsuarioService {
    Usuario iniciarSesion(String correo, String contrasena);
}