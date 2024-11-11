package org.tech.point.adopcionperritos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tech.point.adopcionperritos.model.Usuario;
import org.tech.point.adopcionperritos.repository.UsuarioRepository;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PutMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findByCorreo(usuario.getCorreo()).orElse(null);

        if (existingUsuario != null) {
            existingUsuario.setRol(usuario.getRol());
            existingUsuario.setUpdatedAt(LocalDateTime.now());
            existingUsuario.setNombre(usuario.getNombre());
            usuarioRepository.save(existingUsuario);
            return ResponseEntity.ok(existingUsuario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
