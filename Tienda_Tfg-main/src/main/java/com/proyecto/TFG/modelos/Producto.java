package com.proyecto.TFG.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name  = "productos", catalog = "tfg")
public class Producto implements Serializable {

    private static final long serialVersionUID = -2397774858653723668L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Precio")
    private double precio;
    @Column(name = "IVA")
    private double iva;
    @Column(name = "Descripcion")
    private String descripcion;

    @ManyToOne()
    @JoinColumn(name = "Marcas_Id")
    private Marca marca;

    @ManyToOne()
    @JoinColumn(name = "Categorias_Id")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ejemplar> ejemplares;

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaFactura> lineaFacturas;

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaPedido> lineaPedidos;

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios;

}
