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
public class ClienteDTO {
    @JsonIgnore
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String genero;
    private Long usuarioId;
    private List<EnderecoDTO> enderecos = new ArrayList<>();
    private List<TelefoneDTO> telefones = new ArrayList<>();
    //private List<CartaoCreditoDTO> cartoesCreditos = new ArrayList<>();
    //private List<CupomDTO> cupoms = new ArrayList<>();
    //private boolean ativo;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, LocalDate dataNascimento, String cpf, String genero, Long usuarioId) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.genero = genero;
        this.usuarioId = usuarioId;
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.cpf = cliente.getCpf();
        this.genero = cliente.getGenero();
        this.usuarioId = cliente.getUsuario().getId();
    }
}
