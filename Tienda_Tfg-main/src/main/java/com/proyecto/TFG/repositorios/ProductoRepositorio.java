package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    List<Producto> findByMarcaId(Long marcaId);

    List<Producto> findByCategoriaId(Long categoriaId);

    List<Producto> findByNombreContaining(String texto);

}
