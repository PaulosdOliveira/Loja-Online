package com.github.PaulosdOliveira.Login.validation;

import com.github.PaulosdOliveira.Login.ex.EmailDuplicadoException;
import com.github.PaulosdOliveira.Login.infra.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidator {

    private UsuarioRepository repository;


    public void validar(String email){
        if(repository.existsByEmail(email)) throw new EmailDuplicadoException();
    }
}
