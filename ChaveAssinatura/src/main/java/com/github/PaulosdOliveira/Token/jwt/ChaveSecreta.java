package com.github.PaulosdOliveira.Token.jwt;

import io.jsonwebtoken.Jwts;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;


@Component
public class ChaveSecreta {

    private SecretKey secretKey;


    public SecretKey getSecretKey(){
        if(secretKey == null){
            secretKey = Jwts.SIG.HS256.key().build();
        }
        return this.secretKey;
    }
}
