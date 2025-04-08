package com.github.PaulosdOliveira.usuario.infra.repository.mq;

import com.github.PaulosdOliveira.usuario.jwt.SecretDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.PaulosdOliveira.usuario.jwt.ChaveSecreta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;
import java.util.Base64;

@Component
public class PrivateKeySubscriber {

    @Autowired
    private ChaveSecreta chaveSecreta;

    @RabbitListener(queues = "${mq.queues.getchave}")
    public void getPrivateKey(@Payload String payLoad){
        try{
            SecretDTO dto = new ObjectMapper().readValue(payLoad, SecretDTO.class);
            byte[] decodedKey = Base64.getDecoder().decode(dto.getEncoded());
            SecretKey chavePrivada = new SecretKeySpec(decodedKey, 0, decodedKey.length, dto.getAlgorithm());
            chaveSecreta.setSecretKey(chavePrivada);
        }catch (Exception e){
            System.out.println(e.getMessage() + "***********************");
        }
    }
}
