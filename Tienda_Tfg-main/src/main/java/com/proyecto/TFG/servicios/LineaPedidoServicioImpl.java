package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.LineaFacturaDTO;
import com.proyecto.TFG.dtos.LineaPedidoDTO;
import com.proyecto.TFG.modelos.LineaPedido;
import com.proyecto.TFG.repositorios.LineaPedidoRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LineaPedidoServicioImpl implements IlineaPedidoServicio{

    @Autowired
    LineaPedidoRepositorio lineaPedidoRepositorio;

    @Override
    public List<LineaPedidoDTO> obtenerTodo() {

        List<LineaPedido> lineasPedidos = lineaPedidoRepositorio.findAll();
        List<LineaPedidoDTO> lineasPedidosDTO = new ArrayList<>();
        if (!lineasPedidos.isEmpty()) {

            lineasPedidosDTO = ModelMapperUtil.transformDtoList(lineasPedidos, LineaPedidoDTO.class);
        }

        return lineasPedidosDTO;

    }

    @Override
    public LineaPedidoDTO guardar(LineaPedidoDTO lineaPedido) {

        LineaPedido lineaPedidoEnti = ModelMapperUtil.transformDto(lineaPedido, LineaPedido.class);

        return ModelMapperUtil.transformDto(lineaPedidoRepositorio.save(lineaPedidoEnti), LineaPedidoDTO.class);

    }

    @Override
    public LineaPedidoDTO obtenerPorId(long id) {

        Optional<LineaPedido> lineaPedido = lineaPedidoRepositorio.findById(id);
        LineaPedidoDTO lineaPedidoDTO = new LineaPedidoDTO();

        if (lineaPedido.isPresent()) {

            lineaPedidoDTO = ModelMapperUtil.transformDto(lineaPedido.get(), LineaPedidoDTO.class);

            return lineaPedidoDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {

        lineaPedidoRepositorio.deleteById(id);

    }

}
