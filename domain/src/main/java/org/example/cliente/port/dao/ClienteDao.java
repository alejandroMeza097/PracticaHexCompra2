package org.example.cliente.port.dao;

import org.example.cliente.model.entity.Cliente;

import java.util.List;

public interface ClienteDao {
    Cliente getById(Long id);
    List<Cliente> getAll();
}
