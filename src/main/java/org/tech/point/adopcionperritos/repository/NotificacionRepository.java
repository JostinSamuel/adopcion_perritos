package org.tech.point.adopcionperritos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tech.point.adopcionperritos.model.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
}
