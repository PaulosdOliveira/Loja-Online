package com.github.PaulosdOliveira.Login.application;

import com.github.PaulosdOliveira.Login.infra.repository.UsuarioRepository;
import com.github.PaulosdOliveira.Login.model.Usuario;
import com.github.PaulosdOliveira.Login.model.dto.CadastroUsuarioDTO;
import com.github.PaulosdOliveira.Login.validation.UsuarioValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioValidator validator;

    public void cadastrarUsuario(CadastroUsuarioDTO dadosUsuario) {
        validator.validar(dadosUsuario.getEmail());
        var usuario = new Usuario(dadosUsuario);
        repository.save(usuario);
    }

    public Usuario findByEmail(String email){
        return repository.findByEmail(email);
    }
}
