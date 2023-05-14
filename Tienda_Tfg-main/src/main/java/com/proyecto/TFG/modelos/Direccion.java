package com.proyecto.TFG.modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name  = "Direcciones", catalog = "tfg")
public class Direccion implements Serializable {


    private static final long serialVersionUID = 1262663811049400692L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long Id;
    @Column(name = "Ciudad")
    private String ciudad;
    @Column(name = "Direccion")
    private String direccion;
    @ManyToOne()
    @JoinColumn(name = "Usuarios_Id")
    private Usuario usuario;

    @OneToMany(mappedBy = "direccion",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> factura;

    @OneToMany(mappedBy = "direccion",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    public Direccion(){

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Factura> getFactura() {
        return factura;
    }

    public void setFactura(List<Factura> factura) {
        this.factura = factura;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
