package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.FormaPagoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagoUsuarioRepositorio extends JpaRepository<FormaPagoUsuario, Long> {

    List<FormaPagoUsuario> findByUsuarioId(Long usuarioId);

    List<FormaPagoUsuario> findByFormaPagoId(Long formaPagoId);

}
