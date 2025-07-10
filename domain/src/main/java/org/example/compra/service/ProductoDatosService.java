package org.example.compra.service;

import lombok.RequiredArgsConstructor;
import org.example.compra.port.dao.ProductoDatosDao;
import org.example.producto.model.entity.Producto;

@RequiredArgsConstructor
public class ProductoDatosService {
    private final ProductoDatosDao productoDatosDao;

    public Producto execute(Long id){
        return productoDatosDao.obtenerDatos(id);
    }
}
