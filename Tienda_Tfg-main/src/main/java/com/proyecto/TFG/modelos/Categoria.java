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
@Table(name  = "Categorias", catalog = "tfg")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 2274668925764867778L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "categoria",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;


}
