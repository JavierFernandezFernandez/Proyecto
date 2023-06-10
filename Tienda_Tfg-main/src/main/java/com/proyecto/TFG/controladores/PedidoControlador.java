package com.proyecto.TFG.controladores;

import com.proyecto.TFG.dtos.PedidoDTO;
import com.proyecto.TFG.servicios.PedidoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*")
public class PedidoControlador {

    @Autowired
    PedidoServicioImpl pedidoServicio;

    @GetMapping("/listar")
    public List<PedidoDTO> obtenerPedidos(){
        return pedidoServicio.obtenerTodo();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<PedidoDTO> obtenerPedidosByUsuario( @PathVariable Long usuarioId){
        return pedidoServicio.findByUsuarioId(usuarioId);
    }

    @GetMapping("/usuario/end/{usuarioId}")
    public PedidoDTO obtenerEndFacturaByUsuario(@PathVariable Long usuarioId){
        List<PedidoDTO> pedidosUsusario = pedidoServicio.findByUsuarioId(usuarioId);

        int indice = pedidosUsusario.size() -1;

        System.out.println(indice);

        PedidoDTO pedido =  pedidosUsusario.get(indice);

        return pedido;
    }

    @GetMapping("/direccion/{direccionId}")
    public List<PedidoDTO> obtenerPedidosByDireccion(Long direccionId){
        return pedidoServicio.findByDireccionId(direccionId);
    }

    @GetMapping("/formaPago/{formaPagoId}")
    public List<PedidoDTO> obtenerPedidosByFormaPago(Long formaPagoId){
        return pedidoServicio.findByFormaPagoId(formaPagoId);
    }

    @PostMapping("/guardar")
    public ResponseEntity<PedidoDTO> guardarPedido(@RequestBody PedidoDTO pedido){

        LocalDate fechaActual = LocalDate.now();

        pedido.setFecha(fechaActual);

        fechaActual = fechaActual.plusDays(3);

        pedido.setFechaEntrega(fechaActual);
        pedidoServicio.guardar(pedido);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> obtenerPedido(@PathVariable long id){
        PedidoDTO pedidoId = pedidoServicio.obtenerPorId(id);
        return ResponseEntity.ok(pedidoId);
    }

    //implementar update

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarPedido(@PathVariable long id){
        this.pedidoServicio.eliminar(id);

        HashMap<String, Boolean> estadoPedidoEliminado = new HashMap<>();
        estadoPedidoEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoPedidoEliminado);
    }

}
