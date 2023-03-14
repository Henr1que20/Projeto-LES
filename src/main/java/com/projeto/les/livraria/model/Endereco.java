package com.projeto.les.livraria.model;

import com.projeto.les.livraria.controllers.dto.EnderecoDTO;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String logradouro;
    @Column(columnDefinition = "TEXT")
    private String tipoLogradouro;
    @Column(columnDefinition = "TEXT")
    private String bairro;
    private String numero;
    private String cep;
    @Column(columnDefinition = "TEXT")
    private String complemento;
    private String pais;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;
    @Column(columnDefinition = "TEXT")
    private String descricao;

    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "fk_endereco_cliente"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Cliente cliente;

    public Endereco(EnderecoDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.logradouro = dto.getLogradouro();
        this.tipoLogradouro = dto.getTipoLogradouro();
        this.bairro = dto.getBairro();
        this.numero = dto.getNumero();
        this.cep = dto.getCep();
        this.complemento = dto.getComplemento();
        this.pais = dto.getPais();
        //this.cidade = dto.getCidade();
        this.descricao = dto.getDescricao();
        //this.cliente = dto.getClienteId();
    }
}
