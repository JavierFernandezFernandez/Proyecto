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
@Table(name  = "comentarios", catalog = "tfg")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 8117386946996287653L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Titulo")
    private String  titulo;
    @Column(name = "Mensaje")
    private String  mensaje;
    @Column(name = "Puntuacion")
    private int puntuacion;
    @ManyToOne()
    @JoinColumn(name = "Productos_Id")
    private Producto producto;
    @ManyToOne()
    @JoinColumn(name = "Usuarios_Id")
    private Usuario usuario;

}
