package com.spring.kafka.producer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
public class ProducerController {

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    public ProducerController(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/produce")
    public ResponseEntity<String> produceMessages(@RequestParam String topic, @RequestParam String message) throws ExecutionException, InterruptedException {
        CompletableFuture<SendResult<Integer, String>> resultCompletableFuture = kafkaTemplate.send(topic, message);
        SendResult<Integer, String> sendResult = resultCompletableFuture.get();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
