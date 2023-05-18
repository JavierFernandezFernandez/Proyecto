package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Categoria;
import com.proyecto.TFG.modelos.Ejemplar;
import com.proyecto.TFG.modelos.LineaFactura;
import com.proyecto.TFG.modelos.LineaPedido;
import com.proyecto.TFG.modelos.Marca;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

public class ProductoDTO{

    private long Id;
    private String nombre;
    private double precio;
    private double iva;
    private String descripcion;
    private MarcaDTO marca;
    private CategoriaDTO categoria;

    public ProductoDTO(){

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public MarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MarcaDTO marca) {
        this.marca = marca;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

}
