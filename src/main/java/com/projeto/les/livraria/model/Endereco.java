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
    private String nome;
    private String logradouro;
    private String tipoLogradouro;
    private String bairro;
    private String numero;
    private String cep;
    private String complemento;
    private String pais;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

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
