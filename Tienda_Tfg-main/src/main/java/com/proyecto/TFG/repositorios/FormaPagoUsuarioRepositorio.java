package com.proyecto.TFG.repositorios;

import com.proyecto.TFG.modelos.Factura;
import com.proyecto.TFG.modelos.FormaPagoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagoUsuarioRepositorio extends JpaRepository<FormaPagoUsuario, Long> {
}
