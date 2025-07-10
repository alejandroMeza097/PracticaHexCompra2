package org.example.cliente.service;

import lombok.RequiredArgsConstructor;
import org.example.cliente.model.dto.command.ClienteCreateCommand;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.model.exception.ClienteException;
import org.example.cliente.model.exception.ClienteIlegalInputException;
import org.example.cliente.port.repository.ClienteRepository;
import org.example.message.port.MessageRepository;

@RequiredArgsConstructor
public class ClienteCreateService {

    //se inyecta clienteRepository
    private final ClienteRepository clienteRepository;
    private final MessageRepository messageRepository;

    public Cliente execute(ClienteCreateCommand clienteCreateCommand){
        validarCliente(clienteCreateCommand);

        Cliente clienteToCreate = new Cliente().requestToCreate(clienteCreateCommand);

        messageRepository.publishMessage("Cliente creado : " + clienteToCreate.toString());
        return  clienteRepository.create(clienteToCreate);
    }

    private void validarCliente(ClienteCreateCommand clienteCreateCommand){
        if(clienteCreateCommand.getNombre() == null || clienteCreateCommand.getNombre().isBlank()){
            throw new ClienteIlegalInputException("El campo nombres es obligatorio");
        }
        if(clienteCreateCommand.getApellido() == null || clienteCreateCommand.getApellido().isBlank()){
            throw new ClienteIlegalInputException("El campo apellido es obligatorio");
        }
        if(clienteCreateCommand.getEmail() == null || clienteCreateCommand.getEmail().isBlank()){
            throw new ClienteIlegalInputException("El campo email es obligatorio");
        }
        if(clienteCreateCommand.getTelefono() == null || clienteCreateCommand.getTelefono().isBlank()){
            throw new ClienteIlegalInputException("El campo telefono es obligatorio");
        }
        if(clienteCreateCommand.getDireccion() == null || clienteCreateCommand.getDireccion().isBlank()){
            throw new ClienteIlegalInputException("El campo direccion es obligatorio");
        }

        if(clienteRepository.existsByEmail(clienteCreateCommand.getEmail())){
            throw new ClienteException("Email registrado anteriormente");
        }
        if(clienteRepository.existsByNombre(clienteCreateCommand.getNombre())){
            throw  new ClienteException("Nombre registrado anteriormente");
        }

    }

}
