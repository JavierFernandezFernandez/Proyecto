package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.FormaPago;
import com.proyecto.TFG.modelos.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormaPagoUsuarioDTO{

    private long Id;
    private String datos;
    private UsuarioDTOL usuario;
    private FormaPagoDTO formaPago;


}
