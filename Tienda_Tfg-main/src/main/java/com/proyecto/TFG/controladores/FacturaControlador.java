package com.proyecto.TFG.controladores;

import com.proyecto.TFG.dtos.FacturaDTO;
import com.proyecto.TFG.modelos.Factura;
import com.proyecto.TFG.servicios.FacturaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "*")
public class FacturaControlador {

    @Autowired
    FacturaServicioImpl facturaServicio;

    @GetMapping("/listar")
    public List<FacturaDTO> obtenerFacturas(){
        return facturaServicio.obtenerTodo();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<FacturaDTO> obtenerFacturasByUsuario(Long usuarioId){
        return facturaServicio.findByUsuarioId(usuarioId);
    }

    @GetMapping("/direccion/{direccionId}")
    public List<FacturaDTO> obtenerFacturasByDireccionId(Long direccionId){
        return facturaServicio.findByDireccionId(direccionId);
    }

    @PostMapping("/guardar")
    public ResponseEntity<FacturaDTO> guardarFactura(@RequestBody FacturaDTO factura){

        factura.setFecha(LocalDate.now());

        facturaServicio.guardar(factura);
        return new ResponseEntity<>(factura, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> obtenerFactura(@PathVariable long id){
        FacturaDTO facturaId = facturaServicio.obtenerPorId(id);

        return ResponseEntity.ok(facturaId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaDTO> actualizarFactura(@PathVariable long id, @RequestBody FacturaDTO factura){

        FacturaDTO facturaAtc = facturaServicio.guardar(factura);
        return new ResponseEntity<>(facturaAtc, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarFactura(@PathVariable long id){
        this.facturaServicio.eliminar(id);

        HashMap<String, Boolean> estadoFacturaEliminado = new HashMap<>();
        estadoFacturaEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoFacturaEliminado);
    }

}
