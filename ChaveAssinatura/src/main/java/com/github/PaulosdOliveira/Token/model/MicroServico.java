package com.github.PaulosdOliveira.Token.model;

public class MicroServico {

    private String login;
    private String senha;

    public MicroServico() {
    }

    public MicroServico(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
