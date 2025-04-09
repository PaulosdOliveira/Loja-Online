package com.github.PaulosdOliveira.usuario.model.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class CadastroProdutoDTO {

    @NotBlank(message = "Campo obrigatório")
    private String nome;

    @NotBlank(message = "Campo obrigatório")
    private String descricao;

    @PositiveOrZero(message = "O oreço tem que ser um número decimal positivo ou zero")
    private Float preco;

    @PositiveOrZero(message = "O estoque tem que ser um número positivo ou zero")
    private Integer estoque;
}
