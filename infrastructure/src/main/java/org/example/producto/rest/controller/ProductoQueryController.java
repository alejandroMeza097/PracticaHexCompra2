package org.example.producto.rest.controller;


import org.example.cliente.model.dto.ClienteDto;
import org.example.producto.model.dto.ProductoDto;
import org.example.producto.model.exception.ProductoNotFoundException;
import org.example.producto.query.ProductoAllHandler;
import org.example.producto.query.ProductoByIdHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoQueryController {
    private final ProductoAllHandler productoAllHandler;
    private final ProductoByIdHandler productoByIdHandler;

    public ProductoQueryController(ProductoAllHandler productoAllHandler, ProductoByIdHandler productoByIdHandler) {
        this.productoAllHandler = productoAllHandler;
        this.productoByIdHandler = productoByIdHandler;
    }

    @GetMapping("/{id}")
    public ProductoDto getByIdProducto(@PathVariable("id") Long id){

        return productoByIdHandler.execute(id);
    }

    @GetMapping
    public List<ProductoDto> getAllProductos(){
        return productoAllHandler.execute();
    }
}
