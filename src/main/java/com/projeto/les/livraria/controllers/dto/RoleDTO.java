package com.projeto.les.livraria.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.les.livraria.model.Role;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDTO {

    private Long id;
    private String authority;

    public RoleDTO() {
    }

    public RoleDTO(Long id, String authority) {
        super();
        this.id = id;
        this.authority = authority;
    }

    public RoleDTO(Role role) {
        super();
        id = role.getId();
        authority = role.getAuthority();
    }

}
