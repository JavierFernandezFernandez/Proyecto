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
@Table(name  = "Pedidos", catalog = "tfg")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 3508480517121411311L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Fechaentrega")
    private LocalDate fechaEntrega;
    @Column(name = "Fecha")
    private LocalDate fecha;
    @Column(name = "Estado")
    private String estado;

    @ManyToOne()
    @JoinColumn(name = "Usuarios_Id")
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "Direcciones_Id")
    private Direccion direccion;

    @ManyToOne()
    @JoinColumn(name = "Formaspagos_Id")
    private FormaPago formaPago;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaPedido> lineaPedidos;

}
