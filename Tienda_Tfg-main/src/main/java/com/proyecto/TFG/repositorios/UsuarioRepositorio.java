package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findOneByEmail(String email);

    List<Usuario> findByRolId(Long rolId);

    Optional<Usuario> findByEmail(String email);

}
