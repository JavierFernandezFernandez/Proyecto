package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDTOL {

    private long Id;
    private String ciudad;
    private String direccion;

}
