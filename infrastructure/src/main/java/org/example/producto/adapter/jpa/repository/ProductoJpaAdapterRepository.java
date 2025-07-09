package org.example.producto.adapter.jpa.repository;

import org.example.cliente.model.exception.ClienteException;
import org.example.producto.adapter.jpa.ProductoSpringJpaAdapterRepository;
import org.example.producto.adapter.mapper.ProductoMapper;
import org.example.producto.model.entity.Producto;
import org.example.producto.port.repository.ProductoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoJpaAdapterRepository implements ProductoRepository {

    private final ProductoSpringJpaAdapterRepository productoSpringJpaAdapterRepository;
    private final ProductoMapper productoMapper;

    public ProductoJpaAdapterRepository(ProductoSpringJpaAdapterRepository productoSpringJpaAdapterRepository, ProductoMapper productoMapper) {
        this.productoSpringJpaAdapterRepository = productoSpringJpaAdapterRepository;
        this.productoMapper = productoMapper;
    }

    @Override
    public Producto create(Producto producto) {
        return productoMapper.toDomain(productoSpringJpaAdapterRepository.save(productoMapper.toEntity(producto)));
    }

    @Override
    public Producto update(Long id, Producto producto) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if(!productoSpringJpaAdapterRepository.existsById(id)){
            throw new ClienteException("Producto NO encontrado");
        }
        productoSpringJpaAdapterRepository.deleteById(id);
    }
}
