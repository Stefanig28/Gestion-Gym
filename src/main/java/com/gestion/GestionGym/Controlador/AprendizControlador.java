package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Excepciones.*;
import com.gestion.GestionGym.Modelo.Aprendiz;
import com.gestion.GestionGym.Servicio.AprendizServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/aprendiz")
public class AprendizControlador {

    private final AprendizServicio aprendizServicio;

    @Autowired
    public AprendizControlador(AprendizServicio aprendizServicio) {
        this.aprendizServicio = aprendizServicio;
    }

    @PostMapping
    public ResponseEntity<String> crearAprendiz(@RequestBody Aprendiz aprendiz) {
        try {
            if (aprendiz.getEntrenador() == null || aprendiz.getEntrenador().getId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del entrenador es requerido.");
            }

            Long entrenadorId = aprendiz.getEntrenador().getId();
            this.aprendizServicio.crearAprendiz(aprendiz, entrenadorId);
            return ResponseEntity.ok("Se creó el aprendiz correctamente.");
        } catch (EntrenadorNoEncontradoExcepcion | AprendizExistenteExcepcion | InformacionIncompletaExcepcion e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<String> actualizarAprendiz(@PathVariable Long id, @RequestBody Aprendiz aprendiz) {
        try {
            aprendizServicio.actualizarAprendiz(id, aprendiz);
            return ResponseEntity.ok("Se actualizó el aprendiz correctamente.");
        } catch (AprendizNoEncontradoExcepcion e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Aprendiz>> obtenerAprendices() {
        List<Aprendiz> aprendices = this.aprendizServicio.obtenerAprendices();
        return ResponseEntity.ok(aprendices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAprendizPorId(@PathVariable Long id) {
        try {
            Aprendiz aprendiz = this.aprendizServicio.obtenerAprendizPorId(id);
            return ResponseEntity.ok(aprendiz);
        } catch (AprendizNoEncontradoExcepcion e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAprendiz(@PathVariable Long id) {
        try {
            this.aprendizServicio.eliminarAprendiz(id);
            return ResponseEntity.ok("Se eliminó el aprendiz correctamente.");
        } catch (AprendizNoExistenteExcepcion e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}