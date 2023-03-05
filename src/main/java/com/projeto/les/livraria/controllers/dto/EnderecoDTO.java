package com.projeto.les.livraria.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.les.livraria.model.Cidade;
import com.projeto.les.livraria.model.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

    @JsonIgnore
    private Long id;
    private String nome;
    private String logradouro;
    private String tipoLogradouro;
    private String bairro;
    private String numero;
    private String cep;
    private String complemento;
    private String pais;
    private String nomeCidade;
    private String uf;
    private String nomeEstado;
    private String descricao;

    public EnderecoDTO(Long id, String nome, String logradouro, String tipoLogradouro, String bairro, String numero, String cep, String complemento, String pais, String nomeCidade, String uf, String nomeEstado, String descricao) {
        this.id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.tipoLogradouro = tipoLogradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.complemento = complemento;
        this.pais = pais;
        this.nomeCidade = nomeCidade;
        this.uf = uf;
        this.nomeEstado = nomeEstado;
        this.descricao = descricao;
    }

    public EnderecoDTO(Endereco entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.logradouro = entity.getLogradouro();
        this.tipoLogradouro = entity.getTipoLogradouro();
        this.bairro = entity.getBairro();
        this.numero = entity.getNumero();
        this.cep = entity.getCep();
        this.complemento = entity.getComplemento();
        this.pais = entity.getPais();
        this.nomeCidade = entity.getCidade().getNome();
        this.uf = entity.getCidade().getEstado().getUf();
        this.nomeEstado = entity.getCidade().getEstado().getNome();
        this.descricao = entity.getDescricao();
    }

}
