package com.proyecto.TFG.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EjemplarDTO{

    private long Id;
    private String serie;
    private LocalDate fechaVenta;
    private LocalDate fechaCompra;
    private int unidades;
    private ProductoDTOL producto;

}
