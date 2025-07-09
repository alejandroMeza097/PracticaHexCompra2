package org.example.producto.command;


import lombok.RequiredArgsConstructor;
import org.example.producto.mapper.ProductoDtoMapper;
import org.example.producto.model.dto.ProductoDto;
import org.example.producto.model.entity.Producto;
import org.example.producto.service.ProductoUpdateService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductoUpdateHandler {
    private final ProductoDtoMapper productoDtoMapper;
    private final ProductoUpdateService productoUpdateService;

    public ProductoDto execute(Long id, Producto updateProducto){
        return productoDtoMapper.toDto(productoUpdateService.execute(id,updateProducto));
    }
}
