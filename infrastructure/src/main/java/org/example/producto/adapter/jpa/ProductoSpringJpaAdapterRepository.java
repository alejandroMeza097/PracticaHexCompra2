package org.example.producto.adapter.jpa;


import org.example.producto.adapter.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoSpringJpaAdapterRepository extends JpaRepository<ProductoEntity,Long> {
    ProductoEntity getById(Long id);
    boolean existsByNombre(String nombre);
}
