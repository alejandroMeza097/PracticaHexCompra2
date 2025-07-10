package org.example.compra.adapter.jpa.repository;

import org.example.compra.adapter.entiy.VentaEntity;
import org.example.compra.adapter.jpa.VentaSpringJpaRepository;
import org.example.compra.adapter.mapper.VentaMapper;
import org.example.compra.model.entity.Venta;
import org.example.compra.port.repository.VentaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VentaJpaAdapterRepository implements VentaRepository {
    private final VentaSpringJpaRepository ventaSpringJpaRepository;
    private final VentaMapper ventaMapper;

    public VentaJpaAdapterRepository(VentaSpringJpaRepository ventaSpringJpaRepository,
                                     VentaMapper ventaMapper) {
        this.ventaSpringJpaRepository = ventaSpringJpaRepository;
        this.ventaMapper = ventaMapper;
    }

    @Override
    public Venta guardarVenta(Venta venta) {
        VentaEntity ventaEntitySaved =  ventaSpringJpaRepository.save(ventaMapper.toEntity(venta));
        return ventaMapper.toDomain(ventaEntitySaved);
    }
}
