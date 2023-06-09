package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.TiendaDTO;
import com.proyecto.TFG.modelos.Tienda;
import com.proyecto.TFG.repositorios.TiendaRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TiendaServicioImpl implements  ITiendaServicio{

    @Autowired
    TiendaRepositorio tiendaRepositorio;

    @Override
    public List<TiendaDTO> obtenerTodo() {

        List<Tienda> tiendas = tiendaRepositorio.findAll();
        List<TiendaDTO> tiendasDTO = new ArrayList<>();
        if (!tiendas.isEmpty()) {

            tiendasDTO = ModelMapperUtil.transformDtoList(tiendas, TiendaDTO.class);
        }

        return tiendasDTO;

    }

    @Override
    public TiendaDTO guardar(TiendaDTO tienda) {

        Tienda tiendaEnti = ModelMapperUtil.transformDto(tienda, Tienda.class);

        return ModelMapperUtil.transformDto(tiendaRepositorio.save(tiendaEnti), TiendaDTO.class);
    }

    @Override
    public TiendaDTO obtenerPorId(long id) {

        Optional<Tienda> tienda = tiendaRepositorio.findById(id);
        TiendaDTO tiendaDTO = new TiendaDTO();

        if (tienda.isPresent()) {

            tiendaDTO = ModelMapperUtil.transformDto(tienda.get(), TiendaDTO.class);

            return tiendaDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        tiendaRepositorio.deleteById(id);
    }
}
