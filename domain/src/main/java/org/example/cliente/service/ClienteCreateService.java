package org.example.cliente.service;

import lombok.RequiredArgsConstructor;
import org.example.cliente.model.dto.command.ClienteCreateCommand;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.port.repository.ClienteRepository;

@RequiredArgsConstructor
public class ClienteCreateService {

    //se inyecta clienteRepository
    private final ClienteRepository clienteRepository;
    public Cliente execute(ClienteCreateCommand clienteCreateCommand){
        Cliente clienteToCreate = new Cliente().requestToCreate(clienteCreateCommand);
        return  clienteRepository.create(clienteToCreate);
    }

}
