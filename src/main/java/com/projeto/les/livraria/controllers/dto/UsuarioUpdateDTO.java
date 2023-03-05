package com.projeto.les.livraria.controllers.dto;

public class UsuarioUpdateDTO {
    private String password;
    UsuarioUpdateDTO() {
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
