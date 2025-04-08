package com.github.PaulosdOliveira.Token.infra.mq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.PaulosdOliveira.Token.ex.ServidorNaoAutorizadoException;
import com.github.PaulosdOliveira.Token.model.MicroServico;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ChaveSecretaSubscriber {


    @Value("${ms.login}")
    private String login;

    @Value("${ms.senha}")
    private String senha;

    @Autowired
    private ChaveSecretaPublisher chaveSecretaPublisher;


    @RabbitListener(queues = "${mq.queues.solicitachave}")
    public void receberSolicitaçãoChave(@Payload String payLoad) {
        System.out.println("Recebendo solicitaçã de envio de chave secreta");
        try {
            MicroServico autenticacaoMS = new ObjectMapper().readValue(payLoad, MicroServico.class);
            String loginMs = autenticacaoMS.getLogin();
            String senhaMS = autenticacaoMS.getSenha();
            System.out.println(loginMs + "  /////////  " + senhaMS);
            if (loginMs.equals(login) && senhaMS.equals(senha)) {
                chaveSecretaPublisher.retornarChaveSecreta();
            } else {
                throw new ServidorNaoAutorizadoException();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "///////");
        }
    }
}
