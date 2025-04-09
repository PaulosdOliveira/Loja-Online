package com.github.PaulosdOliveira.usuario.infra.repository.mq.pedido;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.PaulosdOliveira.usuario.model.dto.PedidoDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.Queue;

@Component
public class PedidoPublisher {


    @Autowired
    private RabbitTemplate template;

    @Autowired
    @Qualifier("queuePedido")
    private Queue queue;


    public void fazerPedido(PedidoDTO dto) {
        try {
            String json = new ObjectMapper().writeValueAsString(dto);
            template.convertAndSend(json);
        } catch (Exception e) {
            System.out.println(e.getMessage() + "!!!!!!!!!!!");
        }
    }
}
