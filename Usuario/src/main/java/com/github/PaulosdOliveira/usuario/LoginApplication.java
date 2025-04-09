package com.github.PaulosdOliveira.usuario;

import com.github.PaulosdOliveira.usuario.infra.repository.mq.PrivateKeyPublisher;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@EnableRabbit
@EnableDiscoveryClient
@SpringBootApplication
public class LoginApplication {



    @Autowired
    private PrivateKeyPublisher privateKeyPublisher;

    public static void main(String[] args) {

        SpringApplication.run(LoginApplication.class, args);
    }

}
