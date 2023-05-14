package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.PedidoDTO;
import com.proyecto.TFG.modelos.Pedido;
import com.proyecto.TFG.repositorios.PedidoRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicioImpl implements  IPedidoServicio{

    @Autowired
    PedidoRepositorio pedidoRepositorio;

    @Override
    public List<PedidoDTO> obtenerTodo() {

        List<Pedido> pedidos = pedidoRepositorio.findAll();
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        if (!pedidos.isEmpty()) {

            pedidosDTO = ModelMapperUtil.transformDtoList(pedidos, PedidoDTO.class);
        }

        return pedidosDTO;

    }

    @Override
    public PedidoDTO guardar(PedidoDTO pedido) {

        Pedido pedidoEnti = ModelMapperUtil.transformDto(pedido, Pedido.class);

        return ModelMapperUtil.transformDto(pedidoRepositorio.save(pedidoEnti), PedidoDTO.class);

    }

    @Override
    public PedidoDTO obtenerPorId(long id) {

        Optional<Pedido> pedido = pedidoRepositorio.findById(id);
        PedidoDTO pedidoDTO = new PedidoDTO();

        if (pedido.isPresent()) {

            pedidoDTO = ModelMapperUtil.transformDto(pedido.get(), PedidoDTO.class);

            return pedidoDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        pedidoRepositorio.deleteById(id);
    }
}
