package com.proyecto.TFG.modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name  = "Productos", catalog = "tfg")
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

    public List<LineaPedido> getLineaPedidos() {
        return lineaPedidos;
    }

    public void setLineaPedidos(List<LineaPedido> lineaPedidos) {
        this.lineaPedidos = lineaPedidos;
    }

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

    public Producto(){

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(List<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }

    public List<LineaFactura> getLineaFacturas() {
        return lineaFacturas;
    }

    public void setLineaFacturas(List<LineaFactura> lineaFacturas) {
        this.lineaFacturas = lineaFacturas;
    }
}
