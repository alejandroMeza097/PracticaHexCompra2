package org.example.beanConfiguration;

import org.example.cliente.port.dao.ClienteDao;
import org.example.cliente.service.ClienteAllService;
import org.example.cliente.service.ClienteByIdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteDaoBean {
    @Bean
    public ClienteAllService clienteAllService(ClienteDao clienteDao){
        return new ClienteAllService(clienteDao);
    }

    @Bean
    public ClienteByIdService clienteByIdService(ClienteDao clienteDao){
        return new ClienteByIdService(clienteDao);
    }
}
