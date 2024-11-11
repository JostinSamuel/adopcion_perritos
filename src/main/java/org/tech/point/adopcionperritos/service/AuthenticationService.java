package org.tech.point.adopcionperritos.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tech.point.adopcionperritos.model.Usuario;
import org.tech.point.adopcionperritos.model.dto.LoginUserDto;
import org.tech.point.adopcionperritos.model.dto.RegisterUserDto;
import org.tech.point.adopcionperritos.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UsuarioRepository usuarioRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario signup(RegisterUserDto input) {
        var user = new Usuario();

        user.setNombre(input.getFullName());
        user.setCorreo(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRol(Usuario.Rol.USUARIO);
        user.setCreatedAt(input.getCreatedAt());

        return usuarioRepository.save(user);
    }

    public Usuario authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return usuarioRepository.findByCorreo(input.getEmail()).orElseThrow();
    }

    public List<Usuario> allUsers() {
        List<Usuario> users = new ArrayList<>();

        usuarioRepository.findAll().forEach(users::add);

        return users;
    }
}