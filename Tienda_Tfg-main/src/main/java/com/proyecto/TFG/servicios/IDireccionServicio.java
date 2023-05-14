package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.DireccionDTO;

import java.util.List;

public interface IDireccionServicio {

    public List<DireccionDTO> obtenerTodo();

    public DireccionDTO guardar(DireccionDTO direccion);

    public DireccionDTO obtenerPorId(long id);

    public void eliminar(long id);

}
