package com.projeto.les.livraria.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "dat_criacao", nullable = false, updatable = false)
    private Instant dataCriacao;
    private LocalDate dataNascimento;
    private String cpf;
    private String genero;
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<CartaoCredito> cartoesCredito;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Cupom> cupoms;

    @PrePersist
    public void prePersist() {
        dataCriacao = Instant.now();
    }
}
