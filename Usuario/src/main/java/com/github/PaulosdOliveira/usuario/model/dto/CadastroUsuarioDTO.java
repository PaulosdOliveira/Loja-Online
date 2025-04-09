package com.github.PaulosdOliveira.usuario.model.dto;

import com.github.PaulosdOliveira.usuario.model.Usuario;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CadastroUsuarioDTO {

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    private String email;

    @Min(value = 3, message = "A senha precisa ter no mínimo três digitos")
    @NotBlank(message = "Campo obrigatório")
    private String senha;


    public Usuario toUsuario() {
        return new Usuario(nome, email, senha);
    }
}
