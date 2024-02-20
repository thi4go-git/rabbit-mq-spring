package com.example.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {
    @Autowired
    @Value("${mq.queues.teste}")
    private String fila;

    @Bean
    public Queue filaEmissao() {
        return new Queue(fila, true);
    }

}
