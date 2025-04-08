package com.github.PaulosdOliveira.usuario.config;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Value("${mq.queues.solicitachave}")
    private String fila;

    @Bean
    public Queue queue(){
        return new Queue(fila, true);
    }
}
