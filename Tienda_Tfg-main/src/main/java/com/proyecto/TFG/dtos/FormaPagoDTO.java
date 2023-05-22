package com.proyecto.TFG.dtos;

import java.util.List;

public class FormaPagoDTO {

    private long id;
    private String tipo;
    private List<FormaPagoUsuarioDTO> formaPagoUsuarios;

    public FormaPagoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<FormaPagoUsuarioDTO> getFormaPagoUsuarios() {
        return formaPagoUsuarios;
    }

    public void setFormaPagoUsuarios(List<FormaPagoUsuarioDTO> formaPagoUsuarios) {
        this.formaPagoUsuarios = formaPagoUsuarios;
    }

}
