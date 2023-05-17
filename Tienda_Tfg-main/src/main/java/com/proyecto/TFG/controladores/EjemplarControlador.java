package com.proyecto.TFG.controladores;


import com.proyecto.TFG.dtos.EjemplarDTO;
import com.proyecto.TFG.modelos.Ejemplar;
import com.proyecto.TFG.servicios.EjemplarServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ejemplar")
@CrossOrigin(origins = "*")
public class EjemplarControlador {

    @Autowired
    EjemplarServicioImpl ejemplarServicio;

    @GetMapping("listar")
    public List<EjemplarDTO> obtenerEjemplares(){
        return ejemplarServicio.obtenerTodo();
    }

    @PostMapping("/guardar")
    public ResponseEntity<EjemplarDTO> guardarEjemplar(@RequestBody EjemplarDTO ejemplar){
        ejemplarServicio.guardar(ejemplar);
        return new ResponseEntity<>(ejemplar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EjemplarDTO> obtenerEjemplar(@PathVariable long id){
        EjemplarDTO ejemplarId = ejemplarServicio.obtenerPorId(id);

        return ResponseEntity.ok(ejemplarId);
    }

    //implementar update

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarEjemplar(@PathVariable long id){
        this.ejemplarServicio.eliminar(id);

        HashMap<String, Boolean> estadoEjemplarEliminado = new HashMap<>();
        estadoEjemplarEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoEjemplarEliminado);
    }

}
