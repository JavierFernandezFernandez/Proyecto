package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.FormaPagoDTO;

import java.util.List;

public interface IFormaPagoServicio {

    public List<FormaPagoDTO> obtenerTodo();

    public FormaPagoDTO guardar(FormaPagoDTO formaPago);

    public FormaPagoDTO obtenerPorId(long id);

    public void eliminar(long id);

}
