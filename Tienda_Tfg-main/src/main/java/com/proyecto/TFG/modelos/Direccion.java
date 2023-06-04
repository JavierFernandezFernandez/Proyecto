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
@Table(name  = "Direcciones", catalog = "tfg")
public class Direccion implements Serializable {


    private static final long serialVersionUID = 1262663811049400692L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Ciudad")
    private String ciudad;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "CP")
    private String cp;
    @ManyToOne()
    @JoinColumn(name = "Usuarios_Id")
    private Usuario usuario;

    @OneToMany(mappedBy = "direccion",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> factura;

    @OneToMany(mappedBy = "direccion",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

}
