package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Factura;
import com.proyecto.TFG.modelos.Pedido;
import com.proyecto.TFG.modelos.Producto;
import jakarta.persistence.*;

import java.io.Serializable;

public class LineaPedidoDTO{

    private long id;
    private int unidades;
    private double precio;
    private double iva;
    private ProductoDTO producto;
    private FacturaDTO factura;
    private PedidoDTO pedido;

    public LineaPedidoDTO(){

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

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public FacturaDTO getFactura() {
        return factura;
    }

    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }

    public PedidoDTO getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDTO pedido) {
        this.pedido = pedido;
    }
}
