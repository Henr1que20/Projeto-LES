package com.projeto.les.livraria.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_cartao_credtito")
public class CartaoCredito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bandeira;
    private boolean isPreferencial;
    private String codigoSeguranca;
    private String nomeImpressoCartao;
    private String numeroCartao;

    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "fk_cartao_credito_cliente"))
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Cliente cliente;
}
