package org.example.message;


import lombok.RequiredArgsConstructor;
import org.example.message.service.CreateMessageService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageCreateHandler {
    private final CreateMessageService createMessageService;

    public String execute(String message){
        return createMessageService.execute(message);
    }
}
