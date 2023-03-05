package com.projeto.les.livraria.controllers.dto;

import com.projeto.les.livraria.model.Cidade;
import com.projeto.les.livraria.model.Cliente;
import com.projeto.les.livraria.model.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO {


    private String nome;
    private EstadoDTO estadoDTO;


    public CidadeDTO() {
    }

    public CidadeDTO(String nome, EstadoDTO estadoDTO) {
        this.nome = nome;
        this.estadoDTO = estadoDTO;
    }
}
