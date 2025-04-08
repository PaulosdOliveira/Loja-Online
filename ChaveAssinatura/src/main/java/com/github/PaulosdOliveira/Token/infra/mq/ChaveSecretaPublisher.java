package com.github.PaulosdOliveira.Token.infra.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.PaulosdOliveira.Token.jwt.ChaveSecreta;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ChaveSecretaPublisher {

    @Autowired
    private ChaveSecreta chaveSecreta;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queue;

    public void retornarChaveSecreta() throws JsonProcessingException {
        System.out.println("Enviando chave secreta");

        try {
            System.out.println(chaveSecreta.getSecretKey());
            String jsonChave = new ObjectMapper().writeValueAsString(chaveSecreta.getSecretKey());
            template.convertAndSend(queue.getName(), jsonChave);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " *******");
        }

    }
}
