package org.example.cliente.query;


import lombok.RequiredArgsConstructor;
import org.example.cliente.service.ClienteExistByEmailService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class ClienteExistByEmailHandler {
    private final ClienteExistByEmailService clienteExistByEmailService;
    public boolean execute(String email){
        return clienteExistByEmailService.execute(email);
    }
}
