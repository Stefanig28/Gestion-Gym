package com.gestion.GestionGym.DTOs;

public class EntrenadorDTO {
    private Long id;
    private String nombreCompleto;
    private String correoElectronico;
    private String especialidad;
    private String experiencia;

    public EntrenadorDTO() {
    }

    public EntrenadorDTO(Long id, String nombreCompleto,String correoElectronico, String especialidad, String experiencia) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
}
