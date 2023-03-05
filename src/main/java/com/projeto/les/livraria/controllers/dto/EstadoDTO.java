package com.projeto.les.livraria.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDTO {
    private String uf;
    private String nome;

    public EstadoDTO() {
    }

    public EstadoDTO(String uf, String nome) {
        this.uf = uf;
        this.nome = nome;
    }
}
