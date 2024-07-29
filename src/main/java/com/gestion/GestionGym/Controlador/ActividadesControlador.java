package com.gestion.GestionGym.Controlador;

import com.gestion.GestionGym.DTOs.ActividadDTO;
import com.gestion.GestionGym.Servicio.ActividadesServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/actividades")
public class ActividadesControlador {

    @Autowired
    private ActividadesServicio actividadesServicio;

    @Operation(summary = "Enviar una nueva actividad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Actividad enviada correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/enviar")
    public ResponseEntity<String> enviarActividad(@RequestBody ActividadDTO actividadDTO) {
        try {
            actividadesServicio.enviarActividad(actividadDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Actividad enviada correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Obtener reporte mensual de actividades por aprendiz")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reporte generado correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/reportes/aprendiz/{id}")
    public ResponseEntity<String> obtenerReporteMensual(@PathVariable Long id, @RequestParam int mes, @RequestParam int anio) {
        try {
            String reporte = actividadesServicio.obtenerReporteMensual(id, mes, anio);
            return ResponseEntity.ok(reporte);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Operation(summary = "Actualizar una actividad existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actividad actualizada correctamente"),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
            @ApiResponse(responseCode = "404", description = "Actividad no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarActividad(@PathVariable String id, @RequestBody ActividadDTO actividadDTO) {
        try {
            actividadesServicio.actualizarActividad(id, actividadDTO);
            return ResponseEntity.ok("Actividad actualizada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la actividad: " + e.getMessage());
        }
    }

    @Operation(summary = "Eliminar una actividad existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actividad eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Actividad no encontrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarActividad(@PathVariable String id) {
        try {
            actividadesServicio.eliminarActividad(id);
            return ResponseEntity.ok("Actividad eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la actividad: " + e.getMessage());
        }
    }

    @Operation(summary = "Obtener todas las actividades")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actividades obtenidas correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping
    public ResponseEntity<String> obtenerActividades() {
        try {
            String actividades = actividadesServicio.obtenerActividades();
            return ResponseEntity.ok(actividades);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Obtener actividades por aprendiz")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Actividades obtenidas correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/aprendiz/{id}")
    public ResponseEntity<String> obtenerActividadesPorAprendiz(@PathVariable Long id) {
        try {
            String actividades = actividadesServicio.obtenerActividadesPorAprendiz(id);
            return ResponseEntity.ok(actividades);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}