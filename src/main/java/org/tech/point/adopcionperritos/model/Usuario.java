package org.tech.point.adopcionperritos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    private String correo;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public enum Rol {
        ADMINISTRADOR, USUARIO
    }
}

