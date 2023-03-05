package com.projeto.les.livraria.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.les.livraria.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UsuarioDTO {
    @JsonIgnore
    private Long id;
    @Email(message = "Favor entrar um email válido")
    private String email;
    Set<RoleDTO> roles = new HashSet<>();

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public UsuarioDTO(Usuario entity) {
        id = entity.getId();
        email = entity.getEmail();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }

}
