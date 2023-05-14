package com.proyecto.TFG.modelos;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "lineasfactura", catalog = "tfg")
public class LineaFactura implements Serializable {

    private static final long serialVersionUID = 6731222719924163651L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "IVA")
    private double iva;
    @Column(name = "Precio")
    private double precio;
    @Column(name = "Unidades")
    private int unidades;
    @Column(name = "Serie")
    private String serie;

    @ManyToOne()
    @JoinColumn(name = "Productos_Id")
    private Producto producto;
    @ManyToOne()
    @JoinColumn(name = "Facturas_id")
    private Factura factura;
    public LineaFactura(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
