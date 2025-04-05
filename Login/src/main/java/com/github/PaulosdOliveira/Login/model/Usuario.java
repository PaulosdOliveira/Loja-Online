package com.github.PaulosdOliveira.Login.model;

import com.github.PaulosdOliveira.Login.model.dto.CadastroUsuarioDTO;
import com.github.PaulosdOliveira.Login.model.enums.Perfil;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 300, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    public Usuario(CadastroUsuarioDTO dadosUsuario) {
        BeanUtils.copyProperties(dadosUsuario, this);
    }


}
