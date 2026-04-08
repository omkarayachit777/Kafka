package com.kafka.controller;

import com.kafka.model.MyMessage;
import com.kafka.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/producer")
public class ProducerController {

    @Autowired
    private MessageProducerService service;

    @PostMapping("/add-message")
    public ResponseEntity<String> addMessages(@RequestBody MyMessage myMessage) {
        String response = service.sendMessage(myMessage);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
