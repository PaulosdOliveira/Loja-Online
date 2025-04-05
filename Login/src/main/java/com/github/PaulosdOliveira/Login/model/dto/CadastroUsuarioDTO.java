package com.github.PaulosdOliveira.Login.model.dto;

import com.github.PaulosdOliveira.Login.model.enums.Perfil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CadastroUsuarioDTO {

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @Email(message = "Insira um email válido")
    @NotBlank(message = "Campo obrigatório")
    private String email;

    @NotBlank(message = "Campo obrigatório")
    private String senha;

    @NotNull(message = "Campo obrigatório")
    private Perfil perfil;
}
