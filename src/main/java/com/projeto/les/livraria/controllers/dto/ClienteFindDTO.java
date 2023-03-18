package com.projeto.les.livraria.controllers.dto;

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
public class ClienteFindDTO {

    private String nome;
    private String cpf;
    private String email;

    public ClienteFindDTO() {
    }

    public ClienteFindDTO(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public ClienteFindDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }

    public Specification<Cliente> toSpec() {
        return (root, query, builder) -> {
            List<Predicate> predicate = new ArrayList<>();
            if(StringUtils.hasText(nome)){
                Path<String> campoNome = root.<String>get("nome");
                Predicate predicateNome = builder.like(campoNome, "%"+nome+"%");
                predicate.add(predicateNome);
            }

            if(StringUtils.hasText(cpf)){
                Path<String> campoCpf = root.<String>get("cpf");
                Predicate predicateCpf = builder.like(campoCpf, cpf);
                predicate.add(predicateCpf);
            }

            if(StringUtils.hasText(email)){
                Path<String> campoEmail = root.<String>get("email");
                Predicate predicateGenero = builder.like(campoEmail, email);
                predicate.add(predicateGenero);
            }

            return builder.and(predicate.toArray(new Predicate[0]));
        };
    }
}
