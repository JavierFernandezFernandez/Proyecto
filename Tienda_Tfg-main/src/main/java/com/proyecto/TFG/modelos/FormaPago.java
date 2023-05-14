package com.proyecto.TFG.modelos;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name  = "formaspagos", catalog = "tfg")
public class FormaPago implements Serializable {

    private static final long serialVersionUID = -5759952554983127373L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "Tipo")
    private String tipo;

    @OneToMany(mappedBy = "formaPago",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FormaPagoUsuario> formaPagoUsuarios;

    @OneToMany(mappedBy = "formaPago",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    public FormaPago() {
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

    public List<FormaPagoUsuario> getFormaPagoUsuarios() {
        return formaPagoUsuarios;
    }

    public void setFormaPagoUsuarios(List<FormaPagoUsuario> formaPagoUsuarios) {
        this.formaPagoUsuarios = formaPagoUsuarios;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
