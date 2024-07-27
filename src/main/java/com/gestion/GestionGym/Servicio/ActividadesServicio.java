package com.gestion.GestionGym.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class ActividadesServicio {
    @Autowired
    private RestTemplate restTemplate;

    public String obtenerReporteMensual(Long aprendizId, int mes, int anio) {
        try {
            String url = "https://reporteactividadgym-production.up.railway.app/api/actividades/reporte?aprendizId=" + aprendizId + "&mes=" + mes + "&anio=" + anio;
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            return response.getBody();
        } catch (RuntimeException e) {
            return "Error al obtener el reporte: " + e.getMessage();
        }
    }

    public void guardarActividad(Long aprendizId, Long entrenadorId,
                                 String nombreEntrenamiento, LocalDate fechaEntrenamiento,
                                 String tipoEntrenamiento, Integer duracionEntrenamiento) {
        String url = "https://reporteactividadgym-production.up.railway.app/api/actividades/guardar";

        // Construcción del cuerpo de la solicitud como un Map
        Map<String, Object> actividadData = new HashMap<>();
        actividadData.put("aprendizId", aprendizId);
        actividadData.put("entrenadorId", entrenadorId);
        actividadData.put("nombreEntrenamiento", nombreEntrenamiento);
        actividadData.put("fechaEntrenamiento", fechaEntrenamiento.toString());
        actividadData.put("tipoEntrenamiento", tipoEntrenamiento);
        actividadData.put("duracionEntrenamiento", duracionEntrenamiento);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(actividadData, headers);

            ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, request, Void.class);

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Error al guardar la actividad: " + response.getStatusCode());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al guardar la actividad: " + e.getMessage());
        }
    }

    public String obtenerActividades() {
        try {
            String url ="https://reporteactividadgym-production.up.railway.app/api/actividades";
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            return response.getBody();
        } catch (RuntimeException e) {
            return "Error al obtener las actividades: " + e.getMessage();
        }
    }

    public String obtenerActividadesPorAprendiz(Long aprendizId) {
        try {
            String url = "https://reporteactividadgym-production.up.railway.app/api/actividades/aprendiz/" + aprendizId;
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            return response.getBody();
        } catch (RuntimeException e) {
            return "Error al obtener las actividades del aprendiz: " + e.getMessage();
        }
    }

    public void actualizarActividad(String id, Map<String, Object> actividadData) {
        String url = "https://reporteactividadgym-production.up.railway.app/api/actividades/" + id + "/actualizar";

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(actividadData, headers);

            ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.PUT, request, Void.class);

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Error al actualizar la actividad: " + response.getStatusCode());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al actualizar la actividad: " + e.getMessage());
        }
    }

    public void eliminarActividad(String id) {
        String url = "https://reporteactividadgym-production.up.railway.app/api/actividades/" + id;

        try {
            ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Error al eliminar la actividad: " + response.getStatusCode());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al eliminar la actividad: " + e.getMessage());
        }
    }
}
