package com.proyecto.TFG.controladores;


import com.proyecto.TFG.dtos.LineaPedidoDTO;
import com.proyecto.TFG.modelos.LineaPedido;
import com.proyecto.TFG.servicios.LineaPedidoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/lineaPedido")
@CrossOrigin(origins = "*")
public class LineaPedidoControlador {

    @Autowired
    LineaPedidoServicioImpl lineaPedidoServicio;

    @GetMapping("listar")
    public List<LineaPedidoDTO> obtenerLineasPedido(){
        return lineaPedidoServicio.obtenerTodo();
    }

//    @GetMapping("listar")
//    public List<LineaPedidoDTO> obtenerLineasPedidoFactura(Long facturaId){
//        return lineaPedidoServicio.findByFacturaId(facturaId);
//    }
//
//    @GetMapping("listar")
//    public List<LineaPedidoDTO> obtenerLineasPedidoPedido(Long pedidoId){
//        return lineaPedidoServicio.findByPedidoId(pedidoId);
//    }
//
//    @GetMapping("listar")
//    public List<LineaPedidoDTO> obtenerLineasPedidoProducto(Long productoId){
//        return lineaPedidoServicio.findByProductoId(productoId);
//    }

    @PostMapping("/guardar")
    public ResponseEntity<LineaPedidoDTO> guardarLineaPedido(@RequestBody LineaPedidoDTO lineaPedido){
        lineaPedidoServicio.guardar(lineaPedido);
        return new ResponseEntity<>(lineaPedido, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LineaPedidoDTO> obtenerLineaPedido(@PathVariable long id){
        LineaPedidoDTO lineaPedidoId = lineaPedidoServicio.obtenerPorId(id);

        return ResponseEntity.ok(lineaPedidoId);
    }

    //implementar update

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarLineaPedido(@PathVariable long id){
        this.lineaPedidoServicio.eliminar(id);

        HashMap<String, Boolean> estadoLineaPedidoEliminado = new HashMap<>();
        estadoLineaPedidoEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoLineaPedidoEliminado);
    }

}
