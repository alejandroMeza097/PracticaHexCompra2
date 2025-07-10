package org.example.compra.service;

import lombok.RequiredArgsConstructor;
import org.example.compra.port.dao.ProductoValidacionDao;

@RequiredArgsConstructor
public class ProductoValidacionService {
    private final ProductoValidacionDao productoValidacionDao;
    public boolean execute(Long id){
        return productoValidacionDao.existeProducto(id);
    }
}
