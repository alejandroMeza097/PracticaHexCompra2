package org.example.cliente.query;

import lombok.RequiredArgsConstructor;
import org.example.cliente.mapper.ClienteDtoMapper;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.service.ClienteByIdService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClienteByIdHandler {
    private final ClienteDtoMapper clienteDtoMapper;
    private final ClienteByIdService clienteByIdService;

    public ClienteDto execute(Long id){
        return clienteDtoMapper.toDto(clienteByIdService.execute(id));
    }
}
