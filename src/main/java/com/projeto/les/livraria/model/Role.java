package com.projeto.les.livraria.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    public Role() {
    }
    public Role(Long id, String authority) {
        super();
        this.id = id;
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority() {
        this.authority = "ROLE_CLIENTE";
    }
}
