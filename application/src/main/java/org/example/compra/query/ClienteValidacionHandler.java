package org.example.compra.query;


import lombok.RequiredArgsConstructor;
import org.example.compra.mapper.VentaDtoMapper;
import org.example.compra.port.dao.ClienteValidacionDao;
import org.example.compra.service.ClienteValidacionService;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClienteValidacionHandler {
    private final VentaDtoMapper ventaDtoMapper;
    private final ClienteValidacionService clienteValidacionService;

    public boolean execute(Long id){
        return clienteValidacionService.execute(id);
    }
}
