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
    private Long id;
    private LocalDate dataNascimento;
    private String nome;
    private String cpf;
    private String genero;
    private Long usuarioId;

    public ClienteFindDTO() {
    }

    public ClienteFindDTO(Long id, LocalDate dataNascimento, String nome, String cpf, String genero, Long usuarioId) {
        this.id = id;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero;
        this.usuarioId = usuarioId;
    }

    public ClienteFindDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.cpf = cliente.getCpf();
        this.genero = cliente.getGenero();
        this.usuarioId = cliente.getUsuario().getId();
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

            if(StringUtils.hasText(genero)){
                Path<String> campoGenero = root.<String>get("genero");
                Predicate predicateGenero = builder.like(campoGenero, genero);
                predicate.add(predicateGenero);
            }

            return builder.and(predicate.toArray(new Predicate[0]));
        };
    }
}
