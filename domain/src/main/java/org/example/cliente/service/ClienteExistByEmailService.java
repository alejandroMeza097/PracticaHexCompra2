package org.example.cliente.service;
import lombok.RequiredArgsConstructor;
import org.example.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteExistByEmailService {

    private final ClienteRepository clienteRepository;

    public boolean execute(String email){
        return clienteRepository.existsByEmail(email);
    }
}
