package org.example.cliente.service;

import lombok.RequiredArgsConstructor;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.port.dao.ClienteDao;

@RequiredArgsConstructor
public class ClienteByIdService {

    private final ClienteDao clienteDao;
    public Cliente execute(Long id){
        return clienteDao.getById(id);
    }
}
