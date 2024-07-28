package com.gestion.GestionGym;

import com.gestion.GestionGym.DTOs.AprendizDTO;
import com.gestion.GestionGym.DTOs.EntrenadorDTO;
import com.gestion.GestionGym.Excepciones.AprendizExistenteExcepcion;
import com.gestion.GestionGym.Excepciones.AprendizNoEncontradoExcepcion;
import com.gestion.GestionGym.Excepciones.EntrenadorNoEncontradoExcepcion;
import com.gestion.GestionGym.Excepciones.InformacionIncompletaExcepcion;
import com.gestion.GestionGym.Modelo.Aprendiz;
import com.gestion.GestionGym.Modelo.Entrenador;
import com.gestion.GestionGym.Repositorio.AprendizRepositorio;
import com.gestion.GestionGym.Repositorio.EntrenadorRepositorio;
import com.gestion.GestionGym.Servicio.AprendizServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class AprendizServicioTest {

    private EntrenadorRepositorio entrenadorRepositorio;
    private AprendizRepositorio aprendizRepositorio;
    private AprendizServicio aprendizServicio;

    @BeforeEach
    public void setUp() {
        this.aprendizRepositorio = mock(AprendizRepositorio.class);
        this.entrenadorRepositorio = mock(EntrenadorRepositorio.class);
        this.aprendizServicio = new AprendizServicio(aprendizRepositorio, entrenadorRepositorio);
    }

    @Test
    public void CrearAprendiz_EntrenadorNoExistenteTest() {
        Long entrenadorId = 1L;
        Aprendiz aprendiz = new Aprendiz();
        when(entrenadorRepositorio.existsById(entrenadorId)).thenReturn(false);

        assertThrows(EntrenadorNoEncontradoExcepcion.class, () -> aprendizServicio.crearAprendiz(aprendiz, entrenadorId));
    }

    @Test
    public void CrearAprendiz_ExistenteTest() {
        Long entrenadorId = 1L;
        Aprendiz aprendiz = new Aprendiz();
        aprendiz.setNombreCompleto("Stefani Torres");
        aprendiz.setContrasenia("password123");
        aprendiz.setCorreoElectronico("estefa45@gmail.com");
        aprendiz.setFechaNacimiento(LocalDate.of(2000, 1, 1));
        aprendiz.setGenero("Femenino");
        aprendiz.setObjetivoEntrenamiento("Perder peso");
        aprendiz.setNivelCondicion("Intermedio");

        when(entrenadorRepositorio.existsById(entrenadorId)).thenReturn(true);
        when(aprendizRepositorio.existsByCorreoElectronico("estefa45@gmail.com")).thenReturn(true);

        assertThrows(AprendizExistenteExcepcion.class, () -> aprendizServicio.crearAprendiz(aprendiz, entrenadorId));
    }

    @Test
    public void CrearAprendiz_ConInformacionIncompletaTest() {
        Long entrenadorId = 1L;
        Aprendiz aprendiz = new Aprendiz();
        when(entrenadorRepositorio.existsById(entrenadorId)).thenReturn(true);

        assertThrows(InformacionIncompletaExcepcion.class, () -> aprendizServicio.crearAprendiz(aprendiz, entrenadorId));
    }

    @Test
    public void ActualizarAprendiz_ExistenteTest() {
        Long id = 1L;
        Aprendiz aprendizExistente = new Aprendiz();
        Aprendiz aprendizNuevo = new Aprendiz();
        when(aprendizRepositorio.findById(id)).thenReturn(Optional.of(aprendizExistente));

        aprendizServicio.actualizarAprendiz(id, aprendizNuevo);

        verify(aprendizRepositorio).save(aprendizExistente);
    }

    @Test
    public void ActualizarAprendiz_NoExistenteTest() {
        Long id = 1L;
        Aprendiz aprendizNuevo = new Aprendiz();
        when(aprendizRepositorio.findById(id)).thenReturn(Optional.empty());

        assertThrows(AprendizNoEncontradoExcepcion.class, () -> aprendizServicio.actualizarAprendiz(id, aprendizNuevo));
    }

    @Test
    public void ObtenerAprendicesTest() {
        Long entrenadorId = 1L;
        Entrenador entrenador = new Entrenador();
        entrenador.setId(entrenadorId);
        entrenador.setNombreCompleto("Carlos Pérez");
        entrenador.setEspecialidad("Musculación");
        entrenador.setExperiencia("5 años");

        Aprendiz aprendiz = new Aprendiz();
        aprendiz.setId(1L);
        aprendiz.setNombreCompleto("Ana Gómez");
        aprendiz.setCorreoElectronico("ana@gmail.com");
        aprendiz.setObjetivoEntrenamiento("Fuerza");
        aprendiz.setNivelCondicion("Avanzado");
        aprendiz.setEntrenador(entrenador);

        List<Aprendiz> aprendices = new ArrayList<>();
        aprendices.add(aprendiz);

        when(aprendizRepositorio.findAll()).thenReturn(aprendices);

        List<AprendizDTO> aprendizDTOs = aprendizServicio.obtenerAprendices();

        assertEquals(1, aprendizDTOs.size());
        AprendizDTO dto = aprendizDTOs.get(0);
        assertEquals("Ana Gómez", dto.getNombreCompleto());
        assertEquals("ana@gmail.com", dto.getCorreoElectronico());
        assertEquals("Fuerza", dto.getObjetivoEntrenamiento());
        assertEquals("Avanzado", dto.getNivelCondicion());

        EntrenadorDTO entrenadorDTO = dto.getEntrenador();
        assertEquals(entrenadorId, entrenadorDTO.getId());
        assertEquals("Carlos Pérez", entrenadorDTO.getNombreCompleto());
        assertEquals("Musculación", entrenadorDTO.getEspecialidad());
        assertEquals("5 años", entrenadorDTO.getExperiencia());
    }

    @Test
    public void ObtenerAprendizPorId_ExistenteTest() {
        Long id = 1L;
        Aprendiz aprendiz = new Aprendiz();
        aprendiz.setId(id);
        aprendiz.setNombreCompleto("Ana Gómez");
        aprendiz.setCorreoElectronico("ana@gmail.com");
        aprendiz.setObjetivoEntrenamiento("Fuerza");
        aprendiz.setNivelCondicion("Avanzado");

        Entrenador entrenador = new Entrenador();
        entrenador.setId(1L);
        entrenador.setNombreCompleto("Carlos Pérez");
        entrenador.setEspecialidad("Musculación");
        entrenador.setExperiencia("5 años");
        aprendiz.setEntrenador(entrenador);

        when(aprendizRepositorio.findById(id)).thenReturn(Optional.of(aprendiz));

        AprendizDTO aprendizDTO = aprendizServicio.obtenerAprendizPorId(id);

        assertEquals(id, aprendizDTO.getId());
        assertEquals("Ana Gómez", aprendizDTO.getNombreCompleto());
        assertEquals("ana@gmail.com", aprendizDTO.getCorreoElectronico());
        assertEquals("Fuerza", aprendizDTO.getObjetivoEntrenamiento());
        assertEquals("Avanzado", aprendizDTO.getNivelCondicion());

        EntrenadorDTO entrenadorDTO = aprendizDTO.getEntrenador();
        assertEquals(entrenador.getId(), entrenadorDTO.getId());
        assertEquals(entrenador.getNombreCompleto(), entrenadorDTO.getNombreCompleto());
        assertEquals(entrenador.getEspecialidad(), entrenadorDTO.getEspecialidad());
        assertEquals(entrenador.getExperiencia(), entrenadorDTO.getExperiencia());
    }

    @Test
    public void ObtenerAprendizPorId_NoExistenteTest() {
        Long id = 1L;
        when(aprendizRepositorio.findById(id)).thenReturn(Optional.empty());

        assertThrows(AprendizNoEncontradoExcepcion.class, () -> aprendizServicio.obtenerAprendizPorId(id));
    }

    @Test
    public void EliminarAprendiz_ExistenteTest() {
        Long id = 1L;
        when(aprendizRepositorio.existsById(id)).thenReturn(true);

        aprendizServicio.eliminarAprendiz(id);

        verify(aprendizRepositorio).deleteById(id);
    }

    @Test
    public void EliminarAprendiz_NoExistenteTest() {
        Long id = 1L;
        when(aprendizRepositorio.existsById(id)).thenReturn(false);

        assertThrows(AprendizNoEncontradoExcepcion.class, () -> aprendizServicio.eliminarAprendiz(id));
    }
}