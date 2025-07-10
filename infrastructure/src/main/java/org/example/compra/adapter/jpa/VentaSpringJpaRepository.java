package org.example.compra.adapter.jpa;

import org.example.compra.adapter.entiy.VentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaSpringJpaRepository extends JpaRepository<VentaEntity,Long> {
}
