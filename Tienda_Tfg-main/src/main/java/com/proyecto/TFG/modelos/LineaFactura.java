package com.proyecto.TFG.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "lineasfactura", catalog = "tfg")
public class LineaFactura implements Serializable {

    private static final long serialVersionUID = 6731222719924163651L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "IVA")
    private double iva;
    @Column(name = "Precio")
    private double precio;
    @Column(name = "Unidades")
    private int unidades;
    @Column(name = "Serie")
    private String serie;

    @ManyToOne()
    @JoinColumn(name = "Productos_Id")
    private Producto producto;
    @ManyToOne()
    @JoinColumn(name = "Facturas_id")
    private Factura factura;
}
