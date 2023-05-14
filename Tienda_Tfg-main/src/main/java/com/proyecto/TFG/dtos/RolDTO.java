package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


public class RolDTO {

    private long id;
    private String rol;
    //private List<UsuarioDTO> usuarios;

    public RolDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}
