package com.proyecto.TFG.modelos;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name  = "Facturas", catalog = "tfg")
public class Factura implements Serializable {

    private static final long serialVersionUID = -5417843547467901576L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = true)
    private long id;
    @Column(name = "Observaciones")
    private String observaciones;
    @Column(name = "Fecha")
    private LocalDate fecha;
    @ManyToOne()
    @JoinColumn(name = "Usuarios_Id")
    private Usuario usuario;
    @ManyToOne()
    @JoinColumn(name = "Direcciones_Id")
    private Direccion direccion;

    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaFactura> lineaFacturas;
    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaPedido> lineaPedidos;

    public Factura(){

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<LineaFactura> getLineaFacturas() {
        return lineaFacturas;
    }

    public void setLineaFacturas(List<LineaFactura> lineaFacturas) {
        this.lineaFacturas = lineaFacturas;
    }

    public List<LineaPedido> getLineaPedidos() {
        return lineaPedidos;
    }

    public void setLineaPedidos(List<LineaPedido> lineaPedidos) {
        this.lineaPedidos = lineaPedidos;
    }
}
