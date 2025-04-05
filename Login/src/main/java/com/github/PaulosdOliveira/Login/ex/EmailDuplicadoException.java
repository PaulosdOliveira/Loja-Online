package com.github.PaulosdOliveira.Login.ex;

public class EmailDuplicadoException extends RuntimeException {
    public EmailDuplicadoException() {
        super("Este email já está sendo usado");
    }
}
