package org.example.producto.service;


import lombok.RequiredArgsConstructor;
import org.example.cliente.model.entity.Cliente;
import org.example.producto.model.entity.Producto;
import org.example.producto.port.dao.ProductoDao;

import java.util.List;

@RequiredArgsConstructor
public class ProductoAllService {

    private final ProductoDao productoDao;


    public List<Producto> execute(){
        return productoDao.getAll();
    }
}
