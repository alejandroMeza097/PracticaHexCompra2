package org.example.producto.query;


import lombok.RequiredArgsConstructor;
import org.example.producto.mapper.ProductoDtoMapper;
import org.example.producto.port.dao.ProductoDao;
import org.example.producto.service.ProductoExistByNameService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoExistByNameHandler {
    private final ProductoExistByNameService productoExistByNameService;

    public boolean execute(String nombre){
        return productoExistByNameService.execute(nombre);
    }
}
