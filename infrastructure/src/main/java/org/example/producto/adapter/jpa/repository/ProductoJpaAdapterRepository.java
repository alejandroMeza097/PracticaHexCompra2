package org.example.producto.adapter.jpa.repository;

import org.example.cliente.model.exception.ClienteException;
import org.example.producto.adapter.entity.ProductoEntity;
import org.example.producto.adapter.jpa.ProductoSpringJpaAdapterRepository;
import org.example.producto.adapter.mapper.ProductoMapper;
import org.example.producto.model.entity.Producto;
import org.example.producto.model.exception.ProductoNotFoundException;
import org.example.producto.port.repository.ProductoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    public Producto update(Long id, Producto updatedProduct) {

        Optional<ProductoEntity> optionalProduct =   productoSpringJpaAdapterRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw  new ProductoNotFoundException("Porducto NO encontrado");
        }
        ProductoEntity productoEntity = optionalProduct.get();

        productoEntity.setStock(updatedProduct.getStock());
        productoEntity.setNombre(updatedProduct.getNombre());
        productoEntity.setPrecio(updatedProduct.getPrecio());


        ProductoEntity updatedEntity = productoSpringJpaAdapterRepository.save(productoEntity);

        return productoMapper.toDomain(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        productoSpringJpaAdapterRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String nombre) {
        return productoSpringJpaAdapterRepository.existsByNombre(nombre);
    }
}
