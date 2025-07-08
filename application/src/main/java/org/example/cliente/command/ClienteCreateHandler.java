package org.example.cliente.command;

import lombok.RequiredArgsConstructor;
import org.example.cliente.mapper.ClienteDtoMapper;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.model.dto.command.ClienteCreateCommand;
import org.example.cliente.service.ClienteCreateService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClienteCreateHandler {
    private final ClienteDtoMapper clienteDtoMapper;
    private final ClienteCreateService clienteCreateService;

    public ClienteDto execute(ClienteCreateCommand clienteCreateCommand){
        return clienteDtoMapper.toDto(clienteCreateService.execute(clienteCreateCommand));
    }
}
