package com.gestion.GestionGym.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "aprendiz")
public class Aprendiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aprendiz_id")
    private Long id;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "contraseña")
    private String contrasenia;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento; // Formato YYYY-MM-DD

    @Column(name = "genero")
    private String genero;

    @Column(name = "objetivo_entrenamiento")
    private String objetivoEntrenamiento;

    @Column(name = "nivel_condicion")
    private String nivelCondicion;

    @ManyToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    public Aprendiz() {
    }

    public Aprendiz(Long id, String nombreCompleto, String correoElectronico, String contrasenia, LocalDate fechaNacimiento, String genero, String objetivoEntrenamiento, String nivelCondicion, Entrenador entrenador) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getObjetivoEntrenamiento() {
        return objetivoEntrenamiento;
    }

    public void setObjetivoEntrenamiento(String objetivoEntrenamiento) {
        this.objetivoEntrenamiento = objetivoEntrenamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNivelCondicion() {
        return nivelCondicion;
    }

    public void setNivelCondicion(String nivelCondicion) {
        this.nivelCondicion = nivelCondicion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
}