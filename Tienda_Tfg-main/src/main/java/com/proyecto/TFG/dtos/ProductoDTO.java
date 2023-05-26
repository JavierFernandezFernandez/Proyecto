package com.proyecto.TFG.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO{

    private long Id;
    private String nombre;
    private double precio;
    private double iva;
    private String descripcion;
    private MarcaDTO marca;
    private CategoriaDTO categoria;

}
