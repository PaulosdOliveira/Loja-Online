package com.github.PaulosdOliveira.usuario.model.dto;

import com.github.PaulosdOliveira.usuario.model.Usuario;
import lombok.Data;

@Data
public class CadastroUsuarioDTO {
    private String nome;
    private String email;
    private String senha;


    public Usuario toUsuario(){
        return new Usuario(nome, email, senha);
    }
}
