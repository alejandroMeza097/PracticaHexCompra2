package org.example.message.adapter.repository;


import lombok.RequiredArgsConstructor;
import org.example.message.adapter.KafkaProducerAdapter;
import org.example.message.port.MessageRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProducerRepository implements MessageRepository {
    private final KafkaProducerAdapter kafkaProducerAdapter;
    @Override
    public String publishMessage(String message) {
        return kafkaProducerAdapter.produceMessage(message);
    }
}
