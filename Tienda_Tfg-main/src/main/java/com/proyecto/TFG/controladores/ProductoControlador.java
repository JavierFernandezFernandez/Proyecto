package com.proyecto.TFG.controladores;

import com.proyecto.TFG.dtos.EjemplarDTO;
import com.proyecto.TFG.dtos.EjemplarDTOL;
import com.proyecto.TFG.dtos.ProductoDTO;
import com.proyecto.TFG.modelos.Producto;
import com.proyecto.TFG.servicios.EjemplarServicioImpl;
import com.proyecto.TFG.servicios.ProductoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
public class ProductoControlador {

    @Autowired
    ProductoServicioImpl productoServicio;

    @Autowired
    EjemplarServicioImpl ejemplarServicio;

    @GetMapping("/listar")
    public List<ProductoDTO> obtenerProductos(){
        return productoServicio.obtenerTodo();
    }

    @GetMapping("/nombre/{texto}")
    public List<ProductoDTO> obtenerProductosByNombreContains(@PathVariable String texto){
        return productoServicio.findByNombreContaining(texto);
    }

    @GetMapping("/marca/{marcaId}")
    public List<ProductoDTO> obtenerProductoByMarca(@PathVariable Long marcaId){
        return productoServicio.findByCategoriaId(marcaId);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<ProductoDTO> obtenerProductosByCategoria(@PathVariable Long categoriaId){
        return productoServicio.findByCategoriaId(categoriaId);
    }

    @GetMapping("/random/{num}")
    public List<ProductoDTO> obtenerProductosRamdon(@PathVariable int num){

        List<ProductoDTO> productosRandom = new ArrayList<>();
        List<ProductoDTO> productos = productoServicio.obtenerTodo();
        int numProductos = productos.size();

        for (int i = 0; i < num; i++) {

            Random random = new Random();
            int randomNumber = random.nextInt(numProductos);

            List<EjemplarDTO> listaEjemplares = ejemplarServicio.findByProductoId(productos.get(randomNumber).getId());

            if (listaEjemplares.size() > 0){
                productosRandom.add(productos.get(randomNumber));
            }else{
                i --;
            }

        }

        return productosRandom;

    }

    @GetMapping("/random/categoria/{categoriaId}/{num}")
    public List<ProductoDTO> obtenerProductosRamdonByCategoria(@PathVariable Long categoriaId, @PathVariable int num){

        List<ProductoDTO> productosRandom = new ArrayList<>();
        List<ProductoDTO> productos = productoServicio.findByCategoriaId(categoriaId);
        int numProductos = productos.size();

        for (int i = 0; i < num; i++) {

            Random random = new Random();
            int randomNumber = random.nextInt(numProductos);

            List<EjemplarDTO> listaEjemplares = ejemplarServicio.findByProductoId(productos.get(randomNumber).getId());

            if (listaEjemplares.size() > 0){
                productosRandom.add(productos.get(randomNumber));
            }else{
                i --;
            }

        }

        return productosRandom;

    }

    @GetMapping("/random/marca/{marcaId}/{num}")
    public List<ProductoDTO> obtenerProductosRamdonByMarca(@PathVariable long marcaId,@PathVariable int num){

        List<ProductoDTO> productosRandom = new ArrayList<>();
        List<ProductoDTO> productos = productoServicio.findByMarcaId(marcaId);
        int numProductos = productos.size();

        for (int i = 0; i < num; i++) {

            Random random = new Random();
            int randomNumber = random.nextInt(numProductos);

            List<EjemplarDTO> listaEjemplares = ejemplarServicio.findByProductoId(productos.get(randomNumber).getId());

            if (listaEjemplares.size() > 0){
            productosRandom.add(productos.get(randomNumber));
            }else{
                i --;
            }

        }

        return productosRandom;

    }

    @PostMapping("/guardar")
    public ResponseEntity<ProductoDTO> guardarProducto(@RequestBody ProductoDTO producto){
        productoServicio.guardar(producto);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerProducto(@PathVariable Long id){
        ProductoDTO productoId = productoServicio.obtenerPorId(id);
        return ResponseEntity.ok(productoId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> eliminarProducto(@PathVariable Long id){
        this.productoServicio.eliminar(id);

        HashMap<String, Boolean> estadoProductoEliminado = new HashMap<>();
        estadoProductoEliminado.put("eliminado", true);
        return  ResponseEntity.ok(estadoProductoEliminado);
    }

}
