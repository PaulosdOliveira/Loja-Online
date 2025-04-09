package com.github.PaulosdOliveira.usuario.application;

import com.github.PaulosdOliveira.usuario.infra.repository.UsuarioRepository;
import com.github.PaulosdOliveira.usuario.jwt.JwtService;
import com.github.PaulosdOliveira.usuario.model.Usuario;
import com.github.PaulosdOliveira.usuario.model.dto.CadastroUsuarioDTO;
import com.github.PaulosdOliveira.usuario.model.dto.LoginUsuarioDTO;
import com.github.PaulosdOliveira.usuario.validation.UsuarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioValidator validator;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;

    public String logarUsuario(LoginUsuarioDTO dadosLogin) {
        String email = dadosLogin.getEmail();
        String senhaDigitada = dadosLogin.getSenha();
        var usuario = findByEmail(email);
        String senhaSalva = usuario.getSenha();
        if (encoder.matches(senhaDigitada, senhaSalva)) {
            return jwtService.gerarToken(usuario);
        }
        throw new UsernameNotFoundException("Email e/ou senha incorretos");
    }

    public void cadastrarUsuario(CadastroUsuarioDTO dadosUsuario) {
        validator.validar(dadosUsuario.getEmail());
        var usuario = dadosUsuario.toUsuario();
        usuario.setSenha(encoder.encode(dadosUsuario.getSenha()));
        repository.save(usuario);
    }

    public Usuario findByEmail(String email) {
        Usuario usuario = repository.findByEmail(email);
        if (usuario == null) throw new UsernameNotFoundException("Usuário não encontrado");
        return usuario;
    }


    public String getEnderecoEntrega(Long id){
        String endereco = repository.getEnderecoEntrega(id);
        if(endereco != null) return endereco;
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}
