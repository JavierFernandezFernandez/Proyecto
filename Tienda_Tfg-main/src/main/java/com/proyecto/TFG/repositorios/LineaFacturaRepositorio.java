package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.LineaFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaFacturaRepositorio extends JpaRepository<LineaFactura, Long> {
}
