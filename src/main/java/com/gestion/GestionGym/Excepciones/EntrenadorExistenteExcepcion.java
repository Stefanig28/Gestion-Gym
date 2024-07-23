package com.gestion.GestionGym.Excepciones;

public class EntrenadorExistenteExcepcion extends RuntimeException {
    public EntrenadorExistenteExcepcion(String correoElectronico) {
        super("El entrenador con el correo electrónico " + correoElectronico + " ya se encuentra registrado.");
    }
}
