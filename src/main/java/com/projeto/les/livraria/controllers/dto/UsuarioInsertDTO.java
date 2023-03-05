package com.projeto.les.livraria.controllers.dto;

public class UsuarioInsertDTO extends UsuarioDTO{
    private String password;
    UsuarioInsertDTO() {
        super();
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
