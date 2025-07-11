package org.example.cliente.adapter.jpa.dao;

import org.example.cliente.adapter.jpa.ClienteSpringJpaAdapterRepository;
import org.example.cliente.adapter.mapper.ClienteMapper;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.port.dao.ClienteDao;
import org.example.cliente.port.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClienteJpaAdapterDao implements ClienteDao {
    private final ClienteSpringJpaAdapterRepository clienteSpringJpaAdapterRepository;
    private final ClienteMapper clienteMapper;

    public ClienteJpaAdapterDao(ClienteSpringJpaAdapterRepository clienteSpringJpaAdapterRepository, ClienteMapper clienteMapper) {
        this.clienteSpringJpaAdapterRepository = clienteSpringJpaAdapterRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Cliente getById(Long id) {
        return clienteSpringJpaAdapterRepository.findById(id).map(clienteMapper::toDomain).orElse(null);
    }

    @Override
    public List<Cliente> getAll() {
        return clienteSpringJpaAdapterRepository.findAll().stream().map(clienteMapper::toDomain).collect(Collectors.toList());
    }
}
