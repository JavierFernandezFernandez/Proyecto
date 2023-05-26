package com.proyecto.TFG.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name  = "Ejemplares", catalog = "tfg")
public class Ejemplar implements Serializable {

    private static final long serialVersionUID = 714605479005170543L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Serie")
    private String serie;
    @Column(name = "Venta")
    private Date fechaVenta;
    @Column(name = "Compra")
    private Date fechaCompra;
    @Column(name = "Unidades")
    private int unidades;
    @ManyToOne()
    @JoinColumn(name = "Productos_Id")
    private Producto producto;

}
