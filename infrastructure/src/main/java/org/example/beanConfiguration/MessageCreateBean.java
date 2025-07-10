package org.example.beanConfiguration;


import org.example.message.port.MessageRepository;
import org.example.message.service.CreateMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageCreateBean {

    @Bean
    public CreateMessageService createMessageService(MessageRepository messageRepository){
        return new CreateMessageService(messageRepository);

    }
}
