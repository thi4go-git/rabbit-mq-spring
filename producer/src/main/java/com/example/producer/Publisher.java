package com.example.producer;


import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class Publisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue filaEmissao;

    public void sendAvaliacaoToRabbit() {
        var json = "{\"nome\":\"TEST TESTE\"}";
        rabbitTemplate.convertAndSend(filaEmissao.getName(), json);
    }

    @Bean
    public CommandLineRunner executarAutomatico() {
        return args ->
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        sendAvaliacaoToRabbit();
                    }
                }, 10000L, 10000L);
    }

}
