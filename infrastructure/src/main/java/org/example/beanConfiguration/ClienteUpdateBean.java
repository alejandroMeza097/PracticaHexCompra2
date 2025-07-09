package org.example.beanConfiguration;
import org.example.cliente.port.repository.ClienteRepository;
import org.example.cliente.service.ClienteDeleteService;
import org.example.cliente.service.ClienteUpdateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteUpdateBean {
    @Bean
    public ClienteUpdateService clienteUpdateService(ClienteRepository clienteRepository) {
        return new ClienteUpdateService(clienteRepository);
    }
}
