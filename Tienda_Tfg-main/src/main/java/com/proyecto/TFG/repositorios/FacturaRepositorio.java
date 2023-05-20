package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Long> {

    List<Factura> findByUsuarioId(Long usuarioId);

    List<Factura> findByDireccionId(Long direccionId);

}
