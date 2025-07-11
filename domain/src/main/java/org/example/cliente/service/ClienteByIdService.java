package org.example.cliente.service;

import lombok.RequiredArgsConstructor;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.model.exception.ClienteNotFoundException;
import org.example.cliente.port.dao.ClienteDao;

@RequiredArgsConstructor
public class ClienteByIdService {

    private final ClienteDao clienteDao;

    public Cliente execute(Long id){

        Cliente cliente = clienteDao.getById(id);
        if(cliente == null){
            throw new ClienteNotFoundException("Cliente NO encontrado");
        }
        return cliente;
    }
}
