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
@Table(name  = "usuarios", catalog = "tfg")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -2641504118441203786L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Email")
    private String email;
    @Column(name = "Telefono")
    private String telefono;
    @Column(name = "Cesta")
    private String cesta;
    @Column(name = "Password")
    private String password;
    @ManyToOne()
    @JoinColumn(name = "Roles_Id")
    private Rol rol;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Factura> facturas;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Direccion> direcciones;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<FormaPagoUsuario> FormaPagoUsuario;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Comentario> comentarios;

}
