package com.github.PaulosdOliveira.usuario.ex;

public class EmailDuplicadoException extends RuntimeException {
    public EmailDuplicadoException() {
        super("Este email já esta sendo utilizado");
    }
}
