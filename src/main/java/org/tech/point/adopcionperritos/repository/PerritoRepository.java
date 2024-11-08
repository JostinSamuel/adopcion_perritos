package org.tech.point.adopcionperritos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tech.point.adopcionperritos.model.Perrito;

import java.util.List;

@Repository
public interface PerritoRepository extends JpaRepository<Perrito, Long> {
    List<Perrito> findByEstado(Perrito.Estado estado);
}

