package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.EjemplarDTO;
import com.proyecto.TFG.modelos.Ejemplar;
import com.proyecto.TFG.repositorios.EjemplarRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EjemplarServicioImpl implements IEjemplarServicio{

    @Autowired
    EjemplarRepositorio ejemplarRepositorio;

    @Override
    public List<EjemplarDTO> obtenerTodo() {

        List<Ejemplar> categorias = ejemplarRepositorio.findAll();
        List<EjemplarDTO> ejemplaresDTO = new ArrayList<>();
        if (!categorias.isEmpty()) {

            ejemplaresDTO = ModelMapperUtil.transformDtoList(categorias, EjemplarDTO.class);
        }

        return ejemplaresDTO;

    }

    @Override
    public EjemplarDTO guardar(EjemplarDTO ejemplar) {

        Ejemplar ejemplarEnti = ModelMapperUtil.transformDto(ejemplar, Ejemplar.class);

        return ModelMapperUtil.transformDto(ejemplarRepositorio.save(ejemplarEnti), EjemplarDTO.class);
    }

    @Override
    public EjemplarDTO obtenerPorId(long id) {

        Optional<Ejemplar> ejemplar = ejemplarRepositorio.findById(id);
        EjemplarDTO ejemplarDTO = new EjemplarDTO();

        if (ejemplar.isPresent()) {

            ejemplarDTO = ModelMapperUtil.transformDto(ejemplar.get(), EjemplarDTO.class);

            return ejemplarDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        ejemplarRepositorio.deleteById(id);
    }

}
