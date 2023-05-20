package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

    List<Pedido> findByUsuarioId(Long usuarioId);

    List<Pedido> findByDireccionId(Long direccionId);

    List<Pedido> findByFormaPagoId(Long formaPagoId);

}
