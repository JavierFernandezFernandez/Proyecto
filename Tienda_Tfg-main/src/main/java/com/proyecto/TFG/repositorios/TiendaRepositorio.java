package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaRepositorio extends JpaRepository<Tienda, Long> {
}
