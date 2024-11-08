package org.tech.point.adopcionperritos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tech.point.adopcionperritos.model.Perrito;
import org.tech.point.adopcionperritos.repository.PerritoRepository;

import java.util.List;

@RestController
@RequestMapping("/perritos")
public class PerritoController {
    @Autowired
    private PerritoRepository perritoRepository;

    @GetMapping
    public List<Perrito> listarPerritos() {
        return perritoRepository.findAll();
    }

    @PostMapping
    public Perrito crearPerrito(@RequestBody Perrito perrito) {
        return perritoRepository.save(perrito);
    }

    @PutMapping("/{id}")
    public Perrito actualizarPerrito(@PathVariable Long id, @RequestBody Perrito perritoDetalles) {
        Perrito perrito = perritoRepository.findById(id).orElseThrow();
        perrito.setNombre(perritoDetalles.getNombre());
        perrito.setEdad(perritoDetalles.getEdad());
        perrito.setRaza(perritoDetalles.getRaza());
        perrito.setDescripcion(perritoDetalles.getDescripcion());
        perrito.setEstado(perritoDetalles.getEstado());
        perrito.setTamanio(perritoDetalles.getTamanio());
        perrito.setUbicacion(perritoDetalles.getUbicacion());
        perrito.setImagenes(perritoDetalles.getImagenes());
        return perritoRepository.save(perrito);
    }

    @DeleteMapping("/{id}")
    public void eliminarPerrito(@PathVariable Long id) {
        perritoRepository.deleteById(id);
    }
}

