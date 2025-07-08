package org.example.cliente.adapter.jpa;

import org.example.cliente.adapter.entity.ClienteEntity;
import org.example.cliente.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteSpringJpaAdapterRepository extends JpaRepository<ClienteEntity,Long> {
    ClienteEntity getById(Long id);
}
