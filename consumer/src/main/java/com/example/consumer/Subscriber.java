package com.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Subscriber {


    @RabbitListener(queues = "${mq.queues.teste}")
    public void receberAvaliacaoDTORabbit(@Payload String payload) {
          System.out.println("Recebido: " + LocalDateTime.now() + " -- " + payload);
    }
}
