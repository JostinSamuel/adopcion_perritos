package org.tech.point.adopcionperritos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNotificacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String mensaje;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private LocalDateTime fecha = LocalDateTime.now();

    public enum Tipo {
        MENSAJE_NUEVO, ACTUALIZACION_ADOPCION
    }

}
