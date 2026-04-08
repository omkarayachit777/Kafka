package com.kafka.service;

import com.kafka.model.MyMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageConsumerService {

    private final List<MyMessage> messages = new ArrayList<>();

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void consume(MyMessage myMessage) {
        messages.add(myMessage);
        System.out.println("Data received from Kafka: " + myMessage);
    }

    public List<MyMessage> getMessages() {
        return messages;
    }

}
