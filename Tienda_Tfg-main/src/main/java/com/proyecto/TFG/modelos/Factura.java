package com.proyecto.TFG.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name  = "Facturas", catalog = "tfg")
public class Factura implements Serializable {

    private static final long serialVersionUID = -5417843547467901576L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "Observaciones")
    private String observaciones;
    @Column(name = "Fecha")
    private LocalDate fecha;
    @ManyToOne()
    @JoinColumn(name = "Usuarios_Id")
    private Usuario usuario;
    @ManyToOne()
    @JoinColumn(name = "Direcciones_Id")
    private Direccion direccion;

    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaFactura> lineaFacturas;
    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaPedido> lineaPedidos;

}
