package com.gestion.GestionGym.Excepciones;

public class AprendizObligatorioExecpcion extends RuntimeException {
    public AprendizObligatorioExecpcion() {
        super("La id del aprendiz es obligatoria.");
    }
}
