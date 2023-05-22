package com.proyecto.TFG.controladores;

import com.proyecto.TFG.dtos.ComentarioDTO;
import com.proyecto.TFG.servicios.ComentarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/comentario")
@CrossOrigin(origins = "*")
public class ComentarioControlador {

    @Autowired
    ComentarioServicioImpl comentarioServicio;

    @GetMapping("/listar")
    public List<ComentarioDTO> obtenerComentarios(){
        return comentarioServicio.obtenerTodo();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<ComentarioDTO> obtenerComentariosByUsuario(long usuarioId){
        return comentarioServicio.findByUsuarioId(usuarioId);
    }

    @GetMapping("/producto/{productoId}")
    public List<ComentarioDTO> obtenerComentariosByProducto(long productoId){
        return comentarioServicio.findByProductoId(productoId);
    }

    @PostMapping("/guardar")
    public ResponseEntity<ComentarioDTO> guardarComentario(@RequestBody ComentarioDTO comentario){
        comentarioServicio.guardar(comentario);
        return new ResponseEntity<>(comentario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioDTO> obtenerComentario(@PathVariable long id){
        ComentarioDTO categoriaId = comentarioServicio.obtenerPorId(id);

        return ResponseEntity.ok(categoriaId);
    }

    //implementar update

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarComentario(@PathVariable long id){
        this.comentarioServicio.eliminar(id);

        HashMap<String, Boolean> estadoComentarioEliminado = new HashMap<>();
        estadoComentarioEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoComentarioEliminado);
    }

}
