package com.proyecto.TFG.servicios;

import com.proyecto.TFG.dtos.LineaFacturaDTO;
import com.proyecto.TFG.modelos.LineaFactura;
import com.proyecto.TFG.repositorios.LineaFacturaRepositorio;
import com.proyecto.TFG.utils.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LineaFacturaServicioImpl implements  ILineaFacturaServicio{

    @Autowired
    LineaFacturaRepositorio lineaFacturaRepositorio;

    @Override
    public List<LineaFacturaDTO> obtenerTodo() {

        List<LineaFactura> lineaFacturas = lineaFacturaRepositorio.findAll();
        List<LineaFacturaDTO> lineaFacturasDTO = new ArrayList<>();
        if (!lineaFacturas.isEmpty()) {

            lineaFacturasDTO = ModelMapperUtil.transformDtoList(lineaFacturas, LineaFacturaDTO.class);
        }

        return lineaFacturasDTO;

    }

    public List<LineaFacturaDTO> findByProductoId(Long productoId){
        List<LineaFactura> lineaFacturas = lineaFacturaRepositorio.findByProductoId(productoId);
        List<LineaFacturaDTO> lineaFacturasDTO = new ArrayList<>();
        if (!lineaFacturas.isEmpty()) {

            lineaFacturasDTO = ModelMapperUtil.transformDtoList(lineaFacturas, LineaFacturaDTO.class);
        }

        return lineaFacturasDTO;
    }

    public List<LineaFacturaDTO> findByFacturaId(Long facturaId){
        List<LineaFactura> lineaFacturas = lineaFacturaRepositorio.findByFacturaId(facturaId);
        List<LineaFacturaDTO> lineaFacturasDTO = new ArrayList<>();
        if (!lineaFacturas.isEmpty()) {

            lineaFacturasDTO = ModelMapperUtil.transformDtoList(lineaFacturas, LineaFacturaDTO.class);
        }

        return lineaFacturasDTO;
    }

    @Override
    public LineaFacturaDTO guardar(LineaFacturaDTO lineaFactura) {

        LineaFactura lineaFacturaEnti = ModelMapperUtil.transformDto(lineaFactura, LineaFactura.class);

        return ModelMapperUtil.transformDto(lineaFacturaRepositorio.save(lineaFacturaEnti), LineaFacturaDTO.class);

    }

    @Override
    public LineaFacturaDTO obtenerPorId(long id) {

        Optional<LineaFactura> lineaFactura = lineaFacturaRepositorio.findById(id);
        LineaFacturaDTO lineaFacturaDTO = new LineaFacturaDTO();

        if (lineaFactura.isPresent()) {

            lineaFacturaDTO = ModelMapperUtil.transformDto(lineaFactura.get(), LineaFacturaDTO.class);

            return lineaFacturaDTO;
        } else {

            return null;
        }

    }

    @Override
    public void eliminar(long id) {
        lineaFacturaRepositorio.deleteById(id);
    }
}
