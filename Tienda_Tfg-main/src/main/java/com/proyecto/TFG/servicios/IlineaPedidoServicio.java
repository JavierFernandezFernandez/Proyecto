package com.proyecto.TFG.servicios;


import com.proyecto.TFG.dtos.LineaPedidoDTO;

import java.util.List;

public interface IlineaPedidoServicio {

    public List<LineaPedidoDTO> obtenerTodo();

    public LineaPedidoDTO guardar(LineaPedidoDTO lineaPedido);

    public LineaPedidoDTO obtenerPorId(long id);

    public void eliminar(long id);

}
