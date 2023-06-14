package com.proyecto.TFG.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTOL {

    private long Id;
    private LocalDate fechaEntrega;
    private LocalDate fecha;
    private String estado;

}
