package com.gestion.GestionGym.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ActividadesServicio {
    @Autowired
    private RestTemplate restTemplate;

    public String obtenerReporteMensual(Long aprendizId, int mes, int anio) {
        try {
            String url = "mongodb://mongo:FWxbUldtSQyUfnHlWsupSMxOHSvVkZmL@roundhouse.proxy.rlwy.net:22147/actividades_db" + aprendizId + "&mes=" + mes + "&anio=" + anio;
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
            return response.getBody();
        } catch (RuntimeException e) {
            return "Error al obtener el reporte: " + e.getMessage();
        }
    }
}
