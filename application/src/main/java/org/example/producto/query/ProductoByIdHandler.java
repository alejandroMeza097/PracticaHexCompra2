package org.example.producto.query;
import lombok.RequiredArgsConstructor;
import org.example.producto.mapper.ProductoDtoMapper;
import org.example.producto.model.dto.ProductoDto;
import org.example.producto.model.exception.ProductoNotFoundException;
import org.example.producto.service.ProductoByIdService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductoByIdHandler {

    private final ProductoDtoMapper productoDtoMapper;
    private final ProductoByIdService productoByIdService;

    public ProductoDto execute(Long id){

        return productoDtoMapper.toDto(productoByIdService.execute(id));
    }
}
