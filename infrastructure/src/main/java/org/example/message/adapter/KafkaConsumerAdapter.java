package org.example.message.adapter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumerAdapter {
    @KafkaListener(topics = "clientes-creados",groupId = "my-consumer-group")
    public void consumeMessage(String message) {

        log.info("Mensaje consumido: " + message);
    }
}
