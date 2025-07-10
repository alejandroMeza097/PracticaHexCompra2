package org.example.beanConfiguration;


import org.example.cliente.port.repository.ClienteRepository;
import org.example.cliente.service.ClienteByIdService;
import org.example.cliente.service.ClienteCreateService;
import org.example.cliente.service.ClienteExistByEmailService;
import org.example.cliente.service.ClienteExistByNameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteCreateBean {
    @Bean
    public ClienteCreateService clienteCreateService(ClienteRepository clienteRepository) {
        return new ClienteCreateService(clienteRepository);
    }

    @Bean
    public ClienteExistByEmailService clienteExistByEmailService(ClienteRepository clienteRepository){
        return  new ClienteExistByEmailService(clienteRepository);
    }
    @Bean
    public ClienteExistByNameService clienteExistByNameService(ClienteRepository clienteRepository){
        return new ClienteExistByNameService(clienteRepository);
    }
}
