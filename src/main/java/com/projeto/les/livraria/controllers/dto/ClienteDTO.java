package com.projeto.les.livraria.controllers.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.les.livraria.model.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ClienteDTO {
    @JsonIgnore
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String genero;
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, LocalDate dataNascimento, String cpf, String genero, String email) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.genero = genero;
        this.email = email;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.genero = cliente.getGenero();
    }

}
