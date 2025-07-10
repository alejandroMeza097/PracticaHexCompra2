package org.example.compra.query;

import lombok.RequiredArgsConstructor;
import org.example.compra.mapper.VentaDtoMapper;
import org.example.compra.service.ProductoDatosService;
import org.example.producto.model.entity.Producto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoDatosHandler {
    private final VentaDtoMapper ventaDtoMapper;
    private final ProductoDatosService productoDatosService;

    public Producto execute(Long id){
        return productoDatosService.execute(id);
    }

}
