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
@Table(name  = "Tiendas", catalog = "tfg")
public class Tienda implements Serializable {

    private static final long serialVersionUID = 6936909883410665247L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Ubicacion")
    private String ubicacion;

    @OneToMany(mappedBy = "tienda",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ejemplar> ejemplares;

}
