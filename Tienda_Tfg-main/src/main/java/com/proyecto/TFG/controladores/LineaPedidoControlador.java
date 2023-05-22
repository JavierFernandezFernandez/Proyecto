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

    @GetMapping("/listar")
    public List<LineaPedidoDTO> obtenerLineasPedido(){
        return lineaPedidoServicio.obtenerTodo();
    }

    @GetMapping("/factura/{facturaId}")
    public List<LineaPedidoDTO> obtenerLineasPedidoByFactura(Long facturaId){
        return lineaPedidoServicio.findByFacturaId(facturaId);
    }

    @GetMapping("/pedido/{pedidoId}")
    public List<LineaPedidoDTO> obtenerLineasPedidoByPedido(Long pedidoId){
        return lineaPedidoServicio.findByPedidoId(pedidoId);
    }

    @GetMapping("/producto/{productoId}")
    public List<LineaPedidoDTO> obtenerLineasPedidoByProducto(Long productoId){
        return lineaPedidoServicio.findByProductoId(productoId);
    }

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
