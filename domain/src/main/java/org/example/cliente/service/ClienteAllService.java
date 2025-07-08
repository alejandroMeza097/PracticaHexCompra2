package org.example.cliente.service;


import lombok.RequiredArgsConstructor;
import org.example.cliente.model.entity.Cliente;
import org.example.cliente.port.dao.ClienteDao;

import java.util.List;

@RequiredArgsConstructor

public class ClienteAllService {

    //se realiza la inyeccion del ClienteDao
    private final ClienteDao clienteDao;

    public List<Cliente> execute(){
        return clienteDao.getAll();
    }

}
