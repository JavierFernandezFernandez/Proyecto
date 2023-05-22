package com.proyecto.TFG.servicios;



import com.proyecto.TFG.dtos.ComentarioDTO;

import java.util.List;

public interface IComentarioServicio {

    public List<ComentarioDTO> obtenerTodo();

    public ComentarioDTO guardar(ComentarioDTO comentario);

    public ComentarioDTO obtenerPorId(long id);

    public void eliminar(long id);

}
