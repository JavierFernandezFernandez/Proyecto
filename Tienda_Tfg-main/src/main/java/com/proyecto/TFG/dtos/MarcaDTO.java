package com.proyecto.TFG.dtos;

import com.proyecto.TFG.modelos.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO {

    private long id;
    private String nombre;
    private String descripcion;

}
