package org.example.producto.service;


import lombok.RequiredArgsConstructor;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.model.exception.ClienteNotFoundException;
import org.example.compra.port.dao.ProductoValidacionDao;
import org.example.producto.model.entity.Producto;
import org.example.producto.model.exception.ProductoNotFoundException;
import org.example.producto.port.dao.ProductoDao;

@RequiredArgsConstructor
public class ProductoByIdService {

    private final ProductoDao productoDao;
    private final ProductoValidacionDao productoValidacionDao;

    public Producto execute(Long id){
       if(!productoValidacionDao.existeProducto(id)){
           throw new ProductoNotFoundException("Producto NO encontrado");
       }
        return productoDao.getById(id);
    }
}
