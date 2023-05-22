package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.FPUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagoUsuarioRepositorio extends JpaRepository<FPUsuario, Long> {

    List<FPUsuario> findByUsuarioId(Long usuarioId);

    List<FPUsuario> findByFormaPagoId(Long formaPagoId);

}
