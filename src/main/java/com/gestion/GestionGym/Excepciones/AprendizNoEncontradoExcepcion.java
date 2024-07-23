package com.gestion.GestionGym.Excepciones;

public class AprendizNoEncontradoExcepcion extends RuntimeException {
    public AprendizNoEncontradoExcepcion(Long id) {
        super("El aprendiz con id " + id + " no se encuentra registrado.");
    }
}
