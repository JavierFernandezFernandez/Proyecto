package com.proyecto.TFG.modelos;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "lineaspedidio", catalog = "tfg")
public class LineaPedido implements Serializable {

    private static final long serialVersionUID = -5767527261396068126L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "Unidades")
    private int unidades;
    @Column(name = "Precio")
    private double precio;
    @Column(name = "IVA")
    private double iva;
    @ManyToOne()
    @JoinColumn(name = "Productos_Id")
    private Producto producto;
    @ManyToOne()
    @JoinColumn(name = "Facturas_id")
    private Factura factura;
    @ManyToOne()
    @JoinColumn(name = "Pedidos_id")
    private Pedido pedido;

    public LineaPedido(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
