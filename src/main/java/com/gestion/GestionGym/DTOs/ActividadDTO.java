package com.gestion.GestionGym.DTOs;

import java.time.LocalDate;

public class ActividadDTO {
    private Long aprendizId;
    private Long entrenadorId;
    private String nombreEntrenamiento;
    private LocalDate fechaEntrenamiento;
    private String tipoEntrenamiento;
    private String duracionEntrenamiento;

    public ActividadDTO(Long aprendizId, Long entrenadorId, String nombreEntrenamiento, LocalDate fechaEntrenamiento, String tipoEntrenamiento, String duracionEntrenamiento) {
        this.aprendizId = aprendizId;
        this.entrenadorId = entrenadorId;
        this.nombreEntrenamiento = nombreEntrenamiento;
        this.fechaEntrenamiento = fechaEntrenamiento;
        this.tipoEntrenamiento = tipoEntrenamiento;
        this.duracionEntrenamiento = duracionEntrenamiento;
    }

    public Long getAprendizId() {
        return aprendizId;
    }

    public void setAprendizId(Long aprendizId) {
        this.aprendizId = aprendizId;
    }

    public Long getEntrenadorId() {
        return entrenadorId;
    }

    public void setEntrenadorId(Long entrenadorId) {
        this.entrenadorId = entrenadorId;
    }

    public String getNombreEntrenamiento() {
        return nombreEntrenamiento;
    }

    public void setNombreEntrenamiento(String nombreEntrenamiento) {
        this.nombreEntrenamiento = nombreEntrenamiento;
    }

    public LocalDate getFechaEntrenamiento() {
        return fechaEntrenamiento;
    }

    public void setFechaEntrenamiento(LocalDate fechaEntrenamiento) {
        this.fechaEntrenamiento = fechaEntrenamiento;
    }

    public String getTipoEntrenamiento() {
        return tipoEntrenamiento;
    }

    public void setTipoEntrenamiento(String tipoEntrenamiento) {
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    public String getDuracionEntrenamiento() {
        return duracionEntrenamiento;
    }

    public void setDuracionEntrenamiento(String duracionEntrenamiento) {
        this.duracionEntrenamiento = duracionEntrenamiento;
    }
}
