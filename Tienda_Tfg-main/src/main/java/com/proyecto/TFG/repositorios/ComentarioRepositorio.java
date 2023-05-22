package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepositorio extends JpaRepository<Comentario, Long> {

    List<Comentario> findByUsuarioId(long usuarioId);

    List<Comentario> findByProductoId(long productoId);

}
