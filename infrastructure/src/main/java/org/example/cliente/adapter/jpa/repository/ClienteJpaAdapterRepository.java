package org.example.cliente.adapter.jpa.repository;

import org.example.cliente.adapter.entity.ClienteEntity;
import org.example.cliente.adapter.jpa.ClienteSpringJpaAdapterRepository;
import org.example.cliente.adapter.mapper.ClienteMapper;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.model.exception.ClienteException;
import org.example.cliente.port.repository.ClienteRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteJpaAdapterRepository implements ClienteRepository {

    private final ClienteSpringJpaAdapterRepository clienteSpringJpaAdapterRepository;
    private final ClienteMapper clienteMapper;

    public ClienteJpaAdapterRepository(ClienteSpringJpaAdapterRepository clienteSpringJpaAdapterRepository, ClienteMapper clienteMapper) {
        this.clienteSpringJpaAdapterRepository = clienteSpringJpaAdapterRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteMapper.toDomain(clienteSpringJpaAdapterRepository.save(clienteMapper.toEntity(cliente)));

    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
        ClienteEntity existingEntity = clienteSpringJpaAdapterRepository.findById(id).
                orElseThrow(()-> new ClienteException("Cliente NO encontrado"));
        existingEntity.setNombre(cliente.getNombre());
        existingEntity.setApellido(cliente.getApellido());
        existingEntity.setDireccion(cliente.getDireccion());
        existingEntity.setEmail(cliente.getEmail());
        existingEntity.setTelefono(cliente.getTelefono());
        ClienteEntity updatedCliente = clienteSpringJpaAdapterRepository.save(existingEntity);
        return clienteMapper.toDomain(updatedCliente);
    }

    @Override
    public void delete(Long id) {
        clienteSpringJpaAdapterRepository.deleteById(id);
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return clienteSpringJpaAdapterRepository.existsByNombre(nombre);
    }

    @Override
    public boolean existsByEmail(String email) {
        return clienteSpringJpaAdapterRepository.existsByEmail(email);
    }
}
