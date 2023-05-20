package com.proyecto.TFG.controladores;

import com.proyecto.TFG.dtos.FormaPagoUsuarioDTO;
import com.proyecto.TFG.modelos.FormaPagoUsuario;
import com.proyecto.TFG.servicios.FormaPagoUsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/formaPagoUsuario")
@CrossOrigin(origins = "*")
public class FormaPagoUsuarioControlador {

    @Autowired
    FormaPagoUsuarioServicioImpl formaPagoUsuarioServicio;

    @GetMapping("/listar")
    public List<FormaPagoUsuarioDTO> obtenerFormasPagosUsuario(){
        return formaPagoUsuarioServicio.obtenerTodo();
    }

//    @GetMapping("/listar")
//    public List<FormaPagoUsuarioDTO> obtenerFormasPagosUsuarioByUsuario(Long usuarioId){
//        return formaPagoUsuarioServicio.findByUsuarioId(usuarioId);
//    }
//
//    @GetMapping("/listar")
//    public List<FormaPagoUsuarioDTO> obtenerFormasPagosUsuarioByFormaPago(Long formaPagoId){
//        return formaPagoUsuarioServicio.findByFormaPagoId(formaPagoId);
//    }

    @PostMapping("/guardar")
    public ResponseEntity<FormaPagoUsuarioDTO> guardarFormaPagoUsuario(@RequestBody FormaPagoUsuarioDTO formaPagoUsuario){
        formaPagoUsuarioServicio.guardar(formaPagoUsuario);
        return new ResponseEntity<>(formaPagoUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormaPagoUsuarioDTO> obtenerFormaPagoUsuario(@PathVariable long id){
        FormaPagoUsuarioDTO formaPagoUsuarioId = formaPagoUsuarioServicio.obtenerPorId(id);
        return  ResponseEntity.ok(formaPagoUsuarioId);
    }

    //añadir update

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarFormaPagoUsuario(@PathVariable long id){
        this.formaPagoUsuarioServicio.eliminar(id);

        HashMap<String, Boolean> estadoFormaPagoUsuarioEliminado = new HashMap<>();
        estadoFormaPagoUsuarioEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoFormaPagoUsuarioEliminado);
    }

}
