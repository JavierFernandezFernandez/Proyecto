package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.DireccionDTO;
import com.proyecto.TFG.modelos.Direccion;
import com.proyecto.TFG.repositorios.DireccionRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DireccionServicioImpl implements IDireccionServicio {

    @Autowired
    DireccionRepositorio direccionRepositorio;

    @Override
    public List<DireccionDTO> obtenerTodo() {

        List<Direccion> direcciones = direccionRepositorio.findAll();
        List<DireccionDTO> direccionesDTO = new ArrayList<>();
        if (!direcciones.isEmpty()) {

            direccionesDTO = ModelMapperUtil.transformDtoList(direcciones, DireccionDTO.class);
        }

        return direccionesDTO;
    }

    @Override
    public DireccionDTO guardar(DireccionDTO direccion) {

        Direccion direccionEnti = ModelMapperUtil.transformDto(direccion, Direccion.class);

        return ModelMapperUtil.transformDto(direccionRepositorio.save(direccionEnti), DireccionDTO.class);

    }

    @Override
    public DireccionDTO obtenerPorId(long id) {

        Optional<Direccion> direccion = direccionRepositorio.findById(id);
        DireccionDTO direccionDTO = new DireccionDTO();

        if (direccion.isPresent()) {

            direccionDTO = ModelMapperUtil.transformDto(direccion.get(), DireccionDTO.class);

            return direccionDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        direccionRepositorio.deleteById(id);
    }
}
