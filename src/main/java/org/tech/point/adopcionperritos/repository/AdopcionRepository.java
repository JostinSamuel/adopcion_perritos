package org.tech.point.adopcionperritos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tech.point.adopcionperritos.model.Adopcion;
import org.tech.point.adopcionperritos.model.Usuario;

import java.util.List;

@Repository
public interface AdopcionRepository extends JpaRepository<Adopcion, Long> {
    List<Adopcion> findByUsuario(Usuario usuario);
}

