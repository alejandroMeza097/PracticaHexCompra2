package org.example.compra.service;


import lombok.RequiredArgsConstructor;
import org.example.compra.port.dao.ClienteValidacionDao;

@RequiredArgsConstructor
public class ClienteValidacionService {
    private final ClienteValidacionDao clienteValidacionDao;

    public boolean execute(Long id){
        return clienteValidacionDao.existeCliente(id);
    }
}
