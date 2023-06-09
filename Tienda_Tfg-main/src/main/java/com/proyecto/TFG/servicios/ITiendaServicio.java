package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.TiendaDTO;

import java.util.List;

public interface ITiendaServicio {

    public List<TiendaDTO> obtenerTodo();

    public TiendaDTO guardar(TiendaDTO tienda);

    public TiendaDTO obtenerPorId(long id);

    public void eliminar(long id);

}
