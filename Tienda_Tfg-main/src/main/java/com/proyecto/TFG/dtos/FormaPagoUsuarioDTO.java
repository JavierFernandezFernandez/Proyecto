package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.FormaPago;
import com.proyecto.TFG.modelos.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;

public class FormaPagoUsuarioDTO{

    private long Id;
    private String datos;
    private UsuarioDTO usuario;
    private FormaPagoDTO formaPago;

    public FormaPagoUsuarioDTO(){

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public FormaPagoDTO getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPagoDTO formaPago) {
        this.formaPago = formaPago;
    }
}
