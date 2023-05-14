package com.proyecto.TFG.modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name  = "Ejemplares", catalog = "tfg")
public class Ejemplar implements Serializable {

    private static final long serialVersionUID = 714605479005170543L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Serie")
    private String serie;
    @Column(name = "Venta")
    private Date fechaVenta;
    @Column(name = "Compra")
    private Date fechaCompra;
    @Column(name = "Unidades")
    private int unidades;
    @ManyToOne()
    @JoinColumn(name = "Productos_Id")
    private Producto producto;

    public Ejemplar(){

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
