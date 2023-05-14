package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Direccion;
import com.proyecto.TFG.modelos.LineaFactura;
import com.proyecto.TFG.modelos.LineaPedido;
import com.proyecto.TFG.modelos.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class FacturaDTO{

    private long id;
    private String observaciones;
    private LocalDate fecha;
    private UsuarioDTO usuario;
    private DireccionDTO direccion;

    public FacturaDTO(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDTO direccion) {
        this.direccion = direccion;
    }

}
