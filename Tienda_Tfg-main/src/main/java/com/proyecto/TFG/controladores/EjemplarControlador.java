package com.proyecto.TFG.controladores;


import com.proyecto.TFG.dtos.EjemplarDTO;
import com.proyecto.TFG.dtos.UsuarioDTO;
import com.proyecto.TFG.modelos.Ejemplar;
import com.proyecto.TFG.servicios.EjemplarServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ejemplar")
@CrossOrigin(origins = "*")
public class EjemplarControlador {

    @Autowired
    EjemplarServicioImpl ejemplarServicio;

    @GetMapping("/listar")
    public List<EjemplarDTO> obtenerEjemplares(){
        return ejemplarServicio.obtenerTodo();
    }

    @GetMapping("/producto/{productoId}")
    public List<EjemplarDTO> obtenerEjemplaresByProducto(@PathVariable Long productoId){
        List<EjemplarDTO> ejemplares = ejemplarServicio.findByProductoId(productoId);
        List<EjemplarDTO> ejemplaresDisponibles = new ArrayList<>();

        for (EjemplarDTO ejemplar : ejemplares) {
            String estado = ejemplar.getEstado();
            if (estado != null && estado.equals("disponible")){
                ejemplaresDisponibles.add(ejemplar);
            }
        }

        return ejemplaresDisponibles;

    }

    @GetMapping("/count/producto/tienda/{productoId}/{tiendaId}")
    public int countEjemplaresByProductoByTienda(@PathVariable Long productoId, @PathVariable Long tiendaId){

        List<EjemplarDTO> ejemplares = ejemplarServicio.findByProductoId(productoId);
        List<EjemplarDTO> ejemplaresByTiendaByProducto = new ArrayList<>();
        ejemplares.forEach(ejemplar ->{
            if (ejemplar.getTienda().getId() == tiendaId && ejemplar.getEstado() != null && ejemplar.getEstado().equals("disponible")){
                ejemplaresByTiendaByProducto.add(ejemplar);
            }
        });
        return ejemplaresByTiendaByProducto.size();

    }

    @GetMapping("/producto/tienda/{productoId}/{tiendaId}")
    public List<EjemplarDTO> obtenerEjemplaresByProductoByTienda(@PathVariable Long productoId, @PathVariable Long tiendaId){

        List<EjemplarDTO> ejemplares = ejemplarServicio.findByProductoId(productoId);
        List<EjemplarDTO> ejemplaresByTiendaByProducto = new ArrayList<>();
        ejemplares.forEach(ejemplar ->{
            if (ejemplar.getTienda().getId() == tiendaId && ejemplar.getEstado() != null && ejemplar.getEstado().equals("disponible")){
                ejemplaresByTiendaByProducto.add(ejemplar);
            }
        });
        return ejemplaresByTiendaByProducto;

    }

    @PostMapping("/guardar")
    public ResponseEntity<EjemplarDTO> guardarEjemplar(@RequestBody EjemplarDTO ejemplar){

        ejemplar.setFechaCompra(LocalDate.now());
        ejemplar.setFechaVenta(LocalDate.now());
        ejemplar.setEstado("disponible");

        ejemplarServicio.guardar(ejemplar);
        return new ResponseEntity<>(ejemplar, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EjemplarDTO> obtenerEjemplar(@PathVariable long id){
        EjemplarDTO ejemplarId = ejemplarServicio.obtenerPorId(id);

        return ResponseEntity.ok(ejemplarId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EjemplarDTO> actualizarEjemplarParcial(@PathVariable long id, @RequestBody EjemplarDTO ejemplar){

        EjemplarDTO ejemplarId = ejemplarServicio.obtenerPorId(id);

        if(ejemplar.getSerie() != null) {
            ejemplarId.setSerie(ejemplar.getSerie());
        }
        if (ejemplar.getFechaCompra() != null){
            ejemplarId.setFechaCompra(ejemplar.getFechaCompra());
        }
        if (ejemplar.getFechaVenta() != null){
            ejemplarId.setFechaVenta(ejemplar.getFechaVenta());
        }
        if (ejemplar.getEstado() != null){
            ejemplarId.setEstado(ejemplar.getEstado());
        }
//        if (ejemplar.getUnidades() != null){
//            ejemplarId.setUnidades(ejemplar.getUnidades());
//        }
        if (ejemplar.getProducto() != null){
            ejemplarId.setProducto(ejemplar.getProducto());
        }
        if (ejemplar.getTienda() != null){
            ejemplarId.setTienda(ejemplar.getTienda());
        }

        EjemplarDTO ejemplarActualizado = ejemplarServicio.guardar(ejemplarId);
        return new ResponseEntity<>(ejemplarActualizado, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarEjemplar(@PathVariable long id){
        this.ejemplarServicio.eliminar(id);

        HashMap<String, Boolean> estadoEjemplarEliminado = new HashMap<>();
        estadoEjemplarEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoEjemplarEliminado);
    }

}
