package com.github.PaulosdOliveira.usuario.jwt;

import com.github.PaulosdOliveira.usuario.model.Usuario;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Autowired
    private ChaveSecreta chaveSecreta;

    public String gerarToken(Usuario usuario) {

        return Jwts.builder()
                .signWith(chaveSecreta.getSecretKey())
                .subject(usuario.getEmail())
                .expiration(getExpiration())
                .claims(getClaims(usuario))
                .compact();
    }


    private Date getExpiration() {
        var expiracao = LocalDateTime.now().atZone(ZoneId.systemDefault()).plusMinutes(120).toInstant();
        return Date.from(expiracao);
    }

    private Map<String, Object> getClaims(Usuario usuario){
        Map<String, Object> claims = new HashMap<>();
        claims.put("nome", usuario.getNome());
        claims.put("perfil", usuario.getPerfil().toString());
        return claims;
    }

    public String getEmailByToken(String token){

      try{
          return Jwts.parser()
                  .verifyWith(chaveSecreta.getSecretKey())
                  .build()
                  .parseSignedClaims(token)
                  .getPayload()
                  .getSubject();
      } catch (Exception e) {
          System.out.println(e.getMessage());
          return null;
      }


    }
}
