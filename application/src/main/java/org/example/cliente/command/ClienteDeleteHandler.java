package org.example.cliente.command;

import lombok.RequiredArgsConstructor;
import org.example.cliente.mapper.ClienteDtoMapper;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.service.ClienteDeleteService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClienteDeleteHandler {
    private final ClienteDtoMapper clienteDtoMapper;
    private final ClienteDeleteService clienteDeleteService;

    public void execute(Long id){
        clienteDeleteService.execute(id);
    }
}
