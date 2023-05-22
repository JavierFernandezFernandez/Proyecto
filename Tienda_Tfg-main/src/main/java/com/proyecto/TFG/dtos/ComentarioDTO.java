package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Producto;
import com.proyecto.TFG.modelos.Usuario;


public class ComentarioDTO {

    private long Id;
    private String  mensaje;
    private int puntuacion;
    private Producto producto;
    private Usuario usuario;

    public ComentarioDTO(){

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
