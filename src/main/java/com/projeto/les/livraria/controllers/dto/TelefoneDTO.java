package com.projeto.les.livraria.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TelefoneDTO {
    @JsonIgnore
    private Long id;
    private String telefone;
}
