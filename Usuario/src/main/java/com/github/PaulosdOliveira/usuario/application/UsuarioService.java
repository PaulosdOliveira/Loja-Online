package com.github.PaulosdOliveira.usuario.application;

import com.github.PaulosdOliveira.usuario.infra.repository.UsuarioRepository;
import com.github.PaulosdOliveira.usuario.model.dto.CadastroUsuarioDTO;
import com.github.PaulosdOliveira.usuario.model.dto.LoginUsuarioDTO;
import com.github.PaulosdOliveira.usuario.validation.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioValidator validator;

    /*@Autowired
    private PasswordEncoder encoder;*/

    public String logarUsuario(LoginUsuarioDTO dadosLogin){
        return "";
    }

    public void cadastrarUsuario(CadastroUsuarioDTO dadosUsuario){
        validator.validar(dadosUsuario.getEmail());
        var usuario = dadosUsuario.toUsuario();
       // usuario.setSenha(encoder.encode(dadosUsuario.getSenha()));
        repository.save(usuario);
    }
}
