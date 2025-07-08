package org.example.cliente.query;


import lombok.RequiredArgsConstructor;
import org.example.cliente.mapper.ClienteDtoMapper;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.service.ClienteAllService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ClienteAllHandler {

    private final ClienteDtoMapper clienteDtoMapper;
    private final ClienteAllService clienteAllService;

    public List<ClienteDto> execute(){
        return clienteAllService.execute().stream().map(clienteDtoMapper::toDto).collect(Collectors.toList());
    }
}
