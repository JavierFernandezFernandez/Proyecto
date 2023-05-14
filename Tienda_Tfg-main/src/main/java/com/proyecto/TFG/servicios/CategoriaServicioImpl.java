package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.CategoriaDTO;
import com.proyecto.TFG.modelos.Categoria;
import com.proyecto.TFG.repositorios.CategoriaRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicioImpl implements ICategoriaServicio {

    @Autowired
    CategoriaRepositorio categoriaRepositorio;

    @Override
    public List<CategoriaDTO> obtenerTodo() {

        List<Categoria> categorias = categoriaRepositorio.findAll();
        List<CategoriaDTO> categoriasDTO = new ArrayList<>();
        if (!categorias.isEmpty()) {

            categoriasDTO = ModelMapperUtil.transformDtoList(categorias, CategoriaDTO.class);
        }

        return categoriasDTO;
    }

    @Override
    public CategoriaDTO guardar(CategoriaDTO categoria) {

        Categoria categoriaEnti = ModelMapperUtil.transformDto(categoria, Categoria.class);

        return ModelMapperUtil.transformDto(categoriaRepositorio.save(categoriaEnti), CategoriaDTO.class);
    }

    @Override
    public CategoriaDTO obtenerPorId(long id) {

        Optional<Categoria> categoria = categoriaRepositorio.findById(id);
        CategoriaDTO categoriaDTO = new CategoriaDTO();

        if (categoria.isPresent()) {

            categoriaDTO = ModelMapperUtil.transformDto(categoria.get(), CategoriaDTO.class);

            return categoriaDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        categoriaRepositorio.deleteById(id);
    }
}