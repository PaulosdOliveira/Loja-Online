package com.github.PaulosdOliveira.Login.security;

import com.github.PaulosdOliveira.Login.application.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomRegisteredClient implements RegisteredClientRepository {


    private final UsuarioService usuarioService;
    private final ClientSettings clientSettings;
    private final TokenSettings tokenSettings;

    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String email) {
        var usuario = usuarioService.findByEmail(email);

        return usuario == null ? null :
                RegisteredClient.withId(usuario.getEmail())
                        .clientId(usuario.getId().toString())
                        .clientSecret(usuario.getSenha())
                        .clientName(usuario.getNome())
                        .scope(usuario.getPerfil().toString())
                        .redirectUri(gerarRedirectUri())
                        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                        .clientSettings(clientSettings)
                        .tokenSettings(tokenSettings)
                        .build();
    }

    private String gerarRedirectUri() {
        return "http://localhost:" + new ServerProperties().getPort() + "/authorized";
    }
}
