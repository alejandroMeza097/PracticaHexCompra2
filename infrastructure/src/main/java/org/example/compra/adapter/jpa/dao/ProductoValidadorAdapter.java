package org.example.compra.adapter.jpa.dao;

import lombok.RequiredArgsConstructor;
import org.example.compra.port.dao.ProductoDatosDao;
import org.example.compra.port.dao.ProductoValidacionDao;
import org.example.producto.adapter.jpa.ProductoSpringJpaAdapterRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoValidadorAdapter implements ProductoValidacionDao {
    private final ProductoSpringJpaAdapterRepository productoSpringJpaAdapterRepository;
    @Override
    public boolean existeProducto(Long productoId) {
        return productoSpringJpaAdapterRepository.existsById(productoId);
    }
}
