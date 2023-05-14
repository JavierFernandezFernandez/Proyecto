package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.MarcaDTO;
import com.proyecto.TFG.modelos.Marca;
import com.proyecto.TFG.repositorios.MarcaRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MarcaServicioImpl implements IMarcaServicio{

    @Autowired
    MarcaRepositorio marcaRepositorio;

    @Override
    public List<MarcaDTO> obtenerTodo() {

        List<Marca> marcas = marcaRepositorio.findAll();
        List<MarcaDTO> marcasDTO = new ArrayList<>();
        if (!marcas.isEmpty()) {

            marcasDTO = ModelMapperUtil.transformDtoList(marcas, MarcaDTO.class);
        }

        return marcasDTO;

    }

    @Override
    public MarcaDTO guardar(MarcaDTO marca) {

        Marca marcaEnti = ModelMapperUtil.transformDto(marca, Marca.class);

        return ModelMapperUtil.transformDto(marcaRepositorio.save(marcaEnti), MarcaDTO.class);

    }

    @Override
    public MarcaDTO obtenerPorId(long id) {

        Optional<Marca> marca = marcaRepositorio.findById(id);
        MarcaDTO marcaDTO = new MarcaDTO();

        if (marca.isPresent()) {

            marcaDTO = ModelMapperUtil.transformDto(marca.get(), MarcaDTO.class);

            return marcaDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        marcaRepositorio.deleteById(id);
    }
}
