package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.Excepciones.*;
import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Servicio.EntrenadorServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/entrenador")
public class EntrenadorControlador {

    private final EntrenadorServicio entrenadorServicio;

    @Autowired
    public EntrenadorControlador(EntrenadorServicio entrenadorServicio) {
        this.entrenadorServicio = entrenadorServicio;
    }

    @Operation(summary = "Crear un nuevo entrenador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrenador creado correctamente"),
            @ApiResponse(responseCode = "400", description = "El entrenador ya existe o la información está incompleta"),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado")
    })
    @PostMapping
    public ResponseEntity<String> crearEntrenador(@RequestBody Entrenador entrenador) {
        try {
            this.entrenadorServicio.crearEntrenador(entrenador);
            return ResponseEntity.ok("Se creó el entrenador correctamente");
        } catch (EntrenadorExistenteExcepcion | InformacionIncompletaExcepcion e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado.");
        }
    }

    @Operation(summary = "Actualizar un entrenador existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrenador actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Entrenador no encontrado"),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado")
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarEntrenador(@PathVariable("id") Long id, @RequestBody Entrenador entrenador) {
        try {
            this.entrenadorServicio.actualizarEntrenador(id, entrenador);
            return ResponseEntity.ok("Se actualizó el entrenador correctamente.");
        } catch (EntrenadorNoEncontradoExcepcion e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Obtener la lista de todos los entrenadores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de entrenadores obtenida correctamente"),
            @ApiResponse(responseCode = "400", description = "No se encuentran entrenadores"),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado")
    })
    @GetMapping
    public ResponseEntity<List<Entrenador>> obtenerEntrenadores() {
        try {
            List<Entrenador> entrenadores = this.entrenadorServicio.obtenerEntrenadores();
            return ResponseEntity.ok(entrenadores);
        } catch (EntrenadorNoExistenteExcepcion e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @Operation(summary = "Obtener un entrenador por su id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrenador obtenido correctamente"),
            @ApiResponse(responseCode = "400", description = "Entrenador no encontrado"),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> obtenerEntrenadorPorId(@PathVariable("id") Long id) {
        try {
            Entrenador entrenador = entrenadorServicio.obtenerEntrenadorPorId(id);
            return ResponseEntity.ok(entrenador);
        } catch (EntrenadorNoEncontradoExcepcion e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @Operation(summary = "Eliminar un entrenador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Entrenador eliminado correctamente"),
            @ApiResponse(responseCode = "400", description = "Entrenador no existente"),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error inesperado")
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarEntrenador(@PathVariable Long id) {
        try {
            this.entrenadorServicio.eliminarEntrenador(id);
            return ResponseEntity.ok("Se eliminó el entrenador correctamente.");
        } catch (EntrenadorNoExistenteExcepcion e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}