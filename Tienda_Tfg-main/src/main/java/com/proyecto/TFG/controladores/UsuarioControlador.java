package com.proyecto.TFG.controladores;

import com.proyecto.TFG.dtos.UsuarioDTO;
import com.proyecto.TFG.modelos.Usuario;
import com.proyecto.TFG.servicios.UsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioControlador {

    @Autowired
    UsuarioServicioImpl usuarioServicio;

    @GetMapping("/listar")
    public List<UsuarioDTO> obtenerUsuarios(){
        return usuarioServicio.obtenerTodo();
    }

    @PostMapping("/guardar")
    public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuario){

        usuario.setPassword(new BCryptPasswordEncoder(8).encode(usuario.getPassword()));

        usuarioServicio.guardar(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerUsuario(@PathVariable long id){
        UsuarioDTO usuarioId = usuarioServicio.obtenerPorId(id);

        if(usuarioId.getCesta() == null || usuarioId.getCesta() == ""){
            usuarioId.setCesta("[]");
        }

        return ResponseEntity.ok(usuarioId);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuarioParcial(@PathVariable long id, @RequestBody UsuarioDTO usuario){

        UsuarioDTO usuarioId = usuarioServicio.obtenerPorId(id);

        if(usuario.getNombre() != null) {
            usuarioId.setNombre(usuario.getNombre());
        }
        if(usuario.getPassword() != null) {
            usuarioId.setPassword(new BCryptPasswordEncoder(8).encode(usuario.getPassword()));
        }
        if(usuario.getEmail() != null) {
            usuarioId.setEmail(usuario.getEmail());
        }
        if(usuario.getTelefono() != null) {
            usuarioId.setTelefono(usuario.getTelefono());
        }
        if(usuario.getCesta() != null) {
            usuarioId.setCesta(usuario.getCesta());
        }
        if(usuario.getRol() != null) {
            usuarioId.setRol(usuario.getRol());
        }

        UsuarioDTO usuarioActualizado = usuarioServicio.guardar(usuarioId);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarUsuario(@PathVariable long id){
        this.usuarioServicio.eliminar(id);

        HashMap<String, Boolean> estadoUsuarioEliminado = new HashMap<>();
        estadoUsuarioEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoUsuarioEliminado);
    }

    @GetMapping("/role/{roleId}")
    public List<UsuarioDTO> getUsersByRoleId(@PathVariable("roleId") Long roleId) {
        return usuarioServicio.getUsersByRoleId(roleId);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> obtenerUsuarioByEmail(@PathVariable String email){
        UsuarioDTO clienteId = usuarioServicio.findByEmail(email);
        clienteId.setPassword(null);
        if(clienteId.getCesta() == null || clienteId.getCesta() == ""){
            clienteId.setCesta("[]");
        }
        return ResponseEntity.ok(clienteId);
    }

}
