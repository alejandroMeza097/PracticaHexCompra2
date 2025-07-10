package org.example.compra.adapter.jpa.dao;

import lombok.RequiredArgsConstructor;
import org.example.compra.port.dao.ProductoDatosDao;
import org.example.producto.adapter.jpa.ProductoSpringJpaAdapterRepository;
import org.example.producto.adapter.mapper.ProductoMapper;
import org.example.producto.model.entity.Producto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoDatosAdapter implements ProductoDatosDao {
    private final ProductoSpringJpaAdapterRepository productoSpringJpaAdapterRepository;
    private final ProductoMapper productoMapper;

    @Override
    public Producto obtenerDatos(Long id) {
        return productoMapper.toDomain(productoSpringJpaAdapterRepository.getById(id));
    }
}
