package org.example.producto.command;


import lombok.RequiredArgsConstructor;
import org.example.producto.mapper.ProductoDtoMapper;
import org.example.producto.model.dto.ProductoDto;
import org.example.producto.service.ProductoDeleteService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductoDeleteHandler {

    private final ProductoDtoMapper productoDtoMapper;
    private final ProductoDeleteService productoDeleteService;

    public void execute(Long id){
        productoDeleteService.execute(id);
    }
}
