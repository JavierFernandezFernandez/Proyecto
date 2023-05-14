package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.ProductoDTO;

import java.util.List;

public interface IProductoServicio {

    public List<ProductoDTO> obtenerTodo();

    public ProductoDTO guardar(ProductoDTO producto);

    public ProductoDTO obtenerPorId(long id);

    public void eliminar(long id);

}
