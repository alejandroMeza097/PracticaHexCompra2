package org.example.message.service;


import lombok.RequiredArgsConstructor;
import org.example.message.port.MessageRepository;

@RequiredArgsConstructor
public class CreateMessageService {
    private final MessageRepository messageRepository;
    public String execute(String message){
        return  messageRepository.publishMessage(message);
    }
}
