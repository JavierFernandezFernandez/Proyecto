package com.proyecto.TFG.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaPedidoDTOL {

    private long id;
    private int unidades;
    private double precio;
    private double iva;

}
