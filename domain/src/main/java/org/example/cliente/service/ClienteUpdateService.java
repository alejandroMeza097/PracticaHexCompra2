package org.example.cliente.service;

import lombok.RequiredArgsConstructor;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteUpdateService {
    private final ClienteRepository clienteRepository;
    public Cliente execute(Long id,Cliente updateCliente){
        return clienteRepository.update(id,updateCliente);
    }
}
