package org.example.producto.service;


import lombok.RequiredArgsConstructor;
import org.example.cliente.model.entity.Cliente;
import org.example.producto.model.entity.Producto;
import org.example.producto.port.repository.ProductoRepository;

@RequiredArgsConstructor
public class ProductoUpdateService {
    private final ProductoRepository productoRepository;

    public Producto execute(Long id, Producto producto){
        return productoRepository.update(id,producto);
    }
}
