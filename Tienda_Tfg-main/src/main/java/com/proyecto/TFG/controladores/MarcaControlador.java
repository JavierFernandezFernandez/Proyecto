package com.proyecto.TFG.controladores;

import com.proyecto.TFG.dtos.MarcaDTO;
import com.proyecto.TFG.modelos.Marca;
import com.proyecto.TFG.servicios.MarcaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/marca")
@CrossOrigin(origins = "*")
public class MarcaControlador {

    @Autowired
    MarcaServicioImpl marcaServicio;

    @GetMapping("listar")
    public List<MarcaDTO> obtenerMarcas(){
        return marcaServicio.obtenerTodo();
    }

    @PostMapping("/guardar")
    public ResponseEntity<MarcaDTO> guardarMarca(@RequestBody MarcaDTO marca){
        marcaServicio.guardar(marca);
        return new ResponseEntity<>(marca, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> obtenerMarca(@PathVariable long id){
        MarcaDTO marcaId = marcaServicio.obtenerPorId(id);

        return ResponseEntity.ok(marcaId);
    }

    //implementar update

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarMarca(@PathVariable long id){
        this.marcaServicio.eliminar(id);

        HashMap<String, Boolean> estadoMarcaEliminado = new HashMap<>();
        estadoMarcaEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoMarcaEliminado);
    }

}
