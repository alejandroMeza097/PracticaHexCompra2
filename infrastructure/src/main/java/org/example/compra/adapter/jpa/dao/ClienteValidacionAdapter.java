package org.example.compra.adapter.jpa.dao;


import lombok.RequiredArgsConstructor;
import org.example.cliente.adapter.jpa.ClienteSpringJpaAdapterRepository;
import org.example.cliente.adapter.mapper.ClienteMapper;
import org.example.compra.port.dao.ClienteValidacionDao;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClienteValidacionAdapter implements ClienteValidacionDao {

    private final ClienteSpringJpaAdapterRepository clienteSpringJpaAdapterRepository;


    @Override
    public boolean existeCliente(Long idCliente) {
        return clienteSpringJpaAdapterRepository.existsById(idCliente);
    }
}
