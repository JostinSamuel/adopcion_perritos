package org.tech.point.adopcionperritos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.tech.point.adopcionperritos.model.Usuario;
import org.tech.point.adopcionperritos.repository.UsuarioRepository;
import org.tech.point.adopcionperritos.service.UsuarioService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/me")
    public ResponseEntity<Usuario> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Usuario currentUser = (Usuario) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> allUsers() {
        List <Usuario> users = usuarioService.allUsers();

        return ResponseEntity.ok(users);
    }

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

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

}

