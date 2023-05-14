package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.RolDTO;
import com.proyecto.TFG.modelos.Rol;
import com.proyecto.TFG.repositorios.RolRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolServicioImpl implements IRolServicio {

    @Autowired
    RolRepositorio rolRepositorio;

    @Override
    public List<RolDTO> obtenerTodo() {

        List<Rol> roles = rolRepositorio.findAll();
        List<RolDTO> rolesDTO = new ArrayList<>();
        if (!roles.isEmpty()) {

            rolesDTO = ModelMapperUtil.transformDtoList(roles, RolDTO.class);
        }

        return rolesDTO;

    }

    @Override
    public RolDTO guardar(RolDTO rol) {

        Rol rolEnti = ModelMapperUtil.transformDto(rol, Rol.class);

        return ModelMapperUtil.transformDto(rolRepositorio.save(rolEnti), RolDTO.class);

    }

    @Override
    public RolDTO obtenerPorId(long id) {

        Optional<Rol> rol = rolRepositorio.findById(id);
        RolDTO rolDTO = new RolDTO();

        if (rol.isPresent()) {

            rolDTO = ModelMapperUtil.transformDto(rol.get(), RolDTO.class);

            return rolDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        rolRepositorio.deleteById(id);
    }
}
