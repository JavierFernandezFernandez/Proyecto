package com.proyecto.TFG.servicios;


import com.proyecto.TFG.dtos.RolDTO;

import java.util.List;

public interface IRolServicio {

    public List<RolDTO> obtenerTodo();

    public RolDTO guardar(RolDTO rol);

    public RolDTO obtenerPorId(long id);

    public void eliminar(long id);

}
