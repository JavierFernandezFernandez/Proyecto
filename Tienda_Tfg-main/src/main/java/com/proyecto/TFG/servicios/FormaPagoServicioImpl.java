package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.FormaPagoDTO;
import com.proyecto.TFG.modelos.FormaPago;
import com.proyecto.TFG.repositorios.FormaPagoRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormaPagoServicioImpl implements IFormaPagoServicio{

    @Autowired
    FormaPagoRepositorio formaPagoRepositorio;

    @Override
    public List<FormaPagoDTO> obtenerTodo() {

        List<FormaPago> formaPagos = formaPagoRepositorio.findAll();
        List<FormaPagoDTO> formasPagosDTO = new ArrayList<>();
        if (!formaPagos.isEmpty()) {

            formasPagosDTO = ModelMapperUtil.transformDtoList(formaPagos, FormaPagoDTO.class);
        }

        return formasPagosDTO;

    }

    @Override
    public FormaPagoDTO guardar(FormaPagoDTO formaPago) {

        FormaPago formaPagoEnti = ModelMapperUtil.transformDto(formaPago, FormaPago.class);

        return ModelMapperUtil.transformDto(formaPagoRepositorio.save(formaPagoEnti), FormaPagoDTO.class);

    }

    @Override
    public FormaPagoDTO obtenerPorId(long id) {

        Optional<FormaPago> formaPago = formaPagoRepositorio.findById(id);
        FormaPagoDTO formaPagoDTO = new FormaPagoDTO();

        if (formaPago.isPresent()) {

            formaPagoDTO = ModelMapperUtil.transformDto(formaPago.get(), FormaPagoDTO.class);

            return formaPagoDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        formaPagoRepositorio.deleteById(id);
    }

}
