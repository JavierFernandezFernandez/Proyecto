package com.proyecto.TFG.controladores;


import com.proyecto.TFG.dtos.LineaFacturaDTO;
import com.proyecto.TFG.modelos.LineaFactura;
import com.proyecto.TFG.servicios.LineaFacturaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/lineaFactura")
@CrossOrigin(origins = "*")
public class LineaFacturaControlador {

    @Autowired
    private LineaFacturaServicioImpl lineaFacturaService;

    @GetMapping("listar")
    public List<LineaFacturaDTO> obtenerLineasFactura(){
        return lineaFacturaService.obtenerTodo();
    }

    @PostMapping("/guardar")
    public ResponseEntity<LineaFacturaDTO> guardarLineaFactura(@RequestBody LineaFacturaDTO lineaFactura){
        lineaFacturaService.guardar(lineaFactura);
        return new ResponseEntity<>(lineaFactura, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LineaFacturaDTO> obtenerlineaFactura(@PathVariable long id){
        LineaFacturaDTO lineaFacturaId = lineaFacturaService.obtenerPorId(id);

        return ResponseEntity.ok(lineaFacturaId);
    }

    //implementar update

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarlineaFactura(@PathVariable long id){
        this.lineaFacturaService.eliminar(id);

        HashMap<String, Boolean> estadoLineaFacturaEliminado = new HashMap<>();
        estadoLineaFacturaEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoLineaFacturaEliminado);
    }

}
