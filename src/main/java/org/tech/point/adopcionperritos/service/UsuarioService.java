package org.tech.point.adopcionperritos.service;


import org.springframework.stereotype.Service;
import org.tech.point.adopcionperritos.model.Usuario;
import org.tech.point.adopcionperritos.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> allUsers() {
        List<Usuario> users = new ArrayList<>();

        usuarioRepository.findAll().forEach(users::add);

        return users;
    }
}
