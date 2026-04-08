package com.kafka.service;

import com.kafka.model.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    @Autowired
    private KafkaTemplate<String, MyMessage> kafkaTemplate;

    public String sendMessage(MyMessage myMessage) {
        System.out.println("message == " + myMessage);
        kafkaTemplate.send("my-topic", "my-message", myMessage);
        return "Message is sent to kafka server..";
    }
}
