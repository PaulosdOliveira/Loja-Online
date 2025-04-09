package com.github.PaulosdOliveira.usuario.config.filter;

import com.github.PaulosdOliveira.usuario.application.UsuarioService;
import com.github.PaulosdOliveira.usuario.jwt.JwtService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {


    private final JwtService jwtService;
    private final UsuarioService usuarioService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        if (token != null) {
            String email = jwtService.getEmailByToken(token);
            var usuario = usuarioService.findByEmail(email);
            UserDetails user = User.withUsername(usuario.getEmail())
                    .password(usuario.getSenha())
                    .roles(usuario.getPerfil().toString())
                    .build();
            UsernamePasswordAuthenticationToken useAuth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(useAuth);
        }
        filterChain.doFilter(request, response);
    }


    private String getToken(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization != null) {
            String[] tokenDividido = authorization.split(" ");
            if (tokenDividido.length == 2) return tokenDividido[1];
        }
        return null;
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String uri = request.getRequestURI();
        return uri.contains("/usuario");
    }


}
