package com.kafka.controller;

import com.kafka.model.MyMessage;
import com.kafka.service.MessageConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka/consumer")
public class ConsumerController {

    @Autowired
    private MessageConsumerService service;

    @GetMapping("/get-message")
    public ResponseEntity<List<MyMessage>> getMessages() {
        List<MyMessage> response = service.getMessages();
        System.out.println("response from consumer => " + response);
        return new ResponseEntity<List<MyMessage>>(response, HttpStatus.OK);
    }
}
