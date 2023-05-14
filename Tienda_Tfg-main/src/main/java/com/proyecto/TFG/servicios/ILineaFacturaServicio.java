package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.LineaFacturaDTO;

import java.util.List;

public interface ILineaFacturaServicio {

    public List<LineaFacturaDTO> obtenerTodo();

    public LineaFacturaDTO guardar(LineaFacturaDTO lineaFactura);

    public LineaFacturaDTO obtenerPorId(long id);

    public void eliminar(long id);

}
