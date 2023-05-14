package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.LineaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineaPedidoRepositorio extends JpaRepository<LineaPedido, Long> {
}
