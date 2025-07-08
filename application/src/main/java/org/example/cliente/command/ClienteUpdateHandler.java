package org.example.cliente.command;

import lombok.RequiredArgsConstructor;
import org.example.cliente.mapper.ClienteDtoMapper;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.service.ClienteUpdateService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClienteUpdateHandler {
    private final ClienteDtoMapper clienteDtoMapper;
    private final ClienteUpdateService clienteUpdateService;

    public ClienteDto execute(Long id, Cliente updateCliente){
        return clienteDtoMapper.toDto(clienteUpdateService.execute(id,updateCliente));
    }
}
