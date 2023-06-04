package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Factura;
import com.proyecto.TFG.modelos.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaFacturaDTO{

    private long id;
    private double precio;
    private double iva;
    private int unidades;
    private String serie;
    private ProductoDTOL producto;
    private FacturaDTOL factura;

}
