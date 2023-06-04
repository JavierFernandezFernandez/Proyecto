package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Usuario;
import jakarta.persistence.Column;
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
    private String nombre;
    private String cp;

}
