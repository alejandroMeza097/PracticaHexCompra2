package org.example.cliente.rest.controller;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.query.ClienteAllHandler;
import org.example.cliente.query.ClienteByIdHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteQueryController {
    private final ClienteByIdHandler clienteByIdHandler;
    private final ClienteAllHandler clienteAllHandler;

    public ClienteQueryController(ClienteByIdHandler clienteByIdHandler, ClienteAllHandler clienteAllHandler){
        this.clienteAllHandler = clienteAllHandler;
        this.clienteByIdHandler = clienteByIdHandler;
    }

    @GetMapping
    public List<ClienteDto> getAllClientes(){
        return clienteAllHandler.execute();
    }

    @GetMapping("/{id}")
    public ClienteDto getByIdCliente(@PathVariable("id") Long id){
        return clienteByIdHandler.execute(id);
    }

}
