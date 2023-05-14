package com.proyecto.TFG.servicios;


import com.proyecto.TFG.dtos.UsuarioDTO;

import java.util.List;

public interface IUsuarioServicio {

    public List<UsuarioDTO> obtenerTodo();

    public UsuarioDTO guardar(UsuarioDTO usuario);

    public UsuarioDTO obtenerPorId(long id);

    public void eliminar(long id);

}
