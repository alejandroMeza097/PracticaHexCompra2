package org.example.cliente.rest.controller;
import org.example.cliente.command.ClienteCreateHandler;
import org.example.cliente.command.ClienteDeleteHandler;
import org.example.cliente.command.ClienteUpdateHandler;
import org.example.cliente.model.dto.ClienteDto;
import org.example.cliente.model.dto.command.ClienteCreateCommand;
import org.example.cliente.model.entity.Cliente;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clientes")
public class ClienteCommandController {

    private final ClienteCreateHandler clienteCreateHandler;
    private final ClienteDeleteHandler clienteDeleteHandler;
    private final ClienteUpdateHandler clienteUpdateHandler;

    public ClienteCommandController(ClienteCreateHandler clienteCreateHandler, ClienteDeleteHandler clienteDeleteHandler, ClienteUpdateHandler clienteUpdateHandler) {
        this.clienteCreateHandler = clienteCreateHandler;
        this.clienteDeleteHandler = clienteDeleteHandler;
        this.clienteUpdateHandler = clienteUpdateHandler;
    }

    @PostMapping
    public ClienteDto addCliente(@RequestBody ClienteCreateCommand clienteCreateCommand){
        return clienteCreateHandler.execute(clienteCreateCommand);
    }
    @PutMapping("/{id}")
    public ClienteDto updateCliente(@PathVariable("id") Long id,@RequestBody Cliente updateCliente){
        return clienteUpdateHandler.execute(id, updateCliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable("id") Long id){
            clienteDeleteHandler.execute(id);
        }

}
