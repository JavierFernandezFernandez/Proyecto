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
@Table(name = "lineaspedidio", catalog = "tfg")
public class LineaPedido implements Serializable {

    private static final long serialVersionUID = -5767527261396068126L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "Unidades")
    private int unidades;
    @Column(name = "Precio")
    private double precio;
    @Column(name = "IVA")
    private double iva;
    @ManyToOne()
    @JoinColumn(name = "Productos_Id")
    private Producto producto;
    @ManyToOne()
    @JoinColumn(name = "Facturas_id")
    private Factura factura;
    @ManyToOne()
    @JoinColumn(name = "Pedidos_id")
    private Pedido pedido;

}
