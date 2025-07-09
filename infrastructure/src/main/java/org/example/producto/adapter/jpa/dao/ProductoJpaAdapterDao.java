package org.example.producto.adapter.jpa.dao;


import org.example.producto.adapter.jpa.ProductoSpringJpaAdapterRepository;
import org.example.producto.adapter.mapper.ProductoMapper;
import org.example.producto.model.entity.Producto;
import org.example.producto.port.dao.ProductoDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductoJpaAdapterDao implements ProductoDao {

    private final ProductoSpringJpaAdapterRepository productoSpringJpaAdapterRepository;
    private final ProductoMapper productoMapper;

    public ProductoJpaAdapterDao(ProductoSpringJpaAdapterRepository productoSpringJpaAdapterRepository,
                                 ProductoMapper productoMapper) {
        this.productoSpringJpaAdapterRepository = productoSpringJpaAdapterRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public Producto getById(Long id) {
        return productoMapper.toDomain(productoSpringJpaAdapterRepository.getById(id));
    }

    @Override
    public List<Producto> getAll() {
        return productoSpringJpaAdapterRepository.findAll().stream().map(productoMapper::toDomain).collect(Collectors.toList());
    }
}
