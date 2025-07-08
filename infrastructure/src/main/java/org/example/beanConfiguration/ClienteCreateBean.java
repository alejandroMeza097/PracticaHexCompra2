package org.example.beanConfiguration;


import org.example.cliente.port.repository.ClienteRepository;
import org.example.cliente.service.ClienteCreateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteCreateBean {
    @Bean
    public ClienteCreateService clienteCreateService(ClienteRepository clienteRepository) {
        return new ClienteCreateService(clienteRepository);
    }
}
