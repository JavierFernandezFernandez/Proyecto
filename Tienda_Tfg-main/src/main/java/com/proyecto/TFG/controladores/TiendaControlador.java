package com.proyecto.TFG.controladores;

import com.proyecto.TFG.dtos.TiendaDTO;
import com.proyecto.TFG.servicios.TiendaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/tienda")
@CrossOrigin(origins = "*")
public class TiendaControlador {

    @Autowired
    TiendaServicioImpl tiendaServicio;

    @GetMapping("/listar")
    public List<TiendaDTO> obtenerTiendas(){
        return tiendaServicio.obtenerTodo();
    }

    @PostMapping("/guardar")
    public ResponseEntity<TiendaDTO> guardarTienda(@RequestBody TiendaDTO tienda){
        tiendaServicio.guardar(tienda);
        return new ResponseEntity<>(tienda, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiendaDTO> obtenerTienda(@PathVariable long id){
        TiendaDTO tiendaId = tiendaServicio.obtenerPorId(id);

        return ResponseEntity.ok(tiendaId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarTienda(@PathVariable long id){
        this.tiendaServicio.eliminar(id);

        HashMap<String, Boolean> estadoTiendaEliminado = new HashMap<>();
        estadoTiendaEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoTiendaEliminado);
    }

}
