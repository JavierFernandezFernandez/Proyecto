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
@Table(name  = "fpusuarios", catalog = "tfg")
public class FormaPagoUsuario implements Serializable {

    private static final long serialVersionUID = 4104961599731493478L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Datos")
    private String datos;

    @ManyToOne()
    @JoinColumn(name = "Usuarios_Id")
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "Formaspagos_Id")
    private FormaPago formaPago;

}
