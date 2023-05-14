package com.proyecto.TFG.modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
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

    public Categoria(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
