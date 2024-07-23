package com.gestion.GestionGym.Repositorio;

import com.gestion.GestionGym.Modelo.Aprendiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AprendizRepositorio extends JpaRepository<Aprendiz, Long> {
    boolean existsByCorreoElectronico(String correoElectronico);
}
