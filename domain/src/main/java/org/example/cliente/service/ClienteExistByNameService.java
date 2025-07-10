package org.example.cliente.service;

import lombok.RequiredArgsConstructor;
import org.example.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteExistByNameService {
    private final ClienteRepository clienteRepository;

    public boolean execute(String nombre){
        return clienteRepository.existsByNombre(nombre);
    }

}
