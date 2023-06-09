package com.proyecto.TFG.modelos;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name  = "formaspagos", catalog = "tfg")
public class FormaPago implements Serializable {

    private static final long serialVersionUID = -5759952554983127373L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "Tipo")
    private String tipo;

    @OneToMany(mappedBy = "formaPago",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FormaPagoUsuario> FormaPagoUsuarios;

    @OneToMany(mappedBy = "formaPago",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

}
