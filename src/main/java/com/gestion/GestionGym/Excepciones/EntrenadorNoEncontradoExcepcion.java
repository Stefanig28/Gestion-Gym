package com.gestion.GestionGym.Excepciones;

public class EntrenadorNoEncontradoExcepcion extends RuntimeException{
    public EntrenadorNoEncontradoExcepcion(Long entrenadorId) {
        super("El entrenador con id " + entrenadorId + " no se encuentra registrado.");
    }
}
