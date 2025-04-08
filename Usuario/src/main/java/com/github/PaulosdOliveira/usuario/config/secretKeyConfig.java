package com.github.PaulosdOliveira.usuario.config;


import com.github.PaulosdOliveira.usuario.infra.repository.mq.PrivateKeyPublisher;
import com.github.PaulosdOliveira.usuario.jwt.ChaveSecreta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class secretKeyConfig {


    @Value("${ms.login}")
    private String login;

    @Value("${ms.senha}")
    private String senha;


    @Bean
    public ChaveSecreta chaveSecreta(PrivateKeyPublisher publisher){
        publisher.solicitarChaveSecreta();
        return new ChaveSecreta();
    }





}
