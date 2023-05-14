package com.proyecto.TFG.modelos;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name  = "FormasPagosUsuarios", catalog = "tfg")
public class FormaPagoUsuario implements Serializable {

    private static final long serialVersionUID = 4104961599731493478L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Datos")
    private String datos;

    @ManyToOne()
    @JoinColumn(name = "Usuarios_Id")
    private Usuario usuario;

    @ManyToOne()
    @JoinColumn(name = "FormasPago_Id")
    private FormaPago formaPago;

    public FormaPagoUsuario(){

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }
}
