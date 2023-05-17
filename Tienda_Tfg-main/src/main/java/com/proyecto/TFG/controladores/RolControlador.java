package com.proyecto.TFG.controladores;

import com.proyecto.TFG.dtos.RolDTO;
import com.proyecto.TFG.modelos.Rol;
import com.proyecto.TFG.servicios.RolServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "*")
public class RolControlador {

    @Autowired
    RolServicioImpl rolServicio;

    @GetMapping("/listar")
    public List<RolDTO> obtenerRoles(){
        return rolServicio.obtenerTodo();
    }

    @PostMapping("/guardar")
    public ResponseEntity<RolDTO> guardarRol(@RequestBody RolDTO rol){
        rolServicio.guardar(rol);
        return new ResponseEntity<>(rol, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> obtenerRol(@PathVariable long id){
        RolDTO rolId = rolServicio.obtenerPorId(id);

        return ResponseEntity.ok(rolId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> actualizarRol(@PathVariable long id, @RequestBody RolDTO rol){
        RolDTO rolId = rolServicio.obtenerPorId(id);
        rolId.setRol(rol.getRol());

        RolDTO rolAtc = rolServicio.guardar(rolId);
        return new ResponseEntity<>(rolAtc, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarRol(@PathVariable long id){
        this.rolServicio.eliminar(id);

        HashMap<String, Boolean> estadoRolEliminado = new HashMap<>();
        estadoRolEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoRolEliminado);
    }

}
