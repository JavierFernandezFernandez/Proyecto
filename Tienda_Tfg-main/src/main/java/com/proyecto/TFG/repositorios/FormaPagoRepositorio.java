package com.proyecto.TFG.repositorios;


import com.proyecto.TFG.modelos.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagoRepositorio extends JpaRepository<FormaPago, Long> {
}
