package com.gestion.GestionGym.Excepciones;

public class AprendizNoExistenteExcepcion extends RuntimeException{
    public AprendizNoExistenteExcepcion() {
        super("No se han creado aprendices.");
    }
}