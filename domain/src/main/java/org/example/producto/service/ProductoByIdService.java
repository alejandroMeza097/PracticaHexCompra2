package org.example.producto.service;


import lombok.RequiredArgsConstructor;
import org.example.cliente.model.entity.Cliente;
import org.example.producto.model.entity.Producto;
import org.example.producto.port.dao.ProductoDao;

@RequiredArgsConstructor
public class ProductoByIdService {

    private final ProductoDao productoDao;

    public Producto execute(Long id){
        return  productoDao.getById(id);
    }
}
