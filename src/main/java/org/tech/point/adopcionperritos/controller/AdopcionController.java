package org.tech.point.adopcionperritos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tech.point.adopcionperritos.model.Adopcion;
import org.tech.point.adopcionperritos.model.Perrito;
import org.tech.point.adopcionperritos.model.Usuario;
import org.tech.point.adopcionperritos.repository.AdopcionRepository;
import org.tech.point.adopcionperritos.repository.PerritoRepository;
import org.tech.point.adopcionperritos.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/adopciones")
public class AdopcionController {

    @Autowired
    private AdopcionRepository adopcionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerritoRepository perritoRepository;

    @PostMapping("/registrar")
    public Adopcion registrarAdopcion(@RequestParam Long usuarioId, @RequestParam Long perritoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Perrito perrito = perritoRepository.findById(perritoId)
                .orElseThrow(() -> new RuntimeException("Perrito no encontrado"));

        Adopcion adopcion = new Adopcion();
        adopcion.setUsuario(usuario);
        adopcion.setPerrito(perrito);
        adopcion.setFechaAdopcion(LocalDate.now());
        adopcion.setEstado(Adopcion.Estado.PENDIENTE);

        return adopcionRepository.save(adopcion);
    }


    @GetMapping("/usuario/{usuarioId}")
    public List<Adopcion> listarAdopcionesPorUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return adopcionRepository.findByUsuario(usuario);
    }


    @PutMapping("/{id}/estado")
    public Adopcion actualizarEstadoAdopcion(@PathVariable Long id, @RequestParam Adopcion.Estado nuevoEstado) {
        Adopcion adopcion = adopcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adopción no encontrada"));

        adopcion.setEstado(nuevoEstado);
        return adopcionRepository.save(adopcion);
    }


    @GetMapping
    public List<Adopcion> listarTodasAdopciones() {
        return adopcionRepository.findAll();
    }
}
