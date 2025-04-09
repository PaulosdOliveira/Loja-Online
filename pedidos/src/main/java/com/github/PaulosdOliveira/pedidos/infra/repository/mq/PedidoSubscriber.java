package com.github.PaulosdOliveira.pedidos.infra.repository.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.PaulosdOliveira.pedidos.application.PedidoService;
import com.github.PaulosdOliveira.pedidos.model.dto.PedidoDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PedidoSubscriber {

    @Autowired
    private PedidoService pedidoService;

    @RabbitListener(queues = "${mq.queues.pedido}")
    private void receberSolicitacaoPedido(@Payload String payLoad) {
        try {
            PedidoDTO dto = new ObjectMapper().readValue(payLoad, PedidoDTO.class);
            pedidoService.fazerPedido(dto);
            System.out.println("Pedido cadastrado com sucesso");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "////////////////////////////////");
        }
    }
}
