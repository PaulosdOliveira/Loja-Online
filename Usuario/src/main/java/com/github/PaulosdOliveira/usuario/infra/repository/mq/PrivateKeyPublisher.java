package com.github.PaulosdOliveira.usuario.infra.repository.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.PaulosdOliveira.usuario.servico.LoginMS;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PrivateKeyPublisher {

    @Autowired
    @Qualifier("queueChave")
    private Queue queue;

    @Autowired
    private RabbitTemplate template;

    @Value("${ms.login}")
    private String login;

    @Value("${ms.senha}")
    private String senha;


    public void solicitarChaveSecreta(){
        try{
            var loginMs = new LoginMS(login, senha);
            String json = new ObjectMapper().writeValueAsString( loginMs);
            template.convertAndSend(queue.getName(), json);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "!!!!!");
        }

    }

}
