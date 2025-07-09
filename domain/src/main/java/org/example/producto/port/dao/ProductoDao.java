package org.example.producto.port.dao;

import org.example.cliente.model.entity.Cliente;
import org.example.producto.model.entity.Producto;

import java.util.List;

public interface ProductoDao {
    Producto getById(Long id);
    List<Producto> getAll();
}
