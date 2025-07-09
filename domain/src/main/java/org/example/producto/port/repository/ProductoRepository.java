package org.example.producto.port.repository;

import org.example.cliente.model.entity.Cliente;
import org.example.producto.model.entity.Producto;

public interface ProductoRepository {
    Producto create(Producto producto);
    Producto update(Long id, Producto producto);
    void delete(Long id);
}
