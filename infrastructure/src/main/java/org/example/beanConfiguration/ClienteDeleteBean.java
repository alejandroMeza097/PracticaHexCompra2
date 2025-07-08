package org.example.beanConfiguration;


import org.example.cliente.port.repository.ClienteRepository;
import org.example.cliente.service.ClienteCreateService;
import org.example.cliente.service.ClienteDeleteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteDeleteBean {
    @Bean
    public ClienteDeleteService clienteDeleteServiceService(ClienteRepository clienteRepository) {
        return new ClienteDeleteService(clienteRepository);
    }
}
