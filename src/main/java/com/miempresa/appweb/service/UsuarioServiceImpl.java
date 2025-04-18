package com.miempresa.appweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.appweb.model.Usuario;
import com.miempresa.appweb.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario iniciarSesion (String correo, String password) {
        Usuario usuarioOpt = usuarioRepository.login(correo, password);

        if (usuarioOpt == null) {
            System.out.println("Usuario no encontrado");
            return null;
        }

        return usuarioOpt;
    }
}