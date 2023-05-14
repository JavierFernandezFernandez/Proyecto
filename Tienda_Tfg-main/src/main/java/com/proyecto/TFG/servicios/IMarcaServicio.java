package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.MarcaDTO;

import java.util.List;

public interface IMarcaServicio {

    public List<MarcaDTO> obtenerTodo();

    public MarcaDTO guardar(MarcaDTO marca);

    public MarcaDTO obtenerPorId(long id);

    public void eliminar(long id);

}
