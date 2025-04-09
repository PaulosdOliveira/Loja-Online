package com.github.PaulosdOliveira.usuario.config;


import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Value("${mq.queues.solicitachave}")
    private String filaChave;

    @Value("${mq.queues.pedido}")
    private String filaPedido;

    @Bean
    @Qualifier("queueChave")
    public Queue queueChave(){
        return new Queue(filaChave, true);
    }

    @Bean
    @Qualifier("queuePedido")
    public Queue queuePedido(){
        return new Queue(filaPedido, true);
    }
}
