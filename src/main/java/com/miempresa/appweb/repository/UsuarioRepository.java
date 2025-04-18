package com.miempresa.appweb.repository;

import com.miempresa.appweb.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasena = :password")
    Usuario login(@Param("correo") String correo, @Param("password") String password);
}
