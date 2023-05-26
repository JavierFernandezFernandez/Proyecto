package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Producto;
import com.proyecto.TFG.modelos.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDTO {

    private long Id;
    private String  titulo;
    private String  mensaje;
    private int puntuacion;
    private ProductoDTOL producto;
    private UsuarioDTOL usuario;

}
