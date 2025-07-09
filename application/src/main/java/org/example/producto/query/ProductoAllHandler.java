package org.example.producto.query;


import lombok.RequiredArgsConstructor;
import org.example.producto.mapper.ProductoDtoMapper;
import org.example.producto.model.dto.ProductoDto;
import org.example.producto.service.ProductoAllService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Component
public class ProductoAllHandler {
    private final ProductoDtoMapper productoDtoMapper;
    private final ProductoAllService productoAllService;

    public List<ProductoDto> execute(){
        return productoAllService.execute().stream().map(productoDtoMapper::toDto).collect(Collectors.toList());
    }
}
