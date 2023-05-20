package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.Direccion;
import com.proyecto.TFG.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DireccionRepositorio extends JpaRepository<Direccion, Long> {

    List<Direccion> findByUsuarioId(Long usuarioId);

}
