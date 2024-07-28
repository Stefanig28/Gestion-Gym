package com.gestion.GestionGym.DTOs;

public class AprendizDTO {
    private Long id;
    private String nombreCompleto;
    private String correoElectronico;
    private String objetivoEntrenamiento;
    private String nivelCondicion;
    private EntrenadorDTO entrenador;

    public AprendizDTO(Long id, String nombreCompleto, String correoElectronico, String objetivoEntrenamiento, String nivelCondicion, EntrenadorDTO entrenador) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.objetivoEntrenamiento = objetivoEntrenamiento;
        this.nivelCondicion = nivelCondicion;
        this.entrenador = entrenador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getObjetivoEntrenamiento() {
        return objetivoEntrenamiento;
    }

    public void setObjetivoEntrenamiento(String objetivoEntrenamiento) {
        this.objetivoEntrenamiento = objetivoEntrenamiento;
    }

    public String getNivelCondicion() {
        return nivelCondicion;
    }

    public void setNivelCondicion(String nivelCondicion) {
        this.nivelCondicion = nivelCondicion;
    }

    public EntrenadorDTO getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(EntrenadorDTO entrenador) {
        this.entrenador = entrenador;
    }
}
