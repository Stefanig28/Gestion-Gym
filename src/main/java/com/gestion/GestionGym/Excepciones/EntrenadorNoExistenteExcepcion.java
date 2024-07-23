package com.gestion.GestionGym.Excepciones;

public class EntrenadorNoExistenteExcepcion extends RuntimeException{

    public EntrenadorNoExistenteExcepcion() {
        super("No se han creado entrenadores.");
    }
}
