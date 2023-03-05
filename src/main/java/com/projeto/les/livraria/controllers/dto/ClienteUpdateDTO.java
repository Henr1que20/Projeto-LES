package com.projeto.les.livraria.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.les.livraria.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClienteUpdateDTO {
    @JsonIgnore
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String genero;


    public ClienteUpdateDTO() {
    }

    public ClienteUpdateDTO(Long id, String nome, LocalDate dataNascimento, String cpf, String genero) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.genero = genero;
    }

    public ClienteUpdateDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.cpf = cliente.getCpf();
        this.genero = cliente.getGenero();
    }
}
