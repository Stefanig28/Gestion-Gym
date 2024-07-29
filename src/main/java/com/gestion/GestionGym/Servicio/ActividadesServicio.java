package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Excepciones.AprendizObligatorioExecpcion;
import com.gestion.GestionGym.Excepciones.EntrenadorObligatorioExcepcion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class ActividadesServicio {

    private final RestTemplate restTemplate;

    @Autowired
    public ActividadesServicio(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String baseUrl = "https://reporteactividadgym-production.up.railway.app/api/actividades";

    public void enviarActividad(Long aprendizId, Long entrenadorId,
                                String nombreEntrenamiento, LocalDate fechaEntrenamiento,
                                String tipoEntrenamiento, String duracionEntrenamiento) {
        String url = baseUrl + "/crear";

        Map<String, Object> actividadData = new HashMap<>();
        actividadData.put("aprendizId", aprendizId);
        actividadData.put("entrenadorId", entrenadorId);
        actividadData.put("nombreEntrenamiento", nombreEntrenamiento);
        actividadData.put("fechaEntrenamiento", fechaEntrenamiento.toString());
        actividadData.put("tipoEntrenamiento", tipoEntrenamiento);
        actividadData.put("duracionEntrenamiento", duracionEntrenamiento);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(actividadData, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        if (response.getStatusCode() != HttpStatus.CREATED) {
            throw new RuntimeException("Error al enviar la actividad: " + response.getStatusCode());
        }
        if (actividadData.put("aprendizId", aprendizId) == null) {
            throw new AprendizObligatorioExecpcion();
        }
        if (actividadData.put("entrenadorId", entrenadorId) == null) {
            throw new EntrenadorObligatorioExcepcion();
        }
    }

    public String obtenerReporteMensual(Long aprendizId, int mes, int anio) {
        String url = baseUrl + "/reportes?aprendizId=" + aprendizId + "&mes=" + mes + "&anio=" + anio;
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Error al obtener el reporte: " + response.getStatusCode());
        }
        return response.getBody();
    }

    public String obtenerActividades() {
        try {
            ResponseEntity<String> response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class);
            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Error al obtener las actividades: " + response.getStatusCode());
            }
            return response.getBody();
        } catch (RuntimeException e) {
            return "No hay actividades registradas";
        }
    }

    public String obtenerActividadesPorAprendiz(Long aprendizId) {
        String url = baseUrl + "/aprendiz/" + aprendizId;
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Error al obtener las actividades del aprendiz: " + aprendizId + response.getStatusCode());
            }
            return response.getBody();
        } catch (RuntimeException e) {
            return "No hay actividades registrdas para el aprendiz " + aprendizId;
        }
    }

    public void actualizarActividad(String id, Map<String, Object> actividadData) {
        String url = baseUrl + "/" + id + "/actualizar";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(actividadData, headers);

        try {
            ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.PUT, request, Void.class);

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Error al actualizar la actividad: " + response.getStatusCode());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al actualizar la actividad: " + e.getMessage(), e);
        }
    }

    public void eliminarActividad(String id) {
        String url = baseUrl + "/" + id;

        try {
            ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);

            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Error al eliminar la actividad: " + response.getStatusCode());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al eliminar la actividad: " + e.getMessage(), e);
        }
    }
}
