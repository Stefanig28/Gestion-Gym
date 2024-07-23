package com.gestion.GestionGym.Excepciones;

public class AprendizExistenteExcepcion extends RuntimeException {

    public AprendizExistenteExcepcion(String correoElectronico) {
        super("El aprendiz con correo electrónico " + correoElectronico + " ya se encuentra registrado.");
    }
}
