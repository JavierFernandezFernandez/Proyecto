package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.LineaPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineaPedidoRepositorio extends JpaRepository<LineaPedido, Long> {

    List<LineaPedido> findByPedidoId(Long pedidoId);

    List<LineaPedido> findByFacturaId(Long facturaId);

    List<LineaPedido> findByProductoId(Long productoId);

}
