package com.gestion.GestionGym.Excepciones;

public class EntrenadorObligatorioExcepcion extends RuntimeException {
    public EntrenadorObligatorioExcepcion() {
        super("La id del entrenador es obligatoria.");
    }
}
