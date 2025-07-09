package org.example.producto.command;


import lombok.RequiredArgsConstructor;
import org.example.cliente.mapper.ClienteDtoMapper;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.model.dto.command.ClienteCreateCommand;
import org.example.cliente.service.ClienteCreateService;
import org.example.producto.mapper.ProductoDtoMapper;
import org.example.producto.model.dto.ProductoDto;
import org.example.producto.model.dto.command.ProductoCreateCommand;
import org.example.producto.service.ProductoCreateService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductoCreateHandler {
    private final ProductoDtoMapper productoDtoMapper;
    private final ProductoCreateService productoCreateService;

    public ProductoDto execute(ProductoCreateCommand productoCreateCommand){
        return productoDtoMapper.toDto(productoCreateService.execute(productoCreateCommand));
    }
}
