package com.github.PaulosdOliveira.usuario.validation;


import com.github.PaulosdOliveira.usuario.ex.EmailDuplicadoException;
import com.github.PaulosdOliveira.usuario.infra.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidator {

    @Autowired
    private UsuarioRepository repository;

    public void validar(String email){
        if(repository.existsByEmail(email)) throw new EmailDuplicadoException();
    }
}
