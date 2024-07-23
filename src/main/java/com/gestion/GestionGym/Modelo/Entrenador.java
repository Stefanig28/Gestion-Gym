package com.gestion.GestionGym.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "entrenador")
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entrenador_id")
    private Long id;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "contraseña")
    private String contrasenia;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "experiencia")
    private String experiencia;

    @ElementCollection
    @CollectionTable(name = "entrenador_certificaciones", joinColumns = @JoinColumn(name = "entrenador_id"))
    @Column(name = "certificaciones")
    private Set<String> certificaciones;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Aprendiz> aprendices;

    public Entrenador() {
    }

    public Entrenador(Long id, String correoElectronico) {
        this.id = id;
        this.correoElectronico = correoElectronico;
    }

    public Entrenador(Long id, String nombreCompleto, String contrasenia, String correoElectronico, String especialidad, String experiencia, Set<String> certificaciones, List<Aprendiz> aprendices) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.contrasenia = contrasenia;
        this.correoElectronico = correoElectronico;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
        this.certificaciones = certificaciones;
        this.aprendices = aprendices;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
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

    public Set<String> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(Set<String> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public List<Aprendiz> getAprendices() {
        return aprendices;
    }

    public void setAprendices(List<Aprendiz> aprendices) {
        this.aprendices = aprendices;
    }
}