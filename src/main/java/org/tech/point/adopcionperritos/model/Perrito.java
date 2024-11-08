package org.tech.point.adopcionperritos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Perrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerrito;

    private String nombre;
    private int edad;

    @Enumerated(EnumType.STRING)
    private Tamanio tamanio;

    private String raza;
    private String descripcion;

    @Lob
    private List<String> imagenes; // JSON String

    private String ubicacion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private LocalDateTime fechaPublicacion = LocalDateTime.now();

    public enum Tamanio {
        PEQUENIO, MEDIANO, GRANDE
    }

    public enum Estado {
        DISPONIBLE, EN_PROCESO, ADOPTADO
    }
}

