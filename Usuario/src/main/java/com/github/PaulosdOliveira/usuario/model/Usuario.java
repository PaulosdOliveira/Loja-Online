package com.github.PaulosdOliveira.usuario.model;

import com.github.PaulosdOliveira.usuario.model.enums.Perfil;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String nome;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 300)
    private String senha;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @Column(nullable = false)
    private String enderecoEntrega;

    public Usuario( String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.perfil = Perfil.USUARIO;
    }


    @Override
    public String toString(){
        return this.id + "";
    }
}
