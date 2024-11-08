package org.tech.point.adopcionperritos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tech.point.adopcionperritos.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

