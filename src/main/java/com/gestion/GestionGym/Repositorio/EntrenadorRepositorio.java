package com.gestion.GestionGym.Repositorio;

import com.gestion.GestionGym.Modelo.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepositorio extends JpaRepository<Entrenador, Long> {
    boolean existsByCorreoElectronico(String correoElectronico);
}
