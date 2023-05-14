package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Direccion;
import com.proyecto.TFG.modelos.FormaPago;
import com.proyecto.TFG.modelos.LineaPedido;
import com.proyecto.TFG.modelos.Usuario;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;
public class PedidoDTO {

    private long Id;
    private LocalDate fechaEntrega;
    private UsuarioDTO usuario;
    private DireccionDTO direccion;
    private FormaPagoDTO formaPago;

    public PedidoDTO(){

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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

    public FormaPagoDTO getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPagoDTO formaPago) {
        this.formaPago = formaPago;
    }

}
