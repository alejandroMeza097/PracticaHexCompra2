package org.example.cliente.query;

import lombok.RequiredArgsConstructor;
import org.example.cliente.service.ClienteExistByNameService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteExistByNameHandler {
    private final ClienteExistByNameService clienteExistByNameService;

    public boolean execute(String nombre){
        return clienteExistByNameService.execute(nombre);
    }
}
