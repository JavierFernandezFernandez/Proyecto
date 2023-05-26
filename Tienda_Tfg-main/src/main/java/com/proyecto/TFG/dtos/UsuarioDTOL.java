package com.proyecto.TFG.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTOL {

    private long Id;
    private String nombre;
    private String email;
    private String telefono;
    private String password;
    private String cesta;
}
