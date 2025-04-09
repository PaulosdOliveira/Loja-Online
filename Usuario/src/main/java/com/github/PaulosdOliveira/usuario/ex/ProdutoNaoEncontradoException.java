package com.github.PaulosdOliveira.usuario.ex;

public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException() {
        super("Erro ao buscar produto");
    }
}
