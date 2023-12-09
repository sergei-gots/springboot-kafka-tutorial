package net.javaguides.springboot.controller;

import net.javaguides.springboot.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    //e.g. http:localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    String publish(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return "Message sent to some topic:)";
    }


}
