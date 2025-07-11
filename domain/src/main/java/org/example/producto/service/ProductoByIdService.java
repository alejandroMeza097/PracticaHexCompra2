package org.example.producto.service;


import lombok.RequiredArgsConstructor;
import org.example.cliente.model.entity.Cliente;
import org.example.producto.model.entity.Producto;
import org.example.producto.model.exception.ProductoNotFoundException;
import org.example.producto.port.dao.ProductoDao;

@RequiredArgsConstructor
public class ProductoByIdService {

    private final ProductoDao productoDao;

    public Producto execute(Long id){
        if(productoDao.getById(id) == null){
            throw  new ProductoNotFoundException("Producto NO encontrado");
        }
        return productoDao.getById(id);
    }
}
