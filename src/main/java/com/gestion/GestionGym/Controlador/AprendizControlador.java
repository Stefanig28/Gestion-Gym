package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Excepciones.*;
import com.gestion.GestionGym.Modelo.Aprendiz;
import com.gestion.GestionGym.Servicio.AprendizServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Crear un nuevo aprendiz")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aprendiz creado correctamente"),
            @ApiResponse(responseCode = "400", description = "El id del entrenador es requerido o el aprendiz ya existe"),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado")
    })
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

    @Operation(summary = "Actualizar un aprendiz existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aprendiz actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Aprendiz no encontrado"),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado")
    })
    @PutMapping("/{id}/actualizar")
    public ResponseEntity<String> actualizarAprendiz(@PathVariable Long id, @RequestBody Aprendiz aprendiz) {
        try {
            aprendizServicio.actualizarAprendiz(id, aprendiz);
            return ResponseEntity.ok("Se actualizó el aprendiz correctamente.");
        } catch (AprendizNoEncontradoExcepcion e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Obtener aprendices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de aprendices obtenida correctamente"),
            @ApiResponse(responseCode = "400", description = "No se encuentran aprendices"),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado")
    })
    @GetMapping
    public ResponseEntity<List<Aprendiz>> obtenerAprendices() {
        List<Aprendiz> aprendices = this.aprendizServicio.obtenerAprendices();
        return ResponseEntity.ok(aprendices);
    }

    @Operation(summary = "Obtener un aprendiz por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aprendiz obtenido correctamente"),
            @ApiResponse(responseCode = "400", description = "Aprendiz no encontrado"),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerAprendizPorId(@PathVariable Long id) {
        try {
            Aprendiz aprendiz = this.aprendizServicio.obtenerAprendizPorId(id);
            return ResponseEntity.ok(aprendiz);
        } catch (AprendizNoEncontradoExcepcion e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Operation(summary = "Eliminar un aprendiz por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aprendiz eliminado correctamente"),
            @ApiResponse(responseCode = "400", description = "Aprendiz no existente"),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado")
    })
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