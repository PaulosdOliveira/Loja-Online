package com.github.PaulosdOliveira.usuario.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;

@NoArgsConstructor
@Getter
@Setter
public class ChaveSecreta {


    private SecretKey secretKey;

    @Value("${ms.login}")
    private String login;

    @Value("${ms.senha}")
    private String senha;

    public SecretKey getSecret() {
        System.out.println("************************");
        if (secretKey == null) {
            System.out.println("Oiiiiiiiiii*********************");
        }
        System.out.println(this.secretKey);
        return this.secretKey;
    }


}
