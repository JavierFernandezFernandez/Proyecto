package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.FormaPagoUsuarioDTO;

import java.util.List;

public interface IFormaPagoUsuarioServicio {

    public List<FormaPagoUsuarioDTO> obtenerTodo();

    public FormaPagoUsuarioDTO guardar(FormaPagoUsuarioDTO formaPagoUsuario);

    public FormaPagoUsuarioDTO obtenerPorId(long id);

    public void eliminar(long id);

}
