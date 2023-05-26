package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Factura;
import com.proyecto.TFG.modelos.Pedido;
import com.proyecto.TFG.modelos.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaPedidoDTO{

    private long id;
    private int unidades;
    private double precio;
    private double iva;
    private ProductoDTOL producto;
    private FacturaDTOL factura;
    private PedidoDTOL pedido;

}
