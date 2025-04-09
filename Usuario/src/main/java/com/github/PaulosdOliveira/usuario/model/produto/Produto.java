package com.github.PaulosdOliveira.usuario.model.produto;

import com.github.PaulosdOliveira.usuario.model.dto.CadastroProdutoDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Data
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false, length = 50)
    private String descricao;

    @Column(nullable = false, scale = 2)
    private Float preco;

    @Column()
    private Integer estoque;

    public Produto(CadastroProdutoDTO dados){
        BeanUtils.copyProperties(dados, this);
    }
}
