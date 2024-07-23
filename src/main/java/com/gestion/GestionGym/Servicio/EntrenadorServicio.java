package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Excepciones.EntrenadorExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.EntrenadorNoEncontradoExcepcion;
import com.gestion.GestionGym.Excepciones.EntrenadorNoExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServicio {

    private final EntrenadorRepositorio entrenadorRepositorio;

    @Autowired
    public EntrenadorServicio(EntrenadorRepositorio entrenadorRepositorio) {
        this.entrenadorRepositorio = entrenadorRepositorio;
    }

    public void crearEntrenador(Entrenador entrenador) {
        if (entrenadorRepositorio.existsByCorreoElectronico(entrenador.getCorreoElectronico())) {
            throw new EntrenadorExistenteExcepcion(entrenador.getCorreoElectronico());
        }

        if (entrenador.getCertificaciones() == null ||
                entrenador.getEspecialidad() == null ||
                entrenador.getExperiencia() == null ||
                entrenador.getCorreoElectronico() == null ||
                entrenador.getContrasenia() == null ||
                entrenador.getNombreCompleto() == null) {
            throw new InformacionIncompletaExcepcion();
        }
        entrenadorRepositorio.save(entrenador);
    }

    public Entrenador actualizarEntrenador(Long id, Entrenador actualizar) {
        Entrenador entrenadorActualizar = entrenadorRepositorio.findById(id).orElseThrow(() -> new EntrenadorNoEncontradoExcepcion(id));

        entrenadorActualizar.setNombreCompleto(actualizar.getNombreCompleto());
        entrenadorActualizar.setCorreoElectronico(actualizar.getCorreoElectronico());
        entrenadorActualizar.setEspecialidad(actualizar.getEspecialidad());
        entrenadorActualizar.setExperiencia(actualizar.getExperiencia());
        entrenadorActualizar.setCertificaciones(actualizar.getCertificaciones());

        entrenadorRepositorio.save(entrenadorActualizar);
        return entrenadorActualizar;
    }

    public List<Entrenador> obtenerEntrenadores() {
        if (entrenadorRepositorio == null) {
            throw new EntrenadorNoExistenteExcepcion();
        }
        return entrenadorRepositorio.findAll();
    }

    public Entrenador obtenerEntrenadorPorId(Long id) {
        return entrenadorRepositorio.findById(id).orElseThrow(() -> new EntrenadorNoEncontradoExcepcion(id));
    }

    public void eliminarEntrenador(Long id) {
        if (entrenadorRepositorio.existsById(id)) {
            entrenadorRepositorio.deleteById(id);
        } else {
            throw new EntrenadorNoEncontradoExcepcion(id);
        }
    }
}
