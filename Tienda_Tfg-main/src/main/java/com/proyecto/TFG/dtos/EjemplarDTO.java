package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Producto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

public class EjemplarDTO{

    private long Id;
    private String serie;
    private Date fechaVenta;
    private Date fechaCompra;
    private int unidades;
    private ProductoDTO producto;

    public EjemplarDTO(){

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

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
}
