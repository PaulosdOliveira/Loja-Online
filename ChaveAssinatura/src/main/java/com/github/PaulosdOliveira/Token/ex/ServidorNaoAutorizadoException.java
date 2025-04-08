package com.github.PaulosdOliveira.Token.ex;

public class ServidorNaoAutorizadoException extends RuntimeException {
    public ServidorNaoAutorizadoException() {
        super("Servidor não autorizado ao acesso da chave de assinatura");
    }
}
