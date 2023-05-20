package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.FormaPagoUsuarioDTO;
import com.proyecto.TFG.modelos.FormaPagoUsuario;
import com.proyecto.TFG.repositorios.FormaPagoUsuarioRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormaPagoUsuarioServicioImpl implements IFormaPagoUsuarioServicio{

    @Autowired
    FormaPagoUsuarioRepositorio formaPagoUsuarioRepositorio;

    @Override
    public List<FormaPagoUsuarioDTO> obtenerTodo() {

        List<FormaPagoUsuario> formaPagoUsuarios = formaPagoUsuarioRepositorio.findAll();
        List<FormaPagoUsuarioDTO> formasPagosUsuarioDTO = new ArrayList<>();
        if (!formaPagoUsuarios.isEmpty()) {

            formasPagosUsuarioDTO = ModelMapperUtil.transformDtoList(formaPagoUsuarios, FormaPagoUsuarioDTO.class);
        }

        return formasPagosUsuarioDTO;

    }

    public List<FormaPagoUsuarioDTO> findByUsuarioId(Long usuarioId){
        List<FormaPagoUsuario> formaPagoUsuarios = formaPagoUsuarioRepositorio.findByUsuarioId(usuarioId);
        List<FormaPagoUsuarioDTO> formasPagosUsuarioDTO = new ArrayList<>();
        if (!formaPagoUsuarios.isEmpty()) {

            formasPagosUsuarioDTO = ModelMapperUtil.transformDtoList(formaPagoUsuarios, FormaPagoUsuarioDTO.class);
        }

        return formasPagosUsuarioDTO;
    }

    public List<FormaPagoUsuarioDTO> findByFormaPagoId(Long formaPagoId){
        List<FormaPagoUsuario> formaPagoUsuarios = formaPagoUsuarioRepositorio.findByFormaPagoId(formaPagoId);
        List<FormaPagoUsuarioDTO> formasPagosUsuarioDTO = new ArrayList<>();
        if (!formaPagoUsuarios.isEmpty()) {

            formasPagosUsuarioDTO = ModelMapperUtil.transformDtoList(formaPagoUsuarios, FormaPagoUsuarioDTO.class);
        }

        return formasPagosUsuarioDTO;
    }

    @Override
    public FormaPagoUsuarioDTO guardar(FormaPagoUsuarioDTO formaPagoUsuario) {

        FormaPagoUsuario formaPagoUsuarioEnti = ModelMapperUtil.transformDto(formaPagoUsuario, FormaPagoUsuario.class);

        return ModelMapperUtil.transformDto(formaPagoUsuarioRepositorio.save(formaPagoUsuarioEnti), FormaPagoUsuarioDTO.class);

    }

    @Override
    public FormaPagoUsuarioDTO obtenerPorId(long id) {

        Optional<FormaPagoUsuario> formaPagoUsuario = formaPagoUsuarioRepositorio.findById(id);
        FormaPagoUsuarioDTO formaPagoUsuarioDTO = new FormaPagoUsuarioDTO();

        if (formaPagoUsuario.isPresent()) {

            formaPagoUsuarioDTO = ModelMapperUtil.transformDto(formaPagoUsuario.get(), FormaPagoUsuarioDTO.class);

            return formaPagoUsuarioDTO ;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        formaPagoUsuarioRepositorio.deleteById(id);
    }
}
