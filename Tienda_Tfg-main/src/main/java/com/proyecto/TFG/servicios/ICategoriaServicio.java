package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.CategoriaDTO;

import java.util.List;

public interface ICategoriaServicio {

    public List<CategoriaDTO> obtenerTodo();

    public CategoriaDTO guardar(CategoriaDTO categoria);

    public CategoriaDTO obtenerPorId(long id);

    public void eliminar(long id);

}
