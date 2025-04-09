package com.github.PaulosdOliveira.usuario.config.security;


import com.github.PaulosdOliveira.usuario.application.UsuarioService;
import com.github.PaulosdOliveira.usuario.config.filter.JwtFilter;
import com.github.PaulosdOliveira.usuario.jwt.JwtService;
import com.github.PaulosdOliveira.usuario.model.Usuario;
import com.github.PaulosdOliveira.usuario.model.enums.Perfil;
import com.github.PaulosdOliveira.usuario.security.CustomAuthentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public JwtFilter jwtFilter(JwtService jwtService, UsuarioService usuarioService) {
        return new JwtFilter(jwtService, usuarioService);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter filter) throws Exception {

        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.POST, "/produto/**").hasRole(Perfil.ADMINISTRADOR.name());
                    auth.anyRequest().permitAll();
                })
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}
