package org.example.cliente.port.repository;

import org.example.cliente.model.entity.Cliente;

public interface ClienteRepository {
    Cliente create(Cliente cliente);
    Cliente update(Long id,Cliente cliente);
    void delete(Long id);
}
