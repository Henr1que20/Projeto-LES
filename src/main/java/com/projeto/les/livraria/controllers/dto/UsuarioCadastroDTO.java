package com.projeto.les.livraria.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.les.livraria.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UsuarioCadastroDTO {
    @JsonIgnore
    private Long id;
    @Email(message = "Favor entrar um email válido")
    private String email;
    public UsuarioCadastroDTO() {
    }
    public UsuarioCadastroDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public UsuarioCadastroDTO(Usuario entity) {
        id = entity.getId();
        email = entity.getEmail();
    }

}
