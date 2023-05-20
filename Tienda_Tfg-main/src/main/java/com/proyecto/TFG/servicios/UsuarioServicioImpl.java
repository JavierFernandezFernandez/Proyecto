package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.UsuarioDTO;
import com.proyecto.TFG.modelos.Usuario;
import com.proyecto.TFG.repositorios.UsuarioRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<UsuarioDTO> obtenerTodo() {

        List<Usuario> usuarios = usuarioRepositorio.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        if (!usuarios.isEmpty()) {

            usuariosDTO = ModelMapperUtil.transformDtoList(usuarios, UsuarioDTO.class);
        }

        return usuariosDTO;

    }

    @Override
    public UsuarioDTO guardar(UsuarioDTO usuario) {

        Usuario usuarioEnti = ModelMapperUtil.transformDto(usuario, Usuario.class);

        return ModelMapperUtil.transformDto(usuarioRepositorio.save(usuarioEnti), UsuarioDTO.class);

    }

    @Override
    public UsuarioDTO obtenerPorId(long id) {

        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        if (usuario.isPresent()) {

            usuarioDTO = ModelMapperUtil.transformDto(usuario.get(), UsuarioDTO.class);

            return usuarioDTO;
        } else {

            return null;
        }

    }

    public UsuarioDTO findByEmail(String email){

        Optional<Usuario> usuario = usuarioRepositorio.findByEmail(email);
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        if (usuario.isPresent()) {

            usuarioDTO = ModelMapperUtil.transformDto(usuario.get(), UsuarioDTO.class);

            return usuarioDTO;
        } else {

            return null;
        }

    }

    public List<UsuarioDTO> getUsersByRoleId(Long id) {

        List<Usuario> usuarios = usuarioRepositorio.findByRolId(id);
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        if (!usuarios.isEmpty()) {

            usuariosDTO = ModelMapperUtil.transformDtoList(usuarios, UsuarioDTO.class);
        }

        return usuariosDTO;
    }

    @Override
    public void eliminar(long id) {

        usuarioRepositorio.deleteById(id);
    }
}
