package org.example.cliente.service;


import lombok.RequiredArgsConstructor;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteDeleteService {
    private final ClienteRepository clienteRepository;

    public void execute(Long id){
         clienteRepository.delete(id);
    }
}
