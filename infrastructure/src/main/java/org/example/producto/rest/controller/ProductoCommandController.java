package org.example.producto.rest.controller;


import org.example.producto.command.ProductoCreateHandler;
import org.example.producto.command.ProductoDeleteHandler;
import org.example.producto.command.ProductoUpdateHandler;
import org.example.producto.model.dto.ProductoDto;
import org.example.producto.model.dto.command.ProductoCreateCommand;
import org.example.producto.model.entity.Producto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoCommandController {

    private final ProductoCreateHandler productoCreateHandler;
    private final ProductoDeleteHandler productoDeleteHandler;
    private final ProductoUpdateHandler productoUpdateHandler;

    public ProductoCommandController(ProductoCreateHandler productoCreateHandler,
                                     ProductoDeleteHandler productoDeleteHandler,
                                     ProductoUpdateHandler productoUpdateHandler) {
        this.productoCreateHandler = productoCreateHandler;
        this.productoDeleteHandler = productoDeleteHandler;
        this.productoUpdateHandler = productoUpdateHandler;
    }

    @PostMapping
    public ProductoDto addProducto(@RequestBody ProductoCreateCommand productoCreateCommand){
        return productoCreateHandler.execute(productoCreateCommand);
    }

    @PutMapping
    public ProductoDto updateProducto(@PathVariable Long id,@RequestBody Producto updateProducto){
        return  productoUpdateHandler.execute(id,updateProducto);
    }

    @DeleteMapping
    public void deleteProducto(Long id){
        productoDeleteHandler.execute(id);
    }
}
