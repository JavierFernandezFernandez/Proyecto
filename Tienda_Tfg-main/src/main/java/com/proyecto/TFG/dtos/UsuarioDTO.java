package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Direccion;
import com.proyecto.TFG.modelos.Factura;
import com.proyecto.TFG.modelos.FormaPagoUsuario;
import com.proyecto.TFG.modelos.Pedido;
import com.proyecto.TFG.modelos.Rol;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

public class UsuarioDTO{

    private long Id;
    private String nombre;
    private String email;
    private String telefono;
    private String password;
    private RolDTO rol;

    public UsuarioDTO(){

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
        this.rol = rol;
    }

}
