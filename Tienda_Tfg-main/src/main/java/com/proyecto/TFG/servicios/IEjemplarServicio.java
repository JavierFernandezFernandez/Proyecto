package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.EjemplarDTO;

import java.util.List;

public interface IEjemplarServicio {

    public List<EjemplarDTO> obtenerTodo();

    public EjemplarDTO guardar(EjemplarDTO ejemplar);

    public EjemplarDTO obtenerPorId(long id);

    public void eliminar(long id);

}
