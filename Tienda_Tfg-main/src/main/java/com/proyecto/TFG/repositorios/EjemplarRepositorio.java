package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemplarRepositorio extends JpaRepository<Ejemplar, Long> {
}
