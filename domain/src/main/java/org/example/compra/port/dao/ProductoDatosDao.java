package org.example.compra.port.dao;

import org.example.producto.model.entity.Producto;

public interface ProductoDatosDao {
    Producto obtenerDatos(Long id);
}
