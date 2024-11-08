package org.tech.point.adopcionperritos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tech.point.adopcionperritos.model.Perrito;

import java.util.List;

public interface PerritoRepository extends JpaRepository<Perrito, Long> {
    List<Perrito> findByEstado(Perrito.Estado estado);
}

