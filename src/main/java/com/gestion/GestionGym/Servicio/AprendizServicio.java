package com.gestion.GestionGym.Servicio;

import com.gestion.GestionGym.Excepciones.*;
import com.gestion.GestionGym.Modelo.Aprendiz;
import com.gestion.GestionGym.Repositorio.AprendizRepositorio;
import com.gestion.GestionGym.Repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AprendizServicio {

    private final AprendizRepositorio aprendizRepositorio;
    private final EntrenadorRepositorio entrenadorRepositorio;

    @Autowired
    public AprendizServicio(AprendizRepositorio aprendizRepositorio, EntrenadorRepositorio entrenadorRepositorio) {
        this.aprendizRepositorio = aprendizRepositorio;
        this.entrenadorRepositorio = entrenadorRepositorio;
    }

    public void crearAprendiz(Aprendiz aprendiz, Long entrenadorId) {
        if (!entrenadorRepositorio.existsById(entrenadorId)) {
            throw new EntrenadorNoEncontradoExcepcion(entrenadorId);
        }

        if (aprendizRepositorio.existsByCorreoElectronico(aprendiz.getCorreoElectronico())) {
            throw new AprendizExistenteExcepcion(aprendiz.getCorreoElectronico());
        }
        if ((aprendiz.getNombreCompleto() == null) ||
                (aprendiz.getContrasenia() == null) ||
                (aprendiz.getCorreoElectronico() == null) ||
                (aprendiz.getFechaNacimiento() == null) ||
                (aprendiz.getGenero() == null) ||
                (aprendiz.getObjetivoEntrenamiento() == null) ||
                (aprendiz.getNivelCondicion() == null)) {
            throw new InformacionIncompletaExcepcion();
        }

        aprendiz.setEntrenador(entrenadorRepositorio.findById(entrenadorId).orElseThrow(() -> new EntrenadorNoEncontradoExcepcion(entrenadorId)));
        aprendizRepositorio.save(aprendiz);
    }

    public void actualizarAprendiz(Long id, Aprendiz aprendiz) {
        Aprendiz aprendizActualizar = aprendizRepositorio.findById(id).orElseThrow(() -> new AprendizNoEncontradoExcepcion(id));

        aprendizActualizar.setNombreCompleto(aprendiz.getNombreCompleto());
        aprendizActualizar.setCorreoElectronico(aprendiz.getCorreoElectronico());
        aprendizActualizar.setContrasenia(aprendiz.getContrasenia());
        aprendizActualizar.setGenero(aprendiz.getGenero());
        aprendizActualizar.setObjetivoEntrenamiento(aprendiz.getObjetivoEntrenamiento());
        aprendizActualizar.setNivelCondicion(aprendiz.getNivelCondicion());
        aprendizActualizar.setEntrenador(aprendiz.getEntrenador());

        aprendizRepositorio.save(aprendizActualizar);
    }

    public List<Aprendiz> obtenerAprendices() {
        return aprendizRepositorio.findAll();
    }

    public Aprendiz obtenerAprendizPorId(Long id) {
        return aprendizRepositorio.findById(id).orElseThrow(() -> new AprendizNoEncontradoExcepcion(id));
    }

    public void eliminarAprendiz(Long id) {
        if (aprendizRepositorio.existsById(id)) {
            aprendizRepositorio.deleteById(id);
        } else {
            throw new AprendizNoEncontradoExcepcion(id);
        }
    }
}