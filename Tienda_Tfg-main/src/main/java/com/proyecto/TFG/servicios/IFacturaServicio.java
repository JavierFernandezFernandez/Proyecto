package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.FacturaDTO;

import java.util.List;

public interface IFacturaServicio {

    public List<FacturaDTO> obtenerTodo();

    public FacturaDTO guardar(FacturaDTO factura);

    public FacturaDTO obtenerPorId(long id);

    public void eliminar(long id);

}
