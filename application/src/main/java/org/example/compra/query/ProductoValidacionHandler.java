package org.example.compra.query;


import lombok.RequiredArgsConstructor;
import org.example.compra.mapper.VentaDtoMapper;
import org.example.compra.service.ProductoValidacionService;

@RequiredArgsConstructor
public class ProductoValidacionHandler {
    private final ProductoValidacionService productoValidacionService;
    private final VentaDtoMapper ventaDtoMapper;

    public boolean execute(Long id){
        return productoValidacionService.execute(id);
    }
}
