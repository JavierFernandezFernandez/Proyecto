package com.proyecto.TFG.servicios;


import com.proyecto.TFG.dtos.ComentarioDTO;
import com.proyecto.TFG.modelos.Comentario;
import com.proyecto.TFG.repositorios.ComentarioRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServicioImpl implements  IComentarioServicio{

    @Autowired
    ComentarioRepositorio comentarioRepositorio;

    @Override
    public List<ComentarioDTO> obtenerTodo() {

        List<Comentario> comentarios = comentarioRepositorio.findAll();
        List<ComentarioDTO> comentariosDTO = new ArrayList<>();
        if (!comentarios.isEmpty()) {

            comentariosDTO = ModelMapperUtil.transformDtoList(comentarios, ComentarioDTO.class);
        }

        return comentariosDTO;

    }

    public List<ComentarioDTO> findByUsuarioId(long usuarioId){

        List<Comentario> comentarios = comentarioRepositorio.findByUsuarioId(usuarioId);
        List<ComentarioDTO> comentariosDTO = new ArrayList<>();
        if (!comentarios.isEmpty()) {

            comentariosDTO = ModelMapperUtil.transformDtoList(comentarios, ComentarioDTO.class);
        }

        return comentariosDTO;

    }

    public List<ComentarioDTO> findByProductoId(long productoId){

        List<Comentario> comentarios = comentarioRepositorio.findByProductoId(productoId);
        List<ComentarioDTO> comentariosDTO = new ArrayList<>();
        if (!comentarios.isEmpty()) {

            comentariosDTO = ModelMapperUtil.transformDtoList(comentarios, ComentarioDTO.class);
        }

        return comentariosDTO;

    }

    @Override
    public ComentarioDTO guardar(ComentarioDTO comentario) {

        Comentario comentarioEnti = ModelMapperUtil.transformDto(comentario, Comentario.class);

        return ModelMapperUtil.transformDto(comentarioRepositorio.save(comentarioEnti), ComentarioDTO.class);

    }

    @Override
    public ComentarioDTO obtenerPorId(long id) {

        Optional<Comentario> comentario = comentarioRepositorio.findById(id);
        ComentarioDTO comentarioDTO = new ComentarioDTO();

        if (comentario.isPresent()) {

            comentarioDTO = ModelMapperUtil.transformDto(comentario.get(), ComentarioDTO.class);

            return comentarioDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        comentarioRepositorio.deleteById(id);
    }
}
